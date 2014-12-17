# Android Activity Tracker Sample app for Microsoft Dynamics CRM #

The activity tracker sample application enables you to connect to your Microsoft Dynamics CRM 2013 organization, query for your contacts, and add a quick activity record related to a contact.  Use this sample’s source code as a starting point to build your own apps that can access the CRM web services. 

## Prerequisites ##
1.  This code sample targets an Android device running API version 18 (or 4.3) and higher
2.  Your CRM deployment must be running CRM 2013 or later.
3.  Your CRM deployment must be set up for OAuth 2.0 authentication.

## Quick Start ##
1. Ensure your Active Directory setup meets the prerequisites listed on [MSDN](http://msdn.microsoft.com/en-us/library/dn531010.aspx).
2. Follow the steps in that article to register the app with Active Directory (ADFS) or Microsoft Azure. If you are using an on-premises CRM deployment, ensure you run the PowerShell commands from the article.
3. Open the “ActivityTracker” folder in Android Studio or other IDE.
4. Modify these two constants in the Constants file using the same values from when you registered the app.

	`public static final string CLIENT_ID = "1dc3cd16-85f4-449e-9145-98c996ea6a85";`

	`public static final string REDIRECT_URI = "http://crm.codesamples/";`

5. Build and run the ActivityTracker application.
6. On the settings screen, enter your CRM organization URL and choose Start Login.  You will be prompted to log in.
7. Log in and start searching for your contacts!

**NOTE:**
Even though you don't see the third party libraries, when you compile Gradle will go and grab those libraries and include them on compile time.

## Microsoft Azure Active Directory Authentication Library (ADAL) for Android ##
This application leverages the ADAL to handle authentication.  This library is available from here:
[https://github.com/AzureAD/azure-activedirectory-library-for-android](https://github.com/AzureAD/azure-activedirectory-library-for-android). A copy of the library is included in this project's aadl folder. The text below provides needed information for your own projects. These recommended changes have already been done for the ActivityTracker project.

The library doesn't appear to be directly compatible with Gradle and Android Studio as provided, so if you want to use this in a new project you will need to import the source into your project. When you do, you will end up with a few errors that you will need to fix. The first of them are the dependencies that are used in the project.

Dependencies are handled in the build.gradle file (inside of the ADAL library). Open up that file and at the bottom you should see a dependencies section where you will want to add in your maven libraries. You can either add them manually or you can try and find them in the project structure menu. A great resource to get the string is [Gradle Please](http://gradleplease.appspot.com/)).

ADAL uses two libraries that you must add. Gson (used for JSON) and the Google Play Services Library. You can add them by using these lines:

`compile 'com.google.android.gms:play-services:+'`

`compile 'com.google.code.gson:gson:+'`

**NOTE:**
The + at the end of the line indicates that it will automatically pull the most recent version of that library to use in the project. This may cause issues so make sure to indicate which version you want if you know exactly what you want.

The last thing you will need to do to get this library working is to make sure you adjust the minimum SDK version, target SDK version, compile SDK version, and build tools version to property aline them with your application. For this sample we set them to:

`compileSdkVersion 18`

`buildToolsVersion "19.1.0"`

`minSdkVersion 14`

`targetSdkVersion 20`

## Core ##
The classes in this folder are responsible for communicating with CRM, and parsing the results. The networking leverages an open source library called Retrofit, and both SOAP and OData endpoint calls can be found in the NetworkCalls class. The parsing (for the SOAP XML) is done in the two other classes, and uses the vtd-xml parsing library.

We've chosen to show examples of communicating with the SOAP and OData endpoints in this sample.  We've done this since the current version of the OData endpoint only supports CRUD and Associate/Disassociate messages. Depending on the needs of your own application, you can choose to interact with one endpoint or the other.

You should register a new app ID with Microsoft Azure AD (for CRM Online) or ADFS (for CRM IFD) and replace these constants with the clientID and redirect URL you choose.  The instructions can be found on [MSDN](http://msdn.microsoft.com/en-us/library/dn531010.aspx).


`public static final string CLIENT_ID = "1dc3cd16-85f4-449e-9145-98c996ea6a85";`

`public static final string REDIRECT_URI = "http://crm.codesamples/";`


### OData Calls ###
- Get contact details
- Get recent activities related to a contact
- Create a new task related to a contact

The OData endpoint is used for these calls to show the ease in which you can get to the required data by using URLs such as `*endpoint*/ContactSet('guid')` and `*endpoint*/ContactSet('guid')/Contact_Tasks`.

### SOAP Calls ###
- Search for contacts
- Complete activity

The SOAP endpoint is used for these calls to show the basics of how to interact with the endpoint.  The complete activity call must be made to the SOAP endpoint as the OData endpoint does not currently support execute calls.

### Storage ###
All of the recent records are stored in a local SQLite Database and it is all handled through the RecentHistorydbHandler class. It contains a method for creating, updating, inserting, deleting, and getting records directly from the database.

Everything else is stored in the Shared Preferences of the application. The keys for each item are in the Constants class, and actually storing or removing the items mostly happens in the ActivityTracker and MainActivity classes.

### XML Parsers ###
There are two parsing classes in the Core folder. Each of them use the vtd-xml parsing library so you can easily get the information you need from the XML. Currently it is set up to pull each item and create a Map using this system:`<a:*Key*>*Value*`

## Objects ##
The Entity object is actually used universally throughout the whole application. Most of the properties for the entity are stored inside of a Map so it dynamically changes based on what is pulled from CRM. This object is also completely set up for bundling so it can be passed between activities.

## Views ##

### Setup View ###
This view is displayed every time a user needs to login. There will be two fields to fill in. One for the endpoint you want to log into, and another for the username you wish to login with. Clicking the Start Login button will bring you to the login page on the browser and automatically fill in your email for you.

### Home View ###
This view allows you to access the records you have recently viewed or search for other records. It uses a single Listview and Adapter to display both the search results and the recent records. In this view the search action is displayed in the actionbar allowing the user to type in a search query, and a logout option allowing the user to return to the setup activity.

### Object Details View ###
This view shows more details about the selected contact including recently completed records. Each piece of information that is available for the current object also launches into the corresponding applications. The phone number will launch the dialer, email the email client, and address into Google Maps. Along with that, you can jump into creating a new activity.

### New Activity View ###
This view allows you to create a completed task related to the selected contact. You can edit the subject, date, and add notes.  Before submitting, the activity is automatically checked to make sure the subject is filled in, and then creates and completes the activity. Once finished, the app will return to the Object Details View and update the completed activities list.

### UI Styling ###
Everything related to UI styling is located in the res folder. The *.xml files located in the drawable files are for most of the custom backgrounds (like the round buttons and the shadows). If there are drawables that are repeated in each folder it is because it is custom tailored for that resolution of screen. Colors are stored in the colors.xml file located in the values file, and changing these will change them where they are used through the whole application. The styles.xml file located in the values folder is used for customizing already existing styles in the application. This is where the text and background for the actionbar are setup. The string.xml file is where all the UI string constants are located so it is easy to get translations for you whole application.
