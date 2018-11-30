package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

class ComicSummary {
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
        return "ComicSummary{" +
                "resourceURI='" + resourceURI + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}