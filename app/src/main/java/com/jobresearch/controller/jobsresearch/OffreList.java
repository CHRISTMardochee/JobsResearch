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

public class OffreList extends ArrayAdapter<Offre> {
    private Activity context;
    List<Offre> offres;


    public OffreList(Activity context, List<Offre> offres){
        super(context , R.layout.layout_offre_list, offres);
        this.context=context;
        this.offres=offres;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_offre_list, null, true);
        
        TextView fonction = (TextView) listViewItem.findViewById(R.id.fonction);
        TextView secteur= (TextView) listViewItem.findViewById(R.id.secteur);
        TextView poste = (TextView) listViewItem.findViewById(R.id.poste);
        TextView lieu = (TextView) listViewItem.findViewById(R.id.lieu);
        TextView type = (TextView) listViewItem.findViewById(R.id.type);
        TextView profil = (TextView) listViewItem.findViewById(R.id.profil);
        

        Offre offre = offres.get(position);
        fonction.setText(offre.getFonction());
        secteur.setText(offre.getSecteur());
        poste.setText(offre.getPoste());
        lieu.setText(offre.getLieu());
        type.setText(offre.getType());
        profil.setText(offre.getProfil());
        
        return listViewItem;
    }

}