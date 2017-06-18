/**
 *
 */
package com.sounds.bvs.data.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Vikram
 *
 */
@Entity
@Table(name = "CLN_HDR_TB")
public class Clients implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name="SYSID")
	private Long id;

	@Column(name="VERSION")
	@Version
	private int version;

	@NotBlank(message = "Client Name can't be Blank")
	@Size(min = 3, max = 50, message = "Client Name should be greater then 3 Characters Or Less Then 50 Characters")
	@Column(name = "CLIENT_NAME", length = 50, unique = true)
	private String clientName;

	@ElementCollection
	@OneToMany(mappedBy = "clients", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private Set<SubClients> subClientsSet;


	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST,  mappedBy="clients")
	private ClientsDetails clientDetails;

	@Embedded
	private AuditDetails auditDetails;

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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Set<SubClients> getSubClientsSet() {
		return subClientsSet;
	}

	public void setSubClientsSet(Set<SubClients> subClientsSet) {
		this.subClientsSet = subClientsSet;
	}

	public ClientsDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientsDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
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
		if (!(obj instanceof Clients))
			return false;
		Clients other = (Clients) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
