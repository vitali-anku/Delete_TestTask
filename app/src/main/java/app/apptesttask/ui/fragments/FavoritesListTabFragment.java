package app.apptesttask.ui.fragments;

import android.support.v4.widget.SwipeRefreshLayout;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import app.apptesttask.mvp.presenter.FavoritesListTabFragmentPresenter;
import app.apptesttask.mvp.view.FavoritesListTabFragmentView;

public class FavoritesListTabFragment extends MvpAppCompatFragment implements FavoritesListTabFragmentView,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    FavoritesListTabFragmentPresenter favoritesListPresenter;

    @Override
    public void onRefresh() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showFavoritesList(List<?> heroes, boolean clear) {

    }

    @Override
    public void showMessage(int messResId) {

    }

    @Override
    public void clearList() {

    }
}
