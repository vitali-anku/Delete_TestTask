package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.models.heroes.Image;

public interface HeroesListTabFragmentView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void hideProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void showHeroesList(List<Character> heroes, List<Image> images, boolean clear);
    @StateStrategyType(SkipStrategy.class)
    void onStartLoading();
    void showMessage(int messResId);
    void showRefreshing();
    void showListProgress();
    void hideListProgress();
    void showError(String errorMsg);
    void hideError();
    @StateStrategyType(SkipStrategy.class)
    void clearList();
}
