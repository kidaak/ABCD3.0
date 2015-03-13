package cu.uci.abcd.dao.common;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.common.PostalAddress;

public interface PostalAddressDAO extends
		PagingAndSortingRepository<PostalAddress, Long> {
	
	List<PostalAddress> findDistinctPostalAddressByOwner_ActorID(
            Long actorID);
	
}
