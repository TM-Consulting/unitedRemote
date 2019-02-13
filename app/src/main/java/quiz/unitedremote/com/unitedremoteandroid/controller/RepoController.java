package quiz.unitedremote.com.unitedremoteandroid.controller;

import quiz.unitedremote.com.unitedremoteandroid.Configuration.Config;
import quiz.unitedremote.com.unitedremoteandroid.entity.AllRepositories;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class RepoController {

    private static Retrofit retrofit;
    private static final String BASE_URL = Config.IPURL;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface RepoInfos
    {

        @GET("repositories?q=created:>2017-10-22&sort=stars&order=desc")
        Call<AllRepositories> getAllrepositories();

    }
}
