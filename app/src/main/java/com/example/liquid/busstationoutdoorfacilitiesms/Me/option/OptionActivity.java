package com.example.liquid.busstationoutdoorfacilitiesms.Me.option;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.liquid.busstationoutdoorfacilitiesms.Me.option.account.AccountActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout five;
    private LinearLayout four;
    private LinearLayout third;
    private LinearLayout second;
    private LinearLayout first;
    private ImageButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        initView();
        init();
    }

    private void init() {
        first = findViewById(R.id.account);
        second = findViewById(R.id.yinsi);
        third = findViewById(R.id.jiben);
        four = findViewById(R.id.news);
        five = findViewById(R.id.suggestion);

        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.account:
                startActivity(new Intent(OptionActivity.this, AccountActivity.class));
                break;
            case R.id.yinsi:
                startActivity(new Intent(OptionActivity.this, YinsiActivity.class));
                break;
            case R.id.jiben:
                startActivity(new Intent(OptionActivity.this, BaseOptionActivity.class));
                break;
            case R.id.news:
                startActivity(new Intent(OptionActivity.this, NewsActivity.class));
                break;
            case R.id.suggestion:
                startActivity(new Intent(OptionActivity.this, SuggestionActivity.class));
                break;
            case R.id.Button:
                finish();
                break;
        }

    }

    private void initView() {
        mButton = (ImageButton) findViewById(R.id.Button);
        mButton.setOnClickListener(this);
    }
}

