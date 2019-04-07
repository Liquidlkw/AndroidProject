package com.example.liquid.busstationoutdoorfacilitiesms.Me.usermanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class AddAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        init();
    }

    private void init() {
         findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });

    }
}
