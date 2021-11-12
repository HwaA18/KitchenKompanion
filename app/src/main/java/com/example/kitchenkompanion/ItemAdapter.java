package com.example.kitchenkompanion;
/* Description: Adapter class for inserting item created in the
 * context view. The list of items is passed in as a parameter to the
 * constructor of this class.
 * Author: Oscar Akakpo Ayewanou
 * Date: 10/21/21
 * */
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

    public ItemAdapter(Context context, ArrayList<Item> list) {

        this.context = context;
        this.lst = list;

    }

    public void addItem(Item item)
    {
        lst.add(item);
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
            holder.expDate = (TextView) convertView.findViewById(R.id.expDate);
            holder.qty = (TextView) convertView.findViewById(R.id.qty);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.name.setText(lst.get(position).getName());
        holder.expDate.setText(lst.get(position).getExp());
        holder.qty.setText(String.valueOf(lst.get(position).getQuantity()));

        return convertView;
    }

    private class ViewHolder {

        protected TextView name, expDate, qty;

    }
}
