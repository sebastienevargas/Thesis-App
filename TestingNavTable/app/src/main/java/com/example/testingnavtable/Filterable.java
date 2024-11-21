package com.example.testingnavtable;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.example.testingnavtable.Card_Adapter_Item.CardItem;

import java.util.ArrayList;
import java.util.List;

public interface Filterable {

    public class CardAdapter extends ArrayAdapter<CardItem> implements Filterable {
        private List<CardItem> originalData;
        private List<CardItem> filteredData;

        public CardAdapter(Context context, List<CardItem> data) {
            super(context, android.R.layout.simple_list_item_1, data);
            originalData = data;
            filteredData = data;
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    List<CardItem> results = new ArrayList<>();
                    if (constraint == null || constraint.length() == 0) {
                        results.addAll(filteredData);
                    } else {
                        for (CardItem item : originalData) {
                            if (item.getTitle().toLowerCase().contains(constraint.toString().toLowerCase()) ||
                                    item.getDescription().toLowerCase().contains(constraint.toString().toLowerCase())) {
                                results.add(item);
                            }
                        }
                    }
                    FilterResults filterResults = new FilterResults();
                    filterResults.values = results;
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    filteredData.clear();
                    filteredData.addAll((List<CardItem>) results.values);
                    notifyDataSetChanged();
                }
            };
        }
    }

}
