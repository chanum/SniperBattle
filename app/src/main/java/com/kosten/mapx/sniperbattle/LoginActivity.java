package com.kosten.mapx.sniperbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mNameEditTxt;
    private EditText mPassEditTxt;

    private Button mLogInButton;
    private Button mRegisterButton;
    private CheckBox mLoginCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNameEditTxt = (EditText) findViewById(R.id.edittext_name);
        mPassEditTxt = (EditText) findViewById(R.id.edittext_password);
        mLogInButton = (Button) findViewById(R.id.button_login);
        mRegisterButton = (Button) findViewById(R.id.button_register);
        mLoginCheckBox = (CheckBox) findViewById(R.id.checkbox_remember);

        // button login listener
        mLogInButton.setOnClickListener(this);
    }

    /***********************************************************************************************
     * onClick listner for cancel and save buttons
     * ********************************************************************************************/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                Toast.makeText(this, "Login !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_register:
                Toast.makeText(this, "Register !", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
