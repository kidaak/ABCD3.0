package cu.uci.abos.widgets.grid.demo;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class FDTUpdateArea implements IEditableArea {

	private Map<String, Control> controls;
	
	public FDTUpdateArea() {
		this.controls = new HashMap<String, Control>();
	}
	
	@Override
	public Composite createUI(final Composite parent, IGridViewEntity entity, IVisualEntityManager manager) {
		
		FDTViewEntity fdtEntity = (FDTViewEntity)entity;
		GridLayout topGridLayout = new GridLayout(7, true);
		final Composite topGroup = new Composite(parent, SWT.NONE);
		topGroup.setLayout(topGridLayout);
		this.controls.put("topGroup", topGroup);

		Label tagLbl = new Label(topGroup, SWT.NONE);
		tagLbl.setText("Etiqueta");
		this.controls.put("tagLbl", tagLbl);
		
		Label nameLbl = new Label(topGroup, SWT.NONE);
		nameLbl.setText("Nombre");
		this.controls.put("nameLbl", nameLbl);
		
		Label typeLbl = new Label(topGroup, SWT.NONE);
		typeLbl.setText("Tipo");
		this.controls.put("typeLbl", typeLbl);
		
		Label indicatorsLbl = new Label(topGroup, SWT.NONE);
		indicatorsLbl.setText("Indicadores");
		GridData indicatorsLblGridData = new GridData();
		indicatorsLblGridData.horizontalAlignment = SWT.CENTER;
		indicatorsLbl.setLayoutData(indicatorsLblGridData);
		this.controls.put("indicatorsLbl", indicatorsLbl);
		
		Label repLbl = new Label(topGroup, SWT.NONE);
		repLbl.setText("Rep.");
		GridData repLblGridData = new GridData();
		repLblGridData.horizontalAlignment = SWT.CENTER;
		repLbl.setLayoutData(repLblGridData);
		this.controls.put("repLbl", repLbl);
		
		Label firstSubfieldLbl = new Label(topGroup, SWT.NONE);
		firstSubfieldLbl.setText("Primer subcampo");
		GridData firstSubfieldLblGridData = new GridData();
		firstSubfieldLblGridData.horizontalAlignment = SWT.CENTER;
		firstSubfieldLbl.setLayoutData(firstSubfieldLblGridData);
		this.controls.put("firstSubfieldLbl", firstSubfieldLbl);
		
		Label subfieldPatternLbl = new Label(topGroup, SWT.NONE);
		subfieldPatternLbl.setText("Subcampos/Patrón");
		this.controls.put("subfieldPatternLbl", subfieldPatternLbl);
		
		GridData nameGridData = new GridData();
		nameGridData.horizontalAlignment = SWT.FILL;
		nameGridData.grabExcessHorizontalSpace = true;
		
		Spinner tagSpn = new Spinner(topGroup, SWT.BORDER);
		tagSpn.setLayoutData(nameGridData);
		tagSpn.setValues(fdtEntity.getTag(), 0, Integer.MAX_VALUE, 0, 1, 1);
		this.controls.put("tagSpn", tagSpn);
		
		Text nameTxt = new Text(topGroup, SWT.BORDER);
		nameTxt.setLayoutData(nameGridData);
		nameTxt.setText(fdtEntity.getName());
		this.controls.put("nameTxt", nameTxt);
				
		Combo typeCmb = new Combo(topGroup, SWT.BORDER);
		typeCmb.setItems(new String[]{
				"ALPHANUMERIC",
				"ALPHABETIC",
				"NUMERIC",
				"PATTERN",
				"DATE",
				"TIME",
				"BLOB",
				"URL",
				"DOC"
		});
		typeCmb.setLayoutData(nameGridData);
		typeCmb.select(fdtEntity.getType());
		this.controls.put("typeCmb", typeCmb);
		
		Button indicatorsChk = new Button(topGroup, SWT.CHECK);
		GridData indicatorsChkGridData = new GridData();
		indicatorsChkGridData.horizontalAlignment = SWT.CENTER;
		indicatorsChk.setLayoutData(indicatorsChkGridData);
		indicatorsChk.setSelection(fdtEntity.isIndicators());
		this.controls.put("indicatorsChk", indicatorsChk);
		
		Button repChk = new Button(topGroup, SWT.CHECK);
		GridData repChkGridData = new GridData();
		repChkGridData.horizontalAlignment = SWT.CENTER;
		repChk.setLayoutData(repChkGridData);
		repChk.setSelection(fdtEntity.isRep());
		this.controls.put("repChk", repChk);
		
		Button firstSubfieldChk = new Button(topGroup, SWT.CHECK);
		GridData firstSubfieldChkGridData = new GridData();
		firstSubfieldChkGridData.horizontalAlignment = SWT.CENTER;
		firstSubfieldChk.setLayoutData(firstSubfieldChkGridData);
		firstSubfieldChk.setSelection(fdtEntity.isFirstSubfield());
		this.controls.put("firstSubfieldChk", firstSubfieldChk);
		
		Text subfieldPatternTxt = new Text(topGroup, SWT.BORDER);
		subfieldPatternTxt.setLayoutData(nameGridData);
		subfieldPatternTxt.setText(fdtEntity.getSubfieldPatterns());
		this.controls.put("subfieldPatternTxt", subfieldPatternTxt);
		
		return parent;
	}
	
	@Override
	public Composite createButtons(Composite parent, final IGridViewEntity entity, final IVisualEntityManager manager) {
		
		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Guardar");
		
		saveBtn.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				FDTViewEntity fdtEntity = (FDTViewEntity) entity;
				fdtEntity.setTag(Integer.parseInt(((Spinner)controls.get("tagSpn")).getText()));
				fdtEntity.setName(((Text)controls.get("nameTxt")).getText());
				fdtEntity.setType(((Combo)controls.get("typeCmb")).getSelectionIndex());
				fdtEntity.setIndicators(((Button)controls.get("indicatorsChk")).getSelection());
				fdtEntity.setRep(((Button)controls.get("repChk")).getSelection());
				fdtEntity.setFirstSubfield(((Button)controls.get("firstSubfieldChk")).getSelection());
				fdtEntity.setSubfieldPatterns(((Text)controls.get("subfieldPatternTxt")).getText());				
				manager.save(fdtEntity);	//salva visual.
				//TODO: invocar la salva en la clase de negocio.
			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				//do nothing
			}
		});
		
		return parent;
	}

	@Override
	public boolean isValid() {
		// TODO Iterar el mapa de controles y verificar su validez.
		return false;
	}

	@Override
	public Control getControl(String key) {
		return this.controls.get(key);
	}

	public void dispose() {
		for(Control control : controls.values()) {
			control.dispose();
		}
	}
}
