package com.github.com.ArnaudClarat.CompMoto.pojo;

import java.util.HashSet;
import java.util.Set;

public class MotosManager {
    private Set<Moto> motos = new HashSet<>();
    
    public boolean addMoto(Moto moto){
        return motos.add(moto);
    }
    
    public boolean containsMoto(Moto moto){
        return motos.contains(moto);
    }
    
    public boolean removeMoto(Moto moto){
        if(containsMoto(moto)){
            try {
                return motos.remove(moto);
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

    public Set<Moto> getMotos(){
        return motos;
    }
}
