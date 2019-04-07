package com.example.liquid.busstationoutdoorfacilitiesms;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.Register.RegisterActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    /**
     * 请输入账号
     */
    private EditText mEditText_account;
    /**
     * 请输入密码
     */
    private EditText mEditText_pwd;
    private String message;

    final OkHttpClient client = new OkHttpClient();
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==1){
                String ReturnMessage = (String) msg.obj;
                try {
                    JSONObject jsonObject = new JSONObject(ReturnMessage);
                    message=jsonObject.getString("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(message.equals("1"))
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                /***
                 * 在此处可以通过获取到的Msg值来判断
                 * 给出用户提示注册成功 与否，以及判断是否用户名已经存在
                 */

            }

        }
    };
    private String account;
    private String pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

     mEditText_account.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            account=s.toString();
         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             account=s.toString();
         }

         @Override
         public void afterTextChanged(Editable s) {
             account=s.toString();

         }
     });

     mEditText_pwd.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             pwd=s.toString();
         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             pwd=s.toString();
         }

         @Override
         public void afterTextChanged(Editable s) {
             pwd=s.toString();
         }
     });
        //注册按钮监听器
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
        //登陆按钮监听器
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // postRequest(account,pwd);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });


    }

    private void initView() {
        mEditText_account = (EditText) findViewById(R.id.editText2);
        mEditText_pwd= (EditText) findViewById(R.id.editText3);
    }

    /**
     * post请求后台
     * @param username
     * @param password
     */
    private void postRequest(String username,String password)  {
        //建立请求表单，添加上传服务器的参数

        RequestBody formBody = new FormBody.Builder()
                .add("name",username)
                .add("password",password)
                .build();
        //发起请求
        final Request request = new Request.Builder()
                .url("http://10.66.98.61:8080/ssm/android/login")
                .post(formBody)
                .build();
        Response response = null;
        final Call call = client.newCall(request);
        //新建一个线程，用于得到服务器响应的参数
        new Thread(new Runnable() {
            @Override
            public void run() {
                //同步
                try {
                    Response response = call.execute();
                    if(response.isSuccessful()){
                        mHandler.obtainMessage(1, response.body().string()).sendToTarget();
                    } else {
                        throw new IOException("Unexpected code:" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}


