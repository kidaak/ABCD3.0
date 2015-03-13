package cu.uci.abcd.administration.nomenclators.iu;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.TabableView;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.nomenclators.controller.ControllerNomenclator;
import cu.uci.abcd.domain.common.Nomenclator;
import cu.uci.abos.l10n.management.nomenclator.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.util.api.MessageDialogUtil;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;
import cu.uci.cu.administration.nomenclators.model.NomenclatorAddEditableArea;
import cu.uci.cu.administration.nomenclators.model.NomenclatorGrid;
import cu.uci.cu.administration.nomenclators.model.NomenclatorUpdateEditableArea;
import cu.uci.cu.administration.nomenclators.model.NomenclatorWatchEditableArea;

/**
 * 
 * @author Dayana Rivera
 * 
 */

public class ManageNomenclator implements IContributor {

	Label searchCriteria;
	Label nomenclatorType;
	Combo comboNomenclatorType;
	Label nomenclatorValue;
	Button btnConsult;
	Button btnNewSearch;
	Label list;
	Button exportPDF;
	Button exportEXCEL;
	CRUDTreeTable tabla;

	private Map<String, Control> controls = new HashMap<String, Control>();
	private IViewController controller;
	private IVisualEntityManager manager;

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return AbosMessages.get().NAME_UI_MANAGE_NOMENCLATOR;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "AdministrarTipoUsuarioPrestamoID";
	}

	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub

		
		FormLayout form = new FormLayout();
		shell.setLayout(form);

		Composite test = new Composite(shell, SWT.NORMAL);
		test.setLayout(new FormLayout());
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(test).atLeft(0).atRight(0);
		searchCriteria = new Label(test, SWT.NONE);
		FormDatas.attach(searchCriteria).atTopTo(test, 10).atLeftTo(test, 10);

		nomenclatorType = new Label(test, SWT.NONE);
		FormDatas.attach(nomenclatorType).atTopTo(searchCriteria, 10)
				.atLeftTo(test, 10);
		;

		comboNomenclatorType = new Combo(test, SWT.NORMAL);
		FormDatas.attach(comboNomenclatorType).atTopTo(nomenclatorType, 10)
				.atLeftTo(test, 10);
		controls.put("comboNomenclatorType", comboNomenclatorType);
		initializeCombo();

		nomenclatorValue = new Label(test, SWT.NONE);
		FormDatas.attach(nomenclatorValue).atTopTo(searchCriteria, 10)
				.atLeftTo(comboNomenclatorType, 40);

		final Text textnomenclator = new Text(test, SWT.BORDER);
		textnomenclator.setLayoutData(new FormData());
		FormDatas.attach(textnomenclator).atTopTo(nomenclatorValue, 10)
				.atLeftTo(comboNomenclatorType, 40).withWidth(100);
		controls.put("textnomenclator", textnomenclator);

		Label separator = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separator).atTopTo(textnomenclator, 10).atLeft(5)
				.atRight(5);

		btnNewSearch = new Button(test, SWT.NONE);
		FormDatas.attach(btnNewSearch).atTopTo(separator, 10).atRight();

		btnConsult = new Button(test, SWT.NONE);
		FormDatas.attach(btnConsult).atTopTo(separator, 10)
				.atRightTo(btnNewSearch, 10);

		list = new Label(test, SWT.NORMAL);
		FormDatas.attach(list).atTopTo(btnConsult, 10).atLeftTo(test, 10);

		tabla = new CRUDTreeTable(test, SWT.NONE);
		FormDatas.attach(tabla).atTopTo(list, 10).atLeft(0).atRight(0);
		tabla.setEntityClass(NomenclatorGrid.class);
		tabla.setSearch(true);
		tabla.setSaveAll(true);
		tabla.setAdd(true, new NomenclatorAddEditableArea(controller));
		tabla.setUpdate(true, new NomenclatorUpdateEditableArea(controller));
		tabla.setWatch(true, new NomenclatorWatchEditableArea(controller));
		tabla.setDelete(true);

		tabla.setSearchHintText(AbosMessages.get().BUTTON_SEARCH); 
		tabla.setAddButtonText(AbosMessages.get().BUTTON_ADD); 
		tabla.setSaveAllButtonText(AbosMessages.get().BUTTON_SAVE); 
		tabla.setCancelButtonText(AbosMessages.get().BUTTON_CANCEL); 

		try {
			tabla.setColumnHeaders(Arrays.asList(
					AbosMessages.get().LABEL_NOMENCLATOR_TYPE,
					AbosMessages.get().LABEL_VALUE,
					MessageUtil.unescape(AbosMessages.get().LABEL_DESCRIPTION),
					AbosMessages.get().LABEL_USED));
			tabla.createTable();
			initializeGrid(tabla);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tabla.addDeleteListener(new TreeColumnListener() {

			public void handleEvent(final TreeColumnEvent event) {
				event.performDelete = true;
				NomenclatorGrid nomenclator = (NomenclatorGrid) event.entity;
				((ControllerNomenclator) controller)
						.DeleteNomenclator(nomenclator.getNomenclatorID());
			}
		});

		tabla.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				tabla.refresh();
			}
		});

		// -------- button actions-----

		btnNewSearch.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {
				((Text) controls.get("textnomenclator")).setText("");
				comboNomenclatorType.deselectAll();
				tabla.clearRows();
				initializeGrid(tabla);
				tabla.refresh();

			}

		});
		// Funcionalidad Consultar Nomenclador
		btnConsult.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = ((Combo) controls
						.get("comboNomenclatorType")).getSelectionIndex();
				List<IGridViewEntity> nomenclators = tabla.getEntities();
				NomenclatorGrid nomenclatorType = new NomenclatorGrid();
				tabla.clearRows();
				if (!(selectedIndex == -1)
						|| (!(textnomenclator.getText().equals("")))) {

					for (int i = 0; i < nomenclators.size(); i++) {
						nomenclatorType = (NomenclatorGrid) nomenclators.get(i);
						if (nomenclatorType.getNomenclatorN().equals(
								textnomenclator.getText())) {

							tabla.clearRows();
							tabla.addRow(nomenclatorType);
							tabla.refresh();
							break;
						}
						if (selectedIndex == 0) {

							if (nomenclatorType.getNomenclatorCode().equals(
									AbosMessages.get().LABEL_TYPE_OF_RECORD)) {

								tabla.addRow(nomenclatorType);
								tabla.refresh();

							} 
						} else if (selectedIndex == 1) {

							if (nomenclatorType.getNomenclatorCode().equals(
								MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_USER))) {

								tabla.addRow(nomenclatorType);
								tabla.refresh();
							}
						} else if (selectedIndex == 2) {

							if (nomenclatorType.getNomenclatorCode().equals(
									AbosMessages.get().LABEL_TYPE_OF_WORKER)) {

								tabla.addRow(nomenclatorType);
								tabla.refresh();
							}
						}
					}

				}

				else {
					MessageDialogUtil.openInformation(Display.getCurrent()
							.getActiveShell(), "Information",
							"Do not select search criteria", null);
					initializeGrid(tabla);
				}
			}

		});
		exportPDF = new Button(test, SWT.PUSH);
		FormDatas.attach(exportPDF).atTopTo(tabla, 10).atRight();

		exportEXCEL = new Button(test, SWT.PUSH);
		FormDatas.attach(exportEXCEL).atTopTo(tabla, 10)
				.atRightTo(exportPDF, 10);

		l10n();

		return shell;

	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void l10n() {
		
		// TODO Auto-generated method stub
		searchCriteria.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		nomenclatorValue.setText(AbosMessages.get().LABEL_NOMENCLATOR_VALUE);
		nomenclatorType.setText(AbosMessages.get().LABEL_NOMENCLATOR_TYPE);
		btnConsult.setText(AbosMessages.get().BUTTON_CONSULT);
		btnNewSearch.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		list.setText(AbosMessages.get().LABEL_NOMENCLATOR_LIST);
		exportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		exportEXCEL.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		tabla.setColumnHeaders(Arrays.asList(
				AbosMessages.get().LABEL_NOMENCLATOR_TYPE,
				AbosMessages.get().LABEL_VALUE,
				MessageUtil.unescape(AbosMessages.get().LABEL_DESCRIPTION),
				AbosMessages.get().LABEL_USED));
		tabla.setSearchHintText(AbosMessages.get().BUTTON_SEARCH); 
		tabla.setAddButtonText(AbosMessages.get().BUTTON_ADD); 
		tabla.setSaveAllButtonText(AbosMessages.get().BUTTON_SAVE); 
		tabla.setCancelButtonText(AbosMessages.get().BUTTON_CANCEL); 
		
		initializeCombo();
	}

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
	}

	private void initializeGrid(CRUDTreeTable tabla) {
		Collection<Nomenclator> listnomenclator = ((ControllerNomenclator) controller)
				.ListAll();
		for (Nomenclator aux : listnomenclator) {
			String nomenclatorType = aux.getNomenclatorCode();
			if (nomenclatorType.equals("RECORDTYPE")) {
				NomenclatorGrid nomenclator = new NomenclatorGrid(
						AbosMessages.get().LABEL_TYPE_OF_RECORD,
						aux.getNomeclatorName(),
						aux.getNomenclatorDescription());
				nomenclator.setNomenclatorID(aux.getNomenclatorID());
				tabla.addRow(nomenclator);
			} else if (nomenclatorType.equals("LOANUSERTYPE")) {
				NomenclatorGrid nomenclator = new NomenclatorGrid(
						MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_USER),
						aux.getNomeclatorName(),
						aux.getNomenclatorDescription());
				nomenclator.setNomenclatorID(aux.getNomenclatorID());
				tabla.addRow(nomenclator);
			} else if (nomenclatorType.equals("WORKERTYPE")) {
				NomenclatorGrid nomenclator = new NomenclatorGrid(
						AbosMessages.get().LABEL_TYPE_OF_WORKER,
						aux.getNomeclatorName(),
						aux.getNomenclatorDescription());
				nomenclator.setNomenclatorID(aux.getNomenclatorID());
				tabla.addRow(nomenclator);
			} else {
				NomenclatorGrid nomenclator = new NomenclatorGrid(null,
						aux.getNomeclatorName(),
						aux.getNomenclatorDescription());
				nomenclator.setNomenclatorID(aux.getNomenclatorID());
				tabla.addRow(nomenclator);
			}
		}
	}

	public Control getControl(String key) {
		return this.controls.get(key);
	}

	public void dispose() {
		for (Control control : controls.values()) {
			control.dispose();
		}
	}

	private void initializeCombo() {

		String[] comboStrings = { AbosMessages.get().LABEL_TYPE_OF_RECORD,
				MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_USER),
				AbosMessages.get().LABEL_TYPE_OF_WORKER };
		comboNomenclatorType.setItems(comboStrings);

	}
}
