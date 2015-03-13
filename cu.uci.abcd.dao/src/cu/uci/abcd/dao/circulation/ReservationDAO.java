package cu.uci.abcd.dao.circulation;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.circulation.Reservation;

public interface ReservationDAO extends
		PagingAndSortingRepository<Reservation, Long> {

}
