package cu.uci.abcd.adquisicion.iu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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

public class AprobarRechazarSugerencias implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Aprobar Rechazar Sugerencias ";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "AprobarRechazarSugerenciaID";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		Group group = new Group(parent, SWT.NONE);
		group.setText("APROBAR RECHAZAR SUGERENCIAS");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label titulo = new Label(group, SWT.NONE);
		FormDatas.attach(titulo).atTopTo(group,20).atLeftTo(group, 33);
		titulo.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));

		Text text = new Text(group, SWT.BORDER);
		FormDatas.attach(text).atTopTo(titulo, 6).atLeftTo(group, 33).withWidth(150);
		
		Label lblAutor= new Label(group, SWT.NONE);
		FormDatas.attach(lblAutor).atTopTo(group,20).atLeftTo(text, 20);
		lblAutor.setText(AbosMessages.get().LABEL_AUTHOR);

		Text txtAutor = new Text(group, SWT.BORDER);
		FormDatas.attach(txtAutor).atTopTo(lblAutor, 6).atLeftTo(text, 20).withWidth(150);
		
		Label lblTipoDeUsuario = new Label(group, SWT.NONE);
		FormDatas.attach(lblTipoDeUsuario).atTopTo(group,20).atLeftTo(txtAutor, 20);
		lblTipoDeUsuario.setText(AbosMessages.get().LABEL_USER_TYPE);

		Combo tipoUsuario = new Combo(group, SWT.BORDER);
		FormDatas.attach(tipoUsuario).atTopTo(lblTipoDeUsuario, 6).atLeftTo(txtAutor, 20).withWidth(170);
		
		Button consultar = new Button(group, SWT.NONE);
		FormDatas.attach(consultar).atTopTo(txtAutor, 20).atLeftTo(txtAutor, 70);
		consultar.setText(AbosMessages.get().BUTTON_CONSULT);

		Button nuevaBusqueda = new Button(group, SWT.NONE);
		FormDatas.attach(nuevaBusqueda).atTopTo(txtAutor, 20).atLeftTo(consultar, 10);
		nuevaBusqueda.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));

		Button cerrar = new Button(group, SWT.NONE);
		FormDatas.attach(cerrar).atTopTo(txtAutor, 20).atLeftTo(nuevaBusqueda, 10);
		cerrar.setText(AbosMessages.get().BUTTON_CLOSE);


		Label listado = new Label(group, SWT.NORMAL);
		FormDatas.attach(listado).atTopTo(consultar, 20).atLeftTo(group, 33);
		listado.setText(AbosMessages.get().LABEL_SUGGESTIONS_LIST);


		//-----------------Tabla--------------------------------------

		Table tabla = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		FormDatas.attach(tabla).atTopTo(listado, 10).atLeftTo(group, 30);
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
		columna5.setText("Editor");

		TableColumn columna6 = new TableColumn(tabla, SWT.NONE);
		columna6.setWidth(150);
		columna6.setText("Sugerido por");

		TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		columna3.setWidth(150);
		columna3.setText("Fecha");

		TableColumn columna7 = new TableColumn(tabla, SWT.NONE);
		columna7.setWidth(100);
		columna7.setText("Acciones");



		//        TableEditor te = new TableEditor(tabla);
		//        
		//        te.grabHorizontal = true;
		//       
		//        Button checkButton = new Button(tabla, SWT.CHECK);
		//        checkButton.setText("");
		////        Text tp = new Text(tabla, SWT.BORDER);
		//        
		//        te.setEditor(checkButton, tableItem_1, 0);
		//        
		//        
		//----------------------------------------------------------------------



		Button aprobar = new Button(group, SWT.PUSH);
		FormDatas.attach(aprobar).atTopTo(tabla, 6).atLeftTo(consultar,20);
		aprobar.setText(AbosMessages.get().BUTTON_APPROVE_ALL);

		Button rechazar = new Button(group, SWT.PUSH);
		FormDatas.attach(rechazar).atTopTo(tabla, 6).atLeftTo(aprobar,10);
		rechazar.setText(AbosMessages.get().BUTTON_REJECT_ALL);


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
