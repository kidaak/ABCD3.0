package cu.uci.abcd.administration.library.ui.model;


import java.sql.Date;

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

import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class FormationCourseUpdateArea implements IEditableArea{
	
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
	
	FormationCourseGrid formationCourseToUpdate;
	
	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		
		formationCourseToUpdate = (FormationCourseGrid)entity;
		
		form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
				
		parent= new Composite(shell, SWT.NORMAL);
		parent.setLayout(form);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
		
		courseFormationLabel = new Label(parent, SWT.NONE);
		courseFormationLabel.setText("Datos de los Cursos de Formacion");
		FormDatas.attach(courseFormationLabel).atTopTo(parent, 10).atLeft(10);
		
		courseNameLabel = new Label(parent, SWT.NONE);
		courseNameLabel.setText("Nombre del Curso");
		FormDatas.attach(courseNameLabel).atTopTo(courseFormationLabel, 10).atLeft(10);
		
		courseNameText = new Text(parent, SWT.BORDER);
		FormDatas.attach(courseNameText).atTopTo(courseNameLabel, 10).atLeft(10).withWidth(200);
		
		Label hourQuantityLabel = new Label(parent, SWT.NONE);
		hourQuantityLabel.setText("Cantidad de Horas");
		FormDatas.attach(hourQuantityLabel).atTopTo(courseFormationLabel, 10).atLeftTo(courseNameText, 70);
		
		hourQuantityText = new Text(parent, SWT.BORDER);
		FormDatas.attach(hourQuantityText).atTopTo(hourQuantityLabel, 10).atLeftTo(courseNameText, 70).withWidth(200);
		
		Label externalTeacherQuantityLabel = new Label(parent, SWT.NONE);
		externalTeacherQuantityLabel.setText("Cantidad de Profesores Externos");
		FormDatas.attach(externalTeacherQuantityLabel).atTopTo(courseFormationLabel, 10).atLeftTo(hourQuantityText, 70);
		
		externalTeacherQuantityText = new Text(parent, SWT.BORDER);
		FormDatas.attach(externalTeacherQuantityText).atTopTo(externalTeacherQuantityLabel, 10).atLeftTo(hourQuantityText, 70).withWidth(200);
		
		Label workerTeacherQuantityLabel = new Label(parent, SWT.NONE);
		workerTeacherQuantityLabel.setText("Cantidad de Profesores Trabajadores");
		FormDatas.attach(workerTeacherQuantityLabel).atTopTo(courseNameText, 10).atLeft(10);
		
		workerTeacherQuantityText = new Text(parent, SWT.BORDER);
		FormDatas.attach(workerTeacherQuantityText).atTopTo(workerTeacherQuantityLabel, 10).withWidth(200).atLeft(10);
		
		Label externalStudentQuantityLabel = new Label(parent, SWT.NONE);
		externalStudentQuantityLabel.setText("Cantidad de Estudiantes externos");
		FormDatas.attach(externalStudentQuantityLabel).atTopTo(courseNameText, 10).atLeftTo(courseNameText, 70);
		
		externalStudentQuantityText = new Text(parent, SWT.BORDER);
		FormDatas.attach(externalStudentQuantityText).atTopTo(externalStudentQuantityLabel, 10).atLeftTo(workerTeacherQuantityText, 70).withWidth(200);
		
		Label workerStudentQuantityLabel = new Label(parent, SWT.NONE);
		workerStudentQuantityLabel.setText("Cantidad de Estudiantes Trabajadores");
		FormDatas.attach(workerStudentQuantityLabel).atTopTo(courseNameText, 10).atLeftTo(externalStudentQuantityText, 70);
		
		workerStudentQuantityText = new Text(parent, SWT.BORDER);
		FormDatas.attach(workerStudentQuantityText).atTopTo(workerStudentQuantityLabel, 10).atLeftTo(externalStudentQuantityText, 70).withWidth(200);
			
		Label descriptionLabel = new Label(parent, SWT.NONE);
		descriptionLabel.setText("Descripcion");
		FormDatas.attach(descriptionLabel).atTopTo(workerTeacherQuantityText, 10).atLeft(10);
		
		descriptionText = new Text(parent, SWT.BORDER);
		FormDatas.attach(descriptionText).atTopTo(descriptionLabel, 10).atLeft(10).withWidth(200).atRight(10).withHeight(30);
		
		
		Label lblDireccin = new Label(parent, SWT.NONE);
		lblDireccin.setText("Rango de fechas del Curso");
		FormDatas.attach(lblDireccin).atTopTo(descriptionText, 20).atLeft(10);
		
		Label lblDireccion = new Label(parent, SWT.NONE);
		lblDireccion.setText("Desde");
		FormDatas.attach(lblDireccion).atTopTo(lblDireccin, 10).atLeft(10);
		
		fromDateTime = new DateTime(parent, SWT.BORDER);
		FormDatas.attach(fromDateTime).atTopTo(lblDireccion, 10).atLeft(10);
		
		Label lblNewLabel_3 = new Label(parent, SWT.NONE);
		lblNewLabel_3.setText("Hasta");
		FormDatas.attach(lblNewLabel_3).atTopTo(lblDireccin, 10).atLeftTo(fromDateTime, 30);
		
		toDateTime = new DateTime(parent, SWT.BORDER);
		FormDatas.attach(toDateTime).atTopTo(lblDireccion, 10).atLeftTo(fromDateTime, 30);
		
		Label espacio= new Label(parent, SWT.NORMAL);
		FormDatas.attach(espacio).atTopTo(toDateTime, 10);
		
		LoadFormationCourseData(formationCourseToUpdate);
			  return shell;
	}

	public void LoadFormationCourseData(FormationCourseGrid formationCourseToUpdate){
			courseNameText.setText(formationCourseToUpdate.getFormationCourse().getCourseName());
			hourQuantityText.setText(formationCourseToUpdate.getFormationCourse().getHourQuantity().toString());
			externalTeacherQuantityText.setText(formationCourseToUpdate.getFormationCourse().getExternalTeacherQuantity().toString());
			workerTeacherQuantityText.setText(formationCourseToUpdate.getFormationCourse().getWorkerTeacherQuantity().toString());
			externalStudentQuantityText.setText(formationCourseToUpdate.getFormationCourse().getExternalStudentQuantity().toString());
			workerStudentQuantityText.setText(formationCourseToUpdate.getFormationCourse().getWorkerStudentQuantity().toString());
			
			descriptionText.setText(formationCourseToUpdate.getFormationCourse().getDescription());
			//int fromYear = formationCourseToUpdate.getFormationCourse().getStartDate().getYear();
			//int fromMonth = formationCourseToUpdate.getFormationCourse().getStartDate().getMonth();
			//int fromDay = formationCourseToUpdate.getFormationCourse().getStartDate().getDay();
			
			//fromDateTime.setDate(fromYear, fromMonth, fromDay);
			
			//int toYear = formationCourseToUpdate.getFormationCourse().getStartDate().getYear();
			//int toMonth = formationCourseToUpdate.getFormationCourse().getStartDate().getMonth();
			//int toDay = formationCourseToUpdate.getFormationCourse().getStartDate().getDay()
			
			
			//fromDateTime.setDate(toYear, toMonth, toDay);
			
			/*
			int fromYear = fromDateTime.getYear();
			int fromMonth = fromDateTime.getMonth();
			int fromDay = fromDateTime.getDay();
			Date startDate = new Date(fromYear, fromMonth, fromDay);

			int toYear = toDateTime.getYear();
			int toMonth = toDateTime.getMonth();
			int toDay = toDateTime.getDay();

			Date endDate = new Date(toYear, toMonth, toDay);
			*/

	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			final IVisualEntityManager manager) {
		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Registrar");
		saveBtn.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 2615553092700551346L;
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String courseName = courseNameText.getText();
				Integer hourQuantity = Integer.parseInt(hourQuantityText
						.getText());
				Integer externalTeacherQuantity = Integer
						.parseInt(externalTeacherQuantityText.getText());
				Integer workerTeacherQuantity = Integer
						.parseInt(workerTeacherQuantityText.getText());
				Integer externalStudentQuantity = Integer
						.parseInt(externalStudentQuantityText.getText());
				Integer workerStudentQuantity = Integer
						.parseInt(workerStudentQuantityText.getText());
				
				String description = descriptionText.getText();
				int fromYear = fromDateTime.getYear();
				int fromMonth = fromDateTime.getMonth();
				int fromDay = fromDateTime.getDay();
				Date startDate = new Date(fromYear, fromMonth, fromDay);

				int toYear = toDateTime.getYear();
				int toMonth = toDateTime.getMonth();
				int toDay = toDateTime.getDay();

				Date endDate = new Date(toYear, toMonth, toDay);
				
				FormationCourse formationCourse = new FormationCourse();
				formationCourse.setCourseName(courseName);
				formationCourse.setHourQuantity(hourQuantity);
				formationCourse.setStartDate(startDate);
				formationCourse.setEndDate(endDate);
				formationCourse.setExternalTeacherQuantity(externalTeacherQuantity);
				formationCourse.setWorkerTeacherQuantity(workerTeacherQuantity);
				formationCourse.setExternalStudentQuantity(externalStudentQuantity);
				formationCourse.setWorkerStudentQuantity(workerStudentQuantity);
				formationCourse.setDescription(description);
				
				FormationCourseGrid formationCourseGrid = new FormationCourseGrid(formationCourse);
				
				manager.add(formationCourseGrid);
				
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