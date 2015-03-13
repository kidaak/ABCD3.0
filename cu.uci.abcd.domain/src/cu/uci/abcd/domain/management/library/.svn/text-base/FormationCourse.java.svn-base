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

import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dformationcourse", schema = "abcd")
public class FormationCourse {
	@Id
	@TableGenerator(name = "FORMATION_COURSE_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "FORMATION_COURSE_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "FORMATION_COURSE_GEN")
	@Column(name = "formation_course_id")
	private Long formationCourseID;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "hour_quantity")
	private Integer hourQuantity;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "external_teacher_quantity")
	private Integer externalTeacherQuantity;
	@Column(name = "worker_teacher_quantity")
	private Integer workerTeacherQuantity;
	@Column(name = "student_quantity")
	private Integer externalStudentQuantity;
	@Column(name = "worker_student_quantity")
	private Integer workerStudentQuantity;
	@Column(name = "description")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_library_id")
	private Library ownerLibrary;

	public Long getFormationCourseID() {
		return formationCourseID;
	}

	public void setFormationCourseID(Long formationCourseID) {
		this.formationCourseID = formationCourseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getHourQuantity() {
		return hourQuantity;
	}

	public void setHourQuantity(Integer hourQuantity) {
		this.hourQuantity = hourQuantity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getExternalTeacherQuantity() {
		return externalTeacherQuantity;
	}

	public void setExternalTeacherQuantity(Integer externalTeacherQuantity) {
		this.externalTeacherQuantity = externalTeacherQuantity;
	}

	public Integer getWorkerTeacherQuantity() {
		return workerTeacherQuantity;
	}

	public void setWorkerTeacherQuantity(Integer workerTeacherQuantity) {
		this.workerTeacherQuantity = workerTeacherQuantity;
	}

	public Integer getExternalStudentQuantity() {
		return externalStudentQuantity;
	}

	public void setExternalStudentQuantity(Integer externalStudentQuantity) {
		this.externalStudentQuantity = externalStudentQuantity;
	}

	public Integer getWorkerStudentQuantity() {
		return workerStudentQuantity;
	}

	public void setWorkerStudentQuantity(Integer workerStudentQuantity) {
		this.workerStudentQuantity = workerStudentQuantity;
	}

	public Library getOwnerLibrary() {
		return ownerLibrary;
	}

	public void setOwnerLibrary(Library ownerLibrary) {
		this.ownerLibrary = ownerLibrary;
		if (!ownerLibrary.getFormationCourseList().contains(this)) {
			ownerLibrary.getFormationCourseList().add(this);
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		int[] codes = new int[] {
				((formationCourseID == null) ? 0 : formationCourseID.hashCode()),
				((ownerLibrary == null) ? 0 : ownerLibrary.hashCode()) };
		return DomainUtil.hashCodeGenerator(codes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return false;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		FormationCourse aux = (FormationCourse) obj;
		if (this.ownerLibrary == null) {
			if (aux.getOwnerLibrary() != null) {
				return false;
			}
		} else if (!this.ownerLibrary.equals(aux.getOwnerLibrary())) {
			return false;
		}
		if (formationCourseID == null) {
			if (aux.getFormationCourseID() != null) {
				return false;
			}
		} else if (!formationCourseID.equals(aux.getFormationCourseID())) {
			return false;
		}
		return true;
	}

}
