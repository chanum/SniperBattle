package com.kosten.mapx.sniperbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mShootButton;
    private Button mProcButton;
    private Button mGpsButton;
    private Button mJoinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShootButton = (Button) findViewById(R.id.shoot_button);
        mProcButton = (Button) findViewById(R.id.processed_button);
        mGpsButton = (Button) findViewById(R.id.gps_button);
        mJoinButton = (Button) findViewById(R.id.join_button);

        // button listener
        mShootButton.setOnClickListener(this);
        mProcButton.setOnClickListener(this);
        mGpsButton.setOnClickListener(this);
        mJoinButton.setOnClickListener(this);
    }

    /***********************************************************************************************
     * onClick listner for cancel and save buttons
     * ********************************************************************************************/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shoot_button:
                //Toast.makeText(this, "Shoot !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetectorActivity.class);
                startActivity(intent);
                break;
            case R.id.processed_button:
                Toast.makeText(this, "Processed !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gps_button:
                Toast.makeText(this, "GPS !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.join_button:
                Toast.makeText(this, "Join !", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
