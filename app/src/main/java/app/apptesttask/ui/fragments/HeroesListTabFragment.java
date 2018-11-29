package app.apptesttask.ui.fragments;

import android.support.v4.widget.SwipeRefreshLayout;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import app.apptesttask.mvp.presenter.HeroesListTabFragmentPresenter;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;

public class HeroesListTabFragment extends MvpAppCompatFragment implements HeroesListTabFragmentView,
        SwipeRefreshLayout.OnRefreshListener{

    @InjectPresenter
    HeroesListTabFragmentPresenter heroesListPresenter;



    @Override
    public void onRefresh() {
        ///
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showHeroesList(List<?> heroes, boolean clear) {

    }

    @Override
    public void showMessage(int messResId) {

    }

    @Override
    public void clearList() {

    }
}
