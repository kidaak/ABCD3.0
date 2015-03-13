package cu.uci.abcd.dao.management.library;
import org.springframework.data.repository.PagingAndSortingRepository;
import cu.uci.abcd.domain.management.library.PenaltyEquation;

public interface PenaltyEquationDAO
		extends
		PagingAndSortingRepository<cu.uci.abcd.domain.management.library.PenaltyEquation, Long> {

	PenaltyEquation findDistinctPenaltyEquationByOwner_ActorID(
			Long actorID);
	
}
