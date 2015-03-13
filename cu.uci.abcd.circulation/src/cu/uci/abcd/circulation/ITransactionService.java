package cu.uci.abcd.circulation;

import java.util.Collection;

import cu.uci.abcd.domain.circulation.Transaction;

/**
 * 
 * @author Abelito
 * 
 */

public interface ITransactionService

{

	
public Transaction addTransaction(Transaction transaction);

public Transaction viewTransaction(Long idTransaction);
	
public Transaction editTransaction(Long idTransaction);
	
public void deleteTransaction(Long idTransaction);

public Collection<Transaction> findAllTransaction();

public Transaction findOneTransaction(Long idTransaction);


}
