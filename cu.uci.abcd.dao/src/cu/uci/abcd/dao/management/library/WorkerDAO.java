package cu.uci.abcd.dao.management.library;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import cu.uci.abcd.domain.management.library.Worker;

public interface WorkerDAO extends PagingAndSortingRepository<Worker, Long> {

	List<Worker> findDistinctWorkerByWorkPlace_ActorID(
			Long actorID);
	
}
