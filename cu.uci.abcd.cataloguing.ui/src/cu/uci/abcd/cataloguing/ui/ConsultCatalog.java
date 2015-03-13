package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.repeatable.field.CataloguingComponent;
import cu.uci.abos.widget.repeatable.field.ControlType;

public class ConsultCatalog implements IContributor {

	@Override
	public String contributorName() {
		return "Consultar Catalogo";
	}


	@Override
	public Control createUIControl(Composite parent) {
		
		parent.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		parent.setLayout(new FormLayout());
		
		Composite father = new Composite(parent, 0);
		father.setLayout(new FormLayout());
		
		father.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		FormDatas.attach(father).atLeft(0).atRight(0);
		/*
		Label loupe = new Label(father, SWT.NONE);
		loupe.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String element = RWT.getResourceManager().getLocation("administracion/search.png");
	    loupe.setText("<img width='25' height='25' src='" +element+"'></img>");
	    */
	    Text text = new Text(father, SWT.SEARCH|SWT.ICON_SEARCH);
	    text.setMessage("Búsqueda en Catálogo");
		FormDatas.attach(text).atTopTo(father, 10).atLeftTo(father, 10).withWidth(170).withHeight(14);
	    
	    Button accept = new Button(father, SWT.PUSH);
	    accept.setText("Buscar");
	    FormDatas.attach(accept).atTopTo(father, 10).atLeftTo(text, 10).withHeight(25);
	    
	    CataloguingComponent component = new CataloguingComponent(father, 0, "basilio", ControlType.Text, true);
	    
	    FormDatas.attach(component).atTopTo(accept, 20).atLeftTo(father, 0);
	    
	    parent.layout(true);
		return parent;
	}

	@Override
	public String getID() {
		return  "62347";
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
