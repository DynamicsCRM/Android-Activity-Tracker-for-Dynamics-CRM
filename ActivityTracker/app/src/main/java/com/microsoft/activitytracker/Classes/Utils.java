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

import android.text.TextUtils;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils
{

    /**
     *
     * @param executeBody pass the xml to add to the execution section of the body message
     * @return the xml to be included in the next body of the network call
     */
    public static String getRequestBodyforExecuteXML(String executeBody)
    {
        return String.format(
                "<s:Envelope xmlns:s='http://schemas.xmlsoap.org/soap/envelope/'>" +
                    "<s:Body>" +
                        "%s" +
                    "</s:Body>" +
                "</s:Envelope>", executeBody);
    }

    /**
     *
     * @param fetchBody the fetch xml you want to include in this network call
     * @return the xml string that is used as the body for network calls to CRM
     */
    public static String getRequestBodyforFetchXML(String fetchBody)
    {
        return String.format(
                "<s:Envelope xmlns:s='http://schemas.xmlsoap.org/soap/envelope/'>" +
                    "<s:Body>" +
                        "<RetrieveMultiple xmlns='http://schemas.microsoft.com/xrm/2011/Contracts/Services' xmlns:i='http://www.w3.org/2001/XMLSchema-instance'>" +
                            "<query i:type='a:FetchExpression' xmlns:a='http://schemas.microsoft.com/xrm/2011/Contracts'>" +
                                "<a:Query>%s</a:Query>" +
                            "</query>" +
                        "</RetrieveMultiple>" +
                    "</s:Body>" +
                "</s:Envelope>", TextUtils.htmlEncode(fetchBody));
    }

    /**
     *
     * @param regardingObjectId the id of the object that you want the recent tasks for
     * @return the fetch string to get all the entities that correspond to this filter
     */
    public static String getRecentTasksFetch(String regardingObjectId)
    {
        return String.format(
                "<fetch mapping='logical' count='5'>" +
                    "<entity name='task'>" +
                        "<attribute name='activityid'/>" +
                        "<attribute name='subject'/>" +
                        "<attribute name='scheduledstart'/>" +
                        "<attribute name='description'/>" +
                        "<order attribute='scheduledstart' descending='true' />" +
                        "<filter type='and'>" +
                            "<condition attribute='regardingobjectid' operator='eq' value='%s' />" +
                        "</filter>" +
                    "</entity>" +
                "</fetch>", regardingObjectId);
    }

    /**
     *
     * @param searchTerm the string you want to search the org's contacts for (by fullname)
     * @return the fetch string to get all the entities that correspond to this filter
     */
    public static String getEscapedContactSearchTermFetch(String searchTerm)
    {
        searchTerm = searchTerm.replace("&", "&amp;");
        searchTerm = searchTerm.replace("'", "&apos;");
        searchTerm = searchTerm.replace("\"", "&quot;");
        searchTerm = searchTerm.replace("<", "&lt;");
        searchTerm = searchTerm.replace(">", "&gt;");
        searchTerm = searchTerm.replace("[", "[[]");

        return String.format(
                "<fetch mapping='logical' count='25'>" +
                    "<entity name='contact'>" +
                        "<attribute name='contactid'/>" +
                        "<attribute name='fullname'/>" +
                        "<attribute name='jobtitle'/>" +
                        "<link-entity name='account' from='accountid' to='parentcustomerid' link-type='outer'>" +
                            "<attribute name='name' alias='accountname' />" +
                        "</link-entity>" +
                        "<filter type='and'>" +
                            "<condition attribute='fullname' operator='like' value='%%%s%%' />" +
                        "</filter>" +
                    "</entity>" +
                "</fetch>", searchTerm);
    }

    /**
     *
     * @param activityId the id of the activity that you want to mark as complete
     * @return the execution string to mark this activity as complete
     */
    public static String getMarkActivityCompleteFetch(String activityId)
    {
        return String.format(
                "<Execute " +
                    "xmlns='http://schemas.microsoft.com/xrm/2011/Contracts/Services' " +
                    "xmlns:i='http://www.w3.org/2001/XMLSchema-instance'>" +

                    "<request i:type='c:SetStateRequest' " +
                        "xmlns:a='http://schemas.microsoft.com/xrm/2011/Contracts' " +
                        "xmlns:c='http://schemas.microsoft.com/crm/2011/Contracts'>" +

                        "<a:Parameters xmlns:b='http://schemas.datacontract.org/2004/07/System.Collections.Generic'>" +
                            "<a:KeyValuePairOfstringanyType>" +
                                "<b:key>EntityMoniker</b:key>" +
                                "<b:value i:type='a:EntityReference'>" +
                                    "<a:Id>%s</a:Id>" +
                                    "<a:LogicalName>task</a:LogicalName>" +
                                    "<a:Name i:nil='true' />" +
                                "</b:value>" +
                            "</a:KeyValuePairOfstringanyType>" +
                            "<a:KeyValuePairOfstringanyType>" +
                                "<b:key>State</b:key>" +
                                "<b:value i:type='a:OptionSetValue'>" +
                                    "<a:Value>1</a:Value>" +
                                "</b:value>" +
                            "</a:KeyValuePairOfstringanyType>" +
                            "<a:KeyValuePairOfstringanyType>" +
                                "<b:key>Status</b:key>" +
                                "<b:value i:type='a:OptionSetValue'>" +
                                    "<a:Value>5</a:Value>" +
                                "</b:value>" +
                            "</a:KeyValuePairOfstringanyType>" +
                        "</a:Parameters>" +
                        "<a:RequestId i:nil='true' />" +
                        "<a:RequestName>SetState</a:RequestName>" +
                    "</request>" +
                "</Execute>", activityId);
    }

    /**
     * Formats the date and then creates a json object using the activity information
     * and returns it in string form to be inserted directly into the body of a request
     * @param subject the string from the subject edittext
     * @param date the date that was entered in the date picker
     * @param notes the string from the notes edittext
     * @return returns the activity in a json string
     */
    public static String getSerializedCheckIn(String subject, Date date, String notes)
    {
        JSONObject checkin = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        try
        {
            checkin.put("Subject", subject);
            checkin.put("ActualEnd", format.format(date));
            checkin.put("Description", notes);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return checkin.toString();
    }

    /**
     * pulls out the integer and converts it to a date. Then returns it in a
     * string format.
     * @param date the string that is returned from the odata call that contains the date
     *             looks something like "/Date(%i)/"
     * @return string with the date formatted like "MM/dd/yyyy"
     */
    public static String getDatefromJsonDate(String date)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String[] split = date.split("[()]");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(split[1]));

        return format.format(calendar.getTime());
    }
}
