package cu.uci.abcd.domain.common;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import cu.uci.abcd.domain.circulation.LoanUser;

@Entity
@Table(name = "dtangibleactor", schema = "abcd")
@DiscriminatorValue(value = "TANGIBLE_ACTOR")
@PrimaryKeyJoinColumn(name = "tangible_actor_id")
@DiscriminatorColumn(name = "tangibleactor_discriminator")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TangibleActor extends Actor {
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.PERSIST)
	protected Account account;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "owner")
	protected LoanUser loanUser;

	public TangibleActor() {
		super();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
		if (!account.getOwner().equals(this)) {
			account.setOwner(this);
		}
	}

	public LoanUser getLoanUser() {
		return loanUser;
	}

	public void setLoanUser(LoanUser loanUser) {
		this.loanUser = loanUser;
	}

}
