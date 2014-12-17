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

package com.microsoft.activitytracker.Classes;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import retrofit.RestAdapter;

public class Entity
{
    public static enum LogicalName {
        CONTACT,
        OPPORTUNITY,
        ACCOUNT
    }

    private String Id;
    private LogicalName logicalname;
    public HashMap<String, Object> attributes = new HashMap<String, Object>();

    public void setId(String id)
    {
        this.Id = id;
    }

    public String getAttributeValue(String key) {
        if (attributes.containsKey(key)) {
            if (this.attributes.get(key) != null) {
                return this.attributes.get(key).toString();
            }
        }

        return "";
    }

    public void setLogicalname(LogicalName logicalname) {
        this.logicalname = logicalname;
    }

    public void setLogicalName(String logicalName) {
        this.logicalname = LogicalName.valueOf(logicalName.toUpperCase());
    }

    public LogicalName getLogicalname()
    {
        return this.logicalname;
    }

    public String getId()
    {
        return this.Id;
    }

    /***
     * This parcels up an object into a bundle allowing it to be added as an extra for an intent
     * so it can be used in the next activity.
     * @return the bundled up object
     */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();

        bundle.putString(Constants.ENTITY_ID, this.Id);
        bundle.putString(Constants.ENTITY_LOGICAL_NAME, this.logicalname.name());
        bundle.putSerializable(Constants.ENTITY_ATTRIBUTES, this.attributes);

        return bundle;
    }

    /***
     * This unparcels an object into the entity object. Use this after you have passed it to
     * the activity and you want to start using it.
     * @param bundle the bundle of the object you want to unbundle
     * @return the object in the same state as it was when it was bundled up
     */
    public static Entity fromBundle(Bundle bundle) {
        Entity newEntity = new Entity();

        newEntity.setId(bundle.getString(Constants.ENTITY_ID));
        newEntity.setLogicalName(bundle.getString(Constants.ENTITY_LOGICAL_NAME));
        newEntity.attributes = (HashMap<String, Object>)bundle.getSerializable(Constants.ENTITY_ATTRIBUTES);

        return newEntity;
    }
}
