package com.rinndp.petsrecycler;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PetsRVAdapter extends RecyclerView.Adapter<PetsRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<PetsModel> pets;

    public PetsRVAdapter (Context context, ArrayList<PetsModel> pets) {
        this.context = context;
        this.pets = pets;
    }

    @NonNull
    @Override
    public PetsRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent, false);

        return new PetsRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetsRVAdapter.MyViewHolder holder, int position) {
        String namePet = pets.get(position).getPetName();
        String breedPet = pets.get(position).getPetBreed();
        String descriptionPet = pets.get(position).getPetDescription();


        holder.tvName.setText(namePet);
        holder.tvBreed.setText(breedPet);
        holder.tvDescription.setText(descriptionPet);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                        .setIcon(R.drawable.baseline_pets_24)
                        .setTitle("Hola, soy "+namePet)
                        .setMessage("Soy un '"+breedPet+"' ¿Quieres adoptarme?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                materialAlertDialogBuilder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvBreed, tvDescription;

        public MyViewHolder (@NotNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.petsName);
            tvBreed = itemView.findViewById(R.id.petsBreed);
            tvDescription = itemView.findViewById(R.id.petsDescription);
        }
    }
}
