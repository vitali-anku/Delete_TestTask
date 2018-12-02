package app.apptesttask.mvp.models;

import java.util.ArrayList;
import java.util.List;

public class LocalData {

    public static List<Integer> mInProgress = new ArrayList<>();
    public static List<Integer> mLikesId = new ArrayList<>();

    public static void toggleLike(int idCharacter) {
        Integer id = idCharacter;
        if (mInProgress.contains(id)) {
            mInProgress.remove(id);
            mLikesId.remove(id);
        } else {

            mInProgress.add(id);
            mLikesId.add(id);
        }
    }
}