package com.jobresearch.controller.jobsresearch;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

/**
 * Created by Mardochée on 18/05/2018.
 */

public class CvList extends ArrayAdapter<Cv> {
    private Activity context;
    List<Cv> cvs;

    public CvList(Activity context, List<Cv> cvs){
        super(context , R.layout.layout_cv_list,cvs);
        this.context=context;
        this.cvs=cvs;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_cv_list, null, true);

        TextView nom = (TextView) listViewItem.findViewById(R.id.nom);
        TextView prenom = (TextView) listViewItem.findViewById(R.id.prenom);
        TextView email = (TextView) listViewItem.findViewById(R.id.email);
        TextView adresse = (TextView) listViewItem.findViewById(R.id.adresse);
        TextView tel = (TextView) listViewItem.findViewById(R.id.tel);
        TextView objectif = (TextView) listViewItem.findViewById(R.id.objectif);
        TextView formation = (TextView) listViewItem.findViewById(R.id.formation);
        TextView cpt = (TextView) listViewItem.findViewById(R.id.competences);
        TextView cdi = (TextView) listViewItem.findViewById(R.id.centredi);

        Cv cv = cvs.get(position);
        nom.setText(cv.getNom());
        prenom.setText(cv.getPrenom());
        email.setText(cv.getEmail());
        adresse.setText(cv.getAdresse());
        tel.setText(cv.getTelephone());
        objectif.setText(cv.getObjectif());
        formation.setText(cv.getFormation());
        cpt.setText(cv.getCompetence());
        cdi.setText(cv.getCdi());




        return listViewItem;
    }

}