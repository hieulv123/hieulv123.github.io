package tcom.hieulv.foodcustomer.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    protected ItemClickListener mItemClickListener;
    protected LayoutInflater mInflater;
    protected List<T> mDataList;
    private RecyclerView mRecyclerView;
    private BaseActivity mBaseActivity;
    protected Context mContext;

    public Context getmContext() {
        return mContext;
    }

    public BaseRecyclerViewAdapter(@NonNull BaseActivity baseActivity, ItemClickListener itemClickListener) {
        mContext = baseActivity;
        mBaseActivity = baseActivity;
        mInflater = LayoutInflater.from(baseActivity);
        mItemClickListener = itemClickListener;
        mDataList = new ArrayList<>();
    }

    public List<T> getmDataList() {
        return mDataList;
    }

    public BaseRecyclerViewAdapter(@NonNull BaseActivity context) {
        mContext = context;
        mBaseActivity = context;
        mInflater = LayoutInflater.from(context);
        mDataList = new ArrayList<>();

    }

    public BaseActivity getBaseActivity() {
        return mBaseActivity;
    }

    public void add(List<T> itemList) {
        mDataList.addAll(itemList);
        notifyDataSetChanged();

    }

    public void add(int position, List<T> itemList) {
        mDataList.addAll(position, itemList);
        notifyDataSetChanged();
    }

    public void addItem(int position, T item) {
        mDataList.add(position, item);
        notifyItemInserted(position);
    }

    public void addItem(T item) {
        mDataList.add(item);
        notifyDataSetChanged();
    }

    public void addFirst(T item) {
        addItem(0, item);
        restoreScrollPositionAfterAdded();
    }

    public T getDataItem(int position) {
        if (position >= mDataList.size()) {
            return null;
        }
        return mDataList.get(position);
    }

    public void set(List<T> dataList) {
        if (dataList == null) {
            return;
        }
        List<T> clone = new ArrayList<>(dataList);
        mDataList.clear();
        mDataList.addAll(clone);
        notifyDataSetChanged();
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.mItemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        super.onAttachedToRecyclerView(recyclerView);
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    private void restoreScrollPositionAfterAdded() {
        if (mRecyclerView != null) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPosition(0);
            }

        }

    }

}
