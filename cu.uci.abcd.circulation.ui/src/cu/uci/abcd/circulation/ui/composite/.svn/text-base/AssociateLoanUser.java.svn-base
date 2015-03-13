package cu.uci.abcd.circulation.ui.composite;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.TangibleActor;
import cu.uci.abcd.circulation.ui.controller.AllManagementLoanUserViewController;
import cu.uci.abcd.circulation.ui.model.EntityLoanUser;
import cu.uci.abcd.circulation.ui.model.ViewAreaUserLoan;
import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.Column;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class AssociateLoanUser{
	
	private IViewController controller;
	FormLayout form;
	static CRUDTreeTable tabla;
	private Composite compo;
	private TabFolder tabFolder;

	public AssociateLoanUser(IViewController controller, Composite compo, TabFolder tabFolder) {
		this.controller = controller;
		this.compo = compo;
		this.tabFolder= tabFolder;
	}
	
	public Composite createUIControl(Composite shell) {
		
		
		Composite parent = new Composite(shell, SWT.NONE);
		parent.setLayout(new FormLayout());
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atTopTo(shell, 15);
		
		Label lbSearchCriteria;
		Label lbUserCode;
		Label lbUSer;
		Label lbName;
		Label lbUSerType;
		Label lbRange;
		Label lbFrom;
		Label lbUp;
		Label lbCoincidenceList;
		
		Button btnConsult;
		Button btnClose;
		
		lbSearchCriteria = new Label(parent, SWT.NONE);
		lbUserCode = new Label(parent, SWT.NONE);
		lbUSer = new Label(parent, SWT.NONE);
		lbName = new Label(parent, SWT.NONE);
		lbUSerType = new Label(parent, SWT.NONE);
		  
		FormDatas.attach(lbSearchCriteria).atTopTo(parent, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode).atTopTo(lbSearchCriteria, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUSer).atTopTo(lbSearchCriteria, 5).atLeftTo(lbUserCode, 80);
		FormDatas.attach(lbName).atTopTo(lbSearchCriteria, 5).atLeftTo(lbUSer, 140);
		FormDatas.attach(lbUSerType).atTopTo(lbSearchCriteria, 5).atLeftTo(lbName, 140);
		
		Text txtUserCode = new Text(parent, SWT.NORMAL);
		Text txtUSer = new Text(parent, SWT.NORMAL);
		Text txtName = new Text(parent, SWT.NORMAL);
		Combo comboTypeUSer = new Combo(parent, SWT.NONE);
		comboTypeUSer.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		
		FormDatas.attach(txtUserCode).atTopTo(lbUserCode, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtUSer).atTopTo(lbUSer, 5).atLeftTo(txtUserCode, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtName).atTopTo(lbName, 5).atLeftTo(txtUSer, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboTypeUSer).atTopTo(lbUSerType, 5).atLeftTo(txtName, 30).withWidth(150).withHeight(23);
		
	    lbRange = new Label(parent, SWT.NONE);
		lbFrom = new Label(parent, SWT.NONE);
		lbUp = new Label(parent, SWT.NONE);
		
		FormDatas.attach(lbRange).atTopTo(txtUserCode, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbFrom).atTopTo(lbRange, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUp).atTopTo(lbRange, 5).atLeftTo(lbRange, 8);
		
		DateTime dateTime = new DateTime(parent, SWT.BORDER | SWT.DROP_DOWN);
		DateTime dateTime1 = new DateTime(parent, SWT.BORDER | SWT.DROP_DOWN);
		
		FormDatas.attach(dateTime).atTopTo(lbFrom, 5).atLeftTo(parent, 15);
		FormDatas.attach(dateTime1).atTopTo(lbUp, 5).atLeftTo(lbFrom, 120);
		
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(dateTime, 5).atLeft(0).atRight(0);
		
		btnConsult = new Button(parent, SWT.PUSH);
		btnClose = new Button(parent, SWT.PUSH);
		
		FormDatas.attach(btnClose).atTopTo(separador, 5).atRight(0).withWidth(100).withHeight(23);
		FormDatas.attach(btnConsult).atTopTo(separador, 5).atRightTo(btnConsult, 20).withWidth(100).withHeight(23);
				
		lbCoincidenceList = new Label(parent, SWT.NONE);
		FormDatas.attach(lbCoincidenceList).atTopTo(btnConsult, 5).atLeftTo(parent, 15);
		
		//-----------------Tabla--------------------------------------
						
		tabla = new CRUDTreeTable(parent, SWT.BORDER);
		tabla.setEntityClass(EntityLoanUser.class);
			
		tabla.addActionColumn(new Column(shell.getDisplay(), "arrow_down.png", new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				
				EntityLoanUser entity = (EntityLoanUser) event.entity;
				Control[] childrens = compo.getChildren();
						    
				   childrens[0].setVisible(true);
				   
				   childrens[1].setVisible(false);
				   childrens[2].setVisible(false);
				   childrens[3].setVisible(false);
				   childrens[4].setVisible(false);
				   childrens[5].setVisible(false);
				  
				   childrens[6].setVisible(true);
				   childrens[7].setVisible(true);
				   childrens[8].setVisible(true);
				   
				   ((Label)childrens[9]).setText(entity.getLoanUserID().toString());
				   
				   
				   Table dataPersonTable = (Table) childrens[7];
				   
				   dataPersonTable.getItem(0).setText(1,entity.getObservation());
				   dataPersonTable.getItem(1).setText(1,entity.getLoanUser());
				   dataPersonTable.getItem(2).setText(1,entity.getloanUserCode());
				   dataPersonTable.getItem(3).setText(1,entity.getLoanUserType().getNomenclatorDescription());
				   dataPersonTable.getItem(4).setText(1,entity.getLoanUserState().toString());
				   
				tabFolder.setSelection(0);
			}
		}));
		
		tabla.setColumnHeaders(Arrays.asList("Usuario", "Justificacion", "Tipo de Usuario", "Codigo de Usuario", "Estado")); 																	
		try {
			tabla.createTable();
		} catch (Exception e) {
		}
		
		FormDatas.attach(tabla).atTopTo(lbCoincidenceList, 10).atLeft(0).atRight(0);
		
		initializePersonGrid();
				
		
		lbSearchCriteria.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		lbUSer.setText(AbosMessages.get().LABEL_USER);
		lbName.setText(AbosMessages.get().LABEL_NAME);
		lbUSerType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);		
		lbRange.setText(AbosMessages.get().LABEL_DATE_OF_REGISTRATION_RANGE);
		lbFrom.setText(AbosMessages.get().LABEL_FROM);
		lbUp.setText(AbosMessages.get().LABEL_UP);
		lbCoincidenceList.setText(AbosMessages.get().LABEL_COINCIDENCE_LIST);
		
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnClose.setText(AbosMessages.get().BUTTON_CLOSE);
		
		return parent;
		
	}
		
	 private void initializePersonGrid() {
		
		Collection<LoanUser> list = ((AllManagementLoanUserViewController) controller).getManageLoanUser().findAll();
		
		for (LoanUser aux : list) {
			EntityLoanUser loanUser = new EntityLoanUser(aux.getLoanUser(),
					 aux.getObservation(), aux.getLoanUserType(), aux.getLoanUserCode(), aux.getLoanUserState(), (Person) aux.getOwner());
			loanUser.setLoanUserID(aux.getLoanUserID());
			tabla.addRow(loanUser);
		}
	}
}
