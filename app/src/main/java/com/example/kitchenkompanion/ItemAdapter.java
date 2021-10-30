package com.example.kitchenkompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    ArrayList<Item> lst = new ArrayList<>();
    TextView test;



    public ItemAdapter(Context context, ArrayList<Item> list) {

        this.context = context;
        this.lst = list;

    }

    public void addItem(Item item)
    {
        lst.add(item);
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }


    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lst, null, true);


            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.qty = (TextView) convertView.findViewById(R.id.qty);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.name.setText(lst.get(position).getName());
        holder.price.setText(String.valueOf(lst.get(position).getPrice()));
        holder.qty.setText(String.valueOf(lst.get(position).getQuantity()));

        return convertView;
    }

    private class ViewHolder {

        protected TextView name, price, qty;

    }
}
