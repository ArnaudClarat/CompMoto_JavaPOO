package com.github.com.ArnaudClarat.CompMoto.app;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String choice = "x";
        String menu ="""
	Menu :
		1 = Ajouter une moto
		2 = Afficher une moto
		3 = Supprimer une moto
		4 = Afficher la meilleure moto
		Q = Quitter le programme

    Que voulez-vous faire?
		""";
        Scanner scanner = new Scanner(System.in);

        while (!choice.equals("Q")) {
            System.out.println(menu);
            choice = scanner.nextLine();
            if (choice.equals("1")){

            }
            if (choice.equals("2")){

            }
            if (choice.equals("3")){

            }
            if (choice.equals("4")){

            }
        }
    }
}
