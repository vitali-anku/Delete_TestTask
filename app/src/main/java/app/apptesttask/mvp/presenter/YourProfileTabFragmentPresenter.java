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

        getViewState().showUserData("https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/11/naturo-monkey-selfie.jpg?w968h681",
                "Vitali",
                "Ankudovich",
                "21 year, student BelSTU");
    }



}
