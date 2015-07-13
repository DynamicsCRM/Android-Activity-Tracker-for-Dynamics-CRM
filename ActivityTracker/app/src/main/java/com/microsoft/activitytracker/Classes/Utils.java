package com.microsoft.activitytracker.Classes;

/**
 * Created by jshore on 3/31/2015.
 */
public class Utils {

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
//                        "<all-attributes /> " +
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
}
