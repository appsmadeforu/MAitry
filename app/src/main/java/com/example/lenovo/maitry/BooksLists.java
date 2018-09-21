package com.example.lenovo.maitry;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BooksLists extends ArrayAdapter<Book> {
    private Activity context;
    private List<Book> bklist;

    public BooksLists(Activity context, List<Book> bklist)
    {
        super(context,R.layout.list_layout,bklist);
       this.context=context;
       this.bklist=bklist;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewitem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewB=listviewitem.findViewById(R.id.textViewBookName);
        TextView textViewp=listviewitem.findViewById(R.id.textView2phone);
        TextView textViewn=listviewitem.findViewById(R.id.textView3uname);
        Book book = bklist.get(position);
        textViewB.setText(book.getBookname());
        textViewn.setText(book.getUname());
        textViewp.setText(book.getPhno());
        return listviewitem;
    }
}
