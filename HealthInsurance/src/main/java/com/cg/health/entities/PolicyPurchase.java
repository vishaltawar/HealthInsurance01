package com.cg.health.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PolicyPurchase")

public class PolicyPurchase {
	@Id
	@Column(name="policyPurchaseId")
	@GeneratedValue(strategy= GenerationType.AUTO)

	private long policyPurchaseId;
	private double premiumAmount;
	private int policyPuchaseDuration;
	private LocalDate purchaseDate;
	private LocalDate purchaseEndDate;
	@ManyToOne
	@JoinColumn(name="policyId")
	private Policy policy;
	@ManyToOne
	@JoinColumn(name="userId")
	private PolicyUser policyUser;
	public PolicyPurchase(long policyPurchaseId, double premiumAmount, int policyPuchaseDuration, LocalDate purchaseDate,
			LocalDate purchaseEndDate, Policy policy, PolicyUser policyUser) {
		super();
		this.policyPurchaseId = policyPurchaseId;
		this.premiumAmount = premiumAmount;
		this.policyPuchaseDuration = policyPuchaseDuration;
		this.purchaseDate = purchaseDate;
		this.purchaseEndDate = purchaseEndDate;
		this.policy = policy;
		this.policyUser = policyUser;
	}
	public PolicyPurchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getPolicyPurchaseId() {
		return policyPurchaseId;
	}
	public void setPolicyPurchaseId(long policyPurchaseId) {
		this.policyPurchaseId = policyPurchaseId;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public int getPolicyPuchaseDuration() {
		return policyPuchaseDuration;
	}
	public void setPolicyPuchaseDuration(int policyPuchaseDuration) {
		this.policyPuchaseDuration = policyPuchaseDuration;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public LocalDate getPurchaseEndDate() {
		return purchaseEndDate;
	}
	public void setPurchaseEndDate(LocalDate purchaseEndDate) {
		this.purchaseEndDate = purchaseEndDate;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public PolicyUser getPolicyUser() {
		return policyUser;
	}
	public void setPolicyUser(PolicyUser policyUser) {
		this.policyUser = policyUser;
	}
	@Override
	public String toString() {
		return "PolicyPurchase [policyPurchaseId=" + policyPurchaseId + ", premiumAmount=" + premiumAmount
				+ ", policyPuchaseDuration=" + policyPuchaseDuration + ", purchaseDate=" + purchaseDate
				+ ", purchaseEndDate=" + purchaseEndDate + ", policy=" + policy + ", policyUser=" + policyUser + "]";
	}
	

	
	
	
}
