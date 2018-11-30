package app.apptesttask.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.presenter.InjectPresenter;

import app.apptesttask.R;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.presenter.MainActivityPresenter;
import app.apptesttask.mvp.view.MainActivityView;
import app.apptesttask.ui.fragments.HeroesListTabFragment;
import app.apptesttask.ui.fragments.FavoritesListTabFragment;
import app.apptesttask.ui.fragments.YourProfileTabFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @InjectPresenter
    MainActivityPresenter mMainActivityPresenter;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.view_pages)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initViewPage();
    }

    private void initViewPage() {
        PageAdapter mPageAdapter = new PageAdapter(getSupportFragmentManager(), 3);
        mViewPager.setAdapter(mPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public class PageAdapter extends FragmentStatePagerAdapter {
        private static final int HEROES_LIST_TAB = 0;
        private static final int FAVORITES_LIST_TAB = 1;
        private static final int YOUR_PROFILE_TAB = 2;
        private int mTabsCount;

        public PageAdapter(FragmentManager fm, int tabsCount) {
            super(fm);
            this.mTabsCount = tabsCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case HEROES_LIST_TAB:
                    return new HeroesListTabFragment();
                case FAVORITES_LIST_TAB:
                    return new FavoritesListTabFragment();
                case YOUR_PROFILE_TAB:
                    return new YourProfileTabFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mTabsCount;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case HEROES_LIST_TAB:
                    return getString(R.string.heroes_list_tab);
                case FAVORITES_LIST_TAB:
                    return getString(R.string.favorites_list_tab);
                case YOUR_PROFILE_TAB:
                    return getString(R.string.your_profile_tab);
                default:
                    return "";
            }
        }
    }
}
