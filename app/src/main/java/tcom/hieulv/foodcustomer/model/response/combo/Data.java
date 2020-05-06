package tcom.hieulv.foodcustomer.model.response.combo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("combo")
    @Expose
    private List<Combo> combo = null;
    @SerializedName("total")
    @Expose
    private Integer total;

    public List<Combo> getCombo() {
        return combo;
    }

    public void setCombo(List<Combo> combo) {
        this.combo = combo;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
