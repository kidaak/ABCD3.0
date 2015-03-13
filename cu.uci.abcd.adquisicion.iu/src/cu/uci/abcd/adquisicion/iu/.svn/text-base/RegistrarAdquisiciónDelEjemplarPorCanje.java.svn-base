package cu.uci.abcd.adquisicion.iu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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

public class RegistrarAdquisiciónDelEjemplarPorCanje implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Adquisición del Ejemplar por Canje";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return RegistrarAdquisiciónDelEjemplarPorCanje.class.getSimpleName()+"id11";
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
		Composite group = new Composite(parent, SWT.NONE);
	
		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label datosPedido = new Label(group, SWT.NONE);
		FormDatas.attach(datosPedido).atTop(20).atLeft(25);
		datosPedido.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRY_DATA_ACQUISITION));

		Label autorCorp = new Label(group, SWT.NONE);
		FormDatas.attach(autorCorp).atTopTo(datosPedido, 20).atLeft(43);
		autorCorp.setText("Autor Corporativo");

		Text textAutotCorp = new Text(group,SWT.NONE);
		FormDatas.attach(textAutotCorp).atTopTo(datosPedido, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label volumen = new Label(group, SWT.NONE);
		FormDatas.attach(volumen).atTopTo(autorCorp, 20).atLeft(43);
		volumen.setText("Volumen");

		Text textVolumen = new Text(group,SWT.NONE);
		FormDatas.attach(textVolumen).atTopTo(autorCorp, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label tomo = new Label(group, SWT.NONE);
		FormDatas.attach(tomo).atTopTo(volumen, 20).atLeft(43);
		tomo.setText("Tomo");

		Text textTomo = new Text(group,SWT.NONE);
		FormDatas.attach(textTomo).atTopTo(volumen, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label editor = new Label(group, SWT.NONE);
		FormDatas.attach(editor).atTopTo(tomo, 20).atLeft(43);
		editor.setText("Editor");

		Text textEditor = new Text(group,SWT.NONE);
		FormDatas.attach(textEditor).atTopTo(tomo, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label ciudad = new Label(group, SWT.NONE);
		FormDatas.attach(ciudad).atTopTo(editor, 20).atLeft(43);
		ciudad.setText("Ciudad");

		Text textCiudad = new Text(group,SWT.NONE);
		FormDatas.attach(textCiudad).atTopTo(editor, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label pais = new Label(group, SWT.NONE);
		FormDatas.attach(pais).atTopTo(ciudad, 20).atLeft(43);
		pais.setText("País");

		Text textPaís = new Text(group,SWT.NONE);
		FormDatas.attach(textPaís).atTopTo(ciudad, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label edicion = new Label(group, SWT.NONE);
		FormDatas.attach(edicion).atTopTo(pais, 20).atLeft(43);
		edicion.setText("Edición");

		Text textEdicion= new Text(group,SWT.NONE);
		FormDatas.attach(textEdicion).atTopTo(pais, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label notaPub = new Label(group, SWT.NONE);
		FormDatas.attach(notaPub).atTopTo(edicion, 20).atLeft(43);
		notaPub.setText("Nota Pública");

		Text textNotaPub = new Text(group,SWT.NONE);
		FormDatas.attach(textNotaPub).atTopTo(edicion, 20).atLeftTo(autorCorp,75).withWidth(190);


		Label datosEjemp = new Label(group, SWT.NONE);
		FormDatas.attach(datosEjemp).atTopTo(notaPub, 40).atLeft(25);
		datosEjemp.setText("Datos del Ejemplar");

		Label codigoBarra = new Label(group, SWT.NONE);
		FormDatas.attach(codigoBarra).atTopTo(datosEjemp, 20).atLeft(43);
		codigoBarra.setText("Código de Barra");

		Text textCodigoBarra = new Text(group,SWT.NONE);
		FormDatas.attach(textCodigoBarra).atTopTo(datosEjemp, 20).atLeftTo(autorCorp,75).withWidth(190);

		Label localizacionPerm = new Label(group, SWT.NONE);
		FormDatas.attach(localizacionPerm).atTopTo(codigoBarra, 20).atLeft(43);
		localizacionPerm.setText("Localización Permanente");

		Combo textLocalizacionPerm = new Combo(group,SWT.NONE);
		FormDatas.attach(textLocalizacionPerm).atTopTo(codigoBarra, 20).atLeftTo(localizacionPerm,30).withWidth(210);

		Label localizacionEstant = new Label(group, SWT.NONE);
		FormDatas.attach(localizacionEstant).atTopTo(localizacionPerm, 20).atLeft(43);
		localizacionEstant.setText("Localización en Estantería");

		Combo cb_localizacionEstant = new Combo (group,SWT.NONE);
		FormDatas.attach(cb_localizacionEstant).atTopTo(localizacionPerm, 20).atLeftTo(localizacionPerm,30).withWidth(210);

		Label estadoMat = new Label(group, SWT.NONE);
		FormDatas.attach(estadoMat).atTopTo(localizacionEstant, 20).atLeft(43);
		estadoMat.setText("Estado del Material");

		Text textEstadoMat = new Text(group,SWT.NONE);
		FormDatas.attach(textEstadoMat).atTopTo(localizacionEstant, 20).atLeftTo(autorCorp,75).withWidth(210);

		Label restricciones = new Label(group, SWT.NONE);
		FormDatas.attach(restricciones).atTopTo(estadoMat, 20).atLeft(43);
		restricciones.setText("Restricciones de Uso");

		Combo cb_restricciones = new Combo (group,SWT.NONE);
		FormDatas.attach(cb_restricciones).atTopTo(estadoMat, 20).atLeftTo(localizacionPerm,30).withWidth(210);

		Label datosAdq = new Label(group, SWT.NONE);
		FormDatas.attach(datosAdq).atTopTo(restricciones, 40).atLeft(25);
		datosAdq.setText("Datos de la Adquisición");

		Label proveedor = new Label(group, SWT.NONE);
		FormDatas.attach(proveedor).atTopTo(datosAdq, 20).atLeft(43);
		proveedor.setText("Proveedor");

		Combo cb_proveedor = new Combo (group,SWT.NONE);
		FormDatas.attach(cb_proveedor).atTopTo(datosAdq, 20).atLeftTo(localizacionPerm,30).withWidth(210);
		
		Label fechaAdq = new Label(group, SWT.NONE);
		FormDatas.attach(fechaAdq).atTopTo(proveedor, 20).atLeft(43);
		fechaAdq.setText("Fecha de Adquisición");

		DateTime dateTime = new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(dateTime).atTopTo(proveedor, 20).atLeftTo(localizacionPerm,30).withWidth(212);
		
		Label precio = new Label(group, SWT.NONE);
		FormDatas.attach(precio).atTopTo(fechaAdq, 20).atLeft(43);
		precio.setText("Precio");

		Text textPrecio = new Text(group,SWT.NONE);
		FormDatas.attach(textPrecio).atTopTo(fechaAdq, 20).atLeftTo(autorCorp,75).withWidth(90);
		
		Combo cb_precio= new Combo (group,SWT.NONE);
		FormDatas.attach(cb_precio).atTopTo(fechaAdq, 20).atLeftTo(textPrecio,10).withWidth(90);
		
		Label tipoAdq = new Label(group, SWT.NONE);
		FormDatas.attach(tipoAdq).atTopTo(precio, 20).atLeft(43);
		tipoAdq.setText("Tipo de Adquisición");

		Combo cb_tipoAdq = new Combo (group,SWT.NONE);
		FormDatas.attach(cb_tipoAdq).atTopTo(precio, 20).atLeftTo(localizacionPerm,33).withWidth(210);
		
		Label condiciones = new Label(group, SWT.NONE);
		FormDatas.attach(condiciones).atTopTo(tipoAdq, 20).atLeft(43);
		condiciones.setText("Condiciones de Canje");

		Text listCondiciones = new Text(group, SWT.V_SCROLL | SWT.WRAP);
		FormDatas.attach(listCondiciones).atTopTo(tipoAdq, 20).atLeftTo(localizacionPerm,33).withHeight(50).withWidth(380);
				
		Label sugeridoPor = new Label(group, SWT.NONE);
		FormDatas.attach(sugeridoPor).atTopTo(listCondiciones, 40).atLeft(25);
		sugeridoPor.setText("Sugerido por");


		Table table_1 = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_table_1 = new FormData();
		fd_table_1.top = new FormAttachment(sugeridoPor,10);
		fd_table_1.left= new FormAttachment(0,30);
		table_1.setLayoutData(fd_table_1);
		table_1.setHeaderVisible(false);
		table_1.setLinesVisible(true);

		TableColumn tblclmnNewColumn_11 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_11.setWidth(150);
		tblclmnNewColumn_11.setText("New Column");

		TableColumn tblclmnNewColumn1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn1.setWidth(150);
		tblclmnNewColumn1.setText("New Column");

		TableItem tableItem_31 = new TableItem(table_1, SWT.NONE);
		tableItem_31.setText("Identificador");

		TableItem tableItem_41 = new TableItem(table_1, SWT.NONE);
		tableItem_41.setText("Fecha");

		TableItem tableItem_51 = new TableItem(table_1, SWT.NONE);
		tableItem_51.setText("Sugerido por");

		Button disociar = new Button (group,SWT.None);
		FormDatas.attach(disociar).atTopTo(table_1, 10).atLeft(260);
		disociar.setText(AbosMessages.get().BUTTON_DISSOCIATE);

		Button aceptar = new Button (group,SWT.None);
		FormDatas.attach(aceptar).atTopTo(disociar, 10).atLeft(430);
		aceptar.setText(AbosMessages.get().BUTTON_ACEPT);

		Button cancelar = new Button (group,SWT.None);
		FormDatas.attach(cancelar).atTopTo(disociar, 10).atLeftTo(aceptar,20);
		cancelar.setText(AbosMessages.get().BUTTON_CANCEL);


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
