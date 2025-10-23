package com.example.androiduitesting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    ArrayList<String> dataList;
    String cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        dataList = new ArrayList<>();
        cityName = " ";
        Bundle b = getIntent().getExtras();
        if (b!=null) {
            dataList = b.getStringArrayList("dataList");
            cityName = b.getString("cityName");
        }



        Button backButton = findViewById(R.id.go_back);
        TextView cityDisplay = findViewById(R.id.city_name_display);

        cityDisplay.setText(cityName);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(ShowActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putStringArrayList("dataList", dataList);

                mainIntent.putExtras(b);

                startActivity(mainIntent);
            }
        });



    }
}
