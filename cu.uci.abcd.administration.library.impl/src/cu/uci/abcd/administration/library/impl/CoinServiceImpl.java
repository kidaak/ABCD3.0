package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.ICoinService;
import cu.uci.abcd.administration.library.IProviderService;
import cu.uci.abcd.dao.management.library.CoinDAO;
import cu.uci.abcd.dao.management.library.ProviderDAO;
import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abcd.domain.management.library.Provider;

public class CoinServiceImpl implements ICoinService{
	
	private CoinDAO coinDAO;

	public void bind(CoinDAO coinDAO, Map<?, ?> properties) {
		this.coinDAO = coinDAO;
	}

	@Override
	public Collection<Coin> findAll() {
		return (Collection<Coin>) coinDAO.findAll();
	}

	@Override
	public Coin AddCoin(Coin coin) {
		return coinDAO.save(coin);
	}

	@Override
	public Coin ReadCoin(Long idCoin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coin UpdateCoin(Long idCoin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteCoin(Long idCoin) {
		// TODO Auto-generated method stub
		
	}
	
}
