package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.LightDetailActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class FinishActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        intent = new Intent(FinishActivity.this,LightDetailActivity.class);
        Button button = findViewById(R.id.click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

                finish();
            }
        });
    }
}
