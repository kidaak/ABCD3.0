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

public class RegisterLoanWithoutReservations implements IContributor{

	@Override
	public String contributorName() {
		return "Visualizar Transaccion sin Reservacion ";
	}
	@Override
	public String getID() {
		return RegisterLoanWithoutReservations.class.getSimpleName() + "id30";
	}

	@Override
	public Control createUIControl(Composite parent) {
		parent.setLayout(new FormLayout());
		Composite grupo = new Composite(parent, SWT.BORDER);
		//grupo.setText("REGISTRAR PRESTAMO EXTERNO");
		grupo.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo.setLayout(new FormLayout());
		FormDatas.attach(grupo).atLeftTo(parent, 95).atTopTo(parent, 15);
		
		Label lab2 = new Label(grupo, SWT.None);
		lab2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		FormDatas.attach(lab2).atTopTo(grupo, 5);
				
		Label insertarE = new Label(grupo, SWT.NONE);
		insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		
		FormDatas.attach(insertarE).atTopTo(lab2, 5);
		
		Table tabla = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
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
		
		FormDatas.attach(tabla).atTopTo(lab2, 5).atLeftTo(insertarE, 10);
		
		Label lab = new Label(grupo, SWT.None);
		lab.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
		FormDatas.attach(lab).atTopTo(grupo, 5).atLeftTo(lab2, 230);
		
		Table tabla2 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);

		TableItem tableItem1 = new TableItem(tabla2, SWT.NONE);
		tableItem1.setText("Titulo");

		TableItem tableItem0 = new TableItem(tabla2, SWT.NONE);
		tableItem0.setText("Autor");

		TableItem tableItem2 = new TableItem(tabla2, SWT.NONE);
		tableItem2.setText("No. de Control");

		TableItem tableItem3 = new TableItem(tabla2, SWT.NONE);
		tableItem3.setText("Tipo de Objeto");
		
		TableItem tableItem4 = new TableItem(tabla2, SWT.NONE);
		tableItem4.setText("Estado");

		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(125);
		columna11.setText("");
		TableColumn columna12 = new TableColumn(tabla2, SWT.NONE);
		columna12.setWidth(90);
		columna12.setText("");
		
		FormDatas.attach(tabla2).atTopTo(lab, 5).atLeftTo(tabla, 60);
		
		Label separador= new Label(grupo, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(tabla, 5).withWidth(700);
		
     //----------------------------------------------------
		
		Label lab1 = new Label(grupo, SWT.None);
		lab1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRY_DATA_LOAN));
		FormDatas.attach(lab1).atTopTo(separador, 5).atLeftTo(grupo, 15);
		
		Table tabla3 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla3.setHeaderVisible(false);
		tabla3.setLinesVisible(true);

		TableItem tableItem_11 = new TableItem(tabla3, SWT.NONE);
		tableItem_11.setText("Fecha");

		TableItem tableIte = new TableItem(tabla3, SWT.NONE);
		tableIte.setText("Hora");

		TableItem tableItem_12 = new TableItem(tabla3, SWT.NONE);
		tableItem_12.setText("Tipo");

		TableItem tableItem_13 = new TableItem(tabla3, SWT.NONE);
		tableItem_13.setText("Duracion");
		
		TableItem tableItem_14 = new TableItem(tabla3, SWT.NONE);
		tableItem_14.setText("Entrega");

		TableItem tableItem_15 = new TableItem(tabla3, SWT.NONE);
		tableItem_15.setText("Bibliotecario");
		
		TableItem tableItem_16 = new TableItem(tabla3, SWT.NONE);
		tableItem_16.setText("Usuario");
		
		TableColumn columna_11 = new TableColumn(tabla3, SWT.NONE);
		columna_11.setWidth(125);
		columna_11.setText("");
		TableColumn columna_12 = new TableColumn(tabla3, SWT.NONE);
		columna_12.setWidth(90);
		columna_12.setText("");
		
		FormDatas.attach(tabla3).atTopTo(lab1, 5).atLeftTo(grupo, 15);
		
		
        Button boton1 = new Button(grupo, SWT.PUSH);
        Button boton2 = new Button(grupo, SWT.PUSH);
        Button boton3 = new Button(grupo, SWT.PUSH);
        
		boton1.setText(AbosMessages.get().BUTTON_RETURN);
		boton2.setText(AbosMessages.get().BUTTON_RENEW);
		boton3.setText(AbosMessages.get().BUTTON_CLOSE);
		
		FormDatas.attach(boton1).atTopTo(tabla3, 5).atLeftTo(grupo, 320).withWidth(100).withHeight(23);
		FormDatas.attach(boton2).atTopTo(tabla3, 5).atLeftTo(boton1, 20).withWidth(100).withHeight(23);
		FormDatas.attach(boton3).atTopTo(tabla3, 5).atLeftTo(boton2, 20).withWidth(100).withHeight(23);
						
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
		// TODO Auto-generated method stub
		
	}

}
