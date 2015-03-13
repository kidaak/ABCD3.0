package cu.uci.abos.ui.api;

import org.osgi.framework.ServiceReference;

public interface IServiceTracker {
	void removedService(
			ServiceReference<IContributorFactory> reference,
			IContributor service);

	void addingService(ServiceReference<IContributorFactory> reference,
			IContributor service);
}
