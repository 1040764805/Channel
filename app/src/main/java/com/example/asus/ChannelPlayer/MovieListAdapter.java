package com.example.asus.ChannelPlayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Asus on 2019/5/7.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHoler> {



    private Context mContext;
    private OnItemClickListener mListener;

    public MovieListAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }


    @Override
    public MovieViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view,parent,false);
//        MovieViewHoler a= new MovieViewHoler(LayoutInflater.from(mContext).inflate(R.layout.movie_view, parent, false));
        return new MovieViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHoler holder, final int position) {

        String name = ChannelLab.get().getMovie(position);
        holder.bind(name);
        //
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ChannelLab.get().getSize();
    }

    public class MovieViewHoler extends RecyclerView.ViewHolder{

        private TextView movieName;

        public MovieViewHoler(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.channelmovieName);
        }

        public  void  bind(String movieName){
            this.movieName.setText(movieName);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

}
