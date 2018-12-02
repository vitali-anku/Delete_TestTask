package app.apptesttask.di.modules;

import app.apptesttask.app.MarvelApi;
import app.apptesttask.app.MarvelService;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class MarvelModule {

    @Provides
    MarvelService provideMarvelService(MarvelApi marvelApi){
        return new MarvelService(marvelApi);
    }
}
