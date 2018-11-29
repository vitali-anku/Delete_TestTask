package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.YourProfileTabFragmentView;

@InjectViewState
public class YourProfileTabFragmentPresenter extends BasePresenter<YourProfileTabFragmentView> {

    public YourProfileTabFragmentPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

    }
}
