package cu.uci.abcd.administration.library;

import java.util.Collection;

import cu.uci.abcd.domain.management.library.Coin;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface ICoinService {
	
	public Coin AddCoin(Coin coin);
	
	public Coin ReadCoin(Long idCoin);
	
	public Coin UpdateCoin(Long idCoin);
	
	public void DeleteCoin(Long idCoin);
	
	public Collection<Coin> findAll();
	
}
