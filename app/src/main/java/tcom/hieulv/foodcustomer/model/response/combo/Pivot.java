package tcom.hieulv.foodcustomer.model.response.combo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot {

    @SerializedName("food_id")
    @Expose
    private Integer foodId;
    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("amount")
    @Expose
    private Integer amount;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
