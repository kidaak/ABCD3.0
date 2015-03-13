package cu.uci.abcd.administration.library.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _RegisterWorkerLibraryAssociatedData implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Trabajador de la Biblioteca (Datos Asociados)";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return _RegisterWorkerLibraryAssociatedData.class.getSimpleName() + "id23";
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		
		Group test= new Group(shell, SWT.NORMAL);
		test.setLayout(form);
		
		test.setText("Registrar Trabajador de la Biblioteca");
		FormDatas.attach(test).atLeftTo(shell, 110);
		
		Composite test1= new Composite(test, SWT.NORMAL);
		test1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test1.setLayout(form);
		
		Label lblCriiteriosDeBsqueda=  new Label(test1, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Datos de la Persona");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test1,10);
		
			Label lab = new Label(test1, SWT.None);
		     lab.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
		     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
			  lab.setText("<img width='100' height='114' src='" +elemento+"'></img>");
			  FormDatas.attach(lab).atTopTo(lblCriiteriosDeBsqueda, 10);
			
			 Table tabla= new Table(test1, SWT.BORDER|SWT.FULL_SELECTION);
				tabla.setTouchEnabled(true);
				FormDatas.attach(tabla).atTopTo(lblCriiteriosDeBsqueda, 10).atLeftTo(lab, 0);
				 
				TableItem item= new TableItem(tabla, SWT.NONE);
				 item.setText("Nombre y Apellidos");
				 
				 
				 TableItem item1= new TableItem(tabla, SWT.NONE);
				 item1.setText("Identificación");
				 TableColumn tabc2 = new TableColumn(tabla, SWT.None);
				    tabc2.setWidth(140);
				    tabc2.setText("");
				
				TableItem item2= new TableItem(tabla, SWT.NONE);
				item2.setText("Sexo");
				TableColumn tabc3 = new TableColumn(tabla, SWT.None);
					    tabc3.setWidth(140);
					    tabc3.setText("");
					    
					    TableItem item3= new TableItem(tabla, SWT.NONE);
						item3.setText("Edad");
				tabla.setLinesVisible(true);
			
			Button asociar = new Button(test1, SWT.PUSH);
			FormDatas.attach(asociar).atLeftTo(tabla, 30).atTopTo(tabla, -30);
			asociar.setText("Disociar");
			
			Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
			FormDatas.attach(separador).atTopTo(test1, 10).withWidth(600);
			
			Label listado1 = new Label(test, SWT.NORMAL);
			  FormDatas.attach(listado1).atTopTo(separador, 10);
			   listado1.setText("Datos del Trabajador");
			
			Label lblt=  new Label(test, SWT.NONE);
			lblt.setText("Tipo de Trabajador");
			FormDatas.attach(lblt).atTopTo(listado1, 10);
			
			Combo estado11 = new Combo(test, SWT.NONE);
			estado11.setItems(new String[] { "Especialista", "Profesor"});
			FormDatas.attach(estado11).atTopTo(lblt, 10);
			
			
            Label lblCriiteriosDeBsqueda12=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda12.setText("Fecha de Registro");
            FormDatas.attach(lblCriiteriosDeBsqueda12).atTopTo(listado1, 10).atLeftTo(lblt, 80);
            
            DateTime dateTime = new DateTime(test, SWT.BORDER | SWT.DROP_DOWN);
            FormDatas.attach(dateTime).atTopTo(lblCriiteriosDeBsqueda12, 10).atLeftTo(lblt, 80);
            
						
			  
				  Label lblDescripcion=  new Label(test, SWT.NONE);
				  FormDatas.attach(lblDescripcion).atTopTo(dateTime, 20);
					lblDescripcion.setText("Observaciones");
			
				 Text text_2 = new Text(test, SWT.BORDER |  SWT.WRAP);
				 FormDatas.attach(text_2).atTopTo(lblDescripcion, 10).withHeight(30).withWidth(580);
			//----------------------------------------------------------

		
		 Button exportarPDF = new Button(test, SWT.PUSH);
		  exportarPDF.setText("Cancelar");
		  FormDatas.attach(exportarPDF).atTopTo(text_2, 10).atRight();
		  
		  Button exportarHC = new Button(test, SWT.PUSH);
		  exportarHC.setText("Aceptar");
		  FormDatas.attach(exportarHC).atTopTo(text_2, 10).atRightTo(exportarPDF, 10);
	  
	  
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
