package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class CharacterDataContainer {
    @SerializedName("offset")
    int offset;
    @SerializedName("limit")
    int limit;
    @SerializedName("total")
    int total;
    @SerializedName("count")
    int count;
    @SerializedName("results")
    List<Character> results;
}
