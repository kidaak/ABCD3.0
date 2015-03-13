package cu.uci.cu.administration.nomenclators.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.nomenclators.controller.ControllerNomenclator;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abcd.domain.common.Nomenclator;
import cu.uci.abcd.domain.common.RecordType;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.util.api.MessageDialogUtil;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

/**
 * 
 * @author Dayana Rivera
 *
 */

public class NomenclatorUpdateEditableArea implements IEditableArea{
	private Map<String, Control> controls;
	private IViewController controller;
	Combo comboNomenclatorType;
	NomenclatorGrid fdtEntity ;
	
	public NomenclatorUpdateEditableArea(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller= controller;
	}
	
	@Override
	public Composite createUI(final Composite parent, IGridViewEntity entity, IVisualEntityManager manager) {
		
		fdtEntity = (NomenclatorGrid) entity;
		
		FormLayout form = new FormLayout();
		parent.setLayout(form);
		FormDatas.attach(parent).atLeft(0).atRight(0);
		
		Composite topGroup= new Composite(parent, SWT.NORMAL);
		topGroup.setLayout(form);
		FormDatas.attach(topGroup).atLeft(0).atRight(0);
		
		Label headerLabel= new Label(topGroup, SWT.NORMAL);
		headerLabel.setText("MODIFICAR NOMENCLADOR");
		FormDatas.attach(headerLabel).atTopTo(topGroup, 10).atLeftTo(topGroup, 10);
		
		Label separator = new Label(topGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separator).atTopTo(headerLabel, 10).atLeft(5).atRight(5);
		
		Label nomenclatorData = new Label(topGroup, SWT.NORMAL);
		nomenclatorData.setText("Datos del Nomenclador");
		FormDatas.attach(nomenclatorData).atTopTo(separator, 10).atLeftTo(topGroup, 10);
		
		
		//Table Nomenclator Data
		
		Table nomenclatorTable= new Table(topGroup, SWT.BORDER|SWT.FULL_SELECTION);
		FormDatas.attach(nomenclatorTable).atTopTo(nomenclatorData, 10).atLeftTo(topGroup, 10);
		nomenclatorTable.setTouchEnabled(true);

		TableColumn tabc8 = new TableColumn(nomenclatorTable, SWT.None);
	       tabc8.setWidth(150);
	    TableColumn tabc6 = new TableColumn(nomenclatorTable, SWT.None);
		   tabc6.setWidth(180);
	    
		TableItem item9= new TableItem(nomenclatorTable, SWT.NONE);
		item9.setText(0,"Tipo de Nomenclador");
		item9.setText(1,fdtEntity.getNomenclatorType());
		

		TableItem item7= new TableItem(nomenclatorTable, SWT.NONE);
		item7.setText(0,"Usado");
		item7.setText(1, fdtEntity.getNomenclatorU());
		

		nomenclatorTable.setLinesVisible(true);
		
		
		Label nomenclatorName=  new Label(topGroup, SWT.NONE);
		nomenclatorName.setText("Valor del Nomenclador");
		FormDatas.attach(nomenclatorName).atTopTo(nomenclatorTable,10).atLeftTo(topGroup, 10);
	
		Text textNomenclatorName = new Text(topGroup, SWT.BORDER);
		textNomenclatorName.setText(fdtEntity.getNomeclatorName());
		FormDatas.attach(textNomenclatorName).atTopTo(nomenclatorName, 10).withWidth(100).atLeftTo(topGroup, 10);
		controls.put("textNomenclatorName", textNomenclatorName);
		
		
		Label nomenclatorDescription = new Label(topGroup, SWT.NONE);
		nomenclatorDescription.setText("Descripcion");
		FormDatas.attach(nomenclatorDescription).atTopTo(textNomenclatorName,10).atLeftTo(topGroup, 10);
		
		Text textNomenclatorDescription = new Text(topGroup, SWT.BORDER |SWT.WRAP| SWT.V_SCROLL);
		textNomenclatorDescription.setText(fdtEntity.getNomenclatorDescription());
		FormDatas.attach(textNomenclatorDescription).atTopTo(nomenclatorDescription,10).atRight(10).atLeft(10).withHeight(50);
		controls.put("textNomenclatorDescription", textNomenclatorDescription);
		
		return parent;
	}
	

	@Override
	public Composite createButtons( Composite parent, final IGridViewEntity entity, final IVisualEntityManager manager) {
		
		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Actualizar");
		
		
		
		saveBtn.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				

					Nomenclator auxNomenclator= ((ControllerNomenclator) controller).SearchNomenclator(fdtEntity.getNomenclatorID());
					auxNomenclator.setNomeclatorName(((Text)controls.get("textNomenclatorName")).getText());
					auxNomenclator.setNomenclatorDescription(((Text)controls.get("textNomenclatorDescription")).getText());
					((ControllerNomenclator) controller)
							.RegisterNomenclator(auxNomenclator);
					fdtEntity.setNomeclatorName(((Text)controls.get("textNomenclatorName")).getText());
					fdtEntity.setNomenclatorDescription(((Text)controls.get("textNomenclatorDescription")).getText());
					manager.save((IGridViewEntity) fdtEntity);
				
				// clean the controls
				((Text) controls.get("textNomenclatorName")).setText("");
				((Text) controls.get("textNomenclatorDescription")).setText("");
				
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
