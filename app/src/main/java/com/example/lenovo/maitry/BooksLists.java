package com.example.lenovo.maitry;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class BooksLists extends ArrayAdapter<Book> {
    private Activity context;
    private List<Book> bklist;
    private List<Book> SubjectListTemp;
    public SubjectDataFilter subjectDataFilter ;
    public BooksLists(Activity context, List<Book> bklist) {
        super(context, R.layout.list_layout, bklist);
        this.context = context;
        this.bklist = bklist;

    }
    @Override
    public Filter getFilter() {

        if (subjectDataFilter == null){

            subjectDataFilter  = new SubjectDataFilter();
        }
        return subjectDataFilter;
    }
    



            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater = context.getLayoutInflater();
                View listviewitem = inflater.inflate(R.layout.list_layout, null, true);
                TextView textViewB = listviewitem.findViewById(R.id.textViewBookName);
                TextView textViewp = listviewitem.findViewById(R.id.textView2phone);
                TextView textViewn = listviewitem.findViewById(R.id.textView3uname);
                Book book = bklist.get(position);
                textViewB.setText(book.getBookname());
                textViewn.setText(book.getUname());
                textViewp.setText(book.getPhno());
                return listviewitem;
            }


    private class SubjectDataFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            charSequence = charSequence.toString().toLowerCase();

            FilterResults filterResults = new FilterResults();

            if (charSequence != null && charSequence.toString().length() > 0) {
                ArrayList<Book> arrayList1 = new ArrayList<Book>();

                for (int i = 0, l = bklist.size(); i < l; i++) {
                    Book subject = bklist.get(i);

                    if (subject.toString().toLowerCase().contains(charSequence))

                        arrayList1.add(subject);
                }
                filterResults.count = arrayList1.size();

                filterResults.values = arrayList1;
            } else {
                synchronized (this) {
                    filterResults.values = bklist;

                    filterResults.count = bklist.size();
                }
            }
            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            SubjectListTemp = (ArrayList<Book>) filterResults.values;

            notifyDataSetChanged();

            clear();

            for (int i = 0, l = SubjectListTemp.size(); i < l; i++)
                add(SubjectListTemp.get(i));

            notifyDataSetInvalidated();
        }
    }
}


