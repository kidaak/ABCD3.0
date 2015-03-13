package cu.uci.abcd.administration.library.ui;

import java.util.Arrays;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import cu.uci.abcd.administration.library.ui.model.CalendarGrid;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.DateTime;

public class ConfigureCalendar implements IContributor {

	Composite test;
	Label searchCriteriaLabel;
	DateTime dayDateTime;
	Button consultButton;
	Label separator;
	Label repeatDayEachYearLabel;
	
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Configurar Calendario";
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ConfigurarCalendarioID";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub

		FormLayout form = new FormLayout();
		shell.setLayout(form);
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test = new Composite(shell, SWT.NORMAL);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test.setLayout(form);
		FormDatas.attach(test).atLeftTo(shell, 10).atLeft(0).atRight(0);

		searchCriteriaLabel = new Label(test, SWT.NONE);
		searchCriteriaLabel.setLayoutData(new FormData());
		searchCriteriaLabel.setText("Registrar Día Feriado");
		FormDatas.attach(searchCriteriaLabel).atTopTo(test, 10).atLeft(10);

		dayDateTime = new DateTime(test, SWT.BORDER | SWT.DROP_DOWN
				| SWT.CALENDAR);
		dayDateTime.setLayoutData(new FormData());
		FormDatas.attach(dayDateTime).atTopTo(searchCriteriaLabel, 10)
				.atLeft(10);

		consultButton = new Button(test, SWT.PUSH);
		consultButton.setLayoutData(new FormData());
		consultButton.setText("Registrar");
		FormDatas.attach(consultButton).atTopTo(dayDateTime, -30)
				.atLeftTo(dayDateTime, 20);

		separator = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new FormData());
		FormDatas.attach(separator).atTopTo(dayDateTime, 10).atLeft(5).atRight(5);

		repeatDayEachYearLabel = new Label(test, SWT.NORMAL);
		repeatDayEachYearLabel.setLayoutData(new FormData());
		FormDatas.attach(repeatDayEachYearLabel).atTopTo(separator, 10).atLeft(10);
		repeatDayEachYearLabel.setText("Días Feriados Repetibles para cada año");

		CRUDTreeTable tabla = new CRUDTreeTable(test, SWT.NONE);
		tabla.setEntityClass(CalendarGrid.class);
		// tabla.setAdd(true, new CalendarRepeatableDaysEveryYearAddArea());
		// tabla.setWatch(true, new LibraryUpdateArea());
		// tabla.setUpdate(true, new _LibraryUpdateArea());
		// tabla.setSearch(true);
		tabla.setDelete(true);
		// tabla.setSaveAll(true);

		tabla.setColumnHeaders(Arrays.asList("Fecha", "Titulo", "Descripcion")); // For
																					// the
																					// internationalization.

		try {
			tabla.createTable();
		} catch (Exception e) {
		}
		FormDatas.attach(tabla).atTopTo(repeatDayEachYearLabel, 10).atLeft(5).atRight(5);
		// TreeItem root = tabla.addRow(new
		// LibraryGrid("Editorial Gente Nueva","EK52635"));
		//tabla.addRow(new CalendarGrid("10-12-2014",
			//	"Titulo", "Descripcion del titulo"));
		//tabla.addRow(new CalendarGrid("10-12-2014",
				//"Titulo", "Descripcion del titulo"));
		//tabla.addRow(new CalendarGrid("10-12-2014",
			//	"Titulo", "Descripcion del titulo"));

		tabla.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// IGridViewEntity entity = (FDTViewEntity) event.entity;
				// do something with the data
			}
		});

		tabla.addDeleteListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// IGridViewEntity entity = (FDTViewEntity) event.entity;
				// do something with the data
			}
		});

		Label separador1 = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
		separador1.setLayoutData(new FormData());
		FormDatas.attach(separador1).atTopTo(tabla, 10).atLeft(5).atRight(5);

		Label listado1 = new Label(test, SWT.NORMAL);
		listado1.setLayoutData(new FormData());
		FormDatas.attach(listado1).atTopTo(separador1, 10).atLeft(10);
		listado1.setText("Días Feriados para el Año Actual");

		// -----------------Tabla--------------------------------------
		CRUDTreeTable tabla1 = new CRUDTreeTable(test, SWT.NONE);
		tabla1.setEntityClass(CalendarGrid.class);
		// tabla1.setAdd(true, new CalendarDaysCurrentYearAddArea());
		// tabla.setWatch(true, new LibraryUpdateArea());
		// tabla.setUpdate(true, new _LibraryUpdateArea());
		// tabla1.setSearch(true);
		tabla1.setDelete(true);
		// tabla1.setSaveAll(true);

		tabla1.setColumnHeaders(Arrays.asList("Fecha", "Titulo", "Descripcion")); // For
																					// the
																					// internationalization.

		try {
			tabla1.createTable();
		} catch (Exception e) {
		}
		FormDatas.attach(tabla1).atTopTo(listado1, 10).atLeft(5).atRight(5);
		// TreeItem root = tabla.addRow(new
		// LibraryGrid("Editorial Gente Nueva","EK52635"));
		//tabla1.addRow(new CalendarGrid("10-12-2014", "Titulo",
				//"Descripcion del titulo"));
		//tabla1.addRow(new CalendarGrid("10-12-2014", "Titulo",
				//"Descripcion del titulo"));
		//tabla1.addRow(new CalendarGrid("10-12-2014", "Titulo",
				//"Descripcion del titulo"));

		tabla1.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// IGridViewEntity entity = (FDTViewEntity) event.entity;
				// do something with the data
			}
		});

		tabla1.addDeleteListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// IGridViewEntity entity = (FDTViewEntity) event.entity;
				// do something with the data
			}
		});

		Label separador2 = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
		separador2.setLayoutData(new FormData());
		FormDatas.attach(separador2).atTopTo(tabla1, 10).atLeft(5).atRight(5);

		Label listado12 = new Label(test, SWT.NORMAL);
		listado12.setLayoutData(new FormData());
		FormDatas.attach(listado12).atTopTo(separador2, 10).atLeft(10);
		listado12.setText("Días Feriados para cada Semana del Año");

		// -----------------Tabla--------------------------------------

		CRUDTreeTable tabla2 = new CRUDTreeTable(test, SWT.NONE);
		tabla2.setEntityClass(CalendarGrid.class);
		// tabla2.setAdd(true, new
		// CalendarRepeatableDaysEveryWeekOfYearAddArea());
		// tabla.setWatch(true, new LibraryUpdateArea());
		// tabla.setUpdate(true, new _LibraryUpdateArea());
		// tabla2.setSearch(true);
		tabla2.setDelete(true);
		// tabla2.setSaveAll(true);

		tabla2.setColumnHeaders(Arrays.asList("Fecha", "Titulo", "Descripcion")); // For
																					// the
																					// internationalization.

		try {
			tabla2.createTable();
		} catch (Exception e) {
		}
		FormDatas.attach(tabla2).atTopTo(listado12, 10).atLeft(5).atRight(5);
		// TreeItem root = tabla.addRow(new
		// LibraryGrid("Editorial Gente Nueva","EK52635"));
		//tabla2.addRow(new CalendarGrid(
			//	"10-12-2014", "Titulo", "Descripcion del titulo"));
		//tabla2.addRow(new CalendarGrid(
			//	"10-12-2014", "Titulo", "Descripcion del titulo"));
		//tabla2.addRow(new CalendarGrid(
			//	"10-12-2014", "Titulo", "Descripcion del titulo"));

		tabla2.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// IGridViewEntity entity = (FDTViewEntity) event.entity;
				// do something with the data
			}
		});

		tabla2.addDeleteListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// IGridViewEntity entity = (FDTViewEntity) event.entity;
				// do something with the data
			}
		});

		return shell;
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub

	}
}
