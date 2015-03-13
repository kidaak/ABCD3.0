package cu.uci.cu.administration.nomenclators.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.nomenclators.controller.ControllerNomenclator;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abcd.domain.common.Nomenclator;
import cu.uci.abcd.domain.common.RecordType;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abos.l10n.management.nomenclator.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
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
public class NomenclatorAddEditableArea implements IEditableArea {
	
	private Map<String, Control> controls;
	private IViewController controller;
	Combo comboNomenclatorType;
	Composite topGroup;

	public NomenclatorAddEditableArea(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller = controller;
	}

	@Override
	public Composite createUI( final Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {

		FormLayout form = new FormLayout();
		parent.setLayout(form);
		FormDatas.attach(parent).atLeft(0).atRight(0);

		topGroup = new Composite(parent, SWT.NORMAL);
		topGroup.setLayout(form);
		FormDatas.attach(topGroup).atLeft(0).atRight(0);
		
		Label headerLabel= new Label(topGroup, SWT.NORMAL);
		headerLabel.setText("REGISTRAR NOMENCLADOR");
		FormDatas.attach(headerLabel).atTopTo(topGroup, 10).atLeftTo(topGroup, 10);

		Label separator = new Label(topGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separator).atTopTo(headerLabel, 10).atLeft(5).atRight(5);
		
		Label nomenclatorData = new Label(topGroup, SWT.NORMAL);
		nomenclatorData.setText("Datos del Nomenclador");
		FormDatas.attach(nomenclatorData).atTopTo(separator, 10).atLeftTo(topGroup, 10);
		
		Label nomenclatorType = new Label(topGroup, SWT.NONE);
		nomenclatorType.setText("Tipo de Nomenclador");
		FormDatas.attach(nomenclatorType).atTopTo(nomenclatorData, 10).atLeftTo(topGroup, 10);

	    comboNomenclatorType = new Combo(topGroup, SWT.NORMAL);
		FormDatas.attach(comboNomenclatorType).atTopTo(nomenclatorType, 10).atLeftTo(topGroup, 10);
		controls.put("comboNomenclatorType", comboNomenclatorType);
		initializeCombo();

		Label nomenclatorValue = new Label(topGroup, SWT.NONE);
		nomenclatorValue.setText("Valor del Nomenclador");
		FormDatas.attach(nomenclatorValue).atTopTo(nomenclatorData, 10).atLeftTo(comboNomenclatorType, 40);

		Text textnomenclatorValue = new Text(topGroup, SWT.BORDER);
		FormDatas.attach(textnomenclatorValue).atTopTo(nomenclatorValue, 10).atLeftTo(comboNomenclatorType, 40).withWidth(100);
		controls.put("textnomenclatorValue", textnomenclatorValue);

		Label nomenclatorDescription = new Label(topGroup, SWT.NORMAL);
		nomenclatorDescription.setText("Descripcion");
		FormDatas.attach(nomenclatorDescription).atTopTo(comboNomenclatorType,10).atLeftTo(topGroup, 10);

		Text textNomenclatorDescription = new Text(topGroup, SWT.BORDER |SWT.WRAP| SWT.V_SCROLL);
		FormDatas.attach(textNomenclatorDescription).atTopTo(
				nomenclatorDescription, 10).atRight(10).atLeft(10).withHeight(50);
		controls.put("textNomenclatorDescription", textNomenclatorDescription);

		return parent;
	}

	@Override
	public Composite createButtons(final Composite parent,
			IGridViewEntity entity, final IVisualEntityManager manager) {

		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Aceptar");
		saveBtn.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {

				int selectedIndex = ((Combo) controls
						.get("comboNomenclatorType")).getSelectionIndex();
				if(selectedIndex!=-1){
				
					
				String nomenclatorType = ((Combo) controls
						.get("comboNomenclatorType")).getItem(selectedIndex);
					
					

				if (nomenclatorType == "Tipo de Registro") {

					Nomenclator nomenclator = new NomenclatorGrid("Tipo de Registro", ((Text) controls
							.get("textnomenclatorValue")).getText(),
							((Text) controls.get("textNomenclatorDescription"))
									.getText());
					
					Nomenclator auxNomenclator = new RecordType();
					auxNomenclator.setNomeclatorName(nomenclator
							.getNomeclatorName());
					auxNomenclator.setNomenclatorDescription(nomenclator
							.getNomenclatorDescription());
					((ControllerNomenclator) controller)
							.RegisterNomenclator(auxNomenclator);
					manager.add((IGridViewEntity) nomenclator);
				}
				else if (nomenclatorType == "Tipo de Usuario de Prestamo") {

					Nomenclator nomenclator = new NomenclatorGrid("Tipo de Usuario de Prestamo", ((Text) controls
							.get("textnomenclatorValue")).getText(),
							((Text) controls.get("textNomenclatorDescription"))
									.getText());
					
					Nomenclator auxNomenclator = new LoanUserType();
					auxNomenclator.setNomeclatorName(nomenclator
							.getNomeclatorName());
					auxNomenclator.setNomenclatorDescription(nomenclator
							.getNomenclatorDescription());
					((ControllerNomenclator) controller)
							.RegisterNomenclator(auxNomenclator);
					manager.add((IGridViewEntity) nomenclator);
				}
				else if (nomenclatorType == "Tipo de Trabajador") {

					Nomenclator nomenclator = new NomenclatorGrid("Tipo de Trabajador", ((Text) controls
							.get("textnomenclatorValue")).getText(),
							((Text) controls.get("textNomenclatorDescription"))
									.getText());
					Nomenclator auxNomenclator = new WorkerType();
					auxNomenclator.setNomeclatorName(nomenclator
							.getNomeclatorName());
					auxNomenclator.setNomenclatorDescription(nomenclator
							.getNomenclatorDescription());
					((ControllerNomenclator) controller)
							.RegisterNomenclator(auxNomenclator);
					manager.add((IGridViewEntity) nomenclator);
				} 
					
				}
				else {

					MessageDialogUtil.openInformation(Display.getCurrent()
							.getActiveShell(), "Information",
							"Do not selected Nomenclator Type", null);

				}
				
				// clean the controls
				((Text) controls.get("textnomenclatorValue")).setText("");
				((Text) controls.get("textNomenclatorDescription")).setText("");

			}
		});

		return parent;
	}

	private void initializeCombo() {

		String[] comboStrings = { AbosMessages.get().LABEL_TYPE_OF_RECORD,
				MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_USER),
				AbosMessages.get().LABEL_TYPE_OF_WORKER };
		comboNomenclatorType.setItems(comboStrings);

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
		for (Control control : controls.values()) {
			control.dispose();
		}
	}
}