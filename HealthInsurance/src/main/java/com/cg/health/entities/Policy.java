package com.cg.health.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Policies")
public class Policy {
	 @Id
	// @Column(name = "policyId")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	int policyId;
	String policyName;
	float policyCost;
	int policyDurationInYear;
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public float getPolicyCost() {
		return policyCost;
	}
	public void setPolicyCost(float policyCost) {
		this.policyCost = policyCost;
	}
	public int getPolicyDurationInYear() {
		return policyDurationInYear;
	}
	public void setPolicyDurationInYear(int policyDurationInYear) {
		this.policyDurationInYear = policyDurationInYear;
	}
	
	//Default Constructor
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Field Constructor
	public Policy(int policyId, String policyName, float policyCost, int policyDurationInYear) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyCost = policyCost;
		this.policyDurationInYear = policyDurationInYear;
	}
	
	//Override toString Method from Object class
//	@Override
//	public String toString() {
//		return "Policies [policyId=" + policyId + ", policyName=" + policyName + ", policyCost=" + policyCost
//				+ ", policyDuration=" + policyDurationInYear + "]";
//	}
	
	
	
	

}