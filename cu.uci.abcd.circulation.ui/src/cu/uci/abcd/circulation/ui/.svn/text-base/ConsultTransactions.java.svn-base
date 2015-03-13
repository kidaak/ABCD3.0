package cu.uci.abcd.circulation.ui;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.listener.EventConsultTransactions;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ConsultTransactions implements IContributor
{
	Label lbSEARCH_CRITERIA;
	Label lbObjectLoanData;
	Label lbControlNumber;
	Label lbTitle;
	Label lbObjectType;
	Label lbUserLoanData;
	Label lbUserCode;
	Label lbUser;
	Label lbUserType;
	Label lbDateTransactions;
	Label lbLoanType;
	Label lbState;
	
	Label lbSEARCH_CRITERIA1;
	Label lbObjectLoanData1;
	Label lbControlNumber1;
	Label lbTitle1;
	Label lbObjectType1;
	Label lbTitle2;
	Label lbUserLoanData1;
	Label lbUserCode1;
	Label lbUser1;
	Label lbUserType1;
	Label lbFirstName;
	Label lbSecondName;
	Label lbFirstLast;
	Label lbSecondLast;
	Label lbDateTransactions1;
	Label lbLoanType1;
	Label lbState1;
	Label lbFrom;
	Label lbUp;
	Label lbDate;
	Label lbCoincidenceList;
	Link link;
	Button btnConsult;
	Button btnNewSearch;
	Button btnExportExcel;
	Button btnExportPDF;
	
	@Override
	public String contributorName() {
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_CONSULT_TRANSACTION);
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
	
		parent.setLayout(new FormLayout());
	
    	Composite agrupa = new Composite(parent, SWT.NORMAL);
		agrupa.setData(RWT.CUSTOM_VARIANT, "gray_background");
		agrupa.setVisible(true);
		agrupa.setLayout(new FormLayout());
		FormDatas.attach(agrupa).atTopTo(parent, 5).atLeft(0).atRight(0).withHeight(270);
		
		Composite busquedaB = new Composite(agrupa, SWT.NORMAL);
		busquedaB.setData(RWT.CUSTOM_VARIANT, "gray_background");
		busquedaB.setVisible(true);
		busquedaB.setLayout(new FormLayout());
		FormDatas.attach(busquedaB).atTopTo(agrupa, 5).atLeft(0).atRight(0).withHeight(270);
		
		lbSEARCH_CRITERIA = new Label(busquedaB, SWT.NONE);
		lbObjectLoanData = new Label(busquedaB, SWT.NONE);
		lbControlNumber = new Label(busquedaB, SWT.NONE);
		lbTitle = new Label(busquedaB, SWT.NONE);
		lbObjectType = new Label(busquedaB, SWT.NONE);
		  
		FormDatas.attach(lbSEARCH_CRITERIA).atTopTo(busquedaB, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbObjectLoanData).atTopTo(lbSEARCH_CRITERIA, 15).atLeftTo(parent, 15);
		FormDatas.attach(lbControlNumber).atTopTo(lbObjectLoanData, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbTitle).atTopTo(lbObjectLoanData, 5).atLeftTo(lbControlNumber, 110);
		FormDatas.attach(lbObjectType).atTopTo(lbObjectLoanData, 5).atLeftTo(lbTitle, 140);
		
		Text txtControlNumber = new Text(busquedaB, SWT.NORMAL);
		Text txtTitle = new Text(busquedaB, SWT.NORMAL);
		Combo comboObjectType = new Combo(busquedaB, SWT.NONE);
		comboObjectType.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
	    
		FormDatas.attach(txtControlNumber).atTopTo(lbControlNumber, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtTitle).atTopTo(lbTitle, 5).atLeftTo(txtControlNumber, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboObjectType).atTopTo(lbObjectType, 5).atLeftTo(txtTitle, 30).withWidth(150).withHeight(23);
	
		lbUserLoanData = new Label(busquedaB, SWT.NONE);
		lbUserCode = new Label(busquedaB, SWT.NONE);
		lbUser = new Label(busquedaB, SWT.NONE);
		lbUserType = new Label(busquedaB, SWT.NONE);
		  
		FormDatas.attach(lbUserLoanData).atTopTo(txtControlNumber, 15).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode).atTopTo(lbUserLoanData, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUser).atTopTo(lbUserLoanData, 5).atLeftTo(lbUserCode, 100);
		FormDatas.attach(lbUserType).atTopTo(lbUserLoanData, 5).atLeftTo(lbUserCode, 137);
		
		Text txtUserCode = new Text(busquedaB, SWT.NORMAL);
		Text txtUser = new Text(busquedaB, SWT.NORMAL);
		Combo comboUserType = new Combo(busquedaB, SWT.NONE);
		comboUserType.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
	    
		FormDatas.attach(txtUserCode).atTopTo(lbUser, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtUser).atTopTo(lbUserCode, 5).atLeftTo(txtUserCode, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboUserType).atTopTo(lbUserType, 5).atLeftTo(txtUser, 30).withWidth(150).withHeight(23);
		
		lbDateTransactions = new Label(busquedaB, SWT.NONE);
		lbLoanType = new Label(busquedaB, SWT.NONE);
		lbState = new Label(busquedaB, SWT.NONE);
		  
		FormDatas.attach(lbDateTransactions).atTopTo(txtUserCode, 15).atLeftTo(parent, 15);
		FormDatas.attach(lbLoanType).atTopTo(lbDateTransactions, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbState).atTopTo(lbDateTransactions, 5).atLeftTo(lbLoanType, 90);
		
		Combo comboLoanType = new Combo(busquedaB, SWT.NONE);
		comboLoanType.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		Combo comboState = new Combo(busquedaB, SWT.NONE);
		comboState.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		
		FormDatas.attach(comboLoanType).atTopTo(lbLoanType, 5).atLeftTo(parent, 15).withWidth(150).withHeight(23);
		FormDatas.attach(comboState).atTopTo(lbState, 5).atLeftTo(comboLoanType, 30).withWidth(150).withHeight(23);
		
	//----------------Busqueda Avanzada-------------------------------------------------------
		
		Composite busquedaA = new Composite(agrupa, SWT.NORMAL);
		busquedaA.setData(RWT.CUSTOM_VARIANT, "gray_background");
		busquedaA.setVisible(false);
		busquedaA.setLayout(new FormLayout());
		FormDatas.attach(busquedaA).atTopTo(agrupa, 5).atLeft(0).atRight(0).withHeight(350);
		
		lbSEARCH_CRITERIA1 = new Label(busquedaA, SWT.NONE);
		lbObjectLoanData1 = new Label(busquedaA, SWT.NONE);
		lbControlNumber1 = new Label(busquedaA, SWT.NONE);
		lbTitle1 = new Label(busquedaA, SWT.NONE);
		lbObjectType1 = new Label(busquedaA, SWT.NONE);
		lbTitle2 = new Label(busquedaA, SWT.NONE);
		  
		FormDatas.attach(lbSEARCH_CRITERIA1).atTopTo(busquedaA, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbObjectLoanData1).atTopTo(lbSEARCH_CRITERIA1, 15).atLeftTo(parent, 15);
		FormDatas.attach(lbControlNumber1).atTopTo(lbObjectLoanData1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbTitle1).atTopTo(lbObjectLoanData1, 5).atLeftTo(lbControlNumber1, 110);
		FormDatas.attach(lbObjectType1).atTopTo(lbObjectLoanData1, 5).atLeftTo(lbTitle1, 140);
		FormDatas.attach(lbTitle2).atTopTo(lbObjectLoanData1, 5).atLeftTo(lbObjectType1, 110);
		
		Text txtControlNumber1 = new Text(busquedaA, SWT.NORMAL);
		Text txtTitle1 = new Text(busquedaA, SWT.NORMAL);
		Combo comboObjectType1 = new Combo(busquedaA, SWT.NONE);
		comboObjectType1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		Text txtTitle2 = new Text(busquedaA, SWT.NORMAL);
		
		FormDatas.attach(txtControlNumber1).atTopTo(lbControlNumber1, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtTitle1).atTopTo(lbTitle1, 5).atLeftTo(txtControlNumber1, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboObjectType1).atTopTo(lbObjectType1, 5).atLeftTo(txtTitle1, 30).withWidth(150).withHeight(23);
		FormDatas.attach(txtTitle2).atTopTo(lbTitle2, 5).atLeftTo(comboObjectType1, 30).withWidth(130).withHeight(10);
		
		lbUserLoanData1 = new Label(busquedaA, SWT.NONE);
		lbUserCode1 = new Label(busquedaA, SWT.NONE);
		lbUser1 = new Label(busquedaA, SWT.NONE);
		lbUserType1 = new Label(busquedaA, SWT.NONE);
		  
		FormDatas.attach(lbUserLoanData1).atTopTo(txtControlNumber1, 15).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode1).atTopTo(lbUserLoanData1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUser1).atTopTo(lbUserLoanData1, 5).atLeftTo(lbUserCode1, 80);
		FormDatas.attach(lbUserType1).atTopTo(lbUserLoanData1, 5).atLeftTo(lbUser1, 137);
		
		Text txtUserCode1 = new Text(busquedaA, SWT.NORMAL);
		Text txtUser1 = new Text(busquedaA, SWT.NORMAL);
		Combo comboUserType1 = new Combo(busquedaA, SWT.NONE);
		comboUserType1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
	    
		FormDatas.attach(txtUserCode1).atTopTo(lbUserCode1, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtUser1).atTopTo(lbUser1, 5).atLeftTo(txtUserCode1, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboUserType1).atTopTo(lbUserType1, 5).atLeftTo(txtUser1, 30).withWidth(150).withHeight(23);
		
		lbFirstName = new Label(busquedaA, SWT.NONE);
		lbSecondName = new Label(busquedaA, SWT.NONE);
		lbFirstLast = new Label(busquedaA, SWT.NONE);
		lbSecondLast = new Label(busquedaA, SWT.NONE);
		
		FormDatas.attach(lbFirstName).atTopTo(txtUserCode1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbSecondName).atTopTo(txtUser1, 5).atLeftTo(lbFirstName, 100);
		FormDatas.attach(lbFirstLast).atTopTo(comboUserType1, 5).atLeftTo(lbSecondName, 90);
		FormDatas.attach(lbSecondLast).atTopTo(comboUserType1, 5).atLeftTo(lbFirstLast, 90);  
		
		Text txtFirstName = new Text(busquedaA, SWT.NORMAL);
		Text txtSecondName = new Text(busquedaA, SWT.NORMAL);
		Text txtFirstLast = new Text(busquedaA, SWT.NORMAL);
		Text txtSecondLast = new Text(busquedaA, SWT.NORMAL);
		
		FormDatas.attach(txtFirstName).atTopTo(lbFirstName, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtSecondName).atTopTo(lbSecondName, 5).atLeftTo(txtFirstName, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtFirstLast).atTopTo(lbFirstLast, 5).atLeftTo(txtSecondName, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtSecondLast).atTopTo(lbSecondLast, 5).atLeftTo(txtFirstLast, 30).withWidth(130).withHeight(10);
		
		lbDate = new Label(busquedaA, SWT.NONE);
		lbFrom = new Label(busquedaA, SWT.NONE);
		lbUp = new Label(busquedaA, SWT.NONE);
		lbDateTransactions1 = new Label(busquedaA, SWT.NONE);
		lbLoanType1 = new Label(busquedaA, SWT.NONE);
		lbState1 = new Label(busquedaA, SWT.NONE);
		  
		FormDatas.attach(lbDateTransactions1).atTopTo(txtFirstName, 15).atLeftTo(parent, 15);
		FormDatas.attach(lbDate).atTopTo(txtFirstLast, 15).atLeftTo(lbDateTransactions1,50);
		FormDatas.attach(lbLoanType1).atTopTo(lbDateTransactions1, 5).atLeftTo(parent,15);
		FormDatas.attach(lbState1).atTopTo(lbDateTransactions1, 5).atLeftTo(lbLoanType1, 90);
		FormDatas.attach(lbFrom).atTopTo(lbDateTransactions1, 5).atLeftTo(lbState1, 140);
		FormDatas.attach(lbUp).atTopTo(lbDateTransactions1, 5).atLeftTo(lbFrom, 120);
		
		Combo comboLoanType1 = new Combo(busquedaA, SWT.NONE);
		comboLoanType1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		Combo comboState1 = new Combo(busquedaA, SWT.NONE);
		comboState1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		DateTime dateTime = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
		DateTime dateTime1 = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
		
		FormDatas.attach(comboLoanType1).atTopTo(lbLoanType1, 5).atLeftTo(parent, 15).withWidth(150).withHeight(23);
		FormDatas.attach(comboState1).atTopTo(lbState1, 5).atLeftTo(comboLoanType1, 30).withWidth(150).withHeight(23);
		FormDatas.attach(dateTime).atTopTo(lbFrom, 5).atLeftTo(comboState1, 30);
		FormDatas.attach(dateTime1).atTopTo(lbUp, 5).atLeftTo(dateTime, 30);  
			
	//--------------------------------------------------------------
		
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(agrupa, 5).atLeft(0).atRight(0);
		
		link = new Link(parent, SWT.NONE);
		btnConsult = new Button(parent, SWT.PUSH);
		btnNewSearch = new Button(parent, SWT.PUSH);

		link.setText("<a>"+ MessageUtil.unescape(AbosMessages.get().LABEL_ADVANCED_SEARCH) +"</a>");
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnNewSearch.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		
		link.addListener(SWT.Selection, new EventConsultTransactions(agrupa,busquedaB,busquedaA, link));
		
		FormDatas.attach(btnNewSearch).atTopTo(separador, 5).atRight(0).withWidth(120).withHeight(23);
		FormDatas.attach(btnConsult).atTopTo(separador, 5).atRightTo(btnNewSearch, 10).withWidth(100).withHeight(23);
		FormDatas.attach(link).atTopTo(separador, 5).atRightTo(btnConsult, 10).withWidth(130);
		
		lbCoincidenceList = new Label(parent, SWT.NONE);
		FormDatas.attach(lbCoincidenceList).atTopTo(btnConsult, 5);
		

		//-----------------Tabla--------------------------------------
		
		Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(true);
		tabla.setLinesVisible(true);
		
		TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		tableItem_1.setText("column 1");

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(100);
		columna1.setText("Título");
		
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(150);
		columna2.setText("No. de Control");
		
		TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		columna3.setWidth(100);
		columna3.setText("Tipo de Objeto");
		
		TableColumn columna4 = new TableColumn(tabla, SWT.NONE);
		columna4.setWidth(150);
		columna4.setText("Tipo de Prestamo");

		TableColumn columna5 = new TableColumn(tabla, SWT.NONE);
		columna5.setWidth(100);
		columna5.setText("Estado");
		
		TableColumn columna6 = new TableColumn(tabla, SWT.NONE);
		columna6.setWidth(100);
		columna6.setText("Usuario");
		
		TableColumn columna7 = new TableColumn(tabla, SWT.NONE);
		columna7.setWidth(100);
		columna7.setText("Codigo");
		
		TableColumn columna8 = new TableColumn(tabla, SWT.NONE);
		columna8.setWidth(100);
		columna8.setText("Tipo de Usuario");
		
		TableColumn columna9 = new TableColumn(tabla, SWT.NONE);
		columna9.setWidth(100);
		columna9.setText("Acciones");
		
		FormDatas.attach(tabla).atTopTo(lbCoincidenceList, 5).withWidth(700).withHeight(70);
		//----------------------------------------------------------------------
	    
		btnExportExcel = new Button(parent, SWT.PUSH);
		btnExportPDF = new Button(parent, SWT.PUSH);
		
		FormDatas.attach(btnExportPDF).atTopTo(tabla, 5).atRight(0).withWidth(110).withHeight(25);
		FormDatas.attach(btnExportExcel).atTopTo(tabla, 5).atRightTo(btnExportPDF, 10).withWidth(200).withHeight(25);
		l10n();

		return parent;
	}

	@Override
	public String getID() {
		return "ConsultarTransaccionesID";
	}
	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void l10n() {
		lbSEARCH_CRITERIA.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		lbObjectLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
		lbControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
		lbTitle.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		lbObjectType.setText(AbosMessages.get().LABEL_OBJECT_TYPE);
		lbUserLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		lbUser.setText(AbosMessages.get().LABEL_USER);
		lbUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		lbDateTransactions.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATE_OF_TRANSACTION));
		lbLoanType.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_LOAN));
		lbState.setText(AbosMessages.get().LABEL_STATE);
		lbSEARCH_CRITERIA1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		lbObjectLoanData1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
		lbControlNumber1.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
		lbTitle1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		lbObjectType1.setText(AbosMessages.get().LABEL_OBJECT_TYPE);
		lbTitle2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		lbFirstName.setText(AbosMessages.get().LABEL_FIRST_NAME);
		lbSecondName.setText(AbosMessages.get().LABEL_SECOND_NAME);
		lbFirstLast.setText(AbosMessages.get().LABEL_FIRST_LAST);
		lbSecondLast.setText(AbosMessages.get().LABEL_SECOND_LAST);
		lbDate.setText(AbosMessages.get().LABEL_DATE_OF_REGISTRATION_RANGE);
		lbDateTransactions1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATE_OF_TRANSACTION));
		lbLoanType1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_LOAN));
		lbState1.setText(AbosMessages.get().LABEL_STATE);
		lbFrom.setText(AbosMessages.get().LABEL_FROM);
	    lbUp.setText(AbosMessages.get().LABEL_UP);
	    link.setText("<a>"+ MessageUtil.unescape(AbosMessages.get().LABEL_ADVANCED_SEARCH) +"</a>");
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnNewSearch.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		lbCoincidenceList.setText(AbosMessages.get().LABEL_COINCIDENCE_LIST);
		btnExportExcel.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		lbUserLoanData1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		lbUserCode1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		lbUser1.setText(AbosMessages.get().LABEL_USER);
		lbUserType1.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
	}
	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}

}
