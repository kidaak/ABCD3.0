package cu.uci.abcd.administration.library.impl;

import java.util.Map;

import cu.uci.abcd.administration.library.IPenaltyEquationService;
import cu.uci.abcd.dao.common.PersonDAO;
import cu.uci.abcd.dao.management.library.PenaltyEquationDAO;
import cu.uci.abcd.domain.management.library.PenaltyEquation;

public class PenaltyEquationServiceImpl implements IPenaltyEquationService{

	private PenaltyEquationDAO penaltyEquationDAO;
	
	public void bind(PenaltyEquationDAO penaltyEquationDAO, Map<?, ?> properties) {
		this.penaltyEquationDAO = penaltyEquationDAO;
	}
	
	@Override
	public PenaltyEquation ReadPenaltyEquation(Long idLibrary) {
		return penaltyEquationDAO.findDistinctPenaltyEquationByOwner_ActorID(idLibrary);
	}

	@Override
	public PenaltyEquation AddPenaltyEquation(PenaltyEquation penaltyEquation) {
		return penaltyEquationDAO.save(penaltyEquation);
	}

}
