/*
 * @(#)IContributorService.java 1.1.0 24/06/2014
 * Copyright (c) 2014 Universidad de las Ciencias Informaticas
 */
package cu.uci.abos.ui.api;

import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author Jose Rolando Lafaurie Olivares
 * @author Victor Marin Martinez
 * 
 * @version 1.1.0
 * 
 */
public interface IContributorService {
	/**
	 * Register the content parent when the contributors will be rendered
	 * 
	 * @param contentParent
	 *            The <code>Composite</code> instance container
	 */
	public void registerContentParent(Composite contentParent);

	/**
	 * Add <code>IContributorTracker</code> listener
	 * 
	 * @param moduleUIContributorTracker
	 *            The instance <code>IContributorTracker</code> that
	 *            will be added as listener of <code>IContributor</code>
	 */
	public void addContributorTracker(
			IContributorTracker contributorTracker);

	/**
	 * Remove <code>IContributorTracker</code> listener
	 * 
	 * @param moduleUIContributorTracker
	 *            The instance <code>IContributorTracker</code> that
	 *            will be removed as listener of
	 *            <code>IContributor</code>
	 */
	public void removeContributorTracker(
			IContributorTracker contributorTracker);

	/**
	 * 
	 * @return All contributors ID
	 */
	public String[] getContributorsID();

	/**
	 * Change the content of the platform with the content of the selected
	 * contributor
	 * 
	 * 
	 * @param contributorName
	 *            The name of the contributor that will be be selected
	 */
	public void selectContributor(String contributorName);

	/**
	 * Select the default contributor
	 */
	public void selectDefaultContributor();
	
	/**
	 * Internationalize opened contributions when language change
	 */
	public void l10n();
}
