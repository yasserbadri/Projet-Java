package com.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionDeReservation {
    static final String FILE_PATH = "guijava/demo/src/main/resources/reservations.csv";
    static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    //ajouterReservation();
                    break;
                case "2":
                    //afficherReservations();
                    break;
                case "3":
                    //rechercherReservation();
                    break;
                case "4":
                    //supprimerReservation();
                    break;
                case "5":
                    System.out.println("Merci d'avoir utilisé GestionDeReservation. Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nBienvenue dans GestionDeReservation");
        System.out.println("1. Ajouter une réservation");
        System.out.println("2. Afficher la liste des réservations");
        System.out.println("3. Rechercher une réservation par nom du client");
        System.out.println("4. Supprimer une réservation");
        System.out.println("5. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public static void ajouterReservation(String nomClient, String dateReservation, String details) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            LocalDate date = LocalDate.parse(dateReservation);
            
            // Vous pouvez utiliser des valeurs par défaut pour les autres paramètres
            int nombrePersonnes = 1;
            LocalTime heureDebut = LocalTime.of(0, 0); // Heure de début par défaut (00:00)
            LocalTime heureFin = LocalTime.of(23, 59); // Heure de fin par défaut (23:59)
    
            Reservation reservation = new Reservation(nomClient, nombrePersonnes, date, heureDebut, heureFin);
            writer.write(reservation.getNomClient() + CSV_SEPARATOR + reservation.getNombrePersonnes() + CSV_SEPARATOR +
                    reservation.getDate() + CSV_SEPARATOR + reservation.getHeureDebut() + CSV_SEPARATOR +
                    reservation.getHeureFin() + "\n");
            writer.close();
            System.out.println("Réservation ajoutée avec succès : " + reservation); // Message de débogage
        } catch (IOException | DateTimeParseException e) {
            e.printStackTrace();
        }
    }
    public static void afficherReservations() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (parts.length >= 5) {
                    try {
                        LocalDate date = LocalDate.parse(parts[2]);
                        LocalTime startTime = LocalTime.parse(parts[3]);
                        LocalTime endTime = LocalTime.parse(parts[4]);
                        Reservation reservation = new Reservation(parts[0], Integer.parseInt(parts[1]), date, startTime, endTime);
                        System.out.println(reservation); // Afficher la réservation
                    } catch (DateTimeParseException e) {
                        System.err.println("Erreur lors de l'analyse de la date ou de l'heure : " + e.getMessage());
                    }
                } else {
                    System.err.println("Ligne mal formatée : " + line);
                }
            }
            reader.close();
            System.out.println("Réservations affichées avec succès."); // Message de débogage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String rechercherReservation(String nomClient) {
        StringBuilder resultat = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            boolean reservationTrouvee = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (parts[0].equals(nomClient)) {
                    Reservation reservation = new Reservation(parts[0], Integer.parseInt(parts[1]), LocalDate.parse(parts[2]),
                            LocalTime.parse(parts[3]), LocalTime.parse(parts[4]));
                    resultat.append("Réservation trouvée : ").append(reservation).append("\n");
                    reservationTrouvee = true;
                    break;
                }
            }
            if (!reservationTrouvee) {
                resultat.append("Aucune réservation trouvée pour ce client.");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat.toString();
    }
    
    public static boolean supprimerReservation(String nomClient) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            List<String> lines = new ArrayList<>();
            String line;
            boolean reservationTrouvee = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(CSV_SEPARATOR);
                if (!parts[0].equals(nomClient)) {
                    lines.add(line);
                } else {
                    reservationTrouvee = true;
                }
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (String l : lines) {
                writer.write(l + "\n");
            }
            writer.close();
            return reservationTrouvee;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}     
   