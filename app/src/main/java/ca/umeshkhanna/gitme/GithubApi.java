package ca.umeshkhanna.gitme;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by umeshkhanna on 15-10-11.
 */
public class GithubApi {
    interface GitHubService{
        @GET("/users/{user}")
        void getUser(@Path("user") String username, Callback<User> callback);
    }

    private static GitHubService gitHubService = null;

    private GithubApi(){

    }


    private static final String BASE_URL = "https://api.github.com";
    private static final String ACCEPT_HEADER_NAME = "Accept";
    private static final String ACCEPT_HEADER_VALUE = "application/vnd.github.v3+json";

    public static GitHubService getInstance() {
        if (gitHubService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setClient(new OkClient(new OkHttpClient()))
                    .setRequestInterceptor(request -> {
                        request.addHeader(ACCEPT_HEADER_NAME, ACCEPT_HEADER_VALUE);
                    })
                    .setEndpoint(BASE_URL)
                    .build();

            gitHubService = restAdapter.create(GitHubService.class);
        }
        return gitHubService;
    }

}
