package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TripDetailActivity extends AppCompatActivity {
    TextView tvTripName, tvTripType;
    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        tvTripName = findViewById(R.id.tvTripName);
        tvTripType = findViewById(R.id.tvTripType);
        btnBook = findViewById(R.id.btnBook);

        String tripName = getIntent().getStringExtra("tripName");
        String tripType = getIntent().getStringExtra("tripType");

        tvTripName.setText(tripName);
        tvTripType.setText("Loại vé: " + tripType);

        btnBook.setOnClickListener(v -> {
            Intent intent = new Intent(TripDetailActivity.this, PaymentActivity.class);
            intent.putExtra("tripName", tripName);
            intent.putExtra("tripType", tripType);
            startActivity(intent);
        });
    }
}
