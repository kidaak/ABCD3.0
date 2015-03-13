package cu.uci.abcd.circulation.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import cu.uci.abcd.circulation.ILoanUserService;
import cu.uci.abcd.dao.circulation.LoanUserDAO;
import cu.uci.abcd.dao.circulation.LoanUserTypeDAO;
import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.LoanUserType;


public class LoanUserServiceImpl implements ILoanUserService {
    
	private LoanUserDAO loanUserDAO;
	private LoanUserTypeDAO loanUserTypeDAO;
	
    /**
     * @see ILoanUserService
     */
	
	@Override
	public LoanUser addLoanUser(LoanUser loanUser) {
		return loanUserDAO.save(loanUser);
	}

	@Override
	public LoanUser viewLoanUser(Long idLoanUser) {
		LoanUser guardar = loanUserDAO.findOne(idLoanUser);
		return guardar;
	}

	@Override
	public LoanUser editLoanUser(Long idLoanUser) {
		LoanUser guardar = loanUserDAO.findOne(idLoanUser);
		loanUserDAO.save(guardar);
		return guardar;
	}

	
	@Override
	public void deleteLoanUser(Long idLoanUser) {
		LoanUser eliminar = loanUserDAO.findOne(idLoanUser);
		loanUserDAO.delete(eliminar);
	}

	@Override
	public Collection<LoanUser> findAll() {
		return (Collection<LoanUser>) loanUserDAO.findAll();
	}
	
	@Override
	public List<LoanUserType> findAllLoanUserType() {
		return (List<LoanUserType>) loanUserTypeDAO.findAll();
	}

	public void bind(LoanUserDAO loanUserDAO, Map<?, ?> properties) {
		this.loanUserDAO = loanUserDAO;
	}
	
	public void bind1(LoanUserTypeDAO loanUserTypeDAO, Map<?, ?> properties) {
		this.loanUserTypeDAO = loanUserTypeDAO;
	}

	@Override
	public LoanUser findOneLoanUser(Long idLoanUser) {
		return loanUserDAO.findOne(idLoanUser);
	}

	@Override
	public Collection<LoanUser> findByLoanUserName(String loanUserName) {
		return loanUserDAO.findDistinctByLoanUser(loanUserName);
	}

	@Override
	public LoanUser findByLoanUserCode(String loanUserCode) {
		return loanUserDAO.findDistinctLoanUserByLoanUserCode(loanUserCode);
	}

}
