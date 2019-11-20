package com.github.ArnaudClarat.CompMoto.app;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String choice = menu();
        do {
            if (choice.equals("1")){
                // TODO Créer newMoto()
            }
            if (choice.equals("2")){
                // TODO Créer showMoto()
            }
            if (choice.equals("3")){
                // TODO Créer removeMoto()
            }
            if (choice.equals("4")){
                // TODO Créer bestMoto()
            }
            menu();
        } while (!choice.equals("Q"));
    }

    private static String menu(){
        String menu = "\t\tMenu :  " +
                "\n\t\t\t1 = Ajouter une moto" +
                "\n\t\t\t2 = Afficher une moto" +
                "\n\t\t\t3 = Supprimer une moto" +
                "\n\t\t\t4 = Afficher la meilleure moto" +
                "\n\t\t\tQ = Quitter le programme" +
                '\n'  +
                "\n\t\tQue voulez-vous faire? ";
        Scanner scanner = new Scanner(System.in);
        System.out.print(menu);
        return scanner.next();
    }
}
