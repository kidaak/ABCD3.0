package cu.uci.abcd.dao.management.library;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.management.library.Calendar;

public interface CalendarDAO extends PagingAndSortingRepository<Calendar, Long> {

}
