package com.rinndp.petsrecycler;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PetsModel> pets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewPets = findViewById(R.id.recyclerViewPets);
        setPets();

        PetsRVAdapter adapter = new PetsRVAdapter(this, pets);
        recyclerViewPets.setAdapter(adapter);
        recyclerViewPets.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setPets () {
        String [] petNames = getResources().getStringArray(R.array.pets_names);
        String [] petBreeds = getResources().getStringArray(R.array.pets_breed);
        String [] petDescrptions = getResources().getStringArray(R.array.pets_description);

        for (int i = 0; i < petNames.length; i++) {
            pets.add(new PetsModel(
                    petNames[i],
                    petBreeds[i],
                    petDescrptions[i]
            ));
        }
    }
}