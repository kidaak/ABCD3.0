package cu.uci.abcd.dao.management.library;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.management.library.Coin;

public interface CoinDAO extends PagingAndSortingRepository<Coin, Long> {

}
