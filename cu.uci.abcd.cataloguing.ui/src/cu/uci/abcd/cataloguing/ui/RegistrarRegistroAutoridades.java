package cu.uci.abcd.cataloguing.ui;

import java.util.ArrayList;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import cu.uci.abcd.cataloguing.controller.RegisterController;
import cu.uci.abcd.cataloguing.listener.EventSave;
import cu.uci.abcd.cataloguing.listener.EventServersSearch;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.repeatable.field.util.FieldStructure;
import cu.uci.abos.widget.template.component.TemplateCompound;

public class RegistrarRegistroAutoridades implements IContributor {
	
	private IViewController controller;
	private String dataBaseName = "Autoridades";

	@Override
	public Control createUIControl(Composite arg0) {
		// TODO Auto-generated method stub
		
        arg0.setLayout(new FormLayout());
		
		FormDatas.attach(arg0).atLeft(0).atRight(0);
		
		arg0.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		if(controller != null){
			
			TemplateCompound compound = new TemplateCompound(arg0, 0, dataBaseName, ((RegisterController)controller).getService());
			
			compound.setLayout(new FormLayout());
			
			FormDatas.attach(compound).atTopTo(arg0, 0).atLeftTo(arg0, 0);
			
			Button buttonSave = (Button)compound.getButtonSave();
			
			Button buttonSearch = (Button)compound.getButtonSearch();
			
			CTabFolder tabFolder = compound.getTabFolder();
			
			ArrayList<FieldStructure> childrens = compound.getChildrens();
			
			Shell shell = arg0.getShell();
			
			buttonSave.addListener(SWT.Selection, new EventSave((RegisterController)controller, dataBaseName, childrens,shell));
			
			Composite father = compound.getFather();
			
			buttonSearch.addListener(SWT.Selection, new EventServersSearch(tabFolder, father));
			
			}
		
		
		return arg0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "7";
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Registro de Autoridades";
	}

	@Override
	public void setViewController(IViewController arg0) {
		// TODO Auto-generated method stub
		
		this.controller = arg0;
		
	}

}
