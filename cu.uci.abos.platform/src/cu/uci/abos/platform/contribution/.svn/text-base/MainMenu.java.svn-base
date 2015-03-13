package cu.uci.abos.platform.contribution;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cu.uci.abos.platform.domain.MenuEntity;
import cu.uci.abos.platform.listener.MainMenuResizeListener;
import cu.uci.abos.platform.tracker.TreeMenuContributorTracker;
import cu.uci.abos.ui.api.IContributorService;
import cu.uci.abos.ui.api.IPlatformContributor;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.util.api.IServiceProvider;

public class MainMenu implements IPlatformContributor {
	public static final String MAIN_MENU_CONTROL = MainMenu.class.getName()
			+ "#MAINMENU";
	static final int MAIN_MENU_WIDTH = 140;
	private final IServiceProvider serviceProvider;

	private Map<String, MenuEntity> menuBuilder;
	
    public  ExpandBar bar;
   
	public MainMenu(IServiceProvider serviceProvider) {
		super();
		this.serviceProvider = serviceProvider;
		menuBuilder = new HashMap<String, MenuEntity>();

	}

	@Override
	public Control createUIControl(Composite parent) {

		final Composite composite = new Composite(parent, SWT.V_SCROLL);
		composite.setLayout(new FormLayout());
		composite.setData(RWT.CUSTOM_VARIANT, "main_menu_background");
		final Button button = new Button(composite, SWT.ARROW);
		button.setData(RWT.CUSTOM_VARIANT, "hide_expander_button");
		FormDatas.attach(button).withWidth(10).withHeight(10).atLeft(240);

		// expander

	    bar = new ExpandBar(composite, SWT.V_SCROLL);
		FormDatas.attach(bar).withWidth(250).atTopTo(button, 10)
				.withHeight(400);
		button.addListener(SWT.Selection, new MainMenuResizeListener());

		Document document = LoadXml("menu");

		NodeList rootChildren = document.getChildNodes();

		for (int i = 0; i < rootChildren.getLength(); i++) {
			if (rootChildren.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element rootElement = (Element) rootChildren.item(i);
				visitor(rootElement);
			}

		}

		final IContributorService pageService = serviceProvider
				.get(IContributorService.class);
		pageService.addContributorTracker(new TreeMenuContributorTracker(bar,
				pageService, menuBuilder));

		return composite;
	}

	@SuppressWarnings("unused")
	void visitor(Node node) {
		//System.out.println("Nodo: " + node.getNodeName());
		
		if (node == null) {
			return;
		}
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node n = nodes.item(i);
			String claseObject = n.getClass().toString();
			//System.out.println("Clase: " + claseObject);
			if (n == null) {
				continue;
			}
			if (claseObject.contains("DeferredTextImpl")) {
				continue;
			}
			if (n.getChildNodes().getLength() == 0) {
				if (menuBuilder.get(n.getNodeName()) == null) {
					
			//System.out.println(n.getNodeName());
					
					String containerMenu = n.getParentNode().getParentNode()
							.getAttributes().item(1).getNodeValue();
					
					String containerMenuId = n.getParentNode().getParentNode()
							.getAttributes().item(0).getNodeValue();
					
					String containerCategory = n.getParentNode()
							.getAttributes().item(0).getNodeValue();

					String containerCategoryId = n.getParentNode()
							.getAttributes().item(2).getNodeValue();

					String functionality = n.getAttributes().item(0)
							.getNodeValue();
					
			/*System.out.println("Container menu: " + containerMenu);
			System.out.println("Container menu id: " + containerMenuId);
			System.out.println("Container category: " + containerCategory);
			System.out.println("Container category id: " + containerCategoryId);
			System.out.println("Functionality: " + functionality);*/
			

					MenuEntity entity = new MenuEntity(containerMenu,
							containerCategory, functionality,
							containerCategoryId,containerMenuId);
					
					menuBuilder.put(functionality, entity);

				}

			}

			visitor(n);

		}

	}

	public static Document LoadXml(String path) {
		InputStream src = RWT.getResourceManager().getRegisteredContent(path);
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);

		factory.setNamespaceAware(true);
		try {
			factory.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-dtd-grammar",
					false);
			factory.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-external-dtd",
					false);
		} catch (ParserConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			document = builder.parse(src);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}

	@Override
	public String getID() {
		return MAIN_MENU_CONTROL;
	}

	@Override
	public void l10n() {

	}
}
