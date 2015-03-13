package cu.uci.abcd.domain.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class DomainUtil {
	public static final Date CURRENT_DATE;
	public static final Timestamp CURRENT_TIMESTAMP;
	public static final String SEQUENCE_TABLE_NAME = "dsequencetable";
	public static final String SEQUENCE_TABLE_PK_COLUMN_NAME = "sequence_name";
	public static final String SEQUENCE_TABLE_VALUE_COLUMN_NAME = "sequence_count";
	static {
		CURRENT_DATE = new Date(Calendar.getInstance().getTime().getTime());
		CURRENT_TIMESTAMP = new Timestamp(Calendar.getInstance().getTime()
				.getTime());
	}

	public static int hashCodeGenerator(int[] codes) {
		final int prime = 31;
		int result = 1;
		for (int i = 0; i < codes.length; i++) {
			result += prime * result + codes[i];
		}
		return result;
	}
}
