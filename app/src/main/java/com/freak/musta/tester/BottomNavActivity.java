package com.freak.musta.tester;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.freak.musta.tester.fragments.DashboardFragment;
import com.freak.musta.tester.fragments.HomeFragment;
import com.freak.musta.tester.fragments.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BottomNavActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    fragment = HomeFragment.newInstance("", "");
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    fragment = DashboardFragment.newInstance("", "");
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    fragment = NotificationFragment.newInstance("", "");
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.commit();
                    return true;
                default:
                    fragment = new HomeFragment();
                    transaction.replace(R.id.fragment_container, fragment);
                    transaction.commit();
                    return true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
