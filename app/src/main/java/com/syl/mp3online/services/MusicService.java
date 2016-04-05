package com.syl.mp3online.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.syl.mp3online.utils.MusicUtil;

import java.util.List;

/**
 * Created by ainsc on 2016/4/5/005.
 */
public class MusicService extends Service {

    /**
     * 指令
     * */
    public static final String KEY_COMMAND = "k_command";
  /**
   * 音乐名称
   */
    public  static final String KEY_MUSIC_NAME = "k_music_name";
    /**
     * 音乐路径
     * */
    public static final String KEY_MUSIC_PATH="k_music_path";
    /**
     * 播放位置
     * */
    public static final String KEY_MUSIC_INDEX= "k_music_index";
    /**
     * 播放列表
     * */
    public static final String KEY_MUSIC_LIST = "k_music_list" ;
    /**
     * 播放总时间
     * */
    public static final String MUSIC_TIME_TOTAL = "music_time_total";
    /**
     * 当前播放进度
     * */
    public static final String MUSIC_TIME_CURR = "music_time_curr";
    /**
     * 更新当前播放的广播
     * */
    public static final String CAST_ACTION_UPDATE = "com.syl.mp3online.services.MUSIC_TIME_UPDATE";

    /**
     * 初始化
     * */
    public static final int CMD_INIT = 1000;
    /**
     * 播放
     * */
    public static final int CMD_PLAY = 1001;
    /**
     * 暂停
     * */
    public static final int CMD_PAUSE =1002;
    /**
     * 下一曲
     * */
    public static final int CMD_NEXT = 1003;
    /**
     * 上一曲
     * */
    public static final int CMD_PREV = 1004;
    /**
     * 停止
     * */
    public static final int CMD_STOP = 1005;
    /**
     * 从暂停恢复
     * */
    public static final int CMD_RESUME = 1006;

    private MusicUtil mMusicUtil;
    private Context mContext;

    //每次启动服务时执行
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //从Intent 中获取指令
        int command = intent.getIntExtra(KEY_COMMAND,-1);
        //更具不同的指令，调用不同的方法
        switch (command){
            case CMD_INIT:
                List<String> musicList = intent.getStringArrayListExtra(KEY_MUSIC_LIST);
                mMusicUtil = new MusicUtil(mContext,musicList);
                break;
            case CMD_PLAY:
                int index = intent.getIntExtra(KEY_MUSIC_INDEX,0);
                mMusicUtil.play(index);
                break;
            case CMD_PAUSE:
                mMusicUtil.pause();
                break;
            case CMD_RESUME:
                mMusicUtil.play();
                break;
            case CMD_NEXT:
                mMusicUtil.next();
                break;
            case CMD_PREV:
                mMusicUtil.prev();
                break;
            case CMD_STOP:
                mMusicUtil.stop();
                break;
            default:
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
