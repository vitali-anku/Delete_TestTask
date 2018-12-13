package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.apptesttask.R;
import app.apptesttask.app.MarvelService;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;
import app.apptesttask.mvp.view.ListAdapterView;
import app.apptesttask.util.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class HeroesListTabFragmentPresenter extends BasePresenter<HeroesListTabFragmentView> {

    MarvelService marvelService;

    private List<Character> characterList = new ArrayList<>();

    @Inject
    public HeroesListTabFragmentPresenter(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadHeroesList();
    }

    public void onBindRepositoryRowViewAtPosition(int position, ListAdapterView view) {
        Character character = characterList.get(position);
        view.setData(character.getThumbnail().toString(), character.getName(), character.getDescription());
        view.setStar(R.drawable.ic_star_close);
    }

    public int getCount() {
        return characterList.size();
    }

    @Override
    public void detachView(HeroesListTabFragmentView view) {
        super.detachView(view);
        getViewState().clearList();
    }

    private void loadHeroesList() {
        unsubscribeOnDestroy(marvelService.getHeroesList(String.valueOf(Constants.TS), Constants.PUBLIC_KEY, Constants.HASH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> showProgress())
                .subscribe(characterDataWrapper -> {
                            characterList.addAll(characterDataWrapper.getData().getResults());
                            hideProgress();
                        },
                        error -> {
                            onLoadingFailed(error);
                            hideProgress();
                        })
        );
    }

    private void onLoading() {
        getViewState().showHeroesList(characterList);
    }

    private void hideProgress() {
        getViewState().hideProgress();
    }

    private void onLoadingFailed(Throwable error) {
        getViewState().showError(error.toString());
    }

    private void showProgress() {
        getViewState().showProgress();
    }

    public void refreshCalled() {
        loadHeroesList();
    }
}
