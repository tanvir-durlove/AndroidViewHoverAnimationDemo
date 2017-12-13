package com.example.td.androidviewhoverdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidviewhover.BlurLayout;

public class MainActivity extends AppCompatActivity {

    Button button;
    private Context mContext;
    private BlurLayout mSampleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BlurLayout.setGlobalDefaultDuration(450);

        mSampleLayout = (BlurLayout) findViewById(R.id.sample);


        View hover = getLayoutInflater().inflate(R.layout.hover_sample, null);
        hover.findViewById(R.id.heart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Tada)
                        .duration(1000)
                        .playOn(v);
                Toast.makeText(MainActivity.this, "Hover done 1", Toast.LENGTH_SHORT).show();
            }
        });

        hover.findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Tada)
                        .duration(1000)
                        .playOn(v);
                Toast.makeText(MainActivity.this, "Hover done 3", Toast.LENGTH_SHORT).show();
            }
        });

        hover.findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Tada)
                        .duration(1000)
                        .playOn(v);
                Toast.makeText(MainActivity.this, "Hover done 2", Toast.LENGTH_SHORT).show();
            }
        });

        mSampleLayout.setHoverView(hover);
        mSampleLayout.setBlurDuration(1000);
        mSampleLayout.addChildAppearAnimator(hover, R.id.heart, Techniques.FlipInX, 550, 0);
        mSampleLayout.addChildAppearAnimator(hover, R.id.share, Techniques.FlipInX, 550, 250);
        mSampleLayout.addChildAppearAnimator(hover, R.id.more, Techniques.FlipInX, 550, 500);

        mSampleLayout.addChildDisappearAnimator(hover, R.id.heart, Techniques.FlipOutX, 550, 500);
        mSampleLayout.addChildDisappearAnimator(hover, R.id.share, Techniques.FlipOutX, 550, 250);
        mSampleLayout.addChildDisappearAnimator(hover, R.id.more, Techniques.FlipOutX, 550, 0);

        mSampleLayout.addChildAppearAnimator(hover, R.id.description, Techniques.FadeInUp);
        mSampleLayout.addChildDisappearAnimator(hover, R.id.description, Techniques.FadeOutDown);

    }
}
