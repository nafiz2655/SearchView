package com.example.arrayitemsearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    SearchView searchView;
    My_adapter myAdapter= new My_adapter(arrayList);


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);


        MakeHasmap();

        listView.setAdapter(myAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                fileList(newText);
                return true;
            }
        });



    }


    private void fileList(String newText) {
        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();
        for (HashMap<String, String> detailsItem : arrayList) {
            if (detailsItem.get("name").toLowerCase().contains(newText.toLowerCase())) {
                arrayList1.add(detailsItem);
            }
        }
        if (arrayList1.isEmpty()) {
            Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            myAdapter.setFilteredList(arrayList1);
        }
    }

    private class My_adapter extends BaseAdapter{

        ArrayList<HashMap<String,String>> MyarrayList;

        public My_adapter(ArrayList<HashMap<String, String>> arrayList) {
            this.MyarrayList = arrayList;
        }

        public void setFilteredList(ArrayList<HashMap<String, String>> filteredList) {
            this.MyarrayList = filteredList;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return MyarrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.layout,parent,false);
            TextView textView =view.findViewById(R.id.textView);

            HashMap<String,String> hashMap1 = MyarrayList.get(position);
            String name = hashMap1.get("name");


            textView.setText(name);


            return view;
        }
    }

    private void MakeHasmap() {

        hashMap = new HashMap<>();
        hashMap.put("name","Rakib Hasan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Mahmud Hasan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Arman");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Rahinan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Rohit Ahmed");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","Nafiz Ahmed");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Billal Hamed");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Rohim");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Tasniya khatun");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Rabiya Khatun");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Rohommod Ahmed");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Salma Khatun");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Bidiyar Ahmed");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Sakim Ahmed");
        arrayList.add(hashMap);



    }
}