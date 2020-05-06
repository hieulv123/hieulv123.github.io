package tcom.hieulv.foodcustomer.model.response.combo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image_ {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("menu_id")
    @Expose
    private Object menuId;
    @SerializedName("food_id")
    @Expose
    private Object foodId;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("restaurant_id")
    @Expose
    private Object restaurantId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("del")
    @Expose
    private Integer del;
    @SerializedName("category_id")
    @Expose
    private Object categoryId;
    @SerializedName("shipper_id")
    @Expose
    private Object shipperId;
    @SerializedName("userCms_id")
    @Expose
    private Object userCmsId;
    @SerializedName("userApp_id")
    @Expose
    private Object userAppId;
    @SerializedName("combo_id")
    @Expose
    private Integer comboId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getMenuId() {
        return menuId;
    }

    public void setMenuId(Object menuId) {
        this.menuId = menuId;
    }

    public Object getFoodId() {
        return foodId;
    }

    public void setFoodId(Object foodId) {
        this.foodId = foodId;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Object restaurantId) {
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Object getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Object categoryId) {
        this.categoryId = categoryId;
    }

    public Object getShipperId() {
        return shipperId;
    }

    public void setShipperId(Object shipperId) {
        this.shipperId = shipperId;
    }

    public Object getUserCmsId() {
        return userCmsId;
    }

    public void setUserCmsId(Object userCmsId) {
        this.userCmsId = userCmsId;
    }

    public Object getUserAppId() {
        return userAppId;
    }

    public void setUserAppId(Object userAppId) {
        this.userAppId = userAppId;
    }

    public Integer getComboId() {
        return comboId;
    }

    public void setComboId(Integer comboId) {
        this.comboId = comboId;
    }
}
