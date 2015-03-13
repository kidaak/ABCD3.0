package cu.uci.abcd.dao.circulation;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.circulation.Penalty;

public interface PenaltyDAO extends PagingAndSortingRepository<Penalty, Long> {

	List<Penalty> findDistinctPenaltyByLoanUser_LoanUserID(Long loanUserID);

}
