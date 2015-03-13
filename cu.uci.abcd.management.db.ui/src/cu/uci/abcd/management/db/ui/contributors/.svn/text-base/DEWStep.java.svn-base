/*package cu.uci.abcd.management.db.ui.contributors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;
import cu.uci.abos.widgets.wizard.BaseStep;
import cu.uci.abos.widgets.wizard.IStep;
import cu.uci.abos.widgets.wizard.Wizard;


public abstract class DEWStep extends BaseStep implements IStep {

    public DEWStep(Wizard wizard) {
	super(wizard);
    }

    @Override
    public boolean isValid() {
	// for(Control control : this.controls.values()) {
	// TODO: validation logic here.
	// }
	return true;
    }

    public Control createUI(Composite parent) {
/*
	parent.setLayout(new GridLayout(1, true));

	GridLayout topGridLayout = new GridLayout(8, false);
	GridData topGridDataMenu = new GridData(GridData.FILL, GridData.CENTER, false, false);
	Group topGroupMenu = new Group(parent, SWT.NONE);
	topGroupMenu.setText("Acciones");
	topGroupMenu.setLayout(topGridLayout);
	topGroupMenu.setLayoutData(topGridDataMenu);

	Label selectLabel = new Label(topGroupMenu, SWT.NONE);
	selectLabel.setText("Seleccione:");

	Combo wdCmb = new Combo(topGroupMenu, SWT.BORDER);
	wdCmb.setItems(new String[] { "eber_worksheet", "otro_worksheet", });
	wdCmb.setText("eber_worksheet");

	Label separator = new Label(topGroupMenu, SWT.PUSH);
	separator.setText("    ");

	Button newBtn = new Button(topGroupMenu, SWT.PUSH);
	newBtn.setText("Nuevo");

	Button deleteBtn = new Button(topGroupMenu, SWT.PUSH);
	deleteBtn.setText("Eliminar");

	Button restoreBtn = new Button(topGroupMenu, SWT.PUSH);
	restoreBtn.setText("Restaurar");

	Button saveBtn = new Button(topGroupMenu, SWT.PUSH);
	saveBtn.setText("Salvar");

	Button closeBtn = new Button(topGroupMenu, SWT.PUSH);
	closeBtn.setText("Cerrar");

	FillLayout topFillLayout = new FillLayout();
	GridData topGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
	Group topGroup = new Group(parent, SWT.NONE);
	topGroup.setText("Campos disponibles");
	topGroup.setLayout(topFillLayout);
	topGroup.setLayoutData(topGridData);

	List<FDTViewEntity> fieldDefinitions = new LinkedList<FDTViewEntity>(Arrays.asList(new FDTViewEntity(12, "Conference main entry", 0, false, false, true, "npdz"), new FDTViewEntity(24,
		"Title", 0, false, false, true, "z"), new FDTViewEntity(25, "Edition", 0, false, false, false, ""), new FDTViewEntity(26, "Imprint", 0, false, false, false, "abc"), new FDTViewEntity(
		30, "Collation", 0, false, false, false, "abc"), new FDTViewEntity(44, "Series", 0, false, true, false, "vz"), new FDTViewEntity(50, "Notes", 0, false, false, false, ""),
		new FDTViewEntity(69, "Keywords", 0, false, false, false, ""), new FDTViewEntity(70, "Personal Authors", 0, false, true, false, ""), new FDTViewEntity(71, "Corporate Bodies", 0,
			false, true, false, ""), new FDTViewEntity(72, "Meetings", 0, false, true, false, "npdz"), new FDTViewEntity(74, "Added Title", 0, false, true, false, "z"), new FDTViewEntity(
			76, "Other languages titles", 0, false, true, false, "z")));

	CRUDTreeTable fdt = new CRUDTreeTable(topGroup, FDTViewEntity.class, false, false, false);

	for (FDTViewEntity entity : fieldDefinitions) {
	    fdt.addRow(entity);
	}

	fdt.setEditonArea(new FDTEditionArea());

	fdt.addUpdateListener(new TreeColumnListener() {
	    public void handleEvent(TreeColumnEvent event) {
		// do something.
	    }
	});

	fdt.addDeleteListener(new TreeColumnListener() {
	    public void handleEvent(TreeColumnEvent event) {
		// do something.
	    }
	});

	Composite middleButtons = new Composite(parent, SWT.NONE);
	RowLayout rowLayout = new RowLayout();
	middleButtons.setLayout(rowLayout);
	GridData middleButtonsGridData = new GridData(GridData.END, GridData.CENTER, true, false);
	middleButtonsGridData.horizontalAlignment = SWT.LEFT;
	middleButtons.setLayoutData(middleButtonsGridData);

	Button selectAllBtn = new Button(middleButtons, SWT.PUSH);
	selectAllBtn.setText("Seleccionar todos");

	Button deselectAllBtn = new Button(middleButtons, SWT.PUSH);
	deselectAllBtn.setText("Deseleccionar todos");

	FillLayout middleFillLayout = new FillLayout();
	GridData middleGridData = new GridData(GridData.FILL, GridData.CENTER, true, true);
	middleGridData.minimumHeight = 200;
	Group middleGroup = new Group(parent, SWT.NONE);
	middleGroup.setText("Definición de la hoja de trabajo");
	middleGroup.setLayout(middleFillLayout);
	middleGroup.setLayoutData(middleGridData);

	CRUDTreeTable wd = new CRUDTreeTable(middleGroup, DEWViewEntity.class, true, true, true);

	TreeItem tag12 = wd.addRow(new DEWViewEntity(fieldDefinitions.get(0), "", "", "", "", "Enter Conference title^nnumber^pplace^ddate with no punctuation before or after subfields", "", ""));
	TreeItem tag24 = wd.addRow(new DEWViewEntity(fieldDefinitions.get(1), "", "", "", "", "Enter title in english^aPlace of  publication^bPublisher^cDate", "", ""));
	wd.addRow(new DEWViewEntity(fieldDefinitions.get(2), "", "", "", "", "", "", ""));
	TreeItem tag26 = wd.addRow(new DEWViewEntity(fieldDefinitions.get(3), "", "", "", "", "", "", ""));
	TreeItem tag30 = wd.addRow(new DEWViewEntity(fieldDefinitions.get(4), "", "", "", "", "", "", ""));
	wd.addRow(new DEWViewEntity(fieldDefinitions.get(8), "", "", "", "", "", "", ""));

	wd.addInnerRow(tag12, new DEWViewEntity(new FDTViewEntity(71, "Name of meeting", 1, false, false, false, ""), "$*", "", "", "", "", "", ""));
	wd.addInnerRow(tag12, new DEWViewEntity(new FDTViewEntity(72, "Number of meeting", 1, false, false, false, ""), "$n", "", "", "", "", "", ""));
	wd.addInnerRow(tag12, new DEWViewEntity(new FDTViewEntity(73, "Place of meeting", 1, false, false, false, ""), "$p", "", "", "", "", "", ""));
	wd.addInnerRow(tag12, new DEWViewEntity(new FDTViewEntity(74, "Date of meeting", 1, false, false, false, ""), "$d", "", "", "", "", "", ""));
	wd.addInnerRow(tag12, new DEWViewEntity(new FDTViewEntity(75, "Geographic subdivision", 1, false, false, false, ""), "$z", "", "", "", "", "", ""));

	wd.addInnerRow(tag24, new DEWViewEntity(new FDTViewEntity(76, "Title", 1, false, false, false, ""), "$*", "", "", "", "", "", ""));
	wd.addInnerRow(tag24, new DEWViewEntity(new FDTViewEntity(75, "Geographic subdivision", 1, false, false, false, ""), "$z", "", "", "", "", "", ""));

	wd.addInnerRow(tag26, new DEWViewEntity(new FDTViewEntity(77, "Place of publication", 1, false, false, false, ""), "$a", "", "", "", "", "", ""));
	wd.addInnerRow(tag26, new DEWViewEntity(new FDTViewEntity(78, "Publisher", 1, false, false, false, ""), "$b", "", "", "", "", "", ""));
	wd.addInnerRow(tag26, new DEWViewEntity(new FDTViewEntity(79, "Date of publication", 1, false, false, false, ""), "$c", "", "", "", "", "", ""));

	wd.addInnerRow(tag30, new DEWViewEntity(new FDTViewEntity(75, "Extent of item", 1, false, false, false, ""), "$a", "", "", "", "", "", ""));
	wd.addInnerRow(tag30, new DEWViewEntity(new FDTViewEntity(75, "Other phisical details", 1, false, false, false, ""), "$b", "", "", "", "", "", ""));
	wd.addInnerRow(tag30, new DEWViewEntity(new FDTViewEntity(75, "Dimensions", 1, false, false, false, ""), "$c", "", "", "", "", "", ""));

	FillLayout bottomFillLayout = new FillLayout();
	GridData bottomGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
	Group bottomGroup = new Group(parent, SWT.NONE);
	bottomGroup.setText("Validación a nivel de registro");
	bottomGroup.setLayout(bottomFillLayout);
	bottomGroup.setLayoutData(bottomGridData);

	new Text(bottomGroup, SWT.BORDER);

	parent.pack();

	return parent;
    }
}
*/