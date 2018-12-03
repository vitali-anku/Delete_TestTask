package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import app.apptesttask.mvp.models.heroes.Character;

public interface HeroesView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showRepository(Character heroes);
    @StateStrategyType(AddToEndStrategy.class)
    void updateLike(boolean isInProgress, boolean isLiked);
}
