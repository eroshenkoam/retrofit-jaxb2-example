package me.eroshenkoam.examples;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

/**
 * @author Artem Eroshenko <erosenkoam@me.com>
 */
public interface GitHubClient {

    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);

}
