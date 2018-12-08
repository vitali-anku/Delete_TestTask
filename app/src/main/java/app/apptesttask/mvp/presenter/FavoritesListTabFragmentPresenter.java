package app.apptesttask.mvp.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.apptesttask.app.MarvelService;
import app.apptesttask.mvp.models.LocalData;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.view.FavoritesListTabFragmentView;
import app.apptesttask.util.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class FavoritesListTabFragmentPresenter extends BasePresenter<FavoritesListTabFragmentView> {

    private final MarvelService marvelService;

    @Inject
    public FavoritesListTabFragmentPresenter(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadFavoritesList();
    }

    @Override
    public void attachView(FavoritesListTabFragmentView view) {
        super.attachView(view);
        getViewState().clearList();
    }

    @Override
    public void detachView(FavoritesListTabFragmentView view) {
        super.detachView(view);
        getViewState().clearList();
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

    public void writeFile(View view){
        Context context = view.getContext();
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(context.openFileOutput(Constants.FILENAME, Context.MODE_PRIVATE)));
            // пишем данные
            bw.write(convertToJson(LocalData.mLikesId));
            // закрываем поток
            bw.close();

            Log.d("myLogsWrite", "Файл записан");
        } catch (IOException e) {
            getViewState().showMessage(e);
        }
    }

    private String convertToJson(List<Integer> likesList){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try{
            for (int i: likesList) {
                jsonArray.put(i);
            }

            jsonObject.put(Constants.LIKES_ID, jsonArray);
        } catch (JSONException e){
            getViewState().showMessage(e);
        }
        return jsonObject.toString();
    }
}
