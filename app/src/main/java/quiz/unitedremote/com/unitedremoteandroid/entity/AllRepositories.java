package quiz.unitedremote.com.unitedremoteandroid.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllRepositories {
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<repoItem> items = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<repoItem> getItems() {
        return items;
    }

    public void setItems(List<repoItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "AllRepositories{" +
                "totalCount=" + totalCount +
                ", incompleteResults=" + incompleteResults +
                ", items=" + items +
                '}';
    }
}
