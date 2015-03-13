package cu.uci.abcd.dao.circulation;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.circulation.LoanUser;

public interface LoanUserDAO extends PagingAndSortingRepository<LoanUser, Long> {

	List<LoanUser> findDistinctByLoanUser(String loanUserName);
	
	LoanUser findDistinctLoanUserByLoanUserCode(String loanUserCode);

}
