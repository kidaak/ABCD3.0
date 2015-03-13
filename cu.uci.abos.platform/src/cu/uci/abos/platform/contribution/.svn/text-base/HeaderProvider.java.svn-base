/*
 * @(#)HeaderProvider.java 1.0.0 12/09/2014 
 * Copyright (c) 2014 Universidad de las Ciencias Informaticas
 */
package cu.uci.abos.platform.contribution;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cu.uci.abcd.domain.common.Account;
import cu.uci.abcd.management.security.ILoginService;
import cu.uci.abcd.management.security.LoginException;
import cu.uci.abos.l10n.platform.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.platform.listener.DropDownSelectionListener;
import cu.uci.abos.platform.listener.LocaleResetListener;
import cu.uci.abos.platform.util.AbosImageUtil;
import cu.uci.abos.platform.util.Language;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IContributorService;
import cu.uci.abos.ui.api.IPlatformContributor;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.util.api.IServiceProvider;

public class HeaderProvider implements IPlatformContributor {
	public static final String HEADER_CONTROL = HeaderProvider.class.getName()
			+ "#HEADER";

	public static final int HEADER_HEIGHT = 60;
	private Language[] languages;
	private Composite parentContainer;
	private Composite contentContainer;
	private int selectedLocale;
	private IServiceProvider service;
	private Map<Integer, String> l10nCategory;
	private Map<Integer, String> l10nModule;

	public HeaderProvider(IServiceProvider serviceProvider) {
		this.service = serviceProvider;
		initializel10n();
	}

	void initializel10n() {
		l10nCategory = new HashMap<Integer, String>();
		l10nCategory.put(0, "categoryEs");
		l10nCategory.put(1, "categoryEn");

		l10nModule = new HashMap<Integer, String>();
		l10nModule.put(0, "moduleNameEs");
		l10nModule.put(1, "moduleNameEn");

	}

	@Override
	public Control createUIControl(Composite parent) {
		initLanguages(parent.getDisplay());
		parentContainer = parent;
		parentContainer.addListener(SWT.Dispose, new LocaleResetListener());
		selectedLocale = 0;
		createContentArea();

		return contentContainer;
	}

	private void createBanner() {
		Label logo = new Label(contentContainer, SWT.NONE);
		logo.setData(RWT.CUSTOM_VARIANT, "Banner");

		FormDatas.attach(logo).withWidth(139).withHeight(60).atLeft(20);

		Label grafica = new Label(contentContainer, SWT.NONE);
		grafica.setData(RWT.CUSTOM_VARIANT, "applicationName");
		grafica.setText(MessageUtil.unescape(AbosMessages.get().HEADER_SYSTEM_NAME));

		FormDatas.attach(grafica).atLeftTo(logo, 15).atTop(15);

		Label gradient = new Label(contentContainer, SWT.NONE);
		gradient.setData(RWT.CUSTOM_VARIANT, "gradient");

		FormDatas.attach(gradient).withHeight(60).withWidth(200)
				.atLeftTo(grafica, 10);

	}

	private Composite createAccessibillityMenu(Composite parent) {
		int widths = getMaximumwidht(53, 60);
		Composite result = new Composite(parent, SWT.None);
		result.setLayout(new FormLayout());
		FormDatas.attach(result).atLeft(55);
		ToolBar toolBar = new ToolBar(result, SWT.NONE);
		FormDatas.attach(toolBar).withWidth(150).atTop(15)
				.atLeft(widths / 10, 80).atBottom(20);
		ToolItem dropDownItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		dropDownItem.setText(languages[selectedLocale].name);
		dropDownItem.setImage(languages[selectedLocale].flag);
		Menu dropDownMenu = createDropDownMenu(dropDownItem);
		dropDownItem.addListener(SWT.Selection, new DropDownSelectionListener(
				dropDownMenu));

		ToolBar toolBarAyuda = new ToolBar(result, SWT.NONE);
		FormDatas.attach(toolBarAyuda).withWidth(100).atTop(15)
				.atLeft(widths / 10, 200);
		ToolItem dropDownHelpItem = new ToolItem(toolBarAyuda, SWT.DROP_DOWN);

		String[] Ayuda = { AbosMessages.get().HEADER_MANUAL,
				AbosMessages.get().HEADER_ABOUT_US };

		dropDownHelpItem.setText(AbosMessages.get().HEADER_HELP);
		Menu dropDownMenuHelp = createDropDownMenuText(dropDownHelpItem, Ayuda);
		dropDownHelpItem.addListener(SWT.Selection,
				new DropDownSelectionListener(dropDownMenuHelp));

		return result;

	}

	/**
	 * Accessibility
	 * 
	 * @param parent
	 * @param accesibillity
	 * @return
	 */
	private Composite createProfileMenu(Composite parent,
			Composite accessibillity) {
		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new FormLayout());
		result.setData(RWT.CUSTOM_VARIANT, "Profile");
		FormDatas.attach(result).atLeftTo(accessibillity).atRight(-10);

		Label usuario = new Label(result, SWT.NONE);
		usuario.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		int width = 46;
		int height = 46;
		FormDatas.attach(usuario).withWidth(60).withHeight(60);

		String src = RWT.getResourceManager().getLocation(
				"administracion/user.png");
		String properties = "border:3px solid white;border-radius:4px;margin-top:5px;margin-left:5px";
		usuario.setText("<img  width='" + width + "' height='" + height
				+ "' src='" + src + "' style='" + properties + "'></img> ");

		String[] User = { AbosMessages.get().HEADER_PROFILE,
				AbosMessages.get().HEADER_LOG_OFF };

		ToolBar toolBarPerfil = new ToolBar(result, SWT.NONE);

		FormDatas.attach(toolBarPerfil).withWidth(140)
				.atTopTo(usuario, 0, SWT.CENTER).atLeftTo(usuario, 12);
		ToolItem dropDownProfileItem = new ToolItem(toolBarPerfil,
				SWT.DROP_DOWN);

		ILoginService loginService = service.get(ILoginService.class);

		if (loginService.isEnabled()) {

			String usuarioA = ((Account) loginService.getSecurityDataStore()
					.getSecurityDataObject("account")).getUserName();
			dropDownProfileItem.setText(usuarioA);
		} else {
			dropDownProfileItem.setText("Deshabilitado");
		}

		Menu dropDownMenuProfile = createDropDownMenuText(dropDownProfileItem,
				User);
		dropDownProfileItem.addListener(SWT.Selection,
				new DropDownSelectionListener(dropDownMenuProfile));

		return result;
	}

	@Override
	public String getID() {
		return HEADER_CONTROL;
	}

	private int getMaximumwidht(int bigScreen, int smallScreen) {
		int width;
		Rectangle bounds = Display.getCurrent().getBounds();
		width = bounds.width;
		int result = 0;
		if (width > 1024) {
			result = width * bigScreen / 100;
		} else {
			result = width * smallScreen / 100;
		}

		return result;
	}

	private void initLanguages(Display display) {
		languages = new Language[] {
				new Language(new Locale("es", "ES", ""),
						AbosImageUtil.loadImage(null, display,
								"/cu/uci/abos/platform/resources/es-flag.png"),
						0),
				new Language(Locale.ENGLISH,
						AbosImageUtil.loadImage(null, display,
								"/cu/uci/abos/platform/resources/en-flag.png"),
						1) };

	}

	private Menu createDropDownMenu(ToolItem dropDown) {
		Menu menu = new Menu(dropDown.getParent().getShell(), SWT.POP_UP);
		for (int i = 0; i < languages.length; i++) {
			MenuItem item = new MenuItem(menu, SWT.PUSH);
			item.setText(languages[i].name);
			item.setImage(languages[i].flag);
			item.setData(languages[i]);
			item.addListener(SWT.Selection,
					new LocaleMenuItemSelectionListener(dropDown));
		}
		return menu;
	}

	private Menu createDropDownMenuText(ToolItem dropDown, String[] options) {
		Menu menu = new Menu(dropDown.getParent().getShell(), SWT.POP_UP);
		for (int i = 0; i < options.length; i++) {
			MenuItem item = new MenuItem(menu, SWT.PUSH);
			item.setText(options[i]);
			item.setData(options[i]);
			if (i == 1) {
				item.addSelectionListener(new SelectionAdapter() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void widgetSelected(SelectionEvent e) {
						try {
							ILoginService loginService = service
									.get(ILoginService.class);
							if (loginService.isEnabled()) {
								if (loginService != null) {
									loginService.logout();
								}
							}
						} catch (LoginException e1) {
							// do nothing
						}
					}
				});
			}
		}

		return menu;
	}

	private void createContentArea() {
		if (contentContainer != null) {
			Control[] controls = contentContainer.getChildren();
			for (Control auxControl : controls) {
				auxControl.dispose();
			}
		} else if (contentContainer == null) {
			contentContainer = new Composite(parentContainer,
					SWT.INHERIT_DEFAULT);
			contentContainer.setLayout(new FormLayout());
		}
		createBanner();
		Composite accessibillity = createAccessibillityMenu(contentContainer);
		createProfileMenu(contentContainer, accessibillity);
		contentContainer.layout();
	}

	private final class LocaleMenuItemSelectionListener implements Listener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3996024991064201932L;
		private final ToolItem dropDown;

		public LocaleMenuItemSelectionListener(ToolItem dropDown) {
			this.dropDown = dropDown;
		}

		public void handleEvent(Event event) {
			MenuItem item = (MenuItem) event.widget;
			Language language = (Language) item.getData();
			dropDown.setText(language.name);
			dropDown.setImage(language.flag);
			RWT.setLocale(language.locale);

			selectedLocale = language.index;

			createContentArea();
			updateMainMenu();

			final IContributorService pageService = service
					.get(IContributorService.class);

			pageService.l10n();

		}

	}

	void updateMainMenu() {
		Document xmlDocument = MainMenu.LoadXml("menu");

		Integer localeInteger = selectedLocale;

		MainMenu mainMenu = service.get(MainMenu.class);
		ExpandBar expandBarControl = mainMenu.bar;
		ExpandItem[] moduleExpandItems = expandBarControl.getItems();
		Control[] childTrees = expandBarControl.getChildren();

		for (int i = 0; i < childTrees.length; i++) {

			ExpandItem item = moduleExpandItems[i];
			String moduleName = item.getText();
			String moduleId = (String) item.getData(moduleName);
			Element moduleElement = xmlDocument.getElementById(moduleId);
			String updatedModuleName = moduleElement.getAttribute(l10nModule
					.get(localeInteger));
			item.setText(updatedModuleName);
			item.setData(updatedModuleName, moduleId);
			item.setExpanded(false);
			item.setExpanded(true);

			Tree itemTree = (Tree) childTrees[i];
			TreeItem[] leaf = itemTree.getItems();
			for (int j = 0; j < leaf.length; j++) {

				visitor(leaf[j], xmlDocument, localeInteger);
			}

		}

	}

	void visitor(TreeItem item, Document xml, Integer locale) {

		if (item == null) {
			return;
		}
		if (item.getItemCount() == 0) {
			String text = item.getText();
			IContributor contributor = (IContributor) item.getData(text);
			item.setText(contributor.contributorName());
			item.setData(contributor.contributorName(), contributor);
			return;

		}
		String category = item.getText();
		String id = (String) item.getData(category);
		Element element = (Element) xml.getElementById(id);
		String text = element.getAttribute(l10nCategory.get(locale));
		item.setText(text);
		item.setData(text, id);

		for (int i = 0; i < item.getItemCount(); i++) {
			TreeItem item2 = item.getItem(i);
			visitor(item2, xml, locale);

		}
	}

	@Override
	public void l10n() {

	}
}