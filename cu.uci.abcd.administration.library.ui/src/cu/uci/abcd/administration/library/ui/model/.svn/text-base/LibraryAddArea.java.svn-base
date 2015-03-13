package cu.uci.abcd.administration.library.ui.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.domain.common.Address;
import cu.uci.abcd.domain.common.EmailAddress;
import cu.uci.abcd.domain.common.PostalAddress;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.validation.ui.CustomControlDecoration;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;


public class LibraryAddArea implements IEditableArea {
	
	private IViewController controller;
	FormLayout form;
	Composite parent;
	TabFolder tabFolder;
	TabItem libraryTabItem; 
	Composite group1;
	Composite group2;
	Composite group3;
	Label lblNewLab;
	Label nameLibraryLabel;
	Text nameLibraryText;
	Label surfaceLibraryLabel;
	Text surfaceLibraryText;
	Label roomQuantityLibraryLabel;
	Text roomQuantityLibraryText;
	Label addressLibraryLabel;
	Text addressLibraryText;
	Label separador;
	Label readingPostsLibraryLabel;
	Label readingSeatsLibraryLabel;
	Text readingSeatsLibraryText;
	Label userFormationLabel;
	Text userFormationText;
	Label workingGroupLabel;
	Text workingGroupText;
	Label separador1;
	Label bookshelvesLabel;
	Label openBookshelvesLabel;
	Text openBookshelvesText;
	Label depositBookshelvesLabel;
	Text depositBookshelvesText;
	Label separador2;
	Label equipmentLabel;
	Label userPcQuantityLabel;
	Text userPcQuantityText;
	Label workersPcQuantityLabel;
	Text workersPcQuantityText;
	Label readerPlayersQuantityLabel;
	Text readerPlayersQuantityText;
	Label emailLibraryLabel;
	TabItem workerTabItem;
	Text emailLibraryText;
	Label listWorkerLibraryLabel;
	CRUDTreeTable workerTable;
	CRUDTreeTable formationCourseTable;
	TabItem formationCourseTabItem;
	
	
	CustomControlDecoration customControlDecoration;
	
	ControlDecoration libraryNameRequiered;
	ControlDecoration libraryNameAlphaNumeric;
	
	ControlDecoration librarySurfaceRequiered;
	ControlDecoration librarySurfaceNumbers;
	
	ControlDecoration libraryRoomQuantityRequiered;
	ControlDecoration libraryRoomQuantityNumbers;
	
	ControlDecoration libraryAddressRequiered;
	
	
	ControlDecoration libraryUserFormationRequiered;
	ControlDecoration libraryUserFormationNumbers;
	
	ControlDecoration libraryReadingSeatsRequiered;
	ControlDecoration libraryReadingSeatsNumbers;
	
	ControlDecoration libraryWorkingGroupRequiered;
	ControlDecoration libraryWorkingGroupNUmbers;
	
	ControlDecoration libraryOpenBookshelvesRequiered;
	ControlDecoration libraryOpenBookshelvesNUmbersd;
	
	ControlDecoration libraryDepositBookshelvesRequiered;
	ControlDecoration libraryDepositBookshelvesNumbers;
	
	ControlDecoration libraryUserPcQuantityRequiered;
	ControlDecoration libraryUserPcQuantityNumbers;
	
	ControlDecoration libraryWorkersPcQuantityRequiered;
	ControlDecoration libraryWorkersPcQuantityNumbers;
	
	ControlDecoration libraryReaderPlayersQuantityRequiered;
	ControlDecoration libraryReaderPlayersQuantityNumbers;
	
	
	
	
	
	//final CustomControlDecoration customControlDecoration =  new CustomControlDecoration();
	
	
	public LibraryAddArea(IViewController controller) {
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
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
		
		lblNewLab = new Label(group1, SWT.NONE);
		lblNewLab.setText(MessageUtil.unescape(AbosMessages.get().LABEL_GENERAL_DATA));
		FormDatas.attach(lblNewLab).atTopTo(group1, 10).atLeft(10);
		
		nameLibraryLabel = new Label(group1, SWT.NONE);
		nameLibraryLabel.setText(MessageUtil.unescape(AbosMessages.get().LABEL_NAME));
		FormDatas.attach(nameLibraryLabel).atTopTo(lblNewLab, 10).atLeft(15);
		
		nameLibraryText = new Text(group1, SWT.BORDER);
		FormDatas.attach(nameLibraryText).atTopTo(nameLibraryLabel, 10).atLeft(15).withWidth(200);
		
		surfaceLibraryLabel = new Label(group1, SWT.NONE);
		surfaceLibraryLabel.setText("Superficie");
		FormDatas.attach(surfaceLibraryLabel).atTopTo(lblNewLab, 10).atLeftTo(nameLibraryText, 70);
		
		
		surfaceLibraryText = new Text(group1, SWT.BORDER);
		FormDatas.attach(surfaceLibraryText).atTopTo(surfaceLibraryLabel, 10).atLeftTo(nameLibraryText, 70).withWidth(200);
		//ClientCustomBehaviors.toOnlyDigits(surfaceLibraryText);
		
		roomQuantityLibraryLabel = new Label(group1, SWT.NONE);
		roomQuantityLibraryLabel.setText("Cantidad de Salas");
		FormDatas.attach(roomQuantityLibraryLabel).atTopTo(lblNewLab, 10).atLeftTo(surfaceLibraryText, 70);
		
		roomQuantityLibraryText = new Text(group1, SWT.BORDER);
		FormDatas.attach(roomQuantityLibraryText).atTopTo(roomQuantityLibraryLabel, 10).atLeftTo(surfaceLibraryText, 70).withWidth(200);
		
		emailLibraryLabel = new Label(group1, SWT.NONE);
		emailLibraryLabel.setText("Correo Electronico");
		FormDatas.attach(emailLibraryLabel).atTopTo(nameLibraryText,10).atLeft(15);
		
		emailLibraryText = new Text(group1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(emailLibraryText).atTopTo(emailLibraryLabel, 10).atLeft(15).withWidth(300);
		
		
		addressLibraryLabel = new Label(group1, SWT.NONE);
		addressLibraryLabel.setText("Dirección");
		FormDatas.attach(addressLibraryLabel).atTopTo(emailLibraryText,10).atLeft(15);
		
		addressLibraryText = new Text(group1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(addressLibraryText).atTopTo(addressLibraryLabel, 10).atLeft(15).atRight(10).withWidth(550).withHeight(30);
		
		separador = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(addressLibraryText, 10).atLeft(10).atRight(10);
		
		readingPostsLibraryLabel = new Label(group1, SWT.NONE);
		readingPostsLibraryLabel.setText("Puestos de Lectura");
		FormDatas.attach(readingPostsLibraryLabel).atTopTo(separador, 10).atLeft(15);
		
		readingSeatsLibraryLabel = new Label(group1, SWT.NONE);
		readingSeatsLibraryLabel.setText("Cantidad");
		FormDatas.attach(readingSeatsLibraryLabel).atTopTo(readingPostsLibraryLabel, 10).atLeft(15);
		
		readingSeatsLibraryText = new Text(group1, SWT.BORDER);
		FormDatas.attach(readingSeatsLibraryText).atTopTo(readingSeatsLibraryLabel, 10).withWidth(200).atLeft(15);
		
		userFormationLabel = new Label(group1, SWT.NONE);
		userFormationLabel.setText("Formación de Usuario");
		FormDatas.attach(userFormationLabel).atTopTo(readingPostsLibraryLabel, 10).atLeftTo(readingSeatsLibraryText, 70);
		
		userFormationText = new Text(group1, SWT.BORDER);
		FormDatas.attach(userFormationText).atTopTo(userFormationLabel, 10).atLeftTo(readingSeatsLibraryText, 70).withWidth(200);
		
		workingGroupLabel = new Label(group1, SWT.NONE);
		workingGroupLabel.setText("Trabajo en Grupo");
		FormDatas.attach(workingGroupLabel).atTopTo(readingPostsLibraryLabel, 10).atLeftTo(userFormationText, 70);
		
		workingGroupText = new Text(group1, SWT.BORDER);
		FormDatas.attach(workingGroupText).atTopTo(readingSeatsLibraryLabel, 10).atLeftTo(userFormationText, 70).withWidth(200);
		
		separador1 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador1).atTopTo(workingGroupText, 10).atLeft(10).atRight(10);
		
		bookshelvesLabel = new Label(group1, SWT.NONE);
		bookshelvesLabel.setText("Estanterías");
		FormDatas.attach(bookshelvesLabel).atTopTo(separador1, 10).atLeft(15);
		
		openBookshelvesLabel = new Label(group1, SWT.NONE);
		openBookshelvesLabel.setText("Abierta");
		FormDatas.attach(openBookshelvesLabel).atTopTo(bookshelvesLabel, 10).atLeft(15);
		
		openBookshelvesText = new Text(group1, SWT.BORDER);
		FormDatas.attach(openBookshelvesText).atTopTo(openBookshelvesLabel, 10).withWidth(200).atLeft(15);
		
		depositBookshelvesLabel = new Label(group1, SWT.NONE);
		depositBookshelvesLabel.setText("Depósito");
		FormDatas.attach(depositBookshelvesLabel).atTopTo(bookshelvesLabel, 10).atLeftTo(openBookshelvesText, 70);
		
		depositBookshelvesText = new Text(group1, SWT.BORDER);
		FormDatas.attach(depositBookshelvesText).atTopTo(depositBookshelvesLabel, 10).atLeftTo(openBookshelvesText, 70).withWidth(200);
	
		separador2 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador2).atTopTo(depositBookshelvesText, 10).atLeft(10).atRight(10);
		
		equipmentLabel = new Label(group1, SWT.NONE);
		equipmentLabel.setText("Equipamiento");
		FormDatas.attach(equipmentLabel).atTopTo(separador2, 10).atLeft(15);
		
		userPcQuantityLabel = new Label(group1, SWT.NONE);
		userPcQuantityLabel.setText("PC para Usuarios");
		FormDatas.attach(userPcQuantityLabel).atTopTo(equipmentLabel, 10).atLeft(15);
		
		userPcQuantityText = new Text(group1, SWT.BORDER);
		FormDatas.attach(userPcQuantityText).atTopTo(userPcQuantityLabel, 10).withWidth(200).atLeft(15);
		
		workersPcQuantityLabel = new Label(group1, SWT.NONE);
		workersPcQuantityLabel.setText("PC para Trabajadores");
		FormDatas.attach(workersPcQuantityLabel).atTopTo(equipmentLabel, 10).atLeftTo(userPcQuantityText, 70);
		
		workersPcQuantityText = new Text(group1, SWT.BORDER);
		FormDatas.attach(workersPcQuantityText).atTopTo(workersPcQuantityLabel, 10).atLeftTo(userPcQuantityText, 70).withWidth(200);
		
		readerPlayersQuantityLabel = new Label(group1, SWT.NONE);
		readerPlayersQuantityLabel.setText("Lectores y Reproductores");
		FormDatas.attach(readerPlayersQuantityLabel).atTopTo(equipmentLabel, 10).atLeftTo(workersPcQuantityText, 70);
		
		readerPlayersQuantityText = new Text(group1, SWT.BORDER);
		FormDatas.attach(readerPlayersQuantityText).atTopTo(readerPlayersQuantityLabel, 10).atLeftTo(workersPcQuantityText, 70).withWidth(200);
		
		Label espacio= new Label(group1, SWT.NORMAL);
		FormDatas.attach(espacio).atTopTo(readerPlayersQuantityText, 10);
		
		workerTabItem = new TabItem(tabFolder, SWT.NONE);
		workerTabItem.setText("Trabajadores");
		group2 = new Composite(tabFolder, SWT.NONE);
		group2.setLayout(form);
		group2.setData(RWT.CUSTOM_VARIANT, "gray_background");
		workerTabItem.setControl(group2);
		FormDatas.attach(group2).atTopTo(tabFolder);
		listWorkerLibraryLabel = new Label(group2, SWT.NORMAL);
		listWorkerLibraryLabel.setText("Trabajadores de la Biblioteca");
		FormDatas.attach(listWorkerLibraryLabel).atTopTo(group2, 10).atLeft(25);
		  
		workerTable = new CRUDTreeTable(group2, SWT.NONE);
		workerTable.setData(RWT.CUSTOM_VARIANT, "gray_background");
		workerTable.setEntityClass(WorkerGrid.class);
		workerTable.setAdd(true, new WorkerAddArea(controller, null));
		workerTable.setAddButtonText("Adicionar");
		workerTable.setUpdate(true, new WorkerUpdateArea(controller));
		workerTable.setWatch(true, new WorkerViewArea(controller));
		workerTable.setCancelButtonText("Cancelar"); 
		
		workerTable.setDelete(true);
		
			
		workerTable.setColumnHeaders(Arrays.asList("Nombre", "Observaciones", "Fecha de Registro"));		//For the internationalization.
			
			try {
				workerTable.createTable();
			}
			catch(Exception e) {
			}
			FormDatas.attach(workerTable).atTopTo(listWorkerLibraryLabel, 10).atLeft(25).atRight(15);
			
			
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
	    FormDatas.attach(listado1).atTopTo(group3, 10).atLeft(25);
		
		   
		    formationCourseTable = new CRUDTreeTable(group3, SWT.NONE);
		    formationCourseTable.setData(RWT.CUSTOM_VARIANT, "gray_background");
		    formationCourseTable.setEntityClass(FormationCourseGrid.class);
		    formationCourseTable.setAdd(true, new FormationCourseAddArea());
		    formationCourseTable.setAddButtonText("Adicionar");
		    formationCourseTable.setUpdate(true, new FormationCourseUpdateArea());
		    formationCourseTable.setWatch(true, new FormationCourseViewArea());
			
		    formationCourseTable.setDelete(true);
		    formationCourseTable.setCancelButtonText("Cancelar"); 
			
		    formationCourseTable.setColumnHeaders(Arrays.asList("Nombre", "Descripcion"));		//For the internationalization.
			
			try {
				formationCourseTable.createTable();
			}
			catch(Exception e) {
			}
			FormDatas.attach(formationCourseTable).atTopTo(listado1, 10).atLeft(25).atRight(15);	
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
			
			//customControlDecoration =  new CustomControlDecoration();
			
			
			//customControlDecoration.CreateDecorateToRequeredField(nameLibraryText, "requiereLibraryName", true);
			
			//customControlDecoration.CreateDecorateToRequeredField(surfaceLibraryText, "requiereLibrarySurface", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(surfaceLibraryText, "numberLibrarySurface");
			
			//customControlDecoration.CreateDecorateToRequeredField(roomQuantityLibraryText, "requiereLibraryRoomQuantity", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(roomQuantityLibraryText, "numberLibraryRoomQuantity");
			
            //customControlDecoration.CreateDecorateToRequeredField(addressLibraryText,  "requiereLibraryAddress", true);
			
			//customControlDecoration.CreateDecorateToRequeredField(readingSeatsLibraryText,  "requiereLibraryReadingSeats", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(readingSeatsLibraryText,  "numberLibraryReadingSeats");
			
			//customControlDecoration.CreateDecorateToRequeredField(userFormationText,  "requiereLibraryUserFormation", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(userFormationText, "numberLibraryUserFormation");
						
			//customControlDecoration.CreateDecorateToRequeredField(workingGroupText,  "requiereLibraryWorkingGroup", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(workingGroupText,  "numberLibraryWorkingGroup");
			
			//customControlDecoration.CreateDecorateToRequeredField(openBookshelvesText,  "requiereLibraryOpenBookshelves", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(openBookshelvesText,  "numberLibraryOpenBookshelves");
			
			//customControlDecoration.CreateDecorateToRequeredField(depositBookshelvesText,  "requiereLibraryDepositBookshelves", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(depositBookshelvesText, "numberLibraryDepositBookshelves");
			
			//customControlDecoration.CreateDecorateToRequeredField(userPcQuantityText, "requiereLibraryAddress", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(userPcQuantityText, "requiereLibraryAddress");
			
			//customControlDecoration.CreateDecorateToRequeredField(workersPcQuantityText,  "requiereLibraryWorkersPcQuantity", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(workersPcQuantityText,  "numberLibraryWorkersPcQuantity");
			
			//customControlDecoration.CreateDecorateToRequeredField(readerPlayersQuantityText,  "requiereLibraryReaderPlayers", true);
			//customControlDecoration.CreateDecorateToOnlyNumberField(readerPlayersQuantityText,  "numberLibraryReaderPlayers");
			
			
			
			
			
			
			  return shell;
	}

	@Override
	public Composite createButtons(final Composite parent, IGridViewEntity entity,
			final IVisualEntityManager manager) {
		Button saveBtn = new Button(parent, SWT.PUSH);
		
		saveBtn.setText("Registrar Library");
		saveBtn.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {
				 if(customControlDecoration.AllControlDecorationsHide()){
				/*
				if (nameLibraryText.getText() != ""
						&& surfaceLibraryText.getText() != ""
						&& roomQuantityLibraryText.getText() != ""
						&& readingSeatsLibraryText.getText() != ""
						&& userFormationText.getText() != ""
						&& workingGroupText.getText() != ""
						&& openBookshelvesText.getText() != ""
						&& depositBookshelvesText.getText() != ""
						&& userPcQuantityText.getText() != ""
						&& workersPcQuantityText.getText() != ""
						&& readerPlayersQuantityText.getText() != ""
						&& addressLibraryText.getText() != "") {
*/
					String libraryName = nameLibraryText.getText();
					Double librarySurface = Double.parseDouble(surfaceLibraryText
							.getText());
					Integer roomQuantity = Integer.parseInt(roomQuantityLibraryText
							.getText());
					Integer availableReadingSeats = Integer
							.parseInt(readingSeatsLibraryText.getText());
					Integer availableUserFormationSeats = Integer
							.parseInt(userFormationText.getText());
					Integer availableWorkGroupSeats = Integer
							.parseInt(workingGroupText.getText());
					Double openBookShelves = Double.parseDouble(openBookshelvesText
							.getText());
					Double depositBookShelves = Double
							.parseDouble(depositBookshelvesText.getText());
					Integer userPcQuantity = Integer.parseInt(userPcQuantityText
							.getText());
					Integer workerPcQuantity = Integer
							.parseInt(workersPcQuantityText.getText());
					Integer diverseReaderPlayerQuantity = Integer
							.parseInt(readerPlayersQuantityText.getText());
					
					PostalAddress postalAddress = new PostalAddress();
					postalAddress.setComment(addressLibraryText.getText());
					
					EmailAddress emailAddress = new EmailAddress();
					emailAddress.setComment(emailLibraryText.getText());
					
					
					//List<Address> listAddress = new ArrayList<Address>();
					//listAddress.add(postalAddress);
					
					Library auxLibrary =  new Library();
					auxLibrary.setLibraryName(libraryName);
					auxLibrary.setLibrarySurface(librarySurface);
					auxLibrary.setRoomQuantity(roomQuantity);
					auxLibrary.setAvailableReadingSeats(availableReadingSeats);
					auxLibrary.setAvailableUserFormationSeats(availableUserFormationSeats);
					auxLibrary.setAvailableWorkGroupSeats(availableWorkGroupSeats);
					auxLibrary.setOpenBookShelves(openBookShelves);
					auxLibrary.setDepositBookShelves(depositBookShelves);
					auxLibrary.setUserPcQuantity(userPcQuantity);
					auxLibrary.setWorkerPcQuantity(workerPcQuantity);
					auxLibrary.setDiverseReaderPlayerQuantity(diverseReaderPlayerQuantity);
					auxLibrary.addAddress(postalAddress);
					auxLibrary.addAddress(emailAddress);
					
					Library ownerLibrary = ((LibraryViewController) controller).SaveLibrary(auxLibrary);	
					LibraryGrid library = new LibraryGrid(ownerLibrary);
					
					
					List<IGridViewEntity> formationCourseList = formationCourseTable.getRows();
					for (IGridViewEntity iGridViewEntity : formationCourseList) {
						FormationCourseGrid auxFormationCourseGrid = (FormationCourseGrid) iGridViewEntity;
						auxFormationCourseGrid.getFormationCourse().setOwnerLibrary(ownerLibrary);
						((LibraryViewController) controller).SaveFormationCourse(auxFormationCourseGrid.getFormationCourse());
					}
					List<IGridViewEntity> workerList = workerTable.getRows();
					
					for (IGridViewEntity iGridViewEntity : workerList) {
						WorkerGrid auxWorkerGrid = (WorkerGrid) iGridViewEntity;
						auxWorkerGrid.getWorker().setWorkPlace(ownerLibrary);
						((LibraryViewController) controller).SaveWorker(auxWorkerGrid.getWorker());
					}
					manager.add(library);
					CleanForm();
					
				}else{
					//campos obligatorios
				}
				
			}

			

		});
		return parent;
	}

	private void CleanForm() {
		nameLibraryText.setText("");
		surfaceLibraryText.setText("");
		roomQuantityLibraryText.setText("");
		readingSeatsLibraryText.setText("");
		userFormationText.setText("");
		workingGroupText.setText("");
		openBookshelvesText.setText("");
		depositBookshelvesText.setText("");
		userPcQuantityText.setText("");
		workersPcQuantityText.setText("");
		readerPlayersQuantityText.setText("");
		addressLibraryText.setText("");
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