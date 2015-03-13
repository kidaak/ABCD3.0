package cu.uci.abcd.administration.library.ui.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class _ProviderUpdateArea implements IEditableArea {

	private Map<String, Control> controls;
	
	public _ProviderUpdateArea() {
		this.controls = new HashMap<String, Control>();
	}
	
	@Override
	public Composite createUI(final Composite parent, IGridViewEntity entity, IVisualEntityManager manager) {
		
		ProviderGrid fdtEntity = (ProviderGrid)entity;
		
		GridData nameGridData = new GridData();
		nameGridData.horizontalAlignment = SWT.FILL;
		nameGridData.grabExcessHorizontalSpace = true;
		
		FormLayout form = new FormLayout();
		parent.setLayout(form);
		Composite topGroup= new Composite(parent, SWT.NORMAL);
		topGroup.setLayout(form);
		FormDatas.attach(topGroup).atLeftTo(parent, 5);
		
		Label providerNameLabel = new Label(topGroup, SWT.NONE);
		providerNameLabel.setText("Nombre del Provedor");
		FormDatas.attach(providerNameLabel).atTopTo(topGroup,10);
		this.controls.put("providerNameLabel", providerNameLabel);
		
		Text providerNameText = new Text(topGroup, SWT.BORDER);
		providerNameText.setLayoutData(nameGridData);
		providerNameText.setText(fdtEntity.getProviderName());
		FormDatas.attach(providerNameText).atTopTo(providerNameLabel,2);
		this.controls.put("providerNameText", providerNameText);
		
		Label providerIdLabel = new Label(topGroup, SWT.NONE);
		providerIdLabel.setText("Identificacion");
		FormDatas.attach(providerIdLabel).atTopTo(topGroup,10).atLeftTo(providerNameText,20);
		this.controls.put("providerIdLabel", providerIdLabel);
				
		Text providerIdText = new Text(topGroup, SWT.BORDER);
		providerIdText.setLayoutData(nameGridData);
		providerIdText.setText(fdtEntity.getProviderId());
		FormDatas.attach(providerIdText).atTopTo(providerIdLabel,2).atLeftTo(providerNameText,20);
		this.controls.put("providerIdText", providerIdText);
		
		Label providerAddresLabel = new Label(topGroup, SWT.NONE);
		providerAddresLabel.setText("Direcion");
		FormDatas.attach(providerAddresLabel).atTopTo(topGroup,10).atLeftTo(providerIdText,20);
		this.controls.put("providerAddresLabel", providerAddresLabel);
		
		Text providerAddresText = new Text(topGroup, SWT.BORDER);
		providerAddresText.setLayoutData(nameGridData);
		providerAddresText.setText(fdtEntity.getProviderAddrees());
		FormDatas.attach(providerAddresText).atTopTo(providerAddresLabel,2).atLeftTo(providerIdText,20);
		this.controls.put("providerAddresText", providerAddresText);
		
		Label providerTypeLabel = new Label(topGroup, SWT.NONE);
		providerTypeLabel.setText("Tipo Provedor");
		FormDatas.attach(providerTypeLabel).atTopTo(topGroup,10).atLeftTo(providerAddresText,20);
		this.controls.put("providerTypeLabel", providerTypeLabel);
		
		Combo providerTypeCombo = new Combo(topGroup, SWT.BORDER);
		providerTypeCombo.setItems(new String[]{
				"Comercial",
				"Privado",
				"Particular"
		});
		providerTypeCombo.setLayoutData(nameGridData);
		String[] itemsProviderType = providerTypeCombo.getItems();
		int posProviderType = -1;
		for (int i = 0; i < itemsProviderType.length; i++) {
			if( itemsProviderType[i] == fdtEntity.getProviderType()){
				posProviderType = i;
			}
		}
		providerTypeCombo.select(posProviderType);
		FormDatas.attach(providerTypeCombo).atTopTo(providerTypeLabel,2).atLeftTo(providerAddresText,20);
		this.controls.put("providerTypeCombo", providerTypeCombo);
		
		Label providerStateLabel = new Label(topGroup, SWT.NONE);
		providerStateLabel.setText("Estado");
		FormDatas.attach(providerStateLabel).atTopTo(topGroup,10).atLeftTo(providerTypeCombo,20);
		this.controls.put("providerStateLabel", providerStateLabel);
		
		Combo providerStateCombo = new Combo(topGroup, SWT.BORDER);
		providerStateCombo.setItems(new String[]{
				"Activo",
				"Inactivo"
		});
		providerStateCombo.setLayoutData(nameGridData);
		String[] itemsProviderState = providerStateCombo.getItems();
		int posProviderState = -1;
		for (int i = 0; i < itemsProviderState.length; i++) {
			if( itemsProviderState[i] == fdtEntity.getProviderState()){
				posProviderState = i;
			}
		}
		providerStateCombo.select(posProviderState);
		FormDatas.attach(providerStateCombo).atTopTo(providerStateLabel,2).atLeftTo(providerTypeCombo,20);
		this.controls.put("providerStateCombo", providerStateCombo);
		
		
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
				ProviderGrid fdtEntity = (ProviderGrid) entity;
				fdtEntity.setProviderName(((Text)controls.get("providerNameText")).getText());
				fdtEntity.setProviderId(((Text)controls.get("providerIdText")).getText());
				fdtEntity.setProviderAddrees(((Text)controls.get("providerAddresText")).getText());
				//fdtEntity.setProviderType(((Combo)controls.get("providerTypeCombo")).getSelectionIndex());
				
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
