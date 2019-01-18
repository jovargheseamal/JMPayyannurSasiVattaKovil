package com.ciatlab.jmpayyannursasivattakovil;

/**
 * Created by ADMIN on 29-04-2018.
 */


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ADMIN on 28-04-2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<ListClass> Listclass;
    private Context context;


    public MyAdapter(List<ListClass> listclass, Context context) {
        this.Listclass = listclass;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListClass List=Listclass.get(position);
        holder.Txt1.setText(List.getEname());
        holder.Txt2.setText(List.getDesc());
        holder.Txt3.setText(List.getDate());
        Log.e("Jsonfilesssid",""+List.getId());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,Event2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID",List.getId());
                intent.putExtra("Ename",List.getEname());
                intent.putExtra("Desc",List.getDesc());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);

            }
        });
        holder.Txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,Event2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID",List.getId());
                intent.putExtra("Ename",List.getEname());
                intent.putExtra("Desc",List.getDesc());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);

            }
        });
        holder.Txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,Event2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID",List.getId());
                intent.putExtra("Ename",List.getEname());
                intent.putExtra("Desc",List.getDesc());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return Listclass.size();
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
