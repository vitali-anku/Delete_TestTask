package app.apptesttask.di.modules;

import javax.inject.Singleton;

import app.apptesttask.app.MarvelApi;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.models.heroes.Image;
import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    @Singleton
    public Character provideCharacter(MarvelApi marvelApi){
        return new Character();
    }

    public Image provideImage(MarvelApi marvelApi){
        return new Image();
    }
}
