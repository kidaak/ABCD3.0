package cu.uci.abcd.domain.management.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.common.Account;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dprofile", schema = "abcd")
public class Profile {
	@Id
	@TableGenerator(name = "PROFILE_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "PROFILE_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PROFILE_GEN")
	@Column(name = "profile_id")
	private Long profileID;
	@Column(name = "profile_name")
	private String profileName;
	@Column(name = "description")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	private Library owner;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "dprofilepermission", schema = "abcd", joinColumns = { @JoinColumn(name = "profile_id", referencedColumnName = "profile_id") }, inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "permission_id") })
	private List<Permission> assignedPermissions;
	@ManyToMany(mappedBy = "assignedProfiles", fetch = FetchType.LAZY)
	private List<Account> assignedAccounts;

	public Profile() {
		super();
		assignedPermissions = new ArrayList<>();
		assignedAccounts = new ArrayList<>();
	}

	public Long getProfileID() {
		return profileID;
	}

	public void setProfileID(Long profileID) {
		this.profileID = profileID;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Library getOwner() {
		return owner;
	}

	public void setOwner(Library owner) {
		this.owner = owner;
		if (!owner.getProfiles().contains(this)) {
			owner.getProfiles().add(this);
		}
	}

	public List<Permission> getAssignedPermissions() {
		return assignedPermissions;
	}

	public void setAssignedPermissions(List<Permission> assignedPermissions) {
		this.assignedPermissions = assignedPermissions;
	}

	public List<Account> getAssignedAccounts() {
		return assignedAccounts;
	}

	public void setAssignedAccounts(List<Account> assignedAccounts) {
		this.assignedAccounts = assignedAccounts;
	}

	@Override
	public int hashCode() {
		int[] codes = new int[] { ((owner == null) ? 0 : owner.hashCode()),
				((profileID == null) ? 0 : profileID.hashCode()) };
		return DomainUtil.hashCodeGenerator(codes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (profileID == null) {
			if (other.profileID != null)
				return false;
		} else if (!profileID.equals(other.profileID))
			return false;
		return true;
	}

	public Permission addPermission(Permission permission) {
		this.assignedPermissions.add(permission);
		if (!permission.getAssignedProfiles().contains(this)) {
			permission.getAssignedProfiles().add(this);
		}
		return permission;
	}
}