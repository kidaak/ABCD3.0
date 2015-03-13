package cu.uci.abcd.dao.circulation;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.circulation.Transaction;

public interface TransactionDAO extends
		PagingAndSortingRepository<Transaction, Long> {

}
