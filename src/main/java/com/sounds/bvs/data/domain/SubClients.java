package com.sounds.bvs.data.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="SUB_CLN_HDR_TB")
public class SubClients implements Serializable {

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

	@ManyToOne
	@JoinColumn(name="CLIENT_ID",
	foreignKey = @ForeignKey(name="C_ID_SK"))
	private Clients clients;

	@ElementCollection
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy="subClients")
	private Set<Profiles> profiles;

	@Column(name="BUSINESS_TYPE", length=100)
    private String businessType;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST,  mappedBy="subClients")
	private SubClientsDetails subClientsDetails;

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

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public Set<Profiles> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profiles> profiles) {
		this.profiles = profiles;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public SubClientsDetails getSubClientsDetails() {
		return subClientsDetails;
	}

	public void setSubClientsDetails(SubClientsDetails subClientsDetails) {
		this.subClientsDetails = subClientsDetails;
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
		if (!(obj instanceof SubClients))
			return false;
		SubClients other = (SubClients) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
