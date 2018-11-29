package app.apptesttask.app;

import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import retrofit2.Call;

public class MarvelService {

    private MarvelApi mMarvelApi;

    public MarvelService(MarvelApi mMarvelApi) {
        this.mMarvelApi = mMarvelApi;
    }

    public Call<CharacterDataWrapper> getHeroesList(int ts, String publicKey, String hash){
        return mMarvelApi.getHeroes(ts, publicKey, hash);
    }

//    public Observable<User> signIn(String token){
//        return mMarvelApi.signIn(token);
//    }
}
