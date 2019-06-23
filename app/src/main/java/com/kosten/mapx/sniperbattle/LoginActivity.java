package com.kosten.mapx.sniperbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mNameEditTxt;
    private EditText mPassEditTxt;

    private Button mLogInButton;
    private Button mNewUserButton;
    private CheckBox mLoginCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNameEditTxt = (EditText) findViewById(R.id.edittext_name);
        mPassEditTxt = (EditText) findViewById(R.id.edittext_password);
        mLogInButton = (Button) findViewById(R.id.button_login);
        mNewUserButton = (Button) findViewById(R.id.button_new_user);
        mLoginCheckBox = (CheckBox) findViewById(R.id.checkbox_remember);

        // button listener
        mLogInButton.setOnClickListener(this);
        mNewUserButton.setOnClickListener(this);
    }

    /***********************************************************************************************
     * onClick listner for cancel and save buttons
     * ********************************************************************************************/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                Toast.makeText(this, "Login !", Toast.LENGTH_SHORT).show();
                login();
                break;
            case R.id.button_new_user:
                Toast.makeText(this, "Register !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


    void login() {
        String email = mNameEditTxt.getText().toString();
        String password = mPassEditTxt.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.length()<6){
            Toast.makeText(getApplicationContext(),"Password must be at least 6 characters",Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(
                email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // start Main Activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
