package com.example.admin.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ListAdapter extends BaseAdapter {
        Context context;
        ArrayList<Map<String,String>> al;
public ListAdapter(MainActivity mainActivity, ArrayList<Map<String, String>> arrayList) {
        this.context = mainActivity;
        this.al = arrayList;
        }


@Override
public int getCount() {
        return al.size();
        }

@Override
public Object getItem(int i) {
        return null;
        }

@Override
public long getItemId(int i) {
        return 0;
        }

@Override
public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.dta_list,viewGroup,false);
        TextView textView=view.findViewById(R.id.text1);
        TextView textView1=view.findViewById(R.id.text2);
        textView.setText(al.get(i).get(ExampleDB.Latitude));
        textView1.setText(al.get(i).get(ExampleDB.Longitude));
        return view;
        }

        }