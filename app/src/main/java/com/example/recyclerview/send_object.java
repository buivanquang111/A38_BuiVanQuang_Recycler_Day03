package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class send_object extends AppCompatActivity {

    EditText etname,etphone;
    Contact contact;
    Button btadd;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_object);

        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        btadd=findViewById(R.id.btadd);

        Intent intent=getIntent();

        contact=(Contact) intent.getSerializableExtra("object");
        etname.setText(contact.getName());
        etphone.setText(contact.getPhone());
        position=intent.getIntExtra("position",100);




        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //contact.setName(etname.getText().toString());
                //contact.setPhone(etphone.getText().toString());

                String name=etname.getText().toString();
                String phone=etphone.getText().toString();
                Intent intent=new Intent(getBaseContext(),MainActivity.class);

                intent.putExtra("etname",name);
                intent.putExtra("etphone",phone);
                intent.putExtra("etposition",position);

                startActivity(intent);
            }
        });
    }
}
