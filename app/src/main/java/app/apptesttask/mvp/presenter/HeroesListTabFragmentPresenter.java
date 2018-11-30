package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.apptesttask.app.MarvelApi;
import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.models.heroes.CharacterDataWrapper;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;
import app.apptesttask.util.Constants;
import retrofit2.Call;
import rx.Subscription;

@InjectViewState
public class HeroesListTabFragmentPresenter extends BasePresenter<HeroesListTabFragmentView> {

    @Inject
    MarvelApi marvelApi;

    private boolean mIsInLoading;

    public HeroesListTabFragmentPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    public void loadData(int page, boolean isPageLoading, boolean isRefreshing){
        if(mIsInLoading)
            return;

        getViewState().onStartLoading();

        showProgress(isPageLoading, isRefreshing);

        final Call<CharacterDataWrapper> mCall = marvelApi.getHeroesList(Constants.TS, Constants.PUBLIC_KEY, Constants.HASH);

        Subscription subscription = mCall
                .c


    }

    private void showProgress(boolean isPageLoading, boolean isRefreshing){
        if(isPageLoading)
            return;
        if (isRefreshing)
            getViewState().showRefreshing();
        else
            getViewState().showListProgress();
    }

    private void hideProgress(boolean isPageLoading, boolean isRefreshing){
        if(isPageLoading)
            return;
        if(isRefreshing)
            getViewState().hideProgress();
        else getViewState().hideListProgress();
    }

    private void onLoadingFailed(Throwable error){
        getViewState().showError(error.toString());
    }

    public void onErrorCancel(){
        getViewState().hideError();
    }
}
