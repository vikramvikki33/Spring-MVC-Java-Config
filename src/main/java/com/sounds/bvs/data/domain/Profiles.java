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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "PROFILES")
public class Profiles implements Serializable {

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
	@JoinColumn(name = "CLIENT_ID", foreignKey = @ForeignKey(name = "P_C_ID_SK"))
	private Clients clients;

	@ManyToOne
	@JoinColumn(name = "SUB_CLIENT_ID", foreignKey = @ForeignKey(name = "P_S_ID_SK"))
	private SubClients subClients;

	@Column(name = "PROFILE_NAME", length = 50)
	private String profileName;

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

	public SubClients getSubClients() {
		return subClients;
	}

	public void setSubClients(SubClients subClients) {
		this.subClients = subClients;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
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
		if (!(obj instanceof Profiles))
			return false;
		Profiles other = (Profiles) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
