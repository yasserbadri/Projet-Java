package com.example;

import java.io.*;
import java.util.Scanner;

public class GestionDeDVD {
    private static final String FILE_PATH = "src/main/resources/dvds.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    ajouterDVD();
                    break;
                case "2":
                    afficherDVD();
                    break;
                case "3":
                    rechercherDVD();
                    break;
                case "4":
                    supprimerDVD();
                    break;
                case "5":
                    System.out.println("Merci d'avoir utilisé GestionDeDVD. Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nBienvenue dans GestionDeDVD");
        System.out.println("1. Ajouter un DVD");
        System.out.println("2. Afficher la liste des DVDs");
        System.out.println("3. Rechercher un DVD par titre");
        System.out.println("4. Supprimer un DVD");
        System.out.println("5. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public static void ajouterDVD() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le titre du DVD : ");
            String titre = scanner.nextLine();
            System.out.print("Entrez le nom du réalisateur : ");
            String realisateur = scanner.nextLine();
            System.out.print("Entrez la durée du DVD (en minutes) : ");
            int duree = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la ligne restante
            writer.write(titre + CSV_SEPARATOR + realisateur + CSV_SEPARATOR + duree + "\n");
            System.out.println("DVD ajouté avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void afficherDVD() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                System.out.println("Titre: " + parts[0] + ", Réalisateur: " + parts[1] + ", Durée: " + parts[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rechercherDVD() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le titre du DVD à rechercher : ");
            String titreRecherche = scanner.nextLine();
            String line;
            boolean dvdTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (parts[0].equals(titreRecherche)) {
                    System.out.println("DVD trouvé : " + line);
                    dvdTrouve = true;
                    break;
                }
            }
            if (!dvdTrouve) {
                System.out.println("Aucun DVD trouvé avec ce titre.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerDVD() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + ".tmp"));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le titre du DVD à supprimer : ");
            String titreSuppression = scanner.nextLine();
            String line;
            boolean dvdTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (!parts[0].equals(titreSuppression)) {
                    writer.write(line + "\n");
                } else {
                    dvdTrouve = true;
                }
            }
            reader.close();
            writer.close();
            File file = new File(FILE_PATH);
            File tmpFile = new File(FILE_PATH + ".tmp");
            if (file.delete()) {
                if (!tmpFile.renameTo(file)) {
                    System.out.println("Erreur lors du renommage du fichier temporaire.");
                }
            } else {
                System.out.println("Erreur lors de la suppression du DVD.");
            }
            if (dvdTrouve) {
                System.out.println("DVD supprimé avec succès.");
            } else {
                System.out.println("Aucun DVD trouvé avec ce titre.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
