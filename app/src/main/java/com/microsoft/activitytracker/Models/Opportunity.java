package com.microsoft.activitytracker.Models;//
//  Opportunity.java
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


@EntityLogicalNameAttribute("opportunity")
public class Opportunity extends Entity {
	
	public static final String EntityLogicalName = "opportunity";
	public static final int EntityTypeCode = 3;
	
	public Opportunity() {
		super("opportunity");
	}

	public static Opportunity build() {
		return new Opportunity();
	}

	@AttributeSchemaNameAttribute("OpportunityId")
	@AttributeLogicalNameAttribute("opportunityid")
	public UUID getOpportunityId() {
		return this.getAttributeValue("opportunityid");
	}
	
	@AttributeSchemaNameAttribute("OpportunityId")
	@AttributeLogicalNameAttribute("opportunityid")
	public Opportunity setOpportunityId(UUID value) {
		this.setAttributeValue("opportunityid", value);
		if (value != null) {
			super.setId(value);
		}
		else {
			super.setId(new UUID(0L, 0L));
		}

		return this;
	}
	
	@Override
	@AttributeSchemaNameAttribute("OpportunityId")
	@AttributeLogicalNameAttribute("opportunityid")
	public UUID getId() {
		return super.getId();
	}
	
	@Override
	@AttributeSchemaNameAttribute("OpportunityId")
	@AttributeLogicalNameAttribute("opportunityid")
	public void setId(UUID value) {
		this.setOpportunityId(value);
	}
	

	@AttributeSchemaNameAttribute("AccountId")
	@AttributeLogicalNameAttribute("accountid")
	public EntityReference getAccountId() {
		return this.getAttributeValue("accountid");
	}
	
	@AttributeSchemaNameAttribute("AccountId")
	@AttributeLogicalNameAttribute("accountid")
	public Opportunity setAccountId(EntityReference value) {
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
	public Opportunity setAccountIdName(String value) {
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
	public Opportunity setAccountIdYomiName(String value) {
		this.setAttributeValue("accountidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ActualCloseDate")
	@AttributeLogicalNameAttribute("actualclosedate")
	public Date getActualCloseDate() {
		return this.getAttributeValue("actualclosedate");
	}
	
	@AttributeSchemaNameAttribute("ActualCloseDate")
	@AttributeLogicalNameAttribute("actualclosedate")
	public Opportunity setActualCloseDate(Date value) {
		this.setAttributeValue("actualclosedate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ActualValue")
	@AttributeLogicalNameAttribute("actualvalue")
	public Money getActualValue() {
		return this.getAttributeValue("actualvalue");
	}
	
	@AttributeSchemaNameAttribute("ActualValue")
	@AttributeLogicalNameAttribute("actualvalue")
	public Opportunity setActualValue(Money value) {
		this.setAttributeValue("actualvalue", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ActualValue_Base")
	@AttributeLogicalNameAttribute("actualvalue_base")
	public Money getActualValue_Base() {
		return this.getAttributeValue("actualvalue_base");
	}
	
	@AttributeSchemaNameAttribute("ActualValue_Base")
	@AttributeLogicalNameAttribute("actualvalue_base")
	public Opportunity setActualValue_Base(Money value) {
		this.setAttributeValue("actualvalue_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("BudgetAmount")
	@AttributeLogicalNameAttribute("budgetamount")
	public Money getBudgetAmount() {
		return this.getAttributeValue("budgetamount");
	}
	
	@AttributeSchemaNameAttribute("BudgetAmount")
	@AttributeLogicalNameAttribute("budgetamount")
	public Opportunity setBudgetAmount(Money value) {
		this.setAttributeValue("budgetamount", value);
		return this;
	}

	@AttributeSchemaNameAttribute("BudgetAmount_Base")
	@AttributeLogicalNameAttribute("budgetamount_base")
	public Money getBudgetAmount_Base() {
		return this.getAttributeValue("budgetamount_base");
	}
	
	@AttributeSchemaNameAttribute("BudgetAmount_Base")
	@AttributeLogicalNameAttribute("budgetamount_base")
	public Opportunity setBudgetAmount_Base(Money value) {
		this.setAttributeValue("budgetamount_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("BudgetStatus")
	@AttributeLogicalNameAttribute("budgetstatus")
	public OptionSetValue getBudgetStatus() {
		return this.getAttributeValue("budgetstatus");
	}
	
	@AttributeSchemaNameAttribute("BudgetStatus")
	@AttributeLogicalNameAttribute("budgetstatus")
	public Opportunity setBudgetStatus(OptionSetValue value) {
		this.setAttributeValue("budgetstatus", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CampaignId")
	@AttributeLogicalNameAttribute("campaignid")
	public EntityReference getCampaignId() {
		return this.getAttributeValue("campaignid");
	}
	
	@AttributeSchemaNameAttribute("CampaignId")
	@AttributeLogicalNameAttribute("campaignid")
	public Opportunity setCampaignId(EntityReference value) {
		this.setAttributeValue("campaignid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CampaignIdName")
	@AttributeLogicalNameAttribute("campaignidname")
	public String getCampaignIdName() {
		return this.getAttributeValue("campaignidname");
	}
	
	@AttributeSchemaNameAttribute("CampaignIdName")
	@AttributeLogicalNameAttribute("campaignidname")
	public Opportunity setCampaignIdName(String value) {
		this.setAttributeValue("campaignidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CaptureProposalFeedback")
	@AttributeLogicalNameAttribute("captureproposalfeedback")
	public boolean getCaptureProposalFeedback() {
		return this.getAttributeValue("captureproposalfeedback");
	}
	
	@AttributeSchemaNameAttribute("CaptureProposalFeedback")
	@AttributeLogicalNameAttribute("captureproposalfeedback")
	public Opportunity setCaptureProposalFeedback(boolean value) {
		this.setAttributeValue("captureproposalfeedback", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CloseProbability")
	@AttributeLogicalNameAttribute("closeprobability")
	public int getCloseProbability() {
		return this.getAttributeValue("closeprobability");
	}
	
	@AttributeSchemaNameAttribute("CloseProbability")
	@AttributeLogicalNameAttribute("closeprobability")
	public Opportunity setCloseProbability(int value) {
		this.setAttributeValue("closeprobability", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CompleteFinalProposal")
	@AttributeLogicalNameAttribute("completefinalproposal")
	public boolean getCompleteFinalProposal() {
		return this.getAttributeValue("completefinalproposal");
	}
	
	@AttributeSchemaNameAttribute("CompleteFinalProposal")
	@AttributeLogicalNameAttribute("completefinalproposal")
	public Opportunity setCompleteFinalProposal(boolean value) {
		this.setAttributeValue("completefinalproposal", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CompleteInternalReview")
	@AttributeLogicalNameAttribute("completeinternalreview")
	public boolean getCompleteInternalReview() {
		return this.getAttributeValue("completeinternalreview");
	}
	
	@AttributeSchemaNameAttribute("CompleteInternalReview")
	@AttributeLogicalNameAttribute("completeinternalreview")
	public Opportunity setCompleteInternalReview(boolean value) {
		this.setAttributeValue("completeinternalreview", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ConfirmInterest")
	@AttributeLogicalNameAttribute("confirminterest")
	public boolean getConfirmInterest() {
		return this.getAttributeValue("confirminterest");
	}
	
	@AttributeSchemaNameAttribute("ConfirmInterest")
	@AttributeLogicalNameAttribute("confirminterest")
	public Opportunity setConfirmInterest(boolean value) {
		this.setAttributeValue("confirminterest", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ContactId")
	@AttributeLogicalNameAttribute("contactid")
	public EntityReference getContactId() {
		return this.getAttributeValue("contactid");
	}
	
	@AttributeSchemaNameAttribute("ContactId")
	@AttributeLogicalNameAttribute("contactid")
	public Opportunity setContactId(EntityReference value) {
		this.setAttributeValue("contactid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ContactIdName")
	@AttributeLogicalNameAttribute("contactidname")
	public String getContactIdName() {
		return this.getAttributeValue("contactidname");
	}
	
	@AttributeSchemaNameAttribute("ContactIdName")
	@AttributeLogicalNameAttribute("contactidname")
	public Opportunity setContactIdName(String value) {
		this.setAttributeValue("contactidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ContactIdYomiName")
	@AttributeLogicalNameAttribute("contactidyominame")
	public String getContactIdYomiName() {
		return this.getAttributeValue("contactidyominame");
	}
	
	@AttributeSchemaNameAttribute("ContactIdYomiName")
	@AttributeLogicalNameAttribute("contactidyominame")
	public Opportunity setContactIdYomiName(String value) {
		this.setAttributeValue("contactidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CreatedBy")
	@AttributeLogicalNameAttribute("createdby")
	public EntityReference getCreatedBy() {
		return this.getAttributeValue("createdby");
	}
	
	@AttributeSchemaNameAttribute("CreatedBy")
	@AttributeLogicalNameAttribute("createdby")
	public Opportunity setCreatedBy(EntityReference value) {
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
	public Opportunity setCreatedByName(String value) {
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
	public Opportunity setCreatedByYomiName(String value) {
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
	public Opportunity setCreatedOn(Date value) {
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
	public Opportunity setCreatedOnBehalfBy(EntityReference value) {
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
	public Opportunity setCreatedOnBehalfByName(String value) {
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
	public Opportunity setCreatedOnBehalfByYomiName(String value) {
		this.setAttributeValue("createdonbehalfbyyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CurrentSituation")
	@AttributeLogicalNameAttribute("currentsituation")
	public String getCurrentSituation() {
		return this.getAttributeValue("currentsituation");
	}
	
	@AttributeSchemaNameAttribute("CurrentSituation")
	@AttributeLogicalNameAttribute("currentsituation")
	public Opportunity setCurrentSituation(String value) {
		this.setAttributeValue("currentsituation", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CustomerId")
	@AttributeLogicalNameAttribute("customerid")
	public EntityReference getCustomerId() {
		return this.getAttributeValue("customerid");
	}
	
	@AttributeSchemaNameAttribute("CustomerId")
	@AttributeLogicalNameAttribute("customerid")
	public Opportunity setCustomerId(EntityReference value) {
		this.setAttributeValue("customerid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CustomerIdName")
	@AttributeLogicalNameAttribute("customeridname")
	public String getCustomerIdName() {
		return this.getAttributeValue("customeridname");
	}
	
	@AttributeSchemaNameAttribute("CustomerIdName")
	@AttributeLogicalNameAttribute("customeridname")
	public Opportunity setCustomerIdName(String value) {
		this.setAttributeValue("customeridname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CustomerIdYomiName")
	@AttributeLogicalNameAttribute("customeridyominame")
	public String getCustomerIdYomiName() {
		return this.getAttributeValue("customeridyominame");
	}
	
	@AttributeSchemaNameAttribute("CustomerIdYomiName")
	@AttributeLogicalNameAttribute("customeridyominame")
	public Opportunity setCustomerIdYomiName(String value) {
		this.setAttributeValue("customeridyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CustomerNeed")
	@AttributeLogicalNameAttribute("customerneed")
	public String getCustomerNeed() {
		return this.getAttributeValue("customerneed");
	}
	
	@AttributeSchemaNameAttribute("CustomerNeed")
	@AttributeLogicalNameAttribute("customerneed")
	public Opportunity setCustomerNeed(String value) {
		this.setAttributeValue("customerneed", value);
		return this;
	}

	@AttributeSchemaNameAttribute("CustomerPainPoints")
	@AttributeLogicalNameAttribute("customerpainpoints")
	public String getCustomerPainPoints() {
		return this.getAttributeValue("customerpainpoints");
	}
	
	@AttributeSchemaNameAttribute("CustomerPainPoints")
	@AttributeLogicalNameAttribute("customerpainpoints")
	public Opportunity setCustomerPainPoints(String value) {
		this.setAttributeValue("customerpainpoints", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DecisionMaker")
	@AttributeLogicalNameAttribute("decisionmaker")
	public boolean getDecisionMaker() {
		return this.getAttributeValue("decisionmaker");
	}
	
	@AttributeSchemaNameAttribute("DecisionMaker")
	@AttributeLogicalNameAttribute("decisionmaker")
	public Opportunity setDecisionMaker(boolean value) {
		this.setAttributeValue("decisionmaker", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Description")
	@AttributeLogicalNameAttribute("description")
	public String getDescription() {
		return this.getAttributeValue("description");
	}
	
	@AttributeSchemaNameAttribute("Description")
	@AttributeLogicalNameAttribute("description")
	public Opportunity setDescription(String value) {
		this.setAttributeValue("description", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DevelopProposal")
	@AttributeLogicalNameAttribute("developproposal")
	public boolean getDevelopProposal() {
		return this.getAttributeValue("developproposal");
	}
	
	@AttributeSchemaNameAttribute("DevelopProposal")
	@AttributeLogicalNameAttribute("developproposal")
	public Opportunity setDevelopProposal(boolean value) {
		this.setAttributeValue("developproposal", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DiscountAmount")
	@AttributeLogicalNameAttribute("discountamount")
	public Money getDiscountAmount() {
		return this.getAttributeValue("discountamount");
	}
	
	@AttributeSchemaNameAttribute("DiscountAmount")
	@AttributeLogicalNameAttribute("discountamount")
	public Opportunity setDiscountAmount(Money value) {
		this.setAttributeValue("discountamount", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DiscountAmount_Base")
	@AttributeLogicalNameAttribute("discountamount_base")
	public Money getDiscountAmount_Base() {
		return this.getAttributeValue("discountamount_base");
	}
	
	@AttributeSchemaNameAttribute("DiscountAmount_Base")
	@AttributeLogicalNameAttribute("discountamount_base")
	public Opportunity setDiscountAmount_Base(Money value) {
		this.setAttributeValue("discountamount_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("DiscountPercentage")
	@AttributeLogicalNameAttribute("discountpercentage")
	public BigDecimal getDiscountPercentage() {
		return this.getAttributeValue("discountpercentage");
	}
	
	@AttributeSchemaNameAttribute("DiscountPercentage")
	@AttributeLogicalNameAttribute("discountpercentage")
	public Opportunity setDiscountPercentage(BigDecimal value) {
		this.setAttributeValue("discountpercentage", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EstimatedCloseDate")
	@AttributeLogicalNameAttribute("estimatedclosedate")
	public Date getEstimatedCloseDate() {
		return this.getAttributeValue("estimatedclosedate");
	}
	
	@AttributeSchemaNameAttribute("EstimatedCloseDate")
	@AttributeLogicalNameAttribute("estimatedclosedate")
	public Opportunity setEstimatedCloseDate(Date value) {
		this.setAttributeValue("estimatedclosedate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EstimatedValue")
	@AttributeLogicalNameAttribute("estimatedvalue")
	public Money getEstimatedValue() {
		return this.getAttributeValue("estimatedvalue");
	}
	
	@AttributeSchemaNameAttribute("EstimatedValue")
	@AttributeLogicalNameAttribute("estimatedvalue")
	public Opportunity setEstimatedValue(Money value) {
		this.setAttributeValue("estimatedvalue", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EstimatedValue_Base")
	@AttributeLogicalNameAttribute("estimatedvalue_base")
	public Money getEstimatedValue_Base() {
		return this.getAttributeValue("estimatedvalue_base");
	}
	
	@AttributeSchemaNameAttribute("EstimatedValue_Base")
	@AttributeLogicalNameAttribute("estimatedvalue_base")
	public Opportunity setEstimatedValue_Base(Money value) {
		this.setAttributeValue("estimatedvalue_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("EvaluateFit")
	@AttributeLogicalNameAttribute("evaluatefit")
	public boolean getEvaluateFit() {
		return this.getAttributeValue("evaluatefit");
	}
	
	@AttributeSchemaNameAttribute("EvaluateFit")
	@AttributeLogicalNameAttribute("evaluatefit")
	public Opportunity setEvaluateFit(boolean value) {
		this.setAttributeValue("evaluatefit", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ExchangeRate")
	@AttributeLogicalNameAttribute("exchangerate")
	public BigDecimal getExchangeRate() {
		return this.getAttributeValue("exchangerate");
	}
	
	@AttributeSchemaNameAttribute("ExchangeRate")
	@AttributeLogicalNameAttribute("exchangerate")
	public Opportunity setExchangeRate(BigDecimal value) {
		this.setAttributeValue("exchangerate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FileDebrief")
	@AttributeLogicalNameAttribute("filedebrief")
	public boolean getFileDebrief() {
		return this.getAttributeValue("filedebrief");
	}
	
	@AttributeSchemaNameAttribute("FileDebrief")
	@AttributeLogicalNameAttribute("filedebrief")
	public Opportunity setFileDebrief(boolean value) {
		this.setAttributeValue("filedebrief", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FinalDecisionDate")
	@AttributeLogicalNameAttribute("finaldecisiondate")
	public Date getFinalDecisionDate() {
		return this.getAttributeValue("finaldecisiondate");
	}
	
	@AttributeSchemaNameAttribute("FinalDecisionDate")
	@AttributeLogicalNameAttribute("finaldecisiondate")
	public Opportunity setFinalDecisionDate(Date value) {
		this.setAttributeValue("finaldecisiondate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FreightAmount")
	@AttributeLogicalNameAttribute("freightamount")
	public Money getFreightAmount() {
		return this.getAttributeValue("freightamount");
	}
	
	@AttributeSchemaNameAttribute("FreightAmount")
	@AttributeLogicalNameAttribute("freightamount")
	public Opportunity setFreightAmount(Money value) {
		this.setAttributeValue("freightamount", value);
		return this;
	}

	@AttributeSchemaNameAttribute("FreightAmount_Base")
	@AttributeLogicalNameAttribute("freightamount_base")
	public Money getFreightAmount_Base() {
		return this.getAttributeValue("freightamount_base");
	}
	
	@AttributeSchemaNameAttribute("FreightAmount_Base")
	@AttributeLogicalNameAttribute("freightamount_base")
	public Opportunity setFreightAmount_Base(Money value) {
		this.setAttributeValue("freightamount_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IdentifyCompetitors")
	@AttributeLogicalNameAttribute("identifycompetitors")
	public boolean getIdentifyCompetitors() {
		return this.getAttributeValue("identifycompetitors");
	}
	
	@AttributeSchemaNameAttribute("IdentifyCompetitors")
	@AttributeLogicalNameAttribute("identifycompetitors")
	public Opportunity setIdentifyCompetitors(boolean value) {
		this.setAttributeValue("identifycompetitors", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IdentifyCustomerContacts")
	@AttributeLogicalNameAttribute("identifycustomercontacts")
	public boolean getIdentifyCustomerContacts() {
		return this.getAttributeValue("identifycustomercontacts");
	}
	
	@AttributeSchemaNameAttribute("IdentifyCustomerContacts")
	@AttributeLogicalNameAttribute("identifycustomercontacts")
	public Opportunity setIdentifyCustomerContacts(boolean value) {
		this.setAttributeValue("identifycustomercontacts", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IdentifyPursuitTeam")
	@AttributeLogicalNameAttribute("identifypursuitteam")
	public boolean getIdentifyPursuitTeam() {
		return this.getAttributeValue("identifypursuitteam");
	}
	
	@AttributeSchemaNameAttribute("IdentifyPursuitTeam")
	@AttributeLogicalNameAttribute("identifypursuitteam")
	public Opportunity setIdentifyPursuitTeam(boolean value) {
		this.setAttributeValue("identifypursuitteam", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ImportSequenceNumber")
	@AttributeLogicalNameAttribute("importsequencenumber")
	public int getImportSequenceNumber() {
		return this.getAttributeValue("importsequencenumber");
	}
	
	@AttributeSchemaNameAttribute("ImportSequenceNumber")
	@AttributeLogicalNameAttribute("importsequencenumber")
	public Opportunity setImportSequenceNumber(int value) {
		this.setAttributeValue("importsequencenumber", value);
		return this;
	}

	@AttributeSchemaNameAttribute("InitialCommunication")
	@AttributeLogicalNameAttribute("initialcommunication")
	public OptionSetValue getInitialCommunication() {
		return this.getAttributeValue("initialcommunication");
	}
	
	@AttributeSchemaNameAttribute("InitialCommunication")
	@AttributeLogicalNameAttribute("initialcommunication")
	public Opportunity setInitialCommunication(OptionSetValue value) {
		this.setAttributeValue("initialcommunication", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IsPrivate")
	@AttributeLogicalNameAttribute("isprivate")
	public boolean getIsPrivate() {
		return this.getAttributeValue("isprivate");
	}
	
	@AttributeSchemaNameAttribute("IsPrivate")
	@AttributeLogicalNameAttribute("isprivate")
	public Opportunity setIsPrivate(boolean value) {
		this.setAttributeValue("isprivate", value);
		return this;
	}

	@AttributeSchemaNameAttribute("IsRevenueSystemCalculated")
	@AttributeLogicalNameAttribute("isrevenuesystemcalculated")
	public boolean getIsRevenueSystemCalculated() {
		return this.getAttributeValue("isrevenuesystemcalculated");
	}
	
	@AttributeSchemaNameAttribute("IsRevenueSystemCalculated")
	@AttributeLogicalNameAttribute("isrevenuesystemcalculated")
	public Opportunity setIsRevenueSystemCalculated(boolean value) {
		this.setAttributeValue("isrevenuesystemcalculated", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ModifiedBy")
	@AttributeLogicalNameAttribute("modifiedby")
	public EntityReference getModifiedBy() {
		return this.getAttributeValue("modifiedby");
	}
	
	@AttributeSchemaNameAttribute("ModifiedBy")
	@AttributeLogicalNameAttribute("modifiedby")
	public Opportunity setModifiedBy(EntityReference value) {
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
	public Opportunity setModifiedByName(String value) {
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
	public Opportunity setModifiedByYomiName(String value) {
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
	public Opportunity setModifiedOn(Date value) {
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
	public Opportunity setModifiedOnBehalfBy(EntityReference value) {
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
	public Opportunity setModifiedOnBehalfByName(String value) {
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
	public Opportunity setModifiedOnBehalfByYomiName(String value) {
		this.setAttributeValue("modifiedonbehalfbyyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Name")
	@AttributeLogicalNameAttribute("name")
	public String getName() {
		return this.getAttributeValue("name");
	}
	
	@AttributeSchemaNameAttribute("Name")
	@AttributeLogicalNameAttribute("name")
	public Opportunity setName(String value) {
		this.setAttributeValue("name", value);
		return this;
	}

	@AttributeSchemaNameAttribute("Need")
	@AttributeLogicalNameAttribute("need")
	public OptionSetValue getNeed() {
		return this.getAttributeValue("need");
	}
	
	@AttributeSchemaNameAttribute("Need")
	@AttributeLogicalNameAttribute("need")
	public Opportunity setNeed(OptionSetValue value) {
		this.setAttributeValue("need", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OpportunityRatingCode")
	@AttributeLogicalNameAttribute("opportunityratingcode")
	public OptionSetValue getOpportunityRatingCode() {
		return this.getAttributeValue("opportunityratingcode");
	}
	
	@AttributeSchemaNameAttribute("OpportunityRatingCode")
	@AttributeLogicalNameAttribute("opportunityratingcode")
	public Opportunity setOpportunityRatingCode(OptionSetValue value) {
		this.setAttributeValue("opportunityratingcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("OriginatingLeadId")
	@AttributeLogicalNameAttribute("originatingleadid")
	public EntityReference getOriginatingLeadId() {
		return this.getAttributeValue("originatingleadid");
	}
	
	@AttributeSchemaNameAttribute("OriginatingLeadId")
	@AttributeLogicalNameAttribute("originatingleadid")
	public Opportunity setOriginatingLeadId(EntityReference value) {
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
	public Opportunity setOriginatingLeadIdName(String value) {
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
	public Opportunity setOriginatingLeadIdYomiName(String value) {
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
	public Opportunity setOverriddenCreatedOn(Date value) {
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
	public Opportunity setOwnerId(EntityReference value) {
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
	public Opportunity setOwnerIdName(String value) {
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
	public Opportunity setOwnerIdYomiName(String value) {
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
	public Opportunity setOwningBusinessUnit(EntityReference value) {
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
	public Opportunity setOwningTeam(EntityReference value) {
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
	public Opportunity setOwningUser(EntityReference value) {
		this.setAttributeValue("owninguser", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentAccountId")
	@AttributeLogicalNameAttribute("parentaccountid")
	public EntityReference getParentAccountId() {
		return this.getAttributeValue("parentaccountid");
	}
	
	@AttributeSchemaNameAttribute("ParentAccountId")
	@AttributeLogicalNameAttribute("parentaccountid")
	public Opportunity setParentAccountId(EntityReference value) {
		this.setAttributeValue("parentaccountid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentAccountIdName")
	@AttributeLogicalNameAttribute("parentaccountidname")
	public String getParentAccountIdName() {
		return this.getAttributeValue("parentaccountidname");
	}
	
	@AttributeSchemaNameAttribute("ParentAccountIdName")
	@AttributeLogicalNameAttribute("parentaccountidname")
	public Opportunity setParentAccountIdName(String value) {
		this.setAttributeValue("parentaccountidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentAccountIdYomiName")
	@AttributeLogicalNameAttribute("parentaccountidyominame")
	public String getParentAccountIdYomiName() {
		return this.getAttributeValue("parentaccountidyominame");
	}
	
	@AttributeSchemaNameAttribute("ParentAccountIdYomiName")
	@AttributeLogicalNameAttribute("parentaccountidyominame")
	public Opportunity setParentAccountIdYomiName(String value) {
		this.setAttributeValue("parentaccountidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParentContactId")
	@AttributeLogicalNameAttribute("parentcontactid")
	public EntityReference getParentContactId() {
		return this.getAttributeValue("parentcontactid");
	}
	
	@AttributeSchemaNameAttribute("ParentContactId")
	@AttributeLogicalNameAttribute("parentcontactid")
	public Opportunity setParentContactId(EntityReference value) {
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
	public Opportunity setParentContactIdName(String value) {
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
	public Opportunity setParentContactIdYomiName(String value) {
		this.setAttributeValue("parentcontactidyominame", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ParticipatesInWorkflow")
	@AttributeLogicalNameAttribute("participatesinworkflow")
	public boolean getParticipatesInWorkflow() {
		return this.getAttributeValue("participatesinworkflow");
	}
	
	@AttributeSchemaNameAttribute("ParticipatesInWorkflow")
	@AttributeLogicalNameAttribute("participatesinworkflow")
	public Opportunity setParticipatesInWorkflow(boolean value) {
		this.setAttributeValue("participatesinworkflow", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PresentFinalProposal")
	@AttributeLogicalNameAttribute("presentfinalproposal")
	public boolean getPresentFinalProposal() {
		return this.getAttributeValue("presentfinalproposal");
	}
	
	@AttributeSchemaNameAttribute("PresentFinalProposal")
	@AttributeLogicalNameAttribute("presentfinalproposal")
	public Opportunity setPresentFinalProposal(boolean value) {
		this.setAttributeValue("presentfinalproposal", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PresentProposal")
	@AttributeLogicalNameAttribute("presentproposal")
	public boolean getPresentProposal() {
		return this.getAttributeValue("presentproposal");
	}
	
	@AttributeSchemaNameAttribute("PresentProposal")
	@AttributeLogicalNameAttribute("presentproposal")
	public Opportunity setPresentProposal(boolean value) {
		this.setAttributeValue("presentproposal", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PriceLevelId")
	@AttributeLogicalNameAttribute("pricelevelid")
	public EntityReference getPriceLevelId() {
		return this.getAttributeValue("pricelevelid");
	}
	
	@AttributeSchemaNameAttribute("PriceLevelId")
	@AttributeLogicalNameAttribute("pricelevelid")
	public Opportunity setPriceLevelId(EntityReference value) {
		this.setAttributeValue("pricelevelid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PriceLevelIdName")
	@AttributeLogicalNameAttribute("pricelevelidname")
	public String getPriceLevelIdName() {
		return this.getAttributeValue("pricelevelidname");
	}
	
	@AttributeSchemaNameAttribute("PriceLevelIdName")
	@AttributeLogicalNameAttribute("pricelevelidname")
	public Opportunity setPriceLevelIdName(String value) {
		this.setAttributeValue("pricelevelidname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PricingErrorCode")
	@AttributeLogicalNameAttribute("pricingerrorcode")
	public OptionSetValue getPricingErrorCode() {
		return this.getAttributeValue("pricingerrorcode");
	}
	
	@AttributeSchemaNameAttribute("PricingErrorCode")
	@AttributeLogicalNameAttribute("pricingerrorcode")
	public Opportunity setPricingErrorCode(OptionSetValue value) {
		this.setAttributeValue("pricingerrorcode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PriorityCode")
	@AttributeLogicalNameAttribute("prioritycode")
	public OptionSetValue getPriorityCode() {
		return this.getAttributeValue("prioritycode");
	}
	
	@AttributeSchemaNameAttribute("PriorityCode")
	@AttributeLogicalNameAttribute("prioritycode")
	public Opportunity setPriorityCode(OptionSetValue value) {
		this.setAttributeValue("prioritycode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ProcessId")
	@AttributeLogicalNameAttribute("processid")
	public UUID getProcessId() {
		return this.getAttributeValue("processid");
	}
	
	@AttributeSchemaNameAttribute("ProcessId")
	@AttributeLogicalNameAttribute("processid")
	public Opportunity setProcessId(UUID value) {
		this.setAttributeValue("processid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ProposedSolution")
	@AttributeLogicalNameAttribute("proposedsolution")
	public String getProposedSolution() {
		return this.getAttributeValue("proposedsolution");
	}
	
	@AttributeSchemaNameAttribute("ProposedSolution")
	@AttributeLogicalNameAttribute("proposedsolution")
	public Opportunity setProposedSolution(String value) {
		this.setAttributeValue("proposedsolution", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PurchaseProcess")
	@AttributeLogicalNameAttribute("purchaseprocess")
	public OptionSetValue getPurchaseProcess() {
		return this.getAttributeValue("purchaseprocess");
	}
	
	@AttributeSchemaNameAttribute("PurchaseProcess")
	@AttributeLogicalNameAttribute("purchaseprocess")
	public Opportunity setPurchaseProcess(OptionSetValue value) {
		this.setAttributeValue("purchaseprocess", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PurchaseTimeframe")
	@AttributeLogicalNameAttribute("purchasetimeframe")
	public OptionSetValue getPurchaseTimeframe() {
		return this.getAttributeValue("purchasetimeframe");
	}
	
	@AttributeSchemaNameAttribute("PurchaseTimeframe")
	@AttributeLogicalNameAttribute("purchasetimeframe")
	public Opportunity setPurchaseTimeframe(OptionSetValue value) {
		this.setAttributeValue("purchasetimeframe", value);
		return this;
	}

	@AttributeSchemaNameAttribute("PursuitDecision")
	@AttributeLogicalNameAttribute("pursuitdecision")
	public boolean getPursuitDecision() {
		return this.getAttributeValue("pursuitdecision");
	}
	
	@AttributeSchemaNameAttribute("PursuitDecision")
	@AttributeLogicalNameAttribute("pursuitdecision")
	public Opportunity setPursuitDecision(boolean value) {
		this.setAttributeValue("pursuitdecision", value);
		return this;
	}

	@AttributeSchemaNameAttribute("QualificationComments")
	@AttributeLogicalNameAttribute("qualificationcomments")
	public String getQualificationComments() {
		return this.getAttributeValue("qualificationcomments");
	}
	
	@AttributeSchemaNameAttribute("QualificationComments")
	@AttributeLogicalNameAttribute("qualificationcomments")
	public Opportunity setQualificationComments(String value) {
		this.setAttributeValue("qualificationcomments", value);
		return this;
	}

	@AttributeSchemaNameAttribute("QuoteComments")
	@AttributeLogicalNameAttribute("quotecomments")
	public String getQuoteComments() {
		return this.getAttributeValue("quotecomments");
	}
	
	@AttributeSchemaNameAttribute("QuoteComments")
	@AttributeLogicalNameAttribute("quotecomments")
	public Opportunity setQuoteComments(String value) {
		this.setAttributeValue("quotecomments", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ResolveFeedback")
	@AttributeLogicalNameAttribute("resolvefeedback")
	public boolean getResolveFeedback() {
		return this.getAttributeValue("resolvefeedback");
	}
	
	@AttributeSchemaNameAttribute("ResolveFeedback")
	@AttributeLogicalNameAttribute("resolvefeedback")
	public Opportunity setResolveFeedback(boolean value) {
		this.setAttributeValue("resolvefeedback", value);
		return this;
	}

	@AttributeSchemaNameAttribute("SalesStage")
	@AttributeLogicalNameAttribute("salesstage")
	public OptionSetValue getSalesStage() {
		return this.getAttributeValue("salesstage");
	}
	
	@AttributeSchemaNameAttribute("SalesStage")
	@AttributeLogicalNameAttribute("salesstage")
	public Opportunity setSalesStage(OptionSetValue value) {
		this.setAttributeValue("salesstage", value);
		return this;
	}

	@AttributeSchemaNameAttribute("SalesStageCode")
	@AttributeLogicalNameAttribute("salesstagecode")
	public OptionSetValue getSalesStageCode() {
		return this.getAttributeValue("salesstagecode");
	}
	
	@AttributeSchemaNameAttribute("SalesStageCode")
	@AttributeLogicalNameAttribute("salesstagecode")
	public Opportunity setSalesStageCode(OptionSetValue value) {
		this.setAttributeValue("salesstagecode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ScheduleFollowup_Prospect")
	@AttributeLogicalNameAttribute("schedulefollowup_prospect")
	public Date getScheduleFollowup_Prospect() {
		return this.getAttributeValue("schedulefollowup_prospect");
	}
	
	@AttributeSchemaNameAttribute("ScheduleFollowup_Prospect")
	@AttributeLogicalNameAttribute("schedulefollowup_prospect")
	public Opportunity setScheduleFollowup_Prospect(Date value) {
		this.setAttributeValue("schedulefollowup_prospect", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ScheduleFollowup_Qualify")
	@AttributeLogicalNameAttribute("schedulefollowup_qualify")
	public Date getScheduleFollowup_Qualify() {
		return this.getAttributeValue("schedulefollowup_qualify");
	}
	
	@AttributeSchemaNameAttribute("ScheduleFollowup_Qualify")
	@AttributeLogicalNameAttribute("schedulefollowup_qualify")
	public Opportunity setScheduleFollowup_Qualify(Date value) {
		this.setAttributeValue("schedulefollowup_qualify", value);
		return this;
	}

	@AttributeSchemaNameAttribute("ScheduleProposalMeeting")
	@AttributeLogicalNameAttribute("scheduleproposalmeeting")
	public Date getScheduleProposalMeeting() {
		return this.getAttributeValue("scheduleproposalmeeting");
	}
	
	@AttributeSchemaNameAttribute("ScheduleProposalMeeting")
	@AttributeLogicalNameAttribute("scheduleproposalmeeting")
	public Opportunity setScheduleProposalMeeting(Date value) {
		this.setAttributeValue("scheduleproposalmeeting", value);
		return this;
	}

	@AttributeSchemaNameAttribute("SendThankYouNote")
	@AttributeLogicalNameAttribute("sendthankyounote")
	public boolean getSendThankYouNote() {
		return this.getAttributeValue("sendthankyounote");
	}
	
	@AttributeSchemaNameAttribute("SendThankYouNote")
	@AttributeLogicalNameAttribute("sendthankyounote")
	public Opportunity setSendThankYouNote(boolean value) {
		this.setAttributeValue("sendthankyounote", value);
		return this;
	}

	@AttributeSchemaNameAttribute("StageId")
	@AttributeLogicalNameAttribute("stageid")
	public UUID getStageId() {
		return this.getAttributeValue("stageid");
	}
	
	@AttributeSchemaNameAttribute("StageId")
	@AttributeLogicalNameAttribute("stageid")
	public Opportunity setStageId(UUID value) {
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
	public Opportunity setStateCode(OptionSetValue value) {
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
	public Opportunity setStatusCode(OptionSetValue value) {
		this.setAttributeValue("statuscode", value);
		return this;
	}

	@AttributeSchemaNameAttribute("StepId")
	@AttributeLogicalNameAttribute("stepid")
	public UUID getStepId() {
		return this.getAttributeValue("stepid");
	}
	
	@AttributeSchemaNameAttribute("StepId")
	@AttributeLogicalNameAttribute("stepid")
	public Opportunity setStepId(UUID value) {
		this.setAttributeValue("stepid", value);
		return this;
	}

	@AttributeSchemaNameAttribute("StepName")
	@AttributeLogicalNameAttribute("stepname")
	public String getStepName() {
		return this.getAttributeValue("stepname");
	}
	
	@AttributeSchemaNameAttribute("StepName")
	@AttributeLogicalNameAttribute("stepname")
	public Opportunity setStepName(String value) {
		this.setAttributeValue("stepname", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TimeLine")
	@AttributeLogicalNameAttribute("timeline")
	public OptionSetValue getTimeLine() {
		return this.getAttributeValue("timeline");
	}
	
	@AttributeSchemaNameAttribute("TimeLine")
	@AttributeLogicalNameAttribute("timeline")
	public Opportunity setTimeLine(OptionSetValue value) {
		this.setAttributeValue("timeline", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TimeZoneRuleVersionNumber")
	@AttributeLogicalNameAttribute("timezoneruleversionnumber")
	public int getTimeZoneRuleVersionNumber() {
		return this.getAttributeValue("timezoneruleversionnumber");
	}
	
	@AttributeSchemaNameAttribute("TimeZoneRuleVersionNumber")
	@AttributeLogicalNameAttribute("timezoneruleversionnumber")
	public Opportunity setTimeZoneRuleVersionNumber(int value) {
		this.setAttributeValue("timezoneruleversionnumber", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalAmount")
	@AttributeLogicalNameAttribute("totalamount")
	public Money getTotalAmount() {
		return this.getAttributeValue("totalamount");
	}
	
	@AttributeSchemaNameAttribute("TotalAmount")
	@AttributeLogicalNameAttribute("totalamount")
	public Opportunity setTotalAmount(Money value) {
		this.setAttributeValue("totalamount", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalAmount_Base")
	@AttributeLogicalNameAttribute("totalamount_base")
	public Money getTotalAmount_Base() {
		return this.getAttributeValue("totalamount_base");
	}
	
	@AttributeSchemaNameAttribute("TotalAmount_Base")
	@AttributeLogicalNameAttribute("totalamount_base")
	public Opportunity setTotalAmount_Base(Money value) {
		this.setAttributeValue("totalamount_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalAmountLessFreight")
	@AttributeLogicalNameAttribute("totalamountlessfreight")
	public Money getTotalAmountLessFreight() {
		return this.getAttributeValue("totalamountlessfreight");
	}
	
	@AttributeSchemaNameAttribute("TotalAmountLessFreight")
	@AttributeLogicalNameAttribute("totalamountlessfreight")
	public Opportunity setTotalAmountLessFreight(Money value) {
		this.setAttributeValue("totalamountlessfreight", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalAmountLessFreight_Base")
	@AttributeLogicalNameAttribute("totalamountlessfreight_base")
	public Money getTotalAmountLessFreight_Base() {
		return this.getAttributeValue("totalamountlessfreight_base");
	}
	
	@AttributeSchemaNameAttribute("TotalAmountLessFreight_Base")
	@AttributeLogicalNameAttribute("totalamountlessfreight_base")
	public Opportunity setTotalAmountLessFreight_Base(Money value) {
		this.setAttributeValue("totalamountlessfreight_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalDiscountAmount")
	@AttributeLogicalNameAttribute("totaldiscountamount")
	public Money getTotalDiscountAmount() {
		return this.getAttributeValue("totaldiscountamount");
	}
	
	@AttributeSchemaNameAttribute("TotalDiscountAmount")
	@AttributeLogicalNameAttribute("totaldiscountamount")
	public Opportunity setTotalDiscountAmount(Money value) {
		this.setAttributeValue("totaldiscountamount", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalDiscountAmount_Base")
	@AttributeLogicalNameAttribute("totaldiscountamount_base")
	public Money getTotalDiscountAmount_Base() {
		return this.getAttributeValue("totaldiscountamount_base");
	}
	
	@AttributeSchemaNameAttribute("TotalDiscountAmount_Base")
	@AttributeLogicalNameAttribute("totaldiscountamount_base")
	public Opportunity setTotalDiscountAmount_Base(Money value) {
		this.setAttributeValue("totaldiscountamount_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalLineItemAmount")
	@AttributeLogicalNameAttribute("totallineitemamount")
	public Money getTotalLineItemAmount() {
		return this.getAttributeValue("totallineitemamount");
	}
	
	@AttributeSchemaNameAttribute("TotalLineItemAmount")
	@AttributeLogicalNameAttribute("totallineitemamount")
	public Opportunity setTotalLineItemAmount(Money value) {
		this.setAttributeValue("totallineitemamount", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalLineItemAmount_Base")
	@AttributeLogicalNameAttribute("totallineitemamount_base")
	public Money getTotalLineItemAmount_Base() {
		return this.getAttributeValue("totallineitemamount_base");
	}
	
	@AttributeSchemaNameAttribute("TotalLineItemAmount_Base")
	@AttributeLogicalNameAttribute("totallineitemamount_base")
	public Opportunity setTotalLineItemAmount_Base(Money value) {
		this.setAttributeValue("totallineitemamount_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalLineItemDiscountAmount")
	@AttributeLogicalNameAttribute("totallineitemdiscountamount")
	public Money getTotalLineItemDiscountAmount() {
		return this.getAttributeValue("totallineitemdiscountamount");
	}
	
	@AttributeSchemaNameAttribute("TotalLineItemDiscountAmount")
	@AttributeLogicalNameAttribute("totallineitemdiscountamount")
	public Opportunity setTotalLineItemDiscountAmount(Money value) {
		this.setAttributeValue("totallineitemdiscountamount", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalLineItemDiscountAmount_Base")
	@AttributeLogicalNameAttribute("totallineitemdiscountamount_base")
	public Money getTotalLineItemDiscountAmount_Base() {
		return this.getAttributeValue("totallineitemdiscountamount_base");
	}
	
	@AttributeSchemaNameAttribute("TotalLineItemDiscountAmount_Base")
	@AttributeLogicalNameAttribute("totallineitemdiscountamount_base")
	public Opportunity setTotalLineItemDiscountAmount_Base(Money value) {
		this.setAttributeValue("totallineitemdiscountamount_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalTax")
	@AttributeLogicalNameAttribute("totaltax")
	public Money getTotalTax() {
		return this.getAttributeValue("totaltax");
	}
	
	@AttributeSchemaNameAttribute("TotalTax")
	@AttributeLogicalNameAttribute("totaltax")
	public Opportunity setTotalTax(Money value) {
		this.setAttributeValue("totaltax", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TotalTax_Base")
	@AttributeLogicalNameAttribute("totaltax_base")
	public Money getTotalTax_Base() {
		return this.getAttributeValue("totaltax_base");
	}
	
	@AttributeSchemaNameAttribute("TotalTax_Base")
	@AttributeLogicalNameAttribute("totaltax_base")
	public Opportunity setTotalTax_Base(Money value) {
		this.setAttributeValue("totaltax_base", value);
		return this;
	}

	@AttributeSchemaNameAttribute("TransactionCurrencyId")
	@AttributeLogicalNameAttribute("transactioncurrencyid")
	public EntityReference getTransactionCurrencyId() {
		return this.getAttributeValue("transactioncurrencyid");
	}
	
	@AttributeSchemaNameAttribute("TransactionCurrencyId")
	@AttributeLogicalNameAttribute("transactioncurrencyid")
	public Opportunity setTransactionCurrencyId(EntityReference value) {
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
	public Opportunity setTransactionCurrencyIdName(String value) {
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
	public Opportunity setTraversedPath(String value) {
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
	public Opportunity setUTCConversionTimeZoneCode(int value) {
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
	public Opportunity setVersionNumber(BigInteger value) {
		this.setAttributeValue("versionnumber", value);
		return this;
	}

}

