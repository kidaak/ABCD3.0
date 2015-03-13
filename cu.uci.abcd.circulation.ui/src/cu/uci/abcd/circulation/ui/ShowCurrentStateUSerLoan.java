package cu.uci.abcd.circulation.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ShowCurrentStateUSerLoan implements IContributor{

	@Override
	public String contributorName() {
		return "Mostrar Estado Actual de un Usuario de Prestamo";
	}
	@Override
	public String getID() {
		return ShowHistoricalObjectLoan.class.getSimpleName() + "id20";
	}
	@Override
	public Control createUIControl(Composite parent) {
		parent.setLayout(new FormLayout());
		Composite grupo = new Composite(parent, SWT.BORDER);
		grupo.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo.setLayout(new FormLayout());
		FormDatas.attach(grupo).atLeftTo(parent, 95).atTopTo(parent, 15);
		
		Label lab1 = new Label(grupo, SWT.NONE);
		lab1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		FormDatas.attach(lab1).atTopTo(grupo, 5);
		
		Label separador = new Label(grupo, SWT.SEPARATOR | SWT.VERTICAL);
		FormDatas.attach(separador).atTopTo(grupo, 5).atLeftTo(lab1, 260).withHeight(160);
		
		Label lab2 = new Label(grupo, SWT.NONE);
		lab2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));
		FormDatas.attach(lab2).atTopTo(grupo, 5).atLeftTo(separador, 60);
		
		Label insertarE = new Label(grupo, SWT.NONE);
		insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		
		FormDatas.attach(insertarE).atTopTo(lab1, 5);
	
		Table tabla = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);
			
		TableItem tableItem1 = new TableItem(tabla, SWT.NORMAL);
		tableItem1.setText("Nombre");
			
		TableItem tableItem2 = new TableItem(tabla, SWT.END);
		tableItem2.setText("Usuario");
		
		TableItem tableItem3 = new TableItem(tabla, SWT.NONE);
		tableItem3.setText("Codigo");
		
		TableItem tableItem4 = new TableItem(tabla, SWT.NONE);
		tableItem4.setText("Tipo de Usuario");
			
		TableItem tableItem5 = new TableItem(tabla, SWT.NONE);
		tableItem5.setText("Estado");

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		columna1.setText("");
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(125);
		columna2.setText("");
		
		FormDatas.attach(tabla).atTopTo(lab1, 5).atLeftTo(insertarE, 20);
		
		Table tabla2 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
			
		TableItem tableItem6= new TableItem(tabla2, SWT.NORMAL);
		tableItem6.setText("Nombre y Apellido");
			
		TableItem tableItem7= new TableItem(tabla2, SWT.END);
		tableItem7.setText("Usuario");
		
		TableItem tableItem8= new TableItem(tabla2, SWT.NONE);
		tableItem8.setText("Fecha y Hora");
			
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(125);
		columna11.setText("");
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
		columna22.setText("");
		
		FormDatas.attach(tabla2).atTopTo(lab2, 5).atLeftTo(separador,50);
		
		Label separador1 = new Label(grupo, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador1).atTopTo(tabla, 25).withWidth(900);
		
		//----------------------------------------
		TabFolder tabFolder = new TabFolder(grupo, SWT.NONE);
		
		FormDatas.attach(tabFolder).atTopTo(separador1, 5).withWidth(900).withHeight(200);
		
		Composite g1 = new Composite(tabFolder, SWT.BORDER);
		g1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		TabItem tabItem_1 = new TabItem(tabFolder, SWT.None);
		tabItem_1.setText(AbosMessages.get().LABEL_TRANSACTIONS);
		tabItem_1.setControl(g1);
		
		g1.setLayout(new FormLayout());
		FormDatas.attach(g1).atTopTo(tabFolder, 1);
		
		Label lab3 = new Label(g1, SWT.NONE);
		//lab3.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		lab3.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CURRENT_LOAN_TRANSACTIONS));
		FormDatas.attach(lab3).atTopTo(g1, 15).atLeftTo(g1, 10);
		
		  
		Table tabla3 = new Table(g1, SWT.BORDER | SWT.FULL_SELECTION);
		tabla3.setHeaderVisible(true);
		tabla3.setLinesVisible(true);
		
		TableColumn columna10 = new TableColumn(tabla3, SWT.NONE);
		columna10.setWidth(90);
		columna10.setText("Titulo");
		
		TableColumn columna3 = new TableColumn(tabla3, SWT.NONE);
		columna3.setWidth(90);
		columna3.setText("Autor");
		
		TableColumn columna4 = new TableColumn(tabla3, SWT.NONE);
		columna4.setWidth(100);
		columna4.setText("No. de Control");
		
		TableColumn columna20 = new TableColumn(tabla3, SWT.NONE);
		columna20.setWidth(100);
		columna20.setText("Tipo de Objeto");
		
		TableColumn columna12 = new TableColumn(tabla3, SWT.NONE);
		columna12.setWidth(120);
		columna12.setText("Tipo de Prestamo");
		
		TableColumn columna5 = new TableColumn(tabla3, SWT.NONE);
		columna5.setWidth(80);
		columna5.setText("Estado");

		TableColumn columna23 = new TableColumn(tabla3, SWT.NONE);
		columna23.setWidth(80);
		columna23.setText("Registro");
		
		TableColumn columna24 = new TableColumn(tabla3, SWT.NONE);
		columna24.setWidth(100);
		columna24.setText("Devolucion");
		
		TableColumn columna6 = new TableColumn(tabla3, SWT.NONE);
		columna6.setWidth(100);
		columna6.setText("Acciones");
		
		FormDatas.attach(tabla3).atTopTo(lab3, 5).atLeftTo(g1, 10).withHeight(85).withWidth(850);
		
		//---------------Reservas--------
		TabItem tabItem_2 = new TabItem(tabFolder, SWT.None);
		tabItem_2.setText(AbosMessages.get().LABEL_RESERVATIONS);
		Composite g2 = new Composite(tabFolder, SWT.BORDER);
		g2.setData(RWT.CUSTOM_VARIANT, "gray_background");
		tabItem_2.setControl(g2);
		
		g2.setLayout(new FormLayout());
		FormDatas.attach(g2).atTopTo(tabFolder, 1);
		
		Label lab4 = new Label(g2, SWT.NONE);
		lab4.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CURRENT_LOAN_RESERVATIONS));
		FormDatas.attach(lab4).atTopTo(g2, 15).atLeftTo(g2, 10);
		
		Table tabla4 = new Table(g2, SWT.BORDER | SWT.FULL_SELECTION);
		tabla4.setHeaderVisible(true);
		tabla4.setLinesVisible(true);
				
		TableColumn columna101 = new TableColumn(tabla4, SWT.NONE);
		columna101.setWidth(100);
		columna101.setText("Titulo");
		
		TableColumn columna31 = new TableColumn(tabla4, SWT.NONE);
		columna31.setWidth(100);
		columna31.setText("Autor");
		
		TableColumn columna41 = new TableColumn(tabla4, SWT.NONE);
		columna41.setWidth(150);
		columna41.setText("No. de Control");
		
		TableColumn columna121 = new TableColumn(tabla4, SWT.NONE);
		columna121.setWidth(160);
		columna121.setText("Fecha de Reservacion");

		TableColumn columna231 = new TableColumn(tabla4, SWT.NONE);
		columna231.setWidth(160);
		columna231.setText("Fecha de Vencimiento");
		
		TableColumn columna61 = new TableColumn(tabla4, SWT.NONE);
		columna61.setWidth(120);
		columna61.setText("Acciones");
		
		FormDatas.attach(tabla4).atTopTo(lab4, 5).atLeftTo(g2, 10).withHeight(85).withWidth(850);
		
		//--------------------Sanciones--------------
		TabItem tabItem_3 = new TabItem(tabFolder, SWT.None);
		tabItem_3.setText(AbosMessages.get().LABEL_SANCTIONS);
		Composite g3 = new Composite(tabFolder, SWT.BORDER);
		g3.setData(RWT.CUSTOM_VARIANT, "gray_background");
		tabItem_3.setControl(g3);
		
		g3.setLayout(new FormLayout());
		FormDatas.attach(g3).atTopTo(tabFolder, 1);
		
		Label lab5 = new Label(g3, SWT.NONE);
		lab5.setText(AbosMessages.get().LABEL_USER_CURRENT_LOAN_SANCTIONS);
		FormDatas.attach(lab5).atTopTo(g3, 15).atLeftTo(g3, 10);
		  
		Table tabla5 = new Table(g3, SWT.BORDER | SWT.FULL_SELECTION);
		tabla5.setHeaderVisible(true);
		tabla5.setLinesVisible(true);
	
		TableColumn columna102 = new TableColumn(tabla5, SWT.NONE);
		columna102.setWidth(150);
		columna102.setText("Tipo de Sancion");
		
		TableColumn columna32 = new TableColumn(tabla5, SWT.NONE);
		columna32.setWidth(100);
		columna32.setText("Fecha");
		
		TableColumn columna42 = new TableColumn(tabla5, SWT.NONE);
		columna42.setWidth(100);
		columna42.setText("Duracion");
		
		TableColumn columna202 = new TableColumn(tabla5, SWT.NONE);
		columna202.setWidth(100);
		columna202.setText("Motivo");
		
		TableColumn columna122 = new TableColumn(tabla5, SWT.NONE);
		columna122.setWidth(150);
		columna122.setText("Objeto Asociado");

		TableColumn columna232 = new TableColumn(tabla5, SWT.NONE);
		columna232.setWidth(100);
		columna232.setText("Precio");
		
		TableColumn columna242 = new TableColumn(tabla5, SWT.NONE);
		columna242.setWidth(130);
		columna242.setText("Acciones");
		
		FormDatas.attach(tabla5).atTopTo(lab5, 5).atLeftTo(g3, 10).withHeight(85).withWidth(850);

		//---------------
		Button boton1 = new Button(grupo, SWT.PUSH);
		Button boton2 = new Button(grupo, SWT.PUSH);
		Button boton3 = new Button(grupo, SWT.PUSH);
		
		boton1.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		boton2.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		boton3.setText(AbosMessages.get().BUTTON_CLOSE);
		
		FormDatas.attach(boton1).atTopTo(tabFolder, 5).atLeftTo(grupo,460);
		FormDatas.attach(boton2).atTopTo(tabFolder, 5).atLeftTo(boton1,20);
		FormDatas.attach(boton3).atTopTo(tabFolder, 5).atLeftTo(boton2,20);
					
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
