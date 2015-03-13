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

import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ConsultarOrdenesDeCompra implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Consultar Ordenes de Compra";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "Consultar Ordenes de Compra";
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
		
		gp1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_CHECK_PURCHASE_ORDERS));
		
		FormDatas.attach(gp1).atLeftTo(parent, 10);
		
		Label lab1 = new Label(gp1, SWT.NONE);
		lab1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		
		Label lab2 = new Label(gp1, SWT.NONE);
		lab2.setText(AbosMessages.get().LABEL_IDENTIFIER);
		
		Label lab3 = new Label(gp1, SWT.NONE);
		lab3.setText(AbosMessages.get().LABEL_PROVIDER);
		
		Label lab4 = new Label(gp1, SWT.NONE);
		lab4.setText(AbosMessages.get().LABEL_STATE);
		
		FormDatas.attach(lab1).atTopTo(gp1, 5);
		FormDatas.attach(lab2).atTopTo(lab1, 15).atLeftTo(gp1, 15);
		FormDatas.attach(lab3).atTopTo(lab1, 15).atLeftTo(lab2, 163);
		FormDatas.attach(lab4).atTopTo(lab1, 15).atLeftTo(lab3, 172);
		
		Text tex1 = new Text(gp1, SWT.BORDER);
		
		Combo comb1 = new Combo(gp1, SWT.NONE);
		
		Combo comb2 = new Combo(gp1, SWT.NONE);
		
		FormDatas.attach(tex1).atTopTo(lab2, 5).atLeftTo(gp1, 15).withWidth(180);
		FormDatas.attach(comb1).atTopTo(lab3, 5).atLeftTo(tex1, 25).withWidth(202);
		FormDatas.attach(comb2).atTopTo(lab4, 5).atLeftTo(comb1, 25).withWidth(202);
		
		Label lab6 = new Label(gp1, SWT.NONE);
		lab6.setText(MessageUtil.unescape(AbosMessages.get().LABEL_CREATION_DATE_RANGE));
		
		Label lab7 = new Label(gp1, SWT.NONE);
		lab7.setText(AbosMessages.get().LABEL_SINCE);
		
		Label lab8 = new Label(gp1, SWT.NONE);
		lab8.setText(AbosMessages.get().LABEL_UNTIL);
		
		Label lab9 = new Label(gp1, SWT.NONE);
		lab9.setText(AbosMessages.get().LABEL_TOTAL_AMOUNT);
		
		Label lab10 = new Label(gp1, SWT.NONE);
		lab10.setText(AbosMessages.get().LABEL_CRITERION);
		
		Label lab11 = new Label(gp1, SWT.NONE);
		lab11.setText(AbosMessages.get().LABEL_COIN);
		
		
		FormDatas.attach(lab6).atTopTo(tex1, 25);
		FormDatas.attach(lab7).atTopTo(lab6, 5).atLeftTo(gp1, 15);
		FormDatas.attach(lab8).atTopTo(lab6, 5).atLeftTo(lab7, 195);
		FormDatas.attach(lab9).atTopTo(tex1, 25).atLeftTo(lab6, 315);
		FormDatas.attach(lab10).atTopTo(lab6, 5).atLeftTo(lab8, 198);
		FormDatas.attach(lab11).atTopTo(lab6, 5).atLeftTo(lab10, 306);
		
		DateTime dt1 = new DateTime(gp1, SWT.BORDER|SWT.DROP_DOWN);
		DateTime dt2 = new DateTime(gp1, SWT.BORDER|SWT.DROP_DOWN);
		
		Combo comb3 = new Combo(gp1, SWT.NONE);
		comb3.setText(AbosMessages.get().COMBO_HIGHER_THAN);
		
		Text tex2 = new Text(gp1, SWT.BORDER);
		
		Combo comb4 = new Combo(gp1, SWT.NONE);
		comb4.add("CUC", 0);
		comb4.add("CUP", 1);
		comb4.select(0);
		
		FormDatas.attach(dt1).atTopTo(lab7, 5).withWidth(205).atLeftTo(gp1, 15);
		FormDatas.attach(dt2).atTopTo(lab8, 5).withWidth(205).atLeftTo(dt1, 25);
		
		FormDatas.attach(comb3).atTopTo(lab10, 5).withWidth(202).atLeftTo(dt2, 25);
		FormDatas.attach(tex2).withWidth(70).atTopTo(lab10, 5).atLeftTo(comb3, 25);
		FormDatas.attach(comb4).atTopTo(lab10, 5).withWidth(101).atLeftTo(tex2, 25);
		
		FormDatas.attach(composite).atTopTo(dt1, 25);
		
		Button bt1 = new Button(composite, SWT.PUSH);
		bt1.setText(AbosMessages.get().BUTTON_CONSULT);
		
		Button bt2 = new Button(composite, SWT.PUSH);
		bt2.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		
		Button bt3 = new Button(composite, SWT.PUSH);
		bt3.setText(AbosMessages.get().BUTTON_CLOSE);
		
		FormDatas.attach(bt1).atTopTo(composite, 5).atLeftTo(composite, 655);
		FormDatas.attach(bt2).atTopTo(composite, 5).atLeftTo(bt1, 10);
		FormDatas.attach(bt3).atTopTo(composite, 5).atLeftTo(bt2, 10);
		
		Label lab12 = new Label(composite, SWT.NONE);
		lab12.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LIST_OF_PURCHASE_ORDERS));
		
		FormDatas.attach(lab12).atTopTo(bt1, 20);
		
        Table tab = new Table(composite, SWT.BORDER);
		
		tab.setHeaderVisible(true);
		tab.setLinesVisible(true);
		
		TableColumn tc = new TableColumn(tab, SWT.CENTER);
		tc.setText("Número de Orden");
		tc.setWidth(150);
		
		TableColumn tc2 = new TableColumn(tab, SWT.CENTER);
		tc2.setText("Proveedor");
		tc2.setWidth(150);
		
		TableColumn tc3 = new TableColumn(tab, SWT.CENTER);
		tc3.setText("Fecha");
		tc3.setWidth(120);
		
		
		TableColumn tc4 = new TableColumn(tab, SWT.CENTER);
		tc4.setText("Importe");
		tc4.setWidth(120);
		
		
		TableColumn tc5 = new TableColumn(tab, SWT.CENTER);
		tc5.setText("Estado");
		tc5.setWidth(120);
		
		TableColumn tc6 = new TableColumn(tab, SWT.CENTER);
		tc6.setText("Acciones");
		tc6.setWidth(150);
		
		TableItem ti = new TableItem(tab, SWT.NONE);
		
		TableItem ti2 = new TableItem(tab, SWT.NONE);
		
		FormDatas.attach(tab).atTopTo(lab12, 10);
		
		Button bt4 = new Button(composite, SWT.PUSH);
		bt4.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		
		Button bt5 = new Button(composite, SWT.PUSH);
		bt5.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		
		FormDatas.attach(bt4).atTopTo(tab, 15).atLeftTo(composite, 640);
		FormDatas.attach(bt5).atTopTo(tab, 15).atLeftTo(bt4, 10);
		
		
		
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
