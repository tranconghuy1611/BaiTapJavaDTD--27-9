package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BankLoginActivity extends AppCompatActivity {

    EditText etBankName, etAccountNumber;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_login);

        etBankName = findViewById(R.id.edtBankName);
        etAccountNumber = findViewById(R.id.edtAccountNumber);
        btnPay = findViewById(R.id.btnPay);

        btnPay.setOnClickListener(v -> {
            String bank = etBankName.getText().toString().trim();
            String acc = etAccountNumber.getText().toString().trim();

            if (bank.isEmpty() || acc.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            // Giả lập thành công
            Intent intent = new Intent(BankLoginActivity.this, SuccessActivity.class);
            intent.putExtra("method", "Ngân hàng 🏦");
            startActivity(intent);
        });
    }
}
