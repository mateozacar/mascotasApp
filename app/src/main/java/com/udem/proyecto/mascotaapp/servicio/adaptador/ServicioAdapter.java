package com.udem.proyecto.mascotaapp.servicio.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.udem.proyecto.mascotaapp.Constantes;
import com.udem.proyecto.mascotaapp.R;
import com.udem.proyecto.mascotaapp.modelos.Servicio;
import com.udem.proyecto.mascotaapp.servicio.ActionClickServicio;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ServicioAdapter extends RecyclerView.Adapter<ServicioAdapter.ServicioAdapterViewHolder> {

    private List<Servicio> listaServicios;
    private ActionClickServicio actionClick;

    public ServicioAdapter(ActionClickServicio actionClick){
        listaServicios = new ArrayList<>();
        this.actionClick = actionClick;
    }
    @NonNull
    @Override
    public ServicioAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servicio_adapter,parent,false);
        return new ServicioAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicioAdapterViewHolder holder, int position) {
        Servicio servicio = listaServicios.get(position);
        holder.nombreServicio.setText(servicio.getNombreServicio());
        holder.descripcion.setText(servicio.getDescripcion());
        holder.tipoServicio.setText(servicio.getTipoServicio());
    }

    public void agregarServicio(Servicio servicio){
        listaServicios.add(servicio);
        notifyDataSetChanged();
    }
    public void agregarListaServicios(List<Servicio> listaServicios){
        this.listaServicios = listaServicios;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return listaServicios.size();
    }

    public class ServicioAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imagenMascota;
        public EditText nombreServicio;
        public EditText descripcion;
        public EditText tipoServicio;
        public RecyclerView rvMascotas;

        public ImageView ivBorrarMascota;
        public Button btnGuardarServicio;

        public ServicioAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreServicio = itemView.findViewById(R.id.etNombreServicio_adapter);
            descripcion = itemView.findViewById(R.id.etDescripcionServicio_adapter);
            tipoServicio = itemView.findViewById(R.id.etTipoServicio_adapter);
            btnGuardarServicio = itemView.findViewById(R.id.btnAguardarServicio);
            rvMascotas = itemView.findViewById(R.id.rvNombreMascotas);



            btnGuardarServicio.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnAguardarServicio:
                    actionClick.myClick(Constantes.ACCION_ASIGNAR_SERVICIO, listaServicios.get(getLayoutPosition()),getLayoutPosition());
                    break;
            }
        }

    }
}
