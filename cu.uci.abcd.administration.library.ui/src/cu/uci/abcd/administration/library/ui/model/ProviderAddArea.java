package cu.uci.abcd.administration.library.ui.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.fieldassist.ControlDecoration;
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
import cu.uci.abcd.administration.library.ui.controller.ProviderViewController;
import cu.uci.abcd.domain.common.Address;
import cu.uci.abcd.domain.common.EmailAddress;
import cu.uci.abcd.domain.common.EntityState;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.PhoneNumber;
import cu.uci.abcd.domain.common.PostalAddress;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abcd.domain.management.library.ProviderType;
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

public class ProviderAddArea implements IEditableArea{
	private IViewController controller;
	Composite parent;
	TabFolder tabFolder;
	 TabItem providerTabItem;
	 Composite otherDatas;
	 Label sugestAsociate;
	 Button asociar;
	 Label otherDatasLabel;
	 Table generalDataTable;
	 Button  unAssociateButton;
	 Control group2;
	 Label idPerson;
	 Label providerNameLabel;
	 Text providerNameText;
	 Label identificLabel;
	 Text identificText;
	 Button cangeCheckButton;
	 Button donateCheckButton;
	 Button commercialCheckButton;
	 Button productorCheckButton;
	 Label phoneProviderLabel;
	 
	 Label representDataLabel;
	 Text phoneProviderText;
	 Label emailProviderLabel;
	 Text emailProviderText;
	 Label directionProviderLabel;
	 Text directionProviderText;
	 
	
	private Map<String, Control> controls = new HashMap<String, Control>();
		
	
	public ProviderAddArea(IViewController controller) {
		this.controller = controller;
	}
	
	public ProviderAddArea() {
		
	}
	
	@Override
	public Composite createUI(final Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
				
		parent= new Composite(shell, SWT.NORMAL);
		parent.setLayout(form);
		//parent.setVisible(false);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
		
		tabFolder = new TabFolder(parent, SWT.NONE);
		tabFolder.setData(RWT.CUSTOM_VARIANT, "gray_background");
        FormDatas.attach(tabFolder).atTopTo(parent).atLeft(0).atRight(0);
        
        providerTabItem = new TabItem(tabFolder, SWT.NONE);
        providerTabItem.setText("Provedor");
		Composite group1 = new Composite(tabFolder, SWT.NONE);
		group1.setLayout(form);
		group1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		providerTabItem.setControl(group1);
		FormDatas.attach(group1).atTopTo(tabFolder).atLeft(0).atRight(0);
		
		otherDatas = new Composite(group1, SWT.NORMAL);
		otherDatas.setLayout(form);
		otherDatas.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(otherDatas).atTopTo(group1, 10).atLeft(0).atRight(0);
		
		//child 0
		Label lblCriiteriosDeBsqueda = new Label(otherDatas, SWT.NONE);
		lblCriiteriosDeBsqueda.setLayoutData(new FormData());
		lblCriiteriosDeBsqueda.setText("Datos del Provedor");
		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(otherDatas, 5).atLeft(10);
		
		providerNameLabel =  new Label(otherDatas, SWT.NONE);
		FormDatas.attach(providerNameLabel).atTopTo(lblCriiteriosDeBsqueda, 10).atLeft(10);
		providerNameLabel.setText("Nombre del Proveedor");
		
		providerNameText = new Text(otherDatas, SWT.BORDER);
		FormDatas.attach(providerNameText).atTopTo(providerNameLabel, 10).atLeft(10).withWidth(190);
	
		
		identificLabel=  new Label(otherDatas, SWT.NONE);
		identificLabel.setLayoutData(new FormData());
		FormDatas.attach(identificLabel).atLeftTo(providerNameText, 35).atTopTo(lblCriiteriosDeBsqueda, 10);
		identificLabel.setText("Identificación");
		
		identificText = new Text(otherDatas, SWT.BORDER);
		FormDatas.attach(identificText).atLeftTo(providerNameText, 35).atTopTo(identificLabel, 10).withWidth(190);
		
		
		phoneProviderLabel=  new Label(otherDatas, SWT.NONE);
		phoneProviderLabel.setText("Telefono");
		FormDatas.attach(phoneProviderLabel).atLeftTo(identificText, 35).atTopTo(lblCriiteriosDeBsqueda, 10);
		
		phoneProviderText = new Text(otherDatas, SWT.BORDER);
		FormDatas.attach(phoneProviderText).atLeftTo(identificText, 35).atTopTo(identificLabel, 10).withWidth(190);
		
		emailProviderLabel=  new Label(otherDatas, SWT.NONE);
		emailProviderLabel.setText("Correo");
		FormDatas.attach(emailProviderLabel).atLeftTo(phoneProviderText, 35).atTopTo(lblCriiteriosDeBsqueda, 10);
		
		emailProviderText = new Text(otherDatas, SWT.BORDER);
		FormDatas.attach(emailProviderText).atLeftTo(phoneProviderText, 35).atTopTo(identificLabel, 10).withWidth(190);
		
		Label lblTPo=  new Label(otherDatas, SWT.NONE);
		lblTPo.setText("Tipo de Proveedor");
		FormDatas.attach(lblTPo).atTopTo(providerNameText, 15).atLeft(10);
		
		commercialCheckButton = new Button(otherDatas, SWT.CHECK);
		commercialCheckButton.setText("Comercial");
		FormDatas.attach(commercialCheckButton).atTopTo(lblTPo, 10).atLeft(10);

		cangeCheckButton = new Button(otherDatas, SWT.CHECK);
		cangeCheckButton.setText("Canje");
		FormDatas.attach(cangeCheckButton).atLeftTo(commercialCheckButton, 10)
				.atTopTo(lblTPo, 10);

		donateCheckButton = new Button(otherDatas, SWT.CHECK);
		donateCheckButton.setText("Donaciones");
		FormDatas.attach(donateCheckButton).atLeftTo(cangeCheckButton, 10)
				.atTopTo(lblTPo, 10);

		productorCheckButton = new Button(otherDatas, SWT.CHECK);
		productorCheckButton.setText("Productor");
		FormDatas.attach(productorCheckButton).atLeftTo(donateCheckButton, 10)
				.atTopTo(lblTPo, 10);

  directionProviderLabel=  new Label(otherDatas, SWT.NONE);
  FormDatas.attach(directionProviderLabel).atTopTo(productorCheckButton, 20).atLeft(10);
  directionProviderLabel.setText("Direccion");

 directionProviderText = new Text(otherDatas, SWT.BORDER |  SWT.WRAP);
 FormDatas.attach(directionProviderText).atTopTo(directionProviderLabel, 10).withHeight(30).atLeft(10).atRight(10);
 
 Label separador = new Label(otherDatas, SWT.SEPARATOR | SWT.HORIZONTAL);
	FormDatas.attach(separador).atTopTo(directionProviderText, 10).atLeft(5).atRight(5);
	
	representDataLabel=  new Label(otherDatas, SWT.NONE);
	representDataLabel.setText("Datos del Representante");

	FormDatas.attach(representDataLabel).atTopTo(separador,20).atLeft(10);
	
	
		sugestAsociate=  new Label(otherDatas, SWT.NONE);
		FormDatas.attach(sugestAsociate).atTopTo(representDataLabel, 10).atLeft(10);
		sugestAsociate.setText("¨Puede asociar una Persona como Represenante del Proveedor¨");
		controls.put("1", sugestAsociate);
		
		 otherDatasLabel = new Label(otherDatas, SWT.None);
		 otherDatasLabel.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
	     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
	     otherDatasLabel.setText("<img width='100' height='114' src='" +elemento+"'></img>");
	     otherDatasLabel.setVisible(false);
	     FormDatas.attach(otherDatasLabel).atTopTo(representDataLabel, 10).atLeft(10);
	     controls.put("3", otherDatasLabel);
		
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
	        
	        FormDatas.attach(generalDataTable).atLeftTo(otherDatasLabel, 0).atTopTo(representDataLabel, 2);
	        
		
	      //child 5
	        unAssociateButton = new Button(otherDatas, SWT.PUSH);
	        unAssociateButton.setText("Desasociar");
	        unAssociateButton.setVisible(false);
			FormDatas.attach(unAssociateButton).atTopTo(representDataLabel, 85).atLeftTo(generalDataTable, 5);
			controls.put("5", unAssociateButton);
	        
			unAssociateButton.addSelectionListener(new SelectionAdapter() {
	            
	            private static final long serialVersionUID = 1L;
	            @Override
	            public void widgetSelected(SelectionEvent e) {
	            	sugestAsociate.setVisible(true);
	            	asociar.setVisible(true);
					   
	            	otherDatasLabel.setVisible(false);
	            	generalDataTable.setVisible(false);
	            	unAssociateButton.setVisible(false);
	            	group2.setVisible(false);
	            }

	    });
			
			//child 6
			idPerson = new Label(otherDatas, SWT.NONE);
			idPerson.setLayoutData(new FormData());
			idPerson.setVisible(false);
			FormDatas.attach(idPerson);
			
			controls.put("6", idPerson);
			
		asociar = new Button(otherDatas, SWT.PUSH);
		FormDatas.attach(asociar).atLeft(10).atTopTo(sugestAsociate, 20);
		asociar.setText("Asociar");
		controls.put("2", asociar);
		
		Label espacio = new Label(otherDatas, SWT.NORMAL);
		FormDatas.attach(espacio).atTopTo(asociar, 5);
		
		asociar.addSelectionListener(new SelectionAdapter() {
        
        private static final long serialVersionUID = 1L;
        @Override
        public void widgetSelected(SelectionEvent e) {
        	if(tabFolder.getItemCount()==1){
        		providerTabItem = new TabItem(tabFolder, SWT.NONE);
        		providerTabItem.setText("Persona");
    	    group2 = new SearchPerson(controller, tabFolder, controls).createUIControl(tabFolder);
    	    providerTabItem.setControl(group2);
    		FormDatas.attach(group2).atTopTo(tabFolder);
    		
        	}
        	tabFolder.setSelection(1);
        }

});
		
		
		 
		 
		 
		return shell;
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
				if( !(idPerson.getText() == null) && (!(providerNameText.getText()==null)) && (!(identificText.getText()==null)) ){
					Long personId = Long.parseLong(idPerson.getText());
					String providerName = providerNameText.getText();
					String rIF_NIT = identificText.getText();
					
					Person represent = ((ProviderViewController) controller).getPersonById(personId);
					
					Provider provider = new Provider();
					provider.setProviderName(providerName);
					provider.setRIF_NIT(rIF_NIT);
					provider.setRepresentativePerson(represent);
					
					List<ProviderType> listProviderType = new ArrayList<ProviderType>();
					if(cangeCheckButton.getSelection()){
						listProviderType.add(ProviderType.EXCHANGE);
					}
					if(commercialCheckButton.getSelection()){
						listProviderType.add(ProviderType.COMMERCIAL);
					}
					if(donateCheckButton.getSelection()){
						listProviderType.add(ProviderType.DONATION);
					}
					if(productorCheckButton.getSelection()){
						listProviderType.add(ProviderType.PRODUCER);
					}
					
					PostalAddress postalAddress = new PostalAddress();
					postalAddress.setComment(directionProviderText.getText());
					provider.addAddress(postalAddress);
					
					EmailAddress emailAddress = new EmailAddress();
					emailAddress.setComment(emailProviderText.getText());
					provider.addAddress(emailAddress);
					
					PhoneNumber phoneNumber = new PhoneNumber();
					phoneNumber.setComment(phoneProviderText.getText());
					provider.addAddress(phoneNumber);
					
					provider.setProviderTypeList(listProviderType);
					provider.setProviderState(EntityState.ACTIVE);
					Provider providerSaved = ((ProviderViewController) controller).SaveProvider(provider);	
					ProviderGrid providerGrid = new ProviderGrid(providerSaved);
					manager.add(providerGrid);
					
					CleanForm();
					
					 //Button donateCheckButton;
					//Button commercialCheckButton;
					 //Button productorCheckButton;
					 
					
					
					
					
				}
				
			}
		});
		return parent;
	}

	private void CleanForm() {
		
		otherDatasLabel.setVisible(false);
		generalDataTable.setVisible(false);
		unAssociateButton.setVisible(false);
		
		donateCheckButton.setSelection(false);
		commercialCheckButton.setSelection(false);
		productorCheckButton.setSelection(false);
		cangeCheckButton.setSelection(false);
		providerNameText.setText("");
		identificText.setText("");
		phoneProviderText.setText("");
		emailProviderText.setText("");
		directionProviderText.setText("");
		
		
		representDataLabel.setVisible(true);
		sugestAsociate.setVisible(true);
		asociar.setVisible(true);
		
		//controlsMaps.get("associatePersonLabel").setVisible(true);
		//controlsMaps.get("associateButton").setVisible(true);
		//controlsMaps.get("otherDatasLabel").setVisible(false);
		//controlsMaps.get("generalDataTable").setVisible(false);
		//controlsMaps.get("unAssociateButton").setVisible(false);
		//idPerson.setText("");;
		//workerTypeCombo.setText("");
		//descriptionText.setText("");
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

	
}
