package cu.uci.abcd.dao.management.library;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.management.library.Library;

public interface LibraryDAO extends PagingAndSortingRepository<Library, Long> {

	List<Library> findDistinctLibraryByLibraryName(String libraryName);

	List<Library> findByLibraryNameLike(String libraryName);

	@Query("select l from Library l, Account a where a.accountID = ?1 and a.accountLibrary.actorID = l.actorID")
	Library findLibraryByAcountIDMember(Long accountID);
}
