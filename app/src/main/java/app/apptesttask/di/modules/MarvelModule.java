package app.apptesttask.di.modules;

import javax.inject.Singleton;

import app.apptesttask.app.MarvelApi;
import app.apptesttask.app.MarvelService;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class MarvelModule {

    @Provides
    @Singleton
    MarvelService provideMarvelService(MarvelApi marvelApi){
        return new MarvelService(marvelApi);
    }
}
