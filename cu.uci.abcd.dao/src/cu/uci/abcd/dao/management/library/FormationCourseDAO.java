package cu.uci.abcd.dao.management.library;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.management.library.FormationCourse;

public interface FormationCourseDAO extends
		PagingAndSortingRepository<FormationCourse, Long> {
	
	List<FormationCourse> findDistinctFormationCourseByOwnerLibrary_LibraryName(
			String libraryName);
	
	List<FormationCourse> findDistinctFormationCourseByOwnerLibrary_ActorID(
			Long actorID);
}
