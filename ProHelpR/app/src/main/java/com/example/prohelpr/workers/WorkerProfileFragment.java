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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prohelpr.R;
import com.example.prohelpr.auth.MainActivity;
import com.example.prohelpr.models.Worker;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;


public class WorkerProfileFragment extends Fragment {
    String phoneNumber,roledata;
    TextView role,mobileNumber,savingstatus;

    TextInputEditText workerrole,workername,workernumber,workeraddress,workerplace,workermail,workerpostalcode,workeramount;
    MaterialButton saveworker;
    Spinner workercategory,workerstatus;

    List<Worker> workers;
    FirebaseDatabase database;
    DatabaseReference myRef;

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

        /*Getting ID*/
        workerrole = v.findViewById(R.id.role_name);
        workername=v.findViewById(R.id.worker_name);
        workernumber=v.findViewById(R.id.worker_number);
        workermail=v.findViewById(R.id.worker_mail);
        workeraddress=v.findViewById(R.id.worker_address);
        workerplace=v.findViewById(R.id.worker_place);
        workercategory=v.findViewById(R.id.worker_category);
        workerstatus =v.findViewById(R.id.worker_status);
        workerpostalcode=v.findViewById(R.id.worker_postalcode);
        workeramount=v.findViewById(R.id.worker_amount);

        saveworker=v.findViewById(R.id.save_worker);
        savingstatus = v.findViewById(R.id.savingstatus);

        workernumber.setText(phoneNumber);
        workerrole.setText(roledata);

        workers = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Worker");

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

                String w_role = workerrole.getText().toString();
                String w_name = workername.getText().toString();
                String w_number =workernumber.getText().toString();
                String w_mail =workermail.getText().toString();
                String w_address =workeraddress.getText().toString();
                String w_place= workerplace.getText().toString();
                String w_pcode=workerpostalcode.getText().toString();
                String w_category=workercategory.getSelectedItem().toString();
                String w_staus=workerstatus.getSelectedItem().toString();
                String w_amount=workeramount.getText().toString();

                Toast.makeText(getContext(), ""+w_role+w_name+w_number+w_mail+w_address+w_place+w_pcode+w_category+w_staus, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}