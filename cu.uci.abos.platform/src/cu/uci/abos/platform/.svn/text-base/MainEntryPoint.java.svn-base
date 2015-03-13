package cu.uci.abos.platform;

import java.util.List;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.EntryPoint;
import org.eclipse.rap.rwt.service.UISessionEvent;
import org.eclipse.rap.rwt.service.UISessionListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.domain.management.security.Permission;
import cu.uci.abcd.management.security.ILoginChangedListener;
import cu.uci.abcd.management.security.ILoginService;
import cu.uci.abcd.management.security.ILoginServiceListener;
import cu.uci.abcd.management.security.LoginException;
import cu.uci.abcd.management.security.LoginServiceTracker;
import cu.uci.abos.core.ui.ShellConfigurator;
import cu.uci.abos.l10n.platform.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.platform.contribution.BackgroundProvider;
import cu.uci.abos.platform.contribution.ContentProvider;
import cu.uci.abos.platform.contribution.FooterProvider;
import cu.uci.abos.platform.contribution.HeaderProvider;
import cu.uci.abos.platform.contribution.MainMenu;
import cu.uci.abos.platform.contribution.MenuBarProvider;
import cu.uci.abos.ui.api.ILayoutProvider;
import cu.uci.abos.ui.api.IPlatformContributor;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.util.api.IServiceProvider;
import cu.uci.abos.util.api.ServiceProviderUtil;
import cu.uci.abos.validation.ui.CustomControlDecoration;
import cu.uci.abos.validation.ui.DecoratedControl;
import cu.uci.abos.validation.ui.DecoratorType;

public class MainEntryPoint implements EntryPoint, ILoginServiceListener {

	private IServiceProvider serviceProvider;
	private Display display;
	private ILoginService loginService;
	private CustomControlDecoration customControlDecorationFactory;

	public MainEntryPoint() {
		this.serviceProvider = ServiceProviderUtil
				.getService(IServiceProvider.class);
		LoginServiceTracker tracker = new LoginServiceTracker();
		tracker.setListener(this);
		tracker.open();
		this.display = new Display();
	}

	@Override
	public int createUI() {
		synchronized (display) {
			if ((this.loginService == null || !this.loginService.isLoggedIn())
					&& this.loginService.isEnabled()) {
				customControlDecorationFactory = new CustomControlDecoration();
				this.createLoginUI();
			} else {
				this.createPlatformUI();
			}
		}
		return 0;
	}

	private void createLoginUI() {
		Shell main = new Shell(this.display, SWT.NORMAL);
		main.setLayout(new FormLayout());
		int width = getMaximumwidht();

		main.setData(RWT.CUSTOM_VARIANT, "Login_Background");

		main.setMaximized(true);

		Composite parent = new Composite(main, SWT.BORDER);
		parent.setData(RWT.CUSTOM_VARIANT, "Login_Border");
		parent.setLayout(new FormLayout());
		FormDatas.attach(parent).atLeft(width);

		Composite loginTop = createLoginTop(parent);
		createLoginBottom(parent, loginTop);

		main.layout();
		main.open();
	}

	private int getMaximumwidht() {
		int width;
		Rectangle bounds = Display.getCurrent().getBounds();
		width = bounds.width;
		int mitad = width - 600;
		int result = mitad * 50 / 100;
		return result;
	}

	private int getCenterPosition(int componentSize) {
		int overSpace = 600 - componentSize;
		int result = overSpace * 50 / 100;
		return result;

	}

	private Composite createLoginTop(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new FormLayout());

		Label label = new Label(result, SWT.NONE);
		label.setData(RWT.CUSTOM_VARIANT, "Banner");

		FormDatas.attach(label).withWidth(139).withHeight(60).atLeft(130)
				.atTop(50);

		Label grafica = new Label(result, SWT.NONE);
		grafica.setData(RWT.CUSTOM_VARIANT, "applicationName");
		grafica.setText(MessageUtil.unescape(AbosMessages.get().HEADER_SYSTEM_NAME));

		FormDatas.attach(grafica).atLeftTo(label, 15).atTop(67);

		Label loginGraficaL = new Label(result, SWT.NONE);
		loginGraficaL.setData(RWT.CUSTOM_VARIANT, "Login_grafica");
		FormDatas.attach(loginGraficaL).withWidth(600).withHeight(129)
				.atTopTo(label, 10);

		return result;
	}

	@SuppressWarnings("serial")
	private Composite createLoginBottom(Composite parent, Composite loginTop) {

		Composite result = new Composite(parent, SWT.None);
		FormDatas.attach(result).atTopTo(loginTop);
		result.setData(RWT.CUSTOM_VARIANT, "Login_Bottom_Background");
		result.setLayout(new FormLayout());

		final Text text = new Text(result, SWT.NORMAL);
		text.setMessage(AbosMessages.get().USER);
		int centerText = getCenterPosition(170);

		FormDatas.attach(text).withWidth(147).withHeight(10).atLeft(centerText)
				.atRight(centerText).atTop(10);

		final Text clave = new Text(result, SWT.PASSWORD);
		clave.setMessage(MessageUtil.unescape(AbosMessages.get().PASSWORD));

		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent event) {
				textChanged(text, "username");
				ControlDecoration decoration = customControlDecorationFactory
						.getControlByKey("username");
				if (clave.getText().length() > 0 && decoration != null) {
					decoration.hide();
					customControlDecorationFactory
							.removeControlDecoration("username");
					clave.setBackground(null);
				}
			}
		});

		clave.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent event) {
				textChanged(clave, "password");
				ControlDecoration decoration = customControlDecorationFactory
						.getControlByKey("password");
				if (text.getText().length() > 0 && decoration != null) {
					decoration.hide();
					customControlDecorationFactory
							.removeControlDecoration("password");
					text.setBackground(null);
				}
			}
		});

		FormDatas.attach(clave).withWidth(147).withHeight(10)
				.atLeft(centerText).atRight(centerText).atTopTo(text, 10);

		Button chkrecordar = new Button(result, SWT.CHECK);
		chkrecordar
				.setText(MessageUtil.unescape(AbosMessages.get().REMEMBER_PASSWORD));
		int centerChkrecordar = getCenterPosition(150);
		FormDatas.attach(chkrecordar).withWidth(119).withHeight(20)
				.atLeft(centerChkrecordar).atRight(centerChkrecordar)
				.atTopTo(clave, 15);

		final Button button = new Button(result, SWT.PUSH);

		button.setText(AbosMessages.get().BUTTON_LOG_IN);
		int centerButton = getCenterPosition(64);
		FormDatas.attach(button).withWidth(40).withHeight(24)
				.atLeft(centerButton).atRight(centerButton)
				.atTopTo(chkrecordar, 10);

		clave.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent event) {
			}

			@Override
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == 13) {
					login(text, clave);
				}
			}
		});

		button.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {
				login(text, clave);
			}
		});

		Label mensajeLabel = new Label(result, SWT.CENTER);
		mensajeLabel
				.setText(MessageUtil.unescape(AbosMessages.get().FORGET_PASSWORD));
		int centerLabel = getCenterPosition(164);
		FormDatas.attach(mensajeLabel).withWidth(140).withHeight(14)
				.atLeft(centerLabel).atRight(centerLabel).atTopTo(button, 10)
				.atBottom(30);

		return result;
	}

	private void createPlatformUI() {
		Shell shell = this.configureShell();
		shell.open();
		shell.setData(RWT.CUSTOM_VARIANT, "Principal");
	}

	private Shell configureShell() {
		MainMenu mainMenu = new MainMenu(serviceProvider);
		IPlatformContributor[] pageStructureProviders = new IPlatformContributor[] {
				new HeaderProvider(serviceProvider), new MenuBarProvider(),
				mainMenu, new ContentProvider(serviceProvider),
				new FooterProvider(), new BackgroundProvider() };
		serviceProvider.register(MainMenu.class, mainMenu);
		ILayoutProvider layoutProvider = new LayoutProviderImpl();
		ShellConfigurator configurator = new ShellConfigurator(serviceProvider,
				this.loginService.isEnabled());
		if (this.loginService.isEnabled()) {
			loadContributorsID(configurator);
		}
		Shell shell = configurator.configure(pageStructureProviders,
				layoutProvider);
		shell.layout(true);
		return shell;
	}

	@SuppressWarnings("unchecked")
	private void loadContributorsID(ShellConfigurator configurator) {
		List<Permission> permissions = (List<Permission>) loginService
				.getSecurityDataStore().getSecurityDataObject("permissions");
		for (int j = 0; j < permissions.size(); j++) {
			configurator.addContributorID(permissions.get(j)
					.getFunctionalityIdentifier());
		}
	}

	private void showLoginError(String msg, Text text, String controlKey) {
		if (customControlDecorationFactory.getControlByKey(controlKey) == null) {
			DecoratedControl[] decoratedControls = new DecoratedControl[] { new DecoratedControl(
					text, controlKey, msg) };
			customControlDecorationFactory.createDecorator(decoratedControls,
					DecoratorType.ERROR, 0);
		}
		text.setBackground(new Color(text.getDisplay(), 255, 204, 153));
		customControlDecorationFactory.getControlByKey(controlKey).show();
	}

	private void textChanged(Text text, String controlKey) {
		text.setBackground(null);
		ControlDecoration decoration = customControlDecorationFactory
				.getControlByKey(controlKey);
		if (decoration != null) {
			decoration.hide();
			customControlDecorationFactory.removeControlDecoration(controlKey);
		}
		if (text.getText().length() == 0) {
			showLoginError("Campo requerido!", text, controlKey);
		}
	}

	private void login(Text usernameText, Text passwordText) {
		textChanged(usernameText, "username");
		textChanged(passwordText, "password");
		if (usernameText.getData() == null && passwordText.getData() == null) {
			try {
				this.loginService.login(usernameText.getText(),
						passwordText.getText());
			} catch (LoginException e1) {
				MainEntryPoint.this.showLoginError("Credenciales incorrectas!",
						usernameText, "username");
				MainEntryPoint.this.showLoginError("Credenciales incorrectas!",
						passwordText, "password");
			}
		}
	}

	@SuppressWarnings("serial")
	@Override
	public void setLoginService(ILoginService loginServiceParam) {

		final ILoginService login;

		if (RWT.getUISession().getAttribute("loginService") == null) {
			RWT.getUISession().setAttribute("loginService", loginServiceParam);
			RWT.getUISession()
					.getHttpSession()
					.setMaxInactiveInterval(
							loginServiceParam.getSessionTimeout());
			login = loginServiceParam;
			RWT.getUISession().addUISessionListener(new UISessionListener() {
				@Override
				public void beforeDestroy(UISessionEvent uiSession) {
					try {
						if (login != null) {
							login.logout();
							login.clearEvents();
						}
					} catch (LoginException e) {
					}
				}
			});
		} else {
			login = (ILoginService) RWT.getUISession().getAttribute(
					"loginService");
		}

		this.loginService = login;
		this.serviceProvider.register(ILoginService.class, login);
		this.loginService.onLoginChanged(new ILoginChangedListener() {
			@Override
			public void handle() {
				if (!display.isDisposed()) {
					MainEntryPoint.this.createUI();
				}
			}
		});
	}
}
