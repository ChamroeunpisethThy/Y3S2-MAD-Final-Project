package kh.edu.ferupp.mad.madproject.services;

import java.util.List;

import kh.edu.ferupp.mad.madproject.models.Joiners;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiJoiners {
    @GET("joiner")
    Call<List<Joiners>> loadJoiners();
}
