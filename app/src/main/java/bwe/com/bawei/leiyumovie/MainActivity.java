package bwe.com.bawei.leiyumovie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import bwe.com.bawei.leiyumovie.hom.Hom_Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.jingxuan_image);
        imageView2 = (ImageView) findViewById(R.id.zhuanti_image);
        imageView3 = (ImageView) findViewById(R.id.faxian_image);
        imageView4 = (ImageView) findViewById(R.id.wode_image);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        substitute(new Hom_Fragment());
    }
    public void substitute(Fragment f){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag,f).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jingxuan_image:
            substitute(new Hom_Fragment());
            break;
        }
    }
}
