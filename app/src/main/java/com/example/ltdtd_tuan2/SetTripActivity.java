package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SetTripActivity extends AppCompatActivity {

    Button btnPlane, btnBus, btnTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_trip);

        btnPlane = findViewById(R.id.btnPlane);
        btnBus = findViewById(R.id.btnBus);
        btnTrain = findViewById(R.id.btnTrain);

        btnPlane.setOnClickListener(v -> openTripList("Máy bay ✈️"));
        btnBus.setOnClickListener(v -> openTripList("Xe khách 🚌"));
        btnTrain.setOnClickListener(v -> openTripList("Tàu 🚆"));
    }

    private void openTripList(String type) {
        Intent intent = new Intent(SetTripActivity.this, TripListActivity.class);
        intent.putExtra("tripType", type);
        startActivity(intent);
    }
}
