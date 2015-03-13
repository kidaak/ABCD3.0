package cu.uci.abos.platform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import cu.uci.abos.platform.contribution.BackgroundProvider;
import cu.uci.abos.platform.contribution.ContentProvider;
import cu.uci.abos.platform.contribution.FooterProvider;
import cu.uci.abos.platform.contribution.HeaderProvider;
import cu.uci.abos.platform.contribution.MainMenu;
import cu.uci.abos.platform.contribution.MenuBarProvider;
import cu.uci.abos.ui.api.ILayoutContext;
import cu.uci.abos.ui.api.ILayoutProvider;
import cu.uci.abos.util.api.FormDatas;

public class LayoutProviderImpl implements ILayoutProvider {

	private static final int OFFSET = 20;
	private static final int CONTENT_OFFSET = HeaderProvider.HEADER_HEIGHT
			+ MenuBarProvider.MENU_BAR_HEIGHT + 20;

	private Control content;
	private Control header;
	private Control menuBar;
	private Control mainMenu;
	private Control footer;
	private Control background;

	private void readControls(ILayoutContext context) {
		header = context.getControl(HeaderProvider.HEADER_CONTROL);
		menuBar = context.getControl(MenuBarProvider.MENU_BAR_CONTROL);
		mainMenu = context.getControl(MainMenu.MAIN_MENU_CONTROL);
		content = context.getControl(ContentProvider.CONTENT_CONTROL);
		footer = context.getControl(FooterProvider.FOOTER_CONTROL);
		background = context.getControl(BackgroundProvider.BACKGROUND_CONTROL);
	}

	private void configureLayout() {
		layoutHeader();
		layoutMenuBar();
		layoutMainMenu();
		layoutContent();
		layoutFooter();
		layoutBackground();
	}

	private void layoutMainMenu() {
		/*
		 * FormData layoutData = new FormData();
		 * mainMenu.setLayoutData(layoutData);
		 * 
		 * layoutData.top = new FormAttachment(0, CONTENT_OFFSET);
		 * layoutData.left = new FormAttachment(1, 0);
		 * 
		 * layoutData.width = 270; layoutData.height = calculateHeight();
		 */


		FormDatas.attach(mainMenu).atTopTo(menuBar, OFFSET).withWidth(270)
				.withHeight(calculateHeight() - 5).atLeft(OFFSET);

		

	}

	private void layoutHeader() {
		FormData layoutData = new FormData();
		header.setLayoutData(layoutData);
		layoutData.top = new FormAttachment(0, 0);
		layoutData.left = new FormAttachment(0, 0);
		layoutData.right = new FormAttachment(100, 0);
		layoutData.height = HeaderProvider.HEADER_HEIGHT;
	}

	private void layoutMenuBar() {
		FormData layoutData = new FormData();
		menuBar.setLayoutData(layoutData);
		layoutData.top = new FormAttachment(0, HeaderProvider.HEADER_HEIGHT);
		layoutData.left = new FormAttachment(0, 0);
		layoutData.right = new FormAttachment(100, 0);
		layoutData.height = MenuBarProvider.MENU_BAR_HEIGHT;
	}

	private void layoutContent() {
		FormData layoutData = new FormData();
		content.setLayoutData(layoutData);
		layoutData.top = new FormAttachment(0, CONTENT_OFFSET);
		layoutData.left = new FormAttachment(mainMenu, 10);
		layoutData.right = new FormAttachment(100, 0);
		layoutData.bottom = new FormAttachment(footer, 0, SWT.TOP);
		layoutData.width = content.getSize().x - 4;
		layoutData.height = calculateHeight();
	}

	private int calculateHeight() {
		int height = content.getSize().y;
		int maximumHeight = getMaximumHeight();
		if (height < maximumHeight) {
			height = maximumHeight;
		}
		return height;
	}

	private int getMaximumHeight() {
		int height;
		Rectangle bounds = Display.getCurrent().getBounds();
		height = bounds.height - FooterProvider.FOOTER_HEIGHT
				- HeaderProvider.HEADER_HEIGHT
				- MenuBarProvider.MENU_BAR_HEIGHT - OFFSET;
		return height;
	}

	private void layoutFooter() {
	/*	FormData layoutData = new FormData();
		layoutData.top = new FormAttachment(100, -50);
		layoutData.left = new FormAttachment(0, 0);
		layoutData.bottom = new FormAttachment(100);
		layoutData.right = new FormAttachment(100, 0);
		layoutData.height = FooterProvider.FOOTER_HEIGHT;
		footer.setLayoutData(layoutData);*/

		FormDatas.attach(footer).atTopTo(mainMenu).atLeft(0).atRight(0)
				.withHeight(FooterProvider.FOOTER_HEIGHT).atBottom(0);
	}

	private void layoutBackground() {
		FormData layoutData = new FormData();
		background.setLayoutData(layoutData);
		layoutData.top = new FormAttachment(0, 0);
		layoutData.left = new FormAttachment(0, 0);
		layoutData.right = new FormAttachment(100, 0);
		layoutData.bottom = new FormAttachment(100, 0);
	}

	@Override
	public void layout(ILayoutContext layoutContext) {
		readControls(layoutContext);
		configureLayout();
	}
}