package com.github.ArnaudClarat.CompMoto.pojo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Moto {
    private long id;
    private Marque marque;
    private String modele;
    private BigDecimal puissance;
    private BigDecimal conso;
    private BigDecimal reserv;
    private BigDecimal autonomie;
    private BigDecimal prix;
    private BigDecimal notePerso;
    private BigDecimal noteTotale;

    public Moto(Marque marque, String modele, BigDecimal puissance, BigDecimal conso, BigDecimal reserv, BigDecimal prix, BigDecimal notePerso) {
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.conso = conso;
        this.reserv = reserv;
        this.autonomie = this.reserv.multiply(BigDecimal.valueOf(100)).divide(this.conso, RoundingMode.HALF_UP);
        this.prix = prix;
        this.notePerso = notePerso;
        setNoteTotale();
    }

    public Moto(Marque marque, String modele, BigDecimal puissance, BigDecimal conso, BigDecimal reserv, BigDecimal autonomie, BigDecimal prix, BigDecimal notePerso) {
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.conso = conso;
        this.reserv = reserv;
        this.autonomie = autonomie;
        this.prix = prix;
        this.notePerso = notePerso;
        setNoteTotale();
    }

    public long getId() {
        return id;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public BigDecimal getPuissance() {
        return puissance;
    }

    public void setPuissance(BigDecimal puissance) {
        this.puissance = puissance;
    }

    public BigDecimal getConso() {
        return conso;
    }

    public void setConso(BigDecimal conso) {
        this.conso = conso;
    }

    public BigDecimal getReserv() {
        return reserv;
    }

    public void setReserv(BigDecimal reserv) {
        this.reserv = reserv;
    }

    public BigDecimal getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(BigDecimal autonomie) {
        this.autonomie = autonomie;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public BigDecimal getNotePerso() {
        return notePerso;
    }

    public void setNotePerso(BigDecimal notePerso) {
        this.notePerso = notePerso;
    }

    public BigDecimal getNoteTotale() {
        return noteTotale;
    }

    private void setNoteTotale() {
        BigDecimal notePuissance = this.puissance.subtract(BigDecimal.valueOf(20)); // Coté sur 15 (Meilleur = 35/Pire = 20)
        BigDecimal noteConso = (this.conso.subtract(BigDecimal.valueOf(2))).multiply(BigDecimal.valueOf(5)); // Coté sur 20 (Meilleur = 2/Pire = 6)
        BigDecimal noteReserv = (this.reserv.subtract(BigDecimal.valueOf(5))).divide(BigDecimal.valueOf(2)); // Coté sur 10 (Meilleur = 25/Pire = 5)
        BigDecimal noteAutonomie = (this.autonomie.subtract(BigDecimal.valueOf(200))).divide(BigDecimal.valueOf(10)); // Coté sur 40 (Meilleur = 600/Pire = 200)
        BigDecimal notePrix = (this.prix.subtract(BigDecimal.valueOf(1000))).divide(BigDecimal.valueOf(160)); //Coté sur 25 (Meilleur = 1000/Pire = 5000)
        BigDecimal notePerso = this.notePerso.multiply(BigDecimal.valueOf(0.9)); //Coté sur 90 (Meilleur = 100/Pire = 0)
        this.noteTotale = notePuissance
                .add(noteConso)
                .add(noteReserv)
                .add(noteAutonomie)
                .add(notePrix)
                .add(notePerso)
                .divide(BigDecimal.valueOf(2),2);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string
                .append("\nID : ").append(this.getId())
                .append("\nMarque : ").append(this.getMarque())
                .append("\nModèle : ").append(this.getModele())
                .append("\nPuissance : ").append(this.getPuissance()).append("kW")
                .append("\nConso : ").append(this.getConso()).append("l/100km")
                .append("\nCapacité reservoir : ").append(this.getReserv()).append("l")
                .append("\nAutonomie : ").append(this.getAutonomie()).append("km")
                .append("\nPrix : ").append(this.getPrix()).append("€")
                .append("\nNote personnelle : ").append(this.getNotePerso()).append("/100")
                .append("\nNote Totale : ").append(this.getNoteTotale()).append("/100");
        return string.toString();
    }
}
