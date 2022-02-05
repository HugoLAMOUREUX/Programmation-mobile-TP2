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
    Spinner dropdown;
    TextInputEditText desc;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        titre=findViewById(R.id.inputTitre);
        duree=findViewById(R.id.inputDuree);
        desc=findViewById(R.id.inputDescription);

        /* Ajout des items au spinner */

        dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Sport", "Enfants","Courses", "Menage","Lecture","Travail","Autre"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items); //android.R.layout.simple_spinner_dropdown_item
        dropdown.setAdapter(adapter);
    }

    /* Fonction lancée quand on appuie sur le bouton OK */
    public void valider(View view){
        Intent data= new Intent();

        /* Vérification du remplissage de champs */
        if(titre.getText().toString().equals("") || desc.getText().toString().equals("") || duree.getText().toString().equals("") ){
            error=findViewById(R.id.errorTv);
            error.setText("Merci de bien vouloir remplir les champs correctement !");
            return ;
        }
        /* Passage des données */
        data.putExtra(Constantes.TACHE,""+titre.getText());
        data.putExtra(Constantes.DUREE,""+duree.getText());
        data.putExtra(Constantes.DESCRIPTION,""+desc.getText());
        data.putExtra(Constantes.CATEGORIE,""+dropdown.getSelectedItem().toString());
        setResult(Constantes.CODE_OK,data);
        finish();
    }
}