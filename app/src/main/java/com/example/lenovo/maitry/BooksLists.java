package com.example.lenovo.maitry;

import android.app.Activity;
import android.content.Context;
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
                ViewHolder holder = null;


                if (convertView == null) {

                    LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    convertView = vi.inflate(R.layout.list_layout, null);

                    holder = new ViewHolder();

                    holder.Bookname = (TextView) convertView.findViewById(R.id.textViewBookName);

                    holder.Phoneno = (TextView) convertView.findViewById(R.id.textView2phone);

                    holder.PersonNAme = (TextView) convertView.findViewById(R.id.textView3uname);
                    convertView.setTag(holder);

                }
                else {
                    holder = (ViewHolder) convertView.getTag();
                }

                Book book = bklist.get(position);
                holder.Bookname.setText(book.getBookname());
                holder.PersonNAme.setText(book.getUname());
                holder.Phoneno.setText(book.getPhno());
                return convertView;
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

    private class ViewHolder {
        TextView Bookname;
        TextView Phoneno;
        TextView  PersonNAme;
    }
}


