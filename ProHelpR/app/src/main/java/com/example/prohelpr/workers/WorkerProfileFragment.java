package com.example.prohelpr.workers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prohelpr.R;
import com.example.prohelpr.auth.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;


public class WorkerProfileFragment extends Fragment {
    String phoneNumber,roledata;
    TextView role,mobileNumber,workername,workeraddress,workerplace,workercategory,potsalcode,saveworker,workermobilenumber;

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
        role.setText("Ypur Role Is : "+roledata);

        mobileNumber.setText(phoneNumber);
        workername=v.findViewById(R.id.worker_name);
        workeraddress=v.findViewById(R.id.worker_address);
        workerplace=v.findViewById(R.id.worker_place);
        workercategory=v.findViewById(R.id.worker_category);
        potsalcode=v.findViewById(R.id.worker_postalcode);
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
                Toast.makeText(getActivity(), "Worker Data Update Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}