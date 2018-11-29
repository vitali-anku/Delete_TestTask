package app.apptesttask.app;

import java.util.List;

import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

public interface MarvelApi {

    @GET("/v1/public/characters")
    @Headers("Content-Type: application/json")
    Observable<CharacterDataWrapper> getHeroes(@Query("ts") int fs, @Query("keyapi") String publicKey, @Query("hash") String hash);

//    @GET("/user")
//    Single<User> signIn(@Header("Authorization") String token);

//    @GET("user")
//    Observable<User> signIn(@Header("Authorization") String token);

//    @GET(Constants.USERS)
//    Single<List<?>> getListUs(@Query("since") int lastUserId);

//    @GET(Constants.FIND_USERS)
//    Single<?> getFoundUs(@Query("q") String login, @Query("page") int page);


//    @GET(Constants.USER)
//    @Headers("Content-Type: application/json")
//    Single<?> getUserProfile(@Header("Authorization") String token);

//    @GET(Constants.NO_AUTH_USER_REPOS)
//    Single<List<?>> getNoAutUserRepositoriesList(@Path("login") String login);

//    @GET(Constants.AUTH_USER_REPOS)
//    Single<List<?>> getAutUserRepositoriesList(@Header("Authorization") String token);

//    @PATCH(Constants.USER)
//    Single<?> editUserProfile(@Header("Authorization") String token, @Body Class<?> updateInfo);
}
