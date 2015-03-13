package cu.uci.abcd.domain.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import cu.uci.abcd.domain.management.library.Worker;

@Entity
@DiscriminatorValue(value = "WORKERTYPE")
public class WorkerType extends Nomenclator {
	@OneToMany(mappedBy = "workerType", fetch = FetchType.LAZY)
	private List<Worker> workers;

	public WorkerType() {
		super();
		workers = new ArrayList<>();
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

}
