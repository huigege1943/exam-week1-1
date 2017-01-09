package com.example.hui.js_with_native;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


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
        String path = context.getFilesDir().getPath();
        String urlDownload = "http://123.59.75.85:8080/yhportal/appClientReport/nationalSalesBrief.pdf";

        File pdf = new File(path+"/"+"hello-world.pdf");
        System.out.println(path);
        /*if(pdf.exists())
        {
            pdf.delete();
        }*/
        if (!pdf.exists()){

            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());

            try {
                // 构造URL
                URL url = new URL(urlDownload);
                // 打开连接
                URLConnection con = url.openConnection();
                //获得文件的长度
                int contentLength = con.getContentLength();
                System.out.println("长度 :"+contentLength);

                // 输入流
                InputStream isPdf = con.getInputStream();
                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;

                // 输出的文件流

                pdf.createNewFile();
                FileOutputStream osPdf = new FileOutputStream(pdf);
//

                // 开始读取
                while ((len = isPdf.read(bs)) != -1) {
                    osPdf.write(bs, 0, len);
                }
                // 完毕，关闭所有链接
                osPdf.close();
                isPdf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File html = new File(path + "/" + "javascript.html");
        if(!html.exists()) {
            try {
                InputStream is = context.getAssets().open("javascript.html");
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                is.close();

                File of = new File(path + "/" + "javascript.html");
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
//                webView.loadUrl("file:///android_asset/javascript.html");
                webView.loadUrl("file://" + getFilesDir() + "/" + "javascript.html");
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
            else if(toast.indexOf("pdf") != -1){
                dialog(toast);
            }
            else {
                Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
            }

        }
    }

    protected void dialog(String toast) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(toast);
        builder.setTitle("提示");
        builder.setPositiveButton("确认",
                new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        arg0.dismiss();
                        Intent it = new Intent(MainActivity.this,PdfActivity.class);
                        startActivity(it);
                    }
                });
        builder.setNegativeButton("取消",
                new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}
