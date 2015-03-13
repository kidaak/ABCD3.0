package cu.uci.abcd.administration.library.ui.model;

import java.util.Arrays;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class WorkerViewArea implements IEditableArea{

	private IViewController controller;
	//private Library libraryToUpdate;
	
	FormLayout form;
	Composite parent;
	//TabFolder tabFolder;
	//TabItem libraryTabItem; 
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
	
	public WorkerViewArea(IViewController controller) {
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		
		//LibraryGrid libraryToView = (LibraryGrid)entity;
		
		form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
		parent= new Composite(shell, SWT.NORMAL);
		
		parent.setLayout(form);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
        //tabFolder = new TabFolder(parent, SWT.NONE);
        //tabFolder.setData(RWT.CUSTOM_VARIANT, "gray_background");
        //FormDatas.attach(tabFolder).atTopTo(parent).atLeft(0).atRight(0);
		group1 = new Composite(parent, SWT.NONE);
		group1.setLayout(form);
		group1.setData(RWT.CUSTOM_VARIANT, "gray_background");
	
		FormDatas.attach(group1).atTopTo(parent).atLeft(0).atRight(0);
		
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
		FormDatas.attach(addressLibraryText).atTopTo(addressLibraryLabel, 5).atLeft(10).withWidth(350).withHeight(30);
		
		
		
		
		
			return shell;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Control getControl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Composite createButtons(Composite arg0, IGridViewEntity arg1,
			IVisualEntityManager arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
