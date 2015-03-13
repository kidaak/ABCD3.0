package cu.uci.abcd.administration.library;
import cu.uci.abcd.domain.management.library.PenaltyEquation;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface IPenaltyEquationService {

	public PenaltyEquation AddPenaltyEquation(PenaltyEquation penaltyEquation);
	
	public PenaltyEquation ReadPenaltyEquation(Long idLibrary);
}
