package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class AjoutActivity extends AppCompatActivity {
    TextInputEditText titre;
    TextInputEditText duree;
    Spinner cat;
    TextInputEditText desc;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        titre=findViewById(R.id.inputTitre);
        duree=findViewById(R.id.inputDuree);
        desc=findViewById(R.id.inputDescription);
        cat = (Spinner)findViewById(R.id.spinner1);

        /* Ajout des items au spinner */

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Sport", "Enfants","Courses", "Menage","Lecture","Travail","Autre"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items); //android.R.layout.simple_spinner_dropdown_item
        dropdown.setAdapter(adapter);
    }

    public void valider(View view){
        Intent data= new Intent();
        if(titre.getText().toString().equals("") || desc.getText().toString().equals("") || duree.getText().toString().equals("") ){
            error=findViewById(R.id.errorTv);
            error.setText("Merci de bien vouloir remplir les champs correctement !");
            return ;
        }
        data.putExtra(Constantes.TACHE,""+titre.getText());
        data.putExtra(Constantes.DUREE,""+duree.getText());
        data.putExtra(Constantes.DESCRIPTION,""+desc.getText());
        data.putExtra(Constantes.CATEGORIE,""+cat.getSelectedItem().toString());
        setResult(Constantes.CODE_OK,data);
        finish();
    }
}