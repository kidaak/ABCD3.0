package cu.uci.abcd.domain.management.library;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dcalendar", schema = "abcd")
public class Calendar {
	@Id
	@TableGenerator(name = "CALENDAR_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "CALENDAR_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CALENDAR_GEN")
	@Column(name = "calendar_id")
	private Long calendarID;
	@Column(name = "full_date", nullable = false)
	private Date fullDate;
	@Column(name = "title", nullable = false, length = 255)
	private String title;
	@Column(name = "description", nullable = false, length = 500)
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(name = "holiday_day_type", nullable = false)
	private HolidayDayType holidayDayType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_library_id", nullable = false)
	private Library ownerLibrary;

	public Long getCalendarID() {
		return calendarID;
	}

	public void setCalendarID(Long calendarID) {
		this.calendarID = calendarID;
	}

	public Date getFullDate() {
		return fullDate;
	}

	public void setFullDate(Date fullDate) {
		this.fullDate = fullDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HolidayDayType getHolidayDayType() {
		return holidayDayType;
	}

	public void setHolidayDayType(HolidayDayType holidayDayType) {
		this.holidayDayType = holidayDayType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((calendarID == null) ? 0 : calendarID.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendar other = (Calendar) obj;
		if (this.calendarID == null) {
			if (other.getCalendarID() != null) {
				return false;
			}
		}
		if (!calendarID.equals(other.getCalendarID())) {
			return false;
		}
		return true;
	}

	public Library getOwnerLibrary() {
		return ownerLibrary;
	}

	public void setOwnerLibrary(Library ownerLibrary) {
		this.ownerLibrary = ownerLibrary;
		if (!ownerLibrary.getCalendarList().contains(this)) {
			ownerLibrary.getCalendarList().add(this);
		}
	}

}
