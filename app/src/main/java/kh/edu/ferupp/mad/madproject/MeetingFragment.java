package kh.edu.ferupp.mad.madproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.ferupp.mad.madproject.databinding.FragmentHomeBinding;
import kh.edu.ferupp.mad.madproject.databinding.FragmentMeetingBinding;

public class MeetingFragment extends Fragment {

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        FragmentMeetingBinding binding = FragmentMeetingBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}