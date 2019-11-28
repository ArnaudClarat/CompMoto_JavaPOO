package com.github.ArnaudClarat.CompMoto.pojo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Predicate;

public class MotosManager {
    private static Set<Moto> motos = new HashSet<>();

    public static boolean addMoto(Moto moto){
        return motos.add(moto);
        // TODO Gérer Database
    }

    public static Moto getBestMoto() {
        return motos
                .parallelStream()
                .max(Comparator.comparing(Moto::getNoteTotale))
                .orElseThrow(NoSuchElementException::new);
    }

    public boolean containsMoto(Moto moto){
        return motos.contains(moto);
    }
    
    public boolean removeMoto(Moto moto){
        if(containsMoto(moto)){
            try {
                return motos.remove(moto);
                // TODO Gérer Database
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateMoto(Moto moto1, Moto moto2) {
        if (containsMoto(moto1)) {
            try {
                removeMoto(moto1);
                addMoto(moto2);
                // TODO Gérer Database
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        else {
            return false;
        }
    }

    public static Set<Moto> getMotos(){
        return motos;
    }

    public static Moto getMoto(long id) {
        Predicate<Moto> predicate = moto -> moto.getId() == id;
        return motos.parallelStream().filter(predicate).findFirst().get();
    }

    public static String toString2() {
        StringBuilder string = new StringBuilder();
        for (Moto moto : MotosManager.motos) {
            string.append("\n").append(moto.getMarque()).append(" ").append(moto.getModele()).append(" - ").append(moto.getNoteTotale());
        }
        return string.toString();
    }
}
