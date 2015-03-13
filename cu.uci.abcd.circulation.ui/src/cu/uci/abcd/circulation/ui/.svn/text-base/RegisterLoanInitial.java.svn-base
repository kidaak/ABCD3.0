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
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegisterLoanInitial implements IContributor{

	Label lbLoanType;
	Button rdbExternal;
	Button rdbInternal;
	Label lbUserLoanData;
	Label lbMsjeUserLoan;
	Label lbUserCode;
	Button btnValidate;
	Button btnValidate1;
	Button btnLoan;
	Button btnCancel;
	Label lbObjectLoanData;
	Label lbMsjeObjectLoan;
	Label lbControlNumber;
	Label lbListObjectLoan;
	  
	@Override
	public String contributorName() {
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_LOAN);
	}
	@Override
	public String getID() {
		return "RegistrarPrestamoID";
	}
	@Override
	public Control createUIControl(Composite parent) {
		parent.setLayout(new FormLayout());
				
		lbLoanType = new Label(parent, SWT.None);
		FormDatas.attach(lbLoanType).atTopTo(parent, 15).atLeftTo(parent, 15);
		
		rdbExternal = new Button(parent, SWT.RADIO);
		rdbInternal = new Button(parent, SWT.RADIO);
		
		FormDatas.attach(rdbExternal).atTopTo(lbLoanType, 5).atLeftTo(parent, 15);
		FormDatas.attach(rdbInternal).atTopTo(lbLoanType, 5).atLeftTo(rdbExternal, 30);
		
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(rdbExternal, 5).atRight(0).atLeft(0);
		
		lbUserLoanData = new Label(parent, SWT.None);
		lbMsjeUserLoan = new Label(parent, SWT.None);
		lbUserCode = new Label(parent, SWT.None);
		
		FormDatas.attach(lbUserLoanData).atTopTo(separador, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbMsjeUserLoan).atTopTo(lbUserLoanData, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbUserCode).atTopTo(lbMsjeUserLoan, 5).atLeftTo(parent, 15);
		
		Text txtUserCode = new Text(parent, SWT.BORDER);
		btnValidate = new Button(parent, SWT.PUSH);
		Button btnAsociate = new Button(parent, SWT.PUSH);
		btnAsociate.setText("...");
		
		FormDatas.attach(txtUserCode).atTopTo(lbUserCode, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(btnValidate).atTopTo(lbUserCode, 5).atLeftTo(txtUserCode, 30).withWidth(100).withHeight(23);
		FormDatas.attach(btnAsociate).atTopTo(lbUserCode, 5).atLeftTo(btnValidate, 30).withWidth(30).withHeight(23);
		
		Label separador2 = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador2).atTopTo(txtUserCode, 5).atRight(0).atLeft(0);
		
		lbObjectLoanData = new Label(parent, SWT.None);
		lbMsjeObjectLoan = new Label(parent, SWT.None);
		lbControlNumber = new Label(parent, SWT.None);
		
		FormDatas.attach(lbObjectLoanData).atTopTo(separador2, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbMsjeObjectLoan).atTopTo(lbObjectLoanData, 5).atLeftTo(parent, 15);
		FormDatas.attach(lbControlNumber).atTopTo(lbMsjeObjectLoan, 5).atLeftTo(parent, 15);
		
		Text txtControlNumber = new Text(parent, SWT.BORDER);
		btnValidate1 = new Button(parent, SWT.PUSH);
		Button btnAsociate1 = new Button(parent, SWT.PUSH);
		btnAsociate1.setText("...");
		
		FormDatas.attach(txtControlNumber).atTopTo(lbControlNumber, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
		FormDatas.attach(btnValidate1).atTopTo(lbControlNumber, 5).atLeftTo(txtControlNumber, 30).withWidth(100).withHeight(23);
		FormDatas.attach(btnAsociate1).atTopTo(lbControlNumber, 5).atLeftTo(btnValidate1, 30).withWidth(30).withHeight(23);
		
		Label separador3= new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador3).atTopTo(txtControlNumber, 5).atRight(0).atLeft(0);
		
        lbListObjectLoan = new Label(parent, SWT.None);
		FormDatas.attach(lbListObjectLoan).atTopTo(separador3, 5).atLeftTo(parent, 15);
		
		//-----------------Tabla--------------------------------------
		
		Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(true);
		tabla.setLinesVisible(true);
				
		TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		tableItem_1.setText( new String[] { "column 1",	"column 2","column 3" } );

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(130);
		columna1.setText("Titulo");
				
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(100);
		columna2.setText("Autor");
				
		TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		columna3.setWidth(100);
		columna3.setText("No. de Control");
				
		TableColumn columna4 = new TableColumn(tabla, SWT.NONE);
		columna4.setWidth(150);
		columna4.setText("Tipo de Objeto");

		TableColumn columna5 = new TableColumn(tabla, SWT.NONE);
		columna5.setWidth(100);
		columna5.setText("Entrega");
		
		TableColumn columna6 = new TableColumn(tabla, SWT.NONE);
		columna6.setWidth(100);
		columna6.setText("Tipo de Prestamo");
		
		TableColumn columna7 = new TableColumn(tabla, SWT.NONE);
		columna7.setWidth(100);
		columna7.setText("Duracion");
				
		TableColumn columna8 = new TableColumn(tabla, SWT.NONE);
		columna8.setWidth(100);
		columna8.setText("Acciones");
		
		FormDatas.attach(tabla).atTopTo(lbListObjectLoan, 5).withWidth(700).withHeight(70);
		
		btnLoan = new Button(parent, SWT.PUSH);
		btnCancel = new Button(parent, SWT.PUSH);
		
		FormDatas.attach(btnLoan).atTopTo(tabla, 5).atLeftTo(parent, 490).withWidth(100).withHeight(23);
		FormDatas.attach(btnCancel).atTopTo(tabla, 5).atLeftTo(btnLoan, 20).withWidth(100).withHeight(23);
		
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
	lbMsjeUserLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MESSAGE_USER_LOAN));
	lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
	btnValidate.setText(AbosMessages.get().BUTTON_VALIDATE);
	btnLoan.setText(AbosMessages.get().BUTTON_LOAN);
	btnCancel.setText(AbosMessages.get().BUTTON_CANCEL);	
	lbObjectLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
	lbMsjeObjectLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MESSAGE_OBJECT_LOAN));
	lbControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
	btnValidate1.setText(AbosMessages.get().BUTTON_VALIDATE);
	lbListObjectLoan.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LIST_OF_OBJECTS_TO_LOAN));
	
	}
	
	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}

}
