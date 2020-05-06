package tcom.hieulv.foodcustomer.ui.home.food;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.List;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.model.response.nearrestaurant.ListRestaurant;

public class AdapterNearRestaurant extends RecyclerView.Adapter<AdapterNearRestaurant.MyViewHolder> {
    private Context context;
    List<ListRestaurant> listRestaurants;

    public AdapterNearRestaurant(Context context, List<ListRestaurant> listRestaurants) {
        this.context = context;
        this.listRestaurants = listRestaurants;
    }

    @NonNull
    @Override
    public AdapterNearRestaurant.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(context).inflate(R.layout.item_near_restaurant, parent, false);
        return new MyViewHolder(container);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterNearRestaurant.MyViewHolder holder, int position) {
        ListRestaurant restaurant = listRestaurants.get(position);
        List<String> image = restaurant.getGetImage();
        String linkimages = image.size() > 0 ? image.get(0) : "";
        if (TextUtils.isEmpty(linkimages)) {
            Glide.with(context).load(R.mipmap.ic_launcher).into(holder.imgRestaurant);
        } else {
            Glide.with(context).load(linkimages)
                    .transform(new CenterInside(), new RoundedCorners(24)).into(holder.imgRestaurant);
        }
        String nameRestaurant = restaurant.getLanguage().size() > 0 ? restaurant.getLanguage().get(0).getName() : " ";
        holder.tvNameRestaurant.setText(nameRestaurant);
        String addressRestaurant = restaurant.getLanguage().size() > 0 ? restaurant.getLanguage().get(0).getAddress() : "";
        holder.tvAddress.setText(addressRestaurant);


    }


    @Override
    public int getItemCount() {
        return listRestaurants != null ? listRestaurants.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRestaurant;
        TextView tvNameRestaurant, tvAddress;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRestaurant = itemView.findViewById(R.id.img_res);
            tvNameRestaurant = itemView.findViewById(R.id.tv_nameRestaurant);
            tvAddress = itemView.findViewById(R.id.addRestaurant);
        }
    }
}
