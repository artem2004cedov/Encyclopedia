package com.example.encyclopedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encyclopedia.R;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DataHolder> {
    private Context context;
    private RecOnClickListener recOnClickListener;
    private List<ListItem> listItemList;

    // получам с MainActivity
    public DateAdapter(Context context, RecOnClickListener recOnClickListener, List<ListItem> listItemList) {
        this.context = context;
        this.recOnClickListener = recOnClickListener;
        this.listItemList = listItemList;
    }

    // ресуем item
    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // храним нарисованый элемент
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new DataHolder(view,recOnClickListener);
    }

    // сюда что хотим загрузить
    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {

    }

    // количитво элементов которыем хотим загрузить
    @Override
    public int getItemCount() {
        // сколько элементов столько итемов
        return listItemList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ImageButton imageButton;

        public DataHolder(@NonNull View itemView, RecOnClickListener recOnClickListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageButton = itemView.findViewById(R.id.imageButton);
        }

        public void setData(ListItem item) {

        }

        @Override
        public void onClick(View view) {

        }
    }
}
