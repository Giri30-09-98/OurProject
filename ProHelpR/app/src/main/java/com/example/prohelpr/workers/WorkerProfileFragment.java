package com.example.prohelpr.workers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.prohelpr.R;
import com.example.prohelpr.auth.MainActivity;
import com.example.prohelpr.workersProfiles.WorkersDatabase;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;


public class WorkerProfileFragment extends Fragment {
    String phoneNumber,roledata;
    FirebaseDatabase database;
    DatabaseReference reference;
    WorkersDatabase workersDatabase;
    List<WorkersDatabase> list;
    TextView role,mobileNumber,workername,workeraddress,workerplace,workercategory,saveworker,workermobilenumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_worker_profile, container, false);
        // get saved phone number
        SharedPreferences prefs =  getActivity().getSharedPreferences("USER_PREF",
                Context.MODE_PRIVATE);
        phoneNumber = prefs.getString("phoneNumber", NULL);
        roledata = prefs.getString("role",NULL);
        mobileNumber = v.findViewById(R.id.mobileNumber);
        role = v.findViewById(R.id.roledefine);
        role.setText("Your Role Is : "+roledata);

        mobileNumber.setText(phoneNumber);
        workername=v.findViewById(R.id.worker_name);
        workeraddress=v.findViewById(R.id.worker_address);
        workerplace=v.findViewById(R.id.worker_place);
        workercategory=v.findViewById(R.id.worker_category);
        list=new ArrayList<>();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("WorkersDatabase");

        saveworker=v.findViewById(R.id.save_worker);
        workermobilenumber=v.findViewById(R.id.worker_mobilenumber);

        v.findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        v.findViewById(R.id.save_worker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=workername.getText().toString();
                String roles=role.getText().toString();
                String contact=mobileNumber.getText().toString();
                String address=workeraddress.getText().toString();
                String category=workercategory.getText().toString();
                String place=workerplace.getText().toString();

                WorkersDatabase workersDatabase=new WorkersDatabase(name,roles,contact,address,category,place);
                list.add(workersDatabase);
                reference.push().setValue(list).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getActivity(), "Worker Data Update Sucessfully", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        return v;
    }
}