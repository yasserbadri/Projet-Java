package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.fxml.FXML;

public class GestionDeLivres {
    private static final String FILE_PATH = "guijava/demo/src/main/resources/livres.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                 //   ajouterLivre();
                    break;
                case "2":
                    afficherLivres();
                    break;
                case "3":
                 //   rechercherLivre();
                    break;
                case "4":
                 //   supprimerLivre();
                    break;
                case "5":
                    //quit
                    System.out.println("Merci d'avoir utilisé GestionDeLivres. Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nBienvenue dans GestionDeLivres");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Afficher la liste des livres");
        System.out.println("3. Rechercher un livre par titre");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public static void ajouterLivre(String titre, String auteur, String annee) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            Livre livre = new Livre(titre, auteur, annee);
            writer.write(livre.getTitre() + CSV_SEPARATOR + livre.getAuteur() + CSV_SEPARATOR + livre.getAnnee() + "\n");
            writer.close();
            System.out.println("Livre ajouté avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String afficherLivres() {
        StringBuilder booksStringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                Livre livre = new Livre(parts[0], parts[1], parts[2]);
                booksStringBuilder.append(livre).append("\n"); // Append each book to the StringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return booksStringBuilder.toString(); // Return the string representation of the books
    }


    public static String rechercherLivre(String titre) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            boolean livreTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (parts[0].equals(titre)) {
                    Livre livre = new Livre(parts[0], parts[1], parts[2]);
                    result.append("Livre trouvé : ").append(livre).append("\n");
                    livreTrouve = true;
                    break;
                }
            }
            if (!livreTrouve) {
                result.append("Aucun livre trouvé avec ce titre.");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    
    

    public static String supprimerLivre(String titre) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            List<String> lines = new ArrayList<>();
            String line;
            boolean livreTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (!parts[0].equals(titre)) {
                    lines.add(line);
                } else {
                    livreTrouve = true;
                }
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (String l : lines) {
                writer.write(l + "\n");
            }
            writer.close();
            if (livreTrouve) {
                return "Livre supprimé avec succès.";
            } else {
                return "Aucun livre trouvé avec ce titre.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Une erreur s'est produite lors de la suppression du livre.";
        }
    }
}
