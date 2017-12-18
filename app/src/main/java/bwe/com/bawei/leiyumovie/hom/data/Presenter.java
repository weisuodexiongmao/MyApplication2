package bwe.com.bawei.leiyumovie.hom.data;

import bwe.com.bawei.leiyumovie.hom.bean.Hom_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/14.
 */

public class Presenter {
    private Hom_View hom_view;
    private Mod mod;
    public Presenter(Hom_View hom_view) {
        this.hom_view = hom_view;
        this.mod=new Mod();
    }
    public void presen(){
        mod.getData(new Mod.Data1() {
            @Override
            public void Data(Hom_Bean hom_bean) {
                hom_view.getData(hom_bean);
            }
        });
    }
}
