package cn.haiyueshang.nettest.nettest;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzeya on 16/8/2.
 */
public class MyNetWork {
    public static RequestQueue queue = Volley.newRequestQueue(MyApplication.getContext());
    public static String mUrl = "http://58.210.247.180:8188/appapi/";

    public static void test(){
        String url = mUrl+"getHot";
        Log.i("url:",url);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("测试成功",s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("测试失败","");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("page", "1");
                map.put("num", "1");
                return map;
            }
        };

        queue.add(request);





    }



}
