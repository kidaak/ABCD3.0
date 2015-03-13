package cu.uci.abcd.administration.library.ui.model;


import java.sql.Date;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.communFragment.RegisterFormationCourseFragment;
import cu.uci.abcd.administration.library.communFragment.RegisterWorkerFragment;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class FormationCourseAddArea implements IEditableArea{
	FormLayout form;
	Composite parent;
	Label courseFormationLabel;
	Label courseNameLabel;
	Text courseNameText;
	Text hourQuantityText;
	Text externalTeacherQuantityText;
	Text workerTeacherQuantityText;
	Text externalStudentQuantityText;
	Text workerStudentQuantityText;
	Label descriptionLabel;
	Text descriptionText;
	DateTime fromDateTime;
	DateTime toDateTime;
	RegisterFormationCourseFragment registerFormationCourseFragment;
	private IViewController controller;
	Composite parentComposite;
	Map<String, Control> controlsMaps;
	
	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		registerFormationCourseFragment = new RegisterFormationCourseFragment(controller, null, manager);
		parentComposite = (Composite) registerFormationCourseFragment.createUIControl(shell);
		controlsMaps = registerFormationCourseFragment.getMapControls();
		return parentComposite;
	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			final IVisualEntityManager manager) {
		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Registrar FormationCourse");
		saveBtn.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 2615553092700551346L;
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				courseNameText = (Text) controlsMaps.get("courseNameText");
				hourQuantityText = (Text) controlsMaps.get("hourQuantityText");
				externalTeacherQuantityText = (Text) controlsMaps.get("externalTeacherQuantityText");
				workerTeacherQuantityText = (Text) controlsMaps.get("workerTeacherQuantityText");
				externalStudentQuantityText = (Text) controlsMaps.get("externalStudentQuantityText");
				workerStudentQuantityText = (Text) controlsMaps.get("workerStudentQuantityText");
				descriptionText = (Text) controlsMaps.get("descriptionText");
				fromDateTime = (DateTime) controlsMaps.get("fromDateTime");
				toDateTime = (DateTime) controlsMaps.get("toDateTime");
				
				int fromYear = fromDateTime.getYear();
				int fromMonth = fromDateTime.getMonth();
				int fromDay = fromDateTime.getDay();
				Date startDate = new Date(fromYear, fromMonth, fromDay);

				int toYear = toDateTime.getYear();
				int toMonth = toDateTime.getMonth();
				int toDay = toDateTime.getDay();

				Date endDate = new Date(toYear, toMonth, toDay);
				
				FormationCourse formationCourse = new FormationCourse();
				formationCourse.setCourseName(courseNameText.getText());
				formationCourse.setHourQuantity(Integer.parseInt(hourQuantityText.getText()));
				formationCourse.setStartDate(startDate);
				formationCourse.setEndDate(endDate);
				formationCourse.setExternalTeacherQuantity(Integer.parseInt(externalTeacherQuantityText.getText()));
				formationCourse.setWorkerTeacherQuantity(Integer.parseInt(workerTeacherQuantityText.getText()));
				formationCourse.setExternalStudentQuantity(Integer.parseInt(externalStudentQuantityText.getText()));
				formationCourse.setWorkerStudentQuantity(Integer.parseInt(workerStudentQuantityText.getText()));
				formationCourse.setDescription(descriptionText.getText());
				
				FormationCourseGrid formationCourseGrid = new FormationCourseGrid(formationCourse);
				
				manager.add(formationCourseGrid);
				//CleanForm();
			
				
			}
		});
		return parent;
	}

	
	
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Control getControl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
