package com.example.mylearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class recyclerAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_adapter);

        ArrayList post = new ArrayList<imagePost>();
        post.add(new imagePost("Ini Foto pas aku lagi jalan2 anjeng","Jalan Jalan Kuta",R.drawable.ic_launcher_foreground));
        post.add(new imagePost("Ngapain liat liat kondol","Foto 3D Image",R.drawable.ic_launcher_background));
        post.add(new imagePost("Woy anjeng ini kamar indah gua, seneng lu anjeng","Kamar Indah Surga",R.drawable.ic_launcher_foreground));

        RecyclerView rw = findViewById(R.id.recycleView);
        rw.setAdapter(new ViewHolderAdapter(post));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rw.setLayoutManager(linearLayoutManager);


    }


}


class imagePost{
    private String subTitle;
    private String postTitle;

    int imageResourceId = R.drawable.ic_launcher_foreground;

    public imagePost(String subTitle, String postTitle, int imageResourceId) {
        this.subTitle = subTitle;
        this.postTitle = postTitle;
        this.imageResourceId = imageResourceId;
    }

    public String getSubTitle() {
        return subTitle;
    }


    public String getPostTitle() {
        return postTitle;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    protected ImageView imageView;
    protected TextView smallRecycleView;
    protected TextView bigRecycleView;

    public ViewHolder(@NonNull View itemView){
        super(itemView);

        imageView = itemView.findViewById(R.id.imageRecycle);
        smallRecycleView = itemView.findViewById(R.id.smallRecycle);
        bigRecycleView = itemView.findViewById(R.id.bigRecycle);
    }
}

class ViewHolderAdapter extends RecyclerView.Adapter<ViewHolder>{
    ArrayList<imagePost> posts;

    public ViewHolderAdapter(ArrayList<imagePost> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.menu_recycle,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        imagePost h = posts.get(position);
        holder.bigRecycleView.setText(h.getSubTitle());
        holder.smallRecycleView.setText(h.getPostTitle());

        holder.imageView.setImageResource(h.getImageResourceId());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
