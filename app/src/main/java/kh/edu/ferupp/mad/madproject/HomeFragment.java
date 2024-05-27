package kh.edu.ferupp.mad.madproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import kh.edu.ferupp.mad.madproject.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

//    private FragmentHomeBinding binding;
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }
//    @Override
//    public void onDestroxyView() {
//        super.onDestroyView();
//        binding = null;
//    }



}