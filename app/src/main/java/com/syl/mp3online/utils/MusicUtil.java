package com.syl.mp3online.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;

import com.syl.mp3online.services.MusicService;

import java.util.List;

/**
 * Created by ainsc on 2016/4/5/005.
 */
public class MusicUtil {
    private List<String> musics = null;
    /**
     * 系统提供的播放器
     * */
    private MediaPlayer mPlayer;

    private Context mContext;

    private  static int index = 0;

    /**
     * 用于记录播放状态
     * */
    private boolean isPlay = false;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(MusicService.CAST_ACTION_UPDATE);
            intent.putExtra(MusicService.KEY_MUSIC_INDEX,index);
            intent.putExtra(MusicService.MUSIC_TIME_CURR, mPlayer.getCurrentPosition());
            intent.putExtra(MusicService.MUSIC_TIME_TOTAL,mPlayer.getDuration());

            mContext.sendBroadcast(intent);
            //handler 自己给自己发消息，以达到每500毫秒/次
            handler.sendEmptyMessageDelayed(1,500);

        }
    };
/**
 * 构造方法
 * @param mContext  当前server的上下文
 *
 * */
    public MusicUtil(Context mContext, List<String> musicList) {

    }

    public void play(int index) {

    }

    public void pause() {
    }

    public void play() {

    }

    public void next() {
    }

    public void prev() {
    }

    public void stop() {

    }
}
