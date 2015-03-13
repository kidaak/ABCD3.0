package cu.uci.abos.ui.api.reponsive;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.swt.widgets.Composite;

public class ScaleProvider {
	final Composite composite;
	final Collection<ScaleListener> listeners;

	Scale scale;

	public ScaleProvider(Composite composite) {
		this.listeners = new HashSet<ScaleListener>();
		this.composite = composite;
	}

	public Scale getScale() {
		Scale oldScale = scale;
		scale = Scale.valueOf(composite.getSize().x);
		if (scale != oldScale) {
			notifyListeners(composite, scale, oldScale);
		}
		return scale;
	}

	public void addScaleListener(ScaleListener listener) {
		listeners.add(listener);
	}

	public void removeScaleListener(ScaleListener listener) {
		listeners.remove(listener);
	}

	private void notifyListeners(Composite composite, Scale newScale,
			Scale oldScale) {
		ScaleEvent event = new ScaleEvent(composite, newScale, oldScale);
		for (ScaleListener scaleListener : listeners) {
			scaleListener.scaleChanged(event);
		}
	}
}
