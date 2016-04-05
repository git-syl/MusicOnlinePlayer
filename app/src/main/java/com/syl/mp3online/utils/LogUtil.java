package com.syl.mp3online.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by ainsc on 2016/4/4/004.
 */
public class LogUtil {
    private static final String tag = "MyLog";
    private static final boolean isOpen =true;

    /*
    * 打印日志
    * @param log
    */
    public static void log(String log){
        if (isOpen){
            Log.e(tag,log);
        }
    }

    /**
     * 显示Toast
     * @param context
     * @param message
     * */
    public static void toast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
