package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JavascriptInterface(),"appInterface");
    }
    public void loadURL(View view){
        EditText urlEditText = findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        if (url.isEmpty()){
            Toast.makeText(this,"Ingrese una url valida",Toast.LENGTH_SHORT).show();
        }else {
            webView.loadUrl(url);
        }
    }

    private class JavascriptInterface{
        @android.webkit.JavascriptInterface
        public void showToast(String message){

        }
    }
}