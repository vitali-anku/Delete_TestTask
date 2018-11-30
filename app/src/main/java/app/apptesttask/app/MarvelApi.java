package app.apptesttask.app;

import java.util.Observable;

import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MarvelApi {

    @GET("/v1/public/characters")
    @Headers("Content-Type: application/json")
    Observable<CharacterDataWrapper> getHeroesList(@Query("ts") int fs, @Query("keyapi") String publicKey, @Query("hash") String hash);

}
