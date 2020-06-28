package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapp.R;

import java.util.HashMap;
import java.util.List;

public class CatagoriesExpandLVAdapter extends BaseExpandableListAdapter {


    private Context context;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDatachild;
    int images[];

    public CatagoriesExpandLVAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDatachild,int [] images) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDatachild = listDatachild;
        this.images = images;
    }



    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listDatachild.get(listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listDatachild.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerText = (String) getGroup(groupPosition);

        if(convertView == null)
        {

            try {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                convertView=  inflater.inflate(R.layout.group_layout,null);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        TextView textView = convertView.findViewById(R.id.headerId);
        RelativeLayout imageRL = convertView.findViewById(R.id.backgroundRL);
        textView.setText(headerText);
        imageRL.setBackgroundResource(images[groupPosition]);


        return convertView;

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition,childPosition);

        if(convertView == null)
        {

            try {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                convertView =   inflater.inflate(R.layout.child_layout,null);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TextView textView = convertView.findViewById(R.id.childtxtId);
        textView.setText(childText);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (groupPosition==0)
               {
                   if (childPosition==0)
                   {
                       Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });



        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
