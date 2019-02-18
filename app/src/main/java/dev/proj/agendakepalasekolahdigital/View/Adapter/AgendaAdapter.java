package dev.proj.agendakepalasekolahdigital.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.proj.agendakepalasekolahdigital.Model.Agendas;
import dev.proj.agendakepalasekolahdigital.R;
import dev.proj.agendakepalasekolahdigital.View.Activity.InputBukti;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaHolder> {

    private Context context;
    private List<Agendas> data;

    public AgendaAdapter(Context context) {
        this.context = context;
        data =new ArrayList<>();
    }

    @NonNull
    @Override
    public AgendaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater
                .from(context)
                .inflate(R.layout.row_agenda,viewGroup, false);

        return new AgendaHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaHolder agendaHolder, int i) {
        Agendas agendas = data.get(i);
        agendaHolder.agendaAcara.setText(agendas.getAgenda());
        agendaHolder.agendaLokasi.setText(agendas.getLokasi());
        agendaHolder.agendaRepeat.setText(agendas.getRepeat() ? "Ya" : "Tidak");
        agendaHolder.agendaWaktu.setText(String.format("%s, %s", agendas.getWaktu(), agendas.getDate()));
        agendaHolder.parentBackground.setBackgroundColor(i % 2 == 0 ? context.getResources().getColor(R.color.agendaGenap) : context.getResources().getColor(R.color.white));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void add(Agendas agendas){
        data.add(agendas);
        notifyItemInserted(data.size() - 1);
    }

    public void addListItems(List<Agendas> agendasList){
        for (Agendas agendas : agendasList){
            add(agendas);
        }
    }

    class AgendaHolder extends RecyclerView.ViewHolder{
        TextView agendaAcara, agendaWaktu, agendaLokasi, agendaRepeat;
        LinearLayout parentBackground;
        AgendaHolder(@NonNull View itemView) {
            super(itemView);

            parentBackground = itemView.findViewById(R.id.parentBackground);
            agendaAcara = itemView.findViewById(R.id.agendaAcara);
            agendaLokasi = itemView.findViewById(R.id.agendaLokasi);
            agendaWaktu = itemView.findViewById(R.id.agendaWaktu);
            agendaRepeat = itemView.findViewById(R.id.agendaRepeat);

            itemView.setOnClickListener(v -> {
                Intent i = new Intent(context, InputBukti.class);
                context.startActivity(i);
            });

        }
    }

}
