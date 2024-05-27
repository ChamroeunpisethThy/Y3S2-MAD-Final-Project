package kh.edu.ferupp.mad.madproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kh.edu.ferupp.mad.madproject.databinding.ActivityMainBinding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.menuHome) {
                showFragment(new HomeFragment());
                return true;
            } else if (menuItem.getItemId() == R.id.menuMeeting) {
                showFragment(new MeetingFragment());
                return true;
            } else if (menuItem.getItemId() == R.id.menuCalender) {
                showFragment(new CalendarFragment());
                return true;
            } else if (menuItem.getItemId() == R.id.profile) {
                showFragment(new HomeFragment());
                return true;
            }
            return true;
        });
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}

