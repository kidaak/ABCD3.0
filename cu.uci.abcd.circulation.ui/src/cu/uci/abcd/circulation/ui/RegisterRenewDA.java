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

public class RegisterRenewDA implements IContributor{

	Label lbUserLoanData;
	Label lbMsjeRenovationDA;
	Label lbListObjectRenew;
	/*User Loan Data*/
	TableItem tbItemName;
	TableItem tbItemUser;
	TableItem tbItemUserCode;
	TableItem tbItemUserType;
	TableItem tbItemState;
	Button btnRenew;
	Button btnReturn;
	Button btnCancel;
	@Override
	public String contributorName() {
		return "Renovacion.Datos Asociados";
	}

	@Override
	public String getID() {
		return RegisterRenewDA.class.getSimpleName() + "id27";
	}

	@Override
	public Control createUIControl(Composite parent) {
		parent.setLayout(new FormLayout());
		Composite grupo = new Composite(parent, SWT.BORDER);
		grupo.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo.setLayout(new FormLayout());
		FormDatas.attach(grupo).atLeftTo(parent, 95).atTopTo(parent, 15);
		
		lbUserLoanData = new Label(grupo, SWT.None);
		FormDatas.attach(lbUserLoanData).atTopTo(grupo, 5);
		
		
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
		
		Label separador3= new Label(grupo, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador3).atTopTo(tabla, 5).withWidth(700);	
		
		lbMsjeRenovationDA = new Label(grupo, SWT.None);
		FormDatas.attach(lbMsjeRenovationDA).atTopTo(separador3, 5);
			
		lbListObjectRenew = new Label(grupo, SWT.None);
		FormDatas.attach(lbListObjectRenew).atTopTo(lbMsjeRenovationDA, 5);
		
		//-----------------Listado--------------------------------------
		
		Composite bottomGroup = new Composite(grupo, SWT.NONE);
		bottomGroup.setLayout(new FormLayout());
		FormDatas.attach(bottomGroup).atTopTo(lbListObjectRenew, 10);
		
	   /* CRUDTreeTable table = new CRUDTreeTable(bottomGroup,SWT.BORDER, ObjectLoanView.class, true, true, true,true,true,true);
			
        table.addRow(new ObjectLoanView("Edad de Oro","Jose Marti", "Libro", "100", "10/10/2014", "20/12/2014", "Atrasado"));
        table.addRow(new ObjectLoanView("Principito","Jose Marti", "Libro", "100", "10/10/2014", "20/12/2014", "Atrasado"));
	    table.setUpdateArea(new EditorAreaAssociateObjectLoan());*/
		
	    l10n();
		
		btnRenew = new Button(grupo, SWT.PUSH);
		btnReturn = new Button(grupo, SWT.PUSH);
		btnCancel = new Button(grupo, SWT.PUSH);
		
		FormDatas.attach(btnRenew).atTopTo(bottomGroup, 5).atLeftTo(grupo, 370).withWidth(100).withHeight(23);
		FormDatas.attach(btnReturn).atTopTo(bottomGroup, 5).atLeftTo(btnRenew, 20).withWidth(100).withHeight(23);
		FormDatas.attach(btnCancel).atTopTo(bottomGroup, 5).atLeftTo(btnReturn, 20).withWidth(100).withHeight(23);
		return parent;
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		lbUserLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));	
		lbMsjeRenovationDA.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MESSAGE_RENOVATION_DA));
		lbListObjectRenew.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LIST_OF_OBJECTS_TO_RENEW));
		
		tbItemName.setText(AbosMessages.get().LABEL_NAME);
		tbItemUser.setText(AbosMessages.get().LABEL_USER);
		tbItemUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		tbItemUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		tbItemState.setText(AbosMessages.get().LABEL_STATE);
		
		btnRenew.setText(AbosMessages.get().BUTTON_RENEW);
		btnReturn.setText(AbosMessages.get().BUTTON_RETURN);
		btnCancel.setText(AbosMessages.get().BUTTON_CANCEL);
	}
	@Override
	public void setViewController(IViewController controller) {
	
	}

}
