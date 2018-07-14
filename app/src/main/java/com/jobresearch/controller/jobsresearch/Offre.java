package com.jobresearch.controller.jobsresearch;

/**
 * Created by Mardochée on 19/05/2018.
 */

public class Offre {

    String id;
    String secteur;
    String fonction;
    String poste;
    String lieu;
    String type;
    String profil;

    public Offre(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Offre(String id, String secteur,  String lieu,String fonction, String poste, String profil,String type){
        this.id=id;
        this.fonction=fonction;
        this.secteur=secteur;
        this.poste=poste;
        this.lieu=lieu;
        this.type=type;
        this.profil=profil;

    }

}
