package com.ciatlab.jmpayyannursasivattakovil;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by ADMIN on 01-05-2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationClass> notify;
    private Context context;

    public NotificationAdapter(List<NotificationClass> notify, Context context) {
        this.notify = notify;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notify_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final NotificationClass List=notify.get(position);
        holder.Txt1.setText(List.getTitle());
        holder.Txt2.setText(List.getDate());
        holder.Txt3.setText(List.getContent());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Notification2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID", List.getId());
                intent.putExtra("Content",List.getContent());
                intent.putExtra("Title",List.getTitle());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);
            }
        });
        holder.Txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Notification2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID", List.getId());
                intent.putExtra("Content",List.getContent());
                intent.putExtra("Title",List.getTitle());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);
            }
        });
        holder.Txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Clicked"+List.getId(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Notification2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("ID", List.getId());
                intent.putExtra("Content",List.getContent());
                intent.putExtra("Title",List.getTitle());
                intent.putExtra("Date",List.getDate());
                context.getApplicationContext().startActivity(intent);
            }
        });




    }

            @Override
            public int getItemCount() {
                return notify.size();
            }


            public class ViewHolder extends RecyclerView.ViewHolder {
                public TextView Txt1, Txt2, Txt3;
                public LinearLayout linearLayout;

                public ViewHolder(View itemView) {
                    super(itemView);

                    Txt1 = (TextView) itemView.findViewById(R.id.text1);
                    Txt2 = (TextView) itemView.findViewById(R.id.text2);
                    Txt3 = (TextView) itemView.findViewById(R.id.text3);
                    linearLayout = (LinearLayout) itemView.findViewById(R.id.Linearnot1);

                }
            }
        }


