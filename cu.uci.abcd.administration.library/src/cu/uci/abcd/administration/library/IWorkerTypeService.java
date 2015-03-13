package cu.uci.abcd.administration.library;

import java.util.Collection;
import cu.uci.abcd.domain.common.WorkerType;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface IWorkerTypeService {

	public Collection<WorkerType> findAll();
}
