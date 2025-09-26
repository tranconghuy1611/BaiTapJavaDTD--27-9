package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TripListActivity extends AppCompatActivity {

    TextView tvTripType;
    ListView listTrips;
    ArrayList<String> trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);

        tvTripType = findViewById(R.id.tvTripType);
        listTrips = findViewById(R.id.listTrips);

        // Nhận loại vé từ màn hình trước
        String tripType = getIntent().getStringExtra("tripType");
        tvTripType.setText("Loại vé: " + tripType);

        // Tạo danh sách chuyến đi mẫu
        trips = new ArrayList<>();
        if (tripType.contains("Máy bay")) {
            trips.add("Hà Nội ✈️ TP.HCM");
            trips.add("Đà Nẵng ✈️ Hà Nội");
            trips.add("Huế ✈️ Sài Gòn");
        } else if (tripType.contains("Xe khách")) {
            trips.add("Hà Nội 🚌 Hải Phòng");
            trips.add("Đà Nẵng 🚌 Huế");
            trips.add("Cần Thơ 🚌 Sài Gòn");
        } else if (tripType.contains("Tàu")) {
            trips.add("Hà Nội 🚆 Lào Cai");
            trips.add("Hải Phòng 🚆 Đà Nẵng");
            trips.add("Sài Gòn 🚆 Nha Trang");
        }

        // Adapter hiển thị danh sách
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, trips);
        listTrips.setAdapter(adapter);

        // Xử lý click chọn chuyến
        listTrips.setOnItemClickListener((parent, view, position, id) -> {
            String tripName = trips.get(position);

            Intent intent = new Intent(TripListActivity.this, TripDetailActivity.class);
            intent.putExtra("tripName", tripName);
            intent.putExtra("tripType", tripType);
            startActivity(intent);
        });
    }
}
