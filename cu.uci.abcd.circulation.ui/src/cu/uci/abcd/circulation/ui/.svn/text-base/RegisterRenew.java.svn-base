package cu.uci.abcd.circulation.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegisterRenew implements IContributor{

	Label lbObjectLoanData;
	Label lbMsjeRenovation;
	Label lbControlNumber;
	Button btnValidate;
	Button btnRenew;
	Button btnCancel;
	
	@Override
	public String contributorName() {
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_RENEWAL);
	}
	@Override
	public String getID() {
		return "RegistrarRenovacionID";
	}
	@Override
	public Control createUIControl(Composite parent) {
	parent.setLayout(new FormLayout());
	
	lbObjectLoanData = new Label(parent, SWT.None);
	lbMsjeRenovation = new Label(parent, SWT.None);
	lbControlNumber = new Label(parent, SWT.None);
		
	FormDatas.attach(lbObjectLoanData).atTopTo(parent, 5).atLeftTo(parent, 15);
	FormDatas.attach(lbMsjeRenovation).atTopTo(lbObjectLoanData, 5).atLeftTo(parent, 15);
	FormDatas.attach(lbControlNumber).atTopTo(lbMsjeRenovation, 5).atLeftTo(parent, 15);
		
	Text txtControlNumber = new Text(parent, SWT.BORDER);
	btnValidate = new Button(parent, SWT.PUSH);
	Button btnAsociate = new Button(parent, SWT.PUSH);
	btnAsociate.setText("...");
		
	FormDatas.attach(txtControlNumber).atTopTo(lbControlNumber, 5).atLeftTo(parent, 15).withWidth(130).withHeight(10);
	FormDatas.attach(btnValidate).atTopTo(lbControlNumber, 5).atLeftTo(txtControlNumber, 30).withWidth(100).withHeight(23);
	FormDatas.attach(btnAsociate).atTopTo(lbControlNumber, 5).atLeftTo(btnValidate, 30).withWidth(30).withHeight(23);
	
	Label separador3= new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
	FormDatas.attach(separador3).atTopTo(txtControlNumber, 105).atLeft(0).atRight(0);
	
	btnRenew = new Button(parent, SWT.PUSH);
	btnCancel = new Button(parent, SWT.PUSH);
	
	FormDatas.attach(btnCancel).atTopTo(separador3, 15).atRight(0).withWidth(100).withHeight(23);
	FormDatas.attach(btnRenew).atTopTo(separador3, 15).atRightTo(btnCancel, 20).withWidth(100).withHeight(23);
	
	l10n();
		
		return parent;
		
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
	lbObjectLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
	lbMsjeRenovation.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MESSAGE_RENOVATION));
	lbControlNumber.setText(AbosMessages.get().LABEL_CONTROL_NUMBER);
	btnValidate.setText(AbosMessages.get().BUTTON_VALIDATE);
	btnRenew.setText(AbosMessages.get().BUTTON_RENEW);
	btnCancel.setText(AbosMessages.get().BUTTON_CANCEL);
	
	}
	
	@Override
	public void setViewController(IViewController controller) {
	
	}

}
