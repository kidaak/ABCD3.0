package cu.uci.abcd.domain.common;

import java.sql.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.security.Profile;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "daccount", schema = "abcd")
public class Account {
	@Id
	@TableGenerator(name = "ACCOUNT_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "ACCOUNT_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ACCOUNT_GEN")
	@Column(name = "account_id")
	private Long accountID;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password", length = 500)
	private String password;
	@Column(name = "creation_date")
	private Date creationDate;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	private TangibleActor owner;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "account_library_id", nullable = false)
	private Library accountLibrary;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "daccountprofile", schema = "abcd", joinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "account_id") }, inverseJoinColumns = { @JoinColumn(name = "profile_id", referencedColumnName = "profile_id") })
	private List<Profile> assignedProfiles;

	public Account() {
		super();
		assignedProfiles = new ArrayList<>();
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TangibleActor getOwner() {
		return owner;
	}

	public void setOwner(TangibleActor owner) {
		this.owner = owner;
		if (owner.getAccount() != this) {
			owner.setAccount(this);
		}
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		Account other = (Account) obj;
		if (accountID == null) {
			if (other.accountID != null)
				return false;
		} else if (!accountID.equals(other.accountID))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	public List<Profile> getAssignedProfiles() {
		return assignedProfiles;
	}

	public void setAssignedProfiles(List<Profile> assignedProfiles) {
		this.assignedProfiles = assignedProfiles;
	}

	public Profile addAssignedProfile(Profile profile) {
		this.assignedProfiles.add(profile);
		if (!profile.getAssignedAccounts().contains(this)) {
			profile.getAssignedAccounts().add(this);
		}
		return profile;
	}

	@PrePersist
	private void generateCreationDate() {
		this.creationDate = DomainUtil.CURRENT_DATE;
	}

	@Override
	public String toString() {
		return "Account username: " + this.userName;
	}

	public Library getAccountLibrary() {
		return accountLibrary;
	}

	public void setAccountLibrary(Library accountLibrary) {
		this.accountLibrary = accountLibrary;
	}

}
