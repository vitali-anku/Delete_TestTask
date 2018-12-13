package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.YourProfileTabFragmentView;

@InjectViewState
public class YourProfileTabFragmentPresenter extends BasePresenter<YourProfileTabFragmentView> {

    @Inject
    public YourProfileTabFragmentPresenter() {}

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().showUserData("https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/11/naturo-monkey-selfie.jpg?w968h681",
                "Vitali",
                "Ankudovich",
                "21 year, student BelSTU");
    }



}
