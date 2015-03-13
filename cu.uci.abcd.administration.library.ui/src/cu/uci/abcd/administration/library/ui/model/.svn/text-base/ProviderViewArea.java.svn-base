package cu.uci.abcd.administration.library.ui.model;

import org.eclipse.rap.rwt.RWT;
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

import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.administration.library.ui.controller.ProviderViewController;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class ProviderViewArea implements IEditableArea {

	private IViewController controller;
	FormLayout form;
	Composite parent;
	Label provedorDataLabel;
	
	public ProviderViewArea(IViewController controller) {
		this.controller = controller;
	}
	
	@Override
	public Composite createButtons(Composite arg0, IGridViewEntity arg1,
			IVisualEntityManager arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		
		ProviderGrid providerToView = (ProviderGrid)entity;
		form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
		parent = new Composite(shell, SWT.NORMAL);
		parent.setLayout(form);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
		provedorDataLabel = new Label(parent, SWT.NONE);
		provedorDataLabel.setText("Datos del Proveedor");
		FormDatas.attach(provedorDataLabel).atTopTo(parent, 10);
		
		Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setTouchEnabled(true);
		FormDatas.attach(tabla).atTopTo(provedorDataLabel, 10);

		TableItem item = new TableItem(tabla, SWT.NONE);
		item.setText("Nombre y Apellidos");

		TableItem item1 = new TableItem(tabla, SWT.NONE);
		item1.setText("Identificación");
		TableColumn tabc2 = new TableColumn(tabla, SWT.None);
		tabc2.setWidth(140);
		tabc2.setText("");

		TableItem item2 = new TableItem(tabla, SWT.NONE);
		item2.setText("Tipo de Proveedor");
		TableColumn tabc3 = new TableColumn(tabla, SWT.None);
		tabc3.setWidth(140);
		tabc3.setText("");

		TableItem item3 = new TableItem(tabla, SWT.NONE);
		item3.setText("Telefono");

		TableItem item33 = new TableItem(tabla, SWT.NONE);
		item33.setText("Correo");

		TableItem item34 = new TableItem(tabla, SWT.NONE);
		item34.setText("Estado");

		TableItem item35 = new TableItem(tabla, SWT.NONE);
		item35.setText("Direccion");
		tabla.setLinesVisible(true);

		Label lblNombreDelRegistro = new Label(parent, SWT.None);
		FormDatas.attach(lblNombreDelRegistro).atTopTo(parent, 10)
				.atLeftTo(tabla, 30);
		lblNombreDelRegistro.setText("Datos de la última Actualización");

		Table tabla13 = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla13.setTouchEnabled(true);
		FormDatas.attach(tabla13).atTopTo(lblNombreDelRegistro, 10)
				.atLeftTo(tabla, 30);

		TableItem item0 = new TableItem(tabla13, SWT.NONE);
		item0.setText("Nombre y Apellidos");

		TableItem item4 = new TableItem(tabla13, SWT.NONE);
		item4.setText("Usuario");
		TableColumn tabc4 = new TableColumn(tabla13, SWT.None);
		tabc4.setWidth(135);
		tabc4.setText("");

		TableItem item5 = new TableItem(tabla13, SWT.NONE);
		item5.setText("Fecha");
		TableColumn tabc5 = new TableColumn(tabla13, SWT.None);
		tabc5.setWidth(135);
		tabc5.setText("");

		TableItem item11 = new TableItem(tabla13, SWT.NONE);
		item11.setText("Hora");
		tabla13.setLinesVisible(true);

		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(tabla, 10).atRight(5).atLeft(5);

		Label listado1 = new Label(parent, SWT.NORMAL);
		FormDatas.attach(listado1).atTopTo(separador, 20);
		listado1.setText("Datos del Representante");

		Label lab = new Label(parent, SWT.None);
		lab.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation(
				"administracion/user.png");
		lab.setText("<img width='100' height='114' src='" + elemento
				+ "'></img>");
		FormDatas.attach(lab).atTopTo(listado1, 10);

		Table tabla1 = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla1.setTouchEnabled(true);
		FormDatas.attach(tabla1).atTopTo(listado1, 10).atLeftTo(lab, 0);

		TableItem item17 = new TableItem(tabla1, SWT.NONE);
		item17.setText("Nombre y Apellidos");

		TableItem item18 = new TableItem(tabla1, SWT.NONE);
		item18.setText("Identificación");
		TableColumn tabc21 = new TableColumn(tabla1, SWT.None);
		tabc21.setWidth(140);
		tabc21.setText("");

		TableItem item21 = new TableItem(tabla1, SWT.NONE);
		item21.setText("Teléfono");
		TableColumn tabc31 = new TableColumn(tabla1, SWT.None);
		tabc31.setWidth(140);
		tabc31.setText("");

		TableItem item31 = new TableItem(tabla1, SWT.NONE);
		item31.setText("Correo");
		TableItem item41 = new TableItem(tabla1, SWT.NONE);
		item41.setText("Dirección");

		tabla.setLinesVisible(true);

		Button cerrar = new Button(parent, SWT.PUSH);
		FormDatas.attach(cerrar).atTopTo(tabla1, 10).atRight(30);
		cerrar.setText("Cerrar");

		Button eliminar = new Button(parent, SWT.PUSH);
		FormDatas.attach(eliminar).atTopTo(tabla1, 10).atRightTo(cerrar, 10);
		eliminar.setText("Eliminar");

		Button modificar = new Button(parent, SWT.PUSH);
		FormDatas.attach(modificar).atTopTo(tabla1, 10).atRightTo(eliminar, 10);
		modificar.setText("Modiicar");

		Button exportarPDF = new Button(parent, SWT.PUSH);
		exportarPDF.setText("Exportar a Hoja de Calculo");
		FormDatas.attach(exportarPDF).atTopTo(eliminar, 10).atRight();

		Button exportarHC = new Button(parent, SWT.PUSH);
		exportarHC.setText("Exportar a PDF");
		FormDatas.attach(exportarHC).atTopTo(eliminar, 10)
				.atRightTo(exportarPDF, 10);
		
		LoadProviderData(providerToView);
		return shell;
	}

	private void LoadProviderData(ProviderGrid provider) {
		Provider providerToUpdate = ((ProviderViewController) controller).getProviderById(provider.getProvider().getActorID());
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Control getControl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
