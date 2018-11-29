package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

public class CharacterDataWrapper {
    @SerializedName("code")
    String code;
    @SerializedName("status")
    String status;
    @SerializedName("copyright")
    String copyright;
    @SerializedName("attributionText")
    String attributionText;
    @SerializedName("attributionHTML")
    String attributionHTML;
    @SerializedName("data")
    CharacterDataContainer data;
    @SerializedName("etag")
    String etag;
}
