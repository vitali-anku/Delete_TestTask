package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeriesList {
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
    private List<SeriesSummary> items;

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
