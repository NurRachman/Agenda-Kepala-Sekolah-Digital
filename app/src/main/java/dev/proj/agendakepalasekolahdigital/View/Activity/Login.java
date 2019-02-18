package dev.proj.agendakepalasekolahdigital.View.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import dev.proj.agendakepalasekolahdigital.R;

public class Login extends AppCompatActivity {
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
            Intent i = new Intent(Login.this, Main.class);
            startActivity(i);
            finish();
        });
    }
}
