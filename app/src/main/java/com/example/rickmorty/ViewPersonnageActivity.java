package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ViewPersonnageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_personnage);

        Personnage p = (Personnage) this.getIntent().getSerializableExtra("personnage");

        ImageView personnageImage = findViewById(R.id.idViewPersonnageImage);
        TextView personnageName = findViewById(R.id.idViewPersonnageName);
        ImageView personnageGenre = findViewById(R.id.idViewPersonnageGenre);
        ImageView personnageEspece = findViewById(R.id.idViewPersonnageEspece);
        ImageView personnageStatus = findViewById(R.id.idViewPersonnageStatus);

        TextView personnageDefaultGenre = findViewById(R.id.idViewDefaultGenre);
        TextView personnageDefaultStatus = findViewById(R.id.idViewDefaultStatus);
        TextView personnageDefaultEspece = findViewById(R.id.idViewDefaultEspece);

        Picasso.get().load(p.getImage()).into(personnageImage);
        personnageName.setText(p.getNom());

        if (p.getGenre().equals("unknown")) {
            personnageDefaultGenre.setText("Inconnu");
        } else if (p.getGenre().equals("Male")) {
            Picasso.get().load("https://image.flaticon.com/icons/png/512/44/44483.png").into(personnageGenre);
        } else if (p.getGenre().equals("Female")) {
            Picasso.get().load("https://www.icone-png.com/png/45/45112.png").into(personnageGenre);
        } else {
            personnageDefaultGenre.setText(p.getGenre());
        }

        if (p.getEspece().equals("unknown")) {
            personnageDefaultEspece.setText("Inconnu");
        } else if (p.getEspece().equals("Alien")) {
            Picasso.get().load("https://img.icons8.com/metro/452/grey.png").into(personnageEspece);
        } else if (p.getEspece().equals("Human")) {
            Picasso.get().load("https://cdn3.iconfinder.com/data/icons/halloween/512/skull-512.png").into(personnageEspece);
        } else {
            personnageDefaultEspece.setText(p.getEspece());
        }

        if (p.getStatus().equals("unknown")) {
            personnageDefaultStatus.setText("Inconnu");
        } else if (p.getStatus().equals("Alive")) {
            Picasso.get().load("https://cdn3.iconfinder.com/data/icons/valentine-s-day-26/52/30-2-512.png").into(personnageStatus);
        } else if (p.getStatus().equals("Dead")) {
            Picasso.get().load("https://icons-for-free.com/iconfiles/png/512/dead-1321215618131453604.png").into(personnageStatus);
        } else {
            personnageDefaultStatus.setText(p.getStatus());
        }
    }
}