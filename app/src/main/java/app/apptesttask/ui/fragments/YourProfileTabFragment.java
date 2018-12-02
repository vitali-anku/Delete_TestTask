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
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

import app.apptesttask.R;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.presenter.FavoritesListTabFragmentPresenter;
import app.apptesttask.mvp.presenter.YourProfileTabFragmentPresenter;
import app.apptesttask.mvp.view.FavoritesListTabFragmentView;
import app.apptesttask.mvp.view.YourProfileTabFragmentView;
import app.apptesttask.ui.adapters.RecyclerHeroesListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class YourProfileTabFragment extends MvpAppCompatFragment implements YourProfileTabFragmentView,
        SwipeRefreshLayout.OnRefreshListener, FavoritesListTabFragmentView {

    @InjectPresenter
    YourProfileTabFragmentPresenter yourProfilePresenter;

    @InjectPresenter
    FavoritesListTabFragmentPresenter favoritesListPresenter;

    @BindView(R.id.avatar_image)
    CircleImageView circleImageView;
    @BindView(R.id.first_name)
    TextView firstNameView;
    @BindView(R.id.last_name)
    TextView lastNameView;
    @BindView(R.id.about_me)
    TextView aboutMeView;
    @BindView(R.id.my_favorites)
    RecyclerView recyclerView;
    @BindView(R.id.my_favorites_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerHeroesListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.your_profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        initRecycler();
        initSwipeRefreshLayout();
    }

    private void initRecycler() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getContext()), VERTICAL);
        mAdapter = new RecyclerHeroesListAdapter();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
    }

    @Override
    public void onRefresh() {
        clearList();
        favoritesListPresenter.refreshCalled();
    }

    @Override
    public void showUserData(String urlImage, String firstName, String lastName, String aboutMe) {
        Glide.with(Objects.requireNonNull(getContext()))
                .load(urlImage)
                .into(circleImageView);
        firstNameView.setText(firstName);
        lastNameView.setText(lastName);
        aboutMeView.setText(aboutMe);
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showFavoritesList(List<Character> heroes) {
        mAdapter.setItemsList(heroes, false);
    }

    @Override
    public void showMessage(Throwable throwable) {
        Toast.makeText(getContext(), throwable.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearList() {
        mAdapter.clearItemList();
    }
}
