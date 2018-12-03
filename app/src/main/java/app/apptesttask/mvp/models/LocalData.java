package app.apptesttask.mvp.models;

import java.util.ArrayList;
import java.util.List;

public class LocalData {

    public static List<Integer> mLikesId = new ArrayList<>();

    public static void toggleLike(int idCharacter) {
        Integer id = idCharacter;
        if (mLikesId.contains(id)) {
            mLikesId.remove(id);
        } else
            mLikesId.add(id);
    }
}