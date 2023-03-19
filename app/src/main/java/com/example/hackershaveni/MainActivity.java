package com.example.hackershaveni;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText name,etDate;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView tag,text2,bday;
    ImageView img;
    DatePickerDialog.OnDateSetListener setListener;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        button =findViewById(R.id.button);
        radioGroup = findViewById(R.id.group);
        tag = findViewById(R.id.text);
        etDate = findViewById(R.id.et_date);
        bday = findViewById(R.id.bday);
        img = findViewById(R.id.img);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        String current = DateFormat.getDateInstance().format(calendar.getTime());
        text2 = findViewById(R.id.text2);
        text2.setText(current);


        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                       int month1 = month + 1 ;
                       if (month1 == 1){
                           etDate.setText("Jan " + day +", " + year);
                       }
                        if (month1 == 2){
                            etDate.setText("Feb " + day +", " + year);
                        }
                        if (month1 == 3){
                            etDate.setText("Mar " + day +", " + year);
                        }
                        if (month1 == 4){
                            etDate.setText("Apr " + day +", " + year);
                        }
                        if (month1 == 5){
                            etDate.setText("May " + day +", " + year);
                        }
                        if (month1 == 6){
                            etDate.setText("Jun " + day +", " + year);
                        }
                        if (month1 == 7){
                            etDate.setText("Jul " + day +", " + year);
                        }
                        if (month1 == 8){
                            etDate.setText("Aug " + day +", " + year);
                        }
                        if (month1 == 9){
                            etDate.setText("Sep " + day +", " + year);
                        }
                        if (month1 == 10){
                            etDate.setText("Oct " + day +", " + year);
                        }
                        if (month1 == 11){
                            etDate.setText("Nov " + day +", " + year);
                        }
                        if (month1 == 12){
                            etDate.setText("Dec " + day +", " + year);
                        }



                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                int radioId = radioGroup.getCheckedRadioButtonId();
                 tag.setText(radioButton.getText());
                String rad = tag.getText().toString();
                date();
                String day = bday.getText().toString();
                String date = text2.getText().toString();
                String date1 = etDate.getText().toString();


                Intent intent = new Intent(MainActivity.this, Information.class);
                intent.putExtra("keyname", username);
                intent.putExtra("radio", rad );
                intent.putExtra("day", day);
                if(date1.equals(date)){
                    intent.putExtra("img", R.drawable.cake);
                }
                else {
                }


                startActivity(intent);

            }
        });

    }
    public void checker(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, radioButton.getText().toString(), Toast.LENGTH_LONG).show();
    }
   public void date(){
       String username = name.getText().toString();
       String date = text2.getText().toString();
       String date1 = etDate.getText().toString();

        if(date1.equals(date)){
            bday.setText("It's Your Birthday " + username + "!");



   }
        else {
            bday.setText("It's not your Birthday "+username +  ".");
        }

}


}