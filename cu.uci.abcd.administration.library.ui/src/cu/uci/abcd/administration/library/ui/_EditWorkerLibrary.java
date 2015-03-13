package cu.uci.abcd.administration.library.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _EditWorkerLibrary implements IContributor{

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Editar Trabajador de la Biblioteca";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return _EditWorkerLibrary.class.getSimpleName() + "id11";
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
		
		test.setText("Editar Trabajador de la Biblioteca");
		FormDatas.attach(test).atLeftTo(shell, 110);
		
		Composite test1= new Composite(test, SWT.NORMAL);
		test1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test1.setLayout(form);
		
		Label lblCriiteriosDeBsqueda=  new Label(test1, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Datos de la Persona");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test1,10);
		
		
			Label lblNombreDelRegistro=  new Label(test1, SWT.NONE);
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 10);
			lblNombreDelRegistro.setText("¨Debe asociar una Persona¨");
			
			Label lblCdigo=  new Label(test1, SWT.NONE);
			FormDatas.attach(lblCdigo).atTopTo(lblNombreDelRegistro, 10);
			lblCdigo.setText("Identificación");
			
			Text estado2 = new Text(test1, SWT.NONE);
			FormDatas.attach(estado2).atTopTo(lblCdigo, 10);
			
			Button asociar = new Button(test1, SWT.PUSH);
			FormDatas.attach(asociar).atLeftTo(estado2, 30).atTopTo(lblCdigo, 10);
			asociar.setText(AbosMessages.get().BUTTON_VALIDATE);
			
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
		  exportarPDF.setText(AbosMessages.get().BUTTON_CANCEL);
		  FormDatas.attach(exportarPDF).atTopTo(text_2, 10).atRight();
		  
		  Button exportarHC = new Button(test, SWT.PUSH);
		  exportarHC.setText(AbosMessages.get().BUTTON_UPDATE);
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
