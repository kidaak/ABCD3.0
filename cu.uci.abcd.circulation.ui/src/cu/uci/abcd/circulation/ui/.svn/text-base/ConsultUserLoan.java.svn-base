package cu.uci.abcd.circulation.ui;

import java.util.Arrays;
import java.util.Collection;
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
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.controller.AllManagementLoanUserViewController;
import cu.uci.abcd.circulation.ui.controller.LoanUserViewController;
import cu.uci.abcd.circulation.ui.listener.EventConsultUserLoan;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.Actor;
import cu.uci.abcd.circulation.ui.model.EditorAreaUserLoan;
import cu.uci.abcd.circulation.ui.model.EntityLoanUser;
import cu.uci.abcd.circulation.ui.model.ViewAreaUserLoan;
import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ConsultUserLoan implements IContributor{
	private Map<String, Control> controls;
	private IViewController controller;
	
	Label lbSEARCH_CRITERIA;
	Label lbUserCode;
	Label lbUser;
	Label lbUserType;
	Label lbState;
	Label lbFirstName;
	Label lbSecondName;
	Label lbFirstLast;
	Label lbSecondLast;
	Label lbCoincidenceList;
	Link link;
	Button btnConsult;
	Button btnNewSearch;
	Button btnExportExcel;
	Button btnExportPDF;
	Label lbState1;
	Label lbFrom;
	Label lbUp;
	Label lbRange;
	CRUDTreeTable tabla;
	Combo comboUserType;
	
	@Override
	public String contributorName() {
	
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_CONSULT_LOAN_USER);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		
		FormLayout form = new FormLayout();
		parent.setLayout(form);
		
		Composite busquedaB = new Composite(parent, SWT.NORMAL);
		busquedaB.setData(RWT.CUSTOM_VARIANT, "gray_background");
		busquedaB.setVisible(true);
		busquedaB.setLayout(new FormLayout());
		FormDatas.attach(busquedaB).atTopTo(parent, 5).atLeft(0).atRight(0).withHeight(75);
		
		lbSEARCH_CRITERIA = new Label(busquedaB, SWT.NONE);
		lbUser = new Label(busquedaB, SWT.NONE);
		lbUserCode = new Label(busquedaB, SWT.NONE);
		lbUserType = new Label(busquedaB, SWT.NONE);
		lbState= new Label(busquedaB, SWT.NONE);
		
		FormDatas.attach(lbSEARCH_CRITERIA).atTopTo(busquedaB, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUser).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(lbUser, 80);
		FormDatas.attach(lbUserType).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(lbUserCode, 137);
		FormDatas.attach(lbState).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(lbUserType, 100);
		
		Text txtUserCode = new Text(busquedaB, SWT.NORMAL);
		final Text txtUser = new Text(busquedaB, SWT.NORMAL);
		comboUserType = new Combo(busquedaB, SWT.NONE);
		initializeCombo();
		Combo comboState = new Combo(busquedaB, SWT.NONE);
		comboState.setItems(new String[] { "Activo", "Inactivo"});
			    
		FormDatas.attach(txtUserCode).atTopTo(lbUser, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtUser).atTopTo(lbUserCode, 5).atLeftTo(txtUserCode, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboUserType).atTopTo(lbUserType, 5).atLeftTo(txtUser, 30).withWidth(150).withHeight(23);
		FormDatas.attach(comboState).atTopTo(lbUserType, 5).atLeftTo(comboUserType, 30).withWidth(150).withHeight(23);
				
		lbFirstName = new Label(busquedaB, SWT.NONE);
		lbSecondName = new Label(busquedaB, SWT.NONE);
		lbFirstLast = new Label(busquedaB, SWT.NONE);
		lbSecondLast = new Label(busquedaB, SWT.NONE);
		
		FormDatas.attach(lbFirstName).atTopTo(txtUserCode, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbSecondName).atTopTo(txtUser, 5).atLeftTo(lbFirstName, 100);
		FormDatas.attach(lbFirstLast).atTopTo(comboUserType, 5).atLeftTo(lbSecondName, 90);
		FormDatas.attach(lbSecondLast).atTopTo(comboState, 5).atLeftTo(lbFirstLast, 90);  
		
		Text txtFirstName = new Text(busquedaB, SWT.NORMAL);
		Text txtSecondName = new Text(busquedaB, SWT.NORMAL);
		Text txtFirstLast = new Text(busquedaB, SWT.NORMAL);
		Text txtSecondLast = new Text(busquedaB, SWT.NORMAL);
		
		FormDatas.attach(txtFirstName).atTopTo(lbFirstName, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtSecondName).atTopTo(lbSecondName, 5).atLeftTo(txtFirstName, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtFirstLast).atTopTo(lbFirstLast, 5).atLeftTo(txtSecondName, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtSecondLast).atTopTo(lbSecondLast, 5).atLeftTo(txtFirstLast, 30).withWidth(130).withHeight(10);
		
	    lbRange = new Label(busquedaB, SWT.NONE);
	    lbState1 = new Label(busquedaB, SWT.NONE);
	    lbFrom = new Label(busquedaB, SWT.NONE);
		lbUp = new Label(busquedaB, SWT.NONE);
	         
		lbRange.setText(AbosMessages.get().LABEL_DATE_OF_REGISTRATION_RANGE);
		lbState1.setText(AbosMessages.get().LABEL_STATE);
	  	    
	    FormDatas.attach(lbRange).atTopTo(txtFirstName, 5).atLeftTo(busquedaB, 200);
		FormDatas.attach(lbState1).atTopTo(lbRange, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbFrom).atTopTo(lbRange, 5).atLeftTo(lbState1, 150);
		FormDatas.attach(lbUp).atTopTo(lbRange, 5).atLeftTo(lbFrom, 120);  
	    
	    Text text7 = new Text(busquedaB, SWT.NORMAL);
	    DateTime dateTime = new DateTime(busquedaB, SWT.BORDER | SWT.DROP_DOWN);
		DateTime dateTime1 = new DateTime(busquedaB, SWT.BORDER | SWT.DROP_DOWN);
		
		FormDatas.attach(text7).atTopTo(lbState1, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(dateTime).atTopTo(lbFrom, 5).atLeftTo(text7, 30);
		FormDatas.attach(dateTime1).atTopTo(lbUp, 5).atLeftTo(dateTime, 30);  
		
		//--------------------------------------------------------------
		
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(busquedaB, 5).atRight(5).atLeft(5);
				
		link = new Link(parent, SWT.NONE);
		btnConsult = new Button(parent, SWT.PUSH);
		btnNewSearch = new Button(parent, SWT.PUSH);
				
		FormDatas.attach(btnNewSearch).atTopTo(separador, 5).atRight(0).withWidth(120).withHeight(23);
		FormDatas.attach(btnConsult).atTopTo(separador, 5).atRightTo(btnNewSearch, 10).withWidth(100).withHeight(23);
		FormDatas.attach(link).atTopTo(separador, 5).atRightTo(btnConsult, 10).withWidth(130);
		
		link.addListener(SWT.Selection, new EventConsultUserLoan(busquedaB, link));
	
		btnConsult.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                    //Invocar a un metodo que te vacie la tabla completa
                 tabla.redraw();
                    
             String userName = txtUser.getText();
                    
             Collection<LoanUser> listLoanUser = ((AllManagementLoanUserViewController) controller).getManageLoanUser().findByLoanUserName(userName);
             for (LoanUser aux : listLoanUser) {
                   	
            	EntityLoanUser loanUser = new EntityLoanUser(aux.getLoanUser(),
           		 aux.getObservation(), aux.getLoanUserType(), aux.getLoanUserCode(), aux.getLoanUserState(), (Person)aux.getOwner());
           	     loanUser.setLoanUserID(aux.getLoanUserID());
           	     tabla.addRow(loanUser);
                 tabla.refresh();
                }
            }
    });

		
		lbCoincidenceList = new Label(parent, SWT.NONE);
		FormDatas.attach(lbCoincidenceList).atTopTo(btnConsult, 5).atLeftTo(parent, 15);
		
		//-----------------Tabla--------------------------------------

		tabla = new CRUDTreeTable(parent, SWT.NONE);
	    FormDatas.attach(tabla).atTopTo(lbCoincidenceList, 10).atLeft(0).atRight(0);
	    			
		tabla.setEntityClass(EntityLoanUser.class);	
		
		tabla.setUpdate(true, new EditorAreaUserLoan(controller));
		tabla.setWatch(true, new ViewAreaUserLoan(controller));
		tabla.setDelete(true);
			
		tabla.setCancelButtonText("Cancelar");     //For the internationalization. If it is non set, only the icon will show up.
					
		try {
			tabla.setColumnHeaders(Arrays.asList("Usuario", "Justificacion", "Tipo de Usuario", "Codigo de Usuario", "Estado"));
			tabla.createTable();
			initializeGrid(tabla);
			}
			catch(Exception e) {
				e.printStackTrace();
		}

		tabla.addDeleteListener(new TreeColumnListener(){			
			
			public void handleEvent(final TreeColumnEvent event) {
	     	event.performDelete = true;
	     	
	     	EntityLoanUser loanUser = (EntityLoanUser) event.entity;
	     	
	    	((AllManagementLoanUserViewController) controller).getManageLoanUser().deleteLoanUser(loanUser.getLoanUserID());
	    	
			}
		});
		
		tabla.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				//IGridViewEntity entity = (GridAssociateUserLoan) event.entity;
				//do something with the data
				//event.showEditableArea = false;
				tabla.refresh();
		   }
		});
		
		
		
		btnExportExcel = new Button(parent, SWT.PUSH);
		btnExportPDF = new Button(parent, SWT.PUSH);
		
		FormDatas.attach(btnExportPDF).atTopTo(tabla, 5).atRight(0).withWidth(110).withHeight(25);
		FormDatas.attach(btnExportExcel).atTopTo(tabla, 5).atRightTo(btnExportPDF, 10).withWidth(200).withHeight(25);
		
			
		l10n();
		return parent;
	}

	@Override
	public String getID() {
		return "ConsultarUsuarioPrestamoID";
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		lbSEARCH_CRITERIA.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		lbUser.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		lbUserCode.setText(AbosMessages.get().LABEL_USER);
		lbUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		lbState.setText(AbosMessages.get().LABEL_STATE);
		lbFirstName.setText(AbosMessages.get().LABEL_FIRST_NAME);
		lbSecondName.setText(AbosMessages.get().LABEL_SECOND_NAME);
		lbFirstLast.setText(AbosMessages.get().LABEL_FIRST_LAST);
		lbSecondLast.setText(AbosMessages.get().LABEL_SECOND_LAST);
		lbState1.setText(AbosMessages.get().LABEL_STATE);
		lbFrom.setText(AbosMessages.get().LABEL_FROM);
	    lbUp.setText(AbosMessages.get().LABEL_UP);
	    link.setText("<a>"+ MessageUtil.unescape(AbosMessages.get().LABEL_ADVANCED_SEARCH) +"</a>");
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnNewSearch.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		lbCoincidenceList.setText(AbosMessages.get().LABEL_COINCIDENCE_LIST);
		btnExportExcel.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		
	}

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;		
	}
	
	
	private void initializeGrid(CRUDTreeTable table) {
		
		Collection<LoanUser> listLoanUser = ((AllManagementLoanUserViewController) controller).getManageLoanUser().findAll();
		
		for (LoanUser aux : listLoanUser) {
			
			EntityLoanUser loanUser = new EntityLoanUser(aux.getLoanUser(),
					 aux.getObservation(), aux.getLoanUserType(), aux.getLoanUserCode(), aux.getLoanUserState(), (Person)aux.getOwner());
			loanUser.setLoanUserID(aux.getLoanUserID());
			table.addRow(loanUser);
		}
	}
	
      private void initializeCombo() {
        
		List<LoanUserType> listloanUserType = ((AllManagementLoanUserViewController) controller).getManageLoanUser().findAllLoanUserType();
		String [] comboStrings = new String[listloanUserType.size()];
		List<LoanUserType> type = new LinkedList<LoanUserType>();
		for (int i = 0; i < listloanUserType.size(); i++) {
			
			type.add(listloanUserType.get(i));
			comboStrings[i] = listloanUserType.get(i).getNomeclatorName();
			
		}
	   comboUserType.setItems(comboStrings);

	}
	
}
