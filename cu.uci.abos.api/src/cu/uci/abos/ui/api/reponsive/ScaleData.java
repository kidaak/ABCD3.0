package cu.uci.abos.ui.api.reponsive;

import java.util.HashMap;

import org.eclipse.swt.widgets.Control;

public class ScaleData {
	private final HashMap<Scale, ScaleDetail> scales;
	private final Control control;

	public ScaleData(Control control) {
		this.scales = new HashMap<Scale, ScaleDetail>();
		this.control = control;
		control.setLayoutData(this);
	}

	public Control getControl() {
		return control;
	}

	public ScaleDetail on(Scale scale) {
		if (!scales.containsKey(scale)) {
			scales.put(scale, new ScaleDetail(this, scale));
		}
		return scales.get(scale);
	}
}
