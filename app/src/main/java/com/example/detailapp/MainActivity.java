package com.example.detailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import adapter.AdapterProfile;
import model.ProfileDetails;

public class MainActivity extends AppCompatActivity {

    private EditText name,age ;
    private RadioButton rmale,rfemale,rother;
    private Spinner spinner;
    private Button save;
    private RecyclerView recyclerView;
    String gender;
    int img;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        save=findViewById(R.id.save);
        recyclerView=findViewById(R.id.recyclerView);
        rmale=findViewById(R.id.rMale);
        rfemale=findViewById(R.id.rFemale);
        rother=findViewById(R.id.rOthers);
        group=findViewById(R.id.group);
        spinner=findViewById(R.id.spinner);


        final List<ProfileDetails> profileDetails= new ArrayList<>();
        final int[] title = {
                (R.drawable.dayahang),
                (R.drawable.lily),
                (R.drawable.red),


        };
        final String[] titlenaME = {
                "Dayahang",
                "Lily",
                "red",


        };
        final ArrayAdapter<String> img= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, titlenaME);
        spinner.setAdapter(img);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select=group.getCheckedRadioButtonId();
                RadioButton radioButton= findViewById(select);
               String genders=radioButton.getText().toString();
                String names=name.getText().toString();
                String ages=(age.getText().toString());
                int position = (spinner.getSelectedItemPosition());
                int imageposition=title[position];
                profileDetails.add(new ProfileDetails(names,gender,imageposition,ages));
                AdapterProfile adapterProfile= new AdapterProfile(MainActivity.this,profileDetails);
                recyclerView.setAdapter(adapterProfile);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));




            }
        });



    }
}
