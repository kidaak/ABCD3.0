package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IProviderService;
import cu.uci.abcd.administration.library.IWorkerService;
import cu.uci.abcd.dao.management.library.LibraryDAO;
import cu.uci.abcd.dao.management.library.ProviderDAO;
import cu.uci.abcd.dao.management.library.WorkerDAO;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abcd.domain.management.library.Worker;

public class WorkerServiceImpl implements IWorkerService{
	
	private WorkerDAO workerDAO;

	public void bind(WorkerDAO workerDAO, Map<?, ?> properties) {
		this.workerDAO = workerDAO;
	}
	
	@Override
	public Worker AddWorker(Worker worker) {
		return workerDAO.save(worker);
	}

	@Override
	public Worker ReadWorker(Long idWorker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Worker UpdateWorker(Long idWorker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteWorker(Long idWorker) {
		workerDAO.delete(idWorker);
	}

	@Override
	public Collection<Worker> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Worker> findByLibrary(Long idLibrary) {
		return (Collection<Worker>) workerDAO.findDistinctWorkerByWorkPlace_ActorID(idLibrary);
	}

}
