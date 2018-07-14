package com.jobresearch.controller.jobsresearch;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Mardochée on 18/05/2018.
 */

@IgnoreExtraProperties
public class Cv {

        private String id;
        private String nom;
        private String prenom;
        private String email;
        private String adresse;
        private String telephone;
        private String objectif;
        private String formation;
        private String competence;
        private String cdi;

    public String getId() {
        return id;
    }


    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getCdi() {
        return cdi;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {

        return adresse;
    }

    public String getNom() {

        return nom;
    }

    public String getObjectif() {
        return objectif;
    }

    public String getFormation() {
        return formation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public void setCdi(String cdi) {
        this.cdi = cdi;
    }

    public String getCompetence() {
        return competence;
    }

    public Cv(){
    }


    public Cv(String id,String nom,String prenom,String email,String adresse,String cdi,String telephone,String objectif,String formation,String competence){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse=adresse;
        this.cdi=cdi;
        this.telephone=telephone;
        this.objectif=objectif;
        this.formation=formation;
        this.competence=competence;
    }




}

