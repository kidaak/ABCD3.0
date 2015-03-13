/*
 * @(#)IContributorFactory.java 1.0.0 20/06/2014
 * Copyright (c) 2014 Universidad de las Ciencias Informaticas
 */
package cu.uci.abos.ui.api;

import java.lang.reflect.InvocationTargetException;

import org.osgi.framework.ServiceReference;

import cu.uci.abos.api.exception.AbosInstantiationException;

/**
 * 
 * @author Jose Rolando Lafaurie Olivares
 * @version 1.0.0 20/06/2014
 */
public interface IContributorFactory {
	/**
	 *  
	 * @return The new instance of <code>IContributor</code>
	 * @throws AbosInstantiationException
	 * @see IContributor
	 */
	public IContributor create() throws AbosInstantiationException;

	/**
	 * 
	 * @param contributor
	 *            The new instance of <code>IContributor</code>
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void injectViewController(IContributor contributor)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException;

	/**
	 * Gets all necessary values from its service reference
	 * 
	 * @param contributorServiceReference
	 *            The instance of
	 *            <code>ServiceReference<IContributorFactory></code> that
	 *            contains the service values
	 * @throws ClassNotFoundException
	 */
	public void injectServiceReference(
			ServiceReference<IContributorFactory> contributorServiceReference)
			throws ClassNotFoundException;
}
