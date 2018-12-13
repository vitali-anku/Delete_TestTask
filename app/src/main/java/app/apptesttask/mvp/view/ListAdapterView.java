package app.apptesttask.mvp.view;

import android.support.annotation.DrawableRes;

public interface ListAdapterView {

    void setData(String image, String name, String description);

    void setStar(@DrawableRes int resId);
}
