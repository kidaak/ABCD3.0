package cu.uci.abcd.cataloguing.ui;


import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import cu.uci.abos.l10n.cataloguing.AbosMessages;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class ConsultMaterialsCataloger implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return AbosMessages.get().CONTRIBUTOR_CONSULT_MATERIALS_CATALOGER;
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistrarAutorSecundarioID";
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		Composite father = new Composite(parent, 0);
		
		father.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		parent.setLayout(new FormLayout());
		father.setLayout(new FormLayout());
		
		FormDatas.attach(father).atTopTo(parent, 10).atLeftTo(parent, 5);
		
		CompoundLabel catalogerCompound = new CompoundLabel(father, 0, ControlType.Combo);
		catalogerCompound.setText(AbosMessages.get().LABEL_CATALOGER);
		((Combo)catalogerCompound.getControl()).setText(AbosMessages.get().COMBO_PLEASE_CHOOSE);
		
		CompoundLabel recordTypeCompound = new CompoundLabel(father, 0, ControlType.Combo);
		recordTypeCompound.setText(AbosMessages.get().LABEL_RECORD_TYPE);
		((Combo)recordTypeCompound.getControl()).setText(AbosMessages.get().COMBO_PLEASE_CHOOSE);
		
		CompoundLabel startingDateCompound = new CompoundLabel(father, 0, ControlType.DatePicker);
		startingDateCompound.setText(AbosMessages.get().LABEL_STARTING_DATE);
		
		CompoundLabel finalDateCompound = new CompoundLabel(father, 0, ControlType.DatePicker);
		finalDateCompound.setText(AbosMessages.get().LABEL_FINAL_DATE);
		
		FormDatas.attach(catalogerCompound).atTopTo(father, 0);
		FormDatas.attach(recordTypeCompound).atTopTo(catalogerCompound, 15);
		FormDatas.attach(startingDateCompound).atTopTo(recordTypeCompound, 15);
		FormDatas.attach(finalDateCompound).atTopTo(startingDateCompound, 15);
		
		int moreBig = recordTypeCompound.getLabel().getSize().x;
		
		catalogerCompound.setPosition(SWT.LEFT, moreBig - catalogerCompound.getLabel().getSize().x + 10);
		recordTypeCompound.setPosition(SWT.LEFT, 10);
		startingDateCompound.setPosition(SWT.LEFT, moreBig - startingDateCompound.getLabel().getSize().x + 10);
		finalDateCompound.setPosition(SWT.LEFT, moreBig - finalDateCompound.getLabel().getSize().x + 10);
		
		father.layout(true);
		
		Button serachMaterialsButton = new Button(father, SWT.PUSH | SWT.CENTER);
		serachMaterialsButton.setText(AbosMessages.get().BUTTON_SEARCH_MATERIALS);
		
		FormDatas.attach(serachMaterialsButton).withHeight(25).atTopTo(finalDateCompound, 40).atLeftTo(father, 50);
		
		Button exitButton = new Button(father, SWT.PUSH | SWT.CENTER);
		exitButton.setText(AbosMessages.get().BUTTON_EXIT);
		
		FormDatas.attach(exitButton).withHeight(25).atTopTo(finalDateCompound, 40).atLeftTo(serachMaterialsButton, 5);
		
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
