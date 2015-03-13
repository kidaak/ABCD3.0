package cu.uci.abcd.cataloguing.ui;


import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import cu.uci.abos.l10n.cataloguing.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class NewSubscription implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return MessageUtil.unescape(AbosMessages.get().CONTRIBUTOR_NEW_SUBSCRIPTION);
		   
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "BusquedaSimpleMaterialesID";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		Group grpDetallesDeLa = new Group(parent, SWT.NONE);
		grpDetallesDeLa.setText(MessageUtil.unescape(AbosMessages.get().GROUP_SUBSCRIPTION_DETAILS));
		
		FormLayout layout = new FormLayout();
		
		parent.setLayout(layout);
		grpDetallesDeLa.setLayout(layout);
		
		FormDatas.attach(grpDetallesDeLa).atLeft(0).atRight(0);
		
		Label subscriptionLabel = new Label(grpDetallesDeLa, SWT.BEGINNING);
		subscriptionLabel.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SUBSCRIPTION_N));
		
		FormDatas.attach(subscriptionLabel).atTopTo(grpDetallesDeLa, 5).atLeftTo(grpDetallesDeLa, 15);
		
		CompoundLabel text1 = new CompoundLabel(grpDetallesDeLa, 0);
		text1.setText("");
		
		CompoundLabel provider = new CompoundLabel(grpDetallesDeLa, 0);
		provider.setText(AbosMessages.get().LABEL_PROVIDER);
		
		FormDatas.attach(provider).atTopTo(subscriptionLabel, 5);
		
		FormDatas.attach(text1).atTopTo(subscriptionLabel, 5).atLeftTo(provider, 10);
		
		text1.setPosition(SWT.LEFT, 0);
	
		Label loupe = new Label(grpDetallesDeLa, SWT.None);
		loupe.setText("Lupa");
		
		FormDatas.attach(loupe).atTopTo(subscriptionLabel, 12).atLeftTo(text1, 10);
		
		Link lin1 = new Link(grpDetallesDeLa, SWT.BEGINNING);
		lin1.setText(AbosMessages.get().LINK_SEARCH_PROVIDER);
        
        FormDatas.attach(lin1).atTopTo(subscriptionLabel, 10).atLeftTo(loupe, 12);
        
        CompoundLabel record = new CompoundLabel(grpDetallesDeLa, 0);
        record.setText(AbosMessages.get().LABEL_RECORD_PTS);
     
        CompoundLabel text2 = new CompoundLabel(grpDetallesDeLa, 0);
        text2.setText("");
        
        FormDatas.attach(text2).atTopTo(text1, 5).atLeftTo(record, 10);
        
        text2.setPosition(SWT.LEFT, 0);
        
		Label loupe2 = new Label(grpDetallesDeLa, SWT.None);
		loupe2.setText("Lupa");
		
		FormDatas.attach(loupe2).atTopTo(loupe, 18).atLeftTo(text2, 10);
		
		Link lin2 = new Link(grpDetallesDeLa, SWT.BEGINNING);
		lin2.setText(AbosMessages.get().LINK_SEARCH_BY_RECORD);
		
        FormDatas.attach(lin2).atTopTo(lin1, 13).atLeftTo(loupe2, 10);
        
        CompoundLabel signature = new CompoundLabel(grpDetallesDeLa, 0);
        signature.setText(AbosMessages.get().LABEL_SIGNATURE);
        
        CompoundLabel library = new CompoundLabel(grpDetallesDeLa, 0,ControlType.Combo);
        library.setText(AbosMessages.get().LABEL_LIBRARY);
        ((Combo)library.getControl()).setText(AbosMessages.get().COMBO_NONE);
       
        CompoundLabel notification = new CompoundLabel(grpDetallesDeLa, 0, ControlType.Combo);
        notification.setText(MessageUtil.unescape(AbosMessages.get().LABEL_NOTIFICATION_TO) +" "+AbosMessages.get().LABEL_USER_PTS);
        ((Combo)notification.getControl()).setText(AbosMessages.get().COMBO_NONE);
   
		Label lab10 = new Label(grpDetallesDeLa, SWT.None);
		lab10.setText(MessageUtil.unescape(AbosMessages.get().LABEL_ENABLE_FALSE));
		lab10.setEnabled(false);
		
		FormDatas.attach(lab10).atTopTo(notification, 5).atLeftTo(grpDetallesDeLa, 113);
		
		CompoundLabel publicNote = new CompoundLabel(grpDetallesDeLa, 0);
		publicNote.setText(MessageUtil.unescape(AbosMessages.get().LABEL_PUBLIC_NOTE));
		
		CompoundLabel nonPublicNote = new CompoundLabel(grpDetallesDeLa, 0);
		nonPublicNote.setText(MessageUtil.unescape(AbosMessages.get().LABEL_NONPUBLIC_NOTE));
		FormDatas.attach(nonPublicNote.getControl()).withHeight(40);
		
		Label lab13 = new Label(grpDetallesDeLa, SWT.BORDER);
		lab13.setText(MessageUtil.unescape(AbosMessages.get().LABEL_NOTE));
		
		FormDatas.attach(lab13).atTopTo(nonPublicNote, 10).atLeftTo(grpDetallesDeLa, 10);
		
		FormDatas.attach(provider).atTopTo(subscriptionLabel, 5);
		FormDatas.attach(record).atTopTo(provider, 5);
		FormDatas.attach(signature).atTopTo(record, 5);
		FormDatas.attach(library).atTopTo(signature, 5);
		FormDatas.attach(notification).atTopTo(library, 5);
		FormDatas.attach(publicNote).atTopTo(lab10, 9);
		FormDatas.attach(nonPublicNote).atTopTo(publicNote, 10);
		
		int moreBig = notification.getLabel().getSize().x;
		
		provider.setPosition(SWT.LEFT, moreBig - provider.getLabel().getSize().x + 10);
		record.setPosition(SWT.LEFT, moreBig - record.getLabel().getSize().x + 10);
		signature.setPosition(SWT.LEFT, moreBig - signature.getLabel().getSize().x + 10);
		library.setPosition(SWT.LEFT, moreBig - library.getLabel().getSize().x + 10);
		notification.setPosition(SWT.LEFT, 10);
		publicNote.setPosition(SWT.LEFT, moreBig - publicNote.getLabel().getSize().x + 10);
		nonPublicNote.setPosition(SWT.LEFT, moreBig - nonPublicNote.getLabel().getSize().x + 10);
		
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
