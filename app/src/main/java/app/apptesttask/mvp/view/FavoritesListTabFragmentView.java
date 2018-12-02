package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.apptesttask.mvp.models.heroes.Character;

public interface FavoritesListTabFragmentView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void hideProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void showFavoritesList(List<Character> heroes);
    @StateStrategyType(SkipStrategy.class)
    void showMessage(Throwable throwable);
    @StateStrategyType(SkipStrategy.class)
    void clearList();

}
