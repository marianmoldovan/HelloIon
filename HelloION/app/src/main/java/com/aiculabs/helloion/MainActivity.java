package com.aiculabs.helloion;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

public class MainActivity extends Activity {

    private android.widget.EditText editText;
    private android.widget.Button button;
    private android.widget.TextView textView;
    private android.widget.ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.textView = (TextView) findViewById(R.id.textView);
        this.button = (Button) findViewById(R.id.button);
        this.editText = (EditText) findViewById(R.id.editText);
    }

    public void click(View v) {
        if (!TextUtils.isEmpty(editText.getText())) {
            realizarPeticionYParseoYResultado(editText.getText().toString());
        }
    }

    private void realizarPeticion(String s) {
        Ion.with(this, Urls.MD5).setBodyParameter("text", s).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                if (result != null) {
                    textView.setText(result);
                } else if (e != null) {
                    textView.setText(e.getMessage());
                }
            }
        });
    }

    private void realizarPeticionYParseo(String s) {
        Ion.with(this, Urls.MD5).setBodyParameter("text", s).as(MD5.class).setCallback(new FutureCallback<MD5>() {
            @Override
            public void onCompleted(Exception e, MD5 result) {
                if (result != null) {
                    textView.setText(result.getMd5());
                } else if (e != null) {
                    textView.setText(e.getMessage());
                }
            }
        });
    }

    private void realizarPeticionYParseoYResultado(String s) {
        Ion.with(this, Urls.MD5).setBodyParameter("text", s).as(MD5.class).withResponse().setCallback(new FutureCallback<Response<MD5>>() {
            @Override
            public void onCompleted(Exception e, Response<MD5> result) {
                if (result != null && result.getResult() != null) {
                    textView.setText(result.getHeaders().getResponseCode() + "\n" + result.getHeaders().getResponseMessage() + "\n"
                            + result.getResult().getMd5());
                } else if (e != null) {
                    textView.setText(e.getMessage());
                }
            }
        });
    }


}
