package com.microsoft.activitytracker.Models;//
//  Contact.java
//  Microsoft Xrm Mobile SDK
//
//  Copyright (c) 2015 Microsoft. All rights reserved.
//

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;
import com.microsoft.xrm.sdk.*;


@EntityLogicalNameAttribute("contact")
public class Contact extends Entity {
	
	public static final String EntityLogicalName = "contact";
	public static final int EntityTypeCode = 2;
	
	public Contact() {
		super("contact");
	}

	public static Contact build() {
		return new Contact();
	}

	@AttributeSchemaNameAttribute("ContactId")
	@AttributeLogicalNameAttribute("contactid")
	public UUID getContactId() {
		return this.getAttributeValue("contactid");
	}
	
	@AttributeSchemaNameAttribute("ContactId")
	@AttributeLogicalNameAttribute("contactid")
	public Contact setContactId(UUID value) {
		this.setAttributeValue("contactid", value);
		if (value != null) {
			super.setId(value);
		}
		else {
			super.setId(new UUID(0L, 0L));
		}

		return this;
	}
	
	@Override
	@AttributeSchemaNameAttribute("ContactId")
	@AttributeLogicalNameAttribute("contactid")
	public UUID getId() {
		return super.getId();
	}
	
	@Override
	@AttributeSchemaNameAttribute("ContactId")
	@AttributeLogicalNameAttribute("contactid")
	public void setId(UUID value) {
		this.setContactId(value);
	}
	

	@AttributeSchemaNameAttribute("AccountId")
	@AttributeLogicalNameAttribute("accountid")
	public EntityReference getAccountId() {
		return this.getAttributeValue("accountid");
	}
	
	@AttributeSchemaNameAttribute("AccountId")
	@AttributeLogicalNameAttribute("accountid")
	public Contact setAccountId(EntityReference value) {
		this.setAttributeValue("accountid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("AccountIdName")
	@AttributeLogicalNameAttribute("accountidname")
	public String getAccountIdName() {
		return this.getAttributeValue("accountidname");
	}
	
	@AttributeSchemaNameAttribute("AccountIdName")
	@AttributeLogicalNameAttribute("accountidname")
	public Contact setAccountIdName(String value) {
		this.setAttributeValue("accountidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("AccountIdYomiName")
	@AttributeLogicalNameAttribute("accountidyominame")
	public String getAccountIdYomiName() {
		return this.getAttributeValue("accountidyominame");
	}
	
	@AttributeSchemaNameAttribute("AccountIdYomiName")
	@AttributeLogicalNameAttribute("accountidyominame")
	public Contact setAccountIdYomiName(String value) {
		this.setAttributeValue("accountidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("AccountRoleCode")
	@AttributeLogicalNameAttribute("accountrolecode")
	public OptionSetValue getAccountRoleCode() {
		return this.getAttributeValue("accountrolecode");
	}
	
	@AttributeSchemaNameAttribute("AccountRoleCode")
	@AttributeLogicalNameAttribute("accountrolecode")
	public Contact setAccountRoleCode(OptionSetValue value) {
		this.setAttributeValue("accountrolecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_AddressId")
	@AttributeLogicalNameAttribute("address1_addressid")
	public UUID getAddress1_AddressId() {
		return this.getAttributeValue("address1_addressid");
	}
	
	@AttributeSchemaNameAttribute("Address1_AddressId")
	@AttributeLogicalNameAttribute("address1_addressid")
	public Contact setAddress1_AddressId(UUID value) {
		this.setAttributeValue("address1_addressid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_AddressTypeCode")
	@AttributeLogicalNameAttribute("address1_addresstypecode")
	public OptionSetValue getAddress1_AddressTypeCode() {
		return this.getAttributeValue("address1_addresstypecode");
	}
	
	@AttributeSchemaNameAttribute("Address1_AddressTypeCode")
	@AttributeLogicalNameAttribute("address1_addresstypecode")
	public Contact setAddress1_AddressTypeCode(OptionSetValue value) {
		this.setAttributeValue("address1_addresstypecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_City")
	@AttributeLogicalNameAttribute("address1_city")
	public String getAddress1_City() {
		return this.getAttributeValue("address1_city");
	}
	
	@AttributeSchemaNameAttribute("Address1_City")
	@AttributeLogicalNameAttribute("address1_city")
	public Contact setAddress1_City(String value) {
		this.setAttributeValue("address1_city", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Composite")
	@AttributeLogicalNameAttribute("address1_composite")
	public String getAddress1_Composite() {
		return this.getAttributeValue("address1_composite");
	}
	
	@AttributeSchemaNameAttribute("Address1_Composite")
	@AttributeLogicalNameAttribute("address1_composite")
	public Contact setAddress1_Composite(String value) {
		this.setAttributeValue("address1_composite", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Country")
	@AttributeLogicalNameAttribute("address1_country")
	public String getAddress1_Country() {
		return this.getAttributeValue("address1_country");
	}
	
	@AttributeSchemaNameAttribute("Address1_Country")
	@AttributeLogicalNameAttribute("address1_country")
	public Contact setAddress1_Country(String value) {
		this.setAttributeValue("address1_country", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_County")
	@AttributeLogicalNameAttribute("address1_county")
	public String getAddress1_County() {
		return this.getAttributeValue("address1_county");
	}
	
	@AttributeSchemaNameAttribute("Address1_County")
	@AttributeLogicalNameAttribute("address1_county")
	public Contact setAddress1_County(String value) {
		this.setAttributeValue("address1_county", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Fax")
	@AttributeLogicalNameAttribute("address1_fax")
	public String getAddress1_Fax() {
		return this.getAttributeValue("address1_fax");
	}
	
	@AttributeSchemaNameAttribute("Address1_Fax")
	@AttributeLogicalNameAttribute("address1_fax")
	public Contact setAddress1_Fax(String value) {
		this.setAttributeValue("address1_fax", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_FreightTermsCode")
	@AttributeLogicalNameAttribute("address1_freighttermscode")
	public OptionSetValue getAddress1_FreightTermsCode() {
		return this.getAttributeValue("address1_freighttermscode");
	}
	
	@AttributeSchemaNameAttribute("Address1_FreightTermsCode")
	@AttributeLogicalNameAttribute("address1_freighttermscode")
	public Contact setAddress1_FreightTermsCode(OptionSetValue value) {
		this.setAttributeValue("address1_freighttermscode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Latitude")
	@AttributeLogicalNameAttribute("address1_latitude")
	public double getAddress1_Latitude() {
		return this.getAttributeValue("address1_latitude");
	}
	
	@AttributeSchemaNameAttribute("Address1_Latitude")
	@AttributeLogicalNameAttribute("address1_latitude")
	public Contact setAddress1_Latitude(double value) {
		this.setAttributeValue("address1_latitude", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Line1")
	@AttributeLogicalNameAttribute("address1_line1")
	public String getAddress1_Line1() {
		return this.getAttributeValue("address1_line1");
	}
	
	@AttributeSchemaNameAttribute("Address1_Line1")
	@AttributeLogicalNameAttribute("address1_line1")
	public Contact setAddress1_Line1(String value) {
		this.setAttributeValue("address1_line1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Line2")
	@AttributeLogicalNameAttribute("address1_line2")
	public String getAddress1_Line2() {
		return this.getAttributeValue("address1_line2");
	}
	
	@AttributeSchemaNameAttribute("Address1_Line2")
	@AttributeLogicalNameAttribute("address1_line2")
	public Contact setAddress1_Line2(String value) {
		this.setAttributeValue("address1_line2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Line3")
	@AttributeLogicalNameAttribute("address1_line3")
	public String getAddress1_Line3() {
		return this.getAttributeValue("address1_line3");
	}
	
	@AttributeSchemaNameAttribute("Address1_Line3")
	@AttributeLogicalNameAttribute("address1_line3")
	public Contact setAddress1_Line3(String value) {
		this.setAttributeValue("address1_line3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Longitude")
	@AttributeLogicalNameAttribute("address1_longitude")
	public double getAddress1_Longitude() {
		return this.getAttributeValue("address1_longitude");
	}
	
	@AttributeSchemaNameAttribute("Address1_Longitude")
	@AttributeLogicalNameAttribute("address1_longitude")
	public Contact setAddress1_Longitude(double value) {
		this.setAttributeValue("address1_longitude", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Name")
	@AttributeLogicalNameAttribute("address1_name")
	public String getAddress1_Name() {
		return this.getAttributeValue("address1_name");
	}
	
	@AttributeSchemaNameAttribute("Address1_Name")
	@AttributeLogicalNameAttribute("address1_name")
	public Contact setAddress1_Name(String value) {
		this.setAttributeValue("address1_name", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_PostalCode")
	@AttributeLogicalNameAttribute("address1_postalcode")
	public String getAddress1_PostalCode() {
		return this.getAttributeValue("address1_postalcode");
	}
	
	@AttributeSchemaNameAttribute("Address1_PostalCode")
	@AttributeLogicalNameAttribute("address1_postalcode")
	public Contact setAddress1_PostalCode(String value) {
		this.setAttributeValue("address1_postalcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_PostOfficeBox")
	@AttributeLogicalNameAttribute("address1_postofficebox")
	public String getAddress1_PostOfficeBox() {
		return this.getAttributeValue("address1_postofficebox");
	}
	
	@AttributeSchemaNameAttribute("Address1_PostOfficeBox")
	@AttributeLogicalNameAttribute("address1_postofficebox")
	public Contact setAddress1_PostOfficeBox(String value) {
		this.setAttributeValue("address1_postofficebox", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_PrimaryContactName")
	@AttributeLogicalNameAttribute("address1_primarycontactname")
	public String getAddress1_PrimaryContactName() {
		return this.getAttributeValue("address1_primarycontactname");
	}
	
	@AttributeSchemaNameAttribute("Address1_PrimaryContactName")
	@AttributeLogicalNameAttribute("address1_primarycontactname")
	public Contact setAddress1_PrimaryContactName(String value) {
		this.setAttributeValue("address1_primarycontactname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_ShippingMethodCode")
	@AttributeLogicalNameAttribute("address1_shippingmethodcode")
	public OptionSetValue getAddress1_ShippingMethodCode() {
		return this.getAttributeValue("address1_shippingmethodcode");
	}
	
	@AttributeSchemaNameAttribute("Address1_ShippingMethodCode")
	@AttributeLogicalNameAttribute("address1_shippingmethodcode")
	public Contact setAddress1_ShippingMethodCode(OptionSetValue value) {
		this.setAttributeValue("address1_shippingmethodcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_StateOrProvince")
	@AttributeLogicalNameAttribute("address1_stateorprovince")
	public String getAddress1_StateOrProvince() {
		return this.getAttributeValue("address1_stateorprovince");
	}
	
	@AttributeSchemaNameAttribute("Address1_StateOrProvince")
	@AttributeLogicalNameAttribute("address1_stateorprovince")
	public Contact setAddress1_StateOrProvince(String value) {
		this.setAttributeValue("address1_stateorprovince", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Telephone1")
	@AttributeLogicalNameAttribute("address1_telephone1")
	public String getAddress1_Telephone1() {
		return this.getAttributeValue("address1_telephone1");
	}
	
	@AttributeSchemaNameAttribute("Address1_Telephone1")
	@AttributeLogicalNameAttribute("address1_telephone1")
	public Contact setAddress1_Telephone1(String value) {
		this.setAttributeValue("address1_telephone1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Telephone2")
	@AttributeLogicalNameAttribute("address1_telephone2")
	public String getAddress1_Telephone2() {
		return this.getAttributeValue("address1_telephone2");
	}
	
	@AttributeSchemaNameAttribute("Address1_Telephone2")
	@AttributeLogicalNameAttribute("address1_telephone2")
	public Contact setAddress1_Telephone2(String value) {
		this.setAttributeValue("address1_telephone2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_Telephone3")
	@AttributeLogicalNameAttribute("address1_telephone3")
	public String getAddress1_Telephone3() {
		return this.getAttributeValue("address1_telephone3");
	}
	
	@AttributeSchemaNameAttribute("Address1_Telephone3")
	@AttributeLogicalNameAttribute("address1_telephone3")
	public Contact setAddress1_Telephone3(String value) {
		this.setAttributeValue("address1_telephone3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_UPSZone")
	@AttributeLogicalNameAttribute("address1_upszone")
	public String getAddress1_UPSZone() {
		return this.getAttributeValue("address1_upszone");
	}
	
	@AttributeSchemaNameAttribute("Address1_UPSZone")
	@AttributeLogicalNameAttribute("address1_upszone")
	public Contact setAddress1_UPSZone(String value) {
		this.setAttributeValue("address1_upszone", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address1_UTCOffset")
	@AttributeLogicalNameAttribute("address1_utcoffset")
	public int getAddress1_UTCOffset() {
		return this.getAttributeValue("address1_utcoffset");
	}
	
	@AttributeSchemaNameAttribute("Address1_UTCOffset")
	@AttributeLogicalNameAttribute("address1_utcoffset")
	public Contact setAddress1_UTCOffset(int value) {
		this.setAttributeValue("address1_utcoffset", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_AddressId")
	@AttributeLogicalNameAttribute("address2_addressid")
	public UUID getAddress2_AddressId() {
		return this.getAttributeValue("address2_addressid");
	}
	
	@AttributeSchemaNameAttribute("Address2_AddressId")
	@AttributeLogicalNameAttribute("address2_addressid")
	public Contact setAddress2_AddressId(UUID value) {
		this.setAttributeValue("address2_addressid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_AddressTypeCode")
	@AttributeLogicalNameAttribute("address2_addresstypecode")
	public OptionSetValue getAddress2_AddressTypeCode() {
		return this.getAttributeValue("address2_addresstypecode");
	}
	
	@AttributeSchemaNameAttribute("Address2_AddressTypeCode")
	@AttributeLogicalNameAttribute("address2_addresstypecode")
	public Contact setAddress2_AddressTypeCode(OptionSetValue value) {
		this.setAttributeValue("address2_addresstypecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_City")
	@AttributeLogicalNameAttribute("address2_city")
	public String getAddress2_City() {
		return this.getAttributeValue("address2_city");
	}
	
	@AttributeSchemaNameAttribute("Address2_City")
	@AttributeLogicalNameAttribute("address2_city")
	public Contact setAddress2_City(String value) {
		this.setAttributeValue("address2_city", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Composite")
	@AttributeLogicalNameAttribute("address2_composite")
	public String getAddress2_Composite() {
		return this.getAttributeValue("address2_composite");
	}
	
	@AttributeSchemaNameAttribute("Address2_Composite")
	@AttributeLogicalNameAttribute("address2_composite")
	public Contact setAddress2_Composite(String value) {
		this.setAttributeValue("address2_composite", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Country")
	@AttributeLogicalNameAttribute("address2_country")
	public String getAddress2_Country() {
		return this.getAttributeValue("address2_country");
	}
	
	@AttributeSchemaNameAttribute("Address2_Country")
	@AttributeLogicalNameAttribute("address2_country")
	public Contact setAddress2_Country(String value) {
		this.setAttributeValue("address2_country", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_County")
	@AttributeLogicalNameAttribute("address2_county")
	public String getAddress2_County() {
		return this.getAttributeValue("address2_county");
	}
	
	@AttributeSchemaNameAttribute("Address2_County")
	@AttributeLogicalNameAttribute("address2_county")
	public Contact setAddress2_County(String value) {
		this.setAttributeValue("address2_county", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Fax")
	@AttributeLogicalNameAttribute("address2_fax")
	public String getAddress2_Fax() {
		return this.getAttributeValue("address2_fax");
	}
	
	@AttributeSchemaNameAttribute("Address2_Fax")
	@AttributeLogicalNameAttribute("address2_fax")
	public Contact setAddress2_Fax(String value) {
		this.setAttributeValue("address2_fax", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_FreightTermsCode")
	@AttributeLogicalNameAttribute("address2_freighttermscode")
	public OptionSetValue getAddress2_FreightTermsCode() {
		return this.getAttributeValue("address2_freighttermscode");
	}
	
	@AttributeSchemaNameAttribute("Address2_FreightTermsCode")
	@AttributeLogicalNameAttribute("address2_freighttermscode")
	public Contact setAddress2_FreightTermsCode(OptionSetValue value) {
		this.setAttributeValue("address2_freighttermscode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Latitude")
	@AttributeLogicalNameAttribute("address2_latitude")
	public double getAddress2_Latitude() {
		return this.getAttributeValue("address2_latitude");
	}
	
	@AttributeSchemaNameAttribute("Address2_Latitude")
	@AttributeLogicalNameAttribute("address2_latitude")
	public Contact setAddress2_Latitude(double value) {
		this.setAttributeValue("address2_latitude", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Line1")
	@AttributeLogicalNameAttribute("address2_line1")
	public String getAddress2_Line1() {
		return this.getAttributeValue("address2_line1");
	}
	
	@AttributeSchemaNameAttribute("Address2_Line1")
	@AttributeLogicalNameAttribute("address2_line1")
	public Contact setAddress2_Line1(String value) {
		this.setAttributeValue("address2_line1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Line2")
	@AttributeLogicalNameAttribute("address2_line2")
	public String getAddress2_Line2() {
		return this.getAttributeValue("address2_line2");
	}
	
	@AttributeSchemaNameAttribute("Address2_Line2")
	@AttributeLogicalNameAttribute("address2_line2")
	public Contact setAddress2_Line2(String value) {
		this.setAttributeValue("address2_line2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Line3")
	@AttributeLogicalNameAttribute("address2_line3")
	public String getAddress2_Line3() {
		return this.getAttributeValue("address2_line3");
	}
	
	@AttributeSchemaNameAttribute("Address2_Line3")
	@AttributeLogicalNameAttribute("address2_line3")
	public Contact setAddress2_Line3(String value) {
		this.setAttributeValue("address2_line3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Longitude")
	@AttributeLogicalNameAttribute("address2_longitude")
	public double getAddress2_Longitude() {
		return this.getAttributeValue("address2_longitude");
	}
	
	@AttributeSchemaNameAttribute("Address2_Longitude")
	@AttributeLogicalNameAttribute("address2_longitude")
	public Contact setAddress2_Longitude(double value) {
		this.setAttributeValue("address2_longitude", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Name")
	@AttributeLogicalNameAttribute("address2_name")
	public String getAddress2_Name() {
		return this.getAttributeValue("address2_name");
	}
	
	@AttributeSchemaNameAttribute("Address2_Name")
	@AttributeLogicalNameAttribute("address2_name")
	public Contact setAddress2_Name(String value) {
		this.setAttributeValue("address2_name", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_PostalCode")
	@AttributeLogicalNameAttribute("address2_postalcode")
	public String getAddress2_PostalCode() {
		return this.getAttributeValue("address2_postalcode");
	}
	
	@AttributeSchemaNameAttribute("Address2_PostalCode")
	@AttributeLogicalNameAttribute("address2_postalcode")
	public Contact setAddress2_PostalCode(String value) {
		this.setAttributeValue("address2_postalcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_PostOfficeBox")
	@AttributeLogicalNameAttribute("address2_postofficebox")
	public String getAddress2_PostOfficeBox() {
		return this.getAttributeValue("address2_postofficebox");
	}
	
	@AttributeSchemaNameAttribute("Address2_PostOfficeBox")
	@AttributeLogicalNameAttribute("address2_postofficebox")
	public Contact setAddress2_PostOfficeBox(String value) {
		this.setAttributeValue("address2_postofficebox", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_PrimaryContactName")
	@AttributeLogicalNameAttribute("address2_primarycontactname")
	public String getAddress2_PrimaryContactName() {
		return this.getAttributeValue("address2_primarycontactname");
	}
	
	@AttributeSchemaNameAttribute("Address2_PrimaryContactName")
	@AttributeLogicalNameAttribute("address2_primarycontactname")
	public Contact setAddress2_PrimaryContactName(String value) {
		this.setAttributeValue("address2_primarycontactname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_ShippingMethodCode")
	@AttributeLogicalNameAttribute("address2_shippingmethodcode")
	public OptionSetValue getAddress2_ShippingMethodCode() {
		return this.getAttributeValue("address2_shippingmethodcode");
	}
	
	@AttributeSchemaNameAttribute("Address2_ShippingMethodCode")
	@AttributeLogicalNameAttribute("address2_shippingmethodcode")
	public Contact setAddress2_ShippingMethodCode(OptionSetValue value) {
		this.setAttributeValue("address2_shippingmethodcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_StateOrProvince")
	@AttributeLogicalNameAttribute("address2_stateorprovince")
	public String getAddress2_StateOrProvince() {
		return this.getAttributeValue("address2_stateorprovince");
	}
	
	@AttributeSchemaNameAttribute("Address2_StateOrProvince")
	@AttributeLogicalNameAttribute("address2_stateorprovince")
	public Contact setAddress2_StateOrProvince(String value) {
		this.setAttributeValue("address2_stateorprovince", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Telephone1")
	@AttributeLogicalNameAttribute("address2_telephone1")
	public String getAddress2_Telephone1() {
		return this.getAttributeValue("address2_telephone1");
	}
	
	@AttributeSchemaNameAttribute("Address2_Telephone1")
	@AttributeLogicalNameAttribute("address2_telephone1")
	public Contact setAddress2_Telephone1(String value) {
		this.setAttributeValue("address2_telephone1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Telephone2")
	@AttributeLogicalNameAttribute("address2_telephone2")
	public String getAddress2_Telephone2() {
		return this.getAttributeValue("address2_telephone2");
	}
	
	@AttributeSchemaNameAttribute("Address2_Telephone2")
	@AttributeLogicalNameAttribute("address2_telephone2")
	public Contact setAddress2_Telephone2(String value) {
		this.setAttributeValue("address2_telephone2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_Telephone3")
	@AttributeLogicalNameAttribute("address2_telephone3")
	public String getAddress2_Telephone3() {
		return this.getAttributeValue("address2_telephone3");
	}
	
	@AttributeSchemaNameAttribute("Address2_Telephone3")
	@AttributeLogicalNameAttribute("address2_telephone3")
	public Contact setAddress2_Telephone3(String value) {
		this.setAttributeValue("address2_telephone3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_UPSZone")
	@AttributeLogicalNameAttribute("address2_upszone")
	public String getAddress2_UPSZone() {
		return this.getAttributeValue("address2_upszone");
	}
	
	@AttributeSchemaNameAttribute("Address2_UPSZone")
	@AttributeLogicalNameAttribute("address2_upszone")
	public Contact setAddress2_UPSZone(String value) {
		this.setAttributeValue("address2_upszone", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address2_UTCOffset")
	@AttributeLogicalNameAttribute("address2_utcoffset")
	public int getAddress2_UTCOffset() {
		return this.getAttributeValue("address2_utcoffset");
	}
	
	@AttributeSchemaNameAttribute("Address2_UTCOffset")
	@AttributeLogicalNameAttribute("address2_utcoffset")
	public Contact setAddress2_UTCOffset(int value) {
		this.setAttributeValue("address2_utcoffset", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_AddressId")
	@AttributeLogicalNameAttribute("address3_addressid")
	public UUID getAddress3_AddressId() {
		return this.getAttributeValue("address3_addressid");
	}
	
	@AttributeSchemaNameAttribute("Address3_AddressId")
	@AttributeLogicalNameAttribute("address3_addressid")
	public Contact setAddress3_AddressId(UUID value) {
		this.setAttributeValue("address3_addressid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_AddressTypeCode")
	@AttributeLogicalNameAttribute("address3_addresstypecode")
	public OptionSetValue getAddress3_AddressTypeCode() {
		return this.getAttributeValue("address3_addresstypecode");
	}
	
	@AttributeSchemaNameAttribute("Address3_AddressTypeCode")
	@AttributeLogicalNameAttribute("address3_addresstypecode")
	public Contact setAddress3_AddressTypeCode(OptionSetValue value) {
		this.setAttributeValue("address3_addresstypecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_City")
	@AttributeLogicalNameAttribute("address3_city")
	public String getAddress3_City() {
		return this.getAttributeValue("address3_city");
	}
	
	@AttributeSchemaNameAttribute("Address3_City")
	@AttributeLogicalNameAttribute("address3_city")
	public Contact setAddress3_City(String value) {
		this.setAttributeValue("address3_city", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Composite")
	@AttributeLogicalNameAttribute("address3_composite")
	public String getAddress3_Composite() {
		return this.getAttributeValue("address3_composite");
	}
	
	@AttributeSchemaNameAttribute("Address3_Composite")
	@AttributeLogicalNameAttribute("address3_composite")
	public Contact setAddress3_Composite(String value) {
		this.setAttributeValue("address3_composite", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Country")
	@AttributeLogicalNameAttribute("address3_country")
	public String getAddress3_Country() {
		return this.getAttributeValue("address3_country");
	}
	
	@AttributeSchemaNameAttribute("Address3_Country")
	@AttributeLogicalNameAttribute("address3_country")
	public Contact setAddress3_Country(String value) {
		this.setAttributeValue("address3_country", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_County")
	@AttributeLogicalNameAttribute("address3_county")
	public String getAddress3_County() {
		return this.getAttributeValue("address3_county");
	}
	
	@AttributeSchemaNameAttribute("Address3_County")
	@AttributeLogicalNameAttribute("address3_county")
	public Contact setAddress3_County(String value) {
		this.setAttributeValue("address3_county", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Fax")
	@AttributeLogicalNameAttribute("address3_fax")
	public String getAddress3_Fax() {
		return this.getAttributeValue("address3_fax");
	}
	
	@AttributeSchemaNameAttribute("Address3_Fax")
	@AttributeLogicalNameAttribute("address3_fax")
	public Contact setAddress3_Fax(String value) {
		this.setAttributeValue("address3_fax", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_FreightTermsCode")
	@AttributeLogicalNameAttribute("address3_freighttermscode")
	public OptionSetValue getAddress3_FreightTermsCode() {
		return this.getAttributeValue("address3_freighttermscode");
	}
	
	@AttributeSchemaNameAttribute("Address3_FreightTermsCode")
	@AttributeLogicalNameAttribute("address3_freighttermscode")
	public Contact setAddress3_FreightTermsCode(OptionSetValue value) {
		this.setAttributeValue("address3_freighttermscode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Latitude")
	@AttributeLogicalNameAttribute("address3_latitude")
	public double getAddress3_Latitude() {
		return this.getAttributeValue("address3_latitude");
	}
	
	@AttributeSchemaNameAttribute("Address3_Latitude")
	@AttributeLogicalNameAttribute("address3_latitude")
	public Contact setAddress3_Latitude(double value) {
		this.setAttributeValue("address3_latitude", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Line1")
	@AttributeLogicalNameAttribute("address3_line1")
	public String getAddress3_Line1() {
		return this.getAttributeValue("address3_line1");
	}
	
	@AttributeSchemaNameAttribute("Address3_Line1")
	@AttributeLogicalNameAttribute("address3_line1")
	public Contact setAddress3_Line1(String value) {
		this.setAttributeValue("address3_line1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Line2")
	@AttributeLogicalNameAttribute("address3_line2")
	public String getAddress3_Line2() {
		return this.getAttributeValue("address3_line2");
	}
	
	@AttributeSchemaNameAttribute("Address3_Line2")
	@AttributeLogicalNameAttribute("address3_line2")
	public Contact setAddress3_Line2(String value) {
		this.setAttributeValue("address3_line2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Line3")
	@AttributeLogicalNameAttribute("address3_line3")
	public String getAddress3_Line3() {
		return this.getAttributeValue("address3_line3");
	}
	
	@AttributeSchemaNameAttribute("Address3_Line3")
	@AttributeLogicalNameAttribute("address3_line3")
	public Contact setAddress3_Line3(String value) {
		this.setAttributeValue("address3_line3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Longitude")
	@AttributeLogicalNameAttribute("address3_longitude")
	public double getAddress3_Longitude() {
		return this.getAttributeValue("address3_longitude");
	}
	
	@AttributeSchemaNameAttribute("Address3_Longitude")
	@AttributeLogicalNameAttribute("address3_longitude")
	public Contact setAddress3_Longitude(double value) {
		this.setAttributeValue("address3_longitude", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Name")
	@AttributeLogicalNameAttribute("address3_name")
	public String getAddress3_Name() {
		return this.getAttributeValue("address3_name");
	}
	
	@AttributeSchemaNameAttribute("Address3_Name")
	@AttributeLogicalNameAttribute("address3_name")
	public Contact setAddress3_Name(String value) {
		this.setAttributeValue("address3_name", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_PostalCode")
	@AttributeLogicalNameAttribute("address3_postalcode")
	public String getAddress3_PostalCode() {
		return this.getAttributeValue("address3_postalcode");
	}
	
	@AttributeSchemaNameAttribute("Address3_PostalCode")
	@AttributeLogicalNameAttribute("address3_postalcode")
	public Contact setAddress3_PostalCode(String value) {
		this.setAttributeValue("address3_postalcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_PostOfficeBox")
	@AttributeLogicalNameAttribute("address3_postofficebox")
	public String getAddress3_PostOfficeBox() {
		return this.getAttributeValue("address3_postofficebox");
	}
	
	@AttributeSchemaNameAttribute("Address3_PostOfficeBox")
	@AttributeLogicalNameAttribute("address3_postofficebox")
	public Contact setAddress3_PostOfficeBox(String value) {
		this.setAttributeValue("address3_postofficebox", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_PrimaryContactName")
	@AttributeLogicalNameAttribute("address3_primarycontactname")
	public String getAddress3_PrimaryContactName() {
		return this.getAttributeValue("address3_primarycontactname");
	}
	
	@AttributeSchemaNameAttribute("Address3_PrimaryContactName")
	@AttributeLogicalNameAttribute("address3_primarycontactname")
	public Contact setAddress3_PrimaryContactName(String value) {
		this.setAttributeValue("address3_primarycontactname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_ShippingMethodCode")
	@AttributeLogicalNameAttribute("address3_shippingmethodcode")
	public OptionSetValue getAddress3_ShippingMethodCode() {
		return this.getAttributeValue("address3_shippingmethodcode");
	}
	
	@AttributeSchemaNameAttribute("Address3_ShippingMethodCode")
	@AttributeLogicalNameAttribute("address3_shippingmethodcode")
	public Contact setAddress3_ShippingMethodCode(OptionSetValue value) {
		this.setAttributeValue("address3_shippingmethodcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_StateOrProvince")
	@AttributeLogicalNameAttribute("address3_stateorprovince")
	public String getAddress3_StateOrProvince() {
		return this.getAttributeValue("address3_stateorprovince");
	}
	
	@AttributeSchemaNameAttribute("Address3_StateOrProvince")
	@AttributeLogicalNameAttribute("address3_stateorprovince")
	public Contact setAddress3_StateOrProvince(String value) {
		this.setAttributeValue("address3_stateorprovince", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Telephone1")
	@AttributeLogicalNameAttribute("address3_telephone1")
	public String getAddress3_Telephone1() {
		return this.getAttributeValue("address3_telephone1");
	}
	
	@AttributeSchemaNameAttribute("Address3_Telephone1")
	@AttributeLogicalNameAttribute("address3_telephone1")
	public Contact setAddress3_Telephone1(String value) {
		this.setAttributeValue("address3_telephone1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Telephone2")
	@AttributeLogicalNameAttribute("address3_telephone2")
	public String getAddress3_Telephone2() {
		return this.getAttributeValue("address3_telephone2");
	}
	
	@AttributeSchemaNameAttribute("Address3_Telephone2")
	@AttributeLogicalNameAttribute("address3_telephone2")
	public Contact setAddress3_Telephone2(String value) {
		this.setAttributeValue("address3_telephone2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_Telephone3")
	@AttributeLogicalNameAttribute("address3_telephone3")
	public String getAddress3_Telephone3() {
		return this.getAttributeValue("address3_telephone3");
	}
	
	@AttributeSchemaNameAttribute("Address3_Telephone3")
	@AttributeLogicalNameAttribute("address3_telephone3")
	public Contact setAddress3_Telephone3(String value) {
		this.setAttributeValue("address3_telephone3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_UPSZone")
	@AttributeLogicalNameAttribute("address3_upszone")
	public String getAddress3_UPSZone() {
		return this.getAttributeValue("address3_upszone");
	}
	
	@AttributeSchemaNameAttribute("Address3_UPSZone")
	@AttributeLogicalNameAttribute("address3_upszone")
	public Contact setAddress3_UPSZone(String value) {
		this.setAttributeValue("address3_upszone", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Address3_UTCOffset")
	@AttributeLogicalNameAttribute("address3_utcoffset")
	public int getAddress3_UTCOffset() {
		return this.getAttributeValue("address3_utcoffset");
	}
	
	@AttributeSchemaNameAttribute("Address3_UTCOffset")
	@AttributeLogicalNameAttribute("address3_utcoffset")
	public Contact setAddress3_UTCOffset(int value) {
		this.setAttributeValue("address3_utcoffset", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Aging30")
	@AttributeLogicalNameAttribute("aging30")
	public Money getAging30() {
		return this.getAttributeValue("aging30");
	}
	
	@AttributeSchemaNameAttribute("Aging30")
	@AttributeLogicalNameAttribute("aging30")
	public Contact setAging30(Money value) {
		this.setAttributeValue("aging30", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Aging30_Base")
	@AttributeLogicalNameAttribute("aging30_base")
	public Money getAging30_Base() {
		return this.getAttributeValue("aging30_base");
	}
	
	@AttributeSchemaNameAttribute("Aging30_Base")
	@AttributeLogicalNameAttribute("aging30_base")
	public Contact setAging30_Base(Money value) {
		this.setAttributeValue("aging30_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Aging60")
	@AttributeLogicalNameAttribute("aging60")
	public Money getAging60() {
		return this.getAttributeValue("aging60");
	}
	
	@AttributeSchemaNameAttribute("Aging60")
	@AttributeLogicalNameAttribute("aging60")
	public Contact setAging60(Money value) {
		this.setAttributeValue("aging60", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Aging60_Base")
	@AttributeLogicalNameAttribute("aging60_base")
	public Money getAging60_Base() {
		return this.getAttributeValue("aging60_base");
	}
	
	@AttributeSchemaNameAttribute("Aging60_Base")
	@AttributeLogicalNameAttribute("aging60_base")
	public Contact setAging60_Base(Money value) {
		this.setAttributeValue("aging60_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Aging90")
	@AttributeLogicalNameAttribute("aging90")
	public Money getAging90() {
		return this.getAttributeValue("aging90");
	}
	
	@AttributeSchemaNameAttribute("Aging90")
	@AttributeLogicalNameAttribute("aging90")
	public Contact setAging90(Money value) {
		this.setAttributeValue("aging90", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Aging90_Base")
	@AttributeLogicalNameAttribute("aging90_base")
	public Money getAging90_Base() {
		return this.getAttributeValue("aging90_base");
	}
	
	@AttributeSchemaNameAttribute("Aging90_Base")
	@AttributeLogicalNameAttribute("aging90_base")
	public Contact setAging90_Base(Money value) {
		this.setAttributeValue("aging90_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Anniversary")
	@AttributeLogicalNameAttribute("anniversary")
	public Date getAnniversary() {
		return this.getAttributeValue("anniversary");
	}
	
	@AttributeSchemaNameAttribute("Anniversary")
	@AttributeLogicalNameAttribute("anniversary")
	public Contact setAnniversary(Date value) {
		this.setAttributeValue("anniversary", value);
		return this;
	}

	@AttributeSchemaNameAttribute("AnnualIncome")
	@AttributeLogicalNameAttribute("annualincome")
	public Money getAnnualIncome() {
		return this.getAttributeValue("annualincome");
	}
	
	@AttributeSchemaNameAttribute("AnnualIncome")
	@AttributeLogicalNameAttribute("annualincome")
	public Contact setAnnualIncome(Money value) {
		this.setAttributeValue("annualincome", value);
		return this;
	}

	@AttributeSchemaNameAttribute("AnnualIncome_Base")
	@AttributeLogicalNameAttribute("annualincome_base")
	public Money getAnnualIncome_Base() {
		return this.getAttributeValue("annualincome_base");
	}
	
	@AttributeSchemaNameAttribute("AnnualIncome_Base")
	@AttributeLogicalNameAttribute("annualincome_base")
	public Contact setAnnualIncome_Base(Money value) {
		this.setAttributeValue("annualincome_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("AssistantName")
	@AttributeLogicalNameAttribute("assistantname")
	public String getAssistantName() {
		return this.getAttributeValue("assistantname");
	}
	
	@AttributeSchemaNameAttribute("AssistantName")
	@AttributeLogicalNameAttribute("assistantname")
	public Contact setAssistantName(String value) {
		this.setAttributeValue("assistantname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("AssistantPhone")
	@AttributeLogicalNameAttribute("assistantphone")
	public String getAssistantPhone() {
		return this.getAttributeValue("assistantphone");
	}
	
	@AttributeSchemaNameAttribute("AssistantPhone")
	@AttributeLogicalNameAttribute("assistantphone")
	public Contact setAssistantPhone(String value) {
		this.setAttributeValue("assistantphone", value);
		return this;
	}

	@AttributeSchemaNameAttribute("BirthDate")
	@AttributeLogicalNameAttribute("birthdate")
	public Date getBirthDate() {
		return this.getAttributeValue("birthdate");
	}
	
	@AttributeSchemaNameAttribute("BirthDate")
	@AttributeLogicalNameAttribute("birthdate")
	public Contact setBirthDate(Date value) {
		this.setAttributeValue("birthdate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Business2")
	@AttributeLogicalNameAttribute("business2")
	public String getBusiness2() {
		return this.getAttributeValue("business2");
	}
	
	@AttributeSchemaNameAttribute("Business2")
	@AttributeLogicalNameAttribute("business2")
	public Contact setBusiness2(String value) {
		this.setAttributeValue("business2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Callback")
	@AttributeLogicalNameAttribute("callback")
	public String getCallback() {
		return this.getAttributeValue("callback");
	}
	
	@AttributeSchemaNameAttribute("Callback")
	@AttributeLogicalNameAttribute("callback")
	public Contact setCallback(String value) {
		this.setAttributeValue("callback", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ChildrensNames")
	@AttributeLogicalNameAttribute("childrensnames")
	public String getChildrensNames() {
		return this.getAttributeValue("childrensnames");
	}
	
	@AttributeSchemaNameAttribute("ChildrensNames")
	@AttributeLogicalNameAttribute("childrensnames")
	public Contact setChildrensNames(String value) {
		this.setAttributeValue("childrensnames", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Company")
	@AttributeLogicalNameAttribute("company")
	public String getCompany() {
		return this.getAttributeValue("company");
	}
	
	@AttributeSchemaNameAttribute("Company")
	@AttributeLogicalNameAttribute("company")
	public Contact setCompany(String value) {
		this.setAttributeValue("company", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedBy")
	@AttributeLogicalNameAttribute("createdby")
	public EntityReference getCreatedBy() {
		return this.getAttributeValue("createdby");
	}
	
	@AttributeSchemaNameAttribute("CreatedBy")
	@AttributeLogicalNameAttribute("createdby")
	public Contact setCreatedBy(EntityReference value) {
		this.setAttributeValue("createdby", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedByName")
	@AttributeLogicalNameAttribute("createdbyname")
	public String getCreatedByName() {
		return this.getAttributeValue("createdbyname");
	}
	
	@AttributeSchemaNameAttribute("CreatedByName")
	@AttributeLogicalNameAttribute("createdbyname")
	public Contact setCreatedByName(String value) {
		this.setAttributeValue("createdbyname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedByYomiName")
	@AttributeLogicalNameAttribute("createdbyyominame")
	public String getCreatedByYomiName() {
		return this.getAttributeValue("createdbyyominame");
	}
	
	@AttributeSchemaNameAttribute("CreatedByYomiName")
	@AttributeLogicalNameAttribute("createdbyyominame")
	public Contact setCreatedByYomiName(String value) {
		this.setAttributeValue("createdbyyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedOn")
	@AttributeLogicalNameAttribute("createdon")
	public Date getCreatedOn() {
		return this.getAttributeValue("createdon");
	}
	
	@AttributeSchemaNameAttribute("CreatedOn")
	@AttributeLogicalNameAttribute("createdon")
	public Contact setCreatedOn(Date value) {
		this.setAttributeValue("createdon", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedOnBehalfBy")
	@AttributeLogicalNameAttribute("createdonbehalfby")
	public EntityReference getCreatedOnBehalfBy() {
		return this.getAttributeValue("createdonbehalfby");
	}
	
	@AttributeSchemaNameAttribute("CreatedOnBehalfBy")
	@AttributeLogicalNameAttribute("createdonbehalfby")
	public Contact setCreatedOnBehalfBy(EntityReference value) {
		this.setAttributeValue("createdonbehalfby", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedOnBehalfByName")
	@AttributeLogicalNameAttribute("createdonbehalfbyname")
	public String getCreatedOnBehalfByName() {
		return this.getAttributeValue("createdonbehalfbyname");
	}
	
	@AttributeSchemaNameAttribute("CreatedOnBehalfByName")
	@AttributeLogicalNameAttribute("createdonbehalfbyname")
	public Contact setCreatedOnBehalfByName(String value) {
		this.setAttributeValue("createdonbehalfbyname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedOnBehalfByYomiName")
	@AttributeLogicalNameAttribute("createdonbehalfbyyominame")
	public String getCreatedOnBehalfByYomiName() {
		return this.getAttributeValue("createdonbehalfbyyominame");
	}
	
	@AttributeSchemaNameAttribute("CreatedOnBehalfByYomiName")
	@AttributeLogicalNameAttribute("createdonbehalfbyyominame")
	public Contact setCreatedOnBehalfByYomiName(String value) {
		this.setAttributeValue("createdonbehalfbyyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreditLimit")
	@AttributeLogicalNameAttribute("creditlimit")
	public Money getCreditLimit() {
		return this.getAttributeValue("creditlimit");
	}
	
	@AttributeSchemaNameAttribute("CreditLimit")
	@AttributeLogicalNameAttribute("creditlimit")
	public Contact setCreditLimit(Money value) {
		this.setAttributeValue("creditlimit", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreditLimit_Base")
	@AttributeLogicalNameAttribute("creditlimit_base")
	public Money getCreditLimit_Base() {
		return this.getAttributeValue("creditlimit_base");
	}
	
	@AttributeSchemaNameAttribute("CreditLimit_Base")
	@AttributeLogicalNameAttribute("creditlimit_base")
	public Contact setCreditLimit_Base(Money value) {
		this.setAttributeValue("creditlimit_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreditOnHold")
	@AttributeLogicalNameAttribute("creditonhold")
	public boolean getCreditOnHold() {
		return this.getAttributeValue("creditonhold");
	}
	
	@AttributeSchemaNameAttribute("CreditOnHold")
	@AttributeLogicalNameAttribute("creditonhold")
	public Contact setCreditOnHold(boolean value) {
		this.setAttributeValue("creditonhold", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CustomerSizeCode")
	@AttributeLogicalNameAttribute("customersizecode")
	public OptionSetValue getCustomerSizeCode() {
		return this.getAttributeValue("customersizecode");
	}
	
	@AttributeSchemaNameAttribute("CustomerSizeCode")
	@AttributeLogicalNameAttribute("customersizecode")
	public Contact setCustomerSizeCode(OptionSetValue value) {
		this.setAttributeValue("customersizecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CustomerTypeCode")
	@AttributeLogicalNameAttribute("customertypecode")
	public OptionSetValue getCustomerTypeCode() {
		return this.getAttributeValue("customertypecode");
	}
	
	@AttributeSchemaNameAttribute("CustomerTypeCode")
	@AttributeLogicalNameAttribute("customertypecode")
	public Contact setCustomerTypeCode(OptionSetValue value) {
		this.setAttributeValue("customertypecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DefaultPriceLevelId")
	@AttributeLogicalNameAttribute("defaultpricelevelid")
	public EntityReference getDefaultPriceLevelId() {
		return this.getAttributeValue("defaultpricelevelid");
	}
	
	@AttributeSchemaNameAttribute("DefaultPriceLevelId")
	@AttributeLogicalNameAttribute("defaultpricelevelid")
	public Contact setDefaultPriceLevelId(EntityReference value) {
		this.setAttributeValue("defaultpricelevelid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DefaultPriceLevelIdName")
	@AttributeLogicalNameAttribute("defaultpricelevelidname")
	public String getDefaultPriceLevelIdName() {
		return this.getAttributeValue("defaultpricelevelidname");
	}
	
	@AttributeSchemaNameAttribute("DefaultPriceLevelIdName")
	@AttributeLogicalNameAttribute("defaultpricelevelidname")
	public Contact setDefaultPriceLevelIdName(String value) {
		this.setAttributeValue("defaultpricelevelidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Department")
	@AttributeLogicalNameAttribute("department")
	public String getDepartment() {
		return this.getAttributeValue("department");
	}
	
	@AttributeSchemaNameAttribute("Department")
	@AttributeLogicalNameAttribute("department")
	public Contact setDepartment(String value) {
		this.setAttributeValue("department", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Description")
	@AttributeLogicalNameAttribute("description")
	public String getDescription() {
		return this.getAttributeValue("description");
	}
	
	@AttributeSchemaNameAttribute("Description")
	@AttributeLogicalNameAttribute("description")
	public Contact setDescription(String value) {
		this.setAttributeValue("description", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DoNotBulkEMail")
	@AttributeLogicalNameAttribute("donotbulkemail")
	public boolean getDoNotBulkEMail() {
		return this.getAttributeValue("donotbulkemail");
	}
	
	@AttributeSchemaNameAttribute("DoNotBulkEMail")
	@AttributeLogicalNameAttribute("donotbulkemail")
	public Contact setDoNotBulkEMail(boolean value) {
		this.setAttributeValue("donotbulkemail", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DoNotBulkPostalMail")
	@AttributeLogicalNameAttribute("donotbulkpostalmail")
	public boolean getDoNotBulkPostalMail() {
		return this.getAttributeValue("donotbulkpostalmail");
	}
	
	@AttributeSchemaNameAttribute("DoNotBulkPostalMail")
	@AttributeLogicalNameAttribute("donotbulkpostalmail")
	public Contact setDoNotBulkPostalMail(boolean value) {
		this.setAttributeValue("donotbulkpostalmail", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DoNotEMail")
	@AttributeLogicalNameAttribute("donotemail")
	public boolean getDoNotEMail() {
		return this.getAttributeValue("donotemail");
	}
	
	@AttributeSchemaNameAttribute("DoNotEMail")
	@AttributeLogicalNameAttribute("donotemail")
	public Contact setDoNotEMail(boolean value) {
		this.setAttributeValue("donotemail", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DoNotFax")
	@AttributeLogicalNameAttribute("donotfax")
	public boolean getDoNotFax() {
		return this.getAttributeValue("donotfax");
	}
	
	@AttributeSchemaNameAttribute("DoNotFax")
	@AttributeLogicalNameAttribute("donotfax")
	public Contact setDoNotFax(boolean value) {
		this.setAttributeValue("donotfax", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DoNotPhone")
	@AttributeLogicalNameAttribute("donotphone")
	public boolean getDoNotPhone() {
		return this.getAttributeValue("donotphone");
	}
	
	@AttributeSchemaNameAttribute("DoNotPhone")
	@AttributeLogicalNameAttribute("donotphone")
	public Contact setDoNotPhone(boolean value) {
		this.setAttributeValue("donotphone", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DoNotPostalMail")
	@AttributeLogicalNameAttribute("donotpostalmail")
	public boolean getDoNotPostalMail() {
		return this.getAttributeValue("donotpostalmail");
	}
	
	@AttributeSchemaNameAttribute("DoNotPostalMail")
	@AttributeLogicalNameAttribute("donotpostalmail")
	public Contact setDoNotPostalMail(boolean value) {
		this.setAttributeValue("donotpostalmail", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DoNotSendMM")
	@AttributeLogicalNameAttribute("donotsendmm")
	public boolean getDoNotSendMM() {
		return this.getAttributeValue("donotsendmm");
	}
	
	@AttributeSchemaNameAttribute("DoNotSendMM")
	@AttributeLogicalNameAttribute("donotsendmm")
	public Contact setDoNotSendMM(boolean value) {
		this.setAttributeValue("donotsendmm", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EducationCode")
	@AttributeLogicalNameAttribute("educationcode")
	public OptionSetValue getEducationCode() {
		return this.getAttributeValue("educationcode");
	}
	
	@AttributeSchemaNameAttribute("EducationCode")
	@AttributeLogicalNameAttribute("educationcode")
	public Contact setEducationCode(OptionSetValue value) {
		this.setAttributeValue("educationcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EMailAddress1")
	@AttributeLogicalNameAttribute("emailaddress1")
	public String getEMailAddress1() {
		return this.getAttributeValue("emailaddress1");
	}
	
	@AttributeSchemaNameAttribute("EMailAddress1")
	@AttributeLogicalNameAttribute("emailaddress1")
	public Contact setEMailAddress1(String value) {
		this.setAttributeValue("emailaddress1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EMailAddress2")
	@AttributeLogicalNameAttribute("emailaddress2")
	public String getEMailAddress2() {
		return this.getAttributeValue("emailaddress2");
	}
	
	@AttributeSchemaNameAttribute("EMailAddress2")
	@AttributeLogicalNameAttribute("emailaddress2")
	public Contact setEMailAddress2(String value) {
		this.setAttributeValue("emailaddress2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EMailAddress3")
	@AttributeLogicalNameAttribute("emailaddress3")
	public String getEMailAddress3() {
		return this.getAttributeValue("emailaddress3");
	}
	
	@AttributeSchemaNameAttribute("EMailAddress3")
	@AttributeLogicalNameAttribute("emailaddress3")
	public Contact setEMailAddress3(String value) {
		this.setAttributeValue("emailaddress3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EmployeeId")
	@AttributeLogicalNameAttribute("employeeid")
	public String getEmployeeId() {
		return this.getAttributeValue("employeeid");
	}
	
	@AttributeSchemaNameAttribute("EmployeeId")
	@AttributeLogicalNameAttribute("employeeid")
	public Contact setEmployeeId(String value) {
		this.setAttributeValue("employeeid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EntityImage_Timestamp")
	@AttributeLogicalNameAttribute("entityimage_timestamp")
	public BigInteger getEntityImage_Timestamp() {
		return this.getAttributeValue("entityimage_timestamp");
	}
	
	@AttributeSchemaNameAttribute("EntityImage_Timestamp")
	@AttributeLogicalNameAttribute("entityimage_timestamp")
	public Contact setEntityImage_Timestamp(BigInteger value) {
		this.setAttributeValue("entityimage_timestamp", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EntityImage_URL")
	@AttributeLogicalNameAttribute("entityimage_url")
	public String getEntityImage_URL() {
		return this.getAttributeValue("entityimage_url");
	}
	
	@AttributeSchemaNameAttribute("EntityImage_URL")
	@AttributeLogicalNameAttribute("entityimage_url")
	public Contact setEntityImage_URL(String value) {
		this.setAttributeValue("entityimage_url", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EntityImageId")
	@AttributeLogicalNameAttribute("entityimageid")
	public UUID getEntityImageId() {
		return this.getAttributeValue("entityimageid");
	}
	
	@AttributeSchemaNameAttribute("EntityImageId")
	@AttributeLogicalNameAttribute("entityimageid")
	public Contact setEntityImageId(UUID value) {
		this.setAttributeValue("entityimageid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ExchangeRate")
	@AttributeLogicalNameAttribute("exchangerate")
	public BigDecimal getExchangeRate() {
		return this.getAttributeValue("exchangerate");
	}
	
	@AttributeSchemaNameAttribute("ExchangeRate")
	@AttributeLogicalNameAttribute("exchangerate")
	public Contact setExchangeRate(BigDecimal value) {
		this.setAttributeValue("exchangerate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ExternalUserIdentifier")
	@AttributeLogicalNameAttribute("externaluseridentifier")
	public String getExternalUserIdentifier() {
		return this.getAttributeValue("externaluseridentifier");
	}
	
	@AttributeSchemaNameAttribute("ExternalUserIdentifier")
	@AttributeLogicalNameAttribute("externaluseridentifier")
	public Contact setExternalUserIdentifier(String value) {
		this.setAttributeValue("externaluseridentifier", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FamilyStatusCode")
	@AttributeLogicalNameAttribute("familystatuscode")
	public OptionSetValue getFamilyStatusCode() {
		return this.getAttributeValue("familystatuscode");
	}
	
	@AttributeSchemaNameAttribute("FamilyStatusCode")
	@AttributeLogicalNameAttribute("familystatuscode")
	public Contact setFamilyStatusCode(OptionSetValue value) {
		this.setAttributeValue("familystatuscode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Fax")
	@AttributeLogicalNameAttribute("fax")
	public String getFax() {
		return this.getAttributeValue("fax");
	}
	
	@AttributeSchemaNameAttribute("Fax")
	@AttributeLogicalNameAttribute("fax")
	public Contact setFax(String value) {
		this.setAttributeValue("fax", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FirstName")
	@AttributeLogicalNameAttribute("firstname")
	public String getFirstName() {
		return this.getAttributeValue("firstname");
	}
	
	@AttributeSchemaNameAttribute("FirstName")
	@AttributeLogicalNameAttribute("firstname")
	public Contact setFirstName(String value) {
		this.setAttributeValue("firstname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FtpSiteUrl")
	@AttributeLogicalNameAttribute("ftpsiteurl")
	public String getFtpSiteUrl() {
		return this.getAttributeValue("ftpsiteurl");
	}
	
	@AttributeSchemaNameAttribute("FtpSiteUrl")
	@AttributeLogicalNameAttribute("ftpsiteurl")
	public Contact setFtpSiteUrl(String value) {
		this.setAttributeValue("ftpsiteurl", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FullName")
	@AttributeLogicalNameAttribute("fullname")
	public String getFullName() {
		return this.getAttributeValue("fullname");
	}
	
	@AttributeSchemaNameAttribute("FullName")
	@AttributeLogicalNameAttribute("fullname")
	public Contact setFullName(String value) {
		this.setAttributeValue("fullname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("GenderCode")
	@AttributeLogicalNameAttribute("gendercode")
	public OptionSetValue getGenderCode() {
		return this.getAttributeValue("gendercode");
	}
	
	@AttributeSchemaNameAttribute("GenderCode")
	@AttributeLogicalNameAttribute("gendercode")
	public Contact setGenderCode(OptionSetValue value) {
		this.setAttributeValue("gendercode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("GovernmentId")
	@AttributeLogicalNameAttribute("governmentid")
	public String getGovernmentId() {
		return this.getAttributeValue("governmentid");
	}
	
	@AttributeSchemaNameAttribute("GovernmentId")
	@AttributeLogicalNameAttribute("governmentid")
	public Contact setGovernmentId(String value) {
		this.setAttributeValue("governmentid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("HasChildrenCode")
	@AttributeLogicalNameAttribute("haschildrencode")
	public OptionSetValue getHasChildrenCode() {
		return this.getAttributeValue("haschildrencode");
	}
	
	@AttributeSchemaNameAttribute("HasChildrenCode")
	@AttributeLogicalNameAttribute("haschildrencode")
	public Contact setHasChildrenCode(OptionSetValue value) {
		this.setAttributeValue("haschildrencode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Home2")
	@AttributeLogicalNameAttribute("home2")
	public String getHome2() {
		return this.getAttributeValue("home2");
	}
	
	@AttributeSchemaNameAttribute("Home2")
	@AttributeLogicalNameAttribute("home2")
	public Contact setHome2(String value) {
		this.setAttributeValue("home2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ImportSequenceNumber")
	@AttributeLogicalNameAttribute("importsequencenumber")
	public int getImportSequenceNumber() {
		return this.getAttributeValue("importsequencenumber");
	}
	
	@AttributeSchemaNameAttribute("ImportSequenceNumber")
	@AttributeLogicalNameAttribute("importsequencenumber")
	public Contact setImportSequenceNumber(int value) {
		this.setAttributeValue("importsequencenumber", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IsAutoCreate")
	@AttributeLogicalNameAttribute("isautocreate")
	public boolean getIsAutoCreate() {
		return this.getAttributeValue("isautocreate");
	}
	
	@AttributeSchemaNameAttribute("IsAutoCreate")
	@AttributeLogicalNameAttribute("isautocreate")
	public Contact setIsAutoCreate(boolean value) {
		this.setAttributeValue("isautocreate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IsBackofficeCustomer")
	@AttributeLogicalNameAttribute("isbackofficecustomer")
	public boolean getIsBackofficeCustomer() {
		return this.getAttributeValue("isbackofficecustomer");
	}
	
	@AttributeSchemaNameAttribute("IsBackofficeCustomer")
	@AttributeLogicalNameAttribute("isbackofficecustomer")
	public Contact setIsBackofficeCustomer(boolean value) {
		this.setAttributeValue("isbackofficecustomer", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IsPrivate")
	@AttributeLogicalNameAttribute("isprivate")
	public boolean getIsPrivate() {
		return this.getAttributeValue("isprivate");
	}
	
	@AttributeSchemaNameAttribute("IsPrivate")
	@AttributeLogicalNameAttribute("isprivate")
	public Contact setIsPrivate(boolean value) {
		this.setAttributeValue("isprivate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("JobTitle")
	@AttributeLogicalNameAttribute("jobtitle")
	public String getJobTitle() {
		return this.getAttributeValue("jobtitle");
	}
	
	@AttributeSchemaNameAttribute("JobTitle")
	@AttributeLogicalNameAttribute("jobtitle")
	public Contact setJobTitle(String value) {
		this.setAttributeValue("jobtitle", value);
		return this;
	}

	@AttributeSchemaNameAttribute("LastName")
	@AttributeLogicalNameAttribute("lastname")
	public String getLastName() {
		return this.getAttributeValue("lastname");
	}
	
	@AttributeSchemaNameAttribute("LastName")
	@AttributeLogicalNameAttribute("lastname")
	public Contact setLastName(String value) {
		this.setAttributeValue("lastname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("LastUsedInCampaign")
	@AttributeLogicalNameAttribute("lastusedincampaign")
	public Date getLastUsedInCampaign() {
		return this.getAttributeValue("lastusedincampaign");
	}
	
	@AttributeSchemaNameAttribute("LastUsedInCampaign")
	@AttributeLogicalNameAttribute("lastusedincampaign")
	public Contact setLastUsedInCampaign(Date value) {
		this.setAttributeValue("lastusedincampaign", value);
		return this;
	}

	@AttributeSchemaNameAttribute("LeadSourceCode")
	@AttributeLogicalNameAttribute("leadsourcecode")
	public OptionSetValue getLeadSourceCode() {
		return this.getAttributeValue("leadsourcecode");
	}
	
	@AttributeSchemaNameAttribute("LeadSourceCode")
	@AttributeLogicalNameAttribute("leadsourcecode")
	public Contact setLeadSourceCode(OptionSetValue value) {
		this.setAttributeValue("leadsourcecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ManagerName")
	@AttributeLogicalNameAttribute("managername")
	public String getManagerName() {
		return this.getAttributeValue("managername");
	}
	
	@AttributeSchemaNameAttribute("ManagerName")
	@AttributeLogicalNameAttribute("managername")
	public Contact setManagerName(String value) {
		this.setAttributeValue("managername", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ManagerPhone")
	@AttributeLogicalNameAttribute("managerphone")
	public String getManagerPhone() {
		return this.getAttributeValue("managerphone");
	}
	
	@AttributeSchemaNameAttribute("ManagerPhone")
	@AttributeLogicalNameAttribute("managerphone")
	public Contact setManagerPhone(String value) {
		this.setAttributeValue("managerphone", value);
		return this;
	}

	@AttributeSchemaNameAttribute("MasterContactIdName")
	@AttributeLogicalNameAttribute("mastercontactidname")
	public String getMasterContactIdName() {
		return this.getAttributeValue("mastercontactidname");
	}
	
	@AttributeSchemaNameAttribute("MasterContactIdName")
	@AttributeLogicalNameAttribute("mastercontactidname")
	public Contact setMasterContactIdName(String value) {
		this.setAttributeValue("mastercontactidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("MasterContactIdYomiName")
	@AttributeLogicalNameAttribute("mastercontactidyominame")
	public String getMasterContactIdYomiName() {
		return this.getAttributeValue("mastercontactidyominame");
	}
	
	@AttributeSchemaNameAttribute("MasterContactIdYomiName")
	@AttributeLogicalNameAttribute("mastercontactidyominame")
	public Contact setMasterContactIdYomiName(String value) {
		this.setAttributeValue("mastercontactidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("MasterId")
	@AttributeLogicalNameAttribute("masterid")
	public EntityReference getMasterId() {
		return this.getAttributeValue("masterid");
	}
	
	@AttributeSchemaNameAttribute("MasterId")
	@AttributeLogicalNameAttribute("masterid")
	public Contact setMasterId(EntityReference value) {
		this.setAttributeValue("masterid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Merged")
	@AttributeLogicalNameAttribute("merged")
	public boolean getMerged() {
		return this.getAttributeValue("merged");
	}
	
	@AttributeSchemaNameAttribute("Merged")
	@AttributeLogicalNameAttribute("merged")
	public Contact setMerged(boolean value) {
		this.setAttributeValue("merged", value);
		return this;
	}

	@AttributeSchemaNameAttribute("MiddleName")
	@AttributeLogicalNameAttribute("middlename")
	public String getMiddleName() {
		return this.getAttributeValue("middlename");
	}
	
	@AttributeSchemaNameAttribute("MiddleName")
	@AttributeLogicalNameAttribute("middlename")
	public Contact setMiddleName(String value) {
		this.setAttributeValue("middlename", value);
		return this;
	}

	@AttributeSchemaNameAttribute("MobilePhone")
	@AttributeLogicalNameAttribute("mobilephone")
	public String getMobilePhone() {
		return this.getAttributeValue("mobilephone");
	}
	
	@AttributeSchemaNameAttribute("MobilePhone")
	@AttributeLogicalNameAttribute("mobilephone")
	public Contact setMobilePhone(String value) {
		this.setAttributeValue("mobilephone", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedBy")
	@AttributeLogicalNameAttribute("modifiedby")
	public EntityReference getModifiedBy() {
		return this.getAttributeValue("modifiedby");
	}
	
	@AttributeSchemaNameAttribute("ModifiedBy")
	@AttributeLogicalNameAttribute("modifiedby")
	public Contact setModifiedBy(EntityReference value) {
		this.setAttributeValue("modifiedby", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedByName")
	@AttributeLogicalNameAttribute("modifiedbyname")
	public String getModifiedByName() {
		return this.getAttributeValue("modifiedbyname");
	}
	
	@AttributeSchemaNameAttribute("ModifiedByName")
	@AttributeLogicalNameAttribute("modifiedbyname")
	public Contact setModifiedByName(String value) {
		this.setAttributeValue("modifiedbyname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedByYomiName")
	@AttributeLogicalNameAttribute("modifiedbyyominame")
	public String getModifiedByYomiName() {
		return this.getAttributeValue("modifiedbyyominame");
	}
	
	@AttributeSchemaNameAttribute("ModifiedByYomiName")
	@AttributeLogicalNameAttribute("modifiedbyyominame")
	public Contact setModifiedByYomiName(String value) {
		this.setAttributeValue("modifiedbyyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedOn")
	@AttributeLogicalNameAttribute("modifiedon")
	public Date getModifiedOn() {
		return this.getAttributeValue("modifiedon");
	}
	
	@AttributeSchemaNameAttribute("ModifiedOn")
	@AttributeLogicalNameAttribute("modifiedon")
	public Contact setModifiedOn(Date value) {
		this.setAttributeValue("modifiedon", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedOnBehalfBy")
	@AttributeLogicalNameAttribute("modifiedonbehalfby")
	public EntityReference getModifiedOnBehalfBy() {
		return this.getAttributeValue("modifiedonbehalfby");
	}
	
	@AttributeSchemaNameAttribute("ModifiedOnBehalfBy")
	@AttributeLogicalNameAttribute("modifiedonbehalfby")
	public Contact setModifiedOnBehalfBy(EntityReference value) {
		this.setAttributeValue("modifiedonbehalfby", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedOnBehalfByName")
	@AttributeLogicalNameAttribute("modifiedonbehalfbyname")
	public String getModifiedOnBehalfByName() {
		return this.getAttributeValue("modifiedonbehalfbyname");
	}
	
	@AttributeSchemaNameAttribute("ModifiedOnBehalfByName")
	@AttributeLogicalNameAttribute("modifiedonbehalfbyname")
	public Contact setModifiedOnBehalfByName(String value) {
		this.setAttributeValue("modifiedonbehalfbyname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedOnBehalfByYomiName")
	@AttributeLogicalNameAttribute("modifiedonbehalfbyyominame")
	public String getModifiedOnBehalfByYomiName() {
		return this.getAttributeValue("modifiedonbehalfbyyominame");
	}
	
	@AttributeSchemaNameAttribute("ModifiedOnBehalfByYomiName")
	@AttributeLogicalNameAttribute("modifiedonbehalfbyyominame")
	public Contact setModifiedOnBehalfByYomiName(String value) {
		this.setAttributeValue("modifiedonbehalfbyyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("NickName")
	@AttributeLogicalNameAttribute("nickname")
	public String getNickName() {
		return this.getAttributeValue("nickname");
	}
	
	@AttributeSchemaNameAttribute("NickName")
	@AttributeLogicalNameAttribute("nickname")
	public Contact setNickName(String value) {
		this.setAttributeValue("nickname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("NumberOfChildren")
	@AttributeLogicalNameAttribute("numberofchildren")
	public int getNumberOfChildren() {
		return this.getAttributeValue("numberofchildren");
	}
	
	@AttributeSchemaNameAttribute("NumberOfChildren")
	@AttributeLogicalNameAttribute("numberofchildren")
	public Contact setNumberOfChildren(int value) {
		this.setAttributeValue("numberofchildren", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OriginatingLeadId")
	@AttributeLogicalNameAttribute("originatingleadid")
	public EntityReference getOriginatingLeadId() {
		return this.getAttributeValue("originatingleadid");
	}
	
	@AttributeSchemaNameAttribute("OriginatingLeadId")
	@AttributeLogicalNameAttribute("originatingleadid")
	public Contact setOriginatingLeadId(EntityReference value) {
		this.setAttributeValue("originatingleadid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OriginatingLeadIdName")
	@AttributeLogicalNameAttribute("originatingleadidname")
	public String getOriginatingLeadIdName() {
		return this.getAttributeValue("originatingleadidname");
	}
	
	@AttributeSchemaNameAttribute("OriginatingLeadIdName")
	@AttributeLogicalNameAttribute("originatingleadidname")
	public Contact setOriginatingLeadIdName(String value) {
		this.setAttributeValue("originatingleadidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OriginatingLeadIdYomiName")
	@AttributeLogicalNameAttribute("originatingleadidyominame")
	public String getOriginatingLeadIdYomiName() {
		return this.getAttributeValue("originatingleadidyominame");
	}
	
	@AttributeSchemaNameAttribute("OriginatingLeadIdYomiName")
	@AttributeLogicalNameAttribute("originatingleadidyominame")
	public Contact setOriginatingLeadIdYomiName(String value) {
		this.setAttributeValue("originatingleadidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OverriddenCreatedOn")
	@AttributeLogicalNameAttribute("overriddencreatedon")
	public Date getOverriddenCreatedOn() {
		return this.getAttributeValue("overriddencreatedon");
	}
	
	@AttributeSchemaNameAttribute("OverriddenCreatedOn")
	@AttributeLogicalNameAttribute("overriddencreatedon")
	public Contact setOverriddenCreatedOn(Date value) {
		this.setAttributeValue("overriddencreatedon", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OwnerId")
	@AttributeLogicalNameAttribute("ownerid")
	public EntityReference getOwnerId() {
		return this.getAttributeValue("ownerid");
	}
	
	@AttributeSchemaNameAttribute("OwnerId")
	@AttributeLogicalNameAttribute("ownerid")
	public Contact setOwnerId(EntityReference value) {
		this.setAttributeValue("ownerid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OwnerIdName")
	@AttributeLogicalNameAttribute("owneridname")
	public String getOwnerIdName() {
		return this.getAttributeValue("owneridname");
	}
	
	@AttributeSchemaNameAttribute("OwnerIdName")
	@AttributeLogicalNameAttribute("owneridname")
	public Contact setOwnerIdName(String value) {
		this.setAttributeValue("owneridname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OwnerIdYomiName")
	@AttributeLogicalNameAttribute("owneridyominame")
	public String getOwnerIdYomiName() {
		return this.getAttributeValue("owneridyominame");
	}
	
	@AttributeSchemaNameAttribute("OwnerIdYomiName")
	@AttributeLogicalNameAttribute("owneridyominame")
	public Contact setOwnerIdYomiName(String value) {
		this.setAttributeValue("owneridyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OwningBusinessUnit")
	@AttributeLogicalNameAttribute("owningbusinessunit")
	public EntityReference getOwningBusinessUnit() {
		return this.getAttributeValue("owningbusinessunit");
	}
	
	@AttributeSchemaNameAttribute("OwningBusinessUnit")
	@AttributeLogicalNameAttribute("owningbusinessunit")
	public Contact setOwningBusinessUnit(EntityReference value) {
		this.setAttributeValue("owningbusinessunit", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OwningTeam")
	@AttributeLogicalNameAttribute("owningteam")
	public EntityReference getOwningTeam() {
		return this.getAttributeValue("owningteam");
	}
	
	@AttributeSchemaNameAttribute("OwningTeam")
	@AttributeLogicalNameAttribute("owningteam")
	public Contact setOwningTeam(EntityReference value) {
		this.setAttributeValue("owningteam", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OwningUser")
	@AttributeLogicalNameAttribute("owninguser")
	public EntityReference getOwningUser() {
		return this.getAttributeValue("owninguser");
	}
	
	@AttributeSchemaNameAttribute("OwningUser")
	@AttributeLogicalNameAttribute("owninguser")
	public Contact setOwningUser(EntityReference value) {
		this.setAttributeValue("owninguser", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Pager")
	@AttributeLogicalNameAttribute("pager")
	public String getPager() {
		return this.getAttributeValue("pager");
	}
	
	@AttributeSchemaNameAttribute("Pager")
	@AttributeLogicalNameAttribute("pager")
	public Contact setPager(String value) {
		this.setAttributeValue("pager", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentContactId")
	@AttributeLogicalNameAttribute("parentcontactid")
	public EntityReference getParentContactId() {
		return this.getAttributeValue("parentcontactid");
	}
	
	@AttributeSchemaNameAttribute("ParentContactId")
	@AttributeLogicalNameAttribute("parentcontactid")
	public Contact setParentContactId(EntityReference value) {
		this.setAttributeValue("parentcontactid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentContactIdName")
	@AttributeLogicalNameAttribute("parentcontactidname")
	public String getParentContactIdName() {
		return this.getAttributeValue("parentcontactidname");
	}
	
	@AttributeSchemaNameAttribute("ParentContactIdName")
	@AttributeLogicalNameAttribute("parentcontactidname")
	public Contact setParentContactIdName(String value) {
		this.setAttributeValue("parentcontactidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentContactIdYomiName")
	@AttributeLogicalNameAttribute("parentcontactidyominame")
	public String getParentContactIdYomiName() {
		return this.getAttributeValue("parentcontactidyominame");
	}
	
	@AttributeSchemaNameAttribute("ParentContactIdYomiName")
	@AttributeLogicalNameAttribute("parentcontactidyominame")
	public Contact setParentContactIdYomiName(String value) {
		this.setAttributeValue("parentcontactidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentCustomerId")
	@AttributeLogicalNameAttribute("parentcustomerid")
	public EntityReference getParentCustomerId() {
		return this.getAttributeValue("parentcustomerid");
	}
	
	@AttributeSchemaNameAttribute("ParentCustomerId")
	@AttributeLogicalNameAttribute("parentcustomerid")
	public Contact setParentCustomerId(EntityReference value) {
		this.setAttributeValue("parentcustomerid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentCustomerIdName")
	@AttributeLogicalNameAttribute("parentcustomeridname")
	public String getParentCustomerIdName() {
		return this.getAttributeValue("parentcustomeridname");
	}
	
	@AttributeSchemaNameAttribute("ParentCustomerIdName")
	@AttributeLogicalNameAttribute("parentcustomeridname")
	public Contact setParentCustomerIdName(String value) {
		this.setAttributeValue("parentcustomeridname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentCustomerIdYomiName")
	@AttributeLogicalNameAttribute("parentcustomeridyominame")
	public String getParentCustomerIdYomiName() {
		return this.getAttributeValue("parentcustomeridyominame");
	}
	
	@AttributeSchemaNameAttribute("ParentCustomerIdYomiName")
	@AttributeLogicalNameAttribute("parentcustomeridyominame")
	public Contact setParentCustomerIdYomiName(String value) {
		this.setAttributeValue("parentcustomeridyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParticipatesInWorkflow")
	@AttributeLogicalNameAttribute("participatesinworkflow")
	public boolean getParticipatesInWorkflow() {
		return this.getAttributeValue("participatesinworkflow");
	}
	
	@AttributeSchemaNameAttribute("ParticipatesInWorkflow")
	@AttributeLogicalNameAttribute("participatesinworkflow")
	public Contact setParticipatesInWorkflow(boolean value) {
		this.setAttributeValue("participatesinworkflow", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PaymentTermsCode")
	@AttributeLogicalNameAttribute("paymenttermscode")
	public OptionSetValue getPaymentTermsCode() {
		return this.getAttributeValue("paymenttermscode");
	}
	
	@AttributeSchemaNameAttribute("PaymentTermsCode")
	@AttributeLogicalNameAttribute("paymenttermscode")
	public Contact setPaymentTermsCode(OptionSetValue value) {
		this.setAttributeValue("paymenttermscode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredAppointmentDayCode")
	@AttributeLogicalNameAttribute("preferredappointmentdaycode")
	public OptionSetValue getPreferredAppointmentDayCode() {
		return this.getAttributeValue("preferredappointmentdaycode");
	}
	
	@AttributeSchemaNameAttribute("PreferredAppointmentDayCode")
	@AttributeLogicalNameAttribute("preferredappointmentdaycode")
	public Contact setPreferredAppointmentDayCode(OptionSetValue value) {
		this.setAttributeValue("preferredappointmentdaycode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredAppointmentTimeCode")
	@AttributeLogicalNameAttribute("preferredappointmenttimecode")
	public OptionSetValue getPreferredAppointmentTimeCode() {
		return this.getAttributeValue("preferredappointmenttimecode");
	}
	
	@AttributeSchemaNameAttribute("PreferredAppointmentTimeCode")
	@AttributeLogicalNameAttribute("preferredappointmenttimecode")
	public Contact setPreferredAppointmentTimeCode(OptionSetValue value) {
		this.setAttributeValue("preferredappointmenttimecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredContactMethodCode")
	@AttributeLogicalNameAttribute("preferredcontactmethodcode")
	public OptionSetValue getPreferredContactMethodCode() {
		return this.getAttributeValue("preferredcontactmethodcode");
	}
	
	@AttributeSchemaNameAttribute("PreferredContactMethodCode")
	@AttributeLogicalNameAttribute("preferredcontactmethodcode")
	public Contact setPreferredContactMethodCode(OptionSetValue value) {
		this.setAttributeValue("preferredcontactmethodcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredEquipmentId")
	@AttributeLogicalNameAttribute("preferredequipmentid")
	public EntityReference getPreferredEquipmentId() {
		return this.getAttributeValue("preferredequipmentid");
	}
	
	@AttributeSchemaNameAttribute("PreferredEquipmentId")
	@AttributeLogicalNameAttribute("preferredequipmentid")
	public Contact setPreferredEquipmentId(EntityReference value) {
		this.setAttributeValue("preferredequipmentid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredEquipmentIdName")
	@AttributeLogicalNameAttribute("preferredequipmentidname")
	public String getPreferredEquipmentIdName() {
		return this.getAttributeValue("preferredequipmentidname");
	}
	
	@AttributeSchemaNameAttribute("PreferredEquipmentIdName")
	@AttributeLogicalNameAttribute("preferredequipmentidname")
	public Contact setPreferredEquipmentIdName(String value) {
		this.setAttributeValue("preferredequipmentidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredServiceId")
	@AttributeLogicalNameAttribute("preferredserviceid")
	public EntityReference getPreferredServiceId() {
		return this.getAttributeValue("preferredserviceid");
	}
	
	@AttributeSchemaNameAttribute("PreferredServiceId")
	@AttributeLogicalNameAttribute("preferredserviceid")
	public Contact setPreferredServiceId(EntityReference value) {
		this.setAttributeValue("preferredserviceid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredServiceIdName")
	@AttributeLogicalNameAttribute("preferredserviceidname")
	public String getPreferredServiceIdName() {
		return this.getAttributeValue("preferredserviceidname");
	}
	
	@AttributeSchemaNameAttribute("PreferredServiceIdName")
	@AttributeLogicalNameAttribute("preferredserviceidname")
	public Contact setPreferredServiceIdName(String value) {
		this.setAttributeValue("preferredserviceidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredSystemUserId")
	@AttributeLogicalNameAttribute("preferredsystemuserid")
	public EntityReference getPreferredSystemUserId() {
		return this.getAttributeValue("preferredsystemuserid");
	}
	
	@AttributeSchemaNameAttribute("PreferredSystemUserId")
	@AttributeLogicalNameAttribute("preferredsystemuserid")
	public Contact setPreferredSystemUserId(EntityReference value) {
		this.setAttributeValue("preferredsystemuserid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredSystemUserIdName")
	@AttributeLogicalNameAttribute("preferredsystemuseridname")
	public String getPreferredSystemUserIdName() {
		return this.getAttributeValue("preferredsystemuseridname");
	}
	
	@AttributeSchemaNameAttribute("PreferredSystemUserIdName")
	@AttributeLogicalNameAttribute("preferredsystemuseridname")
	public Contact setPreferredSystemUserIdName(String value) {
		this.setAttributeValue("preferredsystemuseridname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PreferredSystemUserIdYomiName")
	@AttributeLogicalNameAttribute("preferredsystemuseridyominame")
	public String getPreferredSystemUserIdYomiName() {
		return this.getAttributeValue("preferredsystemuseridyominame");
	}
	
	@AttributeSchemaNameAttribute("PreferredSystemUserIdYomiName")
	@AttributeLogicalNameAttribute("preferredsystemuseridyominame")
	public Contact setPreferredSystemUserIdYomiName(String value) {
		this.setAttributeValue("preferredsystemuseridyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ProcessId")
	@AttributeLogicalNameAttribute("processid")
	public UUID getProcessId() {
		return this.getAttributeValue("processid");
	}
	
	@AttributeSchemaNameAttribute("ProcessId")
	@AttributeLogicalNameAttribute("processid")
	public Contact setProcessId(UUID value) {
		this.setAttributeValue("processid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Salutation")
	@AttributeLogicalNameAttribute("salutation")
	public String getSalutation() {
		return this.getAttributeValue("salutation");
	}
	
	@AttributeSchemaNameAttribute("Salutation")
	@AttributeLogicalNameAttribute("salutation")
	public Contact setSalutation(String value) {
		this.setAttributeValue("salutation", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ShippingMethodCode")
	@AttributeLogicalNameAttribute("shippingmethodcode")
	public OptionSetValue getShippingMethodCode() {
		return this.getAttributeValue("shippingmethodcode");
	}
	
	@AttributeSchemaNameAttribute("ShippingMethodCode")
	@AttributeLogicalNameAttribute("shippingmethodcode")
	public Contact setShippingMethodCode(OptionSetValue value) {
		this.setAttributeValue("shippingmethodcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("SpousesName")
	@AttributeLogicalNameAttribute("spousesname")
	public String getSpousesName() {
		return this.getAttributeValue("spousesname");
	}
	
	@AttributeSchemaNameAttribute("SpousesName")
	@AttributeLogicalNameAttribute("spousesname")
	public Contact setSpousesName(String value) {
		this.setAttributeValue("spousesname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("StageId")
	@AttributeLogicalNameAttribute("stageid")
	public UUID getStageId() {
		return this.getAttributeValue("stageid");
	}
	
	@AttributeSchemaNameAttribute("StageId")
	@AttributeLogicalNameAttribute("stageid")
	public Contact setStageId(UUID value) {
		this.setAttributeValue("stageid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("StateCode")
	@AttributeLogicalNameAttribute("statecode")
	public OptionSetValue getStateCode() {
		return this.getAttributeValue("statecode");
	}
	
	@AttributeSchemaNameAttribute("StateCode")
	@AttributeLogicalNameAttribute("statecode")
	public Contact setStateCode(OptionSetValue value) {
		this.setAttributeValue("statecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("StatusCode")
	@AttributeLogicalNameAttribute("statuscode")
	public OptionSetValue getStatusCode() {
		return this.getAttributeValue("statuscode");
	}
	
	@AttributeSchemaNameAttribute("StatusCode")
	@AttributeLogicalNameAttribute("statuscode")
	public Contact setStatusCode(OptionSetValue value) {
		this.setAttributeValue("statuscode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("SubscriptionId")
	@AttributeLogicalNameAttribute("subscriptionid")
	public UUID getSubscriptionId() {
		return this.getAttributeValue("subscriptionid");
	}
	
	@AttributeSchemaNameAttribute("SubscriptionId")
	@AttributeLogicalNameAttribute("subscriptionid")
	public Contact setSubscriptionId(UUID value) {
		this.setAttributeValue("subscriptionid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Suffix")
	@AttributeLogicalNameAttribute("suffix")
	public String getSuffix() {
		return this.getAttributeValue("suffix");
	}
	
	@AttributeSchemaNameAttribute("Suffix")
	@AttributeLogicalNameAttribute("suffix")
	public Contact setSuffix(String value) {
		this.setAttributeValue("suffix", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Telephone1")
	@AttributeLogicalNameAttribute("telephone1")
	public String getTelephone1() {
		return this.getAttributeValue("telephone1");
	}
	
	@AttributeSchemaNameAttribute("Telephone1")
	@AttributeLogicalNameAttribute("telephone1")
	public Contact setTelephone1(String value) {
		this.setAttributeValue("telephone1", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Telephone2")
	@AttributeLogicalNameAttribute("telephone2")
	public String getTelephone2() {
		return this.getAttributeValue("telephone2");
	}
	
	@AttributeSchemaNameAttribute("Telephone2")
	@AttributeLogicalNameAttribute("telephone2")
	public Contact setTelephone2(String value) {
		this.setAttributeValue("telephone2", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Telephone3")
	@AttributeLogicalNameAttribute("telephone3")
	public String getTelephone3() {
		return this.getAttributeValue("telephone3");
	}
	
	@AttributeSchemaNameAttribute("Telephone3")
	@AttributeLogicalNameAttribute("telephone3")
	public Contact setTelephone3(String value) {
		this.setAttributeValue("telephone3", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TerritoryCode")
	@AttributeLogicalNameAttribute("territorycode")
	public OptionSetValue getTerritoryCode() {
		return this.getAttributeValue("territorycode");
	}
	
	@AttributeSchemaNameAttribute("TerritoryCode")
	@AttributeLogicalNameAttribute("territorycode")
	public Contact setTerritoryCode(OptionSetValue value) {
		this.setAttributeValue("territorycode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TimeZoneRuleVersionNumber")
	@AttributeLogicalNameAttribute("timezoneruleversionnumber")
	public int getTimeZoneRuleVersionNumber() {
		return this.getAttributeValue("timezoneruleversionnumber");
	}
	
	@AttributeSchemaNameAttribute("TimeZoneRuleVersionNumber")
	@AttributeLogicalNameAttribute("timezoneruleversionnumber")
	public Contact setTimeZoneRuleVersionNumber(int value) {
		this.setAttributeValue("timezoneruleversionnumber", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TransactionCurrencyId")
	@AttributeLogicalNameAttribute("transactioncurrencyid")
	public EntityReference getTransactionCurrencyId() {
		return this.getAttributeValue("transactioncurrencyid");
	}
	
	@AttributeSchemaNameAttribute("TransactionCurrencyId")
	@AttributeLogicalNameAttribute("transactioncurrencyid")
	public Contact setTransactionCurrencyId(EntityReference value) {
		this.setAttributeValue("transactioncurrencyid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TransactionCurrencyIdName")
	@AttributeLogicalNameAttribute("transactioncurrencyidname")
	public String getTransactionCurrencyIdName() {
		return this.getAttributeValue("transactioncurrencyidname");
	}
	
	@AttributeSchemaNameAttribute("TransactionCurrencyIdName")
	@AttributeLogicalNameAttribute("transactioncurrencyidname")
	public Contact setTransactionCurrencyIdName(String value) {
		this.setAttributeValue("transactioncurrencyidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TraversedPath")
	@AttributeLogicalNameAttribute("traversedpath")
	public String getTraversedPath() {
		return this.getAttributeValue("traversedpath");
	}
	
	@AttributeSchemaNameAttribute("TraversedPath")
	@AttributeLogicalNameAttribute("traversedpath")
	public Contact setTraversedPath(String value) {
		this.setAttributeValue("traversedpath", value);
		return this;
	}

	@AttributeSchemaNameAttribute("UTCConversionTimeZoneCode")
	@AttributeLogicalNameAttribute("utcconversiontimezonecode")
	public int getUTCConversionTimeZoneCode() {
		return this.getAttributeValue("utcconversiontimezonecode");
	}
	
	@AttributeSchemaNameAttribute("UTCConversionTimeZoneCode")
	@AttributeLogicalNameAttribute("utcconversiontimezonecode")
	public Contact setUTCConversionTimeZoneCode(int value) {
		this.setAttributeValue("utcconversiontimezonecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("VersionNumber")
	@AttributeLogicalNameAttribute("versionnumber")
	public BigInteger getVersionNumber() {
		return this.getAttributeValue("versionnumber");
	}
	
	@AttributeSchemaNameAttribute("VersionNumber")
	@AttributeLogicalNameAttribute("versionnumber")
	public Contact setVersionNumber(BigInteger value) {
		this.setAttributeValue("versionnumber", value);
		return this;
	}

	@AttributeSchemaNameAttribute("WebSiteUrl")
	@AttributeLogicalNameAttribute("websiteurl")
	public String getWebSiteUrl() {
		return this.getAttributeValue("websiteurl");
	}
	
	@AttributeSchemaNameAttribute("WebSiteUrl")
	@AttributeLogicalNameAttribute("websiteurl")
	public Contact setWebSiteUrl(String value) {
		this.setAttributeValue("websiteurl", value);
		return this;
	}

	@AttributeSchemaNameAttribute("YomiFirstName")
	@AttributeLogicalNameAttribute("yomifirstname")
	public String getYomiFirstName() {
		return this.getAttributeValue("yomifirstname");
	}
	
	@AttributeSchemaNameAttribute("YomiFirstName")
	@AttributeLogicalNameAttribute("yomifirstname")
	public Contact setYomiFirstName(String value) {
		this.setAttributeValue("yomifirstname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("YomiFullName")
	@AttributeLogicalNameAttribute("yomifullname")
	public String getYomiFullName() {
		return this.getAttributeValue("yomifullname");
	}
	
	@AttributeSchemaNameAttribute("YomiFullName")
	@AttributeLogicalNameAttribute("yomifullname")
	public Contact setYomiFullName(String value) {
		this.setAttributeValue("yomifullname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("YomiLastName")
	@AttributeLogicalNameAttribute("yomilastname")
	public String getYomiLastName() {
		return this.getAttributeValue("yomilastname");
	}
	
	@AttributeSchemaNameAttribute("YomiLastName")
	@AttributeLogicalNameAttribute("yomilastname")
	public Contact setYomiLastName(String value) {
		this.setAttributeValue("yomilastname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("YomiMiddleName")
	@AttributeLogicalNameAttribute("yomimiddlename")
	public String getYomiMiddleName() {
		return this.getAttributeValue("yomimiddlename");
	}
	
	@AttributeSchemaNameAttribute("YomiMiddleName")
	@AttributeLogicalNameAttribute("yomimiddlename")
	public Contact setYomiMiddleName(String value) {
		this.setAttributeValue("yomimiddlename", value);
		return this;
	}

}

