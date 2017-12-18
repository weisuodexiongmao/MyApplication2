package bwe.com.bawei.leiyumovie.particulars;

/**
 * Created by 猥琐的熊猫 on 2017/12/18.
 */

public class Particulars_Presenter {
    private Particulars_view view;
    private Particulars_mod mod;
    public Particulars_Presenter(Particulars_view view) {
        this.view = view;
        this.mod=new Particulars_mod();
    }
    public void presen(){
        mod.getData(new Particulars_mod.Data2() {
            @Override
            public void data2(Bean2 bean2) {
                view.getData(bean2);
            }
        },view.str());
    }
}
