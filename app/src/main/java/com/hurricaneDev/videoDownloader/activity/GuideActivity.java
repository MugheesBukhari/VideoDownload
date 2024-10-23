/*
 * Copyright (c) 2021.  Hurricane Development Studios
 */

package com.hurricaneDev.videoDownloader.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.sinaseyfi.advancedcardview.AdvancedCardView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.hurricaneDev.videoDownloader.model.GuideModel;
import com.hurricaneDev.videoDownloader.R;
import com.hurricaneDev.videoDownloader.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;



public class GuideActivity extends AppCompatActivity {

    private ViewPager2 pager;
    private AdvancedCardView back;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);

        back = findViewById(R.id.info_back);
        next = findViewById(R.id.info_next);
        ImageView close = findViewById(R.id.close);

        pager = findViewById(R.id.guide_pager);
        DotsIndicator indicator = findViewById(R.id.dots_indicator);

        GuideAdapter adapter = new GuideAdapter(this, getList());
        pager.setAdapter(adapter);

        indicator.setViewPager2(pager);
        pager.registerOnPageChangeCallback(callback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(pager.getCurrentItem() - 1);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(pager.getCurrentItem() + 1);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    ViewPager2.OnPageChangeCallback callback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            switch (position) {
                case 0:
                    back.setVisibility(View.GONE);
                    next.setText("Next");
                    break;
                case 3:
                    next.setText("Got it");
                    break;
                default:
                    back.setVisibility(View.VISIBLE);
                    next.setText("Next");
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pager.unregisterOnPageChangeCallback(callback);
    }

    private List<GuideModel> getList() {
        List<GuideModel> list = new ArrayList<>();
        list.add(new GuideModel("1", "Go to website", R.drawable.info_one));
        list.add(new GuideModel("2", "Play the video", R.drawable.info_two));
        list.add(new GuideModel("3", "Click the download button", R.drawable.info_three));
        list.add(new GuideModel("1", "Go to website", 0));
        return list;
    }

}