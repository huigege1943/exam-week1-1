package com.example.hui.js_with_native;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    private WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setContentView(R.layout.activity_main);
        //实例化WebView对象
        webView = new WebView(this);
        //设置WebView属性，能够执行Javascript脚本
        webView.setWebChromeClient(new WebChromeClient());
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);

        webView.addJavascriptInterface(new JavascriptInterface(), "javascriptInterface");


        Context context = MainActivity.this;
        File file = context.getFilesDir();
        String path = file.getAbsolutePath();
//        System.out.println(path);
        File html = new File(path+"javascript.html");
        if(!html.exists()) {
            try {
                InputStream is = context.getAssets().open("javascript.html");
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                is.close();

                File of = new File(file + "/" + "javascript.html");
                of.createNewFile();
                FileOutputStream os = new FileOutputStream(of);
                os.write(buffer);
                os.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        try {
            //设置打开的页面地址
                webView.loadUrl("file:///android_asset/javascript.html");
//            webView.loadUrl("file://" + getFilesDir() + "/www/" + "javascript.html");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setContentView(webView);

    }

    public class JavascriptInterface {
        @android.webkit.JavascriptInterface
        public void showToast(String toast) {
            if (toast.length()==0){
                Toast.makeText(MainActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
            }
            else {

                Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
