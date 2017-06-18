/**
 *
 */
package com.sounds.bvs.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author Vikram
 *
 */
@Embeddable
public class AddressDetails implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "CONTACT_PERSON_NAME", length = 50)
	private String contactPersonName;

	@Column(name = "CONTACT_REFERENCE", length = 50)
	private String contactReference;

	@Embedded
	private Address address;

	/**
	 * @return the contactPersonName
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}

	/**
	 * @param contactPersonName the contactPersonName to set
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	/**
	 * @return the contactReference
	 */
	public String getContactReference() {
		return contactReference;
	}

	/**
	 * @param contactReference the contactReference to set
	 */
	public void setContactReference(String contactReference) {
		this.contactReference = contactReference;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
