package cu.uci.abcd.domain.management.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.common.CommonData;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dpermission", schema = "abcd")
public class Permission {
	@Id
	@TableGenerator(name = "PERMISSION_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "PERMISSION_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PERMISSION_GEN")
	@Column(name = "permission_id")
	private Long permissionID;
	@Column(name = "functionality_identifier", unique = true)
	private String functionalityIdentifier;
	@Embedded
	private CommonData commonData;
	@ManyToMany(mappedBy = "assignedPermissions", fetch = FetchType.LAZY)
	private List<Profile> assignedProfiles;

	public Permission() {
		super();
		assignedProfiles = new ArrayList<>();
	}

	public Long getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(Long permissionID) {
		this.permissionID = permissionID;
	}

	public String getFunctionalityIdentifier() {
		return functionalityIdentifier;
	}

	public void setFunctionalityIdentifier(String functionalityIdentifier) {
		this.functionalityIdentifier = functionalityIdentifier;
	}

	public List<Profile> getAssignedProfiles() {
		return assignedProfiles;
	}

	public void setAssignedProfiles(List<Profile> assignedProfiles) {
		this.assignedProfiles = assignedProfiles;
	}

	
	public CommonData getCommonData() {
		return commonData;
	}

	public void setCommonData(CommonData commonData) {
		this.commonData = commonData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((functionalityIdentifier == null) ? 0
						: functionalityIdentifier.hashCode());
		result = prime * result
				+ ((permissionID == null) ? 0 : permissionID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		if (functionalityIdentifier == null) {
			if (other.functionalityIdentifier != null)
				return false;
		} else if (!functionalityIdentifier
				.equals(other.functionalityIdentifier))
			return false;
		if (permissionID == null) {
			if (other.permissionID != null)
				return false;
		} else if (!permissionID.equals(other.permissionID))
			return false;
		return true;
	}

}
