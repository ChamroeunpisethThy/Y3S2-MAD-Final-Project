package kh.edu.ferupp.mad.madproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.ferupp.mad.madproject.adapters.CategoriesAdapter;
import kh.edu.ferupp.mad.madproject.databinding.FragmentHomeBinding;
import kh.edu.ferupp.mad.madproject.models.Categories;
import kh.edu.ferupp.mad.madproject.services.ApiCategories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    ImageView btnNoti;
    ImageView btnSetting;
    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnNoti = view.findViewById(R.id.notificationIcon);
        btnSetting = view.findViewById(R.id.settingIcon);

        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NotificationActivity.class);
                startActivity(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
            }
        });

        showCategories();
    }

    private void showCategories() {
        Retrofit retrofitClient = new Retrofit.Builder()
                .baseUrl("https://65fada3f3909a9a65b1bb6ce.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCategories service = retrofitClient.create(ApiCategories.class);
        Call<List<Categories>> task = service.loadCategories();
        task.enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    bindCategories(response.body());
                } else {
                    Toast.makeText(getContext(), "Failed to load categories", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindCategories(List<Categories> categories) {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        binding.displayAPI.setLayoutManager(manager);
        CategoriesAdapter adapter = new CategoriesAdapter();
        adapter.submitList(categories);
        binding.displayAPI.setAdapter(adapter);
    }
}
