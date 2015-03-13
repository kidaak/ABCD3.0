package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IProviderService;
import cu.uci.abcd.dao.management.library.ProviderDAO;
import cu.uci.abcd.domain.management.library.Provider;

public class ProviderServiceImpl implements IProviderService{
	
	private ProviderDAO providerDAO;

	public void bind(ProviderDAO providerDAO, Map<?, ?> properties) {
		this.providerDAO = providerDAO;
	}
	
	@Override
	public Collection<Provider> findAll() {
		return (Collection<Provider>) providerDAO.findAll();
	}

	@Override
	public Provider AddProvider(Provider provider) {
		return providerDAO.save(provider);
	}

	@Override
	public Provider ReadProvider(Long idProvider) {
		return providerDAO.findOne(idProvider);
	}

	@Override
	public Provider UpdateProvider(Long idProvider) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteProvider(Long idProvider) {
		// TODO Auto-generated method stub
		
	}
	
}
