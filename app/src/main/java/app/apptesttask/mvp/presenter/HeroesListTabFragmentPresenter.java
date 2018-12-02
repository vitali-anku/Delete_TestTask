package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.apptesttask.app.MarvelService;
import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;
import app.apptesttask.util.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class HeroesListTabFragmentPresenter extends BasePresenter<HeroesListTabFragmentView> {

    @Inject
    MarvelService marvelService;

    public HeroesListTabFragmentPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadHeroesList();
    }

    private void loadHeroesList() {
        unsubscribeOnDestroy(marvelService.getHeroesList(String.valueOf(Constants.TS), Constants.PUBLIC_KEY, Constants.HASH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> showProgress())
                .subscribe(characterDataWrapper -> {
                            List<Character> characters = new ArrayList<>(characterDataWrapper.getData().getResults());
                            onLoading(characters);
                            hideProgress();
                        },
                        error -> {
                            onLoadingFailed(error);
                            hideProgress();
                        })
        );
    }

    private void onLoading(List<Character> characters){
          getViewState().showHeroesList(characters);
    }

    private void hideProgress(){
        getViewState().hideProgress();
    }

    private void onLoadingFailed(Throwable error){
        getViewState().showError(error.toString());
    }

    private void showProgress(){
        getViewState().showProgress();
    }

    public void refreshCalled() {
        loadHeroesList();
    }
}
