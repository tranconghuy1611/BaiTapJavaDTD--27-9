package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    Button btnBank, btnCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnBank = findViewById(R.id.btnBank);
        btnCash = findViewById(R.id.btnCash);

        // Chọn thanh toán qua ngân hàng
        btnBank.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentActivity.this, BankLoginActivity.class);
            startActivity(intent);
        });

        // Chọn tiền mặt => thành công luôn
        btnCash.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentActivity.this, SuccessActivity.class);
            intent.putExtra("method", "Tiền mặt 💵");
            startActivity(intent);
        });
    }
}
