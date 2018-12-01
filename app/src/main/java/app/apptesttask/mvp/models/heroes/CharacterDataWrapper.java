package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterDataWrapper {
    @SerializedName("code")
    @Expose
    String code;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("copyright")
    @Expose
    String copyright;
    @SerializedName("attributionText")
    @Expose
    String attributionText;
    @SerializedName("attributionHTML")
    @Expose
    String attributionHTML;
    @SerializedName("data")
    @Expose
    CharacterDataContainer data;
    @SerializedName("etag")
    @Expose
    String etag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public CharacterDataContainer getData() {
        return data;
    }

    public void setData(CharacterDataContainer data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
