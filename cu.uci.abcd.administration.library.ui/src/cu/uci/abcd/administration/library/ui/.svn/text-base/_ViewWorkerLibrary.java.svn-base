package cu.uci.abcd.administration.library.ui;

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

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _ViewWorkerLibrary implements IContributor{
	
	@Override
	public String contributorName() {
		return "Visualizar Trabajador";
	}

	@Override
	public String getID() {
		return "ConsultarTrabajadoresBibliotecaID";
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
		
		test.setText("Visualizar Trabajador de la Biblioteca");
		FormDatas.attach(test).atLeftTo(shell, 110);
		
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Datos de la Persona");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10);
		
			
		Label lab = new Label(test, SWT.None);
	     lab.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
	     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		  lab.setText("<img width='100' height='114' src='" +elemento+"'></img>");
			  FormDatas.attach(lab).atTopTo(lblCriiteriosDeBsqueda, 10);
			
			 Table tabla= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
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
				
				
				Label lblNombreDelRegistro=  new Label(test, SWT.None);
				FormDatas.attach(lblNombreDelRegistro).atTopTo(test, 10).atLeftTo(tabla, 30);
				lblNombreDelRegistro.setText("Datos de la última Actualización");
				
				Table tabla13= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
				tabla13.setTouchEnabled(true);
				FormDatas.attach(tabla13).atTopTo(lblNombreDelRegistro, 10).atLeftTo(tabla, 30);
				 
				TableItem item0= new TableItem(tabla13, SWT.NONE);
				 item0.setText("Nombre y Apellidos");
				 
				 
				 TableItem item4= new TableItem(tabla13, SWT.NONE);
				 item4.setText("Usuario");
				 TableColumn tabc4 = new TableColumn(tabla13, SWT.None);
				    tabc4.setWidth(135);
				    tabc4.setText("");
				
				TableItem item5= new TableItem(tabla13, SWT.NONE);
				item5.setText("Fecha");
				TableColumn tabc5 = new TableColumn(tabla13, SWT.None);
					    tabc5.setWidth(135);
					    tabc5.setText("");
					    
					    TableItem item11= new TableItem(tabla13, SWT.NONE);
						item11.setText("Hora");
				tabla13.setLinesVisible(true);
				
				Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
				FormDatas.attach(separador).atTopTo(tabla13, 10).withWidth(700);
				
				Label listado1 = new Label(test, SWT.NORMAL);
				  FormDatas.attach(listado1).atTopTo(separador, 20);
				   listado1.setText("Datos del Trabajador");
				
				 Table tabla1= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
					tabla1.setTouchEnabled(true);
					FormDatas.attach(tabla1).atTopTo(listado1, 10);
					 

					TableItem item8= new TableItem(tabla1, SWT.NONE);
					item8.setText("Tipo");
					TableColumn tabc8 = new TableColumn(tabla1, SWT.None);
						    tabc8.setWidth(200);
						    tabc8.setText("");
					 
					 
					 TableItem item7= new TableItem(tabla1, SWT.NONE);
					 item7.setText("Rango de Fechas del Registro");
					 TableColumn tabc6 = new TableColumn(tabla1, SWT.None);
					    tabc6.setWidth(200);
					    tabc6.setText("");
					tabla1.setLinesVisible(true);
				
					
				 Label lblDescripcion=  new Label(test, SWT.NONE);
				  FormDatas.attach(lblDescripcion).atTopTo(tabla1, 20);
					lblDescripcion.setText("Observaciones");
			
				 Text text_2 = new Text(test, SWT.BORDER |  SWT.WRAP);
				 FormDatas.attach(text_2).atTopTo(lblDescripcion, 10).withHeight(30).withWidth(680);
				 
				Button cerrar = new Button(test, SWT.PUSH);
				  FormDatas.attach(cerrar).atTopTo(text_2, 10).atRight(30);
				  cerrar.setText("Cerrar");
				  
                Button eliminar = new Button(test, SWT.PUSH);
                FormDatas.attach(eliminar).atTopTo(text_2, 10).atRightTo(cerrar, 10);
				  eliminar.setText("Eliminar");
				  
				 Button modificar= new Button(test, SWT.PUSH);
				 FormDatas.attach(modificar).atTopTo(text_2, 10).atRightTo(eliminar, 10);
				  modificar.setText("Modiicar");
				  
				  
				 Button exportarPDF = new Button(test, SWT.PUSH);
				  exportarPDF.setText("Exportar a Hoja de Calculo");
				  FormDatas.attach(exportarPDF).atTopTo(eliminar, 10).atRight();
				  
				  Button exportarHC = new Button(test, SWT.PUSH);
				  exportarHC.setText("Exportar a PDF");
				  FormDatas.attach(exportarHC).atTopTo(eliminar, 10).atRightTo(exportarPDF, 10);
				
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
