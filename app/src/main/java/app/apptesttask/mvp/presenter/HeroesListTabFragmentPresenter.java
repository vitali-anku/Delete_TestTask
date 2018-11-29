package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;

@InjectViewState
public class HeroesListTabFragmentPresenter extends BasePresenter<HeroesListTabFragmentView> {
//    @Inject
//    etwa

    public HeroesListTabFragmentPresenter() {
        MyApplication.getAppComponent().inject(this);
    }


}
