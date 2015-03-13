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

import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class VerDatosDelPedidoSinSugerenciasAsociada implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Ver Datos del Pedido";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return VerDatosDelPedidoSinSugerenciasAsociada.class.getSimpleName()+"id8";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		Group group = new Group(parent, SWT.NONE);
		group.setText("VER DATOS DEL PEDIDO");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label datosPedido = new Label(group, SWT.NONE);
		FormDatas.attach(datosPedido).atTop(15).atLeft(46);
		datosPedido.setText(AbosMessages.get().LABEL_ORDER_DATA);

		Table table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(table).atTopTo(datosPedido,10).atLeft(46);
		table.setHeaderVisible(false);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("New Column");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");

		TableItem tableItem_3 = new TableItem(table, SWT.NONE);
		tableItem_3.setText("Título");

		TableItem tableItem_4 = new TableItem(table, SWT.NONE);
		tableItem_4.setText("Autor");

		TableItem tableItem_5 = new TableItem(table, SWT.NONE);
		tableItem_5.setText("Editor");

		//---------------tabla2---------------------------------------
		Label ultimaAct = new Label(group, SWT.NONE);
		FormDatas.attach(ultimaAct).atTop(15).atLeftTo(table,20);
		ultimaAct.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LAST_UPDATE));
		
		Table table_1 = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(table_1).atTopTo(ultimaAct,10).atLeftTo(table,20);
		table_1.setHeaderVisible(false);
		table_1.setLinesVisible(true);

		TableColumn tblclmnNewColumn_11 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_11.setWidth(100);
		tblclmnNewColumn_11.setText("New Column");

		TableColumn tblclmnNewColumn1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn1.setWidth(100);
		tblclmnNewColumn1.setText("New Column");

		TableItem tableItem_31 = new TableItem(table_1, SWT.NONE);
		tableItem_31.setText("Nombre y Apellidos");

		TableItem tableItem_41 = new TableItem(table_1, SWT.NONE);
		tableItem_41.setText("Usuario");

		TableItem tableItem_51 = new TableItem(table_1, SWT.NONE);
		tableItem_51.setText("Fecha");

		Button editar = new Button(group, SWT.NONE);
		FormDatas.attach(editar).atTopTo(table, 10).atLeft(340);
		editar.setText(AbosMessages.get().BUTTON_EDIT);

		Button eliminar = new Button(group, SWT.NONE);
		FormDatas.attach(eliminar).atTopTo(table, 10).atLeftTo(editar,30);
		eliminar.setText(AbosMessages.get().BUTTON_DELETE);

		Button cerrar = new Button(group, SWT.NONE);
		FormDatas.attach(cerrar).atTopTo(editar, 10).atLeftTo(eliminar,30);
		cerrar.setText(AbosMessages.get().BUTTON_CLOSE);

		Button exportaHC = new Button(group, SWT.NONE);
		FormDatas.attach(exportaHC).atTopTo(table, 10).atLeft(340);
		exportaHC.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);

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
