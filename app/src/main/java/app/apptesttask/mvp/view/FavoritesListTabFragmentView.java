package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

public interface FavoritesListTabFragmentView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void hideProgress();
    @StateStrategyType(AddToEndStrategy.class)
    void showFavoritesList(List<?> heroes, boolean clear);
    @StateStrategyType(SkipStrategy.class)
    void showMessage(int messResId);
    @StateStrategyType(SkipStrategy.class)
    void clearList();

}