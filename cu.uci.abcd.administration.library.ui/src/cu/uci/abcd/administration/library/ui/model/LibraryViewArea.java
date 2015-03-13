package cu.uci.abcd.administration.library.ui.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.aux.Auxiliary;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.domain.common.Address;
import cu.uci.abcd.domain.common.PostalAddress;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Worker;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.Column;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class LibraryViewArea implements IEditableArea {
	
	private IViewController controller;
	//private Library libraryToUpdate;
	
	FormLayout form;
	Composite parent;
	TabFolder tabFolder;
	TabItem libraryTabItem; 
	Composite group1;
	Composite group2;
	Composite group3;
	Label generalDataLabel;
	Label userDataLabel;
	Label readingSetsDataLabel;
	Label addressLibraryLabel;
	Text addressLibraryText;
	Label separador;
	Label separador1;
	Label bookshelvesLabel;
	Label separador2;
	Label equipmentLabel;
	TabItem workerTabItem;
	Label listWorkerLibraryLabel;
	CRUDTreeTable workerTable;
	CRUDTreeTable formationCourseTable;
	TabItem formationCourseTabItem;
	Table generalDataTable;
	Table userDataTable;
	Table readingSetsDataTable;
	Table equipmentTable;
	Table bookshelvesTable;
	
	TableItem nameTableItem;
	TableItem surficeTableItem;
	TableItem roomQuantityTableItem;
	TableItem nameAndLastNameTableItem;
	TableItem userTableItem;
	TableItem DateTableItem;
	TableItem HourTableItem;
	TableItem contReadingSetsDataTableItem;
	TableItem contUserFormationTableItem;
	TableItem contWorkGroupTableItem;
	TableItem openBookshelvesTableItem;
	TableItem depositTableItem;
	TableItem userPcTableItem;
	TableItem workerPcTableItem;
	TableItem readerPlayersTableItem;
	
	public LibraryViewArea(IViewController controller) {
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		
		LibraryGrid libraryToView = (LibraryGrid)entity;
		
		form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
		parent= new Composite(shell, SWT.NORMAL);
		
		parent.setLayout(form);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
        tabFolder = new TabFolder(parent, SWT.NONE);
        tabFolder.setData(RWT.CUSTOM_VARIANT, "gray_background");
        FormDatas.attach(tabFolder).atTopTo(parent).atLeft(0).atRight(0);
		libraryTabItem = new TabItem(tabFolder, SWT.NONE);
		libraryTabItem.setText(AbosMessages.get().LABEL_LIBRARY);
		group1 = new Composite(tabFolder, SWT.NONE);
		group1.setLayout(form);
		group1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		libraryTabItem.setControl(group1);
		FormDatas.attach(group1).atTopTo(tabFolder).atLeft(0).atRight(0);
		
		generalDataLabel = new Label(group1, SWT.NONE);
		//lblNewLab.setText(MessageUtil.unescape(AbosMessages.get().LABEL_GENERAL_DATA)); //no esta pinchando
		generalDataLabel.setText("Datos Generales"); //no esta pinchando
		
		FormDatas.attach(generalDataLabel).atTopTo(group1, 10).atLeft(20);
		
		generalDataTable = new Table(group1, SWT.BORDER | SWT.FULL_SELECTION);
		generalDataTable.setHeaderVisible(false);
		generalDataTable.setLinesVisible(true);
        
        TableColumn generalDataColumn1 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn1.setWidth(125);
        TableColumn generalDataColumn2 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn2.setWidth(125);
                                
        nameTableItem = new TableItem(generalDataTable, SWT.NONE);
        nameTableItem.setText(0,"Nombre");
        nameTableItem.setText(1, "");
                
        surficeTableItem = new TableItem(generalDataTable, SWT.NONE);
        surficeTableItem.setText("Superficie");
        surficeTableItem.setText(1, "");
                                
        roomQuantityTableItem = new TableItem(generalDataTable, SWT.NONE);
        roomQuantityTableItem.setText("Cantidad de Salas");
        roomQuantityTableItem.setText(1, "");
        
        FormDatas.attach(generalDataTable).atTopTo(generalDataLabel, 5).atLeftTo(group1, 20);
        
        
        userDataLabel = new Label(group1, SWT.NONE);
        userDataLabel.setText("Datos del usuario que actua en el sistema"); //no esta pinchando
		FormDatas.attach(userDataLabel).atTopTo(group1, 10).atLeftTo(generalDataLabel, 300);
		
		userDataTable = new Table(group1, SWT.BORDER | SWT.FULL_SELECTION);
		userDataTable.setHeaderVisible(false);
		userDataTable.setLinesVisible(true);
        
        TableColumn userDataColumn1 = new TableColumn(userDataTable, SWT.NONE);
        userDataColumn1.setWidth(175);
        TableColumn userDataColumn2 = new TableColumn(userDataTable, SWT.NONE);
        userDataColumn2.setWidth(300);
                                
        nameAndLastNameTableItem= new TableItem(userDataTable, SWT.NONE);
        nameAndLastNameTableItem.setText(0,"Nombre y Apellidos");
        nameAndLastNameTableItem.setText(1, "");
                
        userTableItem = new TableItem(userDataTable, SWT.NONE);
        userTableItem.setText("Usuario");
        userTableItem.setText(1, "");
                                
        DateTableItem = new TableItem(userDataTable, SWT.NONE);
        DateTableItem.setText("Fecha");
        DateTableItem.setText(1, "");
        
        HourTableItem = new TableItem(userDataTable, SWT.NONE);
        HourTableItem.setText("Hora");
        HourTableItem.setText(1, "");
        
        FormDatas.attach(userDataTable).atTopTo(generalDataLabel, 5).atLeftTo(generalDataLabel, 300);
        
        addressLibraryLabel = new Label(group1, SWT.NONE);
		addressLibraryLabel.setText("Dirección");
		FormDatas.attach(addressLibraryLabel).atTopTo(generalDataTable,10).atLeft(20);
		
		addressLibraryText = new Text(group1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(addressLibraryText).atTopTo(addressLibraryLabel, 5).atLeft(20).withWidth(350).withHeight(30);
		
		separador = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(addressLibraryText, 10).atLeft(10).atRight(10);
		
		readingSetsDataLabel = new Label(group1, SWT.NONE);
		readingSetsDataLabel.setText("Datos de los puestos de lectura"); 
		FormDatas.attach(readingSetsDataLabel).atTopTo(separador, 10).atLeft(20);
		
		readingSetsDataTable = new Table(group1, SWT.BORDER | SWT.FULL_SELECTION);
		readingSetsDataTable.setHeaderVisible(false);
		readingSetsDataTable.setLinesVisible(true);
        
        TableColumn readingSetsDataTableColumn1 = new TableColumn(readingSetsDataTable, SWT.NONE);
        readingSetsDataTableColumn1.setWidth(150);
        TableColumn readingSetsDataTableColumn2 = new TableColumn(readingSetsDataTable, SWT.NONE);
        readingSetsDataTableColumn2.setWidth(125);
                                
        contReadingSetsDataTableItem = new TableItem(readingSetsDataTable, SWT.NONE);
        contReadingSetsDataTableItem.setText(0,"Cantidad");
        contReadingSetsDataTableItem.setText(1, "");
                
        contUserFormationTableItem = new TableItem(readingSetsDataTable, SWT.NONE);
        contUserFormationTableItem.setText("Formacion de Usuario");
        contUserFormationTableItem.setText(1, "");
                                
        contWorkGroupTableItem = new TableItem(readingSetsDataTable, SWT.NONE);
        contWorkGroupTableItem.setText("Trabajo en Grupo");
        contWorkGroupTableItem.setText(1, "");
        
        FormDatas.attach(readingSetsDataTable).atTopTo(readingSetsDataLabel, 5).atLeftTo(group1, 20);
		
        
        bookshelvesLabel = new Label(group1, SWT.NONE);
        bookshelvesLabel.setText("Estanterias");
		FormDatas.attach(bookshelvesLabel).atTopTo(separador, 10).atLeftTo(generalDataLabel, 300);
		
		bookshelvesTable = new Table(group1, SWT.BORDER | SWT.FULL_SELECTION);
		bookshelvesTable.setHeaderVisible(false);
		bookshelvesTable.setLinesVisible(true);
        
        TableColumn bookshelvesTableColumn1 = new TableColumn(bookshelvesTable, SWT.NONE);
        bookshelvesTableColumn1.setWidth(175);
        TableColumn bookshelvesTableColumn2 = new TableColumn(bookshelvesTable, SWT.NONE);
        bookshelvesTableColumn2.setWidth(300);
                                
        openBookshelvesTableItem= new TableItem(bookshelvesTable, SWT.NONE);
        openBookshelvesTableItem.setText(0,"Abierta");
        openBookshelvesTableItem.setText(1, "");
                
        depositTableItem = new TableItem(bookshelvesTable, SWT.NONE);
        depositTableItem.setText("Deposito");
        depositTableItem.setText(1, "");
        
        FormDatas.attach(bookshelvesTable).atTopTo(bookshelvesLabel, 5).atLeftTo(generalDataLabel, 300);
        
        
		separador1 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador1).atTopTo(readingSetsDataTable, 10).atLeft(10).atRight(10);
		
		equipmentLabel = new Label(group1, SWT.NONE);
		equipmentLabel.setText("Equipamiento");
		FormDatas.attach(equipmentLabel).atTopTo(separador1, 10).atLeft(10);
		
		equipmentTable = new Table(group1, SWT.BORDER | SWT.FULL_SELECTION);
		equipmentTable.setHeaderVisible(false);
		equipmentTable.setLinesVisible(true);
        
        TableColumn equipmentTableTableColumn1 = new TableColumn(equipmentTable, SWT.NONE);
        equipmentTableTableColumn1.setWidth(175);
        TableColumn equipmentTableTableColumn2 = new TableColumn(equipmentTable, SWT.NONE);
        equipmentTableTableColumn2.setWidth(300);
                                
        userPcTableItem= new TableItem(equipmentTable, SWT.NONE);
        userPcTableItem.setText(0,"PC para usuarios");
        userPcTableItem.setText(1, "");
                
        workerPcTableItem = new TableItem(equipmentTable, SWT.NONE);
        workerPcTableItem.setText("PC para trabajadores");
        workerPcTableItem.setText(1, "");
        
        readerPlayersTableItem = new TableItem(equipmentTable, SWT.NONE);
        readerPlayersTableItem.setText("Lectores y Reproductores");
        readerPlayersTableItem.setText(1, "");
        
        
        FormDatas.attach(equipmentTable).atTopTo(equipmentLabel, 5).atLeft(10);
		
		separador2 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador2).atTopTo(equipmentTable, 10).atLeft(10).atRight(10);
		
		
		Label espacio= new Label(group1, SWT.NORMAL);
		FormDatas.attach(espacio).atTopTo(separador2, 10);
		
		workerTabItem = new TabItem(tabFolder, SWT.NONE);
		workerTabItem.setText("Trabajadores");
		group2 = new Composite(tabFolder, SWT.NONE);
		group2.setLayout(form);
		group2.setData(RWT.CUSTOM_VARIANT, "gray_background");
		workerTabItem.setControl(group2);
		FormDatas.attach(group2).atTopTo(tabFolder);
		listWorkerLibraryLabel = new Label(group2, SWT.NORMAL);
		listWorkerLibraryLabel.setText("Trabajadores de la Biblioteca");
		FormDatas.attach(listWorkerLibraryLabel).atTopTo(group2, 10).atLeft(10);
		  
		workerTable = new CRUDTreeTable(group2, SWT.NONE);
		workerTable.setEntityClass(WorkerGrid.class);
		//Point width = workerTable.getSize();
				//workerTable.getBounds().width;
		//workerTable.setAdd(true, new WorkerAddArea(controller));
		//workerTable.setSearch(true);
		//workerTable.setDelete(true);
		//workerTable.setSaveAll(true);
			
		workerTable.setColumnHeaders(Arrays.asList("Nombre", "Descripcion", "sadf", "sadf", "sadfsad"));		//For the internationalization.
			
			try {
				workerTable.createTable();
			}
			catch(Exception e) {
			}
			FormDatas.attach(workerTable).atTopTo(listWorkerLibraryLabel, 10).atLeft(20).atRight(15);
			
			
			workerTable.addUpdateListener(new TreeColumnListener() {
				public void handleEvent(TreeColumnEvent event) {
					//IGridViewEntity entity = (FDTViewEntity) event.entity;
				}
			});
			
			workerTable.addDeleteListener(new TreeColumnListener() {
				public void handleEvent(TreeColumnEvent event) {
					//IGridViewEntity entity = (FDTViewEntity) event.entity;
					//do something with the data
				}
			});
		   
		  
		formationCourseTabItem = new TabItem(tabFolder, SWT.NONE);
		formationCourseTabItem.setText("Formacion");
		group3 = new Composite(tabFolder, SWT.NONE);
		group3.setLayout(form);
		group3.setData(RWT.CUSTOM_VARIANT, "gray_background");
		formationCourseTabItem.setControl(group3);
		FormDatas.attach(group3).atTopTo(tabFolder);
		Label listado1 = new Label(group3, SWT.NORMAL);
	    listado1.setText("Cursos de Formación");
		FormDatas.attach(listado1).atTopTo(group3, 10);
		   
		    formationCourseTable = new CRUDTreeTable(group3, SWT.NONE);
		    formationCourseTable.setEntityClass(FormationCourseGrid.class);
		    //formationCourseTable.setAdd(true, new FormationCourseAddArea());
		    //formationCourseTable.setSearch(true);
		    //formationCourseTable.setDelete(true);
		    //formationCourseTable.setSaveAll(true);
			
		    formationCourseTable.setColumnHeaders(Arrays.asList("Nombre", "Descripcion"));		//For the internationalization.
			
			try {
				formationCourseTable.createTable();
			}
			catch(Exception e) {
			}
			FormDatas.attach(formationCourseTable).atTopTo(listado1, 10).atLeft(20).atRight(15);	
			formationCourseTable.addUpdateListener(new TreeColumnListener() {
				public void handleEvent(TreeColumnEvent event) {
					//IGridViewEntity entity = (FDTViewEntity) event.entity;
					//do something with the data
				}
			});
			
			formationCourseTable.addDeleteListener(new TreeColumnListener() {
				public void handleEvent(TreeColumnEvent event) {
					//IGridViewEntity entity = (FDTViewEntity) event.entity;
					//do something with the data
				}
			});
			
			LoadLibraryData(libraryToView);
			LoadLibraryFormationCourse(libraryToView);
			LoadLibraryWorker(libraryToView);
			return shell;
	}

	private void LoadLibraryWorker(LibraryGrid libraryToUpdate) {
		Collection<Worker> list = ((LibraryViewController) controller)
				.findWorkerByLibrary(libraryToUpdate.getLibrary().getActorID());
		for (Worker worker : list) {
			WorkerGrid aux = new WorkerGrid(worker);
			workerTable.addRow(aux);
		}		
	}

	private void LoadLibraryFormationCourse(LibraryGrid libraryToUpdate) {
		Collection<FormationCourse> list = ((LibraryViewController) controller)
				.findFormationCourseByLibrary(libraryToUpdate.getLibrary().getActorID());
		for (FormationCourse formationCourse : list) {
			FormationCourseGrid aux = new FormationCourseGrid(formationCourse);
			formationCourseTable.addRow(aux);
		}
	}

	private void LoadLibraryData(LibraryGrid library) {
		Library libraryToUpdate = ((LibraryViewController) controller).getLibraryById(library.getLibrary().getActorID());
		
		nameAndLastNameTableItem.setText(1, "");
		userTableItem.setText(1, "");
		DateTableItem.setText(1, "");
		HourTableItem.setText(1, "");
		addressLibraryText.setText("");
		
		nameTableItem.setText(1, (!(libraryToUpdate.getLibraryName() == null) ? libraryToUpdate.getLibraryName():""));
		surficeTableItem.setText(1, (!(libraryToUpdate.getLibrarySurface() == null) ? libraryToUpdate.getLibrarySurface().toString():""));
		roomQuantityTableItem.setText(1, (!(libraryToUpdate.getRoomQuantity() == null) ? libraryToUpdate.getRoomQuantity().toString():""));
		
		
		
		contReadingSetsDataTableItem.setText(1, (!(libraryToUpdate.getAvailableReadingSeats() == null) ? libraryToUpdate.getAvailableReadingSeats().toString():""));
		contUserFormationTableItem.setText(1, (!(libraryToUpdate.getAvailableUserFormationSeats() == null) ? libraryToUpdate.getAvailableUserFormationSeats().toString():""));
		contWorkGroupTableItem.setText(1, (!(libraryToUpdate.getAvailableWorkGroupSeats() == null) ? libraryToUpdate.getAvailableWorkGroupSeats().toString():""));
		openBookshelvesTableItem.setText(1, (!(libraryToUpdate.getOpenBookShelves() == null) ? libraryToUpdate.getOpenBookShelves().toString():""));
		depositTableItem.setText(1, (!(libraryToUpdate.getDepositBookShelves() == null) ? libraryToUpdate.getDepositBookShelves().toString():""));
		userPcTableItem.setText(1, (!(libraryToUpdate.getUserPcQuantity() == null) ? libraryToUpdate.getUserPcQuantity().toString():""));
		workerPcTableItem.setText(1, (!(libraryToUpdate.getWorkerPcQuantity() == null) ? libraryToUpdate.getWorkerPcQuantity().toString():""));
		readerPlayersTableItem.setText(1, (!(libraryToUpdate.getDiverseReaderPlayerQuantity() == null) ? libraryToUpdate.getDiverseReaderPlayerQuantity().toString():""));
	
		Collection<PostalAddress> list = ((LibraryViewController) controller).findPostalAddresByLibrary(libraryToUpdate.getActorID());		
		addressLibraryText.setText((!(list.isEmpty()))?((PostalAddress) (list.toArray())[0]).getComment():"");
		
		
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

	@Override
	public Composite createButtons(Composite arg0, IGridViewEntity arg1,
			IVisualEntityManager arg2) {
		// TODO Auto-generated method stub
		return null;
	}
}