package cu.uci.abcd.opac.contribution;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.Label;

import cu.uci.abos.ui.api.IPlatformContributor;
import cu.uci.abos.util.api.IServiceProvider;

public class OpacAdquisitionMenu implements IPlatformContributor {
	public static final String ADQUISITION_MENU_CONTROL = OpacAdquisitionMenu.class
			.getName() + "#ADQUISITIONMENU";
	public static final int ADQUISITION_MENU_WIDTH = 140;
	private final IServiceProvider serviceProvider;

	public Composite composite;

	public OpacAdquisitionMenu(IServiceProvider serviceProvider) {
		super();
		this.serviceProvider = serviceProvider;
	}
 
	@Override
	public Control createUIControl(Composite parent) {
		 composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new FormLayout());
		composite.setData(RWT.CUSTOM_VARIANT, "body_background");
		Label lbFilter = new Label(composite, SWT.NONE);
		lbFilter.setText("Adquisicion");
		composite.setVisible(false);
		return composite;
	}

	@Override
	public String getID() {
		return ADQUISITION_MENU_CONTROL;
	}

	@Override
	public void l10n() {

	}
}
