package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.apptesttask.mvp.models.heroes.Character;
@StateStrategyType(AddToEndSingleStrategy.class)
public interface HeroesListTabFragmentView extends MvpView {
    void showProgress();
    void hideProgress();
    void showHeroesList(List<Character> character);
    @StateStrategyType(SkipStrategy.class)
    void clearList();
    @StateStrategyType(SkipStrategy.class)
    void showError(String msg);
}
