package com.example.rickmorty;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MyAsyncTask extends AsyncTask<Object, Void, String> {
    private ArrayList<Personnage> lesPersos = new ArrayList<Personnage>();
    private PersonnageAdapter personnageAdapter;

    @Override
    protected String doInBackground(Object... objects) {
        try {
            lesPersos = (ArrayList<Personnage>) objects[1];
            personnageAdapter = (PersonnageAdapter) objects[2];
            String stringUrl = (String) objects[0];
            URL url = new URL(stringUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            BufferedReader reader;
            String line;
            StringBuilder responseContent = new StringBuilder();
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                JSONObject resp = new JSONObject(responseContent.toString());
                JSONObject info = resp.getJSONObject("info");
                JSONArray results = resp.getJSONArray("results");
                JSONObject perso;
                for (int i = 0; i < results.length(); i++) {
                    perso = results.getJSONObject(i);
                    Personnage p = new Personnage(perso.getString("name"), perso.getString("status"), perso.getString("species"), perso.getString("gender"), perso.getString("image"));
                    lesPersos.add(p);
                }
                if (!info.getString("next").equals("null")) {
                    new MyAsyncTask().execute(info.getString("next"), lesPersos, personnageAdapter);
                }
                conn.disconnect();
                return "ok";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "pas ok";
    }

    @Override
    protected void onPostExecute(String s) {
        System.out.println(s);
        personnageAdapter.notifyDataSetChanged();
    }
}
