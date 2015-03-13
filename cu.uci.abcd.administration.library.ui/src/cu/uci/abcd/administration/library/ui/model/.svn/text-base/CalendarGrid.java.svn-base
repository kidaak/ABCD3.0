package cu.uci.abcd.administration.library.ui.model;

import java.util.List;

import cu.uci.abcd.domain.management.library.Calendar;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class CalendarGrid implements IGridViewEntity {

	private Calendar calendar;
	
	public CalendarGrid(Calendar calendar) {
		super();
		this.setCalendar(calendar);
	}
	
	public CalendarGrid() {
	}
	@TreeTableColumn(percentWidth = 33, index=0)
	public String getFecha() {
		return getCalendar().getFullDate().toString();
	}
	@TreeTableColumn(percentWidth = 33, index=1)
	public String getTitulo() {
		return getCalendar().getTitle();
	}
	@TreeTableColumn(percentWidth = 34, index=2)
	public String getDescripcion() {
		return getCalendar().getDescription();
	}
	@Override
	public void addChild(IGridViewEntity child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	
}
