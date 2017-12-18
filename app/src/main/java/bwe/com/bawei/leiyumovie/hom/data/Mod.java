package bwe.com.bawei.leiyumovie.hom.data;

import bwe.com.bawei.leiyumovie.hom.bean.Hom_Bean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 猥琐的熊猫 on 2017/12/14.
 */

public class Mod {
    public void getData(final Data1 data1){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Dataapi dataapi = retrofit.create(Dataapi.class);
        Flowable<Hom_Bean> flowable = dataapi.getData();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Hom_Bean>() {
                    @Override
                    public void accept(Hom_Bean hom_bean) throws Exception {
                        data1.Data(hom_bean);
                    }
                });
    }
public interface Data1{
    void Data(Hom_Bean hom_bean);
}
}
