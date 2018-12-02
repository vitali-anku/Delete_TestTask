package app.apptesttask.app;

import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MarvelApi {

    @GET("/v1/public/characters")
    @Headers("Content-Type: application/json")
    Observable<CharacterDataWrapper> getHeroesList(@Query("ts") String ts, @Query("apikey") String publicKey, @Query("hash") String hash);

}
