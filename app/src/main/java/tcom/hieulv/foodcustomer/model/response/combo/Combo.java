package tcom.hieulv.foodcustomer.model.response.combo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Combo {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("del")
    @Expose
    private Integer del;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("price_sale")
    @Expose
    private Integer priceSale;
    @SerializedName("items")
    @Expose
    private List<String> items = null;
    @SerializedName("get_image")
    @Expose
    private List<String> getImage = null;
    @SerializedName("price_format_with_currency")
    @Expose
    private String priceFormatWithCurrency;
    @SerializedName("language")
    @Expose
    private List<Language> language = null;
    @SerializedName("foods")
    @Expose
    private List<Food> foods = null;
    @SerializedName("images")
    @Expose
    private List<Image_> images = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
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

    public Integer getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Integer priceSale) {
        this.priceSale = priceSale;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getGetImage() {
        return getImage;
    }

    public void setGetImage(List<String> getImage) {
        this.getImage = getImage;
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

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Image_> getImages() {
        return images;
    }

    public void setImages(List<Image_> images) {
        this.images = images;
    }

}
