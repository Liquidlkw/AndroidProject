package com.example.liquid.busstationoutdoorfacilitiesms.Me.usermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mUserRetun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initView();
        init();
    }

    private void init() {

        LinearLayout add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this, AddAccountActivity.class));
            }
        });

        findViewById(R.id.bianji).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this, UserManager.class));
            }
        });


    }

    private void initView() {
        mUserRetun = (ImageView) findViewById(R.id.user_retun);
        mUserRetun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.user_retun:
                finish();
                break;
        }
    }
}
