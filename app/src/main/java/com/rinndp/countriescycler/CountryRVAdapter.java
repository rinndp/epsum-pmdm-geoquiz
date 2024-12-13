package com.rinndp.countriescycler;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.jetbrains.annotations.NotNull;
import com.rinndp.petsrecycler.R;
import java.util.ArrayList;

public class CountryRVAdapter extends RecyclerView.Adapter<CountryRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<CountryModel> countries;
    View view;

    public CountryRVAdapter(Context context, ArrayList<CountryModel> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.view = inflater.inflate(R.layout.cv_row, parent, false);
        return new CountryRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryRVAdapter.MyViewHolder holder, int position) {
        String nameCountry = countries.get(position).getPetName();
        String descriptionCountry = countries.get(position).getPetDescription();
        String flagCountry = countries.get(position).getCountryFlag();

        ImageView IVcountryFlag = view.findViewById(R.id.imageViewFlag);

        Glide.with(view)
                .load(flagCountry)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .centerCrop()
                .into(IVcountryFlag);

        holder.tvName.setText(nameCountry);
        holder.tvDescription.setText(descriptionCountry);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context)
                        .setIcon(R.drawable.baseline_flag_24)
                        .setTitle("¿Cuál es la capital de "+nameCountry+"?")
                        .setPositiveButton("Confirmar respuesta", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
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
        return countries.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription;

        public MyViewHolder (@NotNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.TVcountryName);
            tvDescription = itemView.findViewById(R.id.countryDescription);
        }
    }
}
