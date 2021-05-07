package com.example.prohelpr.users;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.prohelpr.R;
import com.example.prohelpr.models.Worker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class UserHomeFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    User_home_design user_home_design;
    user_home_design_adapter adapter;
    ArrayList<Worker> list;
    Button v_btn;


    public UserHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*  recyclerView=recyclerView.findViewById(R.id.w_b_recycler);*/


        // Inflate the layout for this fragment
        View vi = inflater.inflate(R.layout.fragment_user_home, container, false);
        recyclerView = vi.findViewById(R.id.w_b_recycler);
        v_btn = vi.findViewById(R.id.save_btn);
        databaseReference = FirebaseDatabase.getInstance().getReference("WorkersDatabase");
        v_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "ding", Toast.LENGTH_SHORT).show();
                list = new ArrayList<>();

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int a=0;
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                          Worker worker = dataSnapshot.getValue(Worker.class);
                            list.add(worker);
                            Toast.makeText(getContext(), "Total"+list.size(),Toast.LENGTH_SHORT).show();
                          //  Log.i("worker",list.get(a).getName());
                        }
                        adapter = new user_home_design_adapter(getContext(), list);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(adapter);
                        // adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        return vi;
    }
}