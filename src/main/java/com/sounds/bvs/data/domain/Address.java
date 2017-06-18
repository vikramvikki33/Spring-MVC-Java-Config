package com.sounds.bvs.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ADDRESS_LINE1" , nullable=true)
	private String addressLine1;

	@Column(name="ADDRESS_LINE2" , nullable=true)
	private String addressLine2;

	@Column(name="ADDRESS_LINE3" , nullable=true)
	private String addressLine3;

	@Column(name="CITY", length=50, nullable=true)
    private String city;

	@Column(name="COUNTRY", length=25, nullable=true)
    private String country;

	@Column(name="PRY_EMAIL_ID", length=50,  nullable=true)
	private String primaryEmailId;

	@Column(name="SEC_EMAIL_ID", length=50,  nullable=true)
	private String secondaryEmailId;

	@Column(name="PIN", length=6, nullable=true)
    private String pin;

	@Column(name="PER_PHN", length=10, nullable=true)
    private String personalPhone;

	@Column(name="OFF_PHN", length=10, nullable=true)
    private String officePhone;

	@Column(name="PER_MOB", nullable=true)
    private String personalMobile;

	@Column(name="OFF_MOB", length=10, nullable=true)
    private String officeMobile;

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the primaryEmailId
	 */
	public String getPrimaryEmailId() {
		return primaryEmailId;
	}

	/**
	 * @param primaryEmailId the primaryEmailId to set
	 */
	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}

	/**
	 * @return the secondaryEmailId
	 */
	public String getSecondaryEmailId() {
		return secondaryEmailId;
	}

	/**
	 * @param secondaryEmailId the secondaryEmailId to set
	 */
	public void setSecondaryEmailId(String secondaryEmailId) {
		this.secondaryEmailId = secondaryEmailId;
	}

	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * @return the personalPhone
	 */
	public String getPersonalPhone() {
		return personalPhone;
	}

	/**
	 * @param personalPhone the personalPhone to set
	 */
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}

	/**
	 * @return the officePhone
	 */
	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * @param officePhone the officePhone to set
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	/**
	 * @return the personalMobile
	 */
	public String getPersonalMobile() {
		return personalMobile;
	}

	/**
	 * @param personalMobile the personalMobile to set
	 */
	public void setPersonalMobile(String personalMobile) {
		this.personalMobile = personalMobile;
	}

	/**
	 * @return the officeMobile
	 */
	public String getOfficeMobile() {
		return officeMobile;
	}

	/**
	 * @param officeMobile the officeMobile to set
	 */
	public void setOfficeMobile(String officeMobile) {
		this.officeMobile = officeMobile;
	}
}
