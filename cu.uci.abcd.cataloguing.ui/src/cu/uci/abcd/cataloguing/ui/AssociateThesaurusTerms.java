package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import cu.uci.abos.l10n.cataloguing.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class AssociateThesaurusTerms implements IContributor {

	

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return MessageUtil.unescape(AbosMessages.get().CONTRIBUTOR_ASSOCIATE_THESAURUS_TERMS);
	}


	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		Composite father = new Composite(parent, 0);
		
		Composite composite = new Composite(father, SWT.NONE);
		
		parent.setLayout(new FormLayout());
		father.setLayout(new FormLayout());
		composite.setLayout(new FormLayout());
		
		father.setData(RWT.CUSTOM_VARIANT,"gray_background");
		composite.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		FormDatas.attach(father).atLeft(0).atRight(0);
		
		CompoundLabel matterCompound = new CompoundLabel(composite, 0, ControlType.Combo);
		matterCompound.setLayout(new FormLayout());
		
		matterCompound.setText(AbosMessages.get().LABEL_MATTER);
		((Combo)matterCompound.getControl()).setText(AbosMessages.get().COMBO_PLEASE_CHOOSE);
		
		FormDatas.attach(matterCompound.getControl()).withHeight(14);
		
		matterCompound.setPosition(SWT.LEFT, 10);
		
		FormDatas.attach(matterCompound).atTopTo(composite, 10);
		
		Button searchTermButton = new Button(composite, SWT.PUSH|SWT.CENTER);
		searchTermButton.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_SEARCH_TERM));
		
		FormDatas.attach(searchTermButton).withHeight(25).atTopTo(matterCompound, 20).atLeftTo(composite, 60);
		
		Button exitButton = new Button(composite, SWT.PUSH|SWT.CENTER);
		exitButton.setText(AbosMessages.get().BUTTON_EXIT);
		
		FormDatas.attach(exitButton).withHeight(25).atLeftTo(searchTermButton, 5).atTopTo(matterCompound, 20);
		
		Label termObtainedLabel = new Label(composite, SWT.NONE);
		termObtainedLabel.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TERM_OBTAINED));
		
	    FormDatas.attach(termObtainedLabel).atTopTo(exitButton, 40).atLeftTo(composite, 50);
	    
	    Button associateTermButton = new Button(composite, SWT.PUSH|SWT.CENTER);
	    associateTermButton.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_ASSOCIATE_TERM));
	    
		FormDatas.attach(associateTermButton).withHeight(25).atLeftTo(composite, 50).atTopTo(termObtainedLabel, 15);
		
		parent.layout(true);
		
		return parent;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistrarLibroID";
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
