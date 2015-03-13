package cu.uci.abcd.dao.common;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.common.RecordType;

public interface RecordTypeDAO extends
		PagingAndSortingRepository<RecordType, Long> {
	List<RecordType> findDistinctRecordTypeByNomeclatorNameOrNomenclatorDescription(
			String name, String description);
}
