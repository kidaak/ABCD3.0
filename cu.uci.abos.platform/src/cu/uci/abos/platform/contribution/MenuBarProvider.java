package cu.uci.abos.platform.contribution;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.ui.api.IContributorService;
import cu.uci.abos.ui.api.IPlatformContributor;

public class MenuBarProvider implements IPlatformContributor {
	public static final String MENU_BAR_CONTROL = MenuBarProvider.class
			.getName() + "#MENUBAR";
	// NOTE: this value reflects the height of the menubar_background image set
	// via css
	public static final int MENU_BAR_HEIGHT = 41;
	private static final String MENUBAR_BACKGROUND = "menubar_background";

	// private static final String MENU_BUTTON = "menu_button";

	Button createMenuButton(Composite parent,
			final IContributorService pageService, final String pageId) {

		parent.setLayout(new FormLayout());

		FormData data1 = new FormData(100, 25);
		data1.left = new FormAttachment(parent, 7);
		data1.top = new FormAttachment(parent, 7);

		Button result = new Button(parent, SWT.PUSH);

		result.setText("Opcion1");
		result.setLayoutData(data1);
		result.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent evt) {
				pageService.selectContributor(pageId);
			}
		});

		FormData separator1 = new FormData();
		separator1.height = 37;
		separator1.left = new FormAttachment(result, 5);
		separator1.top = new FormAttachment(parent, 2);
		Label label1 = new Label(parent, SWT.SEPARATOR | SWT.SHADOW_OUT);

		label1.setLayoutData(separator1);

		FormData opcion2 = new FormData(100, 25);
		opcion2.left = new FormAttachment(label1, 5);
		opcion2.top = new FormAttachment(parent, 7);
		Button button2 = new Button(parent, SWT.PUSH);
		button2.setLayoutData(opcion2);
		button2.setText("Opcion 2");

		FormData separator2 = new FormData();
		separator2.height = 37;
		separator2.left = new FormAttachment(button2, 5);
		separator2.top = new FormAttachment(parent, 2);
		Label label2 = new Label(parent, SWT.SEPARATOR | SWT.SHADOW_OUT);

		label2.setLayoutData(separator2);

		FormData opcion3 = new FormData(100, 25);
		opcion3.left = new FormAttachment(label2, 5);
		opcion3.top = new FormAttachment(parent, 7);
		Button button3 = new Button(parent, SWT.PUSH);
		button3.setLayoutData(opcion3);
		button3.setText("Opcion 3");

		FormData separator3 = new FormData();
		separator3.height = 37;
		separator3.left = new FormAttachment(button3, 5);
		separator3.top = new FormAttachment(parent, 2);
		Label label3 = new Label(parent, SWT.SEPARATOR | SWT.SHADOW_OUT);

		label3.setLayoutData(separator3);

		FormData opcion4 = new FormData(100, 25);
		opcion4.left = new FormAttachment(label3, 5);
		opcion4.top = new FormAttachment(parent, 7);
		Button button4 = new Button(parent, SWT.PUSH);
		button4.setLayoutData(opcion4);
		button4.setText("Opcion 4");

		pageService.selectContributor(pageId);
		return result;
	}

	@Override
	public Control createUIControl(Composite parent) {
		final Composite result = new Composite(parent, SWT.None);
		result.layout(true, true);
		result.setData(RWT.CUSTOM_VARIANT, MENUBAR_BACKGROUND);
		result.setLayout(new FormLayout());

		Text text = new Text(result, SWT.SEARCH | SWT.ICON_SEARCH
				| SWT.ICON_CANCEL);
		FormData searchData = new FormData(275, 15);
		int width = getMaximumwidht();

		searchData.left = new FormAttachment(width / 11, 100);
		searchData.top = new FormAttachment(result, 5);
		text.setLayoutData(searchData);

		return result;
	}

	private int getMaximumwidht() {
		int width;
		Rectangle bounds = Display.getCurrent().getBounds();
		width = bounds.width;
		int result = 0;
		if (width > 1024) {
			result = width * 55 / 100;
		} else {
			result = width * 62 / 100;
		}

		return result;
	}

	@Override
	public String getID() {
		return MENU_BAR_CONTROL;
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub

	}

}