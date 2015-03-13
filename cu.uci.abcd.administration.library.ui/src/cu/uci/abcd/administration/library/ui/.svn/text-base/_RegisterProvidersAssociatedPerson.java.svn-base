package cu.uci.abcd.administration.library.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
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

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _RegisterProvidersAssociatedPerson implements IContributor{
	
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Proveedores. Persona Asociada";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return _RegisterProvidersAssociatedPerson.class.getSimpleName() + "id20";
	}


	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		
		Group test= new Group(shell, SWT.NORMAL);
		test.setLayout(form);
		
		test.setText("Registrar Proveedores");
		FormDatas.attach(test).atLeftTo(shell, 110);
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Datos del Proveedor");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10);
		
		
			Label lblNombreDelRegistro=  new Label(test, SWT.NONE);
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 10);
			lblNombreDelRegistro.setText("Nombre del Proveedor");
			
			Text text_1 = new Text(test, SWT.BORDER);
			FormDatas.attach(text_1).atTopTo(lblNombreDelRegistro, 10);
		
			
			Label lblCdigo=  new Label(test, SWT.NONE);
			lblCdigo.setLayoutData(new FormData());
			FormDatas.attach(lblCdigo).atLeftTo(lblNombreDelRegistro, 40).atTopTo(lblCriiteriosDeBsqueda, 10);
			lblCdigo.setText("Identificación");
			
			Text text_2 = new Text(test, SWT.BORDER);
			FormDatas.attach(text_2).atLeftTo(text_1, 75).atTopTo(lblCdigo, 10);
			
			
			Label lblEst=  new Label(test, SWT.NONE);
			lblEst.setText("Telefono");
			FormDatas.attach(lblEst).atLeftTo(text_2, 75).atTopTo(lblCriiteriosDeBsqueda, 10);
			
			Text text_3 = new Text(test, SWT.BORDER);
			FormDatas.attach(text_3).atLeftTo(text_2, 75).atTopTo(lblCdigo, 10);
			
			Label lblEst1=  new Label(test, SWT.NONE);
			lblEst1.setText("Correo");
			FormDatas.attach(lblEst1).atLeftTo(text_3, 75).atTopTo(lblCriiteriosDeBsqueda, 10);
			
			Text text_31 = new Text(test, SWT.BORDER);
			FormDatas.attach(text_31).atLeftTo(text_3, 75).atTopTo(lblCdigo, 10);
			
			Label lblTPo=  new Label(test, SWT.NONE);
			lblTPo.setText("Tipo de Proveedor");
			FormDatas.attach(lblTPo).atTopTo(text_1, 15);
			
			Button btnCheckButton = new Button(test, SWT.CHECK);
			btnCheckButton.setText("Comercial");
			FormDatas.attach(btnCheckButton).atTopTo(lblTPo, 10);
			
	Button btnCheckButton_1 = new Button(test, SWT.CHECK);
	btnCheckButton_1.setText("Canje");
	FormDatas.attach(btnCheckButton_1).atLeftTo(btnCheckButton, 10).atTopTo(lblTPo, 10);
	
	Button btnCheckButton_2 = new Button(test, SWT.CHECK);
	btnCheckButton_2.setText("Donaciones");
	FormDatas.attach(btnCheckButton_2).atLeftTo(btnCheckButton_1, 10).atTopTo(lblTPo, 10);
	
	Button btnCheckButton_3 = new Button(test, SWT.CHECK);
	btnCheckButton_3.setText("Productor");
	FormDatas.attach(btnCheckButton_3).atLeftTo(btnCheckButton_2, 10).atTopTo(lblTPo, 10);
	
	 Label lblDescripcion=  new Label(test, SWT.NONE);
	  FormDatas.attach(lblDescripcion).atTopTo(btnCheckButton_3, 20);
		lblDescripcion.setText("Direccion");

	 Text text_21 = new Text(test, SWT.BORDER |  SWT.WRAP);
	 FormDatas.attach(text_21).atTopTo(lblDescripcion, 10).withHeight(30).withWidth(580);
	 
	 Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(text_21, 10).withWidth(600);
		
		Label lblCriiteriosDeBsqueda1=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda1.setText("Datos del Representante");

		FormDatas.attach(lblCriiteriosDeBsqueda1).atTopTo(separador,20);
		
		Label lab = new Label(test, SWT.None);
	     lab.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
	     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		  lab.setText("<img width='100' height='140' src='" +elemento+"'></img>");
		  FormDatas.attach(lab).atTopTo(lblCriiteriosDeBsqueda1, 10);
		
		 Table tabla= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
			tabla.setTouchEnabled(true);
			
			 
			TableItem item= new TableItem(tabla, SWT.NONE);
			 item.setText("Nombre y Apellidos");
			 
			 
			 TableItem item1= new TableItem(tabla, SWT.NONE);
			 item1.setText("Identificación");
			 TableColumn tabc2 = new TableColumn(tabla, SWT.None);
			    tabc2.setWidth(140);
			    tabc2.setText("");
			
			TableItem item2= new TableItem(tabla, SWT.NONE);
			item2.setText("Teléfono");
			TableColumn tabc3 = new TableColumn(tabla, SWT.None);
				    tabc3.setWidth(140);
				    tabc3.setText("");
				    
				    TableItem item3= new TableItem(tabla, SWT.NONE);
					item3.setText("Correo");
					TableItem item4= new TableItem(tabla, SWT.NONE);
					item4.setText("Dirección");
			
			tabla.setLinesVisible(true);
			FormDatas.attach(tabla).atTopTo(lblCriiteriosDeBsqueda1, 10).atLeftTo(lab, 0);
			
			
			Button asociar = new Button(test, SWT.PUSH);
			FormDatas.attach(asociar).atLeftTo(tabla, 30).atTopTo(tabla, -30);
			asociar.setText("Disociar");
			
			//----------------------------------------------------------

		 Button exportarPDF = new Button(test, SWT.PUSH);
		  exportarPDF.setText("Cancelar");
		  FormDatas.attach(exportarPDF).atTopTo(asociar, 30).atRight();
		  
		  Button exportarHC = new Button(test, SWT.PUSH);
		  exportarHC.setText("Aceptar");
		  FormDatas.attach(exportarHC).atTopTo(asociar, 30).atRightTo(exportarPDF, 10);
	  
	  
	return shell;
	
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
