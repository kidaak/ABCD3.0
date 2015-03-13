package cu.uci.abcd.adquisicion.iu;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.adquisicion.iu.domain.ListaDeEjemplaresDelRegistroDeAdquisicionEntity;
import cu.uci.abcd.adquisicion.ui.updateArea.ListaDeEjemplaresDelRegistroDeAdquisicionUpdateArea;
import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;



public class VerRegistroDeAdquisicion implements IContributor {
	private Record record;
	private IViewController controller;
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Ver Registro de Adquisición";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() { 
		// TODO Auto-generated method stub
		return "VerRegistroDeAdquisicionID";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	
	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}

	
	
	 
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub

		Composite group = new Composite(parent, SWT.NONE);
		FormDatas.attach(group).atLeft(0).atRight(0);
		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);



		Label datosRegistro = new Label(group, SWT.NONE);
		FormDatas.attach(datosRegistro).atTop(36).atLeft(50);
		datosRegistro.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRY_DATA_ACQUISITION));

		Table table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(table).atTopTo(datosRegistro,10).atLeft(50);
		table.setHeaderVisible(false);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(200);
		tblclmnNewColumn_1.setText("New Column");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(200);
		tblclmnNewColumn.setText("New Column");


		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText("No. Control");
		tableItem_1.setText(1, "prueba");

		TableItem tableItem_3 = new TableItem(table, SWT.NONE);
		tableItem_3.setText("Título");

		TableItem tableItem_4 = new TableItem(table, SWT.NONE);
		tableItem_4.setText("Autor");

		TableItem tableItem_5 = new TableItem(table, SWT.NONE);
		tableItem_5.setText("Editor");

		TableItem tableItem_2 = new TableItem(table, SWT.NONE);
		tableItem_2.setText("Año de Publicación");

		TableItem tableItem_6 = new TableItem(table, SWT.NONE);
		tableItem_6.setText("Tipo de Material");

		TableItem tableItem_7 = new TableItem(table, SWT.NONE);
		tableItem_7.setText("Sala");

		//---------------tabla2---------------------------------------
		Label ultimaAct = new Label(group, SWT.NONE);
		FormDatas.attach(ultimaAct).atTop(36).atLeftTo(table, 85);
		ultimaAct.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));

		Table table_1 = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(table_1).atTopTo(ultimaAct,10).atLeftTo(table, 85);
		table_1.setHeaderVisible(false);
		table_1.setLinesVisible(true);

		TableColumn tblclmnNewColumn_11 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_11.setWidth(200);
		tblclmnNewColumn_11.setText("New Column");

		TableColumn tblclmnNewColumn1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn1.setWidth(200);
		tblclmnNewColumn1.setText("New Column");

		TableItem tableItem_31 = new TableItem(table_1, SWT.NONE);
		tableItem_31.setText("Nombre y Apellidos");

		TableItem tableItem_41 = new TableItem(table_1, SWT.NONE);
		tableItem_41.setText("Usuario");

		TableItem tableItem_51 = new TableItem(table_1, SWT.NONE);
		tableItem_51.setText("Fecha");

		TableItem tableItem_61 = new TableItem(table_1, SWT.NONE);
		tableItem_61.setText("Hora");

		Label lista = new Label(group, SWT.NONE);
		FormDatas.attach(lista).atTopTo(table, 30).atLeft(33);
		lista.setText(MessageUtil.unescape(AbosMessages.get().LABEL_COPIES_OF_THE_REGISTRATION_LIST_ACQUISITION));
		
		CRUDTreeTable tabla = new CRUDTreeTable(group, SWT.BORDER);
		tabla.setEntityClass(ListaDeEjemplaresDelRegistroDeAdquisicionEntity.class);
		FormDatas.attach(tabla).atTopTo(lista, 10).atLeft(0).atRight(0);
		tabla.setSearch(true);
		tabla.setSaveAll(true);
		tabla.setAdd(true, new ListaDeEjemplaresDelRegistroDeAdquisicionUpdateArea());
		
		//tabla.setUpdate(true, new LoanUserTypeUpdateEditableArea(controller));
		tabla.setDelete(true);
		
		
		tabla.setColumnHeaders(Arrays.asList("#",MessageUtil.unescape(AbosMessages.get().TABLE_BARCODE),
				MessageUtil.unescape(AbosMessages.get().TABLE_SHELVING),AbosMessages.get().TABLE_MATERIAL_STATE,
				AbosMessages.get().TABLE_RESTRINCTIONS_ON_USE));
		try {
			tabla.createTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//tabla.addRow(new ListaDeEjemplaresDelRegistroDeAdquisicionEntity(tag, barCode, shelf, materialState, useRestrictions);
		
	

		/*Button nuevo = new Button(group, SWT.NONE);
		FormDatas.attach(nuevo).atTopTo(tabla, 10).atLeft(590);
		nuevo.setText(AbosMessages.get().BUTTON_NEW);

		Label separador = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(nuevo,10).withWidth(670);
		
		Button editar = new Button(group, SWT.NONE);
		FormDatas.attach(editar).atTopTo(separador,10).atLeft(400);
		editar.setText(AbosMessages.get().BUTTON_EDIT);

		Button eliminar = new Button(group, SWT.NONE);
		FormDatas.attach(eliminar).atTopTo(separador,10).atLeftTo(editar,30);
		eliminar.setText(AbosMessages.get().BUTTON_DELETE);

		Button cerrar = new Button(group, SWT.NONE);
		FormDatas.attach(cerrar).atTopTo(separador,10).atLeftTo(eliminar,30);
		cerrar.setText(AbosMessages.get().BUTTON_CLOSE);*/

		Button exportaHC = new Button(group, SWT.NONE);
		FormDatas.attach(exportaHC).atTopTo(tabla, 10).atLeft(640);
		exportaHC.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));

		Button exportaPDF = new Button(group, SWT.NONE);
		FormDatas.attach(exportaPDF).atTopTo(tabla, 10).atLeftTo(exportaHC,20);
		exportaPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);



		return parent;
	}

	
}
