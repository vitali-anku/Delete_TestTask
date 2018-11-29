package app.apptesttask.ui.fragments;

import android.support.v4.widget.SwipeRefreshLayout;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import app.apptesttask.mvp.presenter.YourProfileTabFragmentPresenter;
import app.apptesttask.mvp.view.YourProfileTabFragmentView;

public class YourProfileTabFragment extends MvpAppCompatFragment implements YourProfileTabFragmentView,
        SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    YourProfileTabFragmentPresenter yourProfilePresenter;

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
