package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

public class StorySummary {
    @SerializedName("resourceURI ")
    String resourceURI;
    @SerializedName("name")
    String name;
    @SerializedName("type")
    String type;

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StorySummary{" +
                "resourceURI='" + resourceURI + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
