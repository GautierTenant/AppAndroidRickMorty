package com.example.rickmorty;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PersonnageAdapter extends BaseAdapter {

    private ArrayList<Personnage> personnages;
    private Context context;

    public PersonnageAdapter(Context context, ArrayList<Personnage> personnages) {
        this.context = context;
        this.personnages = personnages;
    }

    @Override
    public int getCount() {
        return personnages.size();
    }

    @Override
    public Object getItem(int position) {
        return personnages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout layoutItem;
        LayoutInflater mInflater = LayoutInflater.from(context);

        if (convertView == null) {
            layoutItem = (ConstraintLayout) mInflater.inflate(R.layout.personnage_layout, parent, false);
        } else {
            layoutItem = (ConstraintLayout) convertView;
        }

        TextView personnageNom = layoutItem.findViewById(R.id.idPersonnageNom);
        if (personnages.get(position).getStatus().equals("Alive")) {
            personnageNom.setText(personnages.get(position).getNom());
            personnageNom.setTextColor(Color.GREEN);
        } else if (personnages.get(position).getStatus().equals("Dead")) {
            personnageNom.setText(personnages.get(position).getNom());
            personnageNom.setTextColor(Color.RED);
        } else {
            personnageNom.setText(personnages.get(position).getNom());
            personnageNom.setTextColor(Color.BLACK);
        }

        ImageView personnageImage = layoutItem.findViewById(R.id.idPersonnageImage);
        Picasso.get().load(personnages.get(position).getImage()).into(personnageImage);


        return layoutItem;
    }
}
