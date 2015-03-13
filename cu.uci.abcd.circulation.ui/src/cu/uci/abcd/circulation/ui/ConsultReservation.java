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

import cu.uci.abcd.circulation.ui.listener.EventConsultReservation;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ConsultReservation implements IContributor{

	Label lbSEARCH_CRITERIA;
	Label lbUser;
	Label lbUserCode;
	Label lbUserType;
	Label lbReservationStatus;
	Label lbTitle;
	Label lbControlNumber;
	Label lbObjectType;
	
	Label lbSearchCriteria1;
	Label lbUserLoanData1;
	Label lbUser1;
	Label lbUserCode1;
	Label lbUserType1;
	Label lbFirstName;
	Label lbSecondName;
	Label lbFirstLast;
	Label lbSecondLast;
    Label lbObjectLoanData;
    Label lbTitle1;
    Label lbAuthor1;
    Label lbControlNumber1;
    Label lbObjectType1;
    Label lbDateReservation;
	Label lbDateRegistrationRange;
	Label lbReservationStatus1;
	Label lbFrom;
	Label lbUp;
	Label lbCoincidenceList;
	Link link;
	Button btnConsult;
	Button btnNewSearch;
	Button btnExportExcel;
	Button btnExportPDF;
	@Override
	public String contributorName() {
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_CONSULT_RESERVATION);
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
		FormDatas.attach(agrupa).atTopTo(parent, 5).atLeft(0).atRight(0).withHeight(130);
		
		Composite busquedaB = new Composite(agrupa, SWT.NORMAL);
		busquedaB.setData(RWT.CUSTOM_VARIANT, "gray_background");
		busquedaB.setVisible(true);
		busquedaB.setLayout(new FormLayout());
		FormDatas.attach(busquedaB).atTopTo(agrupa, 5).atLeft(0).atRight(0).withWidth(710).withHeight(130);
		
		lbSEARCH_CRITERIA = new Label(busquedaB, SWT.NONE);
		lbUser = new Label(busquedaB, SWT.NONE);
		lbUserCode = new Label(busquedaB, SWT.NONE);
		lbUserType = new Label(busquedaB, SWT.NONE);
		lbReservationStatus = new Label(busquedaB, SWT.NONE);
		  
		FormDatas.attach(lbSEARCH_CRITERIA).atTopTo(busquedaB, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUser).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(lbUser, 135);
		FormDatas.attach(lbUserType).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(lbUserCode, 90);
		FormDatas.attach(lbReservationStatus).atTopTo(lbSEARCH_CRITERIA, 5).atLeftTo(lbUserType, 90);
		
		Text txtUser = new Text(busquedaB, SWT.NORMAL);
		Text txtUserCode = new Text(busquedaB, SWT.NORMAL);
		Combo comboUserType = new Combo(busquedaB, SWT.NONE);
		comboUserType.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		Combo comboReservationStatus = new Combo(busquedaB, SWT.NONE);
		comboReservationStatus.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		
		FormDatas.attach(txtUser).atTopTo(lbUser, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtUserCode).atTopTo(lbUserCode, 5).atLeftTo(txtUser, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboUserType).atTopTo(lbUserType, 5).atLeftTo(txtUserCode, 30).withWidth(150).withHeight(23);
		FormDatas.attach(comboReservationStatus).atTopTo(lbReservationStatus, 5).atLeftTo(comboUserType, 30).withWidth(150).withHeight(23);
		
		lbTitle = new Label(busquedaB, SWT.NONE);
		lbControlNumber = new Label(busquedaB, SWT.NONE);
		lbObjectType = new Label(busquedaB, SWT.NONE);
		
		FormDatas.attach(lbTitle).atTopTo(txtUser, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbControlNumber).atTopTo(txtUserCode, 5).atLeftTo(lbTitle, 155);
		FormDatas.attach(lbObjectType).atTopTo(comboUserType, 5).atLeftTo(lbControlNumber, 100);
		
		Text txtTitle = new Text(busquedaB, SWT.NORMAL);
		Text txtControlNumber = new Text(busquedaB, SWT.NORMAL);
		Combo comboObjectType = new Combo(busquedaB, SWT.NONE);
		comboObjectType.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		
		FormDatas.attach(txtTitle).atTopTo(lbControlNumber, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtControlNumber).atTopTo(lbObjectType, 5).atLeftTo(txtTitle, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboObjectType).atTopTo(lbObjectType, 5).atLeftTo(txtControlNumber, 30).withWidth(150).withHeight(23);
		
		//----------------Busqueda Avanzada-------------------------------------------------------
		
		Composite busquedaA = new Composite(agrupa, SWT.NORMAL);
		busquedaA.setData(RWT.CUSTOM_VARIANT, "gray_background");
		busquedaA.setVisible(false);
		
		busquedaA.setLayout(new FormLayout());
		FormDatas.attach(busquedaA).atTopTo(agrupa, 5).atLeft(0).atRight(0).withHeight(300);
		
		lbSearchCriteria1 = new Label(busquedaA, SWT.NONE);
		lbUserLoanData1 = new Label(busquedaA, SWT.NONE);
		lbUser1 = new Label(busquedaA, SWT.NONE);
		lbUserCode1 = new Label(busquedaA, SWT.NONE);
		lbUserType1 = new Label(busquedaA, SWT.NONE);
		  
		FormDatas.attach(lbSearchCriteria1).atTopTo(busquedaA, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserLoanData1).atTopTo(lbSearchCriteria1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUser1).atTopTo(lbUserLoanData1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode1).atTopTo(lbUserLoanData1, 5).atLeftTo(lbUser1, 140);
		FormDatas.attach(lbUserType1).atTopTo(lbUserLoanData1, 5).atLeftTo(lbUserCode1, 80);
		
		Text txtUser1 = new Text(busquedaA, SWT.NORMAL);
		Text txtUserCode1 = new Text(busquedaA, SWT.NORMAL);
		Combo comboUserType1 = new Combo(busquedaA, SWT.NONE);
		comboUserType1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
			
		FormDatas.attach(txtUser1).atTopTo(lbUser1, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtUserCode1).atTopTo(lbUserCode1, 5).atLeftTo(txtUser1, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboUserType1).atTopTo(lbUserType1, 5).atLeftTo(txtUserCode1, 30).withWidth(150).withHeight(23);
		
		lbFirstName = new Label(busquedaA, SWT.NONE);
		lbSecondName = new Label(busquedaA, SWT.NONE);
		lbFirstLast = new Label(busquedaA, SWT.NONE);
		lbSecondLast = new Label(busquedaA, SWT.NONE);
		
		FormDatas.attach(lbFirstName).atTopTo(txtUser1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbSecondName).atTopTo(txtUserCode1, 5).atLeftTo(lbFirstName, 100);
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
		
        lbObjectLoanData = new Label(busquedaA, SWT.NONE);
        lbTitle1 = new Label(busquedaA, SWT.NONE);
        lbAuthor1 = new Label(busquedaA, SWT.NONE);
        lbControlNumber1 = new Label(busquedaA, SWT.NONE);
        lbObjectType1 = new Label(busquedaA, SWT.NONE);
		
		FormDatas.attach(lbObjectLoanData).atTopTo(txtFirstName, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbTitle1).atTopTo(lbObjectLoanData, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbAuthor1).atTopTo(lbObjectLoanData, 5).atLeftTo(lbTitle1, 155);
		FormDatas.attach(lbControlNumber1).atTopTo(lbObjectLoanData, 5).atLeftTo(lbAuthor1, 150);  
		FormDatas.attach(lbObjectType1).atTopTo(lbObjectLoanData, 5).atLeftTo(lbControlNumber1, 110);
		
		Text txtTitle1 = new Text(busquedaA, SWT.NORMAL);
		Text txtAuthor1 = new Text(busquedaA, SWT.NORMAL);
		Text txtControlNumber1 = new Text(busquedaA, SWT.NORMAL);
		Combo comboObjectType1 = new Combo(busquedaA, SWT.NONE);
		comboObjectType1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		
		FormDatas.attach(txtTitle1).atTopTo(lbTitle1, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(txtAuthor1).atTopTo(lbAuthor1, 5).atLeftTo(txtTitle1, 30).withWidth(130).withHeight(10);
		FormDatas.attach(txtControlNumber1).atTopTo(lbControlNumber1, 5).atLeftTo(txtAuthor1, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboObjectType1).atTopTo(lbObjectType1, 5).atLeftTo(txtControlNumber1, 30).withWidth(150).withHeight(23);
		
		lbDateReservation = new Label(busquedaA, SWT.NONE);
		lbDateRegistrationRange = new Label(busquedaA, SWT.NONE);
		lbReservationStatus1 = new Label(busquedaA, SWT.NONE);
		lbFrom = new Label(busquedaA, SWT.NONE);
		lbUp = new Label(busquedaA, SWT.NONE);
		
       	FormDatas.attach(lbDateReservation).atTopTo(txtTitle1, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbDateRegistrationRange).atTopTo(txtTitle1, 5).atLeftTo(lbDateReservation, 90);
		FormDatas.attach(lbReservationStatus1).atTopTo(lbDateReservation, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbFrom).atTopTo(lbDateRegistrationRange, 5).atLeftTo(lbReservationStatus1, 40);
		FormDatas.attach(lbUp).atTopTo(lbDateRegistrationRange, 5).atLeftTo(lbFrom, 120);
		
		Combo comboReservationStatus1 = new Combo(busquedaA, SWT.NONE);
		comboReservationStatus1.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		DateTime dateTime = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
		DateTime dateTime1 = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
		
		FormDatas.attach(comboReservationStatus1).atTopTo(lbReservationStatus1, 5).atLeftTo(parent, 15).withWidth(150).withHeight(23);
		FormDatas.attach(dateTime).atTopTo(lbFrom, 5).atLeftTo(comboReservationStatus1, 30);
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
	
		link.addListener(SWT.Selection, new EventConsultReservation(agrupa,busquedaB,busquedaA, link));
		
		FormDatas.attach(btnNewSearch).atTopTo(separador, 5).atRight(0).withWidth(120).withHeight(23);
		FormDatas.attach(btnConsult).atTopTo(separador, 5).atRightTo(btnNewSearch, 10).withWidth(100).withHeight(23);
		FormDatas.attach(link).atTopTo(separador, 5).atRightTo(btnConsult, 10).withWidth(130);
		
		lbCoincidenceList = new Label(parent, SWT.NONE);
		FormDatas.attach(lbCoincidenceList).atTopTo(btnConsult, 5).atLeftTo(parent, 15);
		
		//-----------------Tabla--------------------------------------
		
		Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
	    tabla.setHeaderVisible(true);
		tabla.setLinesVisible(true);
		
		TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		tableItem_1.setText( new String[] { "column 1",	"column 2","column 3" } );

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(130);
		columna1.setText("Nombre");
		
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(100);
		columna2.setText("Código");
		
		TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		columna3.setWidth(100);
		columna3.setText("Usuario");
		
		TableColumn columna4 = new TableColumn(tabla, SWT.NONE);
		columna4.setWidth(150);
		columna4.setText("Tipo de Usuario");

		TableColumn columna5 = new TableColumn(tabla, SWT.NONE);
		columna5.setWidth(100);
		columna5.setText("Estado");
		
		TableColumn columna6 = new TableColumn(tabla, SWT.NONE);
		columna6.setWidth(100);
		columna6.setText("Acciones");
		
		FormDatas.attach(tabla).atTopTo(lbCoincidenceList, 5).withWidth(700).withHeight(70);
		
		btnExportExcel = new Button(parent, SWT.PUSH);
		btnExportPDF = new Button(parent, SWT.PUSH);
		
		FormDatas.attach(btnExportPDF).atTopTo(tabla, 5).atRight(0).withWidth(110).withHeight(25);
		FormDatas.attach(btnExportExcel).atTopTo(tabla, 5).atRightTo(btnExportPDF, 10).withWidth(200).withHeight(25);
		l10n();
		
	return parent;
		
	}

	@Override
	public String getID() {
		return "ConsultarReservacionesID";
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
	
	lbSEARCH_CRITERIA.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
	lbUser.setText(AbosMessages.get().LABEL_USER);
	lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
	lbUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
	lbReservationStatus.setText(MessageUtil.unescape(AbosMessages.get().LABEL_RESERVATION_STATUS));
	lbTitle.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
	lbControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
	lbObjectType.setText(AbosMessages.get().LABEL_OBJECT_TYPE);
	lbSearchCriteria1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
	lbUserLoanData1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
	lbUser1.setText(AbosMessages.get().LABEL_USER);
	lbUserCode1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
	lbUserType1.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
	lbFirstName.setText(AbosMessages.get().LABEL_FIRST_NAME);
	lbSecondName.setText(AbosMessages.get().LABEL_SECOND_NAME);
	lbFirstLast.setText(AbosMessages.get().LABEL_FIRST_LAST);
	lbSecondLast.setText(AbosMessages.get().LABEL_SECOND_LAST);
	lbObjectLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
	lbTitle1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
	lbAuthor1.setText(AbosMessages.get().LABEL_AUTHOR);
	lbControlNumber1.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
	lbObjectType1.setText(AbosMessages.get().LABEL_OBJECT_TYPE);
	lbDateReservation.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATE_OF_RESERVATION));
    lbDateRegistrationRange.setText(AbosMessages.get().LABEL_DATE_OF_REGISTRATION_RANGE);
    lbReservationStatus1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_RESERVATION_STATUS));
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
		// TODO Auto-generated method stub
		
	}

}
