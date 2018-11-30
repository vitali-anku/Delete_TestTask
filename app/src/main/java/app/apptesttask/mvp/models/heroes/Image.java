package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("path")
    String path;
    @SerializedName("extension")
    String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return getPath() + "." + getExtension();
    }
}
