package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import cu.uci.abos.l10n.cataloguing.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ConsultSubscriptionPeriodicalPublication implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return MessageUtil.unescape(AbosMessages.get().CONTRIBUTOR_CONSULT_SUBSCRIPTION);
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistrarAutorCorporativoID";
	}

	

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		Group consultSuscription = new Group(parent, SWT.NONE);
		consultSuscription.setText(MessageUtil.unescape(AbosMessages.get().GROUP_CONSULT_SUBSCRIPTION_PERIODICAL_PUBLICATIONS));
		
		Composite leftComposite = new Composite(consultSuscription, SWT.NONE);
		Composite rightComposite = new Composite(consultSuscription, SWT.NONE);
		
		leftComposite.setData(RWT.CUSTOM_VARIANT,"gray_background");
		rightComposite.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		parent.setLayout(new FormLayout());
		consultSuscription.setLayout(new FormLayout());
		leftComposite.setLayout(new FormLayout());
		rightComposite.setLayout(new FormLayout());
		
		FormDatas.attach(consultSuscription).atLeft(0).atRight(0);
		
		FormDatas.attach(leftComposite).atLeftTo(consultSuscription, 5);
		FormDatas.attach(rightComposite).atLeftTo(leftComposite, 20);
		
		Text textUp = new Text(leftComposite, 0);
		
		FormDatas.attach(textUp).atTopTo(leftComposite, 5).withWidth(170).withHeight(14);
		
		Text textDown = new Text(leftComposite, SWT.SEARCH|SWT.ICON_SEARCH);
		
		FormDatas.attach(textDown).atTopTo(textUp, 10).withWidth(170).withHeight(14);
		
		Button seekSubscriptionRadio = new Button(leftComposite, SWT.RADIO);
		seekSubscriptionRadio.setText(AbosMessages.get().RADIO_SEEK_SUBSCRIPTION);
		
		FormDatas.attach(seekSubscriptionRadio).atTopTo(textDown, 10);
		
		Button lendRadio = new Button(leftComposite, SWT.RADIO);
		lendRadio.setText(AbosMessages.get().RADIO_LEND);
		
		FormDatas.attach(lendRadio).atTopTo(textDown, 10).atLeftTo(seekSubscriptionRadio, 10);
		
		Button searchRadio = new Button(leftComposite, SWT.RADIO);
		searchRadio.setText(MessageUtil.unescape(AbosMessages.get().RADIO_SEARCH_IN_CATALOG));
		
		FormDatas.attach(searchRadio).atTopTo(seekSubscriptionRadio, 10);
		
		Button newSubscriptionButton = new Button(rightComposite, SWT.PUSH|SWT.LEFT);
		newSubscriptionButton.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SUBSCRIPTION));
		
		FormDatas.attach(newSubscriptionButton).atTopTo(rightComposite, 5).withHeight(25);
		
		Label periodicalSubscription = new Label(rightComposite, SWT.None);
		periodicalSubscription.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SPP));
		
		FormDatas.attach(periodicalSubscription).atTopTo(newSubscriptionButton, 10);
		
        Table table = new Table(rightComposite, SWT.BORDER|SWT.FULL_SELECTION);
		
		table.setTouchEnabled(true);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColum1 = new TableColumn(table, SWT.None);
		tableColum1.setWidth(40);
		tableColum1.setText(AbosMessages.get().TABLE_ISSN);
		
		TableColumn tableColum2 = new TableColumn(table, SWT.None);
		tableColum2.setWidth(45);
		tableColum2.setText(MessageUtil.unescape(AbosMessages.get().TABLE_TITLE));
		
		TableColumn tableColum3 = new TableColumn(table, SWT.None);
		tableColum3.setWidth(45);
		tableColum3.setText(AbosMessages.get().TABLE_NOTES);
		
		TableColumn tableColum4 = new TableColumn(table, SWT.None);
		tableColum4.setText(MessageUtil.unescape(AbosMessages.get().TABLE_LIBRARY_NUMBER));
		tableColum4.setWidth(130);
		
		FormDatas.attach(table).atTopTo(periodicalSubscription, 10);
		
		parent.layout(true);
		
		return parent;
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}

}
