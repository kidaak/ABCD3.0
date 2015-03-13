package cu.uci.abcd.domain.management.library;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import cu.uci.abcd.domain.common.LoanObject;
import cu.uci.abcd.domain.common.Nomenclator;
import cu.uci.abcd.domain.common.TangibleActor;
import cu.uci.abcd.domain.management.security.Profile;

@Entity
@Table(name = "dlibrary", schema = "abcd")
@PrimaryKeyJoinColumn(name = "library_id")
@DiscriminatorValue(value = "LIBRARY")
public class Library extends TangibleActor {
	@Column(name = "library_name")
	private String libraryName;
	@Column(name = "library_surface")
	private Double librarySurface;
	@Column(name = "room_quantity")
	private Integer roomQuantity;
	@Column(name = "available_reading_seats")
	private Integer availableReadingSeats;
	@Column(name = "available_user_formation_seats")
	private Integer availableUserFormationSeats;
	@Column(name = "available_work_group_seats")
	private Integer availableWorkGroupSeats;
	@Column(name = "open_book_shelves")
	private Double openBookShelves;
	@Column(name = "deposit_book_shelves")
	private Double depositBookShelves;
	@Column(name = "user_pc_quantity")
	private Integer userPcQuantity;
	@Column(name = "worker_pc_quantity")
	private Integer workerPcQuantity;
	@Column(name = "diverse_reader_player_quantity")
	private Integer diverseReaderPlayerQuantity;
	@OneToMany(mappedBy = "ownerLibrary", cascade = CascadeType.ALL)
	private List<FormationCourse> formationCourseList;
	@OneToMany(mappedBy = "libraryOwner")
	private List<LoanObject> loanObjectList;
	@OneToMany(mappedBy = "owner")
	private List<Profile> profiles;
	@OneToMany(mappedBy = "ownerLibrary")
	private List<Calendar> calendarList;
	@OneToMany(mappedBy = "workPlace", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Worker> workerList;
	@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
	private PenaltyEquation penaltyEquation;
	@OneToMany(mappedBy = "ownerLibrary", cascade = CascadeType.ALL)
	private List<Nomenclator> nomenclators;

	public Library() {
		super();
		formationCourseList = new ArrayList<>();
		loanObjectList = new ArrayList<>();
		profiles = new ArrayList<>();
		calendarList = new ArrayList<>();
		workerList = new ArrayList<>();
		nomenclators = new ArrayList<>();
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public Double getLibrarySurface() {
		return librarySurface;
	}

	public void setLibrarySurface(Double librarySurface) {
		this.librarySurface = librarySurface;
	}

	public Integer getRoomQuantity() {
		return roomQuantity;
	}

	public void setRoomQuantity(Integer roomQuantity) {
		this.roomQuantity = roomQuantity;
	}

	public Integer getAvailableReadingSeats() {
		return availableReadingSeats;
	}

	public void setAvailableReadingSeats(Integer availableReadingSeats) {
		this.availableReadingSeats = availableReadingSeats;
	}

	public Integer getAvailableUserFormationSeats() {
		return availableUserFormationSeats;
	}

	public void setAvailableUserFormationSeats(
			Integer availableUserFormationSeats) {
		this.availableUserFormationSeats = availableUserFormationSeats;
	}

	public Integer getAvailableWorkGroupSeats() {
		return availableWorkGroupSeats;
	}

	public void setAvailableWorkGroupSeats(Integer availableWorkGroupSeats) {
		this.availableWorkGroupSeats = availableWorkGroupSeats;
	}

	public Double getOpenBookShelves() {
		return openBookShelves;
	}

	public void setOpenBookShelves(Double openBookShelves) {
		this.openBookShelves = openBookShelves;
	}

	public Double getDepositBookShelves() {
		return depositBookShelves;
	}

	public void setDepositBookShelves(Double depositBookShelves) {
		this.depositBookShelves = depositBookShelves;
	}

	public Integer getUserPcQuantity() {
		return userPcQuantity;
	}

	public void setUserPcQuantity(Integer userPcQuantity) {
		this.userPcQuantity = userPcQuantity;
	}

	public Integer getWorkerPcQuantity() {
		return workerPcQuantity;
	}

	public void setWorkerPcQuantity(Integer workerPcQuantity) {
		this.workerPcQuantity = workerPcQuantity;
	}

	public Integer getDiverseReaderPlayerQuantity() {
		return diverseReaderPlayerQuantity;
	}

	public void setDiverseReaderPlayerQuantity(
			Integer diverseReaderPlayerQuantity) {
		this.diverseReaderPlayerQuantity = diverseReaderPlayerQuantity;
	}

	public List<FormationCourse> getFormationCourseList() {
		return formationCourseList;
	}

	public void setFormationCourseList(List<FormationCourse> formationCourseList) {
		this.formationCourseList = formationCourseList;
	}

	public List<LoanObject> getLoanObjectList() {
		return loanObjectList;
	}

	public void setLoanObjectList(List<LoanObject> loanObjectList) {
		this.loanObjectList = loanObjectList;
	}

	public List<Nomenclator> getNomenclators() {
		return nomenclators;
	}

	public void setNomenclators(List<Nomenclator> nomenclators) {
		this.nomenclators = nomenclators;
	}

	public FormationCourse addFormationCourse(FormationCourse course) {
		this.formationCourseList.add(course);
		if (course.getOwnerLibrary() != this) {
			course.setOwnerLibrary(this);
		}
		return course;
	}

	public LoanObject addLoanObject(LoanObject loanObject) {
		this.loanObjectList.add(loanObject);
		if (loanObject.getLibraryOwner() != this) {
			loanObject.setLibraryOwner(this);
		}
		return loanObject;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public List<Calendar> getCalendarList() {
		return calendarList;
	}

	public void setCalendarList(List<Calendar> calendarList) {
		this.calendarList = calendarList;
	}

	public List<Worker> getWorkerList() {
		return workerList;
	}

	public void setWorkerList(List<Worker> workerList) {
		this.workerList = workerList;
	}

	public Worker addWorker(Worker worker) {
		this.workerList.add(worker);
		if (worker.getWorkPlace() != this) {
			worker.setWorkPlace(this);
		}
		return worker;
	}

	public PenaltyEquation getPenaltyEquation() {
		return penaltyEquation;
	}

	public void setPenaltyEquation(PenaltyEquation penaltyEquation) {
		this.penaltyEquation = penaltyEquation;
		if (!penaltyEquation.getOwner().equals(this)) {
			penaltyEquation.setOwner(this);
		}
	}

}
