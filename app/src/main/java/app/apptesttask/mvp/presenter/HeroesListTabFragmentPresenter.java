package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;

@InjectViewState
public class HeroesListTabFragmentPresenter extends BasePresenter<HeroesListTabFragmentView> {

    public HeroesListTabFragmentPresenter() {
        MyApplication.getAppComponent().inject(this);
    }


}
