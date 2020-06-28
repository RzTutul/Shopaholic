package com.example.ecommerceapp;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapp.adapter.CatagoriesExpandLVAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainCatagoriesFragment extends Fragment {

    int images[]={R.drawable.tshirt6,R.drawable.dresss3,R.drawable.tshirt2,R.drawable.dresss6,R.drawable.household1};
    ExpandableListView expandableListView;
    CatagoriesExpandLVAdapter catagoriesExpandLVAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDatachild;
    int lastExpandablePostion = -1;

    AutoCompleteTextView autoCompleteTextView;

    String productListName[] = {"Sari","Panjabi","SmartPhone","TV","LED TV","Ladies Dress"};
    int foucsKeyboard;
    public MainCatagoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        if (bundle!=null)
        {
            foucsKeyboard = bundle.getInt("key");
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_catagories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expandableListView = view.findViewById(R.id.expandableLV);
        autoCompleteTextView = view.findViewById(R.id.autoCompleteProduct);

        if (foucsKeyboard==1)
        {
            autoCompleteTextView.requestFocus();
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(autoCompleteTextView, InputMethodManager.SHOW_IMPLICIT);

        }


        ArrayAdapter adapter = new ArrayAdapter (getContext(),android.R.layout.simple_expandable_list_item_1,productListName);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);



        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name;
                name = autoCompleteTextView.getText().toString();
                Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH) {
                    //do Whatever you Want to do
                    String name = autoCompleteTextView.getText().toString();
                    Toast.makeText(getActivity(), ""+name, Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });



        PrepareData();

        catagoriesExpandLVAdapter = new CatagoriesExpandLVAdapter(getActivity(),listDataHeader,listDatachild,images);

        expandableListView.setAdapter(catagoriesExpandLVAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandablePostion !=-1 && lastExpandablePostion != groupPosition)
                {
                    expandableListView.collapseGroup(lastExpandablePostion);
                }
                lastExpandablePostion = groupPosition;
            }
        });

    }

    private void PrepareData() {

        String[] headerString = {"Men", "Ladies", "Boys", "Girl", "HouseHold"};


        listDataHeader = new ArrayList<>();
        listDatachild = new HashMap<>();

        for (int i = 0; i < headerString.length; i++) {
            listDataHeader.add(headerString[i]);

            List<String> child = new ArrayList<>();

            if (i == 0) {
                child.add("T-Shart");
                child.add("Pants");
                child.add("Panjabi");
                child.add("Huddi");
                listDatachild.put(listDataHeader.get(i), child);
            }
            if (i == 1) {
                child.add("Tops");
                child.add("Shari");
                child.add("3Pices");
                child.add("Ground");
                listDatachild.put(listDataHeader.get(i), child);
            }
            if (i == 2) {
                child.add("T-Shart");
                child.add("Pants");
                child.add("Panjabi");
                child.add("Huddi");
                listDatachild.put(listDataHeader.get(i), child);
            }
            if (i == 3) {
                child.add("Frogs");
                child.add("Floor Touch");

                listDatachild.put(listDataHeader.get(i), child);
            }
            if (i == 4) {
                child.add("SmartPhone");
                child.add("TV");
                child.add("HeadPhone");
                listDatachild.put(listDataHeader.get(i), child);
            }


        }
    }
}
