package com.example.liquid.busstationoutdoorfacilitiesms.Me.option.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout eq;
    private LinearLayout safe;
    private LinearLayout pwd;
    private LinearLayout phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        init();
    }

    private void init() {
        phone = findViewById(R.id.changephone);
        pwd = findViewById(R.id.pwd);
        safe = findViewById(R.id.safe);
        eq = findViewById(R.id.equipment);

        phone.setOnClickListener(this);
        pwd.setOnClickListener(this);
        safe.setOnClickListener(this);
        eq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.changephone:
                startActivity(new Intent(AccountActivity.this,ChangeActivity.class));
                break;

            case R.id.pwd:
                startActivity(new Intent(AccountActivity.this,ChangePwd.class));


                break;
            case R.id.safe:

                break;
            case R.id.equipment:

                break;
        }

    }
}
