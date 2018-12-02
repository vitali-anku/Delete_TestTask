package app.apptesttask.di.modules;

import javax.inject.Singleton;

import app.apptesttask.app.MarvelApi;
import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    @Singleton
    public CharacterDataWrapper provideCharactersData(MarvelApi marvelApi){
        return new CharacterDataWrapper();
    }
}
