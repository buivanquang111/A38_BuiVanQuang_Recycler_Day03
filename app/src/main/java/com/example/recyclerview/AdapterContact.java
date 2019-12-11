package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.Viewhoder> {
    List<Contact> contacts;
    IconClickContact iconClickContact;

    public void setIconClickContact(IconClickContact iconClickContact){
        this.iconClickContact=iconClickContact;
    }
    public  AdapterContact(List<Contact> contacts){
        this.contacts=contacts;
    }
    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_contact,parent,false);

        Viewhoder viewhoder=new Viewhoder(view);
        return viewhoder;
    }

    @NonNull


    @Override
    public void onBindViewHolder(@NonNull AdapterContact.Viewhoder holder, final int position) {
        final  Contact contact=contacts.get(position);

        holder.tvname.setText(contact.getName());
        holder.tvphone.setText(contact.getPhone());

        holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iconClickContact.onClickName(contact.getName());
            }
        });
        holder.tvphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iconClickContact.onClickPhone(contact,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
       TextView tvname,tvphone;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);

            tvname=itemView.findViewById(R.id.tvname);
            tvphone=itemView.findViewById(R.id.tvphone);

        }
    }
}
