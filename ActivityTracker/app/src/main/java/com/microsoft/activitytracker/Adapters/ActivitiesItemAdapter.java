// Android Activity Tracker Sample app for Microsoft Dynamics CRM
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
// MIT License
//
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software
// and associated documentation files (the ""Software""), to deal in the Software without
// restriction, including without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
//    The above copyright notice and this permission notice shall be included in all copies
//    or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
// BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package com.microsoft.activitytracker.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.activitytracker.Classes.Entity;
import com.microsoft.activitytracker.Classes.Utils;
import com.microsoft.activitytracker.R;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class ActivitiesItemAdapter extends BaseAdapter implements StickyListHeadersAdapter
{
    enum ActivityTypeCode
    {
        TASK,
        EMAIL,
        APPOINTMENT,
        LETTER,
        PHONECALL,
        FAX
    }

    private String mHeader;
    private Object mItems;
    private Context mContext;

    public ActivitiesItemAdapter(Context context, Object objects)
    {
        this.mContext = context;
        this.mItems = objects;
        this.mHeader = mContext.getResources().getString(R.string.recent_label);
    }

    private static class ViewHolder
    {
        TextView title;
        TextView date;
        ImageView type;
    }

    /**
     * This view holder is used to store the text for the text item that is used when a string
     * is passed into the adapter.
     */
    private static class TextViewHolder {
        TextView message;
    }

    @Override
    public long getHeaderId(int i) {
        return mHeader.hashCode();
    }

    @Override
    public View getHeaderView(int i, View convertView, ViewGroup parent) {
        final ViewHolder thisHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            thisHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.header_item_layout, parent, false);

            thisHolder.title = (TextView)convertView.findViewById(R.id.header_text);

            convertView.setTag(thisHolder);
        }
        else
            thisHolder = (ViewHolder)convertView.getTag();

        thisHolder.title.setText(mHeader);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final Object thisItem = this.getItem(position);

        if (getItemViewType(position) == 0) {
            final LinkedTreeMap thisActivity = (LinkedTreeMap)thisItem;
            final ViewHolder thisHolder;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                thisHolder = new ViewHolder();

                convertView = inflater.inflate(R.layout.activity_item_layout, parent, false);

                thisHolder.date = (TextView) convertView.findViewById(R.id.activity_date);
                thisHolder.title = (TextView) convertView.findViewById(R.id.activity_title);
                thisHolder.type = (ImageView) convertView.findViewById(R.id.activityImage);

                convertView.setTag(thisHolder);
            } else {
                thisHolder = (ViewHolder) convertView.getTag();
            }

            thisHolder.title.setText(thisActivity.get("Subject").toString());
            thisHolder.date.setText(Utils.getDatefromJsonDate(thisActivity.get("ActualEnd").toString()));

            try {
                switch (ActivityTypeCode.valueOf(thisActivity.get("ActivityTypeCode").toString().toUpperCase())) {
                    case TASK:
                        thisHolder.type.setImageResource(R.drawable.ic_activity_check);
                        break;
                    case APPOINTMENT:
                        thisHolder.type.setImageResource(R.drawable.ic_activity_appt);
                        break;
                    case LETTER:
                        thisHolder.type.setImageResource(R.drawable.ic_activity_note);
                        break;
                    case PHONECALL:
                        thisHolder.type.setImageResource(R.drawable.ic_activity_phone);
                        break;
                    default:
                        thisHolder.type.setImageResource(R.drawable.ic_activity_generic);
                        break;
                }
            }
            catch(IllegalArgumentException ex) {
                Log.d("ItemActivityAdapter", thisActivity.get("ActivityTypeCode").toString() +
                        " not in Activity Enum, setting to generic activity");
                thisHolder.type.setImageResource(R.drawable.ic_activity_generic);
            }
        }
        else {
            final String thisText = thisItem.toString();
            final TextViewHolder thisHolder;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_text_layout, parent, false);

                thisHolder = new TextViewHolder();

                thisHolder.message = (TextView)convertView.findViewById(R.id.message_text);
                convertView.setTag(thisHolder);
            }
            else {
                thisHolder = (TextViewHolder)convertView.getTag();
            }

            thisHolder.message.setText(thisText);
        }


        return convertView;
    }

    @Override
    public int getCount() {
        return ((ArrayList)mItems).size();
    }

    @Override
    public Object getItem(int position)
    {
        return ((ArrayList)mItems).get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).getClass() == LinkedTreeMap.class) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
