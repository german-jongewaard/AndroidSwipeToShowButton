package com.jongewaard.dev.androidswipetoshowbutton;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jongewaard.dev.androidswipetoshowbutton.Adapter.MyAdapter;
import com.jongewaard.dev.androidswipetoshowbutton.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Init
        recyclerView = (RecyclerView)findViewById(R.id.recycler_text);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        generateItem();

    }

    private void generateItem() {

        List<Item> itemList = new ArrayList<>();

        for(int i=0; i<50;i++)
        {

            itemList.add(new Item("Pie 0" + (++i),
                    "100,000",
                    "https://images-gmi-pmc.edge-generalmills.com/f4c0a86f-b080-45cd-a8a7-06b63cdb4671.jpg"

                    ));
        }

        adapter = new MyAdapter(this, itemList);
        recyclerView.setAdapter(adapter);


    }
}
