package com.example.dietconsutant_dietician;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends FirebaseRecyclerAdapter<Post, PostAdapter.PostViewHolder> {
    private  Context context;
    public PostAdapter(@NonNull FirebaseRecyclerOptions<Post> options, Context context) {
        super(options);
        this.context=context;
    }



    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, final int position, @NonNull final Post model) {


        holder.name.setText(model.getFood_name());
        holder.c.setText(model.getCarbohydrates());
        holder.f.setText(model.getFats());
        holder.p.setText(model.getProteins());
        holder.cby.setText(model.getConsumed_By());
        holder.csfor.setText(model.getConsumed_For());



        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialog = DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(50,0,50,0)
                        .setContentHolder(new ViewHolder(R.layout.content))

                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();

                View holderView =(ScrollView)dialog.getHolderView();
                final EditText name=holderView.findViewById(R.id.Fname);
                final EditText c=holderView.findViewById(R.id.Fc);
                final EditText f=holderView.findViewById(R.id.fat);
                final EditText p=holderView.findViewById(R.id.Fp);
                final EditText cby=holderView.findViewById(R.id.ch1);
                final EditText csfor=holderView.findViewById(R.id.ch2);


                Button update=holderView.findViewById(R.id.update);

                name.setText(model.getFood_name());
                c.setText(model.getCarbohydrates());
                f.setText(model.getFats());
                p.setText(model.getProteins());
                cby.setText(model.getConsumed_By());
                csfor.setText(model.getConsumed_For());





                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Map<String,Object> map=new HashMap<>();
                        map.put("Food_name",name.getText().toString());
                        map.put("Carbohydrates",c.getText().toString());
                        map.put("Fats",f.getText().toString());
                        map.put("Proteins",p.getText().toString());
                        map.put("Consumed_By",cby.getText().toString());
                        map.put("Consumed_For",csfor.getText().toString());

                        FirebaseDatabase.getInstance().getReference()
                                .child("Food List")
                                .child( getRef(position).getKey())
                                .updateChildren(map)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        dialog.dismiss();

                                    }
                                });
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);
        return new PostViewHolder(view);
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView name, c,f,p,cby,csfor;
        ImageView  edit;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
           name=itemView.findViewById(R.id.name);
            c=itemView.findViewById(R.id.carbo);
            f=itemView.findViewById(R.id.fat);
            p=itemView.findViewById(R.id.pro);
            cby=itemView.findViewById(R.id.by);
            csfor=itemView.findViewById(R.id.cfor);
            edit=itemView.findViewById(R.id.update);

        }
    }
}
