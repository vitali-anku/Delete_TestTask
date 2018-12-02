package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface YourProfileTabFragmentView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showUserData(String urlImage, String firstName, String lastName, String aboutMe);
}
