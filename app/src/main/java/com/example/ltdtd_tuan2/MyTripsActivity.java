    package com.example.ltdtd_tuan2;

    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;

    public class MyTripsActivity extends AppCompatActivity {
        TextView tvHistory;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my_trips);

            tvHistory = findViewById(R.id.tvHistory);

            SharedPreferences prefs = getSharedPreferences("myTrips", MODE_PRIVATE);
            String lastTrip = prefs.getString("lastTrip", "Chưa có vé nào");

            tvHistory.setText("Lịch sử đặt vé:\n" + lastTrip);
        }
    }
