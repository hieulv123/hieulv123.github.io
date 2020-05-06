package tcom.hieulv.foodcustomer.ui.home.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.model.ItemHeader;

public class AdapterHeader extends RecyclerView.Adapter<AdapterHeader.ViewHolder> {
    Context context;
    List<ItemHeader> data;

    public AdapterHeader(Context context, List<ItemHeader> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemimage_header, parent, false);
        return new ViewHolder(container);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemHeader item = data.get(position);
        holder.imgheader.setImageDrawable(context.getResources().getDrawable(item.getImgageHeader()));

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgheader;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgheader = itemView.findViewById(R.id.item_img);
        }
    }
}
