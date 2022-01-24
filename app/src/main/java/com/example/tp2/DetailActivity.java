package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvTache;
    TextView tvDuree;
    TextView tvDescr;
    ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTache=findViewById(R.id.tacheId);
        tvDuree=findViewById(R.id.dureeId);
        tvDescr=findViewById(R.id.descriptionId);
        ivImg=findViewById(R.id.imgId);


        Intent intent=this.getIntent();
        tvTache.setText(intent.getStringExtra(Constantes.TACHE));
        tvDuree.setText(""+intent.getIntExtra(Constantes.DUREE,0)+"min");
        tvDescr.setText(intent.getStringExtra(Constantes.DESCRIPTION));
        String cat=intent.getStringExtra(Constantes.CATEGORIE);
        switch (cat){
            case "Sport": {
                ivImg.setImageResource(R.drawable.sport);
                break;
            }
            case "Enfants": {
                ivImg.setImageResource(R.drawable.enfant);
                break;
            }
            case "Courses": {
                ivImg.setImageResource(R.drawable.courses);
                break;
            }
            case "Menage": {
                ivImg.setImageResource(R.drawable.menage);
                break;
            }
            case "Lecture": {
                ivImg.setImageResource(R.drawable.lecture);
                break;
            }
            case "Travail": {
                ivImg.setImageResource(R.drawable.travail);
                break;
            }
            case "Autre": {
                ivImg.setImageResource(R.drawable.point_interro_);
                break;
            }
        }


    }
}