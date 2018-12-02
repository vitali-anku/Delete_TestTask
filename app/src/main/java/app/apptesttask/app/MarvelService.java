package app.apptesttask.app;

import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import io.reactivex.Observable;

public class MarvelService {

    private MarvelApi marvelApi;

    public MarvelService(MarvelApi mApi) {
        marvelApi = mApi;
    }

    public Observable<CharacterDataWrapper> getHeroesList(String ts, String publicKey, String hash){
        return marvelApi.getHeroesList(ts, publicKey, hash);
    }
}
