package app.apptesttask.di.modules;

import javax.inject.Singleton;

import app.apptesttask.app.MarvelApi;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.models.heroes.CharacterDataContainer;
import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
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

    @Provides
    @Singleton
    public CharacterDataWrapper provideCharactersData(MarvelApi marvelApi){
        return new CharacterDataWrapper();
    }

    @Provides
    @Singleton
    public CharacterDataContainer provideContainer(MarvelApi marvelApi){
        return new CharacterDataContainer();
    }


    @Provides
    @Singleton
    public Image provideImage(MarvelApi marvelApi){
        return new Image();
    }
}
