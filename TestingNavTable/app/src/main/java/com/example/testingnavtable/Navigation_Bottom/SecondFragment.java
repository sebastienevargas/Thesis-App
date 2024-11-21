package com.example.testingnavtable.Navigation_Bottom;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.testingnavtable.Card_Adapter_Item.CardItem;
import com.example.testingnavtable.R;

import java.util.ArrayList;


public class SecondFragment extends Fragment {

    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<CardItem> adapter;



    public SecondFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

//        searchView = view.findViewById(R.id.searchView);
//        listView = view.findViewById(R.id.listView);
//
//
//        listView.setAdapter(adapter);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                adapter.getFilter().filter(query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return true;
//            }
//        });
        return view;
    }
}
