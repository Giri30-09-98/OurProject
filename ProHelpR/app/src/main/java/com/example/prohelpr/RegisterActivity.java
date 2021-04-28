package com.example.prohelpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {
    RadioButton r_worker, r_user;
    LinearLayout l_worker, l_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        r_worker = findViewById(R.id.workerregiser);
        r_user = findViewById(R.id.userregister);

        l_worker = findViewById(R.id.registerworkerview);
        l_user = findViewById(R.id.userregisteryview);

        r_worker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    l_worker.setVisibility(View.VISIBLE);
                } else {
                    l_worker.setVisibility(View.GONE);
                }
            }
        });

        r_user.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    l_user.setVisibility(View.VISIBLE);
                } else {
                    l_user.setVisibility(View.GONE);
                }
            }
        });

    }

    public void saveWorker(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void saveUser(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }
}