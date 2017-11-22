package com.devtolife.vkvideoline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private ModelVideo[] mDataset;
    Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgVideo;
        TextView nameText;
        TextView durationVideo;

        public ViewHolder(View itemView) {
            super(itemView);

            imgVideo = (ImageView) itemView.findViewById(R.id.videoImg);
            nameText = (TextView) itemView.findViewById(R.id.nameText);
            durationVideo = (TextView) itemView.findViewById(R.id.durationText);

        }
    }

    public MyRecyclerAdapter(Context context, ModelVideo[] myDataset) {
        mDataset = myDataset;
        this.context = context;

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.preview_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        Picasso.with(context).load(mDataset[i].getUrlImage()).into(holder.imgVideo);
        holder.nameText.setText(mDataset[i].getName());
        holder.durationVideo.setText(mDataset[i].getTime());

    }


    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
