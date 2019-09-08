package com.example.dell.it;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonset();
    }

    public void buttonset()
    {
        //open url
        handler_button_pub_url(R.id.button_python, "https://www.python.org/");
        handler_button_pub_url(R.id.button_linux, "https://www.linux.org/");
        handler_button_pub_url(R.id.button_kernel, "https://www.kernel.org/");
//        handler_button_pub_url(R.id.button_testfail, "abb");


        //open application
        handler_button_pub(R.id.button_weather,"com.moji.mjweather","com.moji.mjweather.MainActivity","手机没有安装墨迹天气");
        handler_button_pub(R.id.button_github,"me.majiajie.mygithub","me.majiajie.mygithub.activities.welcome.WelcomeActivity","手机没有安装GitHub");
        handler_button_pub(R.id.button_search,"com.microsoft.bing","com.microsoft.clients.bing.app.MainActivity","手机没有安装必应");
        handler_button_pub(R.id.button_record,"com.miui.notes",
                "com.miui.notes.ui.NotesListActivity",
                "手机未安装记事本");
          handler_button_pub(R.id.button_camera,"com.android.camera",
                  "com.android.camera.Camera",
                  "手机未安装相机");
          handler_button_pub(R.id.button_yingyeting,"com.ct.client",
                  "com.ct.client.SplashActivity",
                  "手机未安装电信营业厅");
           handler_button_pub(R.id.button_weixin,"com.tencent.mm",
                   "com.tencent.mm.ui.LauncherUI",
                  "手机未安装微信");

           handler_button_pub(R.id.button_riji,"com.youdao.note",
                   "com.youdao.note.activity2.SplashActivity",
                  "手机未安装有道云笔记");

           handler_button_pub(R.id.button_caculate,"caculator.bianfl.cn.abccaculator",
                   "caculator.bianfl.cn.abccaculator.activitys.CaculateActivity",
                  "手机未安装计算器");

           handler_button_pub(R.id.button_csdn,"net.csdn.csdnplus",
                   "net.csdn.csdnplus.activity.MainActivity",
                  "手机未安装CSDN");


    }

    public void handler_button_pub(int id, final String pkgname, final String activityname, final String errortip)
    {
        Button btn = (Button)findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pubIntentJump(pkgname,
                        activityname,
                        errortip
                );
            }
        });
    }
    public void handler_button_pub_url(int id, final String surl) {
        Button btn = (Button) findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String texttmp = (String) surl;
                    Uri uri = Uri.parse(texttmp);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
//                MainActivity.this.startActivityForResult(intent, 0x11);
                } catch (Exception e) {
                    Toast toast = Toast.makeText(MainActivity.this, "打开网址失败" + surl, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
    }



    public  void pubIntentJump(String pkgname, String activyname, String iferrtips)
    {
        try {
            ComponentName componentName = new ComponentName(
                    pkgname,
                    activyname);
            Intent intent = new Intent(Intent.ACTION_QUICK_VIEW);
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(componentName);
            startActivity(intent);
//                    startActivityForResult(intent,0x33);
        } catch (Exception e) {
            Toast toast=Toast.makeText(MainActivity.this,iferrtips,Toast.LENGTH_SHORT    );
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 0x11) {
        Toast.makeText(this, "我回来了", Toast.LENGTH_SHORT).show();
//        }
    }
}
