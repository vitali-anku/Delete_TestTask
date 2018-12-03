package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

public interface HeroesListsView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void updateLikes(List<Integer> inProgress, List<Integer> likesId);
}
