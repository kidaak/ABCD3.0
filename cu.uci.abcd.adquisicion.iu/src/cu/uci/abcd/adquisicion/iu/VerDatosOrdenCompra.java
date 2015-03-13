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
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class VerDatosOrdenCompra implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Ver datos de la orden de compra";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "Ver datos de la orden de compra";
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
		Composite composite2 = new Composite(gp1, SWT.NONE);
		
		composite.setData(RWT.CUSTOM_VARIANT,"gray_background");
		composite2.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		parent.setLayout(layout);
		gp1.setLayout(layout);
		composite.setLayout(layout);
		composite2.setLayout(layout);
		
		gp1.setText("Ver Datos de la Orden de Compra");
		
		FormDatas.attach(gp1).atLeftTo(parent, 20);
		
		FormDatas.attach(composite).atTopTo(gp1, 0);
		
		Label lab1 = new Label(composite, SWT.NONE);
		lab1.setText(AbosMessages.get().LABEL_DETAILS_OF_PURCHASE_ORDER);
		
		FormDatas.attach(lab1).atTopTo(composite, 5);
		
        Table tab = new Table(composite, SWT.BORDER);
		
		tab.setHeaderVisible(false);
		tab.setLinesVisible(true);
		
		TableColumn tc = new TableColumn(tab, SWT.CENTER);
		tc.setWidth(250);
		
		TableColumn tc2 = new TableColumn(tab, SWT.CENTER);
		tc2.setWidth(250);
		
		TableItem ti = new TableItem(tab, SWT.NONE);
		ti.setText(0, "Identificador");
		
		TableItem ti2 = new TableItem(tab, SWT.NONE);
		ti2.setText(0, "Fecha");
		
		TableItem ti3 = new TableItem(tab, SWT.NONE);
		ti3.setText(0, "Proveedor");
		
		TableItem ti4 = new TableItem(tab, SWT.NONE);
		ti4.setText(0, "Monto Total");
		
		FormDatas.attach(tab).atTopTo(lab1, 5);
		
		
		Table tab2 = new Table(composite, SWT.BORDER);
			
	    tab2.setHeaderVisible(false);
	    tab2.setLinesVisible(true);
			
		TableColumn tc3 = new TableColumn(tab2, SWT.CENTER);
		tc3.setWidth(200);
			
		TableColumn tc4 = new TableColumn(tab2, SWT.CENTER);
		tc4.setWidth(200);
			
		TableItem ti5 = new TableItem(tab2, SWT.NONE);
		ti5.setText(0, "Nombre y Apellidos");
			
		TableItem ti6 = new TableItem(tab2, SWT.NONE);
		ti6.setText(0, "Usuario");
			
		TableItem ti7 = new TableItem(tab2, SWT.NONE);
		ti7.setText(0, "Fecha");
			
		FormDatas.attach(tab2).atTopTo(lab1, 5).atLeftTo(tab, 25);
		
        Table tab3 = new Table(composite, SWT.BORDER);
		
		tab3.setHeaderVisible(true);
		tab3.setLinesVisible(true);
		
		TableColumn tc5 = new TableColumn(tab3, SWT.CENTER);
		tc5.setText("Título");
		tc5.setWidth(280);
		
		TableColumn tc6 = new TableColumn(tab3, SWT.CENTER);
		tc6.setText("Autor");
		tc6.setWidth(180);
		
		TableColumn tc7 = new TableColumn(tab3, SWT.CENTER);
		tc7.setText("Editor");
		tc7.setWidth(180);
		
		TableColumn tc8 = new TableColumn(tab3, SWT.CENTER);
		tc8.setText("Cantidad");
		tc8.setWidth(100);
		
		TableColumn tc9 = new TableColumn(tab3, SWT.CENTER);
		tc9.setText("Precio UM");
		tc9.setWidth(100);
		
		TableColumn tc10 = new TableColumn(tab3, SWT.CENTER);
		tc10.setText("Acciones");
		tc10.setWidth(100);
		
		
		TableItem ti8 = new TableItem(tab3, SWT.NONE);
		
		TableItem ti9 = new TableItem(tab3, SWT.NONE);
		
		FormDatas.attach(tab3).atTopTo(tab, 10);
		
		FormDatas.attach(composite2).atTopTo(composite, 15);
		
		Button bt1 = new Button(composite2, SWT.PUSH);
		bt1.setText(AbosMessages.get().BUTTON_EDIT);
		
		Button bt2 = new Button(composite2, SWT.PUSH);
		bt2.setText(AbosMessages.get().BUTTON_DELETE);
		
		Button bt3 = new Button(composite2, SWT.PUSH);
		bt3.setText(AbosMessages.get().BUTTON_CLOSE);
		
		Button bt4 = new Button(composite2, SWT.PUSH);
		bt4.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);
		
		Button bt5 = new Button(composite2, SWT.PUSH);
		bt5.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		
		FormDatas.attach(bt1).atTopTo(composite, 0).atLeftTo(composite2,615);
		FormDatas.attach(bt2).atTopTo(composite2,0).atLeftTo(bt1, 10);
		FormDatas.attach(bt3).atTopTo(composite2,0).atLeftTo(bt2, 10);
		FormDatas.attach(bt4).atTopTo(bt1,30).atLeftTo(composite2, 615);
		FormDatas.attach(bt5).atTopTo(bt1,30).atLeftTo(bt4, 10);
		
		
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
