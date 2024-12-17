package com.rinndp.countriescycler;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rinndp.petsrecycler.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewPets = findViewById(R.id.recyclerViewCountries);
        setCountries();
        CountryRVAdapter adapter = new CountryRVAdapter(this, countries);
        recyclerViewPets.setAdapter(adapter);
        recyclerViewPets.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setCountries () {
        String [] countryNames = getResources().getStringArray(R.array.country_names);
        String [] countryFlags = getResources().getStringArray(R.array.url_country_flag);
        String [] countryDescrptions = getResources().getStringArray(R.array.country_description);
        String [] countryCapitals = getResources().getStringArray(R.array.country_capitals);

        for (int i = 0; i < countryNames.length; i++) {
            countries.add(new CountryModel(
                    countryNames[i],
                    countryDescrptions[i],
                    countryFlags[i],
                    countryCapitals[i]
            ));
        }
    }
}