package com.example.ltdtd_tuan2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ltdtd_tuan2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin,btnRegister;
    protected void onCreate(Bundle saveInStanceState){
        super.onCreate(saveInStanceState);
        setContentView(R.layout.activity_main);
        edtUsername = findViewById(R.id.editTen);
        edtPassword = findViewById(R.id.editMatKhau);
        btnLogin = findViewById(R.id.btnDN);
        btnRegister = findViewById(R.id.btnDK);
        btnLogin.setOnClickListener(v -> {
            String user = edtUsername.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            SharedPreferences prefs = getSharedPreferences("accounts", MODE_PRIVATE);
            String savedPass = prefs.getString(user, null);

            if (savedPass != null && savedPass.equals(pass)) {
                Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SetTripActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });


    }
}