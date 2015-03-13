package cu.uci.abcd.administration.library.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _ViewDataLibrary implements IContributor{


	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Visualizar Datos de la Biblioteca";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return ManageLibrary.class.getSimpleName() + "id13";
	}

	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
	
		
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		
		Group test= new Group(shell, SWT.NORMAL);
		test.setLayout(form);
		test.setText("Registrar Datos de la Biblioteca");
		
        TabFolder tabFolder = new TabFolder(test, SWT.NONE);
        FormDatas.attach(tabFolder).atTopTo(test);
		
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Bibiloteca");
		
		TabItem tbtmNewItem1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem1.setText("Trabajadores");
		
		TabItem tbtmNewItem2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem2.setText("Formacion");
		
		Composite group = new Composite(tabFolder, SWT.NONE);
		group.setData(RWT.CUSTOM_VARIANT, "gray_background");
		group.setLayout(form);
		tbtmNewItem.setControl(group);
		FormDatas.attach(group).atTopTo(tabFolder);
		
		Label lblNewLab = new Label(group, SWT.NONE);
		lblNewLab.setText("Datos Generales");
		FormDatas.attach(lblNewLab).atTopTo(group, 10);
		
		Table tabla= new Table(group, SWT.BORDER|SWT.FULL_SELECTION);
		tabla.setTouchEnabled(true);
		FormDatas.attach(tabla).atTopTo(lblNewLab, 10);
		 
		TableItem item= new TableItem(tabla, SWT.NONE);
		 item.setText("Nombre");
		 
		 
		 TableItem item1= new TableItem(tabla, SWT.NONE);
		 item1.setText("Superficie");
		 TableColumn tabc2 = new TableColumn(tabla, SWT.None);
		    tabc2.setWidth(150);
		    tabc2.setText("");
		
		TableItem item2= new TableItem(tabla, SWT.NONE);
		item2.setText("Cantidad de Salas");
		TableColumn tabc3 = new TableColumn(tabla, SWT.None);
			    tabc3.setWidth(150);
			    tabc3.setText("");
			    
		tabla.setLinesVisible(true);
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setText("Datos del usuario que actua en el sisema");
		FormDatas.attach(lblNewLabel).atTopTo(group, 10).atLeftTo(tabla, 50);
		
		Table tabla1= new Table(group, SWT.BORDER|SWT.FULL_SELECTION);
		tabla1.setTouchEnabled(true);
		FormDatas.attach(tabla1).atTopTo(lblNewLabel, 10).atLeftTo(tabla, 50);

		TableItem item7= new TableItem(tabla1, SWT.NONE);
		item7.setText("Nombre y Apellidos");
		TableColumn tabc8 = new TableColumn(tabla1, SWT.None);
			    tabc8.setWidth(150);
			    tabc8.setText("");
		 
		 
		 TableItem item8= new TableItem(tabla1, SWT.NONE);
		 item8.setText("Usuario");
		 TableColumn tabc6 = new TableColumn(tabla1, SWT.None);
		    tabc6.setWidth(150);
		    tabc6.setText("");

		    TableItem item9= new TableItem(tabla1, SWT.NONE);
		    item9.setText("Fecha");
		    TableItem item10= new TableItem(tabla1, SWT.NONE);
		    item10.setText("Hora");

		tabla1.setLinesVisible(true);
		
		Label lblDireccin = new Label(group, SWT.NONE);
		lblDireccin.setText("Dirección");
		FormDatas.attach(lblDireccin).atTopTo(tabla1,10);
		
		Text text_3 = new Text(group, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(text_3).atTopTo(lblDireccin, 10).withWidth(550).withHeight(30);
		
		Label separador = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(text_3, 10).withWidth(690);
		
		Label lblNewLabel_3 = new Label(group, SWT.NONE);
		lblNewLabel_3.setText("Datos de los Puestos de Lectura");
		FormDatas.attach(lblNewLabel_3).atTopTo(separador, 10);
	
		Table tabla13= new Table(group, SWT.BORDER|SWT.FULL_SELECTION);
		tabla13.setTouchEnabled(true);
		FormDatas.attach(tabla13).atTopTo(lblNewLabel_3, 10);
		 
		TableItem item0= new TableItem(tabla13, SWT.NONE);
		 item0.setText("Cantidad");
		 
		 
		 TableItem item4= new TableItem(tabla13, SWT.NONE);
		 item4.setText("Formación de Usuario");
		 TableColumn tabc4 = new TableColumn(tabla13, SWT.None);
		    tabc4.setWidth(150);
		    tabc4.setText("");
		
		TableItem item5= new TableItem(tabla13, SWT.NONE);
		item5.setText("Trabajo en Grupo");
		TableColumn tabc5 = new TableColumn(tabla13, SWT.None);
			    tabc5.setWidth(150);
			    tabc5.setText("");
			   
		
		tabla13.setLinesVisible(true);
		
		Label lblEstaneras = new Label(group, SWT.NONE);
		lblEstaneras.setText("Estanterías");
		FormDatas.attach(lblEstaneras).atTopTo(separador, 10).atLeftTo(tabla13, 50);
		
		
		Table tabla14= new Table(group, SWT.BORDER|SWT.FULL_SELECTION);
		tabla14.setTouchEnabled(true);
		FormDatas.attach(tabla14).atTopTo(lblEstaneras, 10).atLeftTo(tabla13, 50);
		 
		TableItem item01= new TableItem(tabla14, SWT.NONE);
		 item01.setText("Metros Lineales");
		 
		 
		 TableItem item41= new TableItem(tabla14, SWT.NONE);
		 item41.setText("Abierta");
		 TableColumn tabc41 = new TableColumn(tabla14, SWT.None);
		    tabc41.setWidth(150);
		    tabc41.setText("");
		
		TableItem item51= new TableItem(tabla14, SWT.NONE);
		item51.setText("Depósito");
		TableColumn tabc51 = new TableColumn(tabla14, SWT.None);
			    tabc51.setWidth(150);
			    tabc51.setText("");
			
		tabla14.setLinesVisible(true);
		
	
		Label separador11 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador11).atTopTo(tabla14, 10).withWidth(690);
		
		Label lblEquipamiento = new Label(group, SWT.NONE);
		lblEquipamiento.setText("Equipamiento");
		FormDatas.attach(lblEquipamiento).atTopTo(separador11, 10);
		
		Table tabla15= new Table(group, SWT.BORDER|SWT.FULL_SELECTION);
		tabla15.setTouchEnabled(true);
		FormDatas.attach(tabla15).atTopTo(lblEquipamiento, 10);
		 
		TableItem item02= new TableItem(tabla15, SWT.NONE);
		 item02.setText("PC para Usuarios");
		 
		 
		 TableItem item42= new TableItem(tabla15, SWT.NONE);
		 item42.setText("PC para Trabajadores");
		 TableColumn tabc42 = new TableColumn(tabla15, SWT.None);
		    tabc42.setWidth(150);
		    tabc42.setText("");
		
		TableItem item52= new TableItem(tabla15, SWT.NONE);
		item52.setText("Lect. y Repr. Diversos");
		TableColumn tabc52 = new TableColumn(tabla15, SWT.None);
			    tabc52.setWidth(150);
			    tabc52.setText("");
			   
		tabla15.setLinesVisible(true);
		
		Label espacio= new Label(group, SWT.NORMAL);
		FormDatas.attach(espacio).atTopTo(tabla15, 10);
		
		  Button cerrar = new Button(test, SWT.PUSH);
		  FormDatas.attach(cerrar).atTopTo(tabFolder, 10).atRight(30);
		  cerrar.setText("Cerrar");
		  
        Button eliminar = new Button(test, SWT.PUSH);
        FormDatas.attach(eliminar).atTopTo(tabFolder, 10).atRightTo(cerrar, 10);
		  eliminar.setText("Eliminar");
		  
		 Button modificar= new Button(test, SWT.PUSH);
		 FormDatas.attach(modificar).atTopTo(tabFolder, 10).atRightTo(eliminar, 10);
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
