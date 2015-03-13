package cu.uci.abcd.circulation.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.circulation.IReservationService;
import cu.uci.abcd.domain.circulation.Reservation;
import cu.uci.abcd.dao.circulation.ReservationDAO;

/**
 * 
 * @author Abelito
 * 
 */
public class ReservationServiceImpl implements IReservationService 
{

	private ReservationDAO reservationDAO;
	
	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationDAO.save(reservation);
	}

	@Override
	public Reservation viewReservation(Long idReservation) 
	{
	Reservation ver= reservationDAO.findOne(idReservation);
	return ver;
	}

	@Override
	public Reservation editReservation(Long idReservation)
	{
	Reservation editar= reservationDAO.findOne(idReservation);
	reservationDAO.save(editar);
	return editar;
	}

	@Override
	public void deleteReservation(Long idReservation) 
	{
	Reservation eliminar = reservationDAO.findOne(idReservation);
	reservationDAO.delete(eliminar);	
	}

	@Override
	public Collection<Reservation> findAllReservation()
	{
	return (Collection<Reservation>) reservationDAO.findAll();
	}
	 
	@Override
	public Reservation findOneReservation(Long idReservation)
	{
		return reservationDAO.findOne(idReservation);
	}
	
	public void bind(ReservationDAO reservationDAO, Map<?, ?> properties) {
		this.reservationDAO = reservationDAO;
	}
    
}
