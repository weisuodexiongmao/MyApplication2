package bwe.com.bawei.leiyumovie.particulars.fragment.synopsis_adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import bwe.com.bawei.leiyumovie.R;
import bwe.com.bawei.leiyumovie.particulars.Bean2;

/**
 * Created by 猥琐的熊猫 on 2017/12/18.
 */

public class Rlv2adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Bean2 bean2;
    private Context context;
    public Rlv2adapter(Bean2 bean2, Context context) {
        this.bean2 = bean2;
        this.context = context;
    }
    int i=1;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            return new VHItem(LayoutInflater.from(context).inflate(R.layout.rlv2_item1,parent,false));
        }else {
            return new VHItem2(LayoutInflater.from(context).inflate(R.layout.rlv2_item2,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      if (position==0){
          final VHItem vhItem= (VHItem) holder;
          vhItem.textView1.setText("导演："+bean2.getRet().getDirector());
          vhItem.textView2.setText("主演："+bean2.getRet().getActors());
          vhItem.textView3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                      vhItem.textView3.setVisibility(View.GONE);
                   vhItem.textView123.setVisibility(View.VISIBLE);
                      vhItem.textView4.setVisibility(View.VISIBLE);

              }
          });
          vhItem.textView4.setText("简介："+bean2.getRet().getDescription());
          vhItem.textView123.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  vhItem.textView3.setVisibility(View.VISIBLE);
                  vhItem.textView123.setVisibility(View.GONE);
                  vhItem.textView4.setVisibility(View.GONE);
              }
          });
      }else {
              VHItem2 vhItem2= (VHItem2) holder;
              vhItem2.simpleDraweeView.setImageURI(bean2.getRet().getList().get(0).getChildList().get(position-1).getPic());
              vhItem2.textView5.setText(bean2.getRet().getList().get(0).getChildList().get(position-1).getTitle());

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
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            GridLayoutManager gridLayoutManager= (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type){
                        case 0:
                            return 3;
                        case 1:
                            return 1;
                    }
                    return 0;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return bean2.getRet().getList().get(0).getChildList().size()+1;
    }
    class VHItem extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3,textView4,textView123;
        public VHItem(View itemView) {
            super(itemView);
            textView1= (TextView) itemView.findViewById(R.id.textview1);
            textView2= (TextView) itemView.findViewById(R.id.textview2);
            textView3= (TextView) itemView.findViewById(R.id.textview3);
            textView4= (TextView) itemView.findViewById(R.id.textview4);
            textView123= (TextView) itemView.findViewById(R.id.textView123);
        }
    }
    class VHItem2 extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView textView5;
        public VHItem2(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.Sdv2);
            textView5= (TextView) itemView.findViewById(R.id.textView5);

        }
    }
}
