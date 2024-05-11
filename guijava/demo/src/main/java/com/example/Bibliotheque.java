package com.example;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Bienvenue chez Biblio-Badri\n***Menu Principal***\n ");
            System.out.println("1. Gestion des livres");
            System.out.println("2. Gestion des CDs");
            System.out.println("3. Gestion des DVDs");
            System.out.println("4. Gestion des événements");
            System.out.println("5. Quitter");
            System.out.print("Choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la ligne vide après nextInt()

            switch (choix) {
                case 1:
                    GestionDeLivres.main(args);
                    break;
                case 2:
                    GestionDeCD.main(args);
                    break;
                case 3:
                    GestionDeDVD.main(args);
                    break;
                case 4:
                    GestionEvn.main(args);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 5);
    }
*/
   /*  private static void ajouterLivre() {
        GestionDeLivres.ajouterLivre();
    }
*/
  /*   private static void afficherLivres() {
        GestionDeLivres.afficherLivres();
    }

    private static void rechercherLivre() {
       // GestionDeLivres.rechercherLivre();
    }

    private static void supprimerLivre() {
     //   GestionDeLivres.supprimerLivre();
    }
    private static void creerCD(Scanner scanner) {
        System.out.print("Titre du CD: ");
        String titre = scanner.nextLine();
        System.out.print("Artiste du CD: ");
        String artiste = scanner.nextLine();
        System.out.print("Nombre de pistes du CD: ");
        int nbPistes = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la ligne vide après nextInt()

        List<String> pistes = new ArrayList<>();
        for (int i = 0; i < nbPistes; i++) {
            System.out.print("Nom de la piste " + (i + 1) + " : ");
            String piste = scanner.nextLine();
            pistes.add(piste);
        }

        CD cd = new CD(titre, artiste, nbPistes);
        System.out.println("CD créé avec succès: " + cd);
    }

    private static void creerDVD(Scanner scanner) {
        System.out.print("Titre du DVD: ");
        String titre = scanner.nextLine();
        System.out.print("Réalisateur du DVD: ");
        String realisateur = scanner.nextLine();
        System.out.print("Durée du DVD (en minutes): ");
        int duree = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la ligne vide après nextInt()

        DVD dvd = new DVD(titre, realisateur, duree);
        System.out.println("DVD créé avec succès: " + dvd);
    }

    private static void creerEvenement(Scanner scanner) {
        System.out.println("Création d'un événement :");
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Lieu de l'événement : ");
        String lieu = scanner.nextLine();
        System.out.print("Date de l'événement (AAAA-MM-JJ) : ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Heure de début de l'événement (HH:MM) : ");
        LocalTime heureDebut = LocalTime.parse(scanner.nextLine());
        System.out.print("Heure de fin de l'événement (HH:MM) : ");
        LocalTime heureFin = LocalTime.parse(scanner.nextLine());

        Evenement evenement = new Evenement(titre, lieu, date, heureDebut, heureFin);
        System.out.println("Événement créé avec succès : " + evenement);
    }

    private static void creerProgramme(Scanner scanner) {
        System.out.println("Création d'un programme :");
        // si nheb nzid programme
    }
    */
}
