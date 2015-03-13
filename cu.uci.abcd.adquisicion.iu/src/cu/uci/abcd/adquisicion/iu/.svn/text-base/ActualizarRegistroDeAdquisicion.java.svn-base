package cu.uci.abcd.adquisicion.iu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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

public class ActualizarRegistroDeAdquisicion implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Actualizar Registro de Adquisicion";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ActualizarAdquisicionID";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub

		Group group = new Group(parent, SWT.NONE);
		group.setText("ACTUALIZAR REGISTRO DE ADQUISICIÓN");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label label = new Label(group, SWT.NONE);
		FormDatas.attach(label).atTopTo(group,10).atLeft(23);
		label.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRY_DATA_ACQUISITION));

		Label titulo = new Label(group, SWT.NONE);
		FormDatas.attach(titulo).atTopTo(label,10).atLeft(33);
		titulo.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));

		Text  text = new Text(group, SWT.BORDER);
		FormDatas.attach(text).atTopTo(titulo,6).atLeft(33).withHeight(10).withWidth(200);
		

		Label autor = new Label(group, SWT.NONE);
		FormDatas.attach(autor).atTopTo(text,10).atLeft(33);
		autor.setText(AbosMessages.get().LABEL_AUTHOR);

		Text  txtAutor = new Text(group, SWT.BORDER);
		FormDatas.attach(txtAutor).atTopTo(autor,6).atLeft(33).withHeight(10).withWidth(200);
		

		Label editor = new Label(group, SWT.NONE);
		FormDatas.attach(editor).atTopTo(txtAutor,10).atLeft(33);
		editor.setText(AbosMessages.get().LABEL_EDITOR);


		Text  txtEditor = new Text(group, SWT.BORDER);
		FormDatas.attach(txtEditor).atTopTo(editor,6).atLeft(33).withHeight(10).withWidth(200);
		
		Label annoDepublic = new Label(group, SWT.NONE);
		FormDatas.attach(annoDepublic).atTopTo(txtEditor,10).atLeft(33);
		annoDepublic.setText(MessageUtil.unescape(AbosMessages.get().LABEL_YEAR_OF_PUBLICATION));


		Text  txtAnnoDepublic = new Text(group, SWT.BORDER);
		FormDatas.attach(txtAnnoDepublic).atTopTo(annoDepublic,6).atLeft(33).withHeight(10).withWidth(200);
		
		Label tipoMaterial = new Label(group, SWT.NONE);
		FormDatas.attach(tipoMaterial).atTopTo(txtAnnoDepublic,10).atLeft(33);
		tipoMaterial.setText(AbosMessages.get(). LABEL_MATERIAL_TYPE);


		Combo  txtTipoMaterial = new Combo(group, SWT.BORDER);
		FormDatas.attach(txtTipoMaterial).atTopTo(tipoMaterial,6).atLeft(33).withHeight(23).withWidth(220);
		
		Label sala = new Label(group, SWT.NONE);
		FormDatas.attach(sala).atTopTo(txtTipoMaterial,10).atLeft(33);
		sala.setText(AbosMessages.get().LABEL_ROOM);

		Combo  txtSala = new Combo(group, SWT.BORDER);
		FormDatas.attach(txtSala).atTopTo(sala,6).atLeft(33).withHeight(23).withWidth(220);
		
		Button actualizar= new Button(group, SWT.None);
		FormDatas.attach(actualizar).atTopTo(txtSala,6).atLeftTo(txtSala,33);
		actualizar.setText(AbosMessages.get().BUTTON_UPDATE);

		Button cancelar= new Button(group, SWT.None);
		FormDatas.attach(cancelar).atTopTo(txtSala,6).atLeftTo(actualizar, 10);
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
