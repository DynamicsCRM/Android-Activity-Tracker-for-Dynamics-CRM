package com.microsoft.activitytracker.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.activitytracker.Classes.Utils;
import com.microsoft.activitytracker.R;
import com.google.gson.internal.LinkedTreeMap;
import com.microsoft.xrm.sdk.Entity;
import com.microsoft.xrm.sdk.EntityCollection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jeremy Shore on 8/8/14.
 */
public class ActivitiesAdapter extends BaseAdapter
{
    private EntityCollection mActivities;
    private Context mContext;

    public ActivitiesAdapter(Context context, EntityCollection activities)
    {
        this.mContext = context;
        this.mActivities = activities;
    }

    private static class ViewHolder
    {
        TextView title;
        TextView date;
        ImageView type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final Entity thisActivity = (Entity)getItem(position);
        final ViewHolder thisHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            thisHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.twoline_item_layout, parent, false);

            thisHolder.date = (TextView) convertView.findViewById(R.id.item_subtitle);
            thisHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            thisHolder.type = (ImageView) convertView.findViewById(R.id.item_image);

            convertView.setTag(thisHolder);
        } else {
            thisHolder = (ViewHolder) convertView.getTag();
        }

        Resources resources = mContext.getResources();
        thisHolder.title.setText(thisActivity.get("subject").toString());
        thisHolder.type.setBackground(resources.getDrawable(R.drawable.activity_circle_background));

        if (thisActivity.contains("actualend")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            thisHolder.date.setText(simpleDateFormat.format((Date) thisActivity.get("actualend")));
        }

        switch (thisActivity.getLogicalName()) {
            case "task":
//                thisHolder.type.setImageResource(R.drawable.ic_activity_check);
                break;
            case "appointment":
//                thisHolder.type.setImageResource(R.drawable.ic_activity_appt);
                break;
            case "letter":
//                thisHolder.type.setImageResource(R.drawable.ic_activity_note);
                break;
            case "phonecall":
//                thisHolder.type.setImageResource(R.drawable.ic_activity_phone);
                break;
            default:
//                thisHolder.type.setImageResource(R.drawable.ic_activity_generic);
                break;
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return mActivities.getEntities().size();
    }

    @Override
    public Object getItem(int position) {
        return mActivities.getEntities().get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.twoline_item_layout;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
