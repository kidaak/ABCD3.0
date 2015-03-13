package cu.uci.abcd.circulation.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegisterLoanDA implements IContributor{

	Label lbLoanType;
	Button btnLoan;
	Button btnCancel;
	Button rdbExternal;
	Button rdbInternal;
	Label lbUserLoanData;
	Button btnDissociate;
	Label lbObjectLoanData;
	Button btnDissociate1;
	Button btnAdd;
	Label lbListObjectLoan;
	
	/*User Loan Data*/
	TableItem tbItemName;
	TableItem tbItemUser;
	TableItem tbItemUserCode;
	TableItem tbItemUserType;
	TableItem tbItemState;
	/*Object Loan Data*/
	TableItem tbItemTitle;
	TableItem tbItemAuthor;
	TableItem tbItemControlNumber;
	TableItem tbItemObjectType;
	TableItem tbItemStateObject;
	
	@Override
	public String contributorName() {
		return "Prestamo.Datos Asocidos";
	}

	@Override
	public String getID() {
		return "rt";
	}
	@Override
	public Control createUIControl(Composite parent) {
		
		parent.setLayout(new FormLayout());
		Composite grupo = new Composite(parent, SWT.BORDER);
		grupo.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo.setLayout(new FormLayout());
		FormDatas.attach(grupo).atLeftTo(parent, 95).atTopTo(parent, 15);
		
		lbLoanType = new Label(grupo, SWT.None);
		FormDatas.attach(lbLoanType).atTopTo(grupo, 5);
		
		rdbExternal = new Button(grupo, SWT.RADIO);
		rdbInternal = new Button(grupo, SWT.RADIO);
		
		FormDatas.attach(rdbExternal).atTopTo(lbLoanType, 5);
		FormDatas.attach(rdbInternal).atTopTo(lbLoanType, 5).atLeftTo(rdbExternal, 30);
		
		Label separador = new Label(grupo, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(rdbExternal, 5).withWidth(650);
		
		lbUserLoanData = new Label(grupo, SWT.None);
		FormDatas.attach(lbUserLoanData).atTopTo(separador, 5);
		
		Label insertarE = new Label(grupo, SWT.NONE);
		insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		
		FormDatas.attach(insertarE).atTopTo(lbUserLoanData, 5);
		
		Table tabla = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);

		tbItemName = new TableItem(tabla, SWT.NONE);
		tbItemUser = new TableItem(tabla, SWT.NONE);
		tbItemUserCode = new TableItem(tabla, SWT.NONE);
		tbItemUserType = new TableItem(tabla, SWT.NONE);
		tbItemState = new TableItem(tabla, SWT.NONE);

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		columna1.setText("");
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(90);
		columna2.setText("");
		
		FormDatas.attach(tabla).atTopTo(lbUserLoanData, 5).atLeftTo(insertarE, 30);
				
		btnDissociate = new Button(grupo, SWT.PUSH);
		FormDatas.attach(btnDissociate).atTopTo(tabla, 5).atLeftTo(tabla, 3).withWidth(100).withHeight(23);
		
		Label separador2 = new Label(grupo, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador2).atTopTo(btnDissociate, 5).withWidth(650);
		
		lbObjectLoanData = new Label(grupo, SWT.None);
		FormDatas.attach(lbObjectLoanData).atTopTo(separador2, 5);
		
		Table tabla2 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
					
		tbItemTitle = new TableItem(tabla2, SWT.NONE);
		tbItemAuthor = new TableItem(tabla2, SWT.NONE);
		tbItemControlNumber = new TableItem(tabla2, SWT.NONE);
		tbItemObjectType = new TableItem(tabla2, SWT.NONE);
		tbItemStateObject = new TableItem(tabla2, SWT.NONE);
		
			
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(140);
		columna11.setText("");
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
		columna22.setText("");	
		
		FormDatas.attach(tabla2).atTopTo(lbObjectLoanData, 5);
				
		btnDissociate1 = new Button(grupo, SWT.PUSH);
		btnAdd = new Button(grupo, SWT.PUSH);
				
		FormDatas.attach(btnDissociate1).atTopTo(tabla2, 5).atLeftTo(tabla2, 1).withWidth(100).withHeight(23);
		FormDatas.attach(btnAdd).atTopTo(tabla2, 5).atLeftTo(btnDissociate1, 20).withWidth(100).withHeight(23);
		
		Label separador3= new Label(grupo, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador3).atTopTo(btnDissociate1, 5).withWidth(650);
		
        lbListObjectLoan = new Label(grupo, SWT.None);
		FormDatas.attach(lbListObjectLoan).atTopTo(separador3, 5);
		
		//-----------------Listado--------------------------------------
		
		Table tabla3 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla3.setHeaderVisible(true);
		tabla3.setLinesVisible(true);
				
		TableItem tableItem_13 = new TableItem(tabla3, SWT.NONE);
		tableItem_13.setText( new String[] { "column 1",	"column 2","column 3" } );

		TableColumn columna13 = new TableColumn(tabla3, SWT.NONE);
		columna13.setWidth(130);
		columna13.setText(AbosMessages.get().LABEL_TITLE);
				
		TableColumn columna23 = new TableColumn(tabla3, SWT.NONE);
		columna23.setWidth(100);
		columna23.setText(AbosMessages.get().LABEL_AUTHOR);
				
		TableColumn columna33 = new TableColumn(tabla3, SWT.NONE);
		columna33.setWidth(100);
		columna33.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
				
		TableColumn columna4 = new TableColumn(tabla3, SWT.NONE);
		columna4.setWidth(150);
		columna4.setText(AbosMessages.get().LABEL_OBJECT_TYPE);

		TableColumn columna5 = new TableColumn(tabla3, SWT.NONE);
		columna5.setWidth(100);
		columna5.setText("Entrega");
		
		TableColumn columna6 = new TableColumn(tabla3, SWT.NONE);
		columna6.setWidth(100);
		columna6.setText(AbosMessages.get().LABEL_TYPE_OF_LOAN);
		
		TableColumn columna7 = new TableColumn(tabla3, SWT.NONE);
		columna7.setWidth(100);
		columna7.setText("Duracion");
				
		TableColumn columna8 = new TableColumn(tabla3, SWT.NONE);
		columna8.setWidth(100);
		columna8.setText("Acciones");
		
		FormDatas.attach(tabla3).atTopTo(lbListObjectLoan, 5).withWidth(700).withHeight(70);
		
		btnLoan = new Button(grupo, SWT.PUSH);
		btnCancel = new Button(grupo, SWT.PUSH);
		
		FormDatas.attach(btnLoan).atTopTo(tabla3, 5).atLeftTo(grupo, 490).withWidth(100).withHeight(23);
		FormDatas.attach(btnCancel).atTopTo(tabla3, 5).atLeftTo(btnLoan, 20).withWidth(100).withHeight(23);
		
		l10n();
		
		return parent;
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		rdbExternal.setText(AbosMessages.get().LABEL_EXTERNAL);
		rdbInternal.setText(AbosMessages.get().LABEL_INTERNAL);
		lbLoanType.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_LOAN));
		lbUserLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		btnLoan.setText(AbosMessages.get().BUTTON_LOAN);
		btnCancel.setText(AbosMessages.get().BUTTON_CANCEL);	
		btnDissociate.setText(AbosMessages.get().BUTTON_DISSOCIATE);
		lbObjectLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
		btnDissociate1.setText(AbosMessages.get().BUTTON_DISSOCIATE);
		btnAdd.setText(AbosMessages.get().BUTTON_ADD);
		lbListObjectLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LIST_OF_OBJECTS_TO_LOAN));
	
		tbItemName.setText(AbosMessages.get().LABEL_NAME);
		tbItemUser.setText(AbosMessages.get().LABEL_USER);
		tbItemUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		tbItemUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		tbItemState.setText(AbosMessages.get().LABEL_STATE);
		
		tbItemTitle.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		tbItemAuthor.setText(AbosMessages.get().LABEL_AUTHOR);
		tbItemControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
		tbItemObjectType.setText(AbosMessages.get().LABEL_OBJECT_TYPE);
		tbItemStateObject.setText(AbosMessages.get().LABEL_STATE);
	}

	@Override
	public void setViewController(IViewController controller) {
	
	}

}
