# Android Activity Tracker Sample App for Microsoft Dynamics CRM

These instructions describe how to build and run the sample Android Activity Tracker application.

## Register the application

Applications that access CRM business data, using the OAuth identity provider of the organization web service, must be registered in Active Directory. For an on-premises/IFD CRM deployment, AD FS 3.0 (or later) is used to register the app. With CRM Online, Microsoft Azure Active Directory is used for app registration. The result of application registration is a client ID value and a redirect URI that must be placed into the sample application's code where indicated in the next section. These values are used in the authentication process to determine whether the app has permission to access the organization's data.

For information on how to register an application, see [Walkthrough: Register a CRM app with Active Directory](https://msdn.microsoft.com/en-us/library/dn531010.aspx).

For internal app testing, you can share a single app registration across multiple apps. An app registration contains a single client ID, but can include multiple redirect URI's. For testing, you can add a redirect URI for each app you are developing. Once you are ready to publish an app to the Apple Store, the app need's its own registration.

## Build the application

If you will be running the app in the Intel HAXM emulator, you will need to set the memory limit the emulator uses to 2048 MB. This is accomplished by installing the emulator with the -m 2048 command parameter.

To build the sample app, follow these steps. **You will need to download (git clone) the [Mobile SDK library](https://github.com/DynamicsCRM/crm-mobilesdk-library-for-android), which is a dependency for this application.**

1. Load the app's project, located in the ActivityTracker folder under the project’s root folder, into Android Studio.
1. Include the Mobile SDK library as a new module by going to **File > Import Module…** and selecting the path to your local crm-mobilesdk-library-for-android/CRMMobileSDK folder. If **Import Module…** is not in the **File** menu, you can locate that action by choosing **Help > Find Actions** and entering “Import Module…” as the action to find. 
2. In the project view, expand app > java > com.microsoft.activitytracker > Classes.
3. Edit the Constants.java file.
4. On line 7 in the code file, change the provided value of `CLIENT_ID` to the client ID value from your app registration.
5. On line 8 in the code file, change the provided value of `REDIRECT_URI` to the redirect URI value from your app registration.
6. Build the application.

## Run the application

On the mobile device where you deployed the app, choose the Activity Tracker app to start it. The following screens show how to access the features of the app.

Page | Visual Navigation | Description
------- | ---- | ----
Server and account | ![Server URL and username](./_images/1A - Server URL.png) | Enter the https:// root address of your CRM server, including the name of your domain, and the username of the logon system user account. If you do not know the URL, you can find it in the CRM web application by navigating to **Settings > Customization > Developer Resources**. An example URL would be: https://mydomain.crm.dynamics.com. Choose **Start Login** to continue.
Logon credentials |![Logon credentials](./_images/2A - Logon.png) | Enter your the system user account password, for the organization that you specified on the previous page, and choose **Sign in**.
Search | ![Search results](./_images/4A - Contact list.png) | The main page is initially blank with no contacts showing. Choose the search icon and enter one or more letters to find all contacts whose full name contain those letters.
Contact details | ![Contact record](./_images/5A - Contact record with activity.png) | From the search results, choose a contact to display the details for that contact. On the details page, you can choose the street address to see that location on a map, the phone number to call the contact, or the email icon to send an email. All activities for that contact are shown below the command bar. Note that only the check mark command is enabled. The other commands are just place holders.
New activity | ![New activity](./_images/6A - Adding an activity.png) | Choose the check mark icon on the details page to create a new activity for the contact. Enter the requested information. Choose the check mark again to save the activity record and return to the details page.
