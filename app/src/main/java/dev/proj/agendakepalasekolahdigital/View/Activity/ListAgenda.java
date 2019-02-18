package dev.proj.agendakepalasekolahdigital.View.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import dev.proj.agendakepalasekolahdigital.Model.Agendas;
import dev.proj.agendakepalasekolahdigital.R;
import dev.proj.agendakepalasekolahdigital.View.Adapter.AgendaAdapter;

public class ListAgenda extends AppCompatActivity {
    RecyclerView recyclerAgenda;
    AgendaAdapter agendaAdapter;
    List<Agendas> data;
    FloatingActionButton tambahAgenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agenda);
        getSupportActionBar().setTitle("Daftar Agenda");
        getSupportActionBar().setSubtitle("Agenda Periode " + getIntent().getStringExtra("params"));

        data = new ArrayList<>();
        agendaAdapter = new AgendaAdapter(this);

        recyclerAgenda = findViewById(R.id.recyclerAgenda);
        tambahAgenda = findViewById(R.id.tambahAgenda);

        data.add(new Agendas("Rapat Kuy","Ruangan 108","10:20 PM","20/Feb/2019",true));
        data.add(new Agendas("Bagi Rapot","Ruangan 120","10:20 PM","22/Feb/2019",false));
        data.add(new Agendas("Meeting","Ruangan 129","10:20 PM","23/Feb/2019",true));
        data.add(new Agendas("Rapat Lagi","Ruangan 126","10:20 PM","24/Feb/2019",true));
        data.add(new Agendas("Rapat Terus","Ruangan 209","10:20 PM","25/Feb/2019",true));
        recyclerAgenda.setAdapter(agendaAdapter);
        recyclerAgenda.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        agendaAdapter.addListItems(data);

        tambahAgenda.setOnClickListener(v -> {
            Intent i = new Intent(ListAgenda.this, TambahAgenda.class);
            startActivity(i);
        });

    }
}
