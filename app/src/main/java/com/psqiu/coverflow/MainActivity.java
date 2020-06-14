package com.psqiu.coverflow;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.psqiu.coverflow.adapter.ImageAdapter;
import java.util.ArrayList;
import java.util.List;

//更多TV项目资源(如桌面，直播点播，教育，应用市场，文件管理器，设置，酒店应用等)，添加微信：qiupansi
//If you want more TV project resources,such as TvLauncher,TvLive,TvAppStore,TvSettings,TvFileManager,TvEducation,TvHotel,TvMusic,TvRemote and so on，Add me wechat：qiupansi
public class MainActivity extends AppCompatActivity {

    private FancyCoverFlow tvCoverFlow;
    private List<HomeInfo> imageList;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCoverFlow = (FancyCoverFlow) findViewById(R.id.fancyCoverFlow);

        initGallery();
    }

    private void initGallery() {
        tvCoverFlow.setSpacing(-150);

        imageList = getFilmInfo();
        adapter = new ImageAdapter(this, imageList);
        tvCoverFlow.setAdapter(adapter);

        tvCoverFlow.setSelection(5);

        tvCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeInfo info = imageList.get(position % imageList.size());
                showToast(info.getFilmName());
            }
        });
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public static List<HomeInfo> getFilmInfo() {
        List<HomeInfo> filmList = new ArrayList<>();
        filmList.add(new HomeInfo(names[0], null, null, iconIds[0], resIds[0]));
        filmList.add(new HomeInfo(names[1], null, null, iconIds[1], resIds[1]));
        filmList.add(new HomeInfo(names[2], null, null, iconIds[2], resIds[2]));
        filmList.add(new HomeInfo(names[3], null, null, iconIds[3], resIds[3]));
        filmList.add(new HomeInfo(names[4], null, null, iconIds[4], resIds[4]));
        filmList.add(new HomeInfo(names[5], null, null, iconIds[5], resIds[5]));
        filmList.add(new HomeInfo(names[6], null, null, iconIds[6], resIds[6]));
        filmList.add(new HomeInfo(names[7], null, null, iconIds[7], resIds[7]));
        filmList.add(new HomeInfo(names[8], null, null, iconIds[8], resIds[8]));
        filmList.add(new HomeInfo(names[9], null, null, iconIds[9], resIds[9]));
        filmList.add(new HomeInfo(names[10], null, null, iconIds[10], resIds[10]));
        return filmList;
    }

    private static String[] names = new String[]{"西虹市首富", "大话西游", "雷神3", "银河护卫队2",
            "机器人总动员","我不是药神", "红海行动", "无问西东", "一个母亲的复仇", "绿皮书", "何以为家"
    };

    private static int[] iconIds = new int[]{R.mipmap.bg1,R.mipmap.bg2,
            R.mipmap.bg3,R.mipmap.bg4,R.mipmap.bg5, R.mipmap.bg6,
            R.mipmap.bg7, R.mipmap.bg8, R.mipmap.bg9, R.mipmap.bg10, R.mipmap.bg11};

    private static int[] resIds = new int[]{R.mipmap.bg1, R.mipmap.bg2,
            R.mipmap.bg3, R.mipmap.bg4, R.mipmap.bg5,
            R.mipmap.bg6, R.mipmap.bg7, R.mipmap.bg8, R.mipmap.bg9, R.mipmap.bg10, R.mipmap.bg11
    };
}
