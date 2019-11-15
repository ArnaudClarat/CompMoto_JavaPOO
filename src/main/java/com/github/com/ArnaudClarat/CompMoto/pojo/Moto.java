package com.github.com.ArnaudClarat.CompMoto.pojo;

public class Moto {
    private Marque marque;
    private String modele;
    private double puissance;
    private double conso;
    private double reserv;
    private double autonomie;
    private double prix;
    private double notePerso;
    private double noteTotale;

    public Moto(Marque marque, String modele, double puissance, double conso, double reserv, double prix, double notePerso) {
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.conso = conso;
        this.reserv = reserv;
        this.autonomie = this.reserv/this.conso*100;
        this.prix = prix;
        this.notePerso = notePerso;
        setNoteTotale();
    }

    public Moto(Marque marque, String modele, double puissance, double conso, double reserv, double autonomie, double prix, double notePerso) {
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

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance) {
        this.puissance = puissance;
    }

    public double getConso() {
        return conso;
    }

    public void setConso(double conso) {
        this.conso = conso;
    }

    public double getReserv() {
        return reserv;
    }

    public void setReserv(double reserv) {
        this.reserv = reserv;
    }

    public double getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(double autonomie) {
        this.autonomie = autonomie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getNotePerso() {
        return notePerso;
    }

    public void setNotePerso(double notePerso) {
        this.notePerso = notePerso;
    }

    public double getNoteTotale() {
        return noteTotale;
    }

    private void setNoteTotale() {
        double notePuissance = this.puissance - 20; // Coté sur 15 (Meilleur = 35/Pire = 20)
        double noteConso = (this.conso - 2) * 5; // Coté sur 20 (Meilleur = 2/Pire = 6)
        double noteReserv = (this.reserv - 5) * 0.5d; // Coté sur 10 (Meilleur = 25/Pire = 5)
        double noteAutonomie = (this.autonomie - 200) / 10; // Coté sur 40 (Meilleur = 600/Pire = 200)
        double notePrix = (this.prix - 100) / 160; //Coté sur 25 (Meilleur = 1000/Pire = 5000)
        double noteNPerso = this.notePerso * 0.9d; //Coté sur 90 (Meilleur = 100/Pire = 0)
        this.noteTotale = (notePuissance + noteConso + noteReserv + noteAutonomie + notePrix + noteNPerso) / 2;
    }
}
