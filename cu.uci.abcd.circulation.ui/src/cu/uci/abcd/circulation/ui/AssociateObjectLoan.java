package cu.uci.abcd.circulation.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


import cu.uci.abcd.circulation.ui.model.EditorAreaAssociateObjectLoan;
//import cu.uci.abcd.circulation.ui.table.EditorAreaAssociateObjectLoan;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;

public class AssociateObjectLoan implements IContributor{

	Label lbSearchCriteria;
	Label lbTitle;
	Label lbAuthor;
	Label lbObjectType;
	Label lbControlNumber;
	Label lbEditionNumber;
	Label lbKeyWord;
	Label lbCoincidenceList;
	
	Button btnConsult;
	Button btnCancel;
	
	@Override
	public String contributorName() {
		return "Asociar Objeto de Préstamo";
	}

	@Override
	public String getID() {
		return "gg"; 
	}

	@Override
	public Control createUIControl(Composite parent) {
		
		parent.setLayout(new FormLayout());
		/*Composite parent = new Composite(parent, SWT.BORDER);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		parent.setLayout(new FormLayout());
		FormDatas.attach(parent).atLeftTo(parent, 95).atTopTo(parent, 15);*/
		
		lbSearchCriteria = new Label(parent, SWT.NONE);
	    lbTitle = new Label(parent, SWT.NONE);
		lbAuthor = new Label(parent, SWT.NONE);
		lbObjectType = new Label(parent, SWT.NONE);
		lbControlNumber = new Label(parent, SWT.NONE);
		
		FormDatas.attach(lbSearchCriteria).atTopTo(parent, 5);
		FormDatas.attach(lbTitle).atTopTo(lbSearchCriteria, 5);
		FormDatas.attach(lbAuthor).atTopTo(lbSearchCriteria, 5).atLeftTo(lbTitle, 160);
		FormDatas.attach(lbObjectType).atTopTo(lbSearchCriteria, 5).atLeftTo(lbAuthor, 150);
		FormDatas.attach(lbControlNumber).atTopTo(lbSearchCriteria, 5).atLeftTo(lbObjectType, 100);
		
		Text txtTitle = new Text(parent, SWT.NORMAL);
		Text txtAuthor = new Text(parent, SWT.NORMAL);
		Combo comboObjectType = new Combo(parent, SWT.NONE);
		comboObjectType.setItems(new String[] { "Activo", "Pendiente", "Atrazado"});
		Text txtControlNumber = new Text(parent, SWT.NORMAL);
		
		FormDatas.attach(txtTitle).atTopTo(lbTitle, 5).withWidth(130).withHeight(10);
		FormDatas.attach(txtAuthor).atTopTo(lbAuthor, 5).atLeftTo(txtTitle, 30).withWidth(130).withHeight(10);
		FormDatas.attach(comboObjectType).atTopTo(lbObjectType, 5).atLeftTo(txtAuthor, 30).withWidth(150).withHeight(23);
		FormDatas.attach(txtControlNumber).atTopTo(lbControlNumber, 5).atLeftTo(comboObjectType, 30).withWidth(130).withHeight(10);
		
		lbEditionNumber = new Label(parent, SWT.NONE);
		lbKeyWord = new Label(parent, SWT.NONE);
		  
		FormDatas.attach(lbEditionNumber).atTopTo(txtTitle, 5);
		FormDatas.attach(lbKeyWord).atTopTo(txtTitle, 5).atLeftTo(lbEditionNumber, 105);
		
		Text txtEditionNumber = new Text(parent, SWT.NORMAL);
		Text txtKeyWord = new Text(parent, SWT.NORMAL);
		
		FormDatas.attach(txtEditionNumber).atTopTo(lbEditionNumber, 5).withWidth(130).withHeight(10);
		FormDatas.attach(txtKeyWord).atTopTo(lbKeyWord, 5).atLeftTo(txtEditionNumber, 30).withWidth(130).withHeight(10);
		
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(txtKeyWord, 5).withWidth(700);
			
		btnConsult = new Button(parent, SWT.PUSH);
		btnCancel = new Button(parent, SWT.PUSH);

		FormDatas.attach(btnConsult).atTopTo(separador, 5).atLeftTo(parent, 480).withWidth(100).withHeight(23);
		FormDatas.attach(btnCancel).atTopTo(separador, 5).atLeftTo(btnConsult, 20).withWidth(100).withHeight(23);
		
		lbCoincidenceList = new Label(parent, SWT.NONE);
		FormDatas.attach(lbCoincidenceList).atTopTo(btnConsult, 15);
		
		//--------------------------------------------
		Composite bottomGroup = new Composite(parent, SWT.NONE);
		bottomGroup.setLayout(new FormLayout());
		FormDatas.attach(bottomGroup).atTopTo(lbCoincidenceList, 10);
		
	    CRUDTreeTable tabla = new CRUDTreeTable(bottomGroup, SWT.BORDER);
		tabla.setUpdate(true, new EditorAreaAssociateObjectLoan());
		
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
		lbTitle.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		lbAuthor.setText(AbosMessages.get().LABEL_AUTHOR);
		lbObjectType.setText(AbosMessages.get().LABEL_OBJECT_TYPE);
		lbControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
		lbEditionNumber.setText(MessageUtil.unescape(AbosMessages.get().LABEL_NUMBER_OF_EDITION));
		lbKeyWord.setText(AbosMessages.get().LABEL_KEYWORD);
		lbCoincidenceList.setText(AbosMessages.get().LABEL_COINCIDENCE_LIST);
		
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnCancel.setText(AbosMessages.get().BUTTON_CANCEL);
		
	}

	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}

}
