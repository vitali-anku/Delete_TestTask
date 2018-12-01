package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

public class SeriesSummary {
    @SerializedName("resourceURI")
    String resourceURI;
    @SerializedName("name")
    String name;

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

    @Override
    public String toString() {
        return "SeriesSummary{" +
                "resourceURI='" + resourceURI + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
