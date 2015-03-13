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
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegistrarPedidoConSugerenciasAsociadas implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Pedido con Sugerencias Asociadas";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistrarPedidoSugerenciaID";
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
		
		gp1.setText("Registrar Pedido");
		
		FormDatas.attach(gp1).atLeftTo(parent, 92);
		
		Label lab1 = new Label(gp1, SWT.NONE);
		Label lab2 = new Label(gp1, SWT.NONE);
		Label lab3 = new Label(gp1, SWT.NONE);
		
		lab1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		lab2.setText(AbosMessages.get().LABEL_AUTHOR);
		lab3.setText(AbosMessages.get().LABEL_EDITOR);
		
		FormDatas.attach(lab1).atTopTo(gp1, 5);
		FormDatas.attach(lab2).atTopTo(gp1, 5).atLeftTo(lab1, 265);
		FormDatas.attach(lab3).atTopTo(gp1, 5).atLeftTo(lab2, 265);
		
		Text tex1 = new Text(gp1, SWT.BORDER);
		Text tex2 = new Text(gp1, SWT.BORDER);
		Text tex3 = new Text(gp1, SWT.BORDER);
		
		FormDatas.attach(tex1).atTopTo(lab1, 5).atLeftTo(gp1, 0).withWidth(200);
		FormDatas.attach(tex2).atTopTo(lab2, 5).atLeftTo(tex1, 72).withWidth(200);
		FormDatas.attach(tex3).atTopTo(lab3, 5).atLeftTo(tex2, 72).withWidth(200);
		
		Label lab4 = new Label(gp1, SWT.NONE);
		lab4.setText(AbosMessages.get().LABEL_LIST_OF_APPROVED_SUGGESTION);
		
		FormDatas.attach(lab4).atTopTo(tex1, 30);
		
		Table tab = new Table(gp1, SWT.BORDER);
		
		tab.setHeaderVisible(true);
		tab.setLinesVisible(true);
		
		TableColumn tc = new TableColumn(tab, SWT.CENTER);
		tc.setText("Título");
		tc.setWidth(100);
		
		TableColumn tc2 = new TableColumn(tab, SWT.CENTER);
		tc2.setText("Autor");
		tc2.setWidth(100);
		
		TableColumn tc3 = new TableColumn(tab, SWT.CENTER);
		tc3.setText("Editor");
		tc3.setWidth(100);
		
		
		TableColumn tc4 = new TableColumn(tab, SWT.CENTER);
		tc4.setText("Sugerido por");
		tc4.setWidth(300);
		
		
		TableColumn tc5 = new TableColumn(tab, SWT.CENTER);
		tc5.setText("Fecha");
		tc5.setWidth(100);
		
		TableColumn tc6 = new TableColumn(tab, SWT.CENTER);
		tc6.setText("Acciones");
		tc6.setWidth(100);
		
		TableItem ti = new TableItem(tab, SWT.NONE);
		
		TableItem ti2 = new TableItem(tab, SWT.NONE);
		
		FormDatas.attach(tab).atTopTo(tex1, 50);
		
		FormDatas.attach(composite).atTopTo(tab, 15);
		
		Label lab5 = new Label(composite, SWT.NONE);
		lab5.setText(AbosMessages.get().LABEL_LIST_OF_SUGGESTION_FOR_ASSOCIATING);
		
		FormDatas.attach(lab5).atTopTo(composite, 10);
		
		
        Table tab2 = new Table(composite, SWT.BORDER);
		
		tab2.setHeaderVisible(true);
		tab2.setLinesVisible(true);
		
		TableColumn tc7 = new TableColumn(tab2, SWT.CENTER);
		tc7.setText("Título");
		tc7.setWidth(100);
		
		TableColumn tc8 = new TableColumn(tab2, SWT.CENTER);
		tc8.setText("Autor");
		tc8.setWidth(100);
		
		TableColumn tc9 = new TableColumn(tab2, SWT.CENTER);
		tc9.setText("Editor");
		tc9.setWidth(100);
		
		
		TableColumn tc10 = new TableColumn(tab2, SWT.CENTER);
		tc10.setText("Sugerido por");
		tc10.setWidth(300);
		
		
		TableColumn tc11 = new TableColumn(tab2, SWT.CENTER);
		tc11.setText("Fecha");
		tc11.setWidth(100);
		
		TableColumn tc12 = new TableColumn(tab2, SWT.CENTER);
		tc12.setText("Acciones");
		tc12.setWidth(100);
		
		TableItem ti3 = new TableItem(tab2, SWT.NONE);
		
		TableItem ti4 = new TableItem(tab2, SWT.NONE);
		
		FormDatas.attach(tab2).atTopTo(lab5, 5);
		
		Button bt1 = new Button(composite, SWT.CENTER);
		bt1.setText(AbosMessages.get().BUTTON_ACCEPT);
		
		Button bt2 = new Button(composite, SWT.CENTER);
		bt2.setText(AbosMessages.get().BUTTON_CANCEL);
		
		FormDatas.attach(bt1).atTopTo(tab2, 30).atLeftTo(composite, 630).withWidth(80);
		
		FormDatas.attach(bt2).atTopTo(tab2, 30).atLeftTo(bt1, 20).withWidth(80);
		
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
