package com.example.testingnavtable.Card_Adapter_Item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingnavtable.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<CardItem> cardItemList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public CardAdapter(List<CardItem> cardItemList) {
        this.cardItemList = cardItemList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_row, parent, false);
        return new CardViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem cardItem = cardItemList.get(position);
        holder.icon.setImageResource(cardItem.getIconResId());
        holder.title.setText(cardItem.getTitle());
        holder.description.setText(cardItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        TextView description;

        public CardViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            icon = itemView.findViewById(R.id.imageicon);
            title = itemView.findViewById(R.id.LanguageName);
            description = itemView.findViewById(R.id.TV_Description);

            // Set the click listener for the item view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
