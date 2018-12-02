package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicList {
    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("returned")
    @Expose
    private Integer returned;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<ComicSummary> items;

    @Override
    public String toString() {
        return "ComicList{" +
                "available=" + available +
                ", returned=" + returned +
                ", collectionURI='" + collectionURI + '\'' +
                ", items=" + items +
                '}';
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Integer getReturned() {
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

    public List<ComicSummary> getItems() {
        return items;
    }

    public void setItems(List<ComicSummary> items) {
        this.items = items;
    }
}
