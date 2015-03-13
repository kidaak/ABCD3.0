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

public class ConsultarSugerncias implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Consultar Sugerencias";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ConsultarSugerenciaID";
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
		group.setText("CONSULTAR SUGERENCIAS");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label criterio = new Label(group, SWT.NONE);
		FormDatas.attach(criterio).atTop(10).atLeft(33);
		criterio.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));

		Label titulo = new Label(group, SWT.NONE);
		FormDatas.attach(titulo).atTopTo(criterio, 10).atLeft(33);
		titulo.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));

		Text text = new Text(group, SWT.BORDER);
		FormDatas.attach(text).atTopTo(titulo,6).atLeft(33).withWidth(150);

		Label lblAutor= new Label(group, SWT.NONE);
		FormDatas.attach(lblAutor).atTopTo(criterio, 10).atLeftTo(text, 20);
		lblAutor.setText(AbosMessages.get().LABEL_AUTHOR);

		Text txtAutor = new Text(group, SWT.BORDER);
		FormDatas.attach(txtAutor).atTopTo(lblAutor, 6).atLeftTo(text, 20).withWidth(150);

		Label lblTipoDeUsuario = new Label(group, SWT.NONE);
		FormDatas.attach(lblTipoDeUsuario).atTopTo(criterio, 10).atLeftTo(txtAutor, 20);
		lblTipoDeUsuario.setText(AbosMessages.get().LABEL_USER_TYPE);

		Combo tipoUsuario = new Combo(group, SWT.BORDER);
		FormDatas.attach(tipoUsuario).atTopTo(lblTipoDeUsuario, 6).atLeftTo(txtAutor, 20).withWidth(170);
		
		Label lblFechaDeRegistro = new Label(group, SWT.NONE);
		FormDatas.attach(lblFechaDeRegistro).atTopTo(text, 20).atLeftTo(group, 33);
		lblFechaDeRegistro.setText(MessageUtil.unescape(AbosMessages.get().LABEL_CREATION_DATE_RANGE));

		Label lblDesde = new Label(group, SWT.NONE);
		FormDatas.attach(lblDesde).atTopTo(lblFechaDeRegistro, 6).atLeftTo(group, 33);
		lblDesde.setText(AbosMessages.get().LABEL_SINCE);

		DateTime dt_desde = new DateTime(group,SWT.BORDER |SWT.DROP_DOWN);
		FormDatas.attach(dt_desde).atTopTo(lblDesde, 6).atLeftTo(group, 33);
	

		Label lblHasta = new Label(group, SWT.NONE);
		FormDatas.attach(lblHasta).atTopTo(lblFechaDeRegistro,6).atLeftTo(dt_desde, 20);
		lblHasta.setText(AbosMessages.get().LABEL_UNTIL);

		DateTime dateTimeHasta = new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(dateTimeHasta).atTopTo(lblHasta,6).atLeftTo(dt_desde, 20);
		
		Button consultar = new Button(group, SWT.NONE);
		FormDatas.attach(consultar).atTopTo(lblHasta,6).atLeftTo(tipoUsuario, 55);
		consultar.setText(AbosMessages.get().BUTTON_CONSULT);

		Button cerrar = new Button(group, SWT.NONE);
		FormDatas.attach(cerrar).atTopTo(lblHasta,6).atLeftTo(consultar, 10);
		cerrar.setText(AbosMessages.get().BUTTON_CLOSE);

		Label separador = new Label(group,SWT.SEPARATOR| SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(consultar,20).atLeftTo(group, 30).withWidth(900);
		

		Label listado = new Label(group,SWT.NONE);
		FormDatas.attach(listado).atTopTo(separador,10).atLeftTo(group, 33);
		listado.setText(AbosMessages.get().LABEL_SUGGESTIONS_LIST);

		Table tabla = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tabla).atTopTo(listado,10).atLeftTo(group, 33);
		tabla.setHeaderVisible(true);
		tabla.setLinesVisible(false);

		TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		tableItem_1.setText( new String[] { "column 1",        "column 2","column 3" } );

		TableItem tableItem_2 = new TableItem(tabla, SWT.NONE);
		tableItem_2.setText("Total" );


		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(150);
		columna1.setText("Título");

		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(150);
		columna2.setText("Autor");


		TableColumn columna5 = new TableColumn(tabla, SWT.NONE);
		columna5.setWidth(100);
		columna5.setText("Sugerido por");

		TableColumn columna6 = new TableColumn(tabla, SWT.NONE);
		columna6.setWidth(150);
		columna6.setText("Fecha");

		TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		columna3.setWidth(150);
		columna3.setText("Estado");

		TableColumn columna4 = new TableColumn(tabla, SWT.NONE);
		columna4.setWidth(150);
		columna4.setText("Razón");

		TableColumn columna7 = new TableColumn(tabla, SWT.NONE);
		columna7.setWidth(100);
		columna7.setText("Acciones");


		Button exportarHC = new Button(group, SWT.NONE);
		FormDatas.attach(exportarHC).atTopTo(tabla,20).atLeftTo(tipoUsuario, 55);
		exportarHC.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);

		Button exportarPDF = new Button(group, SWT.NONE);
		FormDatas.attach(exportarPDF).atTopTo(tabla,20).atLeftTo(exportarHC,10);
		exportarPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);

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
