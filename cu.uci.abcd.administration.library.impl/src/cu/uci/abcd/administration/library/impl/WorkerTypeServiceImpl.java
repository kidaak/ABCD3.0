package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IProviderService;
import cu.uci.abcd.administration.library.IWorkerTypeService;
import cu.uci.abcd.dao.common.PersonDAO;
import cu.uci.abcd.dao.common.WorkerTypeDAO;
import cu.uci.abcd.dao.management.library.ProviderDAO;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abcd.domain.management.library.Provider;

public class WorkerTypeServiceImpl implements IWorkerTypeService{
	
	private WorkerTypeDAO workerTypeDAO;

	public void bind(WorkerTypeDAO workerTypeDAO, Map<?, ?> properties) {
		this.workerTypeDAO = workerTypeDAO;
	}
	
	@Override
	public Collection<WorkerType> findAll() {
		return (Collection<WorkerType>) workerTypeDAO.findAll();
	}

}
