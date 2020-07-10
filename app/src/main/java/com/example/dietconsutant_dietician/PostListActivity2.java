package com.example.dietconsutant_dietician;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class PostListActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
  //  private PostAdapter2 adapter2;
    private Adapter adapter;
    private DatabaseReference post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list2);


        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        post=FirebaseDatabase.getInstance().getReference().child("Feedback");
        Query query=post;

        FirebaseRecyclerOptions<Post2> options =
                new FirebaseRecyclerOptions.Builder<Post2>()
                        .setQuery(query,Post2.class)
                        .build();
        adapter=new Adapter(options,this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
