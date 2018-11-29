package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface YourProfileTabFragmentView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showUserData(Class<?> clas, boolean visible);

    @StateStrategyType(AddToEndStrategy.class)
    void showLayoutProfile();

//    @StateStrategyType(AddToEndStrategy.class)

}
