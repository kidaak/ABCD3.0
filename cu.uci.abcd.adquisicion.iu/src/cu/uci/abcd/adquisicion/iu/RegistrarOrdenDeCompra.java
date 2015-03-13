package cu.uci.abcd.adquisicion.iu;

import org.eclipse.rap.rwt.RWT;
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

import cu.uci.abcd.adquisicion.iu.domain.ListadoDePedidosPendientesEntity;
import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;

public class RegistrarOrdenDeCompra implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Orden de Compra";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistrarOrdenCompraID";
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
		
		gp1.setText("Registrar Orden de Compra");
		
		FormDatas.attach(gp1).atLeftTo(parent, 15);
		
		FormDatas.attach(composite).atTopTo(gp1, 0);
		
		Label lab1 = new Label(composite, SWT.NONE);
		lab1.setText(AbosMessages.get().LABEL_DATE);
		
		Label lab2 = new Label(composite, SWT.NONE);
		lab2.setText(AbosMessages.get().LABEL_PROVIDER);
		
		Label lab3 = new Label(composite, SWT.NONE);
		lab3.setText(AbosMessages.get().LABEL_COIN);
		
		FormDatas.attach(lab1).atTopTo(composite, 5);
		FormDatas.attach(lab2).atTopTo(composite, 5).atLeftTo(lab1, 250);
		FormDatas.attach(lab3).atTopTo(composite, 5).atLeftTo(lab2, 230);
		
		DateTime dt1 = new DateTime(composite, SWT.BORDER|SWT.DROP_DOWN);
		Combo comb1 = new Combo(composite, SWT.NONE);
		Combo comb2 = new Combo(composite, SWT.NONE);
		
		FormDatas.attach(dt1).atTopTo(lab1, 5).withWidth(205);
		FormDatas.attach(comb1).atTopTo(lab2, 5).atLeftTo(dt1, 80).withWidth(203);
		FormDatas.attach(comb2).atTopTo(lab3, 5).atLeftTo(comb1, 80).withWidth(203);
		
		Label lab4 = new Label(composite, SWT.NONE);
		lab4.setText(AbosMessages.get().LABEL_LIST_OF_PENDING_ORDERS);
		
		FormDatas.attach(lab4).atTopTo(dt1, 25);
		
		final CRUDTreeTable tab = new CRUDTreeTable(composite, SWT.BORDER);
        //Table tab = new Table(composite, SWT.BORDER);
		FormDatas.attach(tab).atTopTo(lab4, 5);
		tab.setEntityClass(ListadoDePedidosPendientesEntity.class);
				
	/*	TableColumn tc = new TableColumn(tab, SWT.CENTER);
		tc.setText("Título");
		tc.setWidth(300);
		
		TableColumn tc2 = new TableColumn(tab, SWT.CENTER);
		tc2.setText("Autor");
		tc2.setWidth(200);
		
		TableColumn tc3 = new TableColumn(tab, SWT.CENTER);
		tc3.setText("Editor");
		tc3.setWidth(200);
		
		TableColumn tc4 = new TableColumn(tab, SWT.CENTER);
		tc4.setText("Acciones");
		tc4.setWidth(100);
		
		TableItem ti = new TableItem(tab, SWT.NONE);
		
		TableItem ti2 = new TableItem(tab, SWT.NONE);
		
		*/
		
        
		Table tab2 = new Table(composite, SWT.BORDER);
		
		tab2.setHeaderVisible(false);
		tab2.setLinesVisible(true);
		
		TableColumn tc5 = new TableColumn(tab2, SWT.CENTER);
		tc5.setWidth(250);
		
		TableColumn tc6 = new TableColumn(tab2, SWT.CENTER);
		tc6.setWidth(250);
		
		TableItem ti3 = new TableItem(tab2, SWT.NONE);
		ti3.setText(0, "Título");
		
		TableItem ti4 = new TableItem(tab2, SWT.NONE);
		ti4.setText(0, "Autor");
		
		TableItem ti5 = new TableItem(tab2, SWT.NONE);
		ti5.setText(0, "Editorial");
		
		FormDatas.attach(tab2).atTopTo(tab, 10);
		
		FormDatas.attach(composite2).atTopTo(composite, 5);
		
		Label lab5 = new Label(composite2, SWT.NONE);
		lab5.setText(AbosMessages.get().LABEL_NUMBER_OF_COPIES);
		
		Label lab6 = new Label(composite2, SWT.NONE);
		lab6.setText(AbosMessages.get().LABEL_PRICE_OF_A_COPY);
		
		FormDatas.attach(lab5).atLeftTo(composite2, 15).atTopTo(composite2, 5);
		FormDatas.attach(lab6).atLeftTo(lab5, 150).atTopTo(composite2, 5);
		
		Text tex1 = new Text(composite2, SWT.BORDER);
		Text tex2 = new Text(composite2, SWT.BORDER);
		
		Button bt1 = new Button(composite2, SWT.PUSH);
		bt1.setText(AbosMessages.get().BUTTON_ADD);
		
		Button bt2 = new Button(composite2, SWT.PUSH);
		bt2.setText(AbosMessages.get().BUTTON_CANCEL);
		
		FormDatas.attach(tex1).atTopTo(lab5, 5).withWidth(180).atLeftTo(composite2, 15);
		FormDatas.attach(tex2).atTopTo(lab6, 5).withWidth(180).atLeftTo(tex1, 80);
		FormDatas.attach(bt1).atTopTo(lab6, 5).atLeftTo(tex2, 12);
		FormDatas.attach(bt2).atTopTo(lab6, 5).atLeftTo(bt1, 10);
		
		Label lab7 = new Label(composite2, SWT.NONE);
		lab7.setText(AbosMessages.get().LABEL_ORDERS_ASSOCIATE);
		
		FormDatas.attach(lab7).atTopTo(tex1, 25);
		
        Table tab3 = new Table(composite2, SWT.BORDER);
		
		tab3.setHeaderVisible(true);
		tab3.setLinesVisible(true);
		
		TableColumn tc7 = new TableColumn(tab3, SWT.CENTER);
		tc7.setText("Título");
		tc7.setWidth(300);
		
		TableColumn tc8 = new TableColumn(tab3, SWT.CENTER);
		tc8.setText("Autor");
		tc8.setWidth(200);
		
		TableColumn tc9 = new TableColumn(tab3, SWT.CENTER);
		tc9.setText("Editorial");
		tc9.setWidth(150);
		
		
		TableColumn tc10 = new TableColumn(tab3, SWT.CENTER);
		tc10.setText("Cantidad");
		tc10.setWidth(100);
		
		
		TableColumn tc11 = new TableColumn(tab3, SWT.CENTER);
		tc11.setText("Precio");
		tc11.setWidth(100);
		
		TableColumn tc12 = new TableColumn(tab3, SWT.CENTER);
		tc12.setText("Acciones");
		tc12.setWidth(100);
		
		TableItem ti6 = new TableItem(tab3, SWT.NONE);
		
		TableItem ti7 = new TableItem(tab3, SWT.NONE);
		
		FormDatas.attach(tab3).atTopTo(lab7, 5);
		
		Table tab4 = new Table(composite2, SWT.BORDER);
		
		tab4.setHeaderVisible(false);
		tab4.setLinesVisible(true);
		
		TableColumn tc13 = new TableColumn(tab4, SWT.CENTER);
		tc13.setWidth(100);
		
		TableColumn tc14 = new TableColumn(tab4, SWT.CENTER);
		tc14.setWidth(100);
		
		TableItem ti8 = new TableItem(tab4, SWT.NONE);
		ti8.setText(0, "Monto Total:");
		
		FormDatas.attach(tab4).atTopTo(tab3, 25);
		
		Button bt3 = new Button(composite2, SWT.PUSH);
		bt3.setText(AbosMessages.get().BUTTON_ACCEPT);
		
		Button bt4 = new Button(composite2, SWT.PUSH);
		bt4.setText(AbosMessages.get().BUTTON_CANCEL);
		
		FormDatas.attach(bt3).atTopTo(tab3, 25).atLeftTo(composite2, 785);
		FormDatas.attach(bt4).atTopTo(tab3, 25).atLeftTo(bt3, 10);
		
		
		
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
