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
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ViewObjectLoan implements IContributor{

	@Override
	public String contributorName() {
		return "Ver Objetos de Préstamos";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		parent.setLayout(new FormLayout());
		Composite grupo = new Composite(parent, SWT.BORDER);
		//grupo.setText("VER OBJETO DE PRESTAMO");
		grupo.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo.setLayout(new FormLayout());
		FormDatas.attach(grupo).atLeftTo(parent, 95).atTopTo(parent, 15);
		
		Label lab1 = new Label(grupo, SWT.NONE);
		lab1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		FormDatas.attach(lab1).atTopTo(grupo, 5);
		
		Label lab2 = new Label(grupo, SWT.NORMAL);
		lab2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));
		FormDatas.attach(lab2).atTopTo(grupo, 5).atLeftTo(lab1, 130);
		
		Table tabla = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);
			
		TableItem tableItem_1 = new TableItem(tabla, SWT.NORMAL);
		tableItem_1.setText("Título");
		
		TableItem tableItem = new TableItem(tabla, SWT.END);
		tableItem.setText("Autor");
					
		TableItem tableItem_2 = new TableItem(tabla, SWT.NONE);
		tableItem_2.setText("Volumen");
			
		TableItem tableItem_3 = new TableItem(tabla, SWT.NONE);
		tableItem_3.setText("Tomo");

		TableItem tableItem_4 = new TableItem(tabla, SWT.NONE);
		tableItem_4.setText("No. Control");
		
		TableItem tableItem_5 = new TableItem(tabla, SWT.NONE);
		tableItem_5.setText("Tipo de Objeto");
		
		TableItem tableItem_6 = new TableItem(tabla, SWT.NONE);
		tableItem_6.setText("Estado");
		
		TableItem tableItem_7 = new TableItem(tabla, SWT.NONE);
		tableItem_7.setText("Ubicación");
		
		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		columna1.setText("");
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(125);
		columna2.setText("");
			
		FormDatas.attach(tabla).atTopTo(lab1, 5);
			
		//------------------------------tabla 2
		Table tabla2 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
					
		TableItem tableItem1 = new TableItem(tabla2, SWT.NONE);
		tableItem1.setText("Nombre y Apellido");
			
		TableItem tableItem2 = new TableItem(tabla2, SWT.NONE);
		tableItem2.setText("Usuario");
							
		TableItem tableItem3 = new TableItem(tabla2, SWT.NONE);
		tableItem3.setText("Fecha y Hora");
					
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(140);
		columna11.setText("");
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
		columna22.setText("");	
		
		FormDatas.attach(tabla2).atTopTo(lab2, 5).atLeftTo(tabla, 30);
		
		Label label3 = new Label(grupo, SWT.NORMAL);
		label3.setText(AbosMessages.get().LABEL_OBSERVATIONS);
		FormDatas.attach(label3).atTopTo(tabla, 5);
		
		Text text2 = new Text(grupo, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(text2).atTopTo(label3, 5).withWidth(600).withHeight(50);
		
		Button boton1 = new Button(grupo, SWT.PUSH);
		Button boton2 = new Button(grupo, SWT.PUSH);
		Button boton3 = new Button(grupo, SWT.PUSH);
		Button boton4 = new Button(grupo, SWT.PUSH);
		
		boton1.setText(AbosMessages.get().BUTTON_CURRENT_STATUS);
		boton2.setText(AbosMessages.get().BUTTON_HISTORY);
		boton3.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_LOSS_REGISTER));
		boton4.setText(AbosMessages.get().BUTTON_CLOSE);

		FormDatas.attach(boton1).atTopTo(text2, 5).atLeftTo(grupo,155);
		FormDatas.attach(boton2).atTopTo(text2, 5).atLeftTo(boton1,20);
		FormDatas.attach(boton3).atTopTo(text2, 5).atLeftTo(boton2,20);
		FormDatas.attach(boton4).atTopTo(text2, 5).atLeftTo(boton3,20);
	
		return parent;
	}

	@Override
	public String getID() {
		return ViewObjectLoan.class.getSimpleName() + "id9";
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
