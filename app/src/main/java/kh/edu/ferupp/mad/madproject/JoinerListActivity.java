package kh.edu.ferupp.mad.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import kh.edu.ferupp.mad.madproject.adapters.JoinersAdapter;
import kh.edu.ferupp.mad.madproject.models.Joiners;
import kh.edu.ferupp.mad.madproject.services.ApiJoiners;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JoinerListActivity extends AppCompatActivity {

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joiner_list);

        btnBack = findViewById(R.id.backButton); // back to home fragment

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinerListActivity.this, TimelineActivity.class);
                startActivity(intent);
            }
        });

        showJoiners();
    }

    private void showJoiners() {
        Retrofit retrofitClient = new Retrofit.Builder()
                .baseUrl("https://65fada3f3909a9a65b1bb6ce.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiJoiners service = retrofitClient.create(ApiJoiners.class);
        Call<List<Joiners>> task = service.loadJoiners();
        task.enqueue(new Callback<List<Joiners>>() {
            @Override
            public void onResponse(Call<List<Joiners>> call, Response<List<Joiners>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    bindJoiners(response.body());
                } else {
                    Toast.makeText(JoinerListActivity.this, "Failed to load joiners", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Joiners>> call, Throwable t) {
                Toast.makeText(JoinerListActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindJoiners(List<Joiners> joiners) {
        GridLayoutManager manager = new GridLayoutManager(JoinerListActivity.this, 1);
        RecyclerView recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(manager);
        JoinersAdapter adapter = new JoinersAdapter();
        adapter.submitList(joiners);
        recyclerView.setAdapter(adapter);
    }
}
