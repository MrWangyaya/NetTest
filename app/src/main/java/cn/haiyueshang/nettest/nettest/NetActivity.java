package cn.haiyueshang.nettest.nettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

public class NetActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        init();
        setListener();
    }

    private void setListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MyNetWork.test();
                okhttp();

            }
        });
    }

    private void init() {
        btn = (Button) findViewById(R.id.btn_nettest);
    }

    public void okhttp(){
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("page","1");
        builder.add("num","1");

        Request request = new Request.Builder()
                .url("http://58.210.247.180:8188/appapi/GetCatList")
                .post(builder.build())
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback(){
            @Override
            public void onFailure(Request request, IOException e) {
                Log.i("测试失败","");

            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.i("测试成功",response.body().string());
            }
        });





    }

}
