package kh.edu.ferupp.mad.madproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MeetingFragment extends Fragment {

    Button btnjoin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meeting, container, false);

        // Initialize the button using the inflated view
        btnjoin = view.findViewById(R.id.joinMeeting);

        // Set an onClickListener on the button
        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start JoinerListActivity
                Intent intent = new Intent(getActivity(), JoinerListActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
