package com.example.tp2;

public class Tache {
    private String nom;
    private int duree;
    private String description;
    private Categorie categorie;

    public enum Categorie {
        Autre, Travail, Sport, Menage, Lecture, Enfants, Courses
    }

    public Tache (String n){
        nom=n;
        duree=0;
        description="";
        categorie=Categorie.Autre;
    }

    public Tache(String n, String cat, String d, String desc){
        nom=n;
        categorie=Categorie.valueOf(cat);
        duree= Integer.parseInt(d);
        description=desc;
    }

    public Tache(String n, Categorie cat, int d, String desc){
        nom=n;
        categorie=cat;
        duree=d;
        description=desc;
    }

    public String getNom(){
        return nom;
    }

    public int getDuree(){
        return duree;
    }

    public Categorie getCategorie(){
        return categorie;
    }

    public String getDescription(){
        return description;
    }
}
