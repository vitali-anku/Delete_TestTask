package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterDataContainer {
    @SerializedName("offset")
    int offset;
    @SerializedName("limit")
    int limit;
    @SerializedName("total")
    int total;
    @SerializedName("count")
    int count;
    @SerializedName("results")
    List<Character> results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
