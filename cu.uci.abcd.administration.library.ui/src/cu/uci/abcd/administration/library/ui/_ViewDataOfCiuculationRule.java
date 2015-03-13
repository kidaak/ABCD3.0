package cu.uci.abcd.administration.library.ui;

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

import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _ViewDataOfCiuculationRule implements IContributor{


	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Ver Datos de la Regla de Circulacion";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return _ViewDataOfCiuculationRule.class.getSimpleName() + "id26";
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
		
		test.setText("Ver Datos de la Regla de Circulacion");
		FormDatas.attach(test).atLeftTo(shell, 110);
		
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Datos Generales");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10);
		
				 
				Table tabla1= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
				FormDatas.attach(tabla1).atTopTo(lblCriiteriosDeBsqueda, 10);
				tabla1.setTouchEnabled(true);

				TableItem item9= new TableItem(tabla1, SWT.NONE);
				item9.setText("Tipo de Material");

				TableItem item7= new TableItem(tabla1, SWT.NONE);
				item7.setText("Tipo de Usuario");
				TableColumn tabc6 = new TableColumn(tabla1, SWT.None);
				   tabc6.setWidth(180);
				   tabc6.setText("");

				TableItem item8= new TableItem(tabla1, SWT.NONE);
				item8.setText("Estado de la Regla");
				TableColumn tabc8 = new TableColumn(tabla1, SWT.None);
					    tabc8.setWidth(150);
					    tabc8.setText("");
				 
				tabla1.setLinesVisible(true);
				
				
				Label lblNombreDelRegistro=  new Label(test, SWT.None);
				FormDatas.attach(lblNombreDelRegistro).atTopTo(test, 10).atLeftTo(tabla1, 73);
				lblNombreDelRegistro.setText("Datos de la última Actualización");
				
				Table tabla13= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
				tabla13.setTouchEnabled(true);
				FormDatas.attach(tabla13).atTopTo(lblNombreDelRegistro, 10).atLeftTo(tabla1, 73);
				 
				TableItem item0= new TableItem(tabla13, SWT.NONE);
				 item0.setText("Nombre y Apellidos");
				 
				 TableItem item4= new TableItem(tabla13, SWT.NONE);
				 item4.setText("Usuario");
				 TableColumn tabc4 = new TableColumn(tabla13, SWT.None);
				    tabc4.setWidth(180);
				    tabc4.setText("");
				
				TableItem item5= new TableItem(tabla13, SWT.NONE);
				item5.setText("Fecha");
				TableColumn tabc5 = new TableColumn(tabla13, SWT.None);
					    tabc5.setWidth(180);
					    tabc5.setText("");
					    
					    TableItem item11= new TableItem(tabla13, SWT.NONE);
						item11.setText("Hora");
				tabla13.setLinesVisible(true);
				
				Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
				FormDatas.attach(separador).atTopTo(tabla13, 10).withWidth(900);
				
				Label listado1 = new Label(test, SWT.NORMAL);
				  FormDatas.attach(listado1).atTopTo(separador, 20);
				   listado1.setText("Datos del Prestamo");
				   
					
					Table tabla= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
					FormDatas.attach(tabla).atTopTo(listado1, 10);
						tabla.setTouchEnabled(true);
						
						 
						TableItem item= new TableItem(tabla, SWT.NONE);
						 item.setText("Lapso de Tiempo Normal");
						 
						 
						 TableItem item1= new TableItem(tabla, SWT.NONE);
						 item1.setText("Lapso de Tiempo Normal (En Cola)");
						 TableColumn tabc2 = new TableColumn(tabla, SWT.None);
						    tabc2.setWidth(230);
						    tabc2.setText("");
						
						TableItem item2= new TableItem(tabla, SWT.NONE);
						item2.setText("Préstamos Permitidos");
						TableColumn tabc3 = new TableColumn(tabla, SWT.None);
							    tabc3.setWidth(150);
							    tabc3.setText("");
							    
								TableItem item41= new TableItem(tabla, SWT.NONE |SWT.WRAP);
								item41.setText("Renovaciones Permitidas");
						
						tabla.setLinesVisible(true);
						
						
						 Label lblD1=  new Label(test, SWT.NONE);
						  lblD1.setText("Datos de la Sanción/Multa");
					     FormDatas.attach(lblD1).atTopTo(separador, 10).atLeftTo(tabla, 30);
						
						
						Table tabla6= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
						tabla6.setTouchEnabled(true);
						FormDatas.attach(tabla6).atTopTo(lblD1, 10).atLeftTo(tabla, 30);
						 
						TableItem item6= new TableItem(tabla6, SWT.NONE);
						item6.setText("Multa por día de atraso");
						
						
						TableItem item16= new TableItem(tabla6, SWT.NONE);
						item16.setText("Multa por día de atraso(Reservado)");
						TableColumn tabc26 = new TableColumn(tabla6, SWT.None);
						tabc26.setWidth(275);
						tabc26.setText("");
						
						TableItem item26= new TableItem(tabla6, SWT.NONE);
						item26.setText("Días de suspensión por día de atraso");
						TableColumn tabc36 = new TableColumn(tabla6, SWT.None);
						tabc36.setWidth(160);
						tabc36.setText("");
						
						TableItem item46= new TableItem(tabla6, SWT.NONE |SWT.WRAP);
						item46.setText("Días de suspensión por día de atraso(Reservado)");
						
						TableItem item461= new TableItem(tabla6, SWT.NONE);
						item461.setText("Multa por Pérdida");
						tabla6.setLinesVisible(true);
								
				Button cerrar = new Button(test, SWT.PUSH);
				  FormDatas.attach(cerrar).atTopTo(tabla6, 10).atRight(30);
				  cerrar.setText(AbosMessages.get().BUTTON_CLOSE);
				  
                Button eliminar = new Button(test, SWT.PUSH);
                FormDatas.attach(eliminar).atTopTo(tabla6, 10).atRightTo(cerrar, 10);
				  eliminar.setText("Eliminar");
				  
				 Button modificar= new Button(test, SWT.PUSH);
				 FormDatas.attach(modificar).atTopTo(tabla6, 10).atRightTo(eliminar, 10);
				  modificar.setText(AbosMessages.get().BUTTON_UPDATE);
				  
				 Button exportarPDF = new Button(test, SWT.PUSH);
				  exportarPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);
				  FormDatas.attach(exportarPDF).atTopTo(eliminar, 10).atRight();
				  
				  Button exportarHC = new Button(test, SWT.PUSH);
				  exportarHC.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
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
