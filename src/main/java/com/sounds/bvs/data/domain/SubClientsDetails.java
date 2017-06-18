package com.sounds.bvs.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="SUB_CLN_DTL_TB")
public class SubClientsDetails implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name="SYSID")
	private Long id;

	@Column(name="VERSION")
	@Version
	private int version;

	@Embedded
	private AuditDetails auditDetails;

	@Column(name="BUSS_DESC", length=50)
	private String busnessDescription;

	@Embedded
	private AddressDetails addressDetails;

	@OneToOne
	@JoinColumn(name="SUB_ID", foreignKey=@ForeignKey(name="SS_ID_SK"))
	private SubClients subClients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	public String getBusnessDescription() {
		return busnessDescription;
	}

	public void setBusnessDescription(String busnessDescription) {
		this.busnessDescription = busnessDescription;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	public SubClients getSubClients() {
		return subClients;
	}

	public void setSubClients(SubClients subClients) {
		this.subClients = subClients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SubClientsDetails))
			return false;
		SubClientsDetails other = (SubClientsDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
