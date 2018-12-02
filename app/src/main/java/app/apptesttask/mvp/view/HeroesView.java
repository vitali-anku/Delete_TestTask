package app.apptesttask.mvp.view;

import com.arellomobile.mvp.MvpView;

import app.apptesttask.mvp.models.heroes.Character;

public interface HeroesView extends MvpView {
    void showRepository(Character heroes);

    void updateLike(boolean isInProgress, boolean isLiked);
}
