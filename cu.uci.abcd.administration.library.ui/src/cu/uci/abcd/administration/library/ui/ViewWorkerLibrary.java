package cu.uci.abcd.administration.library.ui;

import java.util.Arrays;

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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abcd.administration.library.ui.listener.Listeners;
import cu.uci.abcd.administration.library.ui.model.WorkerAddArea;
import cu.uci.abcd.administration.library.ui.model._WorkerUpdateArea;
import cu.uci.abcd.administration.library.ui.model.WorkerGrid;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ViewWorkerLibrary implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Consultar Trabajadores";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ConsultarTrabajadoresBibliotecaID";
	}



	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(shell).atLeft(0).atRight(0);
		
		Composite test= new Composite(shell, SWT.NORMAL);
		test.setLayout(form);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		//test.setText("Consultar Trabajadores de la Biblioteca");
		FormDatas.attach(test).atLeftTo(shell, 10).atLeft(0).atRight(0);
		
		Composite test1= new Composite(test, SWT.NORMAL);
		test1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test1.setLayout(form);
		FormDatas.attach(test1).atLeft(0).atRight(0).withHeight(100);
		
		Label lblCriiteriosDeBsqueda=  new Label(test1, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Criterios de Búsqueda");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test1,10).atLeft(10);
		
		
			Label lblNombreDelRegistro=  new Label(test1, SWT.NONE);
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 10).atLeft(10);
			lblNombreDelRegistro.setText("Nombre y Apellidos");
			
			
			Text estado1 = new Text(test1, SWT.BORDER);
			FormDatas.attach(estado1).atTopTo(lblNombreDelRegistro, 10).atLeft(10).withWidth(175);
		
			
			Label lblCdigo=  new Label(test1, SWT.NONE);
			FormDatas.attach(lblCdigo).atLeftTo(estado1, 60).atTopTo(lblCriiteriosDeBsqueda, 10);
			lblCdigo.setText("Identificación");
			
			Text estado2 = new Text(test1, SWT.BORDER);
			FormDatas.attach(estado2).atLeftTo(estado1, 60).atTopTo(lblCdigo, 10).withWidth(175);
			
			Label lblt=  new Label(test1, SWT.NONE);
			lblt.setText("Tipo de Trabajador");
			FormDatas.attach(lblt).atLeftTo(estado2, 60).atTopTo(lblCriiteriosDeBsqueda, 10);
			
			Combo estado11 = new Combo(test1, SWT.BORDER);
			estado11.setItems(new String[] { "Especialista", "Profesor"});
			FormDatas.attach(estado11).atLeftTo(estado2, 60).atTopTo(lblt, 10).withWidth(200);
			
			Label lblCriiteriosDeBsqueda1=  new Label(test1, SWT.NONE);
			lblCriiteriosDeBsqueda1.setText("Rango de Fechas de Registro");
            FormDatas.attach(lblCriiteriosDeBsqueda1).atTopTo(estado1, 20).atLeft(10);
            
            Label lblCriiteriosDeBsqueda12=  new Label(test1, SWT.NONE);
			lblCriiteriosDeBsqueda12.setText("Desde");
            FormDatas.attach(lblCriiteriosDeBsqueda12).atTopTo(lblCriiteriosDeBsqueda1, 10).atLeft(10);
            
            DateTime dateTime = new DateTime(test1, SWT.BORDER | SWT.DROP_DOWN);
            FormDatas.attach(dateTime).atTopTo(lblCriiteriosDeBsqueda12, 10).withWidth(200).atLeft(10);
            
            
            Label lblCriiteriosDeBsqueda21=  new Label(test1, SWT.NONE);
			lblCriiteriosDeBsqueda21.setText("Hasta");
            FormDatas.attach(lblCriiteriosDeBsqueda21).atTopTo(lblCriiteriosDeBsqueda1, 10).atLeftTo(dateTime, 60);
            
            DateTime dateTime1 = new DateTime(test1, SWT.BORDER | SWT.DROP_DOWN);
            FormDatas.attach(dateTime1).atTopTo(lblCriiteriosDeBsqueda21, 10).atLeftTo(dateTime, 60).withWidth(200);
            
            Label lblt1=  new Label(test1, SWT.NONE);
			lblt1.setText("Sexo");
			FormDatas.attach(lblt1).atLeftTo(dateTime1, 65).atTopTo(lblCriiteriosDeBsqueda1, 10);
			
			Combo estado12 = new Combo(test1, SWT.NONE);
			estado12.setItems(new String[] { "Femenino", "Masculino"});
			FormDatas.attach(estado12).atLeftTo(dateTime1, 60).atTopTo(lblt1, 10).withWidth(190);
			
			Label lblt11=  new Label(test1, SWT.NONE);
			lblt11.setText("Estado");
			FormDatas.attach(lblt11).atLeftTo(estado12, 60).atTopTo(lblCriiteriosDeBsqueda1, 10);
			
			Combo estado13 = new Combo(test1, SWT.NONE);
			estado13.setItems(new String[] { "Activo", "Inactivo"});
			FormDatas.attach(estado13).atLeftTo( estado12, 60).atTopTo(lblt11, 10).withWidth(190);
            
            
            
			Button btnNewButton_2 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_2).atTopTo(test1, 20).atRight(10).withWidth(130);
			btnNewButton_2.setText("Nueva Búsqueda");
			
			Button btnNewButton_1 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_1).atTopTo(test1, 20).atRightTo(btnNewButton_2, 10).withWidth(130);
			btnNewButton_1.setText("Consultar");
			
			Link link = new Link(test, SWT.NONE);
			link.setText("<a>Busqueda Avanzada</a>");
			FormDatas.attach(link).atTopTo(test1, 20).atRightTo(btnNewButton_1, 15);
			link.addListener(SWT.Selection, new Listeners(test1, link));
			
			
			
			
			//Button btnCerrar = new Button(test, SWT.NONE);
			//FormDatas.attach(btnCerrar).atTopTo(test1, 20).atLeftTo(btnNewButton_2, 10);
			//btnCerrar.setText("Cerrar");
			
			Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
			FormDatas.attach(separador).atTopTo(btnNewButton_2, 10).atRight(5).atLeft(5);
			

			  Label listado1 = new Label(test, SWT.NORMAL);
			  FormDatas.attach(listado1).atTopTo(separador, 10).atLeft(10);
			   listado1.setText("Listado de Trabajadores de la Biblioteca");
		
		  //-----------------Tabla--------------------------------------
		  /*
			  
			    Table tabla1 = new Table(test, SWT.BORDER | SWT.FULL_SELECTION);
			    FormDatas.attach(tabla1).atTopTo(listado1, 10);
			    tabla1.setHeaderVisible(true);
			    tabla1.setLinesVisible(true);
			    
			    TableItem tableItem_2 = new TableItem(tabla1, SWT.NONE);
			    tableItem_2.setText( new String[] { "column 0", "column 1" } );
			    
			    TableColumn columna0 = new TableColumn(tabla1, SWT.NONE);
				  columna0.setWidth(200);
				  columna0.setText("Nombre y Apellidos");
				  
				  TableColumn columna1 = new TableColumn(tabla1, SWT.NONE);
				  columna1.setWidth(100);
				  columna1.setText("Identificación");
				  
				  TableColumn columna2 = new TableColumn(tabla1, SWT.NONE);
				  columna2.setWidth(90);
				  columna2.setText("Usuario");
				  
				  TableColumn columna3 = new TableColumn(tabla1, SWT.NONE);
				  columna3.setWidth(90);
				  columna3.setText("Sexo");
				  
				  TableColumn columna4 = new TableColumn(tabla1, SWT.NONE);
				  columna4.setWidth(150);
				  columna4.setText("Tipo de Trabajador");
				  
				  TableColumn columna5 = new TableColumn(tabla1, SWT.NONE);
				  columna5.setWidth(100);
				  columna5.setText("Acciones");
			  */
			  
			 
			//----------------------------------------------------------
			   //FillLayout bottomFillLayout = new FillLayout();
				//GridData bottomGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
				
				//Composite bottomGroup = new Composite(test, SWT.NONE);
				//bottomGroup.setText("Campos definidos");
				//bottomGroup.setLayout(bottomFillLayout);
				//bottomGroup.setLayoutData(bottomGridData);
				
				//FormDatas.attach(bottomGroup).atTopTo(listado1, 10);
				
				
				CRUDTreeTable tabla = new CRUDTreeTable(test, SWT.NONE);
				tabla.setEntityClass(WorkerGrid.class);
				//tabla.setAdd(true, new WorkerAddArea());
				//tabla.setUpdate(true, new _WorkerUpdateArea());
				
				tabla.setColumnHeaders(Arrays.asList("Nombre", "Observaciones", "Fecha de Registro"));		//For the internationalization.
				
				try {
					tabla.createTable();
				}
				catch(Exception e) {
				}
				FormDatas.attach(tabla).atTopTo(listado1, 10).atRight(5).atLeft(5);
				
				//TreeItem root = tabla.addRow(new WorkerGrid("Editorial Gente Nueva","EK52635", "sdafsadf", "sdf", "sdf"));
		        //tabla.addRow(new WorkerGrid("Editorial Pionero","ED63255", "sadfsad", "fdh", "sdf"));
				//tabla.addRow(new WorkerGrid("Editorial Gente Nueva","EK52635", "sdafsadf", "dfg", "sdfsd"));
		        //tabla.addRow(new WorkerGrid("Editorial Pionero","ED63255", "sadfsad", "dfg", "sdfs"));
				//tabla.addRow(new WorkerGrid("Editorial Pionero","ED63255", "sadfsad", "dfg", "sdfsd"));
				//tabla.addRow(new WorkerGrid("Editorial Pionero","ED63255", "sadfsad", "dfg", "sdfsd"));		
				//tabla.addInnerRow(root, new WorkerGrid("Editorial Pionero","ED63255", "sadfsad", "dfgdf", "sdfsd"));
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
