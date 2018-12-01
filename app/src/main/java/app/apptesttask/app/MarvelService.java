package app.apptesttask.app;

import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import io.reactivex.Single;

public class MarvelService {

    private MarvelApi marvelApi;

    public MarvelService(MarvelApi mApi) {
        marvelApi = mApi;
    }

    public Single<CharacterDataWrapper> getHeroesList(int ts, String publicKey, String hash){
        return marvelApi.getHeroesList(ts, publicKey, hash);
    }
}
