package cu.uci.abcd.circulation;

import java.util.Collection;
import java.util.List;

import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abcd.domain.management.library.Coin;

public interface IPenaltyService {
	
	public Penalty addPenalty(Penalty penalty);
	
	public Penalty viewPenalty(Long idPenalty);
		
	public Penalty editPenalty(Long idPenalty);
		
	public void deletePenalty(Long idPenalty);
	
	public Collection<Penalty> findAllPenalty();
	
	public List<Coin> findAllCoin();
	
	public Collection<Penalty> findPenaltybyLoanUser(Long idLoanUser);
	

}
