package app.apptesttask.di;

import javax.inject.Singleton;

import app.apptesttask.di.modules.ContextModule;
import app.apptesttask.di.modules.MarvelModule;
import app.apptesttask.mvp.presenter.FavoritesListTabFragmentPresenter;
import app.apptesttask.ui.fragments.FavoritesListTabFragment;
import app.apptesttask.ui.fragments.HeroesListTabFragment;
import app.apptesttask.ui.fragments.YourProfileTabFragment;
import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, MarvelModule.class})
public interface AppComponent {

    FavoritesListTabFragmentPresenter getFavoritesListTabFragmentPresenter();

    FavoritesListTabFragmentPresenter getPresenter();

    void inject(FavoritesListTabFragment favoritesListTabFragment);

    void inject(HeroesListTabFragment heroesListTabFragment);

    void inject(YourProfileTabFragment yourProfileTabFragment);
}
