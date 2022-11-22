package com.survey.jobdata.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sv_salary")
public class JobData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sid")
	Long sid;

	@Column(name = "timestamp")
	protected String timestamp;

	@Column(name = "employer")
	protected String employer;

	@Column(name = "location")
	protected String location;

	@Column(name = "job_title")
	protected String jobTitle;

	@Column(name = "years_at_employer")
	protected double empYears;
	
	@Column(name = "years_of_experience")
	protected double expYears;

	@Column(name = "salary")
	protected double salary;

	@Column(name = "signing_bonus")
	protected double signingBonus;

	@Column(name = "annual_bonus")
	protected double annualBonus;

	@Column(name = "annual_stock_value")
	protected double annualStockValue;

	@Column(name = "gender")
	protected String gender;

	@Column(name = "additional_comments",columnDefinition="LONGTEXT")
	protected String additionalComments;

}
