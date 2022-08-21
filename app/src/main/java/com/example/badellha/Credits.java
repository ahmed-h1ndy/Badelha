package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        String []names=new String[7];
        names[0]="Ahmed Mostafa";
        names[1]="Mohamed Ali";
        names[2]="Ahmed Montasser";
        names[3]="Merna Fakt";
        names[4]="Yehia Magdy";
        names[5]="Mazen Magdy";
        names[6]="Ahmed Shabaan";
        ArrayAdapter<String> names_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        GridView team_members=findViewById(R.id.my_grid);
        team_members.setAdapter(names_adapter);

    }
}