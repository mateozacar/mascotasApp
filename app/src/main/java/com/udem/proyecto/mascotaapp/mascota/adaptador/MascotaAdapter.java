package com.udem.proyecto.mascotaapp.mascota.adaptador;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.udem.proyecto.mascotaapp.Constantes;
import com.udem.proyecto.mascotaapp.R;
import com.udem.proyecto.mascotaapp.mascota.ActionClick;
import com.udem.proyecto.mascotaapp.modelos.Mascota;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaAdapterViewHolder> {

    private List<Mascota> listaMascotas;
    private ActionClick actionClick;

    public  MascotaAdapter(ActionClick actionClick){
        listaMascotas = new ArrayList<>();
        this.actionClick = actionClick;
    }
    @NonNull
    @Override
    public MascotaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota_adapter,parent,false);
        return new MascotaAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaAdapterViewHolder holder, int position) {
        Mascota mascota = listaMascotas.get(position);
        holder.nombreMascota.setText(mascota.getNombre());
        holder.descripcionMascota.setText(mascota.getDescripcion());
        holder.tipoMascota.setText(mascota.getTipoMascota());
    }

    public void agregarMascota(Mascota mascota){
        listaMascotas.add(mascota);
        notifyDataSetChanged();
    }
    public void agregarListaMascotas(List<Mascota> listaMascotas){
        this.listaMascotas = listaMascotas;
        notifyDataSetChanged();
    }
    public void borrarMascota(Mascota mascota){
        listaMascotas.remove(mascota);
        notifyDataSetChanged();
    }

    public Mascota actualizarMascota(){
        return null;
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public class MascotaAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imagenMascota;
        public EditText nombreMascota;
        public EditText descripcionMascota;
        public EditText tipoMascota;

        public ImageView ivBorrarMascota;
        public Button btnGuardarMascota;

        public MascotaAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenMascota = itemView.findViewById(R.id.ivImagenMascota);
            imagenMascota.setImageResource(R.drawable.icon_animal);
            nombreMascota = itemView.findViewById(R.id.etNombreMascota_adapter);
            descripcionMascota = itemView.findViewById(R.id.etDescripcionMascota_adapter);
            tipoMascota = itemView.findViewById(R.id.etTipoMascota_adapter);
            ivBorrarMascota = itemView.findViewById(R.id.ivBorrarMascota);
            btnGuardarMascota = itemView.findViewById(R.id.btnAguardarMascota);

            ivBorrarMascota.setOnClickListener(this);
            btnGuardarMascota.setOnClickListener(this);

            nombreMascota.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    listaMascotas.get(getLayoutPosition()).setNombre(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            descripcionMascota.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    listaMascotas.get(getLayoutPosition()).setDescripcion(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            tipoMascota.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    listaMascotas.get(getLayoutPosition()).setTipoMascota(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ivBorrarMascota:
                    actionClick.myClick(Constantes.ACCION_BORRAR_MASCOTA,listaMascotas.get(getLayoutPosition()),getLayoutPosition());
                    break;
                case R.id.btnAguardarMascota:
                    actionClick.myClick(Constantes.ACCION_GUARDAR_MASCOTA,listaMascotas.get(getLayoutPosition()),getLayoutPosition());
                    break;
            }
        }

    }
}
