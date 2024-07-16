package com.qzwx.APP.ALLAPPS;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.qzwx.APP.R;
import com.xuexiang.xui.widget.banner.recycler.BannerLayout;
import com.xuexiang.xui.widget.button.roundbutton.RoundButton;
import com.xuexiang.xui.widget.shadow.ShadowButton;

import java.util.Arrays;
import java.util.List;

public class ALLAPPS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_allapps);

        //-----------------按钮点击事件【下】开始--------------------------------------------------------
// 获取按钮
        com.xuexiang.xui.widget.button.shadowbutton.ShadowButton buttonJiSuanQi = findViewById(R.id.btn_JiSuanQi);
        com.xuexiang.xui.widget.button.roundbutton.RoundButton buttonJiZhangBen = findViewById(R.id.btn_JiZhangBen);
        com.xuexiang.xui.widget.button.roundbutton.RoundButton buttonRiJiBen = findViewById(R.id.btn_RiJiBen);
// 设置按钮点击事件
        buttonJiSuanQi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ALLAPPS.this, JiSuanQiActivity.class);
                startActivity(intent);
            }
        });



//        buttonJiZhangBen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ALLAPPS.this, JiZhangBenActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        buttonRiJiBen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ALLAPPS.this, RiJiBenActivity.class);
//                startActivity(intent);
//            }
//        });

//---------------------------按钮点击事件【上】结束-----------------------------------------



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BannerLayout bannerLayout = findViewById(R.id.bl_horizontal);

        List<Integer> images = Arrays.asList(
                R.drawable.tp_lunbotu01,
                R.drawable.tp_lunbotu02,
                R.drawable.tp_lunbotu03
        );

        BannerAdapter bannerAdapter = new BannerAdapter(images);
        bannerLayout.setAdapter(bannerAdapter);
    }




    }
