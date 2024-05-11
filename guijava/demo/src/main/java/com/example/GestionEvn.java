package com.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEvn {

    private static final String FILE_PATH = "guijava/demo/src/main/resources/evn.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    //ajouterEvn();
                    break;
                case "2":
                    //afficherEvn();
                    break;
                case "3":
                    //rechercherEvn();
                    break;
                case "4":
                    //supprimerEvn();
                    break;
                case "5":
                    System.out.println("Merci d'avoir utilisé GestionDeEvn. Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nBienvenue dans GestionDeEvn");
        System.out.println("1. Ajouter un événement");
        System.out.println("2. Afficher les événements disponibles");
        System.out.println("3. Rechercher un événement par titre");
        System.out.println("4. Supprimer un événement");
        System.out.println("5. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public static void ajouterEvn(String titre, String lieu, String dateStr, String heureDebutStr, String heureFinStr) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            LocalDate date = LocalDate.parse(dateStr);
            LocalTime heureDebut = LocalTime.parse(heureDebutStr);
            LocalTime heureFin = LocalTime.parse(heureFinStr);
    
            Evenement evenement = new Evenement(titre, lieu, date, heureDebut, heureFin);
            writer.write(evenement.getTitre() + CSV_SEPARATOR + evenement.getLieu() + CSV_SEPARATOR +
                    evenement.getDate() + CSV_SEPARATOR + evenement.getHeureDebut() + CSV_SEPARATOR +
                    evenement.getHeureFin() + "\n");
            writer.close();
            System.out.println("Événement ajouté avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static String afficherEvn() {
    StringBuilder sb = new StringBuilder();
    try {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(CSV_SEPARATOR);
            if (parts.length >= 5) { // Vérifiez s'il y a suffisamment de parties dans la ligne
                try {
                    LocalDate date = LocalDate.parse(parts[2]);
                    LocalTime startTime = LocalTime.parse(parts[3]);
                    LocalTime endTime = LocalTime.parse(parts[4]);
                    Evenement evenement = new Evenement(parts[0], parts[1], date, startTime, endTime);
                    sb.append(evenement).append("\n");
                } catch (DateTimeParseException e) {
                    System.err.println("Erreur lors de l'analyse de la date ou de l'heure : " + e.getMessage());
                }
            } else {
                System.err.println("Ligne mal formatée : " + line);
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return sb.toString();
}

    


    public static String rechercherEvn(String titre) {
        StringBuilder resultat = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            boolean evnTrouve = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (parts[0].equals(titre)) {
                    Evenement evenement = new Evenement(parts[0], parts[1], LocalDate.parse(parts[2]),
                            LocalTime.parse(parts[3]), LocalTime.parse(parts[4]));
                    resultat.append("Événement trouvé : ").append(evenement).append("\n");
                    evnTrouve = true;
                    break;
                }
            }
            if (!evnTrouve) {
                resultat.append("Aucun événement trouvé avec ce titre.");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat.toString();
    }
    


public static boolean supprimerEvn(String titre) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        List<String> lines = new ArrayList<>();
        String line;
        boolean evnTrouve = false;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(CSV_SEPARATOR);
            if (!parts[0].equals(titre)) {
                lines.add(line);
            } else {
                evnTrouve = true;
            }
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
        for (String l : lines) {
            writer.write(l + "\n");
        }
        writer.close();
        return evnTrouve;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    
    

   
}
