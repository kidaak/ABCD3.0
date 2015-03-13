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
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class AsociarOrdenDeCompra implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return 	"Asociar Orden de Compra"; 
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return AsociarOrdenDeCompra.class.getSimpleName()+"id3";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		Group group = new Group(parent, SWT.NONE);
		group.setText("ASOCIAR ORDEN DE COMPRA");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);


		Label label = new Label(group, SWT.NONE);
		FormDatas.attach(label).atTopTo(group,10).atLeft(3);
		label.setText("Criterios de Búsqueda");

		Label identificador = new Label(group, SWT.NONE);
		FormDatas.attach(identificador).atTopTo(label,20).atLeft(33);
		identificador.setText("Identificador");

		Text  text = new Text(group, SWT.BORDER);
		FormDatas.attach(text).atTopTo(identificador,10).atLeft(33).withWidth(150);

		Label lblProveedor = new Label(group, SWT.NONE);
		FormDatas.attach(lblProveedor).atTopTo(label, 20).atLeftTo(text, 20);
		lblProveedor.setText("Proveedor");

		Combo combo = new Combo(group, SWT.NONE);
		FormDatas.attach(combo).atTopTo(lblProveedor,10).atLeftTo(text,20).withWidth(170);

		Label lblRangoDeFechas = new Label(group, SWT.NONE);
		FormDatas.attach(lblRangoDeFechas).atTopTo(group,15).atLeftTo(combo,20);
		lblRangoDeFechas.setText("Rango de Fecha");

		Label lblDesde = new Label(group, SWT.NONE);
		FormDatas.attach(lblDesde).atTopTo(lblRangoDeFechas,15).atLeftTo(combo,20);
		lblDesde.setText("Desde");

		DateTime dateTime = new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(dateTime).atTopTo(lblDesde,10).atLeftTo(combo,20);

		Label lblHasta = new Label(group, SWT.NONE);
		FormDatas.attach(lblHasta).atTopTo(lblRangoDeFechas, 15).atLeftTo(dateTime,20);
		lblHasta.setText("Hasta");

		DateTime dateTimeHasta = new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(dateTimeHasta).atTopTo(lblHasta, 10).atLeftTo(dateTime,20);


		Button consultar = new Button(group, SWT.NONE);
		FormDatas.attach(consultar).atTopTo(dateTime, 20).atLeftTo(dateTime, 10);
		consultar.setText(AbosMessages.get().BUTTON_CONSULT);

		Button cancelar = new Button(group, SWT.NONE);
		FormDatas.attach(cancelar).atTopTo(dateTime, 20).atLeftTo(consultar, 10);
		cancelar.setText(AbosMessages.get().BUTTON_CANCEL);


		Label separdor = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separdor).atTopTo(cancelar,30).withWidth(800);
		
		Label listado = new Label(group, SWT.NORMAL);
		FormDatas.attach(listado).atTopTo(separdor,6).atLeft(20);
		listado.setText("Listados de Órdenes de Compras ");

		//-----------------Tabla--------------------------------------

		Table tabla = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tabla).atTopTo(listado, 10).atLeftTo(group,0);
		tabla.setHeaderVisible(true);
		tabla.setLinesVisible(false);

		TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		tableItem_1.setText( new String[] { "column 1",        "column 2","column 3" } );

		TableItem tableItem_2 = new TableItem(tabla, SWT.NONE);
		tableItem_2.setText("Total" );


		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(150);
		columna1.setText("Identificador");

		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(150);
		columna2.setText("Proveedor");


		TableColumn columna5 = new TableColumn(tabla, SWT.NONE);
		columna5.setWidth(100);
		columna5.setText("Fecha");

		TableColumn columna6 = new TableColumn(tabla, SWT.NONE);
		columna6.setWidth(150);
		columna6.setText("Importe");

		TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		columna3.setWidth(150);
		columna3.setText("Estado");

		TableColumn columna7 = new TableColumn(tabla, SWT.NONE);
		columna7.setWidth(100);
		columna7.setText("Acciones");

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
