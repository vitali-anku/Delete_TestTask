package app.apptesttask.mvp.models.heroes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterDataContainer {
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("results")
    @Expose
    private List<Character> results;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Integer getCount() {
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
