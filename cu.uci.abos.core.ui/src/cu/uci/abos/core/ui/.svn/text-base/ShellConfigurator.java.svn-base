/*
 * @(#)ShellConfigurator.java 1.0.0 12/09/2014 
 * Copyright (c) 2014 Universidad de las Ciencias Informaticas
 */
package cu.uci.abos.core.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.ServiceReference;

import cu.uci.abos.core.ui.internal.ContributorServiceImpl;
import cu.uci.abos.core.ui.internal.LayoutContextImpl;
import cu.uci.abos.ui.api.ConfiguratorTracker;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IContributorFactory;
import cu.uci.abos.ui.api.IContributorService;
import cu.uci.abos.ui.api.ILayoutProvider;
import cu.uci.abos.ui.api.IPlatformContributor;
import cu.uci.abos.util.api.IServiceProvider;

public class ShellConfigurator {
	private static final String UI_CONTRIBUTOR_TYPE_PAGE = "abcd";

	private final IServiceProvider serviceProvider;
	private List<String> contributionList;
	private boolean securityEnabled;

	public ShellConfigurator(IServiceProvider serviceProvider,
			boolean securityEnabledParam) {
		this.serviceProvider = serviceProvider;
		contributionList = new ArrayList<>();
		this.securityEnabled = securityEnabledParam;
	}

	public Shell configure(IPlatformContributor[] pageStructureProviders,
			ILayoutProvider layoutProvider) {
		LayoutContextImpl layoutContext = new LayoutContextImpl();
		ContributorServiceImpl pageService = new ContributorServiceImpl(
				layoutProvider, layoutContext);
		serviceProvider.register(IContributorService.class, pageService);
		trackContributions(pageService);

		ShellProvider shellProvider = new ShellProvider(pageStructureProviders,
				layoutProvider, layoutContext);
		return shellProvider.createShell();
	}

	private void trackContributions(final ContributorServiceImpl pageService) {
		new ContributorTracker() {

			private boolean initialized;

			@Override
			public void addingService(
					ServiceReference<IContributorFactory> reference,
					IContributor contributor) {
				if (ConfiguratorTracker.matchesType(UI_CONTRIBUTOR_TYPE_PAGE,
						reference)) {
					if (securityEnabled) {
						if (contributionList.contains(contributor.getID())) {
							pageService.addUIContributor(contributor);
							if (!initialized) {
								pageService.selectDefaultContributor();								
							}
						}
					} else {
						pageService.addUIContributor(contributor);
					}
					
					initialized = true;
				}
			}

			@Override
			public void removedService(
					ServiceReference<IContributorFactory> reference,
					IContributor service) {
				if (ConfiguratorTracker.matchesType(UI_CONTRIBUTOR_TYPE_PAGE,
						reference)) {
					pageService.removeUIContributor(service);
				}
			}
		};
	}

	public List<String> getContributionList() {
		return contributionList;
	}

	public void setContributionList(List<String> contributionList) {
		this.contributionList = contributionList;
	}

	public void addContributorID(String contributorID) {
		contributionList.add(contributorID);
	}
}
