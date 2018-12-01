package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.apptesttask.mvp.models.heroes.Character;

public interface HeroesListTabFragmentView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void hideProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void showHeroesList(List<Character> character);
    @StateStrategyType(SkipStrategy.class)
    void clearList();
    void showError(String msg);
}
