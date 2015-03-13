package cu.uci.abcd.administration.library.ui.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

public class WorkerUpdateArea implements IEditableArea{
	private IViewController controller;
	private Library library;
	
	
	
	TabFolder tabFolder;
	Label idPerson;
	Combo workerTypeCombo;
	Text descriptionText;
	
	//Composite personDatas;
	Label nameAndLastName;
	Label nameAndLastNameData;
	 DateTime registerDateTime;
	
	//private IGridViewEntity personEntity;
	//private CRUDTreeTable workerTable;
	TabItem workerTabItem;
	Control group2;
	
	FormLayout form;
	Composite parent;
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
	
	//TabItem workerTabItem;
	
	public WorkerUpdateArea(IViewController controller) {
		this.controller = controller;
	}
	
	
	@Override
	public Composite createUI(final Composite shell, IGridViewEntity entity,
			final IVisualEntityManager manager) {
		RegisterWorkerFragment registerWorkerFragment = new RegisterWorkerFragment(controller, null, manager);
		return (Composite) registerWorkerFragment.createUIControl(shell);
		/*
		form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
				
		parent= new Composite(shell, SWT.NORMAL);
		parent.setLayout(form);
		//parent.setVisible(false);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
		
		////////////////////
		WorkerViewArea workerAddArea = new WorkerViewArea(controller);
		viewWorkerSave = workerAddArea.createUI(shell, entity,manager);
		viewWorkerSave.setData(RWT.CUSTOM_VARIANT, "gray_background");
		//group.setVisible(false);
		/////////////////////
		
		
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
		
		//child 1
		associatePersonLabel = new Label(otherDatas, SWT.NONE);
		associatePersonLabel.setLayoutData(new FormData());
		associatePersonLabel.setText("Debe asociar una Persona");
		FormDatas.attach(associatePersonLabel).atTopTo(personDataLabel, 10).atLeft(10);
		
		//child 2
		associateButton = new Button(otherDatas, SWT.PUSH);
		associateButton.setText("Asociar");
		FormDatas.attach(associateButton).atTopTo(associatePersonLabel, 10).atLeft(10);
		
		//child 3
		lab = new Label(otherDatas, SWT.None);
	     lab.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
	     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		  lab.setText("<img width='100' height='114' src='" +elemento+"'></img>");
		  lab.setVisible(false);
			  FormDatas.attach(lab).atTopTo(personDataLabel, 2).atLeft(10);
			  
	    //child 4  
		generalDataTable = new Table(otherDatas, SWT.BORDER | SWT.FULL_SELECTION);
        generalDataTable.setHeaderVisible(false);
        generalDataTable.setLinesVisible(true);
        generalDataTable.setVisible(false);
        
        
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
        
        FormDatas.attach(generalDataTable).atLeftTo(lab, 0).atTopTo(personDataLabel, 2);
        
        //child 5
        unAssociateButton = new Button(otherDatas, SWT.PUSH);
        unAssociateButton.setText("Desasociar");
        unAssociateButton.setVisible(false);
		FormDatas.attach(unAssociateButton).atTopTo(personDataLabel, 85).atLeftTo(generalDataTable, 5);
        
		//child 6
		idPerson = new Label(otherDatas, SWT.NONE);
		idPerson.setLayoutData(new FormData());
		idPerson.setVisible(false);
		FormDatas.attach(idPerson);
		
		
		unAssociateButton.addSelectionListener(new SelectionAdapter() {
            
            private static final long serialVersionUID = 1L;
            @Override
            public void widgetSelected(SelectionEvent e) {
            	associatePersonLabel.setVisible(true);
            	associateButton.setVisible(true);
				   
            	lab.setVisible(false);
            	generalDataTable.setVisible(false);
            	unAssociateButton.setVisible(false);
            }

    });
        
        
		
		
		associateButton.addSelectionListener(new SelectionAdapter() {
            
            private static final long serialVersionUID = 1L;
            @Override
            public void widgetSelected(SelectionEvent e) {
            	if(tabFolder.getItemCount()==1){
            	workerTabItem = new TabItem(tabFolder, SWT.NONE);
        		workerTabItem.setText("Persona");
        		group2 = new SearchPerson(controller, tabFolder, otherDatas).createUIControl(tabFolder);
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
		
		Label registerDateLabel=  new Label(otherDatas, SWT.NONE);
		registerDateLabel.setText("Fecha de Registro");
        FormDatas.attach(registerDateLabel).atTopTo(workerDataListLabel, 10).atLeftTo(workerTypeLabel, 80);
        
        registerDateTime = new DateTime(otherDatas, SWT.BORDER | SWT.DROP_DOWN);
        FormDatas.attach(registerDateTime).atTopTo(registerDateLabel, 10).atLeftTo(workerTypeLabel, 80);
        
        Label descriptionLabel=  new Label(otherDatas, SWT.NONE);
		FormDatas.attach(descriptionLabel).atTopTo(registerDateTime, 20).atLeft(10);
		descriptionLabel.setText("Observaciones");
	
		 descriptionText = new Text(otherDatas, SWT.BORDER |  SWT.WRAP);
		 FormDatas.attach(descriptionText).atTopTo(descriptionLabel, 10).withHeight(30).atLeft(10).atRight(10);
		
		 Button saveBtn = new Button(otherDatas, SWT.PUSH);
		 saveBtn.setText("Registrar");
		 FormDatas.attach(saveBtn).atTopTo(descriptionText, 10).atLeft(10);
			
		 saveBtn.addSelectionListener(new SelectionAdapter() {
				private static final long serialVersionUID = 2615553092700551346L;
				@Override
				public void widgetSelected(SelectionEvent e) {
					Long personId = Long.parseLong(idPerson.getText());
					int selectedIndex = workerTypeCombo.getSelectionIndex();
					WorkerType workerType = ((LinkedList<WorkerType>)((Combo)workerTypeCombo).getData()).get(selectedIndex);
					String description = descriptionText.getText();
					
					int fromYear = registerDateTime.getYear();
					int fromMonth = registerDateTime.getMonth();
					int fromDay = registerDateTime.getDay();
					Date registerDate = new Date(fromYear, fromMonth, fromDay);
					
					Person personWorker = ((LibraryViewController) controller).getPersonById(personId);
					//Worker worker = null;
					
					if( library==null ){
						Worker worker = new WorkerGrid(registerDate, description, workerType, personWorker);
					    manager.add((IGridViewEntity) worker);
					}else{
						Worker worker = new Worker();
						worker.setObservation(description);
						worker.setPersonWorker(personWorker);
						worker.setRegisterDate(registerDate);
						worker.setWorkerType(workerType);
						worker.setWorkPlace(library);
						
						((LibraryViewController) controller).SaveWorker(worker);
						
						parent.setVisible(false);
						viewWorkerSave.setVisible(true);
						
					}
					
					
				}
			});
		 
		 Label espacio= new Label(otherDatas, SWT.NORMAL);
		 FormDatas.attach(espacio).atTopTo(saveBtn, 10);
		 
		
		InitializeComboWorkerType();
		return shell;
		*/
	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {
		//Button saveBtn = new Button(parent, SWT.PUSH);
		//saveBtn.setText("Registrar");
		
		return null;
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

	public Composite CreateSearchPerson(Composite parent, Composite downTo){
		//FormLayout form = null;
		Composite result = new Composite(parent, SWT.NORMAL);
		result.setLayout(new FormLayout());
		result.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(result).atTopTo(downTo, 15).atLeft(0).atRight(0);
		
		Label p2=  new Label(result, SWT.NONE);
		FormDatas.attach(p2).atTopTo(result, 5);
		p2.setText("p2");
		
		return result;
	}

	private void InitializeComboWorkerType() {
		
	    List<WorkerType> listWorkerType = (List<WorkerType>) ((LibraryViewController) controller).findAllWorkerType();
	    //List<WorkerType> a = listWorkerType;
	    		
	    String [] comboStrings = new String[listWorkerType.size()];
	    List<WorkerType> type = new LinkedList<WorkerType>();
	    for (int i = 0; i < listWorkerType.size(); i++) {
	    	WorkerType workerType = listWorkerType.get(i);
	    	type.add(workerType);
	    	comboStrings[i]=workerType.getNomeclatorName();
		}
	    workerTypeCombo.setData(type);
	    workerTypeCombo.setItems(comboStrings);
	  
	}
	
	
}
