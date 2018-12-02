package app.apptesttask.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import app.apptesttask.R;
import app.apptesttask.mvp.presenter.YourProfileTabFragmentPresenter;
import app.apptesttask.mvp.view.YourProfileTabFragmentView;

public class YourProfileTabFragment extends MvpAppCompatFragment implements YourProfileTabFragmentView,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    YourProfileTabFragmentPresenter yourProfilePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.your_profile_fragment, container, false);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showUserData(Class<?> clas, boolean visible) {

    }

    @Override
    public void showLayoutProfile() {

    }
}
