package tcom.hieulv.foodcustomer.ui.combo;

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

import java.util.List;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.model.response.combo.Combo;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class AdapterComboFood extends RecyclerView.Adapter<AdapterComboFood.ViewHolder> {
    private Context context;
    List<Combo> combos;

    public AdapterComboFood(Context context, List<Combo> combos) {
        this.context = context;
        this.combos = combos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View combo = LayoutInflater.from(context).inflate(R.layout.item_foodcombo,parent,false);
        return new ViewHolder(combo) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Combo combo = combos.get(position);
        List<String> listImage = combo.getGetImage() ;
        String linkImage = listImage.size() >0?listImage.get(0): " ";
        if (TextUtils.isEmpty(linkImage)){
            Glide.with(context).load(R.mipmap.ic_launcher).into(holder.imgCombo);
        }else {
            Glide.with(context).load(linkImage).into(holder.imgCombo);
        }
        String nameCombo = combo.getLanguage().size()>0 ? combo.getLanguage().get(0).getName(): "";
        holder.tvNameCombo.setText(nameCombo);
        String priceSaleCombo = combo.getPriceSale().toString();
        String priceSale = CommonUntils.formatVNDnumber()


    }

    @Override
    public int getItemCount() {
        return combos!= null ? combos.size() : 0 ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCombo;
        TextView tvNameCombo,priceSaleCombo,priceCombo,food1,food2,food3 ;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgCombo = v.findViewById(R.id.img_comboFood);
            tvNameCombo = v.findViewById(R.id.tv_nameCombo);
            priceSaleCombo= v.findViewById(R.id.priceSale_combo);
            priceCombo = v.findViewById(R.id.price_combo);
            food1 = v.findViewById(R.id.food1);
            food2 = v.findViewById(R.id.food2);
            food3 = v.findViewById(R.id.food3);
        }
    }
}
