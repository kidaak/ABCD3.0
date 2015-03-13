package cu.uci.abcd.administration.library.ui.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.client.service.JavaScriptExecutor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.aux.Auxiliary;
import cu.uci.abcd.administration.library.communFragment.RegisterWorkerFragment;
import cu.uci.abcd.administration.library.ui.SearchPerson;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Worker;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class WorkerAddArea implements IEditableArea{
	private IViewController controller;
	private Library library;
	TabFolder tabFolder;
	Label idPerson;
	Combo workerTypeCombo;
	Text descriptionText;
	Label nameAndLastName;
	Label nameAndLastNameData;
	DateTime registerDateTime;
	TabItem workerTabItem;
	Control group2;
	FormLayout form;
	Button asociar;
	Composite indicateAssociatePerson;
	Composite associatePersonan;
	Composite otherDatas;
	Button associateButton;
	Label associatePersonLabel;
	Button unAssociateButton;
	Label lab;
	Table generalDataTable;
	Composite viewWorkerSave;
	Composite parentComposite;
	RegisterWorkerFragment registerWorkerFragment;
	Map<String, Control> controlsMaps;
	
	public WorkerAddArea(IViewController controller, Library library) {
		this.controller = controller;
		this.setLibrary(library);
	}
	
	public WorkerAddArea() {
		
	}
	
	@Override
	public Composite createUI(final Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		registerWorkerFragment = new RegisterWorkerFragment(controller, null, manager);
		parentComposite = (Composite) registerWorkerFragment.createUIControl(shell);
		controlsMaps = registerWorkerFragment.getMapControls();
		return parentComposite;
	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			final IVisualEntityManager manager) {
		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Registrar Worker");
		saveBtn.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 2615553092700551346L;
			@Override
			public void widgetSelected(SelectionEvent e) {
				idPerson = (Label) controlsMaps.get("6");
				workerTypeCombo = (Combo) controlsMaps.get("workerTypeCombo");
				descriptionText = (Text) controlsMaps.get("descriptionText");
				registerDateTime = (DateTime) controlsMaps.get("registerDateTime");
				
				if( !(idPerson.getText() == null) && workerTypeCombo.getSelectionIndex()>=0 ){
					Long personId = Long.parseLong(idPerson.getText());
					int selectedIndex = workerTypeCombo.getSelectionIndex();
					WorkerType workerType = ((LinkedList<WorkerType>)((Combo)workerTypeCombo).getData()).get(selectedIndex);
					String description = descriptionText.getText();
					
					int fromYear = registerDateTime.getYear();
					int fromMonth = registerDateTime.getMonth();
					int fromDay = registerDateTime.getDay();
					Date registerDate = new Date(fromYear, fromMonth, fromDay);
					
					Person personWorker = ((LibraryViewController) controller).getPersonById(personId);
					Worker worker = new Worker();
			    	worker.setRegisterDate(registerDate);
			    	worker.setObservation(description);
			    	worker.setWorkerType(workerType);
			    	worker.setPersonWorker(personWorker);
				    	WorkerGrid workerGrid = new WorkerGrid(worker);
						manager.add(workerGrid);
						CleanForm();
				}
			}
		});
		return parent;
	}

	private void CleanForm() {
		controlsMaps.get("1").setVisible(true);
		controlsMaps.get("2").setVisible(true);
		controlsMaps.get("3").setVisible(false);
		controlsMaps.get("4").setVisible(false);
		controlsMaps.get("5").setVisible(false);
		//idPerson.setText("");;
		((Combo) controlsMaps.get("workerTypeCombo")).setText("");
		((Text) controlsMaps.get("descriptionText")).setText("");
		//registerDateTime = (DateTime) a.get("registerDateTime");
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

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
}
