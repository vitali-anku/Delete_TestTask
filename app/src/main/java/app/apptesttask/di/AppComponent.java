package app.apptesttask.di;

import javax.inject.Singleton;

import app.apptesttask.di.modules.ContextModule;
import app.apptesttask.di.modules.MarvelModule;
import app.apptesttask.di.modules.ModelModule;
import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, MarvelModule.class, ModelModule.class})
public interface AppComponent {

//    void inject(HeroesListAdapterPresenter heroesListAdapterPresenter);
//
//    void inject(HeroesListTabFragmentPresenter heroesListTabFragmentPresenter);
//
//    void inject(YourProfileTabFragmentPresenter yourProfileTabFragmentPresenter);
//
//    void inject(MainActivityPresenter mainActivityPresenter);
//
//    void inject(FavoritesListTabFragmentPresenter favoritesListTabFragmentPresenter);
}
