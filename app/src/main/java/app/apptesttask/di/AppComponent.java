package app.apptesttask.di;

import android.content.Context;

import javax.inject.Singleton;

import app.apptesttask.di.modules.ContextModule;
import app.apptesttask.di.modules.HeroesModule;
import app.apptesttask.di.modules.ModelModule;
import app.apptesttask.mvp.presenter.FavoritesListTabFragmentPresenter;
import app.apptesttask.mvp.presenter.HeroesListAdapterPresenter;
import app.apptesttask.mvp.presenter.HeroesListTabFragmentPresenter;
import app.apptesttask.mvp.presenter.MainActivityPresenter;
import app.apptesttask.mvp.presenter.YourProfileTabFragmentPresenter;
import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, HeroesModule.class, ModelModule.class})
public interface AppComponent {
    Context getContext();

    void inject(MainActivityPresenter mainActivityPresenter);

    void inject(HeroesListTabFragmentPresenter heroesListTabFragmentPresenter);

    void inject(YourProfileTabFragmentPresenter yourProfileTabFragmentPresenter);

    void inject(FavoritesListTabFragmentPresenter favoritesListTabFragmentPresenter);

    void inject(HeroesListAdapterPresenter heroesListAdapterPresenter);
}
