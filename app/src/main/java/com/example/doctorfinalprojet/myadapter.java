package com.example.doctorfinalprojet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class myadapter  extends  RecyclerView.Adapter<myadapter.myviewholder>
{
    private Context context;
    private  ArrayList name_id,contact_id,concer_nid,date_id;

    public myadapter(Context context,ArrayList name_id,ArrayList contactId,ArrayList concernid,ArrayList date) {
        this.context=context;
        this.name_id=name_id;
        this.contact_id=contactId;
        this.concer_nid=concernid;
        this.date_id=date;



    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.contact_id.setText(String.valueOf(contact_id.get(position)));
        holder.concern_id.setText(String.valueOf(concer_nid.get(position)));
        holder.date_id.setText(String.valueOf(date_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView name_id,contact_id,concern_id,date_id;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name_id=itemView.findViewById(R.id.displayname);
            contact_id=itemView.findViewById(R.id.displaycontact);
            concern_id=itemView.findViewById(R.id.displayconcern);
            date_id=itemView.findViewById(R.id.displaydate);
        }
    }
}












/*ArrayList<model>  dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dcontact.setText(dataholder.get(position).getContact());
        holder.demail.setText(dataholder.get(position).getEmail());

    }

    @Override
    public int getItemCount() {

        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView dname,dcontact,demail;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            dname=(TextView) itemView.findViewById(R.id.displayname);
            dcontact=(TextView) itemView.findViewById(R.id.displaycontact);
            demail=(TextView) itemView.findViewById(R.id.displayemail);

        }

    }
    *
 */
