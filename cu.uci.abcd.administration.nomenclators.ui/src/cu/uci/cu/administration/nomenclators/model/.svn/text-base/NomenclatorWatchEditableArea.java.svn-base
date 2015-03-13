package cu.uci.cu.administration.nomenclators.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class NomenclatorWatchEditableArea implements IEditableArea{
	private Map<String, Control> controls;
	private IViewController controller;
	Combo comboNomenclatorType;
	
	public NomenclatorWatchEditableArea(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller= controller;
	}
	
	@Override
	public Composite createUI(final Composite parent, IGridViewEntity entity, IVisualEntityManager manager) {
		
		NomenclatorGrid fdtEntity = (NomenclatorGrid) entity;
		
		FormLayout form = new FormLayout();
		parent.setLayout(form);
		FormDatas.attach(parent).atLeft(0).atRight(0);
		
		Composite topGroup= new Composite(parent, SWT.NORMAL);
		topGroup.setLayout(form);
		FormDatas.attach(topGroup).atLeft(0).atRight(0);
		
		Label headerLabel= new Label(topGroup, SWT.NORMAL);
		headerLabel.setText("VISUALIZAR NOMENCLADOR");
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
		
		TableItem item8= new TableItem(nomenclatorTable, SWT.NONE);
		item8.setText(0,"Valor");
		item8.setText(1,fdtEntity.getNomenclatorN());
		
		TableItem item7= new TableItem(nomenclatorTable, SWT.NONE);
		item7.setText(0,"Usado");
		item7.setText(1, fdtEntity.getNomenclatorU());

		nomenclatorTable.setLinesVisible(true);
		
		
		Label updateDataLabel = new Label(topGroup, SWT.NORMAL);
		updateDataLabel.setText("Datos de la Ultima Actualizacion ");
		FormDatas.attach(updateDataLabel).atTopTo(separator, 10).atLeftTo(nomenclatorTable, 40);
		
		
		//Table Last Update Data
		
		Table updateDataTable= new Table(topGroup, SWT.BORDER|SWT.FULL_SELECTION);
		updateDataTable.setTouchEnabled(true);
		FormDatas.attach(updateDataTable).atTopTo(nomenclatorData, 10).atLeftTo(nomenclatorTable, 40);
		 
		TableItem item0= new TableItem(updateDataTable, SWT.NONE);
		 item0.setText("Nombre y Apellidos");
		 
		 TableItem item4= new TableItem(updateDataTable, SWT.NONE);
		 item4.setText("Usuario");
		 TableColumn tabc4 = new TableColumn(updateDataTable, SWT.None);
		    tabc4.setWidth(135);
		    tabc4.setText("");
		
		TableItem item5= new TableItem(updateDataTable, SWT.NONE);
		item5.setText("Fecha");
		TableColumn tabc5 = new TableColumn(updateDataTable, SWT.None);
			    tabc5.setWidth(135);
			    tabc5.setText("");
			    
		updateDataTable.setLinesVisible(true);
		
		Label nomenclatorDescription = new Label(topGroup, SWT.NONE);
		nomenclatorDescription.setText("Descripcion");
		FormDatas.attach(nomenclatorDescription).atTopTo(updateDataTable,10).atLeftTo(topGroup, 10);
		
		Text textNomenclatorDescription = new Text(topGroup, SWT.BORDER |SWT.WRAP| SWT.V_SCROLL);
		textNomenclatorDescription.setText(fdtEntity.getNomenclatorDescription());
		textNomenclatorDescription.setEditable(false);
		FormDatas.attach(textNomenclatorDescription).atTopTo(nomenclatorDescription,10).atRight(10).atLeft(10).withHeight(50);
		controls.put("textNomenclatorDescription", textNomenclatorDescription);
		
		return parent;
	}
	

	@Override
	public Composite createButtons( Composite parent, final IGridViewEntity entity, final IVisualEntityManager manager) {
	
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
