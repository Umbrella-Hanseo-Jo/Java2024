package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button1.setBackgroundColor(Color.parseColor("#FFEB3B")); // 노란색
        button2.setBackgroundColor(Color.parseColor("#F44336")); // 빨간색
        button3.setBackgroundColor(Color.parseColor("#4CAF50")); // 초록색
        button4.setBackgroundColor(Color.parseColor("#2196F3")); // 파란색

        // 버튼 1 - NAVER.COM으로 이동
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(browserIntent);
            }
        });

        // 버튼 2 - 전체 빨간색 화면 출력
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 현재 액티비티의 배경색을 빨간색으로 설정
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#F44336"));
            }
        });

        // 버튼 3 - 앱 다시 실행
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        // 버튼 4 - 앱 종료
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // 앱을 종료시킴
            }
        });
    }
}
