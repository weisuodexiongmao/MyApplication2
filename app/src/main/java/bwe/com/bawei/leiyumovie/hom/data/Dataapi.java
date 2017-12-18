package bwe.com.bawei.leiyumovie.hom.data;

import bwe.com.bawei.leiyumovie.hom.bean.Hom_Bean;
import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by 猥琐的熊猫 on 2017/12/14.
 */

public interface Dataapi {
@GET("homePageApi/homePage.do")
Flowable<Hom_Bean>getData();
}
