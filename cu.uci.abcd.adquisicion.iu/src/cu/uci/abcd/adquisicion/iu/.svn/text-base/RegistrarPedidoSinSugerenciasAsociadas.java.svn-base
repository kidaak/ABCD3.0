package cu.uci.abcd.adquisicion.iu;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegistrarPedidoSinSugerenciasAsociadas implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Pedido sin Sugerencias Asociadas";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistrarPedidoSinSugerenciaID";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub

		Group group = new Group(parent, SWT.NONE);
		group.setText("REGISTRAR PEDIDO SIN SUGERENCIAS ASOCIADAS");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label titulo = new Label(group, SWT.NONE);
		FormDatas.attach(titulo).atTop(15).atLeft(33);
		titulo.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));

		Text text = new Text(group, SWT.BORDER);
		FormDatas.attach(text).atTopTo(titulo,6).atLeft(33).withWidth(150);


		Label lblAutor= new Label(group, SWT.NONE);
		FormDatas.attach(lblAutor).atTop(15).atLeftTo(text,20);
		lblAutor.setText(AbosMessages.get().LABEL_AUTHOR);

		Text txtAutor = new Text(group, SWT.BORDER);
		FormDatas.attach(txtAutor).atTopTo(lblAutor,6).atLeftTo(text,20).withWidth(150);


		Label lblEditor = new Label(group, SWT.NONE);
		FormDatas.attach(lblEditor).atTop(15).atLeftTo(txtAutor,20);
		lblEditor.setText(AbosMessages.get().LABEL_EDITOR);

		Text editor = new Text(group, SWT.BORDER);
		FormDatas.attach(editor).atTopTo(lblEditor,6).atLeftTo(txtAutor,20).withWidth(150);

		Button aceptar = new Button(group, SWT.NONE);
		FormDatas.attach(aceptar).atTopTo(txtAutor, 20).atLeftTo(txtAutor,20);
		aceptar.setText(AbosMessages.get().BUTTON_ACEPT);

		Button cancelar = new Button(group, SWT.NONE);
		FormDatas.attach(cancelar).atTopTo(txtAutor, 20).atLeftTo(aceptar, 10);
		cancelar.setText(AbosMessages.get().BUTTON_CANCEL);
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
