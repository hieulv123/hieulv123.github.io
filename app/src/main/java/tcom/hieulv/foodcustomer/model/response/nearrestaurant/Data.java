package tcom.hieulv.foodcustomer.model.response.nearrestaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("list_restaurants")
    @Expose
    private List<ListRestaurant> listRestaurants = null;
    @SerializedName("total")
    @Expose
    private Integer total;

    public List<ListRestaurant> getListRestaurants() {
        return listRestaurants;
    }

    public void setListRestaurants(List<ListRestaurant> listRestaurants) {
        this.listRestaurants = listRestaurants;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
