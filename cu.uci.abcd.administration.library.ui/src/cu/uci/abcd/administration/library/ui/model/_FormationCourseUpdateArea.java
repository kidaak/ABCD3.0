package cu.uci.abcd.administration.library.ui.model;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class _FormationCourseUpdateArea implements IEditableArea {

	@Override
	public Composite createUI(Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {
		// TODO Auto-generated method stub
		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Guardar");
		return parent;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Control getControl(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
