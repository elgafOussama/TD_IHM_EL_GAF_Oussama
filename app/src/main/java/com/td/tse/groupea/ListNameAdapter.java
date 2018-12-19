package com.td.tse.groupea;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListNameAdapter extends RecyclerView.Adapter<ListItemVieuwHolder> {

    private List<String> nameList;
    private final NameItemListener nameItemListener;

    public ListNameAdapter(NameItemListener nameItemListener) {
        this.nameItemListener = nameItemListener;
        this.nameList = new ArrayList<>();

    }

    @NonNull
    @Override
    public ListItemVieuwHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_name,viewGroup,false);
        return new ListItemVieuwHolder(v,this.nameItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemVieuwHolder listItemVieuwHolder, int i) {
        listItemVieuwHolder.setContent(nameList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.nameList.size();
    }


    public void updateData(List<String> nameL){
        this.nameList.clear();
        this.nameList.addAll(nameL);
        notifyDataSetChanged();
    }
}
