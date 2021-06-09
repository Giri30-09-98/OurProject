package com.example.prohelpr.workers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prohelpr.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class worker_booking_data extends AppCompatActivity {
    TextView w_name,w_category,charge,contact;
    static List<booking_model> booking_models;
    Button save,cancel;
    String name,category,w_charge,w_contact;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_booking_data);
        w_name=findViewById(R.id.w_name_booking_data);
        w_category=findViewById(R.id.w_category_booking_data);
        charge=findViewById(R.id.bookingcharge_data);
        contact=findViewById(R.id.booking_contact_data);

        save=findViewById(R.id.save_booking);
        cancel=findViewById(R.id.cancel_booking_data);
        Intent i=getIntent();
        name=i.getStringExtra("key_w_name");
        w_name.setText(name);
        category=i.getStringExtra("key_w_category");
        w_category.setText(category);
        w_charge=i.getStringExtra("key_w_amount");
        charge.setText(w_charge);
        w_contact=i.getStringExtra("key_w_contact");
        contact.setText(w_contact);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        booking_model booking_model=new booking_model(name,category,w_charge,w_contact);
reference.child("booking_model").push().setValue(booking_model).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(worker_booking_data.this, "worker booked successfully", Toast.LENGTH_SHORT).show();
    }
});

    }
}