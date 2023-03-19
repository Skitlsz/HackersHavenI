package com.example.hackershaveni;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    private TextView name1,name2;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        name1 = findViewById(R.id.name1);
        name2 =findViewById(R.id.name2);


        ImageView imageView = findViewById(R.id.img1);
        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            int res_img = bundle.getInt("img");
            imageView.setImageResource(res_img);

        }

        String username = getIntent().getStringExtra("keyname");
        String radio = getIntent().getStringExtra("radio");
        String day = getIntent().getStringExtra("day");


        name1.setText("Hello " + username + ", Your gender is " + radio);
        name2.setText(day);


    }
}