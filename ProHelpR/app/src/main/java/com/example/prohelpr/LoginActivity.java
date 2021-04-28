package com.example.prohelpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.prohelpr.users.UsersHome;
import com.example.prohelpr.workers.WorkerHome;

public class LoginActivity extends AppCompatActivity {

    RadioButton r_worker, r_user;
    LinearLayout l_worker, l_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        r_worker = findViewById(R.id.worker);
        r_user = findViewById(R.id.user);

        l_worker = findViewById(R.id.workerview);
        l_user = findViewById(R.id.userview);

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

    public void workerLogin(View view) {
        Intent i = new Intent(this, WorkerHome.class);
        startActivity(i);
    }

    public void userLogin(View view) {
        Intent i = new Intent(this, UsersHome.class);
        startActivity(i);
    }

    public void register(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void forgot(View view) {
        Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show();
    }
}