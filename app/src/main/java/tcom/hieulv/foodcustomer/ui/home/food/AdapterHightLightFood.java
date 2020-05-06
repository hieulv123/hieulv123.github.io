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
import tcom.hieulv.foodcustomer.model.Datum;

public class AdapterHightLightFood extends RecyclerView.Adapter<AdapterHightLightFood.ViewHolder> {
    private Context context;

    List<Datum> images;
//    List<Language> languages;

    public AdapterHightLightFood(Context context, List<Datum> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(context).inflate(R.layout.item_hightlightfood, parent, false);
        return new ViewHolder(container);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Language itemLanguage = languages.get(position);
//        String id1 = itemLanguage.getFoodId();
        Datum itemImage = images.get(position);
        List<String> listImage = itemImage.getGetImage();
        String linkImage = listImage.size() > 0 ? listImage.get(0) : "";
        if (TextUtils.isEmpty(linkImage)) {
            Glide.with(context).load(R.mipmap.ic_launcher).into(holder.imgFood);
        } else {
//            Glide.with(context).load(linkImage).
//                    transform(new CenterInside(), new RoundedCorners(24)).into(holder.imgFood);
            Glide.with(context).load(linkImage).centerCrop().
                   into(holder.imgFood);
        }
        String name = itemImage.getLanguage().size() > 0 ? itemImage.getLanguage().get(0).getName() : "";
        holder.tvFood.setText(name);

    }


    @Override
    public int getItemCount() {
       return images!= null? images.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView tvFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_hightLightFood);
            tvFood = itemView.findViewById(R.id.tv_hightLightFood);
        }
    }
}
