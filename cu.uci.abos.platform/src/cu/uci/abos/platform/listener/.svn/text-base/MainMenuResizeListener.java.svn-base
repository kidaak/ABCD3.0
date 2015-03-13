package cu.uci.abos.platform.listener;

import java.io.InputStream;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class MainMenuResizeListener implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainMenuResizeListener() {

	}

	@Override
	public void handleEvent(Event e) {
		Composite composite = ((Button) e.widget).getParent();
		FormData temporalData = (FormData) composite.getLayoutData();
		Button button = (Button) e.widget;
		if (temporalData.width == 270) {

			FormData data = (FormData) button.getLayoutData();
			data.left = new FormAttachment(10);
			button.setLayoutData(data);

			InputStream src = RWT.getResourceManager().getRegisteredContent(
					"right-arrow");
			Image image = new Image(Display.getCurrent(), src);
			button.setBackgroundImage(image);
			
			composite.setLayoutData(temporalData);
			Composite temp=((Button)e.widget).getParent();
			
			Control[]hijosControls=temp.getChildren();
			hijosControls[1].setVisible(false);
			FormData data2=(FormData)temp.getLayoutData();
			Integer height=data2.height;
			temporalData.width = 25;
			composite.setSize(25, height);

			composite.getShell().layout(true, true);
			composite.getShell().redraw();
			composite.getShell().update();

		} else {

			FormData data = (FormData) button.getLayoutData();
			data.left = new FormAttachment(composite, 240);
			button.setLayoutData(data);

			InputStream src = RWT.getResourceManager().getRegisteredContent(
					"left-arrow");
			Image image = new Image(Display.getCurrent(), src);
			button.setBackgroundImage(image);
			

			temporalData.width = 270;
			composite.setLayoutData(temporalData);
			Composite temp=((Button)e.widget).getParent();
			Control[]hijosControls=temp.getChildren();
			hijosControls[1].setVisible(true);
			FormData data2=(FormData)temp.getLayoutData();
			Integer height=data2.height;
			composite.setSize(270, height);

			composite.getShell().layout(true, true);
			composite.getShell().redraw();
			composite.getShell().update();

		}

	}

}
