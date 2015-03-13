package cu.uci.abcd.adquisicion.iu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unesco.jisis.corelib.common.Global;
import org.unesco.jisis.corelib.record.Field;
import org.unesco.jisis.corelib.record.IField;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abos.l10n.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegistrarRegistroDeAdquisicion implements IContributor {

	private IViewController controller;



	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Registro de Adquisición";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return RegistrarRegistroDeAdquisicion.class.getSimpleName()+"id5";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición"; 
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		Group group = new Group(parent, SWT.NONE);
		group.setText("REGISTRAR REGISTRO DE ADQUISICIÓN ");

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);


		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new FormData());
		FormDatas.attach(label).atTop(10).atLeft(3);
		label.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRY_DATA_ACQUISITION));

		Label numeroControl = new Label(group,SWT.NONE);
		numeroControl.setLayoutData(new FormData());
		FormDatas.attach(numeroControl).atTopTo(label, 20).atLeft(33);
		numeroControl.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRATION_NUMBER));

		final Text  numero = new Text(group, SWT.BORDER);
		numero.setLayoutData(new FormData()); 
		FormDatas.attach(numero).atTopTo(numeroControl, 6).atLeft(33).withWidth(150);

		Label titulo = new Label(group, SWT.NONE);
		titulo.setLayoutData(new FormData());
		FormDatas.attach(titulo).atTopTo(numero, 20).atLeft(33);
		titulo.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));

		final Text  text = new Text(group, SWT.BORDER);
		text.setLayoutData(new FormData());
		FormDatas.attach(text).atTopTo(titulo, 6).atLeft(33).withWidth(150);

		Label autor = new Label(group, SWT.NONE);
		autor.setLayoutData(new FormData());
		FormDatas.attach(autor).atTopTo(text, 15).atLeft(33);
		autor.setText(AbosMessages.get().LABEL_AUTHOR);

		final Text  txtAutor = new Text(group, SWT.BORDER);
		txtAutor.setLayoutData(new FormData());
		FormDatas.attach(txtAutor).atTopTo(autor, 6).atLeft(33).withWidth(150);

		Label editor = new Label(group, SWT.NONE);
		editor.setLayoutData(new FormData());
		FormDatas.attach(editor).atTopTo(txtAutor, 15).atLeft(33);
		editor.setText(AbosMessages.get().LABEL_EDITOR);


		final Text  txtEditor = new Text(group, SWT.BORDER);
		txtEditor.setLayoutData(new FormData());
		FormDatas.attach(txtEditor).atTopTo(editor, 6).atLeft(33).withWidth(150);

		Label annoDepublic = new Label(group, SWT.NONE);
		annoDepublic.setLayoutData(new FormData());
		FormDatas.attach(annoDepublic).atTopTo(txtEditor, 15).atLeft(33);
		annoDepublic.setText(MessageUtil.unescape(AbosMessages.get().LABEL_YEAR_OF_PUBLICATION));

		final Text  txtAnnoDepublic = new Text(group, SWT.BORDER);
		txtAnnoDepublic.setLayoutData(new FormData());
		FormDatas.attach(txtAnnoDepublic).atTopTo(annoDepublic, 6).atLeft(33).withWidth(150);

		Label tipoMaterial = new Label(group, SWT.NONE);
		tipoMaterial.setLayoutData(new FormData());
		FormDatas.attach(tipoMaterial).atTopTo(txtAnnoDepublic, 15).atLeft(33);
		tipoMaterial.setText(AbosMessages.get(). LABEL_MATERIAL_TYPE);


		final Combo  txtTipoMaterial = new Combo(group, SWT.BORDER);
		txtTipoMaterial.setLayoutData(new FormData());
		FormDatas.attach(txtTipoMaterial).atTopTo(tipoMaterial, 6).atLeft(33).withWidth(150);

		Label sala = new Label(group, SWT.NONE);
		FormDatas.attach(sala).atTopTo(txtTipoMaterial, 15).atLeft(33);
		sala.setText(AbosMessages.get().LABEL_ROOM);

		final Combo  txtSala = new Combo(group, SWT.BORDER);
		txtSala.setLayoutData(new FormData());
		FormDatas.attach(txtSala).atTopTo(sala, 6).atLeft(33).withWidth(170);

		Button aceptar= new Button(group, SWT.None);
		aceptar.setLayoutData(new FormData());
		FormDatas.attach(aceptar).atTopTo(txtSala, 20).atLeftTo(txtSala,30);
		aceptar.setText(AbosMessages.get().BUTTON_ACEPT);

		if (aceptar.getSelection()){
			IRecord record = Record.createRecord();
			try {
				IField numeroControl1 = new Field(1, Global.FIELD_TYPE_NUMERIC);
				numeroControl1.setFieldValue(numero.getText());

				IField title = new Field(2, Global.FIELD_TYPE_ALPHABETIC);
				title.setFieldValue(text.getText());

				IField author = new Field(3, Global.FIELD_TYPE_ALPHABETIC);
				author.setFieldValue(txtAutor.getText());

				IField editor1 = new Field(4, Global.FIELD_TYPE_ALPHABETIC);
				editor1.setFieldValue(txtEditor.getText());

				IField annoPublic = new Field(5, Global.FIELD_TYPE_ALPHABETIC);
				annoPublic.setFieldValue(txtAnnoDepublic.getText());

				IField tipoMaterial1 = new Field(6, Global.FIELD_TYPE_ALPHABETIC);
				tipoMaterial1.setFieldValue(txtTipoMaterial.getText());

				IField sala1 = new Field(7, Global.FIELD_TYPE_ALPHANUMERIC);
				sala1.setFieldValue(txtSala.getText());

				record.addField(numeroControl1);
				record.addField(title);
				record.addField(author);
				record.addField(editor1);
				record.addField(annoPublic);
				record.addField(tipoMaterial1);
				record.addField(sala1);

			}catch(Exception e){

			}

		}

		Button cancelar= new Button(group, SWT.None);
		FormDatas.attach(cancelar).atTopTo(txtSala, 20).atLeftTo(aceptar,10);
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

	public void setControl(IViewController controller) {
		// TODO Auto-generated method stub
		this.controller = controller;

	}

	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}

}
