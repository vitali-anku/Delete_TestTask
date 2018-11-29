package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.FavoritesListTabFragmentView;

@InjectViewState
public class FavoritesListTabFragmentPresenter extends BasePresenter<FavoritesListTabFragmentView> {

    public FavoritesListTabFragmentPresenter() {
        MyApplication.getAppComponent().inject(this);
    }
}
