package tcom.hieulv.foodcustomer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {
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
    @SerializedName("get_image")
    @Expose
    private List<String> getImage = null;
    @SerializedName("price_format")
    @Expose
    private String priceFormat;
    @SerializedName("price_format_with_currency")
    @Expose
    private String priceFormatWithCurrency;
    @SerializedName("language")
    @Expose
    private List<Language> language = null;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;

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

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
