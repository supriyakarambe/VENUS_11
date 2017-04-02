package com.example.rahul.question_answer_forum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginPage extends AppCompatActivity {
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.btn_register) Button btnRegister;
    @BindView(R.id.btn_forgot) Button btnForgot;
    @BindView(R.id.edit_pass) EditText editPass;
    @BindView(R.id.edit_user) EditText editUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: add login validation using firebase from registration
                String username = editUser.getText().toString();
                Toast.makeText(LoginPage.this, "Needs user validation", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginPage.this, PortfolioPage.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });


        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
    }

    public void gotoRegistration(View view) {
        Intent intent = new Intent(LoginPage.this, Registration.class);
        startActivity(intent);
    }
}
