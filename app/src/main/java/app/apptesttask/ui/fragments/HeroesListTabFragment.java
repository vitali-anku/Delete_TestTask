package app.apptesttask.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;
import java.util.Objects;

import app.apptesttask.R;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.presenter.HeroesListTabFragmentPresenter;
import app.apptesttask.mvp.view.HeroesListTabFragmentView;
import app.apptesttask.ui.adapters.RecyclerHeroesListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class HeroesListTabFragment extends MvpAppCompatFragment implements HeroesListTabFragmentView,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    HeroesListTabFragmentPresenter heroesListPresenter;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recycler_heroes_list)
    RecyclerView mRecycler;

    private RecyclerHeroesListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_heroes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        initRecycler();
        initSwipeRefreshLayout();
    }

    @Override
    public void onRefresh(){
        heroesListPresenter.refreshCalled();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
    }

    private void initRecycler() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getContext()), VERTICAL);
        mAdapter = new RecyclerHeroesListAdapter();
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
        mRecycler.addItemDecoration(itemDecoration);
    }

    @Override
    public void showHeroesList(List<Character> characters) {
        mAdapter.setItemsList(characters, true);
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
    public void showError(String errorMsg) {
        Toast.makeText(getContext(), "Error!!!! " + errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearList() {
        mAdapter.clearItemList();
    }
}
