package com.t3h.buoi15.fragment.Song;

import com.t3h.basemodule.base.AdapterBaseListener;
import com.t3h.buoi15.model.Song;

public interface SongItemListener extends AdapterBaseListener {
    void onItemSongClicked(Song item ) ;
}
