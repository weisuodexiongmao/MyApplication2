package bwe.com.bawei.leiyumovie.particulars;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceAPI {
    @GET("videoDetailApi/videoDetail.do")
    Observable<Bean2> getData(@Query("mediaId") String s);
}