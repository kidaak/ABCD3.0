package cu.uci.abcd.administration.library.communFragment;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.ui.SearchPerson;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.administration.library.ui.model.WorkerGrid;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Worker;
import cu.uci.abos.ui.api.IFragmentContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class RegisterWorkerFragment implements IFragmentContributor {

	private IViewController controller;
	private Library library;
	private IVisualEntityManager manager;
	
	Composite parent;
	Composite viewWorkerSave;
	TabFolder tabFolder;
	TabItem workerTabItem;
	Control group2;
	
	Composite otherDatas;
	Label associatePersonLabel;
	Button associateButton;
	Label otherDatasLabel;
	Table generalDataTable;
	Button unAssociateButton;
	Combo workerTypeCombo;
	DateTime registerDateTime;
	Text descriptionText;
	Label idPerson;
	Button saveBtn;
	
	private Map<String, Control> controls = new HashMap<String, Control>();
	
	public RegisterWorkerFragment(IViewController controller, Library library, IVisualEntityManager manager) {
		this.controller = controller;
		this.library = library;
		this.manager = manager;
	}
	
	@Override
	public Control createUIControl(Composite shell) {
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
				
		parent= new Composite(shell, SWT.NORMAL);
		parent.setLayout(form);
		//parent.setVisible(false);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
		
		
		
		ViewWorkerFragment viewWorkerFragment =  new ViewWorkerFragment();
		viewWorkerSave = (Composite) viewWorkerFragment.createUIControl(shell);
		viewWorkerSave.setData(RWT.CUSTOM_VARIANT, "gray_background");
		//viewWorkerSave.setVisible(false);
		
		tabFolder = new TabFolder(parent, SWT.NONE);
		tabFolder.setData(RWT.CUSTOM_VARIANT, "gray_background");
        FormDatas.attach(tabFolder).atTopTo(parent).atLeft(0).atRight(0);
        
        TabItem libraryTabItem = new TabItem(tabFolder, SWT.NONE);
		libraryTabItem.setText("Trabajador");
		Composite group1 = new Composite(tabFolder, SWT.NONE);
		group1.setLayout(form);
		group1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		libraryTabItem.setControl(group1);
		FormDatas.attach(group1).atTopTo(tabFolder).atLeft(0).atRight(0);
		
		otherDatas = new Composite(group1, SWT.NORMAL);
		otherDatas.setLayout(form);
		otherDatas.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(otherDatas).atTopTo(group1, 10).atLeft(0).atRight(0);
		
		//child 0
		Label personDataLabel = new Label(otherDatas, SWT.NONE);
		personDataLabel.setLayoutData(new FormData());
		personDataLabel.setText("Datos de la Persona");
		FormDatas.attach(personDataLabel).atTopTo(otherDatas, 5).atLeft(10);
		controls.put("0", personDataLabel);
		
		//child 1
		associatePersonLabel = new Label(otherDatas, SWT.NONE);
		associatePersonLabel.setLayoutData(new FormData());
		associatePersonLabel.setText("Debe asociar una Persona");
		FormDatas.attach(associatePersonLabel).atTopTo(personDataLabel, 10).atLeft(10);
		controls.put("1", associatePersonLabel);
		
		//child 2
		associateButton = new Button(otherDatas, SWT.PUSH);
		associateButton.setText("Asociar");
		FormDatas.attach(associateButton).atTopTo(associatePersonLabel, 10).atLeft(10);
		controls.put("2", associateButton);
		
		//child 3
		otherDatasLabel = new Label(otherDatas, SWT.None);
		otherDatasLabel.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
	     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
	     otherDatasLabel.setText("<img width='100' height='114' src='" +elemento+"'></img>");
	     otherDatasLabel.setVisible(false);
			  FormDatas.attach(otherDatasLabel).atTopTo(personDataLabel, 2).atLeft(10);
			  controls.put("3", otherDatasLabel);
			  
	    //child 4  
		generalDataTable = new Table(otherDatas, SWT.BORDER | SWT.FULL_SELECTION);
        generalDataTable.setHeaderVisible(false);
        generalDataTable.setLinesVisible(true);
        generalDataTable.setVisible(false);
        controls.put("4", generalDataTable);
        
        TableColumn generalDataColumn1 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn1.setWidth(150);
        TableColumn generalDataColumn2 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn2.setWidth(180);
        //generalDataTable.getItem(0).setText(0,"");
        
        TableItem nameTableItem = new TableItem(generalDataTable, SWT.NONE);
        nameTableItem.setText(0,"Nombre y Apellidos");
        nameTableItem.setText(1, "");
                
        TableItem surficeTableItem = new TableItem(generalDataTable, SWT.NONE);
        surficeTableItem.setText("Identificacion");
        surficeTableItem.setText(1, "");
                                
        TableItem roomQuantityTableItem = new TableItem(generalDataTable, SWT.NONE);
        roomQuantityTableItem.setText("Sexo");
        roomQuantityTableItem.setText(1, "");
        
        TableItem agePersonTableItem = new TableItem(generalDataTable, SWT.NONE);
        agePersonTableItem.setText("Edad");
        agePersonTableItem.setText(1, "");
        
        FormDatas.attach(generalDataTable).atLeftTo(otherDatasLabel, 0).atTopTo(personDataLabel, 2);
        
        //child 5
        unAssociateButton = new Button(otherDatas, SWT.PUSH);
        unAssociateButton.setText("Desasociar");
        unAssociateButton.setVisible(false);
		FormDatas.attach(unAssociateButton).atTopTo(personDataLabel, 85).atLeftTo(generalDataTable, 5);
		controls.put("5", unAssociateButton);
        
		//child 6
		idPerson = new Label(otherDatas, SWT.NONE);
		idPerson.setLayoutData(new FormData());
		idPerson.setVisible(false);
		FormDatas.attach(idPerson);
		
		controls.put("6", idPerson);
		
		
		unAssociateButton.addSelectionListener(new SelectionAdapter() {
            
            private static final long serialVersionUID = 1L;
            @Override
            public void widgetSelected(SelectionEvent e) {
            	associatePersonLabel.setVisible(true);
            	associateButton.setVisible(true);
				   
            	otherDatasLabel.setVisible(false);
            	generalDataTable.setVisible(false);
            	unAssociateButton.setVisible(false);
            	group2.setVisible(false);
            }

    });
        
        
		
		
		associateButton.addSelectionListener(new SelectionAdapter() {
            
            private static final long serialVersionUID = 1L;
            @Override
            public void widgetSelected(SelectionEvent e) {
            	if(tabFolder.getItemCount()==1){
            	workerTabItem = new TabItem(tabFolder, SWT.NONE);
        		workerTabItem.setText("Persona");
        		group2 = new SearchPerson(controller, tabFolder, controls).createUIControl(tabFolder);
        		workerTabItem.setControl(group2);
        		FormDatas.attach(group2).atTopTo(tabFolder);
        		
            	}
            	tabFolder.setSelection(1);
            }

    });
		
		Label separador = new Label(otherDatas, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(associateButton, 55).atLeft(10).atRight(10);
		
		
		
		Label workerDataListLabel = new Label(otherDatas, SWT.NORMAL);
		FormDatas.attach(workerDataListLabel).atTopTo(separador, 10).atLeft(10);
		workerDataListLabel.setText("Datos del Trabajador");
		
		Label workerTypeLabel=  new Label(otherDatas, SWT.NONE);
		workerTypeLabel.setText("Tipo de Trabajador");
		FormDatas.attach(workerTypeLabel).atTopTo(workerDataListLabel, 10).atLeft(10);
		
		workerTypeCombo = new Combo(otherDatas, SWT.NONE);
		
		workerTypeCombo.setItems(new String[] { "Especialista", "Profesor"});
		FormDatas.attach(workerTypeCombo).atTopTo(workerTypeLabel, 10).atLeft(10).withWidth(150);
		getMapControls().put("workerTypeCombo", workerTypeCombo);
		
		
		Label registerDateLabel=  new Label(otherDatas, SWT.NONE);
		registerDateLabel.setText("Fecha de Registro");
        FormDatas.attach(registerDateLabel).atTopTo(workerDataListLabel, 10).atLeftTo(workerTypeLabel, 80);
        
        registerDateTime = new DateTime(otherDatas, SWT.BORDER | SWT.DROP_DOWN);
        FormDatas.attach(registerDateTime).atTopTo(registerDateLabel, 10).atLeftTo(workerTypeLabel, 80);
        controls.put("registerDateTime", registerDateTime);
        
        Label descriptionLabel=  new Label(otherDatas, SWT.NONE);
		FormDatas.attach(descriptionLabel).atTopTo(registerDateTime, 20).atLeft(10);
		descriptionLabel.setText("Observaciones");
	
		 descriptionText = new Text(otherDatas, SWT.BORDER |  SWT.WRAP);
		 FormDatas.attach(descriptionText).atTopTo(descriptionLabel, 10).withHeight(30).atLeft(10).atRight(10);
		 controls.put("descriptionText", descriptionText);
		 
		 saveBtn = new Button(otherDatas, SWT.PUSH);
		 saveBtn.setVisible(false);
		 
		 if( !(library==null) ){
			 
			 saveBtn.setText("Registrar Trabajador solo");
			 saveBtn.setVisible(true);
			 FormDatas.attach(saveBtn).atTopTo(descriptionText, 10).atLeft(10);
			 
			 Label espacio= new Label(otherDatas, SWT.NORMAL);
			 FormDatas.attach(espacio).atTopTo(saveBtn, 5);
		 }else{
			 Label espacio= new Label(otherDatas, SWT.NORMAL);
			 FormDatas.attach(espacio).atTopTo(descriptionText, 5);
		 }
		
			
		 saveBtn.addSelectionListener(new SelectionAdapter() {
				private static final long serialVersionUID = 2615553092700551346L;
				@Override
				public void widgetSelected(SelectionEvent e) {
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
			    	
					
						worker.setWorkPlace(library);
						((LibraryViewController) controller).SaveWorker(worker);
						parent.setVisible(false);
						viewWorkerSave.setVisible(true);
					
				}
				}
			});
		 
		 
		 
		
		InitializeComboWorkerType();
		return shell;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub

	}

	@Override
	public Control getControl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

private void InitializeComboWorkerType() {
		
	    List<WorkerType> listWorkerType = (List<WorkerType>) ((LibraryViewController) controller).findAllWorkerType();
	    //List<WorkerType> a = listWorkerType;
	    		
	    String [] comboStrings = new String[listWorkerType.size()];
	    List<WorkerType> type = new LinkedList<WorkerType>();
	    for (int i = 0; i < listWorkerType.size(); i++) {
	    	WorkerType workerType = listWorkerType.get(i);
	    	type.add(workerType);
	    	comboStrings[i]= workerType.getNomeclatorName();
		}
	    workerTypeCombo.setData(type);
	    workerTypeCombo.setItems(comboStrings);
	  
	}

public Map<String, Control> getMapControls() {
	return controls;
}

public void setMapControls(Map<String, Control> controls) {
	this.controls = controls;
}

}
