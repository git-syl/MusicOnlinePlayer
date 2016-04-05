package com.syl.mp3online.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.syl.mp3online.R;
import com.syl.mp3online.bean.Music;

import java.util.List;

/**
 * Created by ainsc on 2016/4/5/005.
 */
public class MusicListViewMainAdapter extends BaseAdapter {

    private List<Music> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    /**
     * @param musics
     * @param context
     * */
    public MusicListViewMainAdapter(List<Music> musics,Context context){
        this.mData = musics;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return mData==null?0:mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData==null?null:mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
class Holder{
    TextView singer;
    TextView title;
}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.list_item,null);
            holder = new Holder();
            holder.singer = (TextView) convertView.findViewById(R.id.txtv_main_list_item_singer);
            holder.title = (TextView) convertView.findViewById(R.id.txtv_main_list_item_title);

            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.title.setText(mData.get(position).getTitle());
        holder.singer.setText(mData.get(position).getSinger());
        return convertView;
    }
}
