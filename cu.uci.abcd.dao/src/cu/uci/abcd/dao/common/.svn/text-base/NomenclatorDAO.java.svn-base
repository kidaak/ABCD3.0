package cu.uci.abcd.dao.common;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.common.Nomenclator;

public interface NomenclatorDAO extends
		PagingAndSortingRepository<Nomenclator, Long> {

	@Query("select n from Nomenclator n where n.ownerLibrary.actorID = ?1")
	List<Nomenclator> findByOwnerLibrary(Long actorID);

}
