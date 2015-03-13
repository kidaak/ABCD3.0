package cu.uci.abcd.administration.library.ui.model;

import java.sql.Date;
import java.util.List;

import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Worker;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class WorkerGrid extends Worker implements IGridViewEntity {

	private Worker worker;
	
	/*
	
	public WorkerGrid(Long workerID, Date registerDate, String observation, WorkerType workerType, Person personWorker, Library workPlace) {
		super();
		this.setWorkerID(workerID);
		this.setRegisterDate(registerDate);
		this.setObservation(observation);
		this.setWorkerType(workerType);
		this.setPersonWorker(personWorker);
		this.setWorkPlace(workPlace);
	}
	
	public WorkerGrid(Date registerDate, String observation, WorkerType workerType, Person personWorker, Library workPlace) {
		super();
		this.setRegisterDate(registerDate);
		this.setObservation(observation);
		this.setWorkerType(workerType);
		this.setPersonWorker(personWorker);
		this.setWorkPlace(workPlace);
	}
	
	public WorkerGrid(Date registerDate, String observation, WorkerType workerType, Person personWorker) {
		super();
		this.setRegisterDate(registerDate);
		this.setObservation(observation);
		this.setWorkerType(workerType);
		this.setPersonWorker(personWorker);
	}

	
	public WorkerGrid(Long workerID, Date registerDate, String observation, WorkerType workerType, Person personWorker) {
		super();
		this.setWorkerID(workerID);
		this.setRegisterDate(registerDate);
		this.setObservation(observation);
		this.setWorkerType(workerType);
		this.setPersonWorker(personWorker);
	}
	*/
	
	public WorkerGrid(Worker worker) {
		this.worker =  worker;
	}
	
	@TreeTableColumn(percentWidth = 33, index=0)
	public String getWorkerName() {
		return getWorker().getPersonWorker().getFirstName();
	}
	@TreeTableColumn(percentWidth = 33, index=1)
	public String getWorkerObservation() {
		return getWorker().getObservation();
	}
	@TreeTableColumn(percentWidth = 33, index=2)
	public Date getRegisterDate() {
		return getWorker().getRegisterDate();
	}
	
	@Override
	public void addChild(IGridViewEntity child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	
}
