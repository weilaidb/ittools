package com.example.dell.it;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        buttonset();
    }


    public void buttonset() {
        //open book
        handler_button_pub(R.id.button_vim, "com.duokan.reader",
                "com.duokan.reader.DkReaderActivity",
                "手机未安装多看");


//        //open url
//        handler_button_pub_url(R.id.button_python, "https://www.python.org/");
////        handler_button_pub_url(R.id.button_testfail, "abb");
//
//
//        //open application
//        handler_button_pub(R.id.button_camera, "com.android.camera",
//                "com.android.camera.Camera",
//                "手机未安装相机");

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
                    Toast toast = Toast.makeText(BookActivity.this, "打开网址失败" + surl, Toast.LENGTH_SHORT);
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
            Toast toast = Toast.makeText(BookActivity.this, iferrtips + e.getMessage(), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }
}
