package bwe.com.bawei.leiyumovie.particulars;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.superplayer.library.SuperPlayer;

import java.util.ArrayList;
import java.util.List;

import bwe.com.bawei.leiyumovie.R;
import bwe.com.bawei.leiyumovie.particulars.fragment.synopsis_Fragment;

public class Particulars_activity extends AppCompatActivity implements Particulars_view{

    private String id;
    private SuperPlayer player;
    private ViewPager viewPager;
    private List<Fragment>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars_activity);
        list=new ArrayList<>();
        list.add(new synopsis_Fragment());
        player = (SuperPlayer) findViewById(R.id.Player);
        viewPager = (ViewPager) findViewById(R.id.Vp);

        id = getIntent().getStringExtra("id");
        Log.d("TAG3",id);
        Particulars_Presenter particulars_presenter=new Particulars_Presenter(this);
        particulars_presenter.presen();
        viewPager.setAdapter(new VPfregment(getSupportFragmentManager()));
    }

    @Override
    public void getData(Bean2 bean2) {
        player.play(bean2.getRet().getHDURL());
        player.setScaleType(SuperPlayer.SCALETYPE_FITXY);
        player.setPlayerWH(0,player.getMeasuredHeight());
        player.setTitle(bean2.getRet().getTitle());

    }

    @Override
    public String str() {
        return id;
    }
    class VPfregment extends FragmentPagerAdapter{

        public VPfregment(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
