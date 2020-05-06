package tcom.hieulv.foodcustomer.model.response.combo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderNotCancel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("price")
    @Expose
    private Object price;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("del")
    @Expose
    private Integer del;
    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("shipper_id")
    @Expose
    private Integer shipperId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("timeChart")
    @Expose
    private String timeChart;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("order_number")
    @Expose
    private String orderNumber;
    @SerializedName("price_format_with_currency")
    @Expose
    private String priceFormatWithCurrency;
    @SerializedName("pivot")
    @Expose
    private Pivot_ pivot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimeChart() {
        return timeChart;
    }

    public void setTimeChart(String timeChart) {
        this.timeChart = timeChart;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPriceFormatWithCurrency() {
        return priceFormatWithCurrency;
    }

    public void setPriceFormatWithCurrency(String priceFormatWithCurrency) {
        this.priceFormatWithCurrency = priceFormatWithCurrency;
    }

    public Pivot_ getPivot() {
        return pivot;
    }

    public void setPivot(Pivot_ pivot) {
        this.pivot = pivot;
    }
}
