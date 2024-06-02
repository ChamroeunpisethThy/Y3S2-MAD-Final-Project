package kh.edu.ferupp.mad.madproject.services;

import java.util.List;

import kh.edu.ferupp.mad.madproject.models.Categories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCategories {
    @GET("categories")
    Call<List<Categories>> loadCategories();
}
