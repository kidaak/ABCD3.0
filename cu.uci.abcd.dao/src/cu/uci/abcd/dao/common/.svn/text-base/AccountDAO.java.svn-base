package cu.uci.abcd.dao.common;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.common.Account;

public interface AccountDAO extends PagingAndSortingRepository<Account, Long> {
	public Account findByUserNameAndPassword(String userName, String password);	
}
