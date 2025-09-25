package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNewUser, edtNewPass;
    Button btnSubmitRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNewUser = findViewById(R.id.edtNewUser);
        edtNewPass = findViewById(R.id.edtNewPass);
        btnSubmitRegister = findViewById(R.id.btnSubmitRegister);

        btnSubmitRegister.setOnClickListener(v -> {
            String newUser = edtNewUser.getText().toString().trim();
            String newPass = edtNewPass.getText().toString();

            if (newUser.isEmpty() || newPass.isEmpty()) {
                Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences prefs = getSharedPreferences("accounts", MODE_PRIVATE);
            if (prefs.contains(newUser)) {
                Toast.makeText(this, "Tên đăng nhập đã tồn tại", Toast.LENGTH_SHORT).show();
                return;
            }

            prefs.edit().putString(newUser, newPass).apply();
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            finish(); // quay lại trang đăng nhập
        });

        Button btnBack = findViewById(R.id.btnBackToLogin);

        btnBack.setOnClickListener(v -> {
            // Quay lại MainActivity
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // đóng RegisterActivity để không quay lại bằng nút Back
        });

    }

}
