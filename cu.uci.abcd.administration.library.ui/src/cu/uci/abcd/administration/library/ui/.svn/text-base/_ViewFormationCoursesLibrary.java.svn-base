package cu.uci.abcd.administration.library.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _ViewFormationCoursesLibrary implements IContributor{

	@Override
	public String contributorName() {
		return "Consultar Cursos de Formacion";
	}

	@Override
	public String getID() {
		return "ConsultarCursoFormacioID";
	}

	@Override
	public Control createUIControl(Composite shell) {
	
		
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		
		Composite test= new Composite(shell, SWT.NORMAL);
		test.setLayout(form);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test.setLayout(form);
		
TabFolder tabFolder = new TabFolder(test, SWT.NONE);
FormDatas.attach(tabFolder).atTopTo(test);
		
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("Cursos de Formacion");
		
		TabItem tbtmNewItem1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem1.setText("Trabajadores Asociados");
		
		Composite group = new Composite(tabFolder, SWT.NONE);
		group.setData(RWT.CUSTOM_VARIANT, "gray_background");
		group.setLayout(form);
		tbtmNewItem.setControl(group);
		FormDatas.attach(group).atTopTo(tabFolder);
		
		Label lblNewLab = new Label(group, SWT.NONE);
		lblNewLab.setText("Datos de los Cursos de Formacion");
		FormDatas.attach(lblNewLab).atTopTo(group, 10);
		
		Table tabla= new Table(group, SWT.BORDER|SWT.FULL_SELECTION);
		tabla.setTouchEnabled(true);
		FormDatas.attach(tabla).atTopTo(lblNewLab, 10);
		 
		TableItem item= new TableItem(tabla, SWT.NONE);
		item.setText("Nombre del curso");
		
		
		TableItem item1= new TableItem(tabla, SWT.NONE);
		item1.setText("Profesor");
		TableColumn tabc2 = new TableColumn(tabla, SWT.None);
		tabc2.setWidth(150);
		tabc2.setText("");
		
		TableItem item2= new TableItem(tabla, SWT.NONE);
		item2.setText("Cantidad de Horas");
		TableColumn tabc3 = new TableColumn(tabla, SWT.None);
		tabc3.setWidth(150);
		tabc3.setText("");
		
		TableItem item5= new TableItem(tabla, SWT.NONE);
		item5.setText("Fecha Inicio");
		
		TableItem item6= new TableItem(tabla, SWT.NONE);
		item6.setText("Fecha Fin");
		tabla.setLinesVisible(true);
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setText("Datos de la Ultima Actualizacion");
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
		
		
		Label espacio= new Label(group, SWT.NORMAL);
		FormDatas.attach(espacio).atTopTo(tabla, 10);
		
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
