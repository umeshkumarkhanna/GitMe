package ca.umeshkhanna.gitme;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by umeshkhanna on 15-10-11.
 */
public class GithubApi {
    interface GithubService{
        @GET("/users/{user}")
        void getUser(@Path("user") String username, Callback<User> callback);
    }

    private static GithubService githubService = null;

    private GithubApi(){
        
    }

}
