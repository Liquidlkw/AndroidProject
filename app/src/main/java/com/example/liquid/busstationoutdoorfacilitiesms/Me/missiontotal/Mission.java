package com.example.liquid.busstationoutdoorfacilitiesms.Me.missiontotal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class Mission extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
        initView();
    }

    private void initView() {
        mButton = (ImageButton) findViewById(R.id.Button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.Button:
                finish();
                break;
        }
    }
}
