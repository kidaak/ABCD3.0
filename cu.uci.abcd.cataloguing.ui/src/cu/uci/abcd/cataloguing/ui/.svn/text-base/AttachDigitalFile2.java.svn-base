package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class AttachDigitalFile2 implements IContributor {

	@Override
	public Control createUIControl(Composite arg0) {
		// TODO Auto-generated method stub
		
		arg0.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		arg0.setLayout(new FormLayout());
		
		Composite father = new Composite(arg0, 0);
		
		father.setLayout(new FormLayout());
		
		father.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		FormDatas.attach(father).atLeft(0).atRight(0);
		
		Group fileDatas = new Group(father, 0);
		
		fileDatas.setLayout(new FormLayout());
		
		fileDatas.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		fileDatas.setText("Datos del archivo");
		
		FormDatas.attach(fileDatas).atTopTo(father, 20).atLeft(0).atRight(0).withHeight(100);
		
		CompoundLabel address = new CompoundLabel(fileDatas, 0, ControlType.Text);
		
		address.setLayout(new FormLayout());
		
		address.setText("Dirección:");
		
		FormDatas.attach(address).atTopTo(fileDatas, 10).atLeftTo(fileDatas, 20);
		
		address.setPosition(SWT.LEFT, 10);
		
		Button browser = new Button(fileDatas, 0);
		
		browser.setText("Examinar");
		
		FormDatas.attach(browser).atTopTo(fileDatas, 10).atLeftTo(address, 10).withHeight(25);
		
		Button attach = new Button(fileDatas, 0);
		
		attach.setText("Adjuntar");
		
		Button close = new Button(fileDatas, 0);
		
		close.setText("Cerrar");
		
		FormDatas.attach(attach).atTopTo(address, 20).atLeftTo(fileDatas, 90).withHeight(25);
		
		FormDatas.attach(close).atTopTo(address, 20).atLeftTo(attach, 15).withHeight(25);
		
		Group files = new Group(father, 0);
		
        files.setLayout(new FormLayout());
		
		files.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		files.setText("Archivos propuestos (0)");
		
		FormDatas.attach(files).atTopTo(fileDatas, 10).atLeft(0).atRight(0);
		
		
		
		return arg0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "98";
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
		return "Adjuntar archivo digital";
	}

	@Override
	public void setViewController(IViewController arg0) {
		// TODO Auto-generated method stub
		
	}

}
