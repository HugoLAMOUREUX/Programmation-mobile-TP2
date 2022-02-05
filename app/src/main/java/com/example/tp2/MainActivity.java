package com.example.tp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Tache> mesTaches;
    private TacheAdapter tacheAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTaches();

        recyclerView =(RecyclerView) findViewById(R.id.rvId);
        tacheAdapter=new TacheAdapter(mesTaches);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tacheAdapter);
    }

    /* Fonction lancée lors du click sur le bouton + */
    public void onAjoutBtnClick(View view){
        Intent intent=new Intent(view.getContext(),AjoutActivity.class);
        startActivityForResult(intent,Constantes.REQUEST_CODE);
    }

    /* Fonction lancée lors du retour de l'Activité AjoutActivity */
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if((resultCode==Constantes.CODE_OK)&&(requestCode==Constantes.REQUEST_CODE)){
            Tache t=new Tache(data.getStringExtra(Constantes.TACHE),data.getStringExtra(Constantes.CATEGORIE),data.getStringExtra(Constantes.DUREE),data.getStringExtra(Constantes.DESCRIPTION));
            mesTaches.add(t);
            tacheAdapter.notifyDataSetChanged();
        }
    }

    /* Fonction qui initialise des tâches par défaut */
    public void initTaches(){
        Tache t1=new Tache("Footing","Sport","60","Course de Yvan");
        Tache t2=new Tache("Travail","Travail","190","Etude pratique");
        Tache t3=new Tache("Grand menage","Menage","10","9 metres carrés");
        Tache t4=new Tache("Promener le chien","Autre","60","Max se balade");
        Tache t5=new Tache("Hunger Games","Lecture","45","Très bon livre");
        Tache t6=new Tache("Mettre au four","Enfants","60","Petit repas de famille");
        Tache t7=new Tache("Courses","Courses","120","Courses alcool");
        Tache t8=new Tache("Footing 10km","Sport","70","Bravo selim -Yvan");
        mesTaches=new ArrayList<Tache>(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8));

    }

}