package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    Context context;
    List<Tweet> tweets;

    //Pass in the context  and list of tweets
    public TweetsAdapter(Context context,List<Tweet> tweets)
    {
        this.context=context;
        this.tweets=tweets;
    }



    //for each row, inflate a layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_tweet,parent,false);


        return new ViewHolder(view);
    }

    //Bind values based on the positions of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //get data at position
        Tweet tweet=tweets.get(position);

        //bind the tweet at the view holder with the view holder
        holder.bind(tweet);
    }

    //pass in contexts and list of tweet
    @Override
    public int getItemCount() {

        return tweets.size();
    }








    //define a viewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;

        //represents one row of recycler view= one tweet
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ivProfileImage=itemView.findViewById(R.id.ivProfileImage);
            tvBody=itemView.findViewById(R.id.tvBody);
            tvScreenName=itemView.findViewById(R.id.tvScreenName);


        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            Glide.with(context).load(tweet.user.publicImageUrl).into(ivProfileImage);
        }
    }



}
