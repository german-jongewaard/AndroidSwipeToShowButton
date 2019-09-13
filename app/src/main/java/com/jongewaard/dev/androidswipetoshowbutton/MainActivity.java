package com.jongewaard.dev.androidswipetoshowbutton;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jongewaard.dev.androidswipetoshowbutton.Adapter.MyAdapter;
import com.jongewaard.dev.androidswipetoshowbutton.Helper.MyButtonClickListener;
import com.jongewaard.dev.androidswipetoshowbutton.Helper.MySwipeHelper;
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

        MySwipeHelper swipeHelper = new MySwipeHelper(this, recyclerView, 200) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
                buffer.add(new MyButton(MainActivity.this,
                        "Delete",
                        30,
                        0,
                        Color.parseColor("#FF3c30"),
                        new MyButtonClickListener(){

                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this, "Delete click", Toast.LENGTH_SHORT).show();
                            }
                        }));
                buffer.add(new MyButton(MainActivity.this,
                        "Update",
                        30,
                        R.drawable.ic_edit_24dp,
                        Color.parseColor("#Ff9502"),
                        new MyButtonClickListener(){

                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this, "Update click", Toast.LENGTH_SHORT).show();
                            }
                        }));
            }
        };

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
