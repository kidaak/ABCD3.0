package cu.uci.abcd.administration.library.ui;

import java.util.Arrays;
import java.util.Date;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abcd.administration.library.ui.model.FormationCourseAddArea;
import cu.uci.abcd.administration.library.ui.model._FormationCourseUpdateArea;
import cu.uci.abcd.administration.library.ui.model.FormationCourseGrid;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ViewFormationCoursesLibrary implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Consultar Cursos de Formación";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ConsultarCursoFormacioID";
	}



	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		final Composite test= new Composite(shell, SWT.NORMAL);
		test.setLayout(form);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		//test.setText("Consultar Corsos de Formación de los Trabajadores");
		FormDatas.attach(test).atLeft(0).atRight(0);
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Criterios de Búsqueda");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10).atLeft(10);
		
		
			Label lblNombreDelRegistro=  new Label(test, SWT.NONE);
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 10).atLeft(10);;
			lblNombreDelRegistro.setText("Nombre del Curso");
			
			
			Text estado1 = new Text(test, SWT.BORDER);
			FormDatas.attach(estado1).atTopTo(lblNombreDelRegistro, 10).atLeft(10).withWidth(200);
		
			
			Label lblCdigo=  new Label(test, SWT.NONE);
			FormDatas.attach(lblCdigo).atLeftTo(estado1, 45).atTopTo(lblCriiteriosDeBsqueda, 10);
			lblCdigo.setText("Profesor");
			
			Text estado2 = new Text(test, SWT.BORDER);
			FormDatas.attach(estado2).atLeftTo(estado1, 45).atTopTo(lblCdigo, 10).withWidth(200);
			
			Label lblCriiteriosDeBsqueda1=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda1.setText("Rango de Fechas del Curso");
            FormDatas.attach(lblCriiteriosDeBsqueda1).atTopTo(test, 10).atLeftTo(estado2, 45);
            
            Label lblCriiteriosDeBsqueda12=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda12.setText("Desde");
            FormDatas.attach(lblCriiteriosDeBsqueda12).atTopTo(lblCriiteriosDeBsqueda1, 10).atLeftTo(estado2, 45);
            
            DateTime dateTime = new DateTime(test, SWT.BORDER | SWT.DROP_DOWN);
            FormDatas.attach(dateTime).atTopTo(lblCriiteriosDeBsqueda12, 10).atLeftTo(estado2, 45).withWidth(200);
            
            
            Label lblCriiteriosDeBsqueda21=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda21.setText("Hasta");
            FormDatas.attach(lblCriiteriosDeBsqueda21).atTopTo(lblCriiteriosDeBsqueda1, 10).atLeftTo(dateTime, 35);
            
            DateTime dateTime1 = new DateTime(test, SWT.BORDER | SWT.DROP_DOWN);
            FormDatas.attach(dateTime1).atTopTo(lblCriiteriosDeBsqueda21, 10).atLeftTo(dateTime, 35).withWidth(200);
            
			
            Button btnNewButton_2 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_2).atTopTo(estado2, 10).atRight(10).withWidth(130);
			btnNewButton_2.setText("Nueva Búsqueda");
			
			Button btnNewButton_1 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_1).atTopTo(estado2, 10).atRightTo(btnNewButton_2, 10).withWidth(130);
			btnNewButton_1.setText("Consultar");
			
			
			
			
			//Button btnCerrar = new Button(test, SWT.NONE);
			//FormDatas.attach(btnCerrar).atTopTo(estado2, 10).atLeftTo(btnNewButton_2, 10);
			//btnCerrar.setText("Cerrar");
			
			Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
			FormDatas.attach(separador).atTopTo(btnNewButton_2, 10).atLeft(5).atRight(5);
			

			  Label listado1 = new Label(test, SWT.NORMAL);
			  FormDatas.attach(listado1).atTopTo(separador, 10).atLeft(10);
			   listado1.setText("Listado de Cursos de Formación para Trabajadores");
		
		  //-----------------Tabla--------------------------------------
		  
			  /*
			    Table tabla1 = new Table(test, SWT.BORDER | SWT.FULL_SELECTION);
			    FormDatas.attach(tabla1).atTopTo(listado1, 10);
			    tabla1.setHeaderVisible(true);
			    tabla1.setLinesVisible(true);
			    
			    TableItem tableItem_2 = new TableItem(tabla1, SWT.NONE);
			    tableItem_2.setText( new String[] { "column 0", "column 1" } );
			    
			    		  TableColumn columna11 = new TableColumn(tabla1, SWT.NONE);
			    		  columna11.setWidth(150);
			    		  columna11.setText("Nombre del Curso");
			    		  
			    		  TableColumn columna12 = new TableColumn(tabla1, SWT.NONE);
			    		  columna12.setWidth(100);
			    		  columna12.setText("Profesor");
			    		  
			    		  TableColumn columna21 = new TableColumn(tabla1, SWT.NONE);
			    		  columna21.setWidth(100);
			    		  columna21.setText("Fecha Inicio");
			    		  
			    		  TableColumn columna31 = new TableColumn(tabla1, SWT.NONE);
			    		  columna31.setWidth(100);
			    		  columna31.setText("Fecha Fin");
			    		  
			    		  TableColumn columna41 = new TableColumn(tabla1, SWT.NONE);
			    		  columna41.setWidth(140);
			    		  columna41.setText("Cantidad de Horas");
			    		  
			    		  TableColumn columna51 = new TableColumn(tabla1, SWT.NONE);
			    		  columna51.setWidth(100);
			    		  columna51.setText("Acciones");
			  
			  
			 
			//----------------------------------------------------------

		
		 Button exportarPDF = new Button(test, SWT.PUSH);
		  exportarPDF.setText("Exportar a PDF");
		  FormDatas.attach(exportarPDF).atTopTo(tabla1, 10).atRight();
		  
		  Button exportarHC = new Button(test, SWT.PUSH);
		  exportarHC.setText("Exportar a Hoja de Cálculo");
		  FormDatas.attach(exportarHC).atTopTo(tabla1, 10).atRightTo(exportarPDF, 10);
	  
	  */
			  // FillLayout bottomFillLayout = new FillLayout();
				//GridData bottomGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
				
				//Composite bottomGroup = new Composite(test, SWT.NONE);
				//bottomGroup.setText("Campos definidos");
				//bottomGroup.setLayout(bottomFillLayout);
				//bottomGroup.setLayoutData(bottomGridData);
				
				//FormDatas.attach(bottomGroup).atTopTo(listado1, 10);
				
				
				CRUDTreeTable tabla = new CRUDTreeTable(test, SWT.NONE);
				tabla.setEntityClass(FormationCourseGrid.class);
				tabla.setAdd(true, new FormationCourseAddArea());
				tabla.setUpdate(true, new _FormationCourseUpdateArea());
				
				tabla.setColumnHeaders(Arrays.asList("Etiqueta", "Nombre", "Tipo", "pepito"));		//For the internationalization.
				
				try {
					tabla.createTable();
				}
				catch(Exception e) {
				}
				FormDatas.attach(tabla).atTopTo(listado1, 10).atLeft(5)
				.atRight(5);
				
				//TreeItem root = tabla.addRow(new FormationCourseGrid("Editorial Gente Nueva","EK52635"));
		        //tabla.addRow(new FormationCourseGrid("Editorial Pionero","ED63255"));
				tabla.addUpdateListener(new TreeColumnListener() {
					public void handleEvent(TreeColumnEvent event) {
						//IGridViewEntity entity = (FDTViewEntity) event.entity;
						//do something with the data
					}
				});
				
				tabla.addDeleteListener(new TreeColumnListener() {
					public void handleEvent(TreeColumnEvent event) {
						//IGridViewEntity entity = (FDTViewEntity) event.entity;
						//do something with the data
					}
				});
			  
				Button exportarPDF = new Button(test, SWT.PUSH);
				  exportarPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
				  FormDatas.attach(exportarPDF).atTopTo(tabla, 10).atRight();
				  
				  Button exportarHC = new Button(test, SWT.PUSH);
				  exportarHC.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
				  FormDatas.attach(exportarHC).atTopTo(tabla, 10).atRightTo(exportarPDF, 10);
		     
			   
			   
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
