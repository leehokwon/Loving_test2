package com.example.loving_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemberActivity extends AppCompatActivity {

    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MemberActivity.this , Main2Activity.class);
                startActivity(intent);
//
            }
        });
        hideSignInButton();


    }
    private void hideSignInButton() {
        Intent intent = getIntent();
        int data = intent.getIntExtra("login", 0);
        if (data == 1) {
            loginBtn.setVisibility(View.GONE);
        }
        else {
            loginBtn.setVisibility(View.VISIBLE);
        }
    }

//    public void signOut() {
//        // [START auth_sign_out]
//        FirebaseAuth.getInstance().signOut();
//        // [END auth_sign_out]
//    }
}