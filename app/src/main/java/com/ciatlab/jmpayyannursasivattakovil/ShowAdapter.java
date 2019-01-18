package com.ciatlab.jmpayyannursasivattakovil;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by ADMIN on 09-05-2018.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {


    private List<Show_class> show_classes;
    private Context context;
    private JSONArray jsonArray;


    public ShowAdapter(List<Show_class> showclass, Context context,JSONArray jsonArray) {
        this.show_classes = showclass;
        this.context = context;
        this.jsonArray=jsonArray;
    }



    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_list,parent,false);
        return new ShowAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ShowAdapter.ViewHolder holder, int position) {
        final Show_class List=show_classes.get(position);
        holder.Txt1.setText(List.getComp());
        holder.Txt2.setText(List.getEmail());
        holder.Txt3.setText(List.getDate());
        Log.e("Jsonfilesssid",""+List.getId());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,ShowComplaint2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID",List.getId());
                intent.putExtra("Complaint",List.getComp());
                intent.putExtra("Email",List.getEmail());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);

            }
        });
        holder.Txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,ShowComplaint2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID",List.getId());
                intent.putExtra("Complaint",List.getComp());
                intent.putExtra("Email",List.getEmail());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);

            }
        });
        holder.Txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,ShowComplaint2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID",List.getId());
                intent.putExtra("Complaint",List.getComp());
                intent.putExtra("Email",List.getEmail());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return show_classes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Txt1,Txt2,Txt3;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            Txt1=(TextView)itemView.findViewById(R.id.txt1);
            Txt2=(TextView)itemView.findViewById(R.id.txt2);
            Txt3=(TextView)itemView.findViewById(R.id.txt3);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.Linear1);

        }
    }
}