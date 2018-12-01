package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

public class Url {
    @SerializedName("type")
    String type;
    @SerializedName("url")
    String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
