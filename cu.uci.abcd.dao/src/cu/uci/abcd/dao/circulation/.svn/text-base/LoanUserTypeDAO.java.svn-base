package cu.uci.abcd.dao.circulation;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.circulation.LoanUserType;

public interface LoanUserTypeDAO extends
		PagingAndSortingRepository<LoanUserType, Long> {
	List<LoanUserType> findDistinctLoanUserTypeByNomeclatorNameOrNomenclatorDescription(
			String name, String description);
}
