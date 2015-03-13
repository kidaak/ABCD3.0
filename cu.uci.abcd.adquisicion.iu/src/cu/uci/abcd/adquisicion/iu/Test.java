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

import Escucha.Escuchar;
import cu.uci.abcd.adquisicion.iu.controller.RegistrarRegistroDeAdquisicionController;
import cu.uci.abos.l10n.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
//RF_AQ15_Registry Acquisition
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class Test implements IContributor {
	private IViewController controller;
	private String numero;
	private String titulo;
	private String author;
	private String edit;
	private String annoPublic;
	private String tipoMat;
	private String room;
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		Composite group = new Composite(parent, SWT.NONE);
		
		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);
		FormDatas.attach(group).atRight(0).atLeft(0);

		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new FormData());
		FormDatas.attach(label).atTop(10).atLeftTo(group,400);
		label.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRY_DATA_ACQUISITION));

		CompoundLabel numeroControl = new CompoundLabel(group, 0, ControlType.Text);
		numeroControl.setText(MessageUtil.unescape(AbosMessages.get().LABEL_REGISTRATION_NUMBER));
		numero = ((Text)numeroControl.getControl()).getText();  	

		CompoundLabel title = new CompoundLabel(group, 0, ControlType.Text);
		title.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		titulo = ((Text)title.getControl()).getText();  	
		
		CompoundLabel autor = new CompoundLabel(group, 0, ControlType.Text);
		autor.setText(MessageUtil.unescape(AbosMessages.get().LABEL_AUTHOR));
		author = ((Text)autor.getControl()).getText();
		
		CompoundLabel editor = new CompoundLabel(group, 0, ControlType.Text);
		editor.setText(MessageUtil.unescape(AbosMessages.get().LABEL_EDITOR));
		edit = ((Text)editor.getControl()).getText();
		
		CompoundLabel annoDepublic = new CompoundLabel(group, 0, ControlType.Text);
		annoDepublic.setText(MessageUtil.unescape(AbosMessages.get().LABEL_YEAR_OF_PUBLICATION));
		annoPublic = ((Text)annoDepublic.getControl()).getText();
		
		CompoundLabel tipoMaterial = new CompoundLabel(group, 0, ControlType.Combo);
		tipoMaterial.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MATERIAL_TYPE));	
		tipoMat = ((Combo)tipoMaterial.getControl()).getText();
		
		CompoundLabel sala = new CompoundLabel(group, 0, ControlType.Combo);
		sala.setText(MessageUtil.unescape(AbosMessages.get().LABEL_ROOM));	
		room = ((Combo)sala.getControl()).getText();
		
		 FormDatas.attach(numeroControl).atTopTo(group, 30).atLeftTo(group,400);
		    FormDatas.attach(title).atTopTo(numeroControl, 30).atLeftTo(group,400);
		    FormDatas.attach(autor).atTopTo(title, 30).atLeftTo(group,400);
		    FormDatas.attach(editor).atTopTo(autor, 30).atLeftTo(group,400);
		    FormDatas.attach(annoDepublic).atTopTo(editor, 30).atLeftTo(group,400);
		    FormDatas.attach(tipoMaterial).atTopTo(annoDepublic, 30).atLeftTo(group,400);
		    FormDatas.attach(sala).atTopTo(tipoMaterial, 30).atLeftTo(group,400);
		    
		    numeroControl.setPosition(SWT.TOP, 6);
		    title.setPosition(SWT.TOP, 6);
		    autor.setPosition(SWT.TOP, 6);
		    editor.setPosition(SWT.TOP, 6);
		    annoDepublic.setPosition(SWT.TOP, 6);
		    tipoMaterial.setPosition(SWT.TOP, 6);
		    sala.setPosition(SWT.TOP, 6);
		  
		   
			
		Button aceptar= new Button(group, SWT.None);
		aceptar.setLayoutData(new FormData());
		aceptar.setText(AbosMessages.get().BUTTON_ACEPT);
		FormDatas.attach(aceptar).atTopTo(sala, 20).atLeftTo(sala,30);
		
		aceptar.addListener(SWT.Selection, new Escuchar(numero, titulo, author, edit, annoPublic, tipoMat, room,(RegistrarRegistroDeAdquisicionController) controller));
		
		Button cancelar= new Button(group, SWT.None);
		FormDatas.attach(cancelar).atTopTo(sala, 20).atLeftTo(aceptar,10);
		cancelar.setText(AbosMessages.get().BUTTON_CANCEL);


		return parent;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistroAdquisicionID";  
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub

	}

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Registro de Adquisición";
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
		

	}

}
