package com.example.prohelpr.workers;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.prohelpr.R;
import com.example.prohelpr.Worker_Home_data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WorkerBookingFragment extends Fragment {

    RecyclerView rv;
   // String[] data = {"MyBookings","MyBookings"};
WorkersBookingDataAdapter adapter;
List<booking_model> booking_modelslist;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_worker_booking, container, false);
        rv = v.findViewById(R.id.wBokking_recycler);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getInstance().getReference("booking_model");
        booking_modelslist = new ArrayList<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    booking_model booking_model = dataSnapshot.getValue(booking_model.class);
                    booking_modelslist.add(booking_model);

                }
                Toast.makeText(getContext(), "" + booking_modelslist.size(), Toast.LENGTH_SHORT).show();
                Log.i("Giri", "" + booking_modelslist.size());
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                rv.setAdapter(new WorkersBookingDataAdapter(booking_modelslist, getContext()));
            }
            @Override
            public void onCancelled (@NonNull DatabaseError error){
                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();


            }
        });

       ;
        /*rv.setAdapter(new Worker_Home_data(getContext(),data));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));*/
        return  v;
    }
}