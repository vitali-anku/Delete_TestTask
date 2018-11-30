package app.apptesttask.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import app.apptesttask.R;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.models.heroes.Image;
import app.apptesttask.mvp.presenter.HeroesListTabFragmentPresenter;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;
import app.apptesttask.ui.adapters.RecyclerHeroesListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HeroesListTabFragment extends MvpAppCompatFragment implements HeroesListTabFragmentView,
        SwipeRefreshLayout.OnRefreshListener{

    @InjectPresenter
    HeroesListTabFragmentPresenter heroesListPresenter;

    @Inject
    Character character;

    @Inject
    Image image;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerHeroesListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showHeroesList(List<Character> heroes, List<Image> images, boolean clear) {
        mAdapter.setItemsList(heroes, images, clear);
    }

    @Override
    public void showMessage(int messResId) {
        Toast.makeText(getContext(), messResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearList() {
        mAdapter.clearItemList();
    }
}
