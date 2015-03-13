package cu.uci.abcd.dao.common;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.common.EmailAddress;

public interface EmailAddressDAO extends
		PagingAndSortingRepository<EmailAddress, Long> {

}
