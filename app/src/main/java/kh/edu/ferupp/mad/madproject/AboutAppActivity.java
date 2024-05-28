//package kh.edu.ferupp.mad.madproject;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class AboutAppActivity extends AppCompatActivity {
//
//    TextView textView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_aboutapp);
//
//        textView = findViewById(R.id.aboutApp);
//
//
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Intent to open register activity
//                Intent intent = new Intent(getApplicationContext(), AboutAppActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }
//}