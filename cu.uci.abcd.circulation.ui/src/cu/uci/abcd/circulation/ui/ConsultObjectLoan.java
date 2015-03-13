package cu.uci.abcd.circulation.ui;

import java.util.Arrays;
import java.util.Map;

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

import cu.uci.abcd.circulation.ui.listener.EventConsultObjectLoan;
import cu.uci.abcd.circulation.ui.model.EditorAreaAssociateObjectLoan;
import cu.uci.abcd.circulation.ui.model.ObjectLoanView;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;

public class ConsultObjectLoan implements IContributor{

	private Map<String, Control> controls;
	private IViewController controller;
	
	Label lbSearchCriteria;
	Label lbTitle;
	Label lbAuthor;
	Label lbControlNumber;
	Label lbObjectType;
	Label lbRange;
	Label lbStateObject;
	Label lbLocation;
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
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_CONSULT_OBJECT_LOAN);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		
	parent.setLayout(new FormLayout());
	
	
	lbSearchCriteria = new Label(parent, SWT.NONE);
	lbTitle = new Label(parent, SWT.NONE);
	lbAuthor = new Label(parent, SWT.NONE);
	lbControlNumber = new Label(parent, SWT.NONE);
	lbObjectType = new Label(parent, SWT.NONE);
	  
	FormDatas.attach(lbSearchCriteria).atTopTo(parent, 5).atLeftTo(parent, 15);
	FormDatas.attach(lbTitle).atTopTo(lbSearchCriteria, 5).atLeftTo(parent, 15);
	FormDatas.attach(lbAuthor).atTopTo(lbSearchCriteria, 5).atLeftTo(lbTitle, 160);
	FormDatas.attach(lbControlNumber).atTopTo(lbSearchCriteria, 5).atLeftTo(lbAuthor, 150);
	FormDatas.attach(lbObjectType).atTopTo(lbSearchCriteria, 5).atLeftTo(lbControlNumber, 100);
	
	Text txtTitle = new Text(parent, SWT.NORMAL);
	Text txtAuthor = new Text(parent, SWT.NORMAL);
	Text txtControlNumber = new Text(parent, SWT.NORMAL);
	
	Combo comboObjectType = new Combo(parent, SWT.NONE);
	comboObjectType.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
	
	
	FormDatas.attach(txtTitle).atTopTo(lbTitle, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
	FormDatas.attach(txtAuthor).atTopTo(lbAuthor, 5).atLeftTo(txtTitle, 30).withWidth(130).withHeight(10);
	FormDatas.attach(txtControlNumber).atTopTo(lbControlNumber, 5).atLeftTo(txtAuthor, 30).withWidth(130).withHeight(10);
	FormDatas.attach(comboObjectType).atTopTo(lbObjectType, 5).atLeftTo(txtControlNumber, 30).withWidth(150).withHeight(23);
	
	//--------------------------------------------
	Composite busquedaA = new Composite(parent, SWT.NORMAL);
    busquedaA.setData(RWT.CUSTOM_VARIANT, "gray_background");
    busquedaA.setVisible(false);
    busquedaA.setLayout(new FormLayout());
    FormDatas.attach(busquedaA).atLeftTo(parent, 180).atTopTo(txtAuthor, 5).withWidth(550).withHeight(85);
    
	lbRange = new Label(busquedaA, SWT.NONE);
	lbStateObject = new Label(parent, SWT.NONE);
	lbLocation = new Label(busquedaA, SWT.NONE);
	lbFrom = new Label(busquedaA, SWT.NONE);
	lbUp = new Label(busquedaA, SWT.NONE);
	
	FormDatas.attach(lbRange).atTopTo(busquedaA, 5).atLeftTo(busquedaA, 200);
	FormDatas.attach(lbStateObject).atTopTo(txtTitle, 30).atLeftTo(parent, 15);
	FormDatas.attach(lbLocation).atTopTo(lbRange, 5).atLeftTo(busquedaA, 5);
	FormDatas.attach(lbFrom).atTopTo(lbRange, 5).atLeftTo(lbLocation, 130);
	FormDatas.attach(lbUp).atTopTo(lbRange, 5).atLeftTo(lbFrom, 120);
	
	Combo comboObjectState = new Combo(parent, SWT.NONE);
	Combo comboLocation = new Combo(busquedaA, SWT.NONE);
	DateTime dateTime = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
	DateTime dateTime1 = new DateTime(busquedaA, SWT.BORDER | SWT.DROP_DOWN);
	
	FormDatas.attach(comboObjectState).atTopTo(lbStateObject, 5).withWidth(150).withHeight(23);
	FormDatas.attach(comboLocation).atTopTo(lbLocation, 5).atLeftTo(busquedaA, 1).withWidth(150).withHeight(23);
	FormDatas.attach(dateTime).atTopTo(lbFrom, 1).atLeftTo(comboLocation, 30);
	FormDatas.attach(dateTime1).atTopTo(lbUp, 1).atLeftTo(dateTime, 30);
	
	Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
	FormDatas.attach(separador).atTopTo(busquedaA, 5).atLeft(0).atRight(0);
	
	link = new Link(parent, SWT.NONE);
	btnConsult = new Button(parent, SWT.PUSH);
	btnNewSearch = new Button(parent, SWT.PUSH);
	
	link.addListener(SWT.Selection, new EventConsultObjectLoan(busquedaA, link));
	
	FormDatas.attach(btnNewSearch).atTopTo(separador, 5).atRight(0).withWidth(120).withHeight(23);
	FormDatas.attach(btnConsult).atTopTo(separador, 5).atRightTo(btnNewSearch, 10).withWidth(100).withHeight(23);
	FormDatas.attach(link).atTopTo(separador, 5).atRightTo(btnConsult, 10).withWidth(130);
	
	lbCoincidenceList = new Label(parent, SWT.NONE);
	FormDatas.attach(lbCoincidenceList).atTopTo(link, 15).atLeftTo(parent, 15);
	
	Composite bottomGroup = new Composite(parent, SWT.NONE);
	bottomGroup.setLayout(new FormLayout());
	FormDatas.attach(bottomGroup).atTopTo(lbCoincidenceList, 10);
	
    CRUDTreeTable tabla = new CRUDTreeTable(bottomGroup, SWT.BORDER);
	tabla.setUpdate(true, new EditorAreaAssociateObjectLoan());
	tabla.setDelete(true);
	tabla.setEntityClass(ObjectLoanView.class);
	tabla.setColumnHeaders(Arrays.asList("Título", "Autor", "No. de Control", "Tipo de Objeto", "Estado"));	
    
    /*tabla.addDeleteListener(new TreeColumnListener() {
		
		@Override
		public void handleEvent(TreeColumnEvent event) {
			ObjectLoanView loanObject = (ObjectLoanView)event.entity;
     	((LoanObjectViewController) controller).deleteLoanObject(loanObject.getIdLoanObject());
			}
			
	});*/

	btnExportExcel = new Button(parent, SWT.PUSH);
	btnExportPDF = new Button(parent, SWT.PUSH);
	
	FormDatas.attach(btnExportExcel).atTopTo(bottomGroup, 10).atLeftTo(parent, 375).withWidth(200).withHeight(23);
	FormDatas.attach(btnExportPDF).atTopTo(bottomGroup, 10).atLeftTo(btnExportExcel, 30).withWidth(100).withHeight(23);

	l10n();
	 return parent;	 
		
	}

	@Override
	public String getID() {
		return "ConsultarObjetoPrestamoID";
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		lbSearchCriteria.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		lbTitle.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		lbAuthor.setText(AbosMessages.get().LABEL_AUTHOR);
		lbControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
		lbObjectType.setText(AbosMessages.get().LABEL_OBJECT_TYPE);
		link.setText("<a>"+MessageUtil.unescape(AbosMessages.get().LABEL_ADVANCED_SEARCH)+"</a>");
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnNewSearch.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		lbRange.setText(AbosMessages.get().LABEL_DATE_OF_REGISTRATION_RANGE);
		lbStateObject.setText(AbosMessages.get().LABEL_STATE_OF_OBJECT);
		lbLocation.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LOCATION));
		lbFrom.setText(AbosMessages.get().LABEL_FROM);
		lbUp.setText(AbosMessages.get().LABEL_UP);
		lbCoincidenceList.setText(AbosMessages.get().LABEL_COINCIDENCE_LIST);
		btnExportExcel.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
	}

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;			
	}
}
