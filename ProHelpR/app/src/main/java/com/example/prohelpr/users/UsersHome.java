package com.example.prohelpr.users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.prohelpr.R;
import com.example.prohelpr.workers.WorkerBookingFragment;
import com.example.prohelpr.workers.WorkerCategoryFragment;
import com.example.prohelpr.workers.WorkerHomeFragment;
import com.example.prohelpr.workers.WorkerProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UsersHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new UserHomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.u_home:
                    fragment = new UserHomeFragment();
                    loadFragment(fragment);
                    // toolbar.setTitle("Shop");
                    return true;
                case R.id.u_booking:
                    fragment = new UserBookingsFragment();
                    loadFragment(fragment);
                    // toolbar.setTitle("My Gifts");
                    return true;
                case R.id.u_profile:
                    fragment = new UserProfileFragment();
                    loadFragment(fragment);
                    // toolbar.setTitle("Profile");
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}