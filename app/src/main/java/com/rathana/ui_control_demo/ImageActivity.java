package com.rathana.ui_control_demo;

import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.btnFloating) FloatingActionButton btnChangeImage;
    @BindView(R.id.imageView) ImageView imageView;

    @BindDrawable(R.drawable.facebook)
    Drawable fbDrawable;

    @BindString(R.string.content)
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ButterKnife.bind(this);
        //btnChangeImage=findViewById(R.id.btnFloating);
        //imageView=findViewById(R.id.imageView);

//        btnChangeImage.setOnClickListener(v->{
//            imageView.setImageResource(R.drawable.images_2);
//        });

        Glide.with(this)
                .load("https://i.pinimg.com/236x/66/35/a7/6635a763858c6fdf35d6192755144bf1--giant-pandas-red-pandas.jpg")
                .centerCrop()
                .override(678,897)
                .error(R.drawable.ic_error_outline_black_24dp)
                .placeholder(fbDrawable)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageView);

    }

    @OnClick(R.id.btnFloating)
    public void floatingButtonClick(){
        imageView.setImageResource(R.drawable.images_2);
    }

}
