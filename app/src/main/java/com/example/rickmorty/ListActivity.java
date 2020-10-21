package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ArrayList<Personnage> personnages = new ArrayList<>();
    private PersonnageAdapter persoAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        persoAdapter = new PersonnageAdapter(ListActivity.this, personnages);
        ListView personnageView = findViewById(R.id.idPersonnagesView);
        personnageView.setAdapter(persoAdapter);

        String url = "https://rickandmortyapi.com/api/character";
        new MyAsyncTask().execute(url, personnages, persoAdapter);

        this.context = this;

        personnageView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(context, ViewPersonnageActivity.class);
                i.putExtra("personnage", personnages.get(position));
                startActivity(i);
            }
        });
    }
}