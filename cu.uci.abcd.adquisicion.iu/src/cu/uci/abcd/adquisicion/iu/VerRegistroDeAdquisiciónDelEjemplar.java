package cu.uci.abcd.adquisicion.iu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class VerRegistroDeAdquisiciónDelEjemplar implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Ver Registro de Adquisición del Ejemplar";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return VerRegistroDeAdquisiciónDelEjemplar.class.getSimpleName()+"id12";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub

		Group group = new Group(parent, SWT.NONE);
		group.setText("VER REGISTRO DE ADQUISICIÓN DEL EJEMPLAR");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label datosEjemplar = new Label(group, SWT.NONE);
		FormDatas.attach(datosEjemplar).atTop(36).atLeft(46);
		datosEjemplar.setText(AbosMessages.get().LABEL_LOG_DATA_ISSUE);


		Table tablaDatosEjemplar = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tablaDatosEjemplar).atTopTo(datosEjemplar,10).atLeft(33);
		tablaDatosEjemplar.setHeaderVisible(false);
		tablaDatosEjemplar.setLinesVisible(true);

		TableColumn tblclmnNewColumn_1 = new TableColumn(tablaDatosEjemplar, SWT.NONE);
		tblclmnNewColumn_1.setWidth(170);
		tblclmnNewColumn_1.setText("New Column");

		TableColumn tblclmnNewColumn = new TableColumn(tablaDatosEjemplar, SWT.NONE);
		tblclmnNewColumn.setWidth(170);
		tblclmnNewColumn.setText("New Column");


		TableItem tableItem_1 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_1.setText("Autor Corporativo");

		TableItem tableItem_2 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_2.setText("Volumen");

		TableItem tableItem_3 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_3.setText("Tomo");

		TableItem tableItem_4 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_4.setText("Editor");

		TableItem tableItem_5 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_5.setText("Ciudad");

		TableItem tableItem_6 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_6.setText("País");

		TableItem tableItem_7 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_7.setText("Edición");

		TableItem tableItem_8 = new TableItem(tablaDatosEjemplar, SWT.NONE);
		tableItem_8.setText("Nota Pública");

		//---------------tabla2---------------------------------------

		Label ultimaAct = new Label(group, SWT.NONE);
		FormDatas.attach(ultimaAct).atTop(36).atLeftTo(tablaDatosEjemplar,35);
		ultimaAct.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));

		Table tablaUltimaAct = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tablaUltimaAct).atTopTo(ultimaAct,10).atLeftTo(tablaDatosEjemplar,30);
		tablaUltimaAct.setHeaderVisible(false);
		tablaUltimaAct.setLinesVisible(true);

		TableColumn tblclmnNewColumn_11 = new TableColumn(tablaUltimaAct, SWT.NONE);
		tblclmnNewColumn_11.setWidth(170);
		tblclmnNewColumn_11.setText("New Column");

		TableColumn tblclmnNewColumn1 = new TableColumn(tablaUltimaAct, SWT.NONE);
		tblclmnNewColumn1.setWidth(170);
		tblclmnNewColumn1.setText("New Column");

		TableItem tableItem_11 = new TableItem(tablaUltimaAct, SWT.NONE);
		tableItem_11.setText("Nombre y Apellidos");

		TableItem tableItem_21 = new TableItem(tablaUltimaAct, SWT.NONE);
		tableItem_21.setText("Usuario");

		TableItem tableItem_31 = new TableItem(tablaUltimaAct, SWT.NONE);
		tableItem_31.setText("Fecha");

		//--------------------tabla3-------------------------------------------

		Label datosDelEjemplar = new Label(group, SWT.NONE);
		FormDatas.attach(datosDelEjemplar).atTopTo(tablaDatosEjemplar,20).atLeft(33);
		datosDelEjemplar.setText(AbosMessages.get().LABEL_DATA_COPY);

		Table tablaDatosDelEjemplar = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tablaDatosDelEjemplar).atTopTo(datosDelEjemplar,10).atLeft(33);
		tablaDatosDelEjemplar.setHeaderVisible(false);
		tablaDatosDelEjemplar.setLinesVisible(true);

		TableColumn tblclmnNewColumn_21 = new TableColumn(tablaDatosDelEjemplar, SWT.NONE);
		tblclmnNewColumn_21.setWidth(170);
		tblclmnNewColumn_21.setText("New Column");

		TableColumn tblclmnNewColumn22 = new TableColumn(tablaDatosDelEjemplar, SWT.NONE);
		tblclmnNewColumn22.setWidth(170);
		tblclmnNewColumn22.setText("New Column");


		TableItem tableItem_22 = new TableItem(tablaDatosDelEjemplar, SWT.NONE);
		tableItem_22.setText("Código de barra");

		TableItem tableItem_23 = new TableItem(tablaDatosDelEjemplar, SWT.NONE);
		tableItem_23.setText("Localización Permanente");

		TableItem tableItem_24 = new TableItem(tablaDatosDelEjemplar, SWT.NONE);
		tableItem_24.setText("Localización en Estantería");

		TableItem tableItem_25 = new TableItem(tablaDatosDelEjemplar, SWT.NONE);
		tableItem_25.setText("Estado del Material");

		TableItem tableItem_26 = new TableItem(tablaDatosDelEjemplar, SWT.NONE);
		tableItem_26.setText("Restricciones de Uso");

		//--------------------Tabla4-----------------------------

		Label datosAdq = new Label(group, SWT.NONE);
		FormDatas.attach(datosAdq).atTopTo(tablaDatosEjemplar,20).atLeftTo(tablaDatosDelEjemplar, 35);
		datosAdq.setText(AbosMessages.get().LABEL_DATA_ACQUISITION);

		Table tablaDatosAdq = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tablaDatosAdq).atTopTo(datosAdq,10).atLeftTo(tablaDatosDelEjemplar, 30);
		tablaDatosAdq.setHeaderVisible(false);
		tablaDatosAdq.setLinesVisible(true);


		TableColumn tblclmnNewColumn_31 = new TableColumn(tablaDatosAdq, SWT.NONE);
		tblclmnNewColumn_31.setWidth(170);


		TableColumn tblclmnNewColumn32 = new TableColumn(tablaDatosAdq, SWT.NONE);
		tblclmnNewColumn32.setWidth(170);


		TableItem tableItem_32 = new TableItem(tablaDatosAdq, SWT.NONE);
		tableItem_32.setText("Tipo de Adquisisción");

		TableItem tableItem_33 = new TableItem(tablaDatosAdq, SWT.NONE);
		tableItem_33.setText("ID Proveedor");

		TableItem tableItem_34 = new TableItem(tablaDatosAdq, SWT.NONE);
		tableItem_34.setText("Precio");

		TableItem tableItem_35 = new TableItem(tablaDatosAdq, SWT.NONE);
		tableItem_35.setText("Moneda");


		Label condiciones = new Label(group, SWT.NONE);
		FormDatas.attach(condiciones).atTopTo(tablaDatosDelEjemplar,20).atLeft(33);
		condiciones.setText(AbosMessages.get().LABEL_EXCHANGE_CONDITIONS);

		Text listCondiciones = new Text(group, SWT.V_SCROLL | SWT.WRAP);
		FormDatas.attach(listCondiciones).atTopTo(condiciones,10).atLeft(33).withHeight(50).withWidth(680);
		
		//--------------------Tabla5-----------------------

		Label sugerido = new Label(group, SWT.NONE);
		FormDatas.attach(sugerido).atTopTo(listCondiciones, 20).atLeft(33);
		sugerido.setText(AbosMessages.get().LABEL_SUGGESTED_BY);

		Table tablaSugerido = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tablaSugerido).atTopTo(sugerido, 10).atLeft(33);
		tablaSugerido.setHeaderVisible(false);
		tablaSugerido.setLinesVisible(true);


		TableColumn tblclmnNewColumn_51 = new TableColumn(tablaSugerido, SWT.NONE);
		tblclmnNewColumn_51.setWidth(170);


		TableColumn tblclmnNewColumn52 = new TableColumn(tablaSugerido, SWT.NONE);
		tblclmnNewColumn52.setWidth(170);


		TableItem tableItem_52 = new TableItem(tablaSugerido, SWT.NONE);
		tableItem_52.setText("Identificador");

		TableItem tableItem_53 = new TableItem(tablaSugerido, SWT.NONE);
		tableItem_53.setText("Fecha");

		TableItem tableItem_54 = new TableItem(tablaSugerido, SWT.NONE);
		tableItem_54.setText("Sugerido por");


		Button editar = new Button(group, SWT.NONE);
		FormDatas.attach(editar).atTopTo(tablaSugerido, 10).atLeft(390);
		editar.setText(AbosMessages.get().BUTTON_EDIT);

		Button eliminar = new Button(group, SWT.NONE);
		FormDatas.attach(eliminar).atTopTo(tablaSugerido, 10).atLeftTo(editar,30);
		eliminar.setText(AbosMessages.get().BUTTON_DELETE);

		Button cerrar = new Button(group, SWT.NONE);
		FormDatas.attach(cerrar).atTopTo(tablaSugerido, 10).atLeftTo(eliminar,30);
		cerrar.setText(AbosMessages.get().BUTTON_CLOSE);

		Button exportaHC = new Button(group, SWT.NONE);
		FormDatas.attach(exportaHC).atTopTo(editar, 10).atLeft(370);
		exportaHC.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));

		Button exportaPDF = new Button(group, SWT.NONE);
		FormDatas.attach(exportaPDF).atTopTo(editar, 10).atLeftTo(exportaHC,20);
		exportaPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);


		return parent;
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}

}
