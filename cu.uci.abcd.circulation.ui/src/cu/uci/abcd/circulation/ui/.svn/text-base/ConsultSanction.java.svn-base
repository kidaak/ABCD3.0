package cu.uci.abcd.circulation.ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
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
import cu.uci.abcd.circulation.ui.controller.PenaltyViewController;
import cu.uci.abcd.circulation.ui.listener.EventConsultSanction;
import cu.uci.abcd.circulation.ui.model.EditorAreaConsultSanction;
import cu.uci.abcd.circulation.ui.model.GridConsultSanction;
import cu.uci.abcd.circulation.ui.model.ViewAreaPenalty;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ConsultSanction implements IContributor{

	Label lbSearchCriteria;
	Label lbSanctionsType;
	Label lbState;
	Label lbUserType;
	Label lbUserCode;
	Label lbSearchCriteria1;
	Label lbDataSanction;
	Label lbRegistrationRange;
	Label lbSanctionsType1;
	Label lbState1;
	Label lbFrom;
	Label lbUp;
	Label lbUserDataAsiciatedLoan;
	Label lbUserType1;
	Label lbUserCode1;
	Label lbFirstName;
	Label lbSecondName;
	Label lbFirstLast;
	Label lbSecondLast;
	Button btnObjectRelatedLoan;
	Button btnObjectRelatedLoan1;
	Label lbObjectDateAsociatedLoan;
    Label lbTitle1;
    Label lbAuthor;
    Label lbControlNumber;
	Label lbCoincidenceList;
	Link link;
	Button btnConsult;
	Button btnNewSearch;
	Button btnExportExcel;
	Button btnExportPDF;
	
	Combo comboUserType;
	
	private IViewController controller;
	
	@Override
	public String contributorName() {
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_CONSULT_PENALTY);
	}

	@Override
	public String getID() {
		return "ConsultarSancionesID";
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		
		FormLayout form = new FormLayout();
		parent.setLayout(form);
		
		Composite agrupa = new Composite(parent, SWT.NORMAL);
		agrupa.setData(RWT.CUSTOM_VARIANT, "gray_background");
		agrupa.setVisible(true);
		agrupa.setLayout(new FormLayout());
		FormDatas.attach(agrupa).atTopTo(parent, 15).atLeft(0).atRight(0).withHeight(110);
		
		Composite busquedaB = new Composite(agrupa, SWT.NORMAL);
		busquedaB.setData(RWT.CUSTOM_VARIANT, "gray_background");
		busquedaB.setVisible(true);
		busquedaB.setLayout(new FormLayout());
		FormDatas.attach(busquedaB).atTopTo(agrupa, 5).atLeft(0).atRight(0).withHeight(110);
		
		lbSearchCriteria = new Label(busquedaB, SWT.NONE);
		lbSanctionsType = new Label(busquedaB, SWT.NONE);
		lbState = new Label(busquedaB, SWT.NONE);
		lbUserType = new Label(busquedaB, SWT.NONE);
		lbUserCode = new Label(busquedaB, SWT.NONE);
		  
    	FormDatas.attach(lbSearchCriteria).atTopTo(busquedaB, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbSanctionsType).atTopTo(lbSearchCriteria, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbState).atTopTo(lbSearchCriteria, 5).atLeftTo(lbSanctionsType, 90);
		FormDatas.attach(lbUserType).atTopTo(lbSearchCriteria, 5).atLeftTo(lbState, 140);
		FormDatas.attach(lbUserCode).atTopTo(lbSearchCriteria, 5).atLeftTo(lbUserType, 100);
		
		Combo comboSactionType = new Combo(busquedaB, SWT.NONE);
		comboSactionType.setItems(new String[] { "Multa", "Suspencion"});
		Combo comboState = new Combo(busquedaB, SWT.NONE);
		comboState.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		comboUserType = new Combo(busquedaB, SWT.NONE);
		Text txtUserCode = new Text(busquedaB, SWT.NORMAL);		
		
		initializeCombo();
		
		FormDatas.attach(comboSactionType).atTopTo(lbSanctionsType, 5).atLeftTo(parent, 15).withWidth(150).withHeight(23);
		FormDatas.attach(comboState).atTopTo(lbState, 5).atLeftTo(comboSactionType, 30).withWidth(150).withHeight(23);
		FormDatas.attach(comboUserType).atTopTo(lbUserType, 5).atLeftTo(comboState, 30).withWidth(150).withHeight(23);
		FormDatas.attach(txtUserCode).atTopTo(lbUserCode, 5).atLeftTo(comboUserType, 30).withWidth(130).withHeight(10);
		
		btnObjectRelatedLoan = new Button(busquedaB, SWT.CHECK);
		FormDatas.attach(btnObjectRelatedLoan).atTopTo(comboSactionType, 5).atLeftTo(parent, 15);
		
	//----------------Busqueda Avanzada-------------------------------------------------------
		
		Composite busquedaA = new Composite(agrupa, SWT.NORMAL);
		busquedaA.setData(RWT.CUSTOM_VARIANT, "gray_background");
		busquedaA.setVisible(false);
		
		busquedaA.setLayout(new FormLayout());
		FormDatas.attach(busquedaA).atTopTo(agrupa, 5).atLeft(0).atRight(0).withHeight(320);
		
		lbSearchCriteria1 = new Label(busquedaA, SWT.NONE);
		lbDataSanction = new Label(busquedaA, SWT.NONE);
		lbRegistrationRange = new Label(busquedaA, SWT.NONE);
		lbSanctionsType1 = new Label(busquedaA, SWT.NONE);
		lbState1 = new Label(busquedaA, SWT.NONE);
		lbFrom= new Label(busquedaA, SWT.NONE);
		lbUp = new Label(busquedaA, SWT.NONE);
		  
		FormDatas.attach(lbSearchCriteria1).atTopTo(busquedaA, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbDataSanction).atTopTo(lbSearchCriteria1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbRegistrationRange).atTopTo(lbSearchCriteria1, 5).atLeftTo(lbDataSanction, 250);
		FormDatas.attach(lbSanctionsType1).atTopTo(lbDataSanction, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbState1).atTopTo(lbDataSanction, 5).atLeftTo(lbSanctionsType1, 100);
		FormDatas.attach(lbFrom).atTopTo(lbDataSanction, 5).atLeftTo(lbState1, 135);
		FormDatas.attach(lbUp).atTopTo(lbDataSanction, 5).atLeftTo(lbFrom, 125);
		
		Combo comboSactionType1 = new Combo(busquedaA, SWT.NONE);
		comboSactionType1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		Combo comboState1 = new Combo(busquedaA, SWT.NONE);
		comboState1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		DateTime dateTime = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
		DateTime dateTime1 = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
		
		FormDatas.attach(comboSactionType1).atTopTo(lbSanctionsType1, 5).atLeftTo(parent, 15).withWidth(150).withHeight(23);
		FormDatas.attach(comboState1).atTopTo(lbState1, 5).atLeftTo(comboSactionType1, 30).withWidth(150).withHeight(23);
		FormDatas.attach(dateTime).atTopTo(lbFrom, 5).atLeftTo(comboState1, 30);
		FormDatas.attach(dateTime1).atTopTo(lbUp, 5).atLeftTo(dateTime, 30);  
				
		lbUserDataAsiciatedLoan = new Label(busquedaA, SWT.NONE);
		lbUserType1 = new Label(busquedaA, SWT.NONE);
		lbUserCode1 = new Label(busquedaA, SWT.NONE);
			
		FormDatas.attach(lbUserDataAsiciatedLoan).atTopTo(comboSactionType1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserType1).atTopTo(lbUserDataAsiciatedLoan, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode1).atTopTo(lbUserDataAsiciatedLoan, 5).atLeftTo(lbUserType1, 90);
		
		lbFirstName = new Label(busquedaA, SWT.NONE);
		lbSecondName = new Label(busquedaA, SWT.NONE);
		lbFirstLast = new Label(busquedaA, SWT.NONE);
		lbSecondLast = new Label(busquedaA, SWT.NONE);
		
		Combo comboSactionType3 = new Combo(busquedaA, SWT.NONE);
		comboSactionType3.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		Text txtUserCode1 = new Text(busquedaA, SWT.NORMAL);
		
		FormDatas.attach(comboSactionType3).atTopTo(lbUserType1, 5).atLeftTo(parent, 15).withWidth(150).withHeight(23);
		FormDatas.attach(txtUserCode1).atTopTo(lbUserCode1, 5).atLeftTo(comboSactionType3, 30).withWidth(130).withHeight(10);
		
		FormDatas.attach(lbFirstName).atTopTo(comboSactionType3, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbSecondName).atTopTo(txtUserCode1, 5).atLeftTo(lbFirstName, 100);
		FormDatas.attach(lbFirstLast).atTopTo(txtUserCode1, 5).atLeftTo(lbSecondName, 90);
		FormDatas.attach(lbSecondLast).atTopTo(txtUserCode1, 5).atLeftTo(lbFirstLast, 90);  
		
		Text txtFirstName = new Text(busquedaA, SWT.NORMAL);
		Text txtSecondName = new Text(busquedaA, SWT.NORMAL);
		Text txtFirstLast = new Text(busquedaA, SWT.NORMAL);
		Text txtSecondLast = new Text(busquedaA, SWT.NORMAL);
		
		FormDatas.attach(txtFirstName).atTopTo(lbFirstName, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtSecondName).atTopTo(lbSecondName, 5).atLeftTo(txtFirstName, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtFirstLast).atTopTo(lbFirstLast, 5).atLeftTo(txtSecondName, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtSecondLast).atTopTo(lbSecondLast, 5).atLeftTo(txtFirstLast, 30).withWidth(130).withHeight(10);
		
        lbObjectDateAsociatedLoan = new Label(busquedaA, SWT.NONE);
        btnObjectRelatedLoan1 = new Button(busquedaA, SWT.CHECK);
        lbTitle1 = new Label(busquedaA, SWT.NONE);
        lbAuthor = new Label(busquedaA, SWT.NONE);
        lbControlNumber = new Label(busquedaA, SWT.NONE);
	
		FormDatas.attach(lbObjectDateAsociatedLoan).atTopTo(txtFirstName, 5).atLeftTo(parent, 15);
		FormDatas.attach(btnObjectRelatedLoan1).atTopTo(lbObjectDateAsociatedLoan, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbTitle1).atTopTo(btnObjectRelatedLoan1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbAuthor).atTopTo(btnObjectRelatedLoan1, 5).atLeftTo(lbTitle1, 155);
		FormDatas.attach(lbControlNumber).atTopTo(btnObjectRelatedLoan1, 5).atLeftTo(lbAuthor, 150);  
		
		Text txtTitle1 = new Text(busquedaA, SWT.NORMAL);
		Text txtAuthor = new Text(busquedaA, SWT.NORMAL);
		Text txtControlNumber = new Text(busquedaA, SWT.NORMAL);
		
		FormDatas.attach(txtTitle1).atTopTo(lbTitle1, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtAuthor).atTopTo(lbAuthor, 5).atLeftTo(txtTitle1, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtControlNumber).atTopTo(lbControlNumber, 5).atLeftTo(txtAuthor, 30).withWidth(130).withHeight(10);
			
		//--------------------------------------------------------------
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(agrupa, 15).atRight(0).atLeft(0);
		
		link = new Link(parent, SWT.NONE);
		btnConsult = new Button(parent, SWT.PUSH);
		btnNewSearch = new Button(parent, SWT.PUSH);
						
		link.addListener(SWT.Selection, new EventConsultSanction(agrupa,busquedaB,busquedaA, link));
		
		FormDatas.attach(btnNewSearch).atTopTo(separador, 5).atRight(0).withWidth(120).withHeight(23);
		FormDatas.attach(btnConsult).atTopTo(separador, 5).atRightTo(btnNewSearch, 10).withWidth(100).withHeight(23);
		FormDatas.attach(link).atTopTo(separador, 5).atRightTo(btnConsult, 10).withWidth(130);
		
		lbCoincidenceList = new Label(parent, SWT.NONE);
		FormDatas.attach(lbCoincidenceList).atTopTo(btnConsult, 5);
		
		//-----------------Tabla--------------------------------------
				
		final CRUDTreeTable tabla = new CRUDTreeTable(parent, SWT.NONE);
	    FormDatas.attach(tabla).atTopTo(lbCoincidenceList, 10).atLeft(0).atRight(0);
	    			
		tabla.setEntityClass(GridConsultSanction.class);	
		
		tabla.setUpdate(true, new EditorAreaConsultSanction(controller));
		tabla.setWatch(true, new ViewAreaPenalty(controller));
		tabla.setDelete(true);
				
		tabla.setCancelButtonText("Cancelar");     //For the internationalization. If it is non set, only the icon will show up.
					
		try {
			tabla.setColumnHeaders(Arrays.asList("Tipo de Sancion", "Fecha de Inicio","Fecha de Fin", "Observaciones","Estado"));
			tabla.createTable();
			initializeGrid(tabla);
			}
			catch(Exception e) {
				e.printStackTrace();
		}
          
		tabla.addDeleteListener(new TreeColumnListener(){			
			
			public void handleEvent(final TreeColumnEvent event) {
	     	event.performDelete = true;
	     	
	     	GridConsultSanction penalty = (GridConsultSanction) event.entity;
	     	
	    	((AllManagementLoanUserViewController) controller).getManagePenalty().deletePenalty(penalty.getPenaltyID());
	    	
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
       		
		//----------------------------------------------------------------------
    	    
	    btnExportExcel = new Button(parent, SWT.PUSH);
		btnExportPDF = new Button(parent, SWT.PUSH);
		
		FormDatas.attach(btnExportPDF).atTopTo(tabla, 5).atRight(0).withWidth(110).withHeight(25);
		FormDatas.attach(btnExportExcel).atTopTo(tabla, 5).atRightTo(btnExportPDF, 10).withWidth(200).withHeight(25);
		l10n();
		return parent;
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		lbSearchCriteria.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		lbSanctionsType.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_SANCTION));
		lbState.setText(AbosMessages.get().LABEL_STATE);
		lbUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		lbSearchCriteria1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		lbDataSanction.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_SANCTION));
		lbRegistrationRange.setText(AbosMessages.get().LABEL_DATE_OF_REGISTRATION_RANGE);
		lbSanctionsType1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_SANCTION));
		lbState1.setText(AbosMessages.get().LABEL_STATE);
		lbFrom.setText(AbosMessages.get().LABEL_FROM);
		lbUp.setText(AbosMessages.get().LABEL_UP);
		lbUserDataAsiciatedLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_DATE_ASOCCIATED_LOAN));
		lbUserType1.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		lbUserCode1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		lbFirstName.setText(AbosMessages.get().LABEL_FIRST_NAME);
		lbSecondName.setText(AbosMessages.get().LABEL_SECOND_NAME);
		lbFirstLast.setText(AbosMessages.get().LABEL_FIRST_LAST);
		lbSecondLast.setText(AbosMessages.get().LABEL_SECOND_LAST);
		btnObjectRelatedLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_RELATED_LOAN));
		lbObjectDateAsociatedLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_DATE_ASOCCIATED_LOAN));
     	btnObjectRelatedLoan1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_RELATED_LOAN));
		lbTitle1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		lbAuthor.setText(AbosMessages.get().LABEL_AUTHOR);
		lbControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
		link.setText("<a>"+ MessageUtil.unescape(AbosMessages.get().LABEL_ADVANCED_SEARCH) +"</a>");
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnNewSearch.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		btnExportExcel.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
	}
	

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
	}
	
     private void initializeGrid(CRUDTreeTable table) {
		
		Collection<Penalty> listPenalty = ((AllManagementLoanUserViewController) controller).getManagePenalty().findAllPenalty();
		
		for (Penalty aux : listPenalty) {
			
			GridConsultSanction penalty = new GridConsultSanction(aux.getPenaltyType(),
					 aux.getEffectiveDate(), aux.getExpirationDate(), aux.getReason(), aux.getPenaltyState(), aux.getLoanUser());
			penalty.setPenaltyID(aux.getPenaltyID());
			table.addRow(penalty);
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
