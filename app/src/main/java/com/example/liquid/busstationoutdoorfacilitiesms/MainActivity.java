package com.example.liquid.busstationoutdoorfacilitiesms;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.liquid.busstationoutdoorfacilitiesms.db.AdDB;
import com.example.liquid.busstationoutdoorfacilitiesms.db.StationDB;
import com.example.liquid.busstationoutdoorfacilitiesms.db.LightTestDB;
import com.example.liquid.busstationoutdoorfacilitiesms.db.MessageDB;
import com.example.liquid.busstationoutdoorfacilitiesms.fragment.HomeFragment;
import com.example.liquid.busstationoutdoorfacilitiesms.fragment.MeFragment;
import com.example.liquid.busstationoutdoorfacilitiesms.fragment.MessageFragment;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout homelayout;
    private LinearLayout messagelayout;
    private LinearLayout nearbyLayout;
    private LinearLayout melayout;
    protected HomeFragment homeFragment = new HomeFragment();
    protected MeFragment meFragment = new MeFragment();
    protected MessageFragment messageFragment = new MessageFragment();
    /*
    消息列表(数据库列表)数据初始化
     */
     public static List<MessageDB> MessageList;
    /*
    检测列表初始化
     */
     private  List<LightTestDB> LightTestList;

    private  List<StationDB> StationTestList;

    private  List<AdDB> AdTestList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //获取Fragment管理类
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_content,homeFragment)
                .add(R.id.container_content,meFragment).hide(meFragment)
                .add(R.id.container_content,messageFragment).hide(messageFragment)

                //Fragment添加  默认：显示首页 其他页面：隐藏
                //提交
                .commit();
        SharedPreferences.Editor editor = getSharedPreferences("data1",MODE_PRIVATE).edit();
        editor.putBoolean("first",false);
        editor.apply();
    }


    private void init() {

        SharedPreferences pref = getSharedPreferences("data1",MODE_PRIVATE);
        Boolean flag=pref.getBoolean("first",true);
            LitePal.getDatabase();//获取数据库

            if(flag) {
                initdb();
            }



        homelayout = findViewById(R.id.menu_home);
        messagelayout = findViewById(R.id.menu_message);
        melayout = findViewById(R.id.menu_me);
        homelayout.setOnClickListener(this);
        messagelayout.setOnClickListener(this);
        melayout.setOnClickListener(this);
    }

    private void initdb() {
        MessageList = new ArrayList<MessageDB>();
       MessageList.add( new MessageDB("清洗","茶汤桥","南向北",
                "","已完成",1,250,"暂时没问题","正常"));

        MessageList.add( new MessageDB("下刊","茶汤桥","南向北",
                "农夫山泉","未接收",2,240,"暂时没问题","正常"));

        MessageList.add( new MessageDB("清洗","七古登","南向北",
                "","已完成",3,150,"暂时没问题","正常"));

        MessageList.add( new MessageDB("上刊","茶汤桥","北向南",
                "哇哈哈","已完成",4,50,"暂时没问题","正常"));

        MessageList.add( new MessageDB("上刊","茶汤桥","北向南",
                "哇哈哈","进行中",5,220,"暂时没问题","正常"));

        MessageList.add( new MessageDB("下刊","七古登","南向北",
                "哇哈哈","进行中",6,240,"暂时没问题","正常"));

        MessageList.add( new MessageDB("下刊","七古登","南向北",
                "农夫山泉","未接收",7,291,"暂时没问题","正常"));

        MessageList.add( new MessageDB("下刊","七古登","南向北",
                "哇哈哈","未接收",8,250,"出现严重异常","异常"));

        for(MessageDB messageDB : MessageList)
        {
            messageDB.save();
        }

        LightTestList = new ArrayList<LightTestDB>();

        LightTestList.add( new LightTestDB("L001","茶汤桥","正常",300,"是","时刻保持干净") );
        LightTestList.add( new LightTestDB("L002","茶汤桥","正常",100,"是","时刻保持干净") );
        LightTestList.add( new LightTestDB("L003","七古登","正常",200,"是","时刻保持干净") );
        LightTestList.add( new LightTestDB("L004","茶汤桥","异常",280,"是","时刻保持干净") );
        LightTestList.add( new LightTestDB("L005","茶汤桥","正常",255,"是","时刻保持干净") );
        LightTestList.add( new LightTestDB("L006","七古登","异常",125,"是","时刻保持干净") );

        for(LightTestDB testDB : LightTestList)
        {
            testDB.save();
        }

        StationTestList = new ArrayList<StationDB>();

        StationTestList.add( new StationDB("S001","茶汤桥","正常",53,"是","每小时更新一次站牌") );
        StationTestList.add( new StationDB("S002","茶汤桥","正常",100,"是","每小时更新一次站牌") );
        StationTestList.add( new StationDB("S003","七古登","正常",69,"是","每小时更新一次站牌") );
        StationTestList.add( new StationDB("S004","茶汤桥","异常",12,"是","每小时更新一次站牌") );
        StationTestList.add( new StationDB("S005","茶汤桥","正常",85,"是","每小时更新一次站牌") );

        for(StationDB testDB : StationTestList)
        {
            testDB.save();
        }

        AdTestList= new ArrayList<AdDB>();

        AdTestList.add( new AdDB("A001","茶汤桥","正常",53,"是","每小时更新一次广告") );
        AdTestList.add( new AdDB("A002","茶汤桥","正常",100,"是","每小时更新一次广告") );
        AdTestList.add( new AdDB("A003","七古登","异常",69,"是","每小时更新一次广告") );
        AdTestList.add( new AdDB("A004","茶汤桥","异常",12,"是","每小时更新一次广告") );
        AdTestList.add( new AdDB("A005","茶汤桥","正常",85,"是","每小时更新一次广告") );
        AdTestList.add( new AdDB("A006","茶汤桥","正常",85,"不是","每小时更新一次广告") );
        AdTestList.add( new AdDB("A007","茶汤桥","正常",85,"是","每小时更新一次广告") );
        AdTestList.add( new AdDB("A008","七古登","正常",85,"是","每小时更新一次广告") );
        for(AdDB testDB : AdTestList)
        {
            testDB.save();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.menu_home: //首页
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(homeFragment)
                        .hide(meFragment)
                        .hide(messageFragment)
                        .commit();
                break;
            case R.id.menu_me:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(meFragment)
                        .hide(homeFragment)
                        .hide(messageFragment)
                        .commit();
                break;
            case R.id.menu_message:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(messageFragment)
                        .hide(meFragment)
                        .hide(homeFragment)
                        .commit();
                break;



        }

    }
}
