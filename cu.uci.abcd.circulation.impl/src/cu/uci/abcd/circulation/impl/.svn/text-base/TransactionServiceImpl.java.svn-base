package cu.uci.abcd.circulation.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.circulation.ITransactionService;
import cu.uci.abcd.dao.circulation.TransactionDAO;
import cu.uci.abcd.domain.circulation.Transaction;


/**
 * 
 * @author Abelito
 * 
 */
public class TransactionServiceImpl implements ITransactionService
{

	private TransactionDAO transactionDAO;
	
	@Override
	public Transaction addTransaction(Transaction transaction)
	{
		return transactionDAO.save(transaction);
	}

	@Override
	public Transaction viewTransaction(Long idTransaction) 
	{
	Transaction ver= transactionDAO.findOne(idTransaction);
		return ver;
	}

	@Override
	public Transaction editTransaction(Long idTransaction)
	{
	Transaction editar= transactionDAO.findOne(idTransaction);
	transactionDAO.save(editar);
	return editar;
	}

	@Override
	public void deleteTransaction(Long idTransaction) 
	{
	Transaction eliminar = transactionDAO.findOne(idTransaction);
	transactionDAO.delete(eliminar);	
	}

	@Override
	public Collection<Transaction> findAllTransaction()
	{
	return (Collection<Transaction>) transactionDAO.findAll();
	}
	 
	@Override
	public Transaction findOneTransaction(Long idTransaction)
	{
		return transactionDAO.findOne(idTransaction);
	}
	
	public void bind(TransactionDAO transactionDAO, Map<?, ?> properties) {
		this.transactionDAO = transactionDAO;
	}
}
