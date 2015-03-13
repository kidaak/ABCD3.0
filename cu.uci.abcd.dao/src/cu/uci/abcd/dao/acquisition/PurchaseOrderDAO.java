package cu.uci.abcd.dao.acquisition;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.acquisition.PurchaseOrder;

public interface PurchaseOrderDAO extends
		PagingAndSortingRepository<PurchaseOrder, Long> {

}
