package tcom.hieulv.foodcustomer.model.response.combo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Food {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("del")
    @Expose
    private Integer del;
    @SerializedName("unit")
    @Expose
    private Object unit;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("totalbooked")
    @Expose
    private Integer totalbooked;
    @SerializedName("hot")
    @Expose
    private Integer hot;
    @SerializedName("price_sale")
    @Expose
    private Integer priceSale;
    @SerializedName("get_image")
    @Expose
    private List<String> getImage = null;
    @SerializedName("price_format")
    @Expose
    private String priceFormat;
    @SerializedName("price_format_with_currency")
    @Expose
    private String priceFormatWithCurrency;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("total_rating")
    @Expose
    private Integer totalRating;
    @SerializedName("total_order")
    @Expose
    private Integer totalOrder;
    @SerializedName("pivot")
    @Expose
    private Pivot pivot;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("order_not_cancel")
    @Expose
    private List<OrderNotCancel> orderNotCancel = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTotalbooked() {
        return totalbooked;
    }

    public void setTotalbooked(Integer totalbooked) {
        this.totalbooked = totalbooked;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Integer priceSale) {
        this.priceSale = priceSale;
    }

    public List<String> getGetImage() {
        return getImage;
    }

    public void setGetImage(List<String> getImage) {
        this.getImage = getImage;
    }

    public String getPriceFormat() {
        return priceFormat;
    }

    public void setPriceFormat(String priceFormat) {
        this.priceFormat = priceFormat;
    }

    public String getPriceFormatWithCurrency() {
        return priceFormatWithCurrency;
    }

    public void setPriceFormatWithCurrency(String priceFormatWithCurrency) {
        this.priceFormatWithCurrency = priceFormatWithCurrency;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<OrderNotCancel> getOrderNotCancel() {
        return orderNotCancel;
    }

    public void setOrderNotCancel(List<OrderNotCancel> orderNotCancel) {
        this.orderNotCancel = orderNotCancel;
    }

}
