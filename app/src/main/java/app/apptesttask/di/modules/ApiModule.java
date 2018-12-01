package app.apptesttask.di.modules;

import javax.inject.Singleton;

import app.apptesttask.app.MarvelApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public MarvelApi provideMarvelApi(Retrofit retrofit){
        return retrofit.create(MarvelApi.class);
    }
}
