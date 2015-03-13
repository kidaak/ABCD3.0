package cu.uci.abcd.dao.acquisition;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.acquisition.Order;

public interface OrderDAO extends PagingAndSortingRepository<Order, Long> {

}
