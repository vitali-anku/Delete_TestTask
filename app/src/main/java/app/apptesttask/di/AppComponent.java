package app.apptesttask.di;

import android.content.Context;

import javax.inject.Singleton;

import app.apptesttask.app.MarvelService;
import app.apptesttask.di.modules.ContextModule;
import app.apptesttask.di.modules.MarvelModule;
import app.apptesttask.di.modules.ModelModule;
import app.apptesttask.mvp.presenter.FavoritesListTabFragmentPresenter;
import app.apptesttask.mvp.presenter.HeroesListAdapterPresenter;
import app.apptesttask.mvp.presenter.HeroesListTabFragmentPresenter;
import app.apptesttask.mvp.presenter.MainActivityPresenter;
import app.apptesttask.mvp.presenter.YourProfileTabFragmentPresenter;
import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, MarvelModule.class, ModelModule.class})
public interface AppComponent {
    Context getContext();

    void inject(HeroesListAdapterPresenter heroesListAdapterPresenter);

    void inject(HeroesListTabFragmentPresenter heroesListTabFragmentPresenter);

    void inject(YourProfileTabFragmentPresenter yourProfileTabFragmentPresenter);

    void inject(MainActivityPresenter mainActivityPresenter);

    void inject(FavoritesListTabFragmentPresenter favoritesListTabFragmentPresenter);
}
