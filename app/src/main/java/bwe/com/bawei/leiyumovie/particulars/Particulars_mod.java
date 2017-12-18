package bwe.com.bawei.leiyumovie.particulars;

import bwe.com.bawei.leiyumovie.retrofit_capsulation.Api2;
import bwe.com.bawei.leiyumovie.retrofit_capsulation.RetrofitHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/12/18.
 */

public class Particulars_mod {
public void getData(final Data2 data2,String s){
    ServiceAPI api = RetrofitHelper.getAPI(Api2.url2);
    Observable<Bean2> observable = api.getData(s);
    observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Bean2>() {
                @Override
                public void accept(Bean2 bean2) throws Exception {
                    data2.data2(bean2);
                }
            });
}
public interface Data2{
    void data2(Bean2 bean2);
}
}
