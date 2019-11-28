package com.github.ArnaudClarat.CompMoto.app;

import com.github.ArnaudClarat.CompMoto.pojo.Marque;
import com.github.ArnaudClarat.CompMoto.pojo.Moto;
import com.github.ArnaudClarat.CompMoto.pojo.MotosManager;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String choice;
        do {
            choice = menu();
            if (choice.equals("1")){
                newMoto();
            }
            if (choice.equals("2")){
                showMotos();
            }
            if (choice.equals("3")){
                bestMoto();
            }
        } while (!choice.equals("Q"));
    }

    private static void bestMoto() {
        String string = "Meilleure moto :" +
                "\n"+MotosManager.getBestMoto();
        System.out.println(string);
    }


    private static void showMotos() {
        String choice;
        do {
            System.out.println(MotosManager.toString2());
            System.out.println("Selectionnez une moto pour voir les détails ou tapez R pour revenir au menu");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();
            if (choice.equals("R")) {
                return;
            } else {
                showMoto(choice);
            }
        } while (Arrays.asList("a","b","c").contains("a"));
    }

    private static void showMoto(String id) {
        System.out.println(MotosManager.getMoto(Long.parseLong(id)).toString());
        // TODO Ajouter updateMoto();
        // TODO Ajouter removeMoto();
    }

    private static void newMoto() { // TODO Check toutes les verifications
        System.out.println("Marque? ");
        Scanner scanner = new Scanner(System.in);
        String tMarque = scanner.nextLine();
        while (!Marque.contains(tMarque)) {
            System.out.print("La Marque n'est pas correcte ");
            tMarque = scanner.nextLine();
        }
        Marque marque = Marque.getMarque(tMarque);

        System.out.println("Modèle? ");
        String modele = scanner.nextLine();

        System.out.println("Puissance? en kW");
        String tPuissance = scanner.nextLine();
        boolean test = false;
        do {
            try {
                BigDecimal puissance = new BigDecimal(tPuissance);
                if (puissance.compareTo(BigDecimal.valueOf(35)) < 0) {
                    test = true;
                }
            } catch (Exception e) {
                System.out.println("Veuillez rentrer un nombre correct. ");
                tPuissance = scanner.nextLine();
            }
        } while (!test);
        BigDecimal puissance = new BigDecimal(tPuissance);

        System.out.println("Consomation? en l/100km");
        String tConso = scanner.nextLine();
        test = false;
        do {
            try {
                BigDecimal conso = new BigDecimal(tConso);
                if (conso.compareTo(BigDecimal.valueOf(10)) < 0) {
                    test = true;
                }
            } catch (Exception e) {
                System.out.println("Veuillez rentrer un nombre correct. ");
                tConso = scanner.nextLine();
            }
        } while (!test);
        BigDecimal conso = new BigDecimal(tConso);

        System.out.println("Taille de reservoir? en l");
        String tReserv = scanner.nextLine();
        test = false;
        do {
            try {
                BigDecimal reserv = new BigDecimal(tReserv);
                if (reserv.compareTo(BigDecimal.valueOf(20)) < 0) {
                    test = true;
                }
            } catch (Exception e) {
                System.out.println("Veuillez rentrer un nombre correct. ");
                tReserv = scanner.nextLine();
            }
        } while (!test);
        BigDecimal reserv = new BigDecimal(tReserv);

        System.out.println("Prix? ");
        String tPrix = scanner.nextLine();
        test = false;
        do {
            try {
                BigDecimal prix = new BigDecimal(tPrix);
                if (prix.compareTo(BigDecimal.valueOf(7000)) < 0) {
                    test = true;
                }
            } catch (Exception e) {
                System.out.println("Veuillez rentrer un nombre correct. ");
                tPrix = scanner.nextLine();
            }
        } while (!test);
        BigDecimal prix = new BigDecimal(tPrix);

        System.out.println("Note Personnelle? ");
        String tNotePerso = scanner.nextLine();
        test = false;
        do {
            try {
                BigDecimal notePerso = new BigDecimal(tNotePerso);
                if (notePerso.compareTo(BigDecimal.valueOf(100)) < 0) {
                    test = true;
                }
            } catch (Exception e) {
                System.out.println("Veuillez rentrer un nombre correct. ");
                tNotePerso = scanner.nextLine();
            }
        } while (!test);
        BigDecimal notePerso = new BigDecimal(tNotePerso);

        Moto newMoto = new Moto(marque, modele, puissance, conso, reserv, prix, notePerso);
        MotosManager.addMoto(newMoto);
    }

    private static String menu(){
        String menu = "\n\t\tMenu :  " +
                "\n\t\t\t1 = Ajouter une moto" +
                "\n\t\t\t2 = Afficher une moto" +
                "\n\t\t\t3 = Afficher la meilleure moto" +
                "\n\t\t\tQ = Quitter le programme" +
                "\n\n\t\tQue voulez-vous faire? ";
        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }
}
