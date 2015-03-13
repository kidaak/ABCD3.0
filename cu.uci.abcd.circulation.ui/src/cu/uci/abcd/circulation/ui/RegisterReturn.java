package cu.uci.abcd.circulation.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegisterReturn implements IContributor{

	@Override
	public String contributorName() {
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_RETURN);
	}

	@Override
	public String getID() {
		return "RegistrarDevolucionID";
	}

	@Override
	public Control createUIControl(Composite parent) {
	parent.setLayout(new FormLayout());
		
	Label lab2 = new Label(parent, SWT.None);
	lab2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
	FormDatas.attach(lab2).atTopTo(parent, 15).atLeftTo(parent, 15);
	
	Label insertarE = new Label(parent, SWT.NONE);
	insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
	String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
	insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
	
	FormDatas.attach(insertarE).atTopTo(lab2, 5).atLeftTo(parent, 15);
	
	Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
	tabla.setHeaderVisible(false);
	tabla.setLinesVisible(true);

	TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
	tableItem_1.setText("Nombre");

	TableItem tableItem = new TableItem(tabla, SWT.NONE);
	tableItem.setText("Usuario");

	TableItem tableItem_2 = new TableItem(tabla, SWT.NONE);
	tableItem_2.setText("Codigo");

	TableItem tableItem_3 = new TableItem(tabla, SWT.NONE);
	tableItem_3.setText("Tipo de Usuario");
	
	TableItem tableItem_4 = new TableItem(tabla, SWT.NONE);
	tableItem_4.setText("Estado");

	TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
	columna1.setWidth(125);
	columna1.setText("");
	TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
	columna2.setWidth(90);
	columna2.setText("");
	
	FormDatas.attach(tabla).atTopTo(lab2, 5).atLeftTo(insertarE, 30);
	
			
	Label lab5 = new Label(parent, SWT.None);
	lab5.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MESSAGE_RENOVATION_DA));
	FormDatas.attach(lab5).atTopTo(tabla, 5).atLeftTo(parent, 15);
		
	Label separador3= new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
	FormDatas.attach(separador3).atTopTo(lab5, 5).atLeft(0).atRight(0);
	
    Label lab8 = new Label(parent, SWT.None);
	lab8.setText(AbosMessages.get().LABEL_LIST_OF_OBJECTS_TO_RENEW);
	FormDatas.attach(lab8).atTopTo(separador3, 5).atLeftTo(parent, 15);
	
	//-----------------Listado--------------------------------------
	
	Table tabla3 = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
	tabla3.setHeaderVisible(true);
	tabla3.setLinesVisible(true);
			
	TableItem tableItem_13 = new TableItem(tabla3, SWT.NONE);
	tableItem_13.setText( new String[] { "column 1",	"column 2","column 3" } );

	TableColumn columna13 = new TableColumn(tabla3, SWT.NONE);
	columna13.setWidth(130);
	columna13.setText("Titulo");
			
	TableColumn columna23 = new TableColumn(tabla3, SWT.NONE);
	columna23.setWidth(100);
	columna23.setText("Autor");
			
	TableColumn columna33 = new TableColumn(tabla3, SWT.NONE);
	columna33.setWidth(100);
	columna33.setText("No. de Control");
			
	TableColumn columna4 = new TableColumn(tabla3, SWT.NONE);
	columna4.setWidth(150);
	columna4.setText("Tipo de Objeto");

	TableColumn columna5 = new TableColumn(tabla3, SWT.NONE);
	columna5.setWidth(100);
	columna5.setText("Devolucion");
	
	TableColumn columna6 = new TableColumn(tabla3, SWT.NONE);
	columna6.setWidth(100);
	columna6.setText("Tipo de Prestamo");
	
	TableColumn columna7 = new TableColumn(tabla3, SWT.NONE);
	columna7.setWidth(100);
	columna7.setText("Estado del Prestamo");
			
	TableColumn columna8 = new TableColumn(tabla3, SWT.NONE);
	columna8.setWidth(100);
	columna8.setText("Acciones");
	
	FormDatas.attach(tabla3).atTopTo(lab8, 5).withWidth(700).withHeight(70);
	
	Button boton6 = new Button(parent, SWT.PUSH);
	Button boton7 = new Button(parent, SWT.PUSH);
	
	boton6.setText(AbosMessages.get().BUTTON_RETURN);
	boton7.setText(AbosMessages.get().BUTTON_CANCEL);
	
	FormDatas.attach(boton6).atTopTo(tabla3, 5).atLeftTo(parent, 490).withWidth(100).withHeight(23);
	FormDatas.attach(boton7).atTopTo(tabla3, 5).atLeftTo(boton6, 20).withWidth(100).withHeight(23);
	return parent;
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
	
	}

	@Override
	public void setViewController(IViewController controller) {

		
	}

}
