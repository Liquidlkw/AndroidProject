package com.example.liquid.busstationoutdoorfacilitiesms.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liquid.busstationoutdoorfacilitiesms.Me.CheckActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Me.Datetotal.DateActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Me.option.OptionActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.Me.homepage.IndexActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Me.missiontotal.Mission;
import com.example.liquid.busstationoutdoorfacilitiesms.Me.usermanagement.UserActivity;

public class MeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ondoing ;
    private LinearLayout undoing ;
    private LinearLayout finish ;

    private LinearLayout user ;
    private LinearLayout date;
    private LinearLayout mission ;

    private ImageView option;
    private TextView indexme;
    private Intent intent;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        return inflater.inflate(R.layout.fragment_me,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intent = new Intent(getActivity(), CheckActivity.class);
        init();

    }

    private void init() {
            ondoing = getActivity().findViewById(R.id.ongoing);
            undoing = getActivity().findViewById(R.id.ungoing);
            finish = getActivity().findViewById(R.id.finish);
            user = getActivity().findViewById(R.id.user);
             date = getActivity().findViewById(R.id.date);
            mission = getActivity().findViewById(R.id.mission);
             option = getActivity().findViewById(R.id.imageView9);
            indexme = getActivity().findViewById(R.id.indexme);

            ondoing.setOnClickListener(this);
            undoing.setOnClickListener(this);
            finish.setOnClickListener(this);
            user.setOnClickListener(this);
            date.setOnClickListener(this);
            mission.setOnClickListener(this);
            option.setOnClickListener(this);
            indexme.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ongoing:
                intent.putExtra("title","进行中任务：");
                startActivity(intent);
                break;

            case R.id.ungoing:
                intent.putExtra("title","未接收任务：");
                startActivity(intent);
                break;

            case R.id.finish:
                intent.putExtra("title","已完成任务：");
                startActivity(intent);
                break;


            case R.id.imageView9:
                Intent intent2 = new Intent(getActivity(),OptionActivity.class);
                startActivity(intent2);

                break;

            case R.id.date:
                Intent intent3 = new Intent(getActivity(),DateActivity.class);
                startActivity(intent3);

                break;


            case R.id.user:

                startActivity(new Intent(getActivity(),UserActivity.class));

                break;

            case R.id.indexme:
                    startActivity(new Intent(getActivity(),IndexActivity.class));

                    break;

            case R.id.mission:
                startActivity(new Intent(getActivity(),Mission.class));

                break;



        }

    }
}
