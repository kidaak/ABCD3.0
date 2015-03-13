package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import cu.uci.abos.l10n.cataloguing.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class NewSubscription1 implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return MessageUtil.unescape(AbosMessages.get().CONTRIBUTOR_NEW_SUBSCRIPTION1);
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "BusquedaAvanzadaMaterialesID";
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		Group grpDetallesDeLa = new Group(parent, SWT.CENTER);
		grpDetallesDeLa.setText(MessageUtil.unescape(AbosMessages.get().GROUP_PLANNING_PERIODICAL_PUBLICATIONS));	
		
		FormLayout layout = new FormLayout();
		parent.setLayout(layout);
		grpDetallesDeLa.setLayout(layout);
		
		FormDatas.attach(grpDetallesDeLa).atLeft(0).atRight(0);
		
		CompoundLabel publication = new CompoundLabel(grpDetallesDeLa, 0,ControlType.DatePicker);
		publication.setText(MessageUtil.unescape(AbosMessages.get().LABEL_PUBLICATION_OF)+" "+MessageUtil.unescape(AbosMessages.get().LABEL_FIRST_ISSUE));
		
		CompoundLabel frecuency = new CompoundLabel(grpDetallesDeLa, 0, ControlType.Combo);
		frecuency.setText(AbosMessages.get().LABEL_FRECUENCY);
		((Combo)frecuency.getControl()).setText(AbosMessages.get().COMBO_PLEASE_CHOOSE);
		
		CompoundLabel pattern = new CompoundLabel(grpDetallesDeLa, 0, ControlType.Combo);
		pattern.setText(MessageUtil.unescape(AbosMessages.get().LABEL_PATTERN_OF) + " "+MessageUtil.unescape(AbosMessages.get().LABEL_NUMERATION));
		((Combo)frecuency.getControl()).setText(AbosMessages.get().COMBO_PLEASE_CHOOSE);
		
		CompoundLabel history = new CompoundLabel(grpDetallesDeLa, 0);
		history.setText(AbosMessages.get().LABEL_MANUAL_HISTORY);
	
		CompoundLabel subscription = new CompoundLabel(grpDetallesDeLa, 0,ControlType.DatePicker);
		subscription.setText(AbosMessages.get().LABEL_START_OF_THE+" "+MessageUtil.unescape(AbosMessages.get().LABEL_SUBSCRIPTION));
		
		CompoundLabel duration = new CompoundLabel(grpDetallesDeLa, 0, ControlType.Combo);
		duration.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DURATION_OF_THE) + " "+MessageUtil.unescape(AbosMessages.get().LABEL_SUBSCRIPTION));
		((Combo)frecuency.getControl()).setText(MessageUtil.unescape(AbosMessages.get().COMBO_NUMBER_OF_COPIES));
		
		CompoundLabel text1 = new CompoundLabel(grpDetallesDeLa, 0);
		text1.setText("");
		
		FormDatas.attach(text1).atTopTo(subscription, 5).atLeftTo(duration, 13);
		
		text1.setPosition(SWT.LEFT, 0);
		
		Label lab11 = new Label(grpDetallesDeLa, SWT.BEGINNING);
		lab11.setText(AbosMessages.get().LABEL_ENTER_QUANTITY_AND_FIGURES);
		
		FormDatas.attach(lab11).atTopTo(subscription, 13).atLeftTo(text1, 3);
		
		CompoundLabel formula = new CompoundLabel(grpDetallesDeLa, 0);
		formula.setText(MessageUtil.unescape(AbosMessages.get().LABEL_FORMULA_OF) + " "+MessageUtil.unescape(AbosMessages.get().LABEL_NUMERATION));
		
		FormDatas.attach(publication).atTopTo(grpDetallesDeLa, 10);
		FormDatas.attach(frecuency).atTopTo(publication, 5);
		FormDatas.attach(pattern).atTopTo(frecuency, 5);
		FormDatas.attach(history).atTopTo(pattern, 5);
		FormDatas.attach(subscription).atTopTo(history, 5);
		FormDatas.attach(duration).atTopTo(subscription, 5);
		FormDatas.attach(formula).atTopTo(duration, 5);
		
		int moreBig = publication.getLabel().getSize().x;
		
		publication.setPosition(SWT.LEFT, 10);
		frecuency.setPosition(SWT.LEFT, moreBig - frecuency.getLabel().getSize().x + 10);
		pattern.setPosition(SWT.LEFT, moreBig - pattern.getLabel().getSize().x + 10);
		history.setPosition(SWT.LEFT, moreBig - history.getLabel().getSize().x + 10);
		subscription.setPosition(SWT.LEFT, moreBig - subscription.getLabel().getSize().x + 10);
		duration.setPosition(SWT.LEFT, moreBig - duration.getLabel().getSize().x + 10);
		formula.setPosition(SWT.LEFT, moreBig - formula.getLabel().getSize().x + 10);
		
	    Composite buttonComposite = new Composite(grpDetallesDeLa,SWT.CENTER);
	    
	    buttonComposite.setData(RWT.CUSTOM_VARIANT,"gray_background");
	   
	    FormDatas.attach(buttonComposite).atTopTo(formula, 10);
	    
	    RowLayout rowLayout = new RowLayout();
	    rowLayout.justify = true;
	    buttonComposite.setLayout(rowLayout);
	    RowData rowData = new RowData();
	   
	    Button testPattern = new Button(buttonComposite, SWT.PUSH|SWT.CENTER);
	    testPattern.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_TEST_PATTERN));
	    rowData.height = 25;
	    testPattern.setLayoutData(rowData);
	    
	    Button rebootPattern = new Button(buttonComposite, SWT.PUSH|SWT.CENTER);
	    rebootPattern.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_REBOOT_PATTERN));
	    rowData = new RowData();
	    rowData.height = 25;
	    rebootPattern.setLayoutData(rowData);
	    
		Button saveSubscription = new Button(buttonComposite, SWT.PUSH|SWT.CENTER);
		saveSubscription.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_SAVE_SUBSCRIPTION));
		rowData = new RowData();
		rowData.height = 25;
		saveSubscription.setLayoutData(rowData);
		
		Button showHideSchemes = new Button(buttonComposite, SWT.PUSH|SWT.CENTER);
		showHideSchemes.setText(AbosMessages.get().BUTTON_SHOW_HIDE_SCHEMES);
		rowData = new RowData();
		rowData.height = 25;
		showHideSchemes.setLayoutData(rowData);
		
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
