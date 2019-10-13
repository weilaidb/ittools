package com.example.dell.it;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {
    private int loop = 0;
    private final int LOOPMAX = 10;

    private int row = 10;
    private int column = 1;

    public class CBtnSets extends AppCompatActivity{
        private Button m_Buttonid;
        private String m_url;
        private String m_pkgname;
        private String m_actname;
        private String m_errtips;

        CBtnSets() {
            m_Buttonid = new Button(this);
            m_Buttonid.setTextSize(11);
            m_Buttonid.setPadding(0,0,0,0);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonset();
        button_toactivity_sets();
    }

    public void buttonset() {
        //open url
        handler_button_pub_url(R.id.button_python, "https://www.python.org/");
        handler_button_pub_url(R.id.button_linux, "https://www.linux.org/");
        handler_button_pub_url(R.id.button_kernel, "https://www.kernel.org/");
        handler_button_pub_url(R.id.button_kernelcode, "https://github.com/torvalds/linux");
        handler_button_pub_url(R.id.button_dataanalysis, "https://www.afenxi.com/");
        handler_button_pub_url(R.id.button_rfc, "https://www.ietf.org/standards/rfcs/");
        handler_button_pub_url(R.id.button_rfc1588, "https://www.rfc-editor.org/info/rfc1588");
        handler_button_pub_url(R.id.button_netmanager, "http://192.168.1.1/");
        handler_button_pub_url(R.id.button_search2, "https://www.baidu.com/");
//        handler_button_pub_url(R.id.button_testfail, "abb");


        //open application
        handler_button_pub(R.id.button_weather, "com.moji.mjweather", "com.moji.mjweather.MainActivity", "手机没有安装墨迹天气");
        handler_button_pub(R.id.button_calendar, "com.android.calendar", "com.android.calendar.homepage.AllInOneActivity", "手机没有安装日历");
        handler_button_pub(R.id.button_github, "me.majiajie.mygithub", "me.majiajie.mygithub.activities.welcome.WelcomeActivity", "手机没有安装GitHub");
        handler_button_pub(R.id.button_search, "com.microsoft.bing", "com.microsoft.clients.bing.app.MainActivity", "手机没有安装必应");
        handler_button_pub(R.id.button_record, "com.miui.notes",
                "com.miui.notes.ui.NotesListActivity",
                "手机未安装记事本");
        handler_button_pub(R.id.button_camera, "com.android.camera",
                "com.android.camera.Camera",
                "手机未安装相机");
        handler_button_pub(R.id.button_yingyeting, "com.ct.client",
                "com.ct.client.SplashActivity",
                "手机未安装电信营业厅");
        handler_button_pub(R.id.button_weixin, "com.tencent.mm",
                "com.tencent.mm.ui.LauncherUI",
                "手机未安装微信");

        handler_button_pub(R.id.button_riji, "com.youdao.note",
                "com.youdao.note.activity2.SplashActivity",
                "手机未安装有道云笔记");

        handler_button_pub(R.id.button_caculate, "caculator.bianfl.cn.abccaculator",
                "caculator.bianfl.cn.abccaculator.activitys.CaculateActivity",
                "手机未安装计算器");

        handler_button_pub(R.id.button_csdn, "net.csdn.csdnplus",
                "net.csdn.csdnplus.activity.MainActivity",
                "手机未安装CSDN");


        handler_button_pub(R.id.button_cidian, "com.kingsoft",
                "com.kingsoft.Main",
                "手机未安装 金山词霸");

        handler_button_pub(R.id.button_haoyangmao, "com.jingdong.app.mall",
                "com.jingdong.app.mall.main.MainActivity",
                "手机未安装 京东");

        handler_button_pub(R.id.button_mailmaster, "com.netease.mail",
                "com.netease.mobimail.activity.LaunchActivity",
                "手机未安装  邮箱大师");

        //自定义的链接
        handler_button_pub_self("TPLINK","com.tplink.cloudrouter",
                "com.tplink.cloudrouter.activity.basesection.InitAppActivity",
                "手机未安装  TPLINK");
//        com.tplink.cloudrouter/com.tplink.cloudrouter.activity.basesection.InitAppActivity

//        handler_button_pub_url_self("百度","http://www.baidu.com");

        handler_button_pub_self("火车票","com.MobileTicket",
                "com.alipay.mobile.quinox.LauncherActivity",
                "手机未安装  12306");
        handler_button_pub_url_self("火车票 h","https://www.12306.cn/index/");
        handler_button_pub_url_self("汽车票","http://www.xn--1lq42ao4e8vmv9fp21byfmg94a9em.com/");
        handler_button_pub_self("嘀嗒出行","com.didapinche.booking",
                "com.didapinche.booking.home.activity.StartActivity",
                "手机未安装  12306");

        //小米
        handler_button_pub_self("遥控器","com.duokan.phone.remotecontroller",
                "com.xiaomi.mitv.phone.remotecontroller.HoriWidgetMainActivityV2",
                "手机未安装  小米遥控器");


        //压缩软件
        handler_button_pub_self("压缩","com.sinaapp.qwwpoo.rar",
                "com.sinaapp.qwwpoo.rar.SplashActivity",
                "手机未安装  压缩软件");

        //我查查
        handler_button_pub_self("我查查","com.wochacha",
                "com.wochacha.StartupActivity",
                "手机未安装  我查查");

        //相册
        handler_button_pub_self("相册","com.miui.gallery",
                "com.miui.gallery.activity.HomePageActivity",
                "手机未安装  相册");


        //相册
        handler_button_pub_self("英语流利说","com.liulishuo.engzo",
                "com.liulishuo.engzo.app.activity.LauncherActivity",
                "手机未安装  英语流利说");


        handler_button_pub_url_self("一些实用的GitHub项目" ,"https://blog.csdn.net/qq_36772866/article/details/102384240");
        handler_button_pub_url_self("JavaGuide" ,"https://github.com/Snailclimb/JavaGuide");
        handler_button_pub_url_self("100-Days-of-ML-Code" ,"https://github.com/Avik-Jain/100-Days-of-ML-Code-Chinese-Version");
        handler_button_pub_url_self("Python-100-Days " ,"https://github.com/jackfrued/Python-100-Days ");
        handler_button_pub_url_self("git-flight-rules" ,"https://github.com/k88hudson/git-flight-rules");
        handler_button_pub_url_self("first-contributions" ,"https://github.com/firstcontributions/first-contributions");
        handler_button_pub_url_self("SQLAdvisor" ,"https://github.com/Meituan-Dianping/SQLAdvisor");
        handler_button_pub_url_self("system-design-primer" ,"https://github.com/donnemartin/system-design-primer");
        handler_button_pub_url_self("Tensorflow " ,"https://github.com/tensorflow/models");
        handler_button_pub_url_self("TensorFlow实现模型" ,"https://github.com/tensorflow/models/blob/master/research");
        handler_button_pub_url_self("TensorFlow教程" ,"https://github.com/tensorflow/models/blob/master/tutorials");
        handler_button_pub_url_self("arthas" ,"https://github.com/alibaba/arthas");
        handler_button_pub_url_self("interviews" ,"https://github.com/kdn251/interviews");
        handler_button_pub_url_self("proxyee-down " ,"https://github.com/proxyee-down-org/proxyee-down");
        handler_button_pub_url_self("incubator-dubbo" ,"https://github.com/apache/incubator-dubbo");
        handler_button_pub_url_self("java-design-patterns " ,"https://github.com/iluwatar/java-design-patterns ");
        handler_button_pub_url_self("elasticsearch" ,"https://github.com/elastic/elasticsearch");

    }



    public void button_toactivity_sets() {

        handler_button_pub(R.id.button_books, "com.duokan.reader",
                "com.duokan.reader.DkReaderActivity",
                "手机未安装多看");

    }

    public void handler_button_pub(int id, final String pkgname, final String activityname, final String errortip) {
        Button btn = (Button) findViewById(id);
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


    public void pubIntentJump(String pkgname, String activyname, String iferrtips) {
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
            Toast toast = Toast.makeText(MainActivity.this, iferrtips, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }


//自定义按钮
    public void handler_button_pub_url_self(final String title, final String surl) {
        Button egbtn = (Button)findViewById(R.id.button_weather);
        Button btn = new Button(this);
        btn.setText(title);
        btn.setTextSize(22);
        btn.setWidth(egbtn.getLayoutParams().width);
        btn.setHeight(egbtn.getLayoutParams().height);
        LinearLayout layout = (LinearLayout)findViewById(R.id.linelayout_main);
        layout.addView(btn);

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

    public void handler_button_pub_self(final String title, final String pkgname, final String activityname, final String errortip) {
        Button egbtn = (Button)findViewById(R.id.button_weather);
        Button btn = new Button(this);
        btn.setText(title);
        btn.setTextSize(22);
        btn.setWidth(egbtn.getLayoutParams().width);
        btn.setHeight(egbtn.getLayoutParams().height);
        LinearLayout layout = (LinearLayout)findViewById(R.id.linelayout_main);
        layout.addView(btn);

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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 0x11) {
        Toast.makeText(this, "我回来了", Toast.LENGTH_SHORT).show();
//        }
    }
}
