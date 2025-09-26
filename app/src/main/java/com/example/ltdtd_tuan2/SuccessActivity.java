package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    TextView tvSuccess;
    Button btnGoMyTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        tvSuccess = findViewById(R.id.tvSuccess);
        btnGoMyTrips = findViewById(R.id.btnGoMyTrips);

        String method = getIntent().getStringExtra("method");
        tvSuccess.setText("Bạn đã thanh toán thành công qua: " + method);

        btnGoMyTrips.setOnClickListener(v -> {
            Intent intent = new Intent(SuccessActivity.this, MyTripsActivity.class);
            startActivity(intent);
        });
    }
}
