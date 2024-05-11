package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionDeCD {
    private static final String FILE_PATH = "guijava/demo/src/main/resources/cds.csv"; // Modifiez le chemin du fichier CSV si nécessaire
    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                 //   ajouterCD();
                    break;
                case "2":
                    afficherCD();
                    break;
                case "3":
             //       rechercherCD();
                    break;
                case "4":
                   // supprimerCD();
                    break;
                case "5":
                    System.out.println("Merci d'avoir utilisé GestionDeCD. Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nBienvenue dans GestionDeCD");
        System.out.println("1. Ajouter un CD");
        System.out.println("2. Afficher la liste des CDs");
        System.out.println("3. Rechercher un CD par titre");
        System.out.println("4. Supprimer un CD");
        System.out.println("5. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public static void ajouterCD(String titre, String artiste, String dureeStr) {
        try {
            int duree = Integer.parseInt(dureeStr); // Convert duration from String to int
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            CD cd = new CD(titre, artiste, duree);
            writer.write(cd.getTitre() + CSV_SEPARATOR + cd.getArtiste() + CSV_SEPARATOR + cd.getDuree() + "\n");
            writer.close();
            System.out.println("CD ajouté avec succès.");
        } catch (NumberFormatException e) {
            System.err.println("Erreur: La durée doit être un nombre entier.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    


    public static String afficherCD() {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                // Convert the duration from String to int
                int duree = Integer.parseInt(parts[2]);
                CD cd = new CD(parts[0], parts[1], duree);
                result.append(cd).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    
    public static String rechercherCD(String titre) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            boolean cdTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (parts[0].equals(titre)) {
                    // Convert the duration from String to int
                    int duree = Integer.parseInt(parts[2]);
                    CD cd = new CD(parts[0], parts[1], duree);
                    result.append("CD trouvé : ").append(cd).append("\n");
                    cdTrouve = true;
                    break;
                }
            }
            if (!cdTrouve) {
                result.append("Aucun CD trouvé avec ce titre.");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    

    public static void supprimerCD(String titre) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            List<String> lines = new ArrayList<>();
            String line;
            boolean cdTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (!parts[0].equals(titre)) {
                    lines.add(line);
                } else {
                    cdTrouve = true;
                }
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (String l : lines) {
                writer.write(l + "\n");
            }
            writer.close();
            if (cdTrouve) {
                System.out.println("CD supprimé avec succès.");
            } else {
                System.out.println("Aucun CD trouvé avec ce titre.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
