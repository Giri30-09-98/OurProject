package com.example.prohelpr.workers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.prohelpr.R;

public class workers_booking_retrieval extends AppCompatActivity {
Button Save,Cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers_booking_retrieval);
        Save=findViewById(R.id.savebook);
        Cancel=findViewById(R.id.cancel);


    }
}