package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class SeriesList {
    @SerializedName("available")
    int available;
    @SerializedName("returned")
    int returned;
    @SerializedName("collectionURI")
    String collectionURI;
    @SerializedName("items")
    List<SeriesSummary> items;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<SeriesSummary> getItems() {
        return items;
    }

    public void setItems(List<SeriesSummary> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SeriesList{" +
                "available=" + available +
                ", returned=" + returned +
                ", collectionURI='" + collectionURI + '\'' +
                ", items=" + items +
                '}';
    }
}
