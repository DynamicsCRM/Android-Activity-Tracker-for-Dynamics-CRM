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
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.microsoft.activitytracker.Classes.Entity;
import com.microsoft.activitytracker.R;

import java.util.ArrayList;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class MainItemAdapter extends BaseAdapter implements StickyListHeadersAdapter
{
    private Context mContext;
    private String mHeader;
    private Object mItems;

    public MainItemAdapter(Context context, Object items, String header) {
        this.mContext = context;
        this.mHeader = header;
        this.mItems = items;
    }

    @Override
    public View getHeaderView(int i, View convertView, ViewGroup parent) {
        final HeaderViewHolder thisHolder;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            thisHolder = new HeaderViewHolder();

            convertView = inflater.inflate(R.layout.header_item_layout, parent, false);

            thisHolder.header = (TextView) convertView.findViewById(R.id.header_text);
            thisHolder.headerCard = (CardView) convertView.findViewById(R.id.header_card);

            // store the holder in the tag of this view
            convertView.setTag(thisHolder);
        }
        else
            thisHolder = (HeaderViewHolder) convertView.getTag();

        if (!mHeader.equals("")) {
            thisHolder.header.setText(mHeader);
        }
        else {
            thisHolder.headerCard.setVisibility(View.GONE);
            thisHolder.header.setVisibility(View.GONE);
        }

        return convertView;
    }

    @Override
    public long getHeaderId(int i) {
        return mHeader.hashCode();
    }

    /**
     * use a ViewHolder to store the reference ids for all the items in this items view,
     * this helps the ListView perform MUCH better than if you don't use it. Since you store
     * the layout items and store them in the view tag the system doesn't have to find the view
     * every time the view needs to be repopulated (via recycling or first use)
     */
    private static class ViewHolder {
        RelativeLayout typeBackground;
        ImageView portrait;
        TextView title;
        TextView text;
    }

    /**
     * This view holder is used to store the text for the text item that is used when a string
     * is passed into the adapter. (when there are no recent records in the database)
     */
    private static class TextViewHolder {
        TextView message;
    }

    /**
     * This view holder is used to store the layout items for the sticky headers.
     */
    private static class HeaderViewHolder {
        CardView headerCard;
        TextView header;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final Object thisItem = this.getItem(position);

        if (getItemViewType(position) == 0) {
            final Entity thisEntity = (Entity)thisItem;
            final ViewHolder thisHolder;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                thisHolder = new ViewHolder();

                convertView = inflater.inflate(R.layout.main_item_layout, parent, false);

                thisHolder.typeBackground = (RelativeLayout) convertView.findViewById(R.id.main_image_layout);
                thisHolder.portrait = (ImageView) convertView.findViewById(R.id.itemImage);
                thisHolder.title = (TextView) convertView.findViewById(R.id.itemTitle);
                thisHolder.text = (TextView) convertView.findViewById(R.id.itemText);

                // store the holder in the tag of this view
                convertView.setTag(thisHolder);
            } else
                // pull the view holder from the tag
                thisHolder = (ViewHolder) convertView.getTag();

            thisHolder.title.setText(thisEntity.getAttributeValue("fullname"));

            String jobTitle = thisEntity.getAttributeValue("jobtitle");
            String accountName = thisEntity.getAttributeValue("accountname");
            String stringFormat;

            if (!jobTitle.equals("") && !accountName.equals("")) {
                stringFormat = "%s, %s";
            } else {
                stringFormat = "%s%s";
            }

            thisHolder.text.setText(String.format(stringFormat, accountName, jobTitle));
            Resources resources = mContext.getResources();

            switch (thisEntity.getLogicalname()) {
                case CONTACT:
                    thisHolder.typeBackground.setBackground(resources.getDrawable(R.drawable.contact_image_background));
                    thisHolder.portrait.setImageResource(R.drawable.ic_record_contact);
                    thisHolder.title.setTextColor(resources.getColor(R.color.contact_color));
                    break;
                case OPPORTUNITY:
                    thisHolder.typeBackground.setBackground(resources.getDrawable(R.drawable.opportunity_image_background));
                    thisHolder.portrait.setImageResource(R.drawable.ic_record_opportunity);
                    thisHolder.title.setTextColor(resources.getColor(R.color.opportunity_color));
                    break;
                case ACCOUNT:
                    thisHolder.typeBackground.setBackground(resources.getDrawable(R.drawable.account_image_background));
                    thisHolder.portrait.setImageResource(R.drawable.ic_record_account);
                    thisHolder.title.setTextColor(resources.getColor(R.color.account_color));
                    break;
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
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).getClass() == Entity.class)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount()
    {
        return 2;
    }
}
