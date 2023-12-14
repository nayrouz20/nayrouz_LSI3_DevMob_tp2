package com.example.weslati_nayrouz_tp1.model;

public class Patient {
    private int age;
    private float valeur_mesure;
    private String resultat;
    private boolean jeuner;
//update controller --> model
    public Patient(int age, float valeur_mesure, boolean jeuner) {
        this.age = age;
        this.valeur_mesure = valeur_mesure;
        this.jeuner = jeuner;
    }

    void calculer() {
        if (jeuner) {
            if (age >= 13) {
                if (valeur_mesure < 5.0) {
                    resultat = ("Niveau de glycemie est bas");
                } else if (valeur_mesure >= 5.0 && valeur_mesure <= 7.2) {
                    resultat = ("Niveau de glycemie est normale");
                } else {
                    resultat = ("Niveau de glycemie est trop elevée");
                }
            } else if (age >= 6 && age <= 12) {
                if (valeur_mesure < 5.0) {
                    resultat = ("Niveau de glycemie est trop bas");
                } else if (valeur_mesure >= 5.0 && valeur_mesure <= 10.0) {
                    resultat = ("Niveau de glycemie est normale");
                } else {
                    resultat = ("Niveau de glycemie est trop elevée");
                }
            } else {
                if (valeur_mesure < 5.5) {
                    resultat = ("Niveau de glycemie est trop bas");
                } else if (valeur_mesure >= 5.5 && valeur_mesure <= 10.0) {
                    resultat = ("Niveau de glycemie est normale");
                } else {
                    resultat = ("Niveau de glycemie est trop elevée");
                }
            }
        }
    }
    //notify model -->controller
    public String getResultat(){
        return resultat;
    }

}
