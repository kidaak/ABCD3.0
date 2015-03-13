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
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

import org.eclipse.swt.layout.FormData;

public class _RegisterPublicHolidayDay implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Dia Feriado";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return _RegisterPublicHolidayDay.class.getSimpleName() + "id14";
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
		
		test.setText("Registrar Dia Feriado");
		FormDatas.attach(test).atLeftTo(shell, 110);
		
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setLayoutData(new FormData());
		lblCriiteriosDeBsqueda.setText("Datos del Dia Feriado");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10);
		
			 Table tabla= new Table(test, SWT.BORDER|SWT.FULL_SELECTION);
			 tabla.setLayoutData(new FormData());
				tabla.setTouchEnabled(true);
				FormDatas.attach(tabla).atTopTo(lblCriiteriosDeBsqueda, 10);
				 
				TableItem item= new TableItem(tabla, SWT.NONE);
				 item.setText("Dia");
				 
				 TableItem item1= new TableItem(tabla, SWT.NONE);
				 item1.setText("Mes");
				 TableColumn tabc2 = new TableColumn(tabla, SWT.None);
				    tabc2.setWidth(140);
				    tabc2.setText("");
				
				TableItem item2= new TableItem(tabla, SWT.NONE);
				item2.setText("Año");
				TableColumn tabc3 = new TableColumn(tabla, SWT.None);
					    tabc3.setWidth(140);
					    tabc3.setText("");
					    
					    TableItem item3= new TableItem(tabla, SWT.NONE);
						item3.setText("Dia de la Semana");
						
				tabla.setLinesVisible(true);
				
				Label listado1 = new Label(test, SWT.NORMAL);
				listado1.setLayoutData(new FormData());
				  FormDatas.attach(listado1).atTopTo(tabla, 20);
				   listado1.setText("Titulo");
				   
				   Text text_1 = new Text(test, SWT.BORDER);
				   text_1.setLayoutData(new FormData());
					FormDatas.attach(text_1).atTopTo(listado1, 10);
					
					Label listado2 = new Label(test, SWT.NORMAL);
					listado2.setLayoutData(new FormData());
					  FormDatas.attach(listado2).atTopTo(text_1, 20);
					   listado2.setText("Descripcion");
					   
					   Text text_2 = new Text(test, SWT.BORDER |  SWT.WRAP);
					   text_2.setLayoutData(new FormData());
						 FormDatas.attach(text_2).atTopTo(listado2 , 10).withHeight(30).withWidth(580);
						 
						 Button btnRadioButton = new Button(test, SWT.RADIO);
						  FormDatas.attach(btnRadioButton).atTopTo(text_2, 10);
						  btnRadioButton.setText("Feriado solo este dia en especifico en el año");
						  
						  Button btnRadioButton_1 = new Button(test, SWT.RADIO);
						  FormDatas.attach(btnRadioButton_1).atTopTo(btnRadioButton, 10);
						  btnRadioButton_1.setText("Feriado este dia cada año");
						  
						  Button btnRadioButton_2 = new Button(test, SWT.RADIO);
						  FormDatas.attach(btnRadioButton_2).atTopTo(btnRadioButton_1, 10);
						  btnRadioButton_2.setText("No laborable este dia de la semana en todas las semanas del año");
						  
						  Button btnRadioButton_3 = new Button(test, SWT.RADIO);
						  FormDatas.attach(btnRadioButton_3).atTopTo(btnRadioButton_2, 10);
						  btnRadioButton_3.setText("Laborable");
						  
				
				Button cerrar = new Button(test, SWT.PUSH);
				cerrar.setLayoutData(new FormData());
				  FormDatas.attach(cerrar).atTopTo(btnRadioButton_3, 10).atRight();
				  cerrar.setText(AbosMessages.get().BUTTON_CANCEL);
				  
                Button eliminar = new Button(test, SWT.PUSH);
                eliminar.setLayoutData(new FormData());
                FormDatas.attach(eliminar).atTopTo(btnRadioButton_3, 10).atRightTo(cerrar, 10);
				  eliminar.setText(AbosMessages.get().BUTTON_ACEPT);
				  
				 
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
