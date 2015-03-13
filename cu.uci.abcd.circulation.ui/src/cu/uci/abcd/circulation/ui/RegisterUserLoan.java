package cu.uci.abcd.circulation.ui;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.composite.SearchPerson;
import cu.uci.abcd.circulation.ui.controller.AllManagementLoanUserViewController;
import cu.uci.abcd.circulation.ui.controller.LoanUserViewController;
import cu.uci.abcd.circulation.ui.listener.EventRegisterSanctions;
import cu.uci.abcd.circulation.ui.model.EntityLoanUser;
import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abcd.domain.common.EntityState;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.util.api.MessageDialogUtil;


public class RegisterUserLoan implements IContributor {

	private Map<String, Control> controls;
	private IViewController controller;
	
	Label lbDetailsPerson;
	Label lbMsjeUserLoan;
	Label lbUserCode;
	Label lbUser;
	Label lbUserType;
	Label lbObservation;
	Label lbUserLoanData;
	Combo comboUserType;
	
	TableItem tbItemNameLastName;
	TableItem tbItemIdentification;
	TableItem tbItemSex;
	TableItem tbItemAge;
	//----------
	TabFolder tabFolder;
	Label idPerson;
	Combo workerTypeCombo;
	
	Label nameAndLastName;
	Label nameAndLastNameData;
	
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
	
	@Override
	public String contributorName() {
		
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_LOAN_USER);
	}
	@Override
	public Control createUIControl(Composite shell) {
		
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
        
        TabItem libraryTabItem = new TabItem(tabFolder, SWT.NONE);
		libraryTabItem.setText("Usuario de Préstamo");
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
		lbDetailsPerson = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbDetailsPerson).atTopTo(otherDatas, 5).atLeftTo(shell, 15);
		
		
		//child 1
		lbMsjeUserLoan = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbMsjeUserLoan).atTopTo(lbDetailsPerson, 5).atLeftTo(shell, 15);
		
		//child 2
		associateButton = new Button(otherDatas, SWT.PUSH);
		FormDatas.attach(associateButton).atTopTo(lbMsjeUserLoan,55).atLeftTo(lbMsjeUserLoan,50);
		
		//child 3
		lab = new Label(otherDatas, SWT.None);
	     lab.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
	     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		  lab.setText("<img width='110' height='113' src='" +elemento+"'></img>");
		  lab.setVisible(false);
			  FormDatas.attach(lab).atTopTo(lbDetailsPerson, 2).atLeft(10);
			  
	    //child 4  
		generalDataTable = new Table(otherDatas, SWT.BORDER | SWT.FULL_SELECTION);
        generalDataTable.setHeaderVisible(false);
        generalDataTable.setLinesVisible(true);
        generalDataTable.setVisible(false);
        
        
        TableColumn generalDataColumn1 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn1.setWidth(150);
        TableColumn generalDataColumn2 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn2.setWidth(180);
                
        tbItemNameLastName = new TableItem(generalDataTable, SWT.NONE);
        tbItemNameLastName.setText(1, "");
                
        tbItemIdentification = new TableItem(generalDataTable, SWT.NONE);
        tbItemIdentification.setText(1, "");
                                
        tbItemSex = new TableItem(generalDataTable, SWT.NONE);
        tbItemSex.setText(1, "");
        
        tbItemAge = new TableItem(generalDataTable, SWT.NONE);
        tbItemAge.setText(1, "");
        
        FormDatas.attach(generalDataTable).atLeftTo(lab, 0).atTopTo(lbDetailsPerson, 2);
        
        //child 5
        unAssociateButton = new Button(otherDatas, SWT.PUSH);
        unAssociateButton.setVisible(false);
		FormDatas.attach(unAssociateButton).atTopTo(generalDataTable, 10).atLeftTo(generalDataTable, 10);
        
		//child 6
		idPerson = new Label(otherDatas, SWT.NONE);
		idPerson.setVisible(false);
		FormDatas.attach(idPerson);
		
		
		unAssociateButton.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;
            @Override
            public void widgetSelected(SelectionEvent e) {
            	lbMsjeUserLoan.setVisible(true);
            	associateButton.setVisible(true);
				  
            	lab.setVisible(false);
            	generalDataTable.setVisible(false);
            	unAssociateButton.setVisible(false);
            }

    });
        
		associateButton.addListener(SWT.Selection, new Listener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void handleEvent(Event arg0) {
				if(tabFolder.getItemCount()==1){
				TabItem tabItemR = new TabItem(tabFolder, SWT.None);
				tabItemR.setText(AbosMessages.get().LABEL_DETAILS_OF_THE_PERSON);
					
				Composite compoR = new SearchPerson(controller,otherDatas,tabFolder).createUIControl(tabFolder);
				tabItemR.setControl(compoR);
				FormDatas.attach(compoR).atLeft(0).atRight(0).atTopTo(tabFolder, 10);
				}
				tabFolder.setSelection(1);
			}
		});
				
		Label separador = new Label(otherDatas, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(unAssociateButton, 20).atLeft(0).atRight(0);
		
		lbUserLoanData = new Label(otherDatas, SWT.NONE);
		lbUser = new Label(otherDatas, SWT.NONE);
		lbUserType = new Label(otherDatas, SWT.NONE);
		lbUserCode = new Label(otherDatas, SWT.NONE);
		lbObservation = new Label(otherDatas, SWT.NONE);
		final Text txtUser = new Text(otherDatas, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		final Text txtObservations = new Text(otherDatas, SWT.V_SCROLL | SWT.WRAP);
		comboUserType = new Combo(otherDatas, SWT.NONE);
		
		final Text txtUserCode = new Text(otherDatas, SWT.NORMAL);
				
		initializeCombo();
						  
		FormDatas.attach(lbUserLoanData).atTopTo(separador, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUser).atTopTo(lbUserLoanData, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserType).atTopTo(lbUserLoanData, 5).atLeftTo(lbUser, 145);
		FormDatas.attach(lbUserCode).atTopTo(lbUserLoanData, 5).atLeftTo(lbUserType, 87);
		FormDatas.attach(txtUser).atTopTo(lbUser, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(comboUserType).atTopTo(lbUserType, 5).atLeftTo(txtUser, 30).withWidth(150).withHeight(23);
		FormDatas.attach(txtUserCode).atTopTo(lbUserCode, 5).atLeftTo(comboUserType, 30).withWidth(130).withHeight(10);
		FormDatas.attach(lbObservation).atTopTo(txtUser, 5).atLeftTo(parent, 15);
		FormDatas.attach(txtObservations).atTopTo(lbObservation, 5).atLeftTo(parent, 15).withWidth(600).withHeight(50);
	
	
		l10n();
		
		Button saveBtn = new Button(otherDatas, SWT.PUSH);
		saveBtn.setText("Registrar");
		FormDatas.attach(saveBtn).atTopTo(txtObservations, 5).atLeftTo(txtObservations, 15);
		
		saveBtn.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {
			
				Long idPersona = Long.parseLong(idPerson.getText());
				Person person = new Person();
				person = ((AllManagementLoanUserViewController) controller).getPersonService().findOnePerson(idPersona);
				
			EntityState state = EntityState.ACTIVE;
					
			int selectedIndex = comboUserType.getSelectionIndex();
			LoanUserType loanUserType = ((LinkedList<LoanUserType>)comboUserType.getData()).get(selectedIndex);
			
			String userNme = txtUser.getText();
			String observation = txtObservations.getText();
			String code = txtUserCode.getText();
			
			LoanUser loanUser = new EntityLoanUser(userNme,observation, loanUserType , code, state, person);
												
				LoanUser auxLoanUser = new LoanUser();
				auxLoanUser.setLoanUser(loanUser.getLoanUser());
				auxLoanUser.setObservation(loanUser.getObservation());
				auxLoanUser.setLoanUserType(loanUser.getLoanUserType());
				auxLoanUser.setLoanUserCode(loanUser.getLoanUserCode());
				auxLoanUser.setLoanUserState(loanUser.getLoanUserState().ACTIVE);
				auxLoanUser.setOwner(loanUser.getOwner());
				
				((AllManagementLoanUserViewController) controller).getManageLoanUser().addLoanUser(auxLoanUser);
				
				// clean the controls
				txtUser.setText("");
				txtObservations.setText("");
				txtUserCode.setText("");
				
				//---------------Mensaje 
				
				MessageDialogUtil.openInformation(Display.getCurrent().getActiveShell(), "Information",
						"The item was registered successfully", null);
				
				
				
			}

		});
		
	
		
	 return parent;
	}

	@Override
	public String getID() {
		return "RegistrarUsuarioPrestamoID";
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		
		lbDetailsPerson.setText(AbosMessages.get().LABEL_DETAILS_OF_THE_PERSON);
		lbMsjeUserLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MESSAGE_USER_LOAN));
		lbUserLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		lbUser.setText(AbosMessages.get().LABEL_USER);
		lbUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		lbObservation.setText(AbosMessages.get().LABEL_OBSERVATIONS);
		lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		associateButton.setText(AbosMessages.get().BUTTON_ASSOCIATE);
		unAssociateButton.setText(AbosMessages.get().BUTTON_DISSOCIATE);
			
		tbItemNameLastName.setText(AbosMessages.get().LABEL_NAME);
    	tbItemIdentification.setText(MessageUtil.unescape(AbosMessages.get().LABEL_IDENTIFICATION));
		tbItemAge.setText(AbosMessages.get().TABLE_AGE);
    	tbItemSex.setText(AbosMessages.get().TABLE_SEX);
		
	}
	

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
	}
	
	private void initializeCombo() {
        
		List<LoanUserType> listloanUserType = ((AllManagementLoanUserViewController) controller).getManageLoanUser().findAllLoanUserType();
		String [] comboStrings = new String[listloanUserType.size()];
		List<LoanUserType> type = new LinkedList<LoanUserType>();
		for (int i = 0; i < listloanUserType.size(); i++) {
			
			type.add(listloanUserType.get(i));
			comboStrings[i] = listloanUserType.get(i).getNomeclatorName();
			
		}
		comboUserType.setData(type);
		comboUserType.setItems(comboStrings);

	}

}
