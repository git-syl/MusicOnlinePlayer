package com.syl.mp3online.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * Created by ainsc on 2016/4/5/005.
 *   <b>异步线程类<b/>
 *   <p>
 *      <ol>
 *        <li>网络请求，加载数据<li/>
 *        <li>耗时操作<li/>
 *      <ol/>
 *   <p/>
 */
public abstract class HttpAsyncRequestTask extends AsyncTask<String,Integer,String>{
    @Override
    protected String doInBackground(String... params) {
        LogUtil.log("-------任务开始-------");
        String result = null;

        HttpURLConnection connection=null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(8000);
            connection.setConnectTimeout(8000);
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();

            String line;
            while ((line=reader.readLine())!=null){
                response.append(line);
            }
            result = response.toString();


        } catch (Exception e) {
            Log.e("try catch",e.getMessage());
        }

        return  result;
    }

    @Override
    protected void onCancelled() {
        //取消异步任务时调用
        LogUtil.log("--------任务被取消了------");
        super.onCancelled();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        onComplete(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //进度发送变化时执行
      LogUtil.log("---------------任务完成了---------------");
        super.onProgressUpdate(values);
    }
    /**
     * 成功
     * */
    public abstract  void onComplete(String result);
}
