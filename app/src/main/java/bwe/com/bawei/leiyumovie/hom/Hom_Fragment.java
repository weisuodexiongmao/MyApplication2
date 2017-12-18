package bwe.com.bawei.leiyumovie.hom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwe.com.bawei.leiyumovie.R;
import bwe.com.bawei.leiyumovie.hom.adapter.Rlvadapter;
import bwe.com.bawei.leiyumovie.hom.bean.Hom_Bean;
import bwe.com.bawei.leiyumovie.hom.data.Hom_View;
import bwe.com.bawei.leiyumovie.hom.data.Presenter;
import bwe.com.bawei.leiyumovie.particulars.Particulars_activity;

/**
 * Created by 猥琐的熊猫 on 2017/12/14.
 */

public class Hom_Fragment extends Fragment implements Hom_View{

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.hom_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.Rlv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Presenter presenter=new Presenter(this);
        presenter.presen();
        return view;
    }

    @Override
    public void getData(Hom_Bean hom_bean) {
        Rlvadapter rlvadapter = new Rlvadapter(hom_bean, getActivity());
        rlvadapter.setOnitemclicklisenter(new Rlvadapter.Onitemclicklisenter() {
            @Override
            public void setonitemclick(Hom_Bean.RetBean.ListBean.ChildListBean childListBean) {
                Intent intent=new Intent(getActivity(), Particulars_activity.class);
                String dataId = childListBean.getDataId();
                intent.putExtra("id",dataId);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(rlvadapter);
    }
}
