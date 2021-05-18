package com.example.prohelpr.users;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prohelpr.R;
import com.example.prohelpr.workers.WorkerDetailsViewAdaper;
import com.example.prohelpr.workers.WorkersPojoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UserHomeFragment extends Fragment {
    RecyclerView recyclerView;
    FirebaseDatabase database;
    Spinner spinner;
    DatabaseReference databaseReference;
    WorkersPojoModel pojoModel;
    Button v_btn;
    ArrayList<WorkersPojoModel> workersPojoModelList;
    WorkerDetailsViewAdaper workerDetailsViewAdaper;


    public UserHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_user_home, container, false);
        recyclerView = vi.findViewById(R.id.w_b_recycler);
        v_btn = vi.findViewById(R.id.save_btn);
        database=FirebaseDatabase.getInstance();
        spinner=vi.findViewById(R.id.user_home_spinner);

        databaseReference = database.getInstance().getReference("WorkersDatabase");
        // DatabaseReference newChildRef = databaseReference.push();


        v_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workersPojoModelList=new ArrayList<>();
                String category=spinner.getSelectedItem().toString();
                databaseReference.child(category).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                            WorkersPojoModel model=dataSnapshot.getValue(WorkersPojoModel.class);
                            workersPojoModelList.add(model);


                        }
                        Toast.makeText(getContext(), ""+workersPojoModelList.size(), Toast.LENGTH_SHORT).show();
                        Log.i("Giri",""+workersPojoModelList.size());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(new WorkerDetailsViewAdaper(workersPojoModelList,getContext()));

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

        return vi;
    }
}
