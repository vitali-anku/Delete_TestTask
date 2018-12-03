package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import app.apptesttask.mvp.models.heroes.Character;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface FavoritesListTabFragmentView extends MvpView {
    void showProgress();
    void hideProgress();
    void showFavoritesList(List<Character> heroes);
    @StateStrategyType(SkipStrategy.class)
    void showMessage(Throwable throwable);
    @StateStrategyType(SkipStrategy.class)
    void clearList();
}
