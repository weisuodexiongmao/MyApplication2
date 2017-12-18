package bwe.com.bawei.leiyumovie.hom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bwe.com.bawei.leiyumovie.R;
import bwe.com.bawei.leiyumovie.hom.bean.Hom_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/14.
 */

public class Rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Hom_Bean hom_bean;
    private Context context;

    public Rlvadapter(Hom_Bean hom_bean, Context context) {
        this.hom_bean = hom_bean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          if (viewType==0){
              return new VHItem1(LayoutInflater.from(context).inflate(R.layout.rlv_item1,parent,false));
          }else {
              return new VHitem2(LayoutInflater.from(context).inflate(R.layout.rlv_item2,parent,false));
          }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     if (position==0){
         VHItem1 vhItem1= (VHItem1) holder;
         List<String>list=new ArrayList<>();
         List<Hom_Bean.RetBean.ListBean.ChildListBean> childList = hom_bean.getRet().getList().get(0).getChildList();
         for (Hom_Bean.RetBean.ListBean.ChildListBean lists:childList) {
             String pic = lists.getPic();
             list.add(pic);
         }
         vhItem1.banner.setImages(list);
         vhItem1.banner.setImageLoader(new ImageLoader() {
             @Override
             public void displayImage(Context context, Object path, ImageView imageView) {
                 Glide.with(context).load(path).into(imageView);
             }
         });
         vhItem1.banner.start();
     }else {
         final Hom_Bean.RetBean.ListBean.ChildListBean childListBean = hom_bean.getRet().getList().get(5).getChildList().get(position);
         VHitem2 vHitem2= (VHitem2) holder;
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onitemclicklisenter.setonitemclick(childListBean);
             }
         });
         vHitem2.simpleDraweeView.setImageURI(hom_bean.getRet().getList().get(5).getChildList().get(position).getPic());
          vHitem2.textView.setText(hom_bean.getRet().getList().get(5).getChildList().get(position).getTitle());
     }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }

    }

    @Override
    public int getItemCount() {
        return hom_bean.getRet().getList().get(5).getChildList().size();
    }
    class VHItem1 extends RecyclerView.ViewHolder{
        Banner banner;
        public VHItem1(View itemView) {
            super(itemView);
            banner= (Banner) itemView.findViewById(R.id.banner);
        }
    }
    class VHitem2 extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView textView;
        public VHitem2(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.sdv);
            textView= (TextView) itemView.findViewById(R.id.title_text);
        }
    }
   public interface Onitemclicklisenter{
       void setonitemclick(Hom_Bean.RetBean.ListBean.ChildListBean childListBean);
   }
   private Onitemclicklisenter onitemclicklisenter;
    public void setOnitemclicklisenter(Onitemclicklisenter onitemclicklisenter){
         this.onitemclicklisenter=onitemclicklisenter;
    }
}
