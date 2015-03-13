package cu.uci.abcd.domain.management.library;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dworker", schema = "abcd")
public class Worker {
	@Id
	@TableGenerator(name = "WORKER_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "WORKER_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "WORKER_GEN")
	@Column(name = "worker_id")
	private Long workerID;
	@Column(name = "register_date", nullable = false)
	private Date registerDate;
	@Column(name = "observation", length = 500)
	private String observation;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "worker_type_id", nullable = false)
	private WorkerType workerType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	private Person personWorker;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_place_id", nullable = false)
	private Library workPlace;

	public Long getWorkerID() {
		return workerID;
	}

	public void setWorkerID(Long workerID) {
		this.workerID = workerID;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public WorkerType getWorkerType() {
		return workerType;
	}

	public void setWorkerType(WorkerType workerType) {
		this.workerType = workerType;
	}

	public Person getPersonWorker() {
		return personWorker;
	}

	public void setPersonWorker(Person personWorker) {
		this.personWorker = personWorker;
		if (!personWorker.getWorkerRole().contains(this)) {
			personWorker.getWorkerRole().add(this);
		}
	}

	public Library getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(Library workPlace) {
		this.workPlace = workPlace;
		if (!workPlace.getWorkerList().contains(this)) {
			workPlace.getWorkerList().add(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((workerID == null) ? 0 : workerID.hashCode());
		result = prime * result
				+ ((personWorker == null) ? 0 : personWorker.hashCode())
				+ ((workPlace == null) ? 0 : workPlace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (workerID == null) {
			if (other.getWorkerID() != null)
				return false;
		} else if (!workerID.equals(other.getWorkerID()))
			return false;
		if (personWorker == null) {
			if (other.getPersonWorker() != null)
				return false;
		} else if (!personWorker.equals(other.getPersonWorker()))
			return false;
		if (workPlace == null) {
			if (other.getWorkPlace() != null)
				return false;
		} else if (!workPlace.equals(other.getWorkPlace()))
			return false;
		return true;
	}

}
