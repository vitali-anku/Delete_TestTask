package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainActivityView extends MvpView {
//    void showDetailsContainer();
//
//    void setSelection(int position);
//
//    @StateStrategyType(OneExecutionStateStrategy.class)
//    void showDetails(int position, Character repository);
}
