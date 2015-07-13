package com.microsoft.activitytracker.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.microsoft.activitytracker.Activities.MainActivity;
import com.microsoft.activitytracker.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by JeremyShore on 4/6/15.
 */
public class HistoryAdapter extends CursorAdapter {

    public HistoryAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    private static class ViewHolder {
        CircleImageView imageView;
        TextView title;
        TextView subtitle;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = new ViewHolder();

        View convertView = inflater.inflate(R.layout.twoline_item_layout, parent, false);

        viewHolder.imageView = (CircleImageView) convertView.findViewById(R.id.item_image);
        viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
        viewHolder.subtitle = (TextView) convertView.findViewById(R.id.item_subtitle);

        convertView.setTag(viewHolder);
        return convertView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder)view.getTag();

        Resources resources = context.getResources();
        switch(cursor.getString(MainActivity.COL_LOGICAL_NAME_INDEX)) {
            case "contact":
                viewHolder.imageView.setBackground(resources.getDrawable(R.drawable.contact_circle_background));
//                viewHolder.imageView.setImageResource(R.drawable.ic_record_contact);
                viewHolder.title.setTextColor(resources.getColor(R.color.contact_color));
                break;
        }

        viewHolder.title.setText(cursor.getString(MainActivity.COL_FULL_NAME_INDEX));
    }
}
