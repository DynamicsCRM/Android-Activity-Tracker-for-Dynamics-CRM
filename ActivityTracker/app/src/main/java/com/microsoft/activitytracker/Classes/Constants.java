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

public class Constants {
    public static final String ENTITY_ID = "entityId";
    public static final String ENTITY_LOGICAL_NAME = "entityLogicalName";
    public static final String ENTITY_ATTRIBUTES = "entityAttributes";

    public static final String TOKEN = "tokenId";
    public static final String REFRESH_TOKEN = "refreshId";

    public static final String CONTACT_SELECT = "ContactId,FullName,Address1_Line1,Address1_City,Address1_StateOrProvince,Address1_PostalCode,EMailAddress1,JobTitle,Telephone1";
    public static final String ACTIVITY_SELECT = "ActivityId,Subject,ActualEnd,Description,ActivityTypeCode";

    public static final String HEADER_AUTHORIZATION_VALUE_PREFIX = "Bearer ";
    public static final String CLIENT_ID = "1dc3cd16-85f4-449e-9145-98c996ea6a85";
    public static final String REDIRECT_URI = "http://crm.codesamples/";

    public static final String SELECTED_ENTITY = "selectedEntity";

    public static final String ENDPOINT = "currentEndpoint";
    public static final String USERNAME = "currentUsername";
    public static final String AUTHORITY = "currentAuthority";

    public static final String SOAP_ACTION_RETRIEVE_MULTIPLE = "http://schemas.microsoft.com/xrm/2011/Contracts/Services/IOrganizationService/RetrieveMultiple";
    public static final String SOAP_ACTION_EXECUTE = "http://schemas.microsoft.com/xrm/2011/Contracts/Services/IOrganizationService/Execute";

    public static final String DEFAULT_ENDPOINT = "https://codesamples.crm.dynamics.com/";
}