package com.microsoft.activitytracker.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.microsoft.activitytracker.R;
import com.microsoft.xrm.sdk.AliasedValue;
import com.microsoft.xrm.sdk.Entity;
import com.microsoft.xrm.sdk.EntityCollection;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchResultsAdapter extends BaseAdapter {
    private Context mContext;
    private EntityCollection mEntities;

    public SearchResultsAdapter(Context context, EntityCollection entityCollection) {
        this.mContext = context;
        this.mEntities = entityCollection;
    }

    /**
     * use a ViewHolder to store the reference ids for all the items in this items view,
     * this helps the ListView perform MUCH better than if you don't use it. Since you store
     * the layout items and store them in the view tag the system doesn't have to find the view
     * every time the view needs to be repopulated (via recycling or first use)
     */
    private static class ViewHolder {
        CircleImageView imageView;
        TextView title;
        TextView subtitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final Entity thisItem = (Entity)this.getItem(position);
        final ViewHolder thisHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            thisHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.twoline_item_layout, parent, false);

            thisHolder.imageView = (CircleImageView) convertView.findViewById(R.id.item_image);
            thisHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            thisHolder.subtitle = (TextView) convertView.findViewById(R.id.item_subtitle);

            convertView.setTag(thisHolder);
        }
        else {
            thisHolder = (ViewHolder) convertView.getTag();
        }

        thisHolder.title.setText(thisItem.get("fullname").toString());

        ArrayList<String> jobAccount = new ArrayList<String>();

        if (thisItem.contains("jobtitle") && !thisItem.get("jobtitle").equals("")) {
            jobAccount.add(thisItem.get("jobtitle").toString());
        }
        if (thisItem.contains("accountname") && !thisItem.get("accountname").equals("")) {
            jobAccount.add(((AliasedValue)thisItem.get("accountname")).getValue().toString());
        }

        thisHolder.subtitle.setText(StringUtils.join(jobAccount.toArray(), ", "));

        Resources resources = mContext.getResources();
        switch(thisItem.getLogicalName()) {
            case "contact":
                thisHolder.imageView.setBackground(resources.getDrawable(R.drawable.contact_circle_background));
//                thisHolder.imageView.setImageResource(R.drawable.ic_record_contact);
                thisHolder.title.setTextColor(resources.getColor(R.color.contact_color));
                break;
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return mEntities.getEntities().size();
    }

    @Override
    public Object getItem(int position) {
        return mEntities.getEntities().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
