package kh.edu.ferupp.mad.madproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kh.edu.ferupp.mad.madproject.databinding.ActivityMainBinding;

import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final int MENU_HOME_ID = R.id.menuHome;
    private static final int MENU_MEETING_ID = R.id.menuMeeting;
    private static final int MENU_ADD_ID = R.id.menuAdd;

    private static final int MENU_CALENDAR_ID = R.id.menuCalender;
    private static final int MENU_PROFILE_ID = R.id.menuProfile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId(); // Get the item ID once to avoid multiple calls

            // Use if-else instead of switch-case
            if (itemId == MENU_HOME_ID) {
                showFragment(new HomeFragment());
                return true;
            } else if (itemId == MENU_MEETING_ID) {
                showFragment(new MeetingFragment());
                return true;
            } else if (itemId == MENU_ADD_ID) {
                showFragment(new AddFragment());
                return true;
            } else if (itemId == MENU_CALENDAR_ID) {
                showFragment(new ScheduleFragment());
                return true;
            } else if (itemId == MENU_PROFILE_ID) {
                showFragment(new ProfileFragment());
                return true;
            } else {
                return false;
            }
        });
    }


    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}
