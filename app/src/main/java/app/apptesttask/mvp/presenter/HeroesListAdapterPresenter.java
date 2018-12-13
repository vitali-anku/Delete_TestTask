package app.apptesttask.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import app.apptesttask.application.MyApplication;
import app.apptesttask.mvp.view.HeroesListsView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class HeroesListAdapterPresenter extends BasePresenter<HeroesListsView> {

    public static final String TAG = "HeroesListAdapterPresenter";

    private List<Integer> mInProgress = new ArrayList<>();
    private List<Integer> mLikesId = new ArrayList<>();

    @Inject
    public HeroesListAdapterPresenter() {}

    public void toggleLike(int id) {
        if (mInProgress.contains(id)) {
            return;
        }

        mInProgress.add(id);

        getViewState().updateLikes(mInProgress, mLikesId);

        final Observable<Boolean> toggleObservable = Observable.create(subscriber -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            subscriber.onNext(!mLikesId.contains(id));
        });

        unsubscribeOnDestroy(toggleObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isLiked -> onComplete(id, isLiked), throwable -> onFail(id)));
    }

    private void onComplete(int id, boolean isLiked){
        if (!mInProgress.contains(id)) {
            return;
        }

        mInProgress.remove(id);

        if (isLiked) {
            mLikesId.add(id);
        } else {
            mLikesId.remove(id);
        }

        getViewState().updateLikes(mInProgress, mLikesId);
    }

    private void onFail(int id){
        if(!mInProgress.contains(id)){
            return;
        }

        mInProgress.remove(id);
        getViewState().updateLikes(mInProgress, mLikesId);
    }
}
