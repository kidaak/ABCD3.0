package cu.uci.abos.ui.api.reponsive;

public enum Scale {
	SUPER_WIDE, WIDE, STANDARD, COMPACT, SUPER_COMPACT;

	static final int UPPER_BOUND_SUPER_COMPACT = 480;
	static final int UPPER_BOUND_COMPACT = 640;
	static final int UPPER_BOUND_STANDARD = 800;
	static final int UPPER_BOUND_WIDE = 1024;

	public static Scale valueOf(int width) {
		Scale result = Scale.SUPER_WIDE;
		if (width < UPPER_BOUND_SUPER_COMPACT) {
			result = SUPER_COMPACT;
		} else if (width < UPPER_BOUND_COMPACT) {
			result = COMPACT;
		} else if (width < UPPER_BOUND_STANDARD) {
			result = STANDARD;
		} else if (width < UPPER_BOUND_WIDE) {
			result = WIDE;
		}
		return result;
	}
}
