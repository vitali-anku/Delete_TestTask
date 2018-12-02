package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.apptesttask.app.MarvelService;
import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.models.LocalData;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.view.FavoritesListTabFragmentView;
import app.apptesttask.util.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class FavoritesListTabFragmentPresenter extends BasePresenter<FavoritesListTabFragmentView> {

    @Inject
    MarvelService marvelService;

    public FavoritesListTabFragmentPresenter() {
        MyApplication.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadFavoritesList();
    }

    private void loadFavoritesList(){
        unsubscribeOnDestroy(marvelService.getHeroesList(String.valueOf(Constants.TS), Constants.PUBLIC_KEY, Constants.HASH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getViewState().showProgress())
                .subscribe(characterDataWrapper -> {
                            List<Character> characters = new ArrayList<>(characterDataWrapper.getData().getResults());
                            loadList(characters);
                            hideProgress();
                        },
                        error -> {
                            getViewState().showMessage(error);
                            hideProgress();
                        })
        );
    }

    private void loadList(List<Character> characters){
        getViewState().showFavoritesList(checkList(characters));
    }

    private List<Character> checkList(List<Character> characters){
        List<Character> charactersList = new ArrayList<>();
        for (Character character: characters) {
            if(LocalData.mLikesId.contains(character.getId())){
                charactersList.add(character);
            }
        }
        return charactersList;
    }

    private void hideProgress(){
        getViewState().hideProgress();
    }

    public void refreshCalled(){
        loadFavoritesList();
    }
}
