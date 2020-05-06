package tcom.hieulv.foodcustomer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.model.ItemRestauran;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    List<ItemRestauran> data;
    Context context;
    clickDetailOrder clickDetailOrder ;

//    public void setOrder(clickDetailOrder clickDetailOrder){
//        this.clickDetailOrder = clickDetailOrder;
//    }

    public RestaurantAdapter(List<ItemRestauran> data, Context context,clickDetailOrder clickDetailOrder) {
        this.data = data;
        this.context = context;
        this.clickDetailOrder = clickDetailOrder;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemRestauran item = data.get(position);
        holder.imgOrder.setImageDrawable(context.getResources().getDrawable(item.getImageRestaurant()));
        holder.detailOrder.setOnClickListener(v->{
            clickDetailOrder.clickImgDetail();

        });

    }
    public interface clickDetailOrder{
        void clickImgDetail();
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgOrder, detailOrder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgOrder = itemView.findViewById(R.id.img_item_order);
            detailOrder = itemView.findViewById(R.id.img_arrowright);
        }
    }

}