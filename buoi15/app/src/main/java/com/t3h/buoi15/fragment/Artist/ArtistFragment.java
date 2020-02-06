package com.t3h.buoi15.fragment.Artist;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.basemodule.base.AdapterBase;
import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.AppAdapter;
import com.t3h.buoi15.R;
import com.t3h.buoi15.data.SystemData;
import com.t3h.buoi15.databinding.FragmentArtistBinding;
import com.t3h.buoi15.model.Song;

public class ArtistFragment extends FragmentBase<FragmentArtistBinding> {
    private AdapterBase <Song> adapter ;
    private SystemData data ;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_artist ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new AppAdapter<>(getLayoutInflater(),R.layout.item_view) ;
        data = new SystemData(getContext()) ;
        adapter.setData(data.readData());
        binding.lvArtist.setAdapter(adapter);
    }
}
