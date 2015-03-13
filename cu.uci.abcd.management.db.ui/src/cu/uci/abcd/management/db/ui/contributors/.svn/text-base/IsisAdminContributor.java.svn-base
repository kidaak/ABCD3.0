package cu.uci.abcd.management.db.ui.contributors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cu.uci.abos.l10n.management.db.AbosMessages;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.wizard.Wizard;


public class IsisAdminContributor implements IContributor {

	private Wizard wizard;
	
	@Override
	public String contributorName() {
		return "Administración Isis";
	}

	@Override
	public String getID() {
		return "adminIsisID";
	}

	@Override
	public Control createUIControl(Composite parent) {
		
        //parent.setLayout(new GridLayout(1, true));
		
		//FillLayout topFillLayout = new FillLayout();
		//GridData topGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		//Composite topComposite = new Composite(parent, SWT.NONE);
		//topComposite.setLayout(new FormLayout());
		//topComposite.setLayout(topFillLayout);
		//topComposite.setLayoutData(topGridData);
		
		wizard = new Wizard(parent, SWT.NONE);
		FormDatas.attach(wizard).atLeft(0).atRight(0);
		
		wizard.addStep(new FDTStep(wizard));
		//wizard.addStep(new FSTStep(wizard));
		//wizard.addStep(new DEWStep(wizard));
		
		wizard.createUI();
		/*wizard.addStepChangeListener(new IStepChangeListener() {			
			@Override
			public void handleEvent(IStep currentStep, IStep oldStep, boolean isLast) {
				// do something.
				
			}
		});
		
		wizard.addCancelListener(new ICancelListener() {			
			@Override
			public void handleEvent() {
				// do something.				
			}
		});*/
		
		l10n();
		return parent;
	}

	@Override
	public boolean canClose() {
		return true;
	}

	@Override
	public void l10n() {
		wizard.setCancelBtnText(AbosMessages.get().WIZARD_BUTTON_CANCEL);
		wizard.setBeforeBtnText(AbosMessages.get().WIZARD_BUTTON_BEFORE);
		wizard.setNextBtnText(AbosMessages.get().WIZARD_BUTTON_NEXT);
		wizard.setFinishBtnText(AbosMessages.get().WIZARD_BUTTON_FINISH);
		wizard.l10n();
	}

	@Override
	public void setViewController(IViewController arg0) {
		// TODO Auto-generated method stub		
	}

}
