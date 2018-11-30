package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.HeroesListsView;

@InjectViewState
public class HeroesListAdapterPresenter extends BasePresenter<HeroesListsView> {

    public final static String TAG = "HeroesListsPresenter";

    List<Integer> mInProgress = new ArrayList<>();
    List<Integer> mLinkedIds = new ArrayList<>();

    public HeroesListAdapterPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

}
