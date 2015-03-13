package cu.uci.abcd.adquisicion.iu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
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

public class AprobarRechazarOrdenDeCompra implements IContributor {
	


	@Override
	public String contributorName() { 
		return "Aprobar Rechazar Orden de Compra";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		Group group = new Group(parent, SWT.NONE);
		group.setText("APROBAR RECHAZAR ORDENE DE COMPRA");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label proveedor = new Label(group, SWT.NONE);
		FormDatas.attach(proveedor).atTopTo(group,30).atLeft(33);
		proveedor.setText(AbosMessages.get().LABEL_PROVIDER);

		Text text = new Text(group, SWT.BORDER);
		FormDatas.attach(text).atTopTo(proveedor,6).atLeft(33).withWidth(120);
		
		Label lblMoneda = new Label(group, SWT.NONE);
		FormDatas.attach(lblMoneda).atTopTo(group,30).atLeftTo(text, 20);
		lblMoneda.setText(AbosMessages.get().LABEL_COIN);

		Combo combo = new Combo(group, SWT.NONE);
		FormDatas.attach(combo).atTopTo(lblMoneda, 6).atLeftTo(text, 20).withWidth(90);
		

		Label lblFechaDeRegistro = new Label(group, SWT.NONE);
		FormDatas.attach(lblFechaDeRegistro).atTopTo(group,10).atLeftTo(combo, 20);
		lblFechaDeRegistro.setText(AbosMessages.get().LABEL_DATE_OF_REGISTRATION);

		Label lblDesde = new Label(group, SWT.NONE);
		FormDatas.attach(lblDesde).atTopTo(group,30).atLeftTo(combo, 20);
		lblDesde.setText(AbosMessages.get().LABEL_SINCE);

		DateTime dt_desde= new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(dt_desde).atTopTo(lblDesde, 6).atLeftTo(combo, 20);
		
		Label lblHasta = new Label(group, SWT.NONE);
		FormDatas.attach(lblHasta).atTopTo(group,30).atLeftTo(dt_desde,10);
		lblHasta.setText(AbosMessages.get().LABEL_UNTIL);

		DateTime dt_hasta= new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(dt_hasta).atTopTo(lblHasta, 6).atLeftTo(dt_desde,10);
		
		Button consultar = new Button(group, SWT.NONE);
		FormDatas.attach(consultar).atTopTo(dt_hasta, 15).atLeftTo(dt_desde,60);
		consultar.setText(AbosMessages.get().BUTTON_CONSULT);

		Button nuevaBusqueda = new Button(group, SWT.NONE);
		FormDatas.attach(nuevaBusqueda).atTopTo(dt_hasta, 15).atLeftTo(consultar, 15);
		nuevaBusqueda.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));

		Button cerrar = new Button(group, SWT.NONE);
		FormDatas.attach(cerrar).atTopTo(dt_hasta, 15).atLeftTo(nuevaBusqueda, 15);
		cerrar.setText(AbosMessages.get().BUTTON_CLOSE);

		Label listado = new Label(group, SWT.NORMAL);
		FormDatas.attach(listado).atTopTo(consultar,20).atLeftTo(group, 33);
		listado.setText(AbosMessages.get().LABEL_LIST_OF_PURCHASE_ORDERS_PENDING);


		//-----------------Tabla--------------------------------------

		Table tabla = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tabla).atTopTo(listado, 10).atLeftTo(group, 33);
		tabla.setHeaderVisible(true);
		tabla.setLinesVisible(false);

		TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		tableItem_1.setText( new String[] { "column 1",        "column 2","column 3" } );

		TableItem tableItem_2 = new TableItem(tabla, SWT.NONE);
		tableItem_2.setText("Total" );


		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(150);
		columna1.setText("Número de Orden");

		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(150);
		columna2.setText(AbosMessages.get().LABEL_PROVIDER);


		TableColumn columna5 = new TableColumn(tabla, SWT.NONE);
		columna5.setWidth(100);
		columna5.setText(AbosMessages.get().LABEL_DATE);

		TableColumn columna6 = new TableColumn(tabla, SWT.NONE);
		columna6.setWidth(150);
		columna6.setText("Importe");

		TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		columna3.setWidth(150);
		columna3.setText(AbosMessages.get().LABEL_COIN);

		TableColumn columna7 = new TableColumn(tabla, SWT.NONE);
		columna7.setWidth(100);
		columna7.setText("Acciones");


		Button aprobar = new Button(group, SWT.PUSH);
		FormDatas.attach(aprobar).atTopTo(tabla, 6).atLeftTo(consultar,-5);
		aprobar.setText(AbosMessages.get().BUTTON_APPROVE_ALL);

		Button rechazar = new Button(group, SWT.PUSH);
		FormDatas.attach(rechazar).atTopTo(tabla, 6).atLeftTo(aprobar, 10);
		rechazar.setText(AbosMessages.get().BUTTON_REJECT_ALL);


		return parent;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "AprobarRechazarOrdenDeCompraID"; 
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
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
