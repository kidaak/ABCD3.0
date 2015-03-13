package cu.uci.abcd.administration.library.ui.model;



import java.sql.Date;
import java.util.List;

import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class FormationCourseGrid implements IGridViewEntity {
	private FormationCourse formationCourse;
	/*
	public FormationCourseGrid(Long formationCourseID, String courseName, Integer hourQuantity,
			Date startDate, Date endDate, Integer externalTeacherQuantity,
			Integer workerTeacherQuantity, Integer externalStudentQuantity,
			Integer workerStudentQuantity, String description) {

		super();
		this.setFormationCourseID(formationCourseID);
		this.setCourseName(courseName);
		this.setHourQuantity(hourQuantity);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setExternalTeacherQuantity(externalTeacherQuantity);
		this.setWorkerTeacherQuantity(workerTeacherQuantity);
		this.setExternalStudentQuantity(externalStudentQuantity);
		this.setWorkerStudentQuantity(workerStudentQuantity);
		this.setDescription(description);
	}
	
	public FormationCourseGrid(String courseName, Integer hourQuantity,
			Date startDate, Date endDate, Integer externalTeacherQuantity,
			Integer workerTeacherQuantity, Integer externalStudentQuantity,
			Integer workerStudentQuantity, String description) {

		super();
		this.setCourseName(courseName);
		this.setHourQuantity(hourQuantity);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setExternalTeacherQuantity(externalTeacherQuantity);
		this.setWorkerTeacherQuantity(workerTeacherQuantity);
		this.setExternalStudentQuantity(externalStudentQuantity);
		this.setWorkerStudentQuantity(workerStudentQuantity);
		this.setDescription(description);
	}
	
	public FormationCourseGrid(String courseName, String description) {
		super();
		this.setCourseName(courseName);
		this.setDescription(description);
	}
	*/
	public FormationCourseGrid(FormationCourse formationCourse) {
		super();
		this.formationCourse = formationCourse;
		
	}
	
	@TreeTableColumn(percentWidth = 30, index=0)
	public String getCourseName() {
		return getFormationCourse().getCourseName();
	}
	@TreeTableColumn(percentWidth = 69, index=1)
	public String getDescription() {
		return getFormationCourse().getDescription();
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

	public FormationCourse getFormationCourse() {
		return formationCourse;
	}

	public void setFormationCourse(FormationCourse formationCourse) {
		this.formationCourse = formationCourse;
	}
	
}
