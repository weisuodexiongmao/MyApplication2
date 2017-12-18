package bwe.com.bawei.leiyumovie.particulars.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwe.com.bawei.leiyumovie.R;
import bwe.com.bawei.leiyumovie.particulars.Bean2;
import bwe.com.bawei.leiyumovie.particulars.Particulars_Presenter;
import bwe.com.bawei.leiyumovie.particulars.Particulars_view;
import bwe.com.bawei.leiyumovie.particulars.fragment.synopsis_adapter.Rlv2adapter;

/**
 * Created by 猥琐的熊猫 on 2017/12/18.
 */

public class synopsis_Fragment extends Fragment implements Particulars_view{

    private RecyclerView recyclerView;
    private String id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.vp_synopsis, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.Rlv2);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        id = getActivity().getIntent().getStringExtra("id");
        Particulars_Presenter particulars_presenter=new Particulars_Presenter(this);
        particulars_presenter.presen();
        return view;
    }


    @Override
    public void getData(Bean2 bean2) {
    recyclerView.setAdapter(new Rlv2adapter(bean2,getActivity()));
    }

    @Override
    public String str() {
        return id;
    }
}
