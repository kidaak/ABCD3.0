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

public class OpacCirculationMenu implements IPlatformContributor {
	public static final String CIRCULATION_MENU_CONTROL = OpacCirculationMenu.class
			.getName() + "#CIRCULATIONMENU";
	public static final int CIRCULATION_MENU_WIDTH = 170;
	private final IServiceProvider serviceProvider;

	public Composite composite;

	public OpacCirculationMenu(IServiceProvider serviceProvider) {
		super();
		this.serviceProvider = serviceProvider;
	}

	@Override
	public Control createUIControl(Composite parent) {

	    composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new FormLayout());
		composite.setData(RWT.CUSTOM_VARIANT, "body_background");
		Label lbFilter = new Label(composite, SWT.NONE);
		lbFilter.setText("Circulacion");
		composite.setVisible(false);
		return composite;
	}

	@Override
	public String getID() {
		return CIRCULATION_MENU_CONTROL;
	}

	@Override
	public void l10n() {

	}
}
