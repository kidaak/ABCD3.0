package cu.uci.abos.platform;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;
import org.eclipse.rap.rwt.service.ResourceLoader;

import cu.uci.abos.ui.api.ConfiguratorTracker;

public class ApplicationPlatform implements ApplicationConfiguration {
	static final String EXAMPLE_UI = "abcd";

	@Override
	public void configure(Application application) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put(WebClient.PAGE_TITLE, "ABCD");

		application.addResource("administracion/user.png",
				
				new ResourceLoader() {
					@Override
					public InputStream getResourceAsStream(String resourceName)
							throws IOException {
						return this
								.getClass()
								.getClassLoader()
								.getResourceAsStream(
										"cu/uci/abos/platform/resources/vemarin.png");

					}
				});

		application.addResource("administracion/search.png",
				new ResourceLoader() {
					@Override
					public InputStream getResourceAsStream(String resourceName)
							throws IOException {
						return this
								.getClass()
								.getClassLoader()
								.getResourceAsStream(
										"cu/uci/abos/platform/resources/search.png");
					}
				});

		application.addResource("left-arrow", new ResourceLoader() {
			@Override
			public InputStream getResourceAsStream(String resourceName)
					throws IOException {
				return this
						.getClass()
						.getClassLoader()
						.getResourceAsStream(
								"cu/uci/abos/platform/resources/left.png");
			}
		});
		application.addResource("right-arrow", new ResourceLoader() {
			@Override
			public InputStream getResourceAsStream(String resourceName)
					throws IOException {
				return this
						.getClass()
						.getClassLoader()
						.getResourceAsStream(
								"cu/uci/abos/platform/resources/right.png");
			}
		});

		application.addResource("menu", new ResourceLoader() {
			@Override
			public InputStream getResourceAsStream(String resourceName)
					throws IOException {
				return this
						.getClass()
						.getClassLoader()
						.getResourceAsStream(
								"cu/uci/abos/platform/style/menu.xml");
			}
		});

		application.addEntryPoint("/", MainEntryPoint.class, properties);
		application.addStyleSheet(RWT.DEFAULT_THEME_ID,
				"cu/uci/abos/platform/style/theme.css");
		new ConfiguratorTracker(application, this);
	}
}
