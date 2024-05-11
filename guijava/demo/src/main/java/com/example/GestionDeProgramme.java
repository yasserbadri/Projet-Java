package com.example;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class GestionDeProgramme {
    private static final String FILE_PATH = "src/main/resources/programmes.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    ajouterProgramme();
                    break;
                case "2":
                    afficherProgrammes();
                    break;
                case "3":
                    rechercherProgramme();
                    break;
                case "4":
                    supprimerProgramme();
                    break;
                case "5":
                    System.out.println("Merci d'avoir utilisé GestionDeProgramme. Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nBienvenue dans GestionDeProgramme");
        System.out.println("1. Ajouter un programme");
        System.out.println("2. Afficher la liste des programmes");
        System.out.println("3. Rechercher un programme par titre");
        System.out.println("4. Supprimer un programme");
        System.out.println("5. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public static void ajouterProgramme() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le titre du programme : ");
            String titre = scanner.nextLine();
            System.out.print("Entrez la description du programme : ");
            String description = scanner.nextLine();
            System.out.print("Entrez la date de début du programme (AAAA-MM-JJ) : ");
            String dateDebutStr = scanner.nextLine();
            LocalDate dateDebut = LocalDate.parse(dateDebutStr);
            System.out.print("Entrez la date de fin du programme (AAAA-MM-JJ) : ");
            String dateFinStr = scanner.nextLine();
            LocalDate dateFin = LocalDate.parse(dateFinStr);
            writer.write(titre + CSV_SEPARATOR + description + CSV_SEPARATOR + dateDebut + CSV_SEPARATOR + dateFin + "\n");
            System.out.println("Programme ajouté avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void afficherProgrammes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                System.out.println("Titre: " + parts[0] + ", Description: " + parts[1] + ", Date de début: " + parts[2] + ", Date de fin: " + parts[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rechercherProgramme() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le titre du programme à rechercher : ");
            String titreRecherche = scanner.nextLine();
            String line;
            boolean programmeTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (parts[0].equals(titreRecherche)) {
                    System.out.println("Programme trouvé : " + line);
                    programmeTrouve = true;
                    break;
                }
            }
            if (!programmeTrouve) {
                System.out.println("Aucun programme trouvé avec ce titre.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerProgramme() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + ".tmp"));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le titre du programme à supprimer : ");
            String titreSuppression = scanner.nextLine();
            String line;
            boolean programmeTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (!parts[0].equals(titreSuppression)) {
                    writer.write(line + "\n");
                } else {
                    programmeTrouve = true;
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
                System.out.println("Erreur lors de la suppression du programme.");
            }
            if (programmeTrouve) {
                System.out.println("Programme supprimé avec succès.");
            } else {
                System.out.println("Aucun programme trouvé avec ce titre.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
