package cu.uci.abcd.circulation.ui.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.controller.AllManagementLoanUserViewController;
import cu.uci.abcd.circulation.ui.controller.LoanUserViewController;
import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;



public class EditorAreaUserLoan implements IEditableArea{

	private Map<String, Control> controls;
	private IViewController controller;
	
	Label lbDetailsPerson;
	Label lbUserLoanData;
	Label lbUser;
	Label lbUserType;
	Label lbUserCode;
	Label lbObservation;
	Button btnDiseble;
	Label lbJustification;

	Combo comboUserType;
	
	TableItem tbItemNameLastName;
    TableItem tbItemIdentification;
    TableItem tbItemAge;
	TableItem tbItemSex;
	
	Boolean aux = false;
	
	public EditorAreaUserLoan(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite parent, IGridViewEntity entity,IVisualEntityManager manager) {
				
		parent.setLayout(new FormLayout());
		FormDatas.attach(parent).atRight(0).atLeft(0);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		EntityLoanUser entityLoanUser = (EntityLoanUser)entity;
		
		lbDetailsPerson = new Label(parent, SWT.NONE);
		FormDatas.attach(lbDetailsPerson).atTopTo(parent, 15).atLeftTo(parent, 15);
		
		Label insertarE = new Label(parent, SWT.NONE);
		insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		
		FormDatas.attach(insertarE).atTopTo(lbDetailsPerson, 5).atLeftTo(parent, 15);
		
		Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(130);
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(130);
		
		tbItemNameLastName = new TableItem(tabla, SWT.NONE);
		tbItemNameLastName.setText(1, ((Person)entityLoanUser.getOwner()).getFirstName());
		
		tbItemIdentification = new TableItem(tabla, SWT.NONE);
		tbItemIdentification.setText(1, ((Person)entityLoanUser.getOwner()).getDNI());
		
		tbItemAge = new TableItem(tabla, SWT.NONE);
		
		tbItemSex = new TableItem(tabla, SWT.NONE);
		tbItemSex.setText(1, ((Person)entityLoanUser.getOwner()).getGender().toString());
		
		FormDatas.attach(tabla).atTopTo(lbDetailsPerson, 5).atLeftTo(insertarE, 30);
		
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(tabla, 25).atRight(0).atLeft(0);
		
		lbUserLoanData = new Label(parent, SWT.NONE);
		lbUser = new Label(parent, SWT.NONE);
		lbUserType = new Label(parent, SWT.NONE);
		lbUserCode = new Label(parent, SWT.NONE);
		
		FormDatas.attach(lbUserLoanData).atTopTo(separador, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUser).atTopTo(lbUserLoanData, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserType).atTopTo(lbUserLoanData, 5).atLeftTo(lbUser, 145);
		FormDatas.attach(lbUserCode).atTopTo(lbUserLoanData, 5).atLeftTo(lbUserType, 85);
		
		Text txtUser = new Text(parent, SWT.NORMAL);
		txtUser.setText(entityLoanUser.getLoanUser());
		this.controls.put("txtUser", txtUser);
		
		Text txtUserCode = new Text(parent, SWT.NORMAL);
		txtUserCode.setText(entityLoanUser.getLoanUserCode());
		this.controls.put("txtUserCode", txtUserCode);
		
		comboUserType = new Combo(parent, SWT.NONE);
		
		
		//int seleccionado = (entityLoanUser.getLoanUserType().getNomenclatorID());
		
		//LoanUserType loanUserType = ((LinkedList<LoanUserType>)comboUserType.getData()).get(selectedIndex);
		
		//comboUserType.select(seleccionado);
		initializeCombo();
		this.controls.put("comboUserType", comboUserType);
	
		FormDatas.attach(txtUser).atTopTo(lbUser, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(comboUserType).atTopTo(lbUserType, 5).atLeftTo(txtUser, 30).withWidth(150).withHeight(23);
		FormDatas.attach(txtUserCode).atTopTo(lbUserCode, 5).atLeftTo(comboUserType, 30).withWidth(130).withHeight(10);
		
        lbObservation = new Label(parent, SWT.NONE);
		FormDatas.attach(lbObservation).atTopTo(txtUser, 5).atLeftTo(parent, 15);
		
		Text txtObservation = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		this.controls.put("txtObservation", txtObservation);
		txtObservation.setText(entityLoanUser.getObservation());
		FormDatas.attach(txtObservation).atTopTo(lbObservation, 5).atLeftTo(parent, 15).withWidth(600).withHeight(50);
		
		btnDiseble = new Button(parent, SWT.CHECK);
		FormDatas.attach(btnDiseble).atTopTo(txtObservation, 5).atLeftTo(parent, 15);
		
		lbJustification = new Label(parent, SWT.NONE);
		FormDatas.attach(lbJustification).atTopTo(btnDiseble, 5).atLeftTo(parent, 15);
		lbJustification.setVisible(false);
		
		final Text txtJustification = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtJustification.setVisible(false);
		FormDatas.attach(txtJustification).atTopTo(lbJustification, 5).atLeftTo(parent, 15).withWidth(600).withHeight(50);
		this.controls.put("txtJustification", txtJustification);
		
		
		btnDiseble.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
             	
            	lbJustification.setVisible(true);
    			txtJustification.setVisible(true);
    			aux = true;		           	
             }

    });		
		
		l10n();
		return parent;
	}

	public void l10n() {
		lbDetailsPerson.setText(AbosMessages.get().LABEL_DETAILS_OF_THE_PERSON);
		lbUserLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		lbUser.setText(AbosMessages.get().LABEL_USER);
		lbUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		lbObservation.setText(AbosMessages.get().LABEL_OBSERVATIONS);
		btnDiseble.setText(AbosMessages.get().LABEL_DISABLE);
		lbJustification.setText(MessageUtil.unescape(AbosMessages.get().LABEL_JUSTIFICATION));
				
		tbItemNameLastName.setText(AbosMessages.get().LABEL_NAME);
    	tbItemIdentification.setText(MessageUtil.unescape(AbosMessages.get().LABEL_IDENTIFICATION));
		tbItemAge.setText(AbosMessages.get().TABLE_AGE);
    	tbItemSex.setText(AbosMessages.get().TABLE_SEX);
	}

	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Control getControl(String key) {
		return this.controls.get(key);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Composite createButtons(Composite parent, final IGridViewEntity entity,
			final IVisualEntityManager manager) {
		
		Button updateBtn = new Button(parent, SWT.PUSH);
		updateBtn.setText("Actualizar");
		
		updateBtn.addSelectionListener(new SelectionListener() {
		
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent arg0) {
			
				int selectedIndex = ((Combo)controls.get("comboUserType")).getSelectionIndex();
				LoanUserType loanUserType = ((LinkedList<LoanUserType>)((Combo)controls.get("comboUserType")).getData()).get(selectedIndex);
			
				EntityLoanUser fdtEntity = (EntityLoanUser) entity;
				
			if (aux == true) {
				
				fdtEntity.setLoanUser(((Text)controls.get("txtUser")).getText());
				fdtEntity.setObservation(((Text)controls.get("txtObservation")).getText());
				fdtEntity.setLoanUserType(loanUserType);
				fdtEntity.setLoanUserCode(((Text)controls.get("txtUserCode")).getText());
				fdtEntity.setInactiveStateObservation(((Text)controls.get("txtJustification")).getText());
				fdtEntity.setLoanUserID(fdtEntity.getLoanUserID());
																	
				LoanUser auxLoanUser = new LoanUser();
				auxLoanUser.setLoanUser(fdtEntity.getLoanUser());
				auxLoanUser.setObservation(fdtEntity.getObservation());
				auxLoanUser.setLoanUserType(fdtEntity.getLoanUserType());
				auxLoanUser.setLoanUserCode(fdtEntity.getLoanUserCode());
				auxLoanUser.setInactiveStateObservation(fdtEntity.getInactiveStateObservation());
				auxLoanUser.setLoanUserState(fdtEntity.getLoanUserState().INACTIVE);
				auxLoanUser.setOwner(fdtEntity.getOwner());
				auxLoanUser.setRegistrationDate(fdtEntity.getRegistrationDate());
				auxLoanUser.setLoanUserID(fdtEntity.getLoanUserID());
							
				
				((AllManagementLoanUserViewController) controller).getManageLoanUser().addLoanUser(auxLoanUser);
				 manager.save(fdtEntity);
				
			}	
			else{
				
			fdtEntity.setLoanUser(((Text)controls.get("txtUser")).getText());
			fdtEntity.setObservation(((Text)controls.get("txtObservation")).getText());
			fdtEntity.setLoanUserType(loanUserType);
			fdtEntity.setLoanUserCode(((Text)controls.get("txtUserCode")).getText());
			fdtEntity.setLoanUserID(fdtEntity.getLoanUserID());
																
			LoanUser auxLoanUser = new LoanUser();
			auxLoanUser.setLoanUser(fdtEntity.getLoanUser());
			auxLoanUser.setObservation(fdtEntity.getObservation());
			auxLoanUser.setLoanUserType(fdtEntity.getLoanUserType());
			auxLoanUser.setLoanUserCode(fdtEntity.getLoanUserCode());
			auxLoanUser.setOwner(fdtEntity.getOwner());
			auxLoanUser.setRegistrationDate(fdtEntity.getRegistrationDate());
			auxLoanUser.setLoanUserState(fdtEntity.getLoanUserState().ACTIVE);
			
			auxLoanUser.setLoanUserID(fdtEntity.getLoanUserID());
						
			
			((AllManagementLoanUserViewController) controller).getManageLoanUser().addLoanUser(auxLoanUser);
			 manager.save(fdtEntity);
			 
			 }
		
		}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
		
		return parent;
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
