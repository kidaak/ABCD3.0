package cu.uci.abcd.adquisicion.iu;

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

import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class VerDatosDelPedido implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Ver Datos del Pedido";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "Ver Datos del Pedido";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
        FormLayout layout = new FormLayout();
		
		Group gp1 = new Group(parent, SWT.NONE);
		Composite composite = new Composite(gp1, SWT.NONE);
		
		composite.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		parent.setLayout(layout);
		gp1.setLayout(layout);
		composite.setLayout(layout);
		
		gp1.setText("Ver Datos del Pedido");
		
		FormDatas.attach(gp1).atLeftTo(parent, 5);
		
		Label lab1 = new Label(gp1, SWT.NONE);
		lab1.setText(AbosMessages.get().LABEL_ORDER_DATA);
		
		Label lab2 = new Label(gp1, SWT.NONE);
		lab2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LAST_UPDATE));
		
		FormDatas.attach(lab1).atTopTo(gp1, 5);
		FormDatas.attach(lab2).atLeftTo(lab1, 388).atTopTo(gp1, 5);
		
		
        Table tab = new Table(gp1, SWT.BORDER);
		
		tab.setHeaderVisible(false);
		tab.setLinesVisible(true);
		
		TableColumn tc = new TableColumn(tab, SWT.CENTER);
		tc.setWidth(150);
		
		TableColumn tc1 = new TableColumn(tab, SWT.CENTER);
		tc1.setWidth(296);
		
		TableItem ti = new TableItem(tab, SWT.CENTER);
		TableItem ti1 = new TableItem(tab, SWT.CENTER);
		TableItem ti2 = new TableItem(tab, SWT.CENTER);
		TableItem ti3 = new TableItem(tab, SWT.CENTER);
		
		ti.setText(0, "Identificador");
		ti1.setText(0, "Título");
		ti2.setText(0, "Autor");
		ti3.setText(0, "Editor");
		
		FormDatas.attach(tab).atTopTo(lab1, 5);
		
        Table tab2 = new Table(gp1, SWT.BORDER);
		
		tab2.setHeaderVisible(false);
		tab2.setLinesVisible(true);
		
		TableColumn tc2 = new TableColumn(tab2, SWT.CENTER);
		tc2.setWidth(150);
		
		TableColumn tc3 = new TableColumn(tab2, SWT.CENTER);
		tc3.setWidth(296);
		
		TableItem ti4 = new TableItem(tab2, SWT.CENTER);
		TableItem ti5 = new TableItem(tab2, SWT.CENTER);
		TableItem ti6 = new TableItem(tab2, SWT.CENTER);
		
		
		ti4.setText(0, "Nombre y Apellidos");
		ti5.setText(0, "Usuario");
		ti6.setText(0, "Fecha");
		
		FormDatas.attach(tab2).atTopTo(lab2, 5).atLeftTo(tab, 25);
		
		FormDatas.attach(composite).atTopTo(tab, 10);
		
		Label lab3 = new Label(composite, SWT.NONE);
		lab3.setText(AbosMessages.get().LABEL_SUGGESTED_ASSOCIATED);
		
		FormDatas.attach(lab3).atTopTo(composite, 5);
		
        Table tab3 = new Table(composite, SWT.BORDER);
		
		tab3.setHeaderVisible(true);
		tab3.setLinesVisible(true);
		
		TableColumn tc4 = new TableColumn(tab3, SWT.CENTER);
		tc4.setWidth(280);
		tc4.setText("Título");
		
		TableColumn tc5 = new TableColumn(tab3, SWT.CENTER);
		tc5.setWidth(150);
		tc5.setText("Autor");
		
		TableColumn tc6 = new TableColumn(tab3, SWT.CENTER);
		tc6.setWidth(150);
		tc6.setText("Editor");
		
		TableColumn tc7 = new TableColumn(tab3, SWT.CENTER);
		tc7.setWidth(150);	
		tc7.setText("Sugerido por");
		
		TableColumn tc8 = new TableColumn(tab3, SWT.CENTER);
		tc8.setWidth(100);
		tc8.setText("Fecha");
		
		TableColumn tc9 = new TableColumn(tab3, SWT.CENTER);
		tc9.setWidth(100);
		tc9.setText("Razón");
		
		TableItem ti7 = new TableItem(tab3, SWT.CENTER);
		TableItem ti8 = new TableItem(tab3, SWT.CENTER);
		
		
		FormDatas.attach(tab3).atTopTo(lab3, 5);
		
		Button bt1 = new Button(composite, SWT.PUSH);
		bt1.setText(AbosMessages.get().BUTTON_EDIT);
		
		Button bt2 = new Button(composite, SWT.PUSH);
		bt2.setText(AbosMessages.get().BUTTON_DELETE);
		
		Button bt3 = new Button(composite, SWT.PUSH);
		bt3.setText(AbosMessages.get().BUTTON_CLOSE);
		
		Button bt4 = new Button(composite, SWT.PUSH);
		bt4.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);
		
		Button bt5 = new Button(composite, SWT.PUSH);
		bt5.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		
		FormDatas.attach(bt1).atTopTo(tab3, 15).atLeftTo(composite, 700);
		FormDatas.attach(bt2).atTopTo(tab3, 15).atLeftTo(bt1, 10);
		FormDatas.attach(bt3).atTopTo(tab3, 15).atLeftTo(bt2, 10);
		FormDatas.attach(bt4).atTopTo(bt1, 25).atLeftTo(composite, 650);
		FormDatas.attach(bt5).atTopTo(bt1, 25).atLeftTo(bt4, 10);
		
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
