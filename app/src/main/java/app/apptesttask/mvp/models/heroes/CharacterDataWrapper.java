package app.apptesttask.mvp.models.heroes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CharacterDataWrapper implements Parcelable {
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

    public CharacterDataWrapper(Parcel in) {
        code = in.readString();
        status = in.readString();
        copyright = in.readString();
        attributionText = in.readString();
        attributionHTML = in.readString();
        etag = in.readString();
    }

    protected CharacterDataWrapper

    public static final Creator<CharacterDataWrapper> CREATOR = new Creator<CharacterDataWrapper>() {
        @Override
        public CharacterDataWrapper createFromParcel(Parcel in) {
            return new CharacterDataWrapper(in);
        }

        @Override
        public CharacterDataWrapper[] newArray(int size) {
            return new CharacterDataWrapper[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(status);
        dest.writeString(copyright);
        dest.writeString(attributionText);
        dest.writeString(attributionHTML);
        dest.writeC
        //dest.writeParcelable(data);
        dest.writeString(etag);
    }
}
