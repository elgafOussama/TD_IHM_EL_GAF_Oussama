package com.td.tse.groupea;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListItemVieuwHolder extends RecyclerView.ViewHolder {

    private TextView txtViewName;
    private View viewToRemove;

    private String name;
    public ListItemVieuwHolder(@NonNull final View itemView , final NameItemListener nameItemListener) {
        super(itemView);

        final CardView cardView = itemView.findViewById(R.id.itemCardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameItemListener.onClickItem(name);

            }
        });

        ImageView imageView = itemView.findViewById(R.id.itemImageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameItemListener.onClickCross(name,view);

            }
        });

        this.txtViewName = itemView
                .findViewById(R.id.txt_list_name);

    }
    public void setContent(String name){
        this.name=name;
        txtViewName.setText(name);
    }
}
