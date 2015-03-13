package cu.uci.abcd.administration.library.ui;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abcd.administration.library.ui.model._HoraryAddArea;
import cu.uci.abcd.administration.library.ui.model._HoraryUpdateArea;
import cu.uci.abcd.administration.library.ui.model._HoraryGrid;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Combo;

public class ConfigureHorary implements IContributor{
	

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Configurar Horario Laboral";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ConfigurarHorarioLaboralID";
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		final Composite test= new Composite(shell, SWT.NORMAL);
		test.setLayout(form);
		
		//test.setText("Configurar Horario Laboral");
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(test).atLeftTo(shell, 10).atLeft(0).atRight(0);
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setLayoutData(new FormData());
		lblCriiteriosDeBsqueda.setText("Horario Laboral");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10).atLeft(10);
		
		
			Label lblNombreDelRegistro=  new Label(test, SWT.NONE);
			lblNombreDelRegistro.setLayoutData(new FormData());
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 20).atLeft(10);
			lblNombreDelRegistro.setText("Día de la Semana");
			
			Combo combo = new Combo(test, SWT.NONE);
			  combo.setItems(new String[] { "Lunes", "Martes","Miércoles","Jueves", "Viernes","Sábado","Domingo"});
				FormDatas.attach(combo).atTopTo(lblNombreDelRegistro, 10).atLeft(10);
			
			Label lblCriiteriosDeBsqueda1=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda1.setText("Desde");
            FormDatas.attach(lblCriiteriosDeBsqueda1).atTopTo(lblCriiteriosDeBsqueda, 1).atLeftTo(combo, 40);
            
            Label lblCriiteriosDeBsqueda12=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda12.setText("Hora");
            FormDatas.attach(lblCriiteriosDeBsqueda12).atTopTo(lblCriiteriosDeBsqueda1, 2).atLeftTo(combo, 40);
            
            Text texto = new Text(test, SWT.BORDER);
            FormDatas.attach(texto).atTopTo(lblCriiteriosDeBsqueda12, 10).atLeftTo(combo, 40);;
            
            Combo combo_1 = new Combo(test, SWT.NONE);
  		  combo_1.setItems(new String[] { "AM", "PM"});
  			FormDatas.attach(combo_1).atTopTo(lblCriiteriosDeBsqueda12, 10).atLeftTo(texto, 5);
  			
            Label lblCriiteriosDeBsqueda2=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda2.setText("Hasta");
            FormDatas.attach(lblCriiteriosDeBsqueda2).atTopTo(lblCriiteriosDeBsqueda, 1).atLeftTo(combo_1, 40);
            
            Label lblCriiteriosDeBsqueda21=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda21.setText("Hora");
            FormDatas.attach(lblCriiteriosDeBsqueda21).atTopTo(lblCriiteriosDeBsqueda1, 2).atLeftTo(combo_1, 40);
            
           Text texto_1 = new Text(test, SWT.BORDER);
            FormDatas.attach(texto_1).atTopTo(lblCriiteriosDeBsqueda21, 10).atLeftTo(combo_1, 40);
            
            Combo combo_2 = new Combo(test, SWT.NONE);
  		    combo_2.setItems(new String[] {"AM", "PM"});
  			FormDatas.attach(combo_2).atTopTo(lblCriiteriosDeBsqueda21, 10).atLeftTo(texto_1, 5);
  			
  			Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
  			FormDatas.attach(separador).atTopTo(combo, 10).atLeft(5).atRight(5);
  			
  			Button btnAdicionar= new Button(test, SWT.NORMAL);
  			btnAdicionar.setText(AbosMessages.get().BUTTON_ADD);
  			 FormDatas.attach(btnAdicionar).atTopTo(separador, 10).atRight(5);
  			
  			
  			
		
		  
		  Label listado = new Label(test, SWT.NORMAL);
		  FormDatas.attach(listado).atTopTo(btnAdicionar, 10).atLeft(10);
		  listado.setText("Horario Semanal");
	
	  //-----------------Tabla--------------------------------------
	  /*
		  Table tabla = new Table(test, SWT.BORDER | SWT.FULL_SELECTION);
		  FormDatas.attach(tabla).atTopTo(listado, 10);
		  tabla.setHeaderVisible(true);
		  tabla.setLinesVisible(true);
		  
		  TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		  tableItem_1.setText( new String[] { "column 0", "column 1" } );

		  TableColumn columna0 = new TableColumn(tabla, SWT.NONE);
		  columna0.setWidth(200);
		  columna0.setText("Día de la semana");
		  
		  TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		  columna1.setWidth(110);
		  columna1.setText("Desde");
		  
		  TableColumn columna12 = new TableColumn(tabla, SWT.NONE);
		  columna12.setWidth(110);
		  columna12.setText("Hasta");
		  
		  TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		  columna2.setWidth(110);
		  columna2.setText("Acciones");
		  
		  
		Button cerrar = new Button(test, SWT.PUSH);
		 FormDatas.attach(cerrar).atTopTo(tabla, 10).atRight();
		  cerrar.setText("Cancelar");
		  
		  Button eliminar = new Button(test, SWT.PUSH);
		  FormDatas.attach(eliminar).atTopTo(tabla, 10).atRightTo(cerrar, 10);
		  eliminar.setText("Aceptar");
		  */
		  
		  //FillLayout bottomFillLayout = new FillLayout();
			//GridData bottomGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
			
			//Composite bottomGroup = new Composite(test, SWT.NONE);
			//bottomGroup.setLayout(bottomFillLayout);
			//bottomGroup.setLayoutData(bottomGridData);
			
			//FormDatas.attach(bottomGroup).atTopTo(listado, 10);
			
			CRUDTreeTable tabla = new CRUDTreeTable(test, SWT.NONE);
			tabla.setEntityClass(_HoraryGrid.class);
			tabla.setAdd(true, new _HoraryAddArea());
			tabla.setUpdate(true, new _HoraryUpdateArea());
			
			tabla.setColumnHeaders(Arrays.asList("Dia de la semana", "Desde", "Hasta"));		//For the internationalization.
			
			try {
				tabla.createTable();
			}
			catch(Exception e) {
			}
			FormDatas.attach(tabla).atTopTo(listado, 10).atRight(5).atLeft(5);
			
			//TreeItem root = tabla.addRow(new _HoraryGrid("Lunes","8.00 am", "5.00 pm"));
	        tabla.addRow(new _HoraryGrid("Lunes","8.00 am", "5.00 pm"));
	        tabla.addRow(new _HoraryGrid("Martes","9.00 am", "5.00 pm"));
	        tabla.addRow(new _HoraryGrid("Miercoles","9.00 am", "5.00 pm"));
	        tabla.addRow(new _HoraryGrid("Jueves","9.00 am", "5.00 pm"));
	        tabla.addRow(new _HoraryGrid("Viernes","8.00 am", "12.00 pm"));		
			//tabla.addInnerRow(root, new _HoraryGrid("Editorial Pionero","ED63255", "sadfsad"));
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
