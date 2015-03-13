package cu.uci.abcd.adquisicion.iu;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
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

public class AsociarPedido implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Asociar Pedido";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "Asociar Pedido";
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
		
		gp1.setText("Asociar Pedido");
		
		FormDatas.attach(gp1).atLeftTo(parent, 110);
		
		Label lab1 = new Label(gp1, SWT.NONE);
		lab1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		
		Label lab2 = new Label(gp1, SWT.NONE);
		lab2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		
		Label lab3 = new Label(gp1, SWT.NONE);
		lab3.setText(AbosMessages.get().LABEL_AUTHOR);
		
		Label lab4 = new Label(gp1, SWT.NONE);
		lab4.setText(AbosMessages.get().LABEL_EDITOR);
		
		FormDatas.attach(lab1).atTopTo(gp1, 5);
		FormDatas.attach(lab2).atTopTo(lab1, 15).atLeftTo(gp1, 15);
		FormDatas.attach(lab3).atTopTo(lab1, 15).atLeftTo(lab2, 225);
		FormDatas.attach(lab4).atTopTo(lab1, 15).atLeftTo(lab3, 222);
		
		Text tex1 = new Text(gp1, SWT.BORDER);
		Text tex2 = new Text(gp1, SWT.BORDER);
		Text tex3 = new Text(gp1, SWT.BORDER);
		
		FormDatas.attach(tex1).atTopTo(lab2, 5).atLeftTo(gp1, 15).withWidth(180);
		FormDatas.attach(tex2).atTopTo(lab3, 5).atLeftTo(tex1, 50).withWidth(180);
		FormDatas.attach(tex3).atTopTo(lab4, 5).atLeftTo(tex2, 50).withWidth(180);
		
		Label lab6 = new Label(gp1, SWT.NONE);
		lab6.setText(MessageUtil.unescape(AbosMessages.get().LABEL_CREATION_DATE_RANGE));
		
		Label lab7 = new Label(gp1, SWT.NONE);
		lab7.setText(AbosMessages.get().LABEL_SINCE);
		
		Label lab8 = new Label(gp1, SWT.NONE);
		lab8.setText(AbosMessages.get().LABEL_UNTIL);
		
		FormDatas.attach(lab6).atTopTo(tex1, 25);
		FormDatas.attach(lab7).atTopTo(lab6, 5).atLeftTo(gp1, 15);
		FormDatas.attach(lab8).atTopTo(lab6, 5).atLeftTo(lab7, 220);
		
		DateTime dt1 = new DateTime(gp1, SWT.BORDER|SWT.DROP_DOWN);
		DateTime dt2 = new DateTime(gp1, SWT.BORDER|SWT.DROP_DOWN);
		
		FormDatas.attach(dt1).atTopTo(lab7, 5).withWidth(205).atLeftTo(gp1, 15);
		FormDatas.attach(dt2).atTopTo(lab8, 5).withWidth(205).atLeftTo(dt1, 50);
		
		Button bt1 = new Button(gp1, SWT.PUSH);
		bt1.setText(AbosMessages.get().BUTTON_CONSULT);
		
		Button bt2 = new Button(gp1, SWT.PUSH);
		bt2.setText(AbosMessages.get().BUTTON_CANCEL);
		
		FormDatas.attach(bt1).atTopTo(lab7, 5).atLeftTo(dt2, 50);
		FormDatas.attach(bt2).atTopTo(lab7, 5).atLeftTo(bt1, 10);
		
		FormDatas.attach(composite).atTopTo(bt1, 25);
		
        Table tab = new Table(composite, SWT.BORDER);
		
		tab.setHeaderVisible(true);
		tab.setLinesVisible(true);
		
		TableColumn tc = new TableColumn(tab, SWT.CENTER);
		tc.setText("Título");
		tc.setWidth(300);
		
		TableColumn tc2 = new TableColumn(tab, SWT.CENTER);
		tc2.setText("Autor");
		tc2.setWidth(100);
		
		TableColumn tc3 = new TableColumn(tab, SWT.CENTER);
		tc3.setText("Editor");
		tc3.setWidth(100);
		
		
		TableColumn tc4 = new TableColumn(tab, SWT.CENTER);
		tc4.setText("Identificador");
		tc4.setWidth(150);
		
		
		TableColumn tc5 = new TableColumn(tab, SWT.CENTER);
		tc5.setText("Acciones");
		tc5.setWidth(100);
		
		TableItem ti = new TableItem(tab, SWT.NONE);
		
		TableItem ti2 = new TableItem(tab, SWT.NONE);
		
		FormDatas.attach(tab).atTopTo(composite, 10).atLeftTo(composite, 15);
		
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
