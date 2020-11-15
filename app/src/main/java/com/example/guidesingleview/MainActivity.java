package com.example.guidesingleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.happyfresh.showcase.GuideViewSingle;
import com.happyfresh.showcase.config.AlignType;
import com.happyfresh.showcase.config.DismissType;
import com.happyfresh.showcase.listener.GuideListener;

public class MainActivity extends AppCompatActivity {


    Button btn1, btn2;

    private GuideViewSingle mGuideView;
    private GuideViewSingle.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);



        showFirstDialog();


    }
    private void showFirstDialog() {


        builder = new GuideViewSingle.Builder(this)
                .setTitle("مذهبی گردی")
                .setContentText(" از طریق این دکمه ها اماکن مذهبی اطرافت رو  به تفکیک دسته بندی روی نقشه مشاهده کن")
                .setViewAlign(AlignType.center)
                .setTitleGravity(Gravity.RIGHT)
                .setContentGravity(Gravity.RIGHT)
                //    .setButtonGravity(Gravity.RIGHT)
//                .setContentTypeFace(FontUtil.getInstance(getApplicationContext()).getRegularFont())//optional
//                .setTitleTypeFace(FontUtil.getInstance(getApplicationContext()).getRegularFont())//optional

//                .setButtonBackground(getResources().getDrawable(R.drawable.ic_launcher_background))
                .setPaddingTitle(40, 10, 40, 10)
                .setPaddingMessage(40, 10, 40, 10)
                .setPaddingButton(40, 10, 40, 10)

                .setButtonText("تایید")

                .setDismissType(DismissType.anywhere)
                .setTargetView(btn1)

                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {

                        showSecondDialog();
                    }
                });

        mGuideView = builder.build();
        mGuideView.show();
    }

    private void showSecondDialog() {

        builder = new GuideViewSingle.Builder(this)
                .setTitle("مذهبی گردی")
                .setContentText(" نمایش اطلاعات کلید دوم")
                .setViewAlign(AlignType.center)
                .setTitleGravity(Gravity.RIGHT)
                .setContentGravity(Gravity.RIGHT)
                //    .setButtonGravity(Gravity.RIGHT)
//                .setContentTypeFace(FontUtil.getInstance(getApplicationContext()).getRegularFont())//optional
//                .setTitleTypeFace(FontUtil.getInstance(getApplicationContext()).getRegularFont())//optional

                .setPaddingTitle(40, 10, 40, 10)
                .setPaddingMessage(40, 10, 40, 10)
                .setPaddingButton(40, 10, 40, 10)
                .setButtonBackground(getResources().getDrawable(R.drawable.shape))
                .setButtonText("تایید")

                .setDismissType(DismissType.anywhere)
                .setTargetView(btn2)

                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {

//                        showthirdDialog();

                    }
                });

        mGuideView = builder.build();
        mGuideView.show();

    }
}