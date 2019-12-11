package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts;
    Contact contact1,contact2,contact3;
    RecyclerView recyclerView;
    AdapterContact adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rvlist);

        contacts = new ArrayList<>();

        contact1 = new Contact("Mr A","0123456789");
        contact2 = new Contact("Mr B","0123456789");
        contact3 = new Contact("Mr C","0123456789");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);

        adapterContact=new AdapterContact(contacts);

        adapterContact.setIconClickContact(new IconClickContact() {
            @Override
            public void onClickName(String name) {
                Toast.makeText(getBaseContext(),name,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onClickPhone(Contact contact, int position) {
                Intent intent=new Intent(getBaseContext(),send_object.class);
                intent.putExtra("object",contact);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterContact);

        Intent intent=getIntent();
        String etname=intent.getStringExtra("etname");
        String etphone=intent.getStringExtra("etphone");
        int i= intent.getIntExtra("etposition",100);
        if(etname!=null && etphone!=null) {
            contacts.get(i).setName(etname);
            contacts.get(i).setPhone(etphone);
        }
    }

}
