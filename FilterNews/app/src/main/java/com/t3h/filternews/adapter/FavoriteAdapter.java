package com.t3h.filternews.adapter;

import android.content.Context;
import android.view.View;

public class FavoriteAdapter extends BaseAdapter{
    private FavoriteItemListener listener;

    public FavoriteAdapter(Context context) {
        super(context);
    }

    public void setListener(FavoriteAdapter.FavoriteItemListener listener) {
        this.listener = listener;
    }

    @Override
    protected void decodeView(BaseHolder holder, final int position) {
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNewsItemClicked(position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onNewsItemLongClicked(position);
                    return true;
                }
            });
        }
    }

    public interface FavoriteItemListener {
        void onNewsItemLongClicked(int position);

        void onNewsItemClicked(int position);
    }
}
