package kh.edu.ferupp.mad.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TimelineActivity extends AppCompatActivity {

    ImageView btnBack;
    Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline); // Route activity time line java to xml

        btnBack = findViewById(R.id.backButton); // back to home fragment
        btnJoin = findViewById(R.id.joinMeeting); // join meeting fragment

        // Create button back to main activity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimelineActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Create button joiner list to joiner list activity
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start JoinerListActivity
                Intent intent = new Intent(TimelineActivity.this, JoinerListActivity.class);
                startActivity(intent);
            }
        });
    }
}