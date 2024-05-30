package kh.edu.ferupp.mad.madproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import kh.edu.ferupp.mad.madproject.Services.ApiCategories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import kh.edu.ferupp.mad.madproject.Adapters.CategoriesAdapter;
import kh.edu.ferupp.mad.madproject.Models.Categories;
import kh.edu.ferupp.mad.madproject.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    private void showCategories(){
        Retrofit retrofitclient = new Retrofit.Builder().baseUrl("https://65fada3f3909a9a65b1bb6ce.mockapi.io/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiCategories service = retrofitclient.create(ApiCategories.class);
        Call<List<Categories>> task = service.loadCategories();
        task.enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                if (response.isSuccessful()){
                    bindingCategiries(response.body());
                }
                else {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable throwable) {
                Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
            }

    private void bindingCategiries(List<Categories> categories){
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        binding.view1.setLayoutManager(manager);
        CategoriesAdapter adapter = new CategoriesAdapter();
        adapter.submitList(categories);
        binding.view1.setAdapter(adapter);
    }
}