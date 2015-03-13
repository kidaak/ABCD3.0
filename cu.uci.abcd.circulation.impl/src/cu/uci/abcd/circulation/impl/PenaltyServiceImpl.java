package cu.uci.abcd.circulation.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import cu.uci.abcd.circulation.IPenaltyService;
import cu.uci.abcd.dao.circulation.PenaltyDAO;
import cu.uci.abcd.dao.management.library.CoinDAO;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abcd.domain.management.library.Coin;


public class PenaltyServiceImpl implements IPenaltyService {
    
	private PenaltyDAO penaltyDAO;
	private CoinDAO coinDAO;
	
	//RF_CI20_Penalty register
	@Override
	public Penalty addPenalty(Penalty penalty) {
		return penaltyDAO.save(penalty);
	}

	//RF_CI21_Penalty view
	@Override
	public Penalty viewPenalty(Long idPenalty) {
		Penalty guardar = penaltyDAO.findOne(idPenalty);
		return guardar;
	}

	//RF_CI22_Penalty edit
	@Override
	public Penalty editPenalty(Long idPenalty) {
		Penalty guardar = penaltyDAO.findOne(idPenalty);
		penaltyDAO.save(guardar);
		return guardar;
	}

	//RF_CI23_Penalty delete
	@Override
	public void deletePenalty(Long idPenalty) {
		Penalty eliminar = penaltyDAO.findOne(idPenalty);
		penaltyDAO.delete(eliminar);
	}

	//Penalty list
	@Override
	public Collection<Penalty> findAllPenalty() {
		return (Collection<Penalty>) penaltyDAO.findAll();
	}
	
	@Override
	public List<Coin> findAllCoin() {
		return (List<Coin>) coinDAO.findAll();
	}
	
	public void bind(PenaltyDAO penaltyDAO, Map<?, ?> properties) {
		this.penaltyDAO = penaltyDAO;
	}

	public void bind1(CoinDAO coinDAO, Map<?, ?> properties) {
		this.coinDAO = coinDAO;
	}

	@Override
	public Collection<Penalty> findPenaltybyLoanUser(Long idLoanUser) {
	    return penaltyDAO.findDistinctPenaltyByLoanUser_LoanUserID(idLoanUser);
	}


}
