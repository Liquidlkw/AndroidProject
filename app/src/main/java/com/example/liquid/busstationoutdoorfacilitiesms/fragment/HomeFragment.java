
package com.example.liquid.busstationoutdoorfacilitiesms.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.CleanActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.NextMissionActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.PreMissionActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.TestingMissionActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.ADActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.EquipMapActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.LightActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.StationActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.information.MissionInforActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout premission;
    private LinearLayout nextlinear;
    private LinearLayout testing;
    private LinearLayout cleanmission;
    private LinearLayout lighttest;
    private LinearLayout adtest;
    private LinearLayout station;
    private LinearLayout equipmap;
    private LinearLayout direction_ongoing;
    private LinearLayout direction_ungoing;
    private LinearLayout direction_finish;
    private LinearLayout brand_ongoing;
    private LinearLayout brand_ungoing;
    private LinearLayout brand_finish;
    private Intent intent ;
    public static  String flag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intent = new Intent(getActivity(), MissionInforActivity.class);
        init();
    }

    private void init() {

        premission = getActivity().findViewById(R.id.premission);
        premission.setOnClickListener(this);

        nextlinear = getActivity().findViewById(R.id.nextmission);
        nextlinear.setOnClickListener(this);

        testing = getActivity().findViewById(R.id.testingmission);
        testing.setOnClickListener(this);

        cleanmission = getActivity().findViewById(R.id.cleanmission);
        cleanmission.setOnClickListener(this);

        lighttest = getActivity().findViewById(R.id.lighttest);
        lighttest.setOnClickListener(this);

        adtest = getActivity().findViewById(R.id.adtest);
        adtest.setOnClickListener(this);

        station = getActivity().findViewById(R.id.stationtest);
        station.setOnClickListener(this);

        equipmap = getActivity().findViewById(R.id.equipmap);
        equipmap.setOnClickListener(this);

        direction_ongoing = getActivity().findViewById(R.id.direction_ongoing);
        direction_ongoing.setOnClickListener(this);

        direction_ungoing = getActivity().findViewById(R.id.direction_ungoing);
        direction_ungoing.setOnClickListener(this);

        direction_finish =getActivity().findViewById(R.id.direction_finish);
        direction_finish.setOnClickListener(this);

        brand_ongoing= getActivity().findViewById(R.id.brand_ongoing);
        brand_ongoing.setOnClickListener(this);

        brand_ungoing= getActivity().findViewById(R.id.brand_ungoing);
        brand_ungoing.setOnClickListener(this);

        brand_finish= getActivity().findViewById(R.id.brand_finish);
        brand_finish.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            //上刊任务
            case R.id.premission:
                startActivity(new Intent(getActivity(),PreMissionActivity.class));
                break;
            //下刊任务
            case R.id.nextmission:
                startActivity(new Intent(getActivity(),NextMissionActivity.class));
                break;
            //监测任务
            case R.id.testingmission:
                startActivity(new Intent(getActivity(),TestingMissionActivity.class));
                break;
            //清洗任务
            case R.id.cleanmission:
                startActivity(new Intent(getActivity(),CleanActivity.class));
                break;
                //灯具监测
            case R.id.lighttest:
                startActivity(new Intent(getActivity(),LightActivity.class));
            break;
            //广告监测
            case R.id.adtest:
                startActivity(new Intent(getActivity(),ADActivity.class));
                break;
            //站牌监测
            case R.id.stationtest:
                startActivity(new Intent(getActivity(),StationActivity.class));
                break;
            //设备地图
            case R.id.equipmap:
                startActivity(new Intent(getActivity(), EquipMapActivity.class));
                break;
            //方向信息已完成
            case R.id.direction_finish:
               flag="方位已完成任务：";
//                intent.putExtra("direction_finish","方位已完成任务：");
                startActivity(intent);
                break;
            //方向信息进行中
            case R.id.direction_ongoing:
                flag="方位进行中任务：";

//                intent.putExtra("direction_ongoing","方位进行中任务：");
                startActivity(intent);
                break;
            //方向信息未接受
            case R.id.direction_ungoing:
                flag="方位未接收任务：";
//                intent.putExtra("direction_ungoing","方位未接收任务：");
                startActivity(intent);
                break;
            //品牌信息进行中
            case R.id.brand_ongoing:
                flag="品牌进行中任务：";
//                intent.putExtra("brand_ongoing","品牌进行中任务：");
                startActivity(intent);
                break;
            //品牌信息未接收
            case R.id.brand_ungoing:
                flag="品牌未接收任务：";

//                intent.putExtra("brand_ungoing","品牌未接收任务：");
//                Toast.makeText(getActivity(), "未接受", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(intent));
                break;
            //品牌信息已完成
            case R.id.brand_finish:
                flag="品牌已完成任务：";
//                intent.putExtra("brand_finish","品牌已完成任务：");
//                Toast.makeText(getActivity(), "已完成", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
        }

    }
}
