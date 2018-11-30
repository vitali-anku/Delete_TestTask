package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import app.apptesttask.mvp.view.MainActivityView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {
    public MainActivityPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

//    public void onRepositorySelection(int position, Character character) {
//        getViewState().showDetailsContainer();
//
//        getViewState().setSelection(position);
//
//        getViewState().showDetails(position, character);
//    }
}
