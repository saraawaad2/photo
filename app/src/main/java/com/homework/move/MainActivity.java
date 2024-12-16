package com.homework.move;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView image ;
    private TextView score;
    private float x,y ;
    Thread thread;
    int counter=0;
    int levelSpeed=1000 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_main);
            image =findViewById(R.id.emoji);
            score=findViewById(R.id.score);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter++;
                    score.setText(counter+"");
                    levelSpeed-=100;
                    if (counter==10)
                    {  score.setText("you win !");
                        levelSpeed=1000;
                        counter=0;

                    }


                }
            });
            thread=new Thread(()->{
                try {
                    while (true){
                        startMoveImage();
                        Thread.sleep(levelSpeed);
                    }
                } catch (InterruptedException e) {

                }
            });
            thread.start();
        }
        private void startMoveImage(){
            x=(float) Math.random()*800;
            y=(float) Math.random()*1000;
            image.setX(x);
            image.setY(y);
        }
    }