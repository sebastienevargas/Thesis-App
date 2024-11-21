package com.example.testingnavtable.Navigation_Bottom;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.testingnavtable.Card_Adapter_Item.CardAdapter;
import com.example.testingnavtable.Card_Adapter_Item.CardItem;
import com.example.testingnavtable.Language.C_C_PlusPlus_language;
import com.example.testingnavtable.Language.Css_language;
import com.example.testingnavtable.Language.Html_language;
import com.example.testingnavtable.Language.JAVA_language;
import com.example.testingnavtable.Language.Javascript_language;
import com.example.testingnavtable.Language.Python_language;
import com.example.testingnavtable.Language.SQL_language;
import com.example.testingnavtable.R;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    ArrayList<CardItem> languageNameModels = new ArrayList<>();
    int[] LanguageIcon = {
            R.drawable.cicon, R.drawable.python, R.drawable.sqlicon,
            R.drawable.javaicon, R.drawable.htmlicon, R.drawable.cssicon,
            R.drawable.jsicon
    };

    public FirstFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Initialize RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Call inputLanguage method to populate the data
        inputLanguage();

        // Set Adapter
        CardAdapter adapter = new CardAdapter(languageNameModels);
        recyclerView.setAdapter(adapter);


        C_C_PlusPlus_language CC = new C_C_PlusPlus_language();
        Python_language python = new Python_language();
        SQL_language SQL = new SQL_language();
        JAVA_language JAVA = new JAVA_language();
        Html_language html = new Html_language();
        Css_language Css = new Css_language();
        Javascript_language Javascript = new Javascript_language();

        // Set item click listener
        adapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle click event here
                CardItem clickedItem = languageNameModels.get(position);

                Toast.makeText(getContext(), "Clicked: " + clickedItem.getTitle(), Toast.LENGTH_SHORT).show();
                    if("C/C++".equals(clickedItem.getTitle())){
                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, CC)
                                .commit();
                    } else if ("PYTHON".equals(clickedItem.getTitle())) {
                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, python)
                                .commit();
                    } else if ("SQL".equals(clickedItem.getTitle())) {
                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, SQL)
                                .commit();
                    }else if ("JAVA".equals(clickedItem.getTitle())){
                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, JAVA)
                                .commit();
                    } else if ("HTML".equals(clickedItem.getTitle())) {
                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, html)
                                .commit();
                    } else if ("CSS".equals(clickedItem.getTitle())) {
                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, Css)
                                .commit();
                    }else if ("JAVASCRIPT".equals(clickedItem.getTitle())){
                        requireActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flFragment, Javascript)
                                .commit();
                    }
            }
        });

        return view;
    }


    private void inputLanguage() {
        String[] languageTitle = getResources().getStringArray(R.array.Language_name);
        String[] descriptionTitle = getResources().getStringArray(R.array.language_Description);
        for (int i = 0; i < languageTitle.length; i++) {
            languageNameModels.add(new CardItem(LanguageIcon[i], languageTitle[i], descriptionTitle[i]));
        }
    }

}