//package kh.edu.ferupp.mad.madproject;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import androidx.fragment.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//public class ProfileFragment extends Fragment {
//
//    private FirebaseAuth auth;
//    private Button button;
//    private TextView textView;
//    private FirebaseUser user;
//    LinearLayout btnMyAccount;
//    LinearLayout btnAboutApp;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//
//        // Initialize Firebase Auth
//        auth = FirebaseAuth.getInstance();
//        user = auth.getCurrentUser();
//
//        // Find views by ID
//        textView = view.findViewById(R.id.welcomeMessage); // Welcome user name
//        button = view.findViewById(R.id.logoutButton); // Button logout
//
//        btnMyAccount = view.findViewById(R.id.myAccount); // Route my account activity
//        btnAboutApp = view.findViewById(R.id.aboutApp); // Route about app activity
//
//        // Check if user is null
//        if (user == null) {
//            // If user is not logged in, navigate to LoginActivity
//            Intent intent = new Intent(getActivity(), LoginActivity.class);
//            startActivity(intent);
//            getActivity().finish();
//        } else {
//            // If user is logged in, display their email
//            textView.setText(user.getEmail());
//        }
//
//        // Set up the logout button click listener
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                auth.signOut(); // Sign out the user
//                Intent intent = new Intent(getActivity(), LoginActivity.class);
//                startActivity(intent);
//                getActivity().finish();
//            }
//        });
//
//        // Route to my account activity
//        btnMyAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), MyAccountActivity.class);
//                startActivity(intent);
//            }
//
//        });
//
//        btnAboutApp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), AboutAppActivity.class);
//                startActivity(intent);
//            }
//
//        });
//
//        return view;
//    }
//
//
//
//}


package kh.edu.ferupp.mad.madproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import kh.edu.ferupp.mad.madproject.databinding.ActivityAboutappBinding;

public class ProfileFragment extends Fragment {

    private FirebaseAuth auth;
    private Button button;
    private TextView textView;
    private FirebaseUser user;
    LinearLayout btnMyAccount;
    LinearLayout btnAboutApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        // Find views by ID
        textView = view.findViewById(R.id.welcomeMessage); // Welcome user name
        button = view.findViewById(R.id.logoutButton); // Button logout
        btnMyAccount = view.findViewById(R.id.myAccount); // Route my account activity
        btnAboutApp = view.findViewById(R.id.aboutApp); // Route about app activity

        // Check if user is null
        if (user == null) {
            // If user is not logged in, navigate to LoginActivity
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        } else {
            // If user is logged in, display their email
            textView.setText(user.getEmail());
        }

        // Set up the logout button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut(); // Sign out the user
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        // Route to my account activity
        btnMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
            }
        });

        // Route to about app activity
        btnAboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutAppActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
