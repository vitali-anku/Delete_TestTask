package app.apptesttask.mvp.presenter;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private final static String LIKES_ID = "likes_id";

    MarvelService marvelService;

    @Inject
    public FavoritesListTabFragmentPresenter(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @Override
    public void attachView(FavoritesListTabFragmentView view) {
        super.attachView(view);
        getViewState().clearList();
        loadFavoritesList();
    }

    @Override
    public void detachView(FavoritesListTabFragmentView view) {
        super.detachView(view);
        getViewState().clearList();
    }

//    @Override
//    protected void onFirstViewAttach() {
//        super.onFirstViewAttach();
//        loadFavoritesList();
//    }

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

    private boolean chekJsonFile(){



        return false;
    }

    private void openFile(View view){

    }

    public String writeFile(){
        return null;
    }

    private void readFile(){
    }

    public List<Integer> convertToClass(JSONObject jsonObject) {

        List<Integer> integers = new ArrayList<>();

        try {
            //String teacherFromJson = schoolClassFromJson.getString("teacher");

            JSONArray jsonArray = jsonObject.getJSONArray(LIKES_ID);

            for (int i = 0; i<jsonArray.length(); i++){
                integers.add(jsonArray.getInt(i));
                LocalData.mLikesId.add(jsonArray.getInt(i));
            }
        } catch (JSONException e) {
            getViewState().showMessage(e);
        }
        return integers;
    }

    public JSONObject convertToJson(){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try{

            for (int i: LocalData.mLikesId) {
                jsonArray.put(i);
            }

            jsonObject.put(LIKES_ID, jsonArray);
        } catch (JSONException ignored){}
        return jsonObject;
    }


    private void hideProgress(){
        getViewState().hideProgress();
    }

    public void refreshCalled(){
        loadFavoritesList();
    }
}
