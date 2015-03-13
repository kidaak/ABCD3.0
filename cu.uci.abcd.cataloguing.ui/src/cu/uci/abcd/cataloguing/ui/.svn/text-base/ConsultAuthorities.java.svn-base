package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import cu.uci.abos.l10n.cataloguing.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class ConsultAuthorities implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return AbosMessages.get().CONTRIBUTOR_CONSULT_AUTHORITIES;
	}

	

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "hh";
	}


	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		Composite father = new Composite(parent, 0);
		
		Composite leftComposite = new Composite(father, SWT.NONE);
		Composite rightComposite = new Composite(father, SWT.NONE);
		
		parent.setLayout(new FormLayout());
		leftComposite.setLayout(new FormLayout());
		rightComposite.setLayout(new FormLayout());
		father.setLayout(new FormLayout());
		
		FormDatas.attach(father).atLeft(0).atRight(0);
		
		father.setData(RWT.CUSTOM_VARIANT,"gray_background");
		leftComposite.setData(RWT.CUSTOM_VARIANT,"gray_background");
		rightComposite.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		FormDatas.attach(leftComposite).atLeftTo(parent, 5).atTopTo(father, 10);
		FormDatas.attach(rightComposite).atLeftTo(leftComposite, 20).atTopTo(father, 10);
		
		CompoundLabel personalNameCombo = new CompoundLabel(leftComposite, 0,ControlType.Combo);
		((Combo)(personalNameCombo.getControl())).setText(AbosMessages.get().COMBO_PERSONAL_NAME);
		personalNameCombo.setText("");
		
		FormDatas.attach(personalNameCombo).atTopTo(leftComposite, 5).atLeftTo(leftComposite, 15);
		
		personalNameCombo.setPosition(SWT.LEFT, 0);
		
		CompoundLabel containsCombo = new CompoundLabel(leftComposite, 0,ControlType.Combo);
		((Combo)(containsCombo.getControl())).setText(AbosMessages.get().COMBO_CONTAINS);
		personalNameCombo.setText("");
		
		FormDatas.attach(containsCombo).atTopTo(personalNameCombo, 10).atLeftTo(leftComposite, 15);
		
		containsCombo.setPosition(SWT.LEFT, 0);
		
		CompoundLabel headerCombo = new CompoundLabel(leftComposite, 0,ControlType.Combo);
		((Combo)(headerCombo.getControl())).setText(AbosMessages.get().COMBO_HEADER);
		personalNameCombo.setText("");
		
		FormDatas.attach(headerCombo).atTopTo(containsCombo, 10).atLeftTo(leftComposite, 15);
		
		headerCombo.setPosition(SWT.LEFT, 0);
		
		Text text = new Text(leftComposite, SWT.SEARCH|SWT.ICON_SEARCH);
		
		FormDatas.attach(text).atLeftTo(leftComposite, 20).atTopTo(headerCombo, 10).withWidth(170).withHeight(14);
		
		Button authoritiesRadio = new Button(leftComposite, SWT.RADIO);
		authoritiesRadio.setText(AbosMessages.get().RADIO_AUTHORITIES);
		
		FormDatas.attach(authoritiesRadio).atLeftTo(leftComposite, 20).atTopTo(text, 10);
		
		Button headerRadio = new Button(leftComposite, SWT.RADIO);
		headerRadio.setText(AbosMessages.get().RADIO_HEADER);
		
		FormDatas.attach(headerRadio).atTopTo(text, 10).atLeftTo(authoritiesRadio, 10);
		
		Button allHeadingsRadio = new Button(leftComposite, SWT.RADIO);
		allHeadingsRadio.setText(AbosMessages.get().RADIO_ALL_HEADINGS);
		
		FormDatas.attach(allHeadingsRadio).atLeftTo(leftComposite, 20).atTopTo(authoritiesRadio, 10);
		
		Button newAuthoritiesButton = new Button(rightComposite,SWT.LEFT|SWT.PUSH);
		newAuthoritiesButton.setText(AbosMessages.get().BUTTON_NEW_AUTHORITY);
		
		FormDatas.attach(newAuthoritiesButton).atTopTo(rightComposite, 5).withHeight(25).atLeftTo(rightComposite, 0);
		
		Label searchResultLabel = new Label(rightComposite, SWT.NONE);
		searchResultLabel.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_RESULTS_AUTHORITY));
		
		FormDatas.attach(searchResultLabel).atLeftTo(rightComposite, 0).atTopTo(newAuthoritiesButton, 10);
		
		Label resultsLabel = new Label(rightComposite, SWT.NONE);
		resultsLabel.setText(AbosMessages.get().LABEL_RESULTS);
		
		FormDatas.attach(resultsLabel).atLeftTo(rightComposite, 0).atTopTo(searchResultLabel, 10);
		
        Table table = new Table(rightComposite, SWT.BORDER|SWT.FULL_SELECTION|RWT.CELL);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setEnabled(true);
		
		TableColumn tableColum1 = new TableColumn(table, SWT.CENTER);
		tableColum1.setWidth(150);
		tableColum1.setText(AbosMessages.get().TABLE_SUMMARY);
		
		TableColumn tableColum2 = new TableColumn(table, SWT.CENTER);
		tableColum2.setWidth(80);
		tableColum2.setText(AbosMessages.get().TABLE_USED_IN);
		
		TableColumn tableColum3 = new TableColumn(table, SWT.CENTER);
		tableColum3.setWidth(45);
		tableColum3.setText("");
		
		FormDatas.attach(table).atLeftTo(rightComposite, 0).atTopTo(resultsLabel, 10);
		
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
