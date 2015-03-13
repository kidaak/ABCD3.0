package cu.uci.abcd.administration.library.ui;

import java.math.BigDecimal;
import java.util.Collection;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.administration.library.ui.controller.PenaltyEquationViewController;
import cu.uci.abcd.administration.library.ui.model.LibraryGrid;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.PenaltyEquation;
import cu.uci.abcd.management.security.ILoginService;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ConfigurePenaltyEquation implements IContributor{
	
	private IViewController controller;
	Text mma;
	Text mmp;
	PenaltyEquation penaltyEquationAux =  null;
	
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Configurar Ecuación para Multa";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ConfigurarEcuacionMultaID";
	}



	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite shell) {
		
		
				
		
		FormLayout form = new FormLayout();
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		shell.setLayout(form);
		Composite test= new Composite(shell, SWT.NORMAL);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test.setLayout(form);
		FormDatas.attach(test).atLeftTo(shell, 10).atLeft(0).atRight(0);
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Atraso");

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10).atLeft(10);
		
		
			Label lblNombreDelRegistro=  new Label(test, SWT.NONE);
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 5).atLeft(10);
			lblNombreDelRegistro.setText("Monto de la Multa(MMA)");
			
			
			mma = new Text(test, SWT.BORDER);
			FormDatas.attach(mma).atTopTo(lblNombreDelRegistro, 10).atLeft(10).withWidth(100);
			
			Label lblCriiteriosDeBsqueda1=  new Label(test, SWT.NONE);
			lblCriiteriosDeBsqueda1.setText("Pérdida");

			FormDatas.attach(lblCriiteriosDeBsqueda1).atTopTo(mma, 15).atLeft(10);
			
			
				Label lblNombreDelRegistro1=  new Label(test, SWT.NONE);
				FormDatas.attach(lblNombreDelRegistro1).atTopTo(lblCriiteriosDeBsqueda1, 5).atLeft(10);
				lblNombreDelRegistro1.setText("Monto de la Multa(MMP)");
				
				
				mmp = new Text(test, SWT.BORDER);
				FormDatas.attach(mmp).atTopTo(lblNombreDelRegistro1, 10).atLeft(10).withWidth(100);
				
				Label lblNewLabel = new Label(test, SWT.NORMAL);
				  FormDatas.attach(lblNewLabel).atTopTo(lblCriiteriosDeBsqueda, 5).atLeftTo(lblNombreDelRegistro, 30);
				  lblNewLabel.setText("Ecuación del Monto Total a Pagar (MTP)");
				  
                Label lblNewLabel1 = new Label(test, SWT.NORMAL);
                FormDatas.attach(lblNewLabel1).atTopTo(lblNewLabel, 5).atLeftTo(lblNombreDelRegistro, 30);
				  lblNewLabel1.setText("MTP = MM + (MDA*DA)    Para un Material que esté No Reservado");
				  
                Label lblNewLabel2 = new Label(test, SWT.NORMAL);
                FormDatas.attach(lblNewLabel2).atTopTo(lblNewLabel1, 5).atLeftTo(lblNombreDelRegistro, 30);
				  lblNewLabel2.setText("MTP = MM + (MDAR*DA)    Para un Material que esté Reservado");
				  
				  Label lblNewLabel_1 = new Label(test, SWT.NORMAL);
				  FormDatas.attach(lblNewLabel_1).atTopTo(lblCriiteriosDeBsqueda1, 5).atLeftTo(lblNombreDelRegistro1, 30);
				  lblNewLabel_1.setText("Ecuación del Monto Total a Pagar (MTP)");
				  
                Label lblNewLabel13 = new Label(test, SWT.NORMAL);
                FormDatas.attach(lblNewLabel13).atTopTo(lblNewLabel_1, 5).atLeftTo(lblNombreDelRegistro1, 30);
				  lblNewLabel13.setText("MTP = MM + (MP*VM)");
				
				  Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
					FormDatas.attach(separador).atTopTo(mmp, 10).atLeft(5).atRight(5);
					
				  Label lblNewLabel19 = new Label(test, SWT.NORMAL);
				  FormDatas.attach(lblNewLabel19).atTopTo(separador, 10).atLeft(10);
				  lblNewLabel19.setText("Leyenda");
				  
				  Label lblNewLabel12 = new Label(test, SWT.NORMAL);
				  FormDatas.attach(lblNewLabel12).atTopTo(lblNewLabel19, 5).atLeft(10);
				  lblNewLabel12.setText("MTP - Monto Total a Pagar");
				  
                Label lblNewLabel14 = new Label(test, SWT.NORMAL);
                FormDatas.attach(lblNewLabel14).atTopTo(lblNewLabel12, 5).atLeft(10);
				  lblNewLabel14.setText("MM - Monto de la Multa (Cada biblioteca estipula un MM en dependencia de sus características)");
				  
                Label lblNewLabel21 = new Label(test, SWT.NORMAL);
                FormDatas.attach(lblNewLabel21).atTopTo(lblNewLabel14, 5).atLeft(10);
				  lblNewLabel21.setText("MDA - Monto por día de Atraso (Se toma el valor de la regla que relaciona el Tipo de Usuario con el Material Involucrado)");
				  
				  Label lblNewLabel_15 = new Label(test, SWT.NORMAL);
				  FormDatas.attach(lblNewLabel_15).atTopTo(lblNewLabel21, 5).atLeft(10);
				  lblNewLabel_15.setText("DA - Días de Atraso (Se cuentan los días de atraso desde la fecha de devolución hasa la fecha en que se devuelve el material)");
				  
                Label lblNewLabel16 = new Label(test, SWT.NORMAL);
                FormDatas.attach(lblNewLabel16).atTopTo(lblNewLabel_15, 5).atLeft(10);
				  lblNewLabel16.setText("MP - Monto por Pérdida (Se toma el valor de la regla que relaciona el Tipo de Usuario con el Material Involucrado)");
				  
				  Label lblNewLabel17 = new Label(test, SWT.NORMAL);
	                FormDatas.attach(lblNewLabel17).atTopTo(lblNewLabel16, 5).atLeft(10);
					  lblNewLabel17.setText("VM - Valor del Material (Precio de adquisición o valor estimado del material)");
				  
					  Label separador1 = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
						FormDatas.attach(separador1).atTopTo(lblNewLabel17, 10).atLeft(5).atRight(5);
						
				 Button cerrar = new Button(test, SWT.PUSH);
				 FormDatas.attach(cerrar).atTopTo(separador1, 10).atRight();
				  cerrar.setText(AbosMessages.get().BUTTON_CANCEL);
				  
				  Button acceptButton = new Button(test, SWT.PUSH);
				  FormDatas.attach(acceptButton).atTopTo(separador1, 10).atRightTo(cerrar, 10);
				  acceptButton.setText(AbosMessages.get().BUTTON_ACEPT);
				  
				  acceptButton.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							ILoginService log = (ILoginService) RWT.getUISession().getHttpSession().getAttribute("loginService"); 
							Library library = (Library) log.getSecurityDataStore().getSecurityDataObject("library");
							
							Library libraryAux = ((PenaltyEquationViewController) controller).getLibraryById(library.getActorID());
							PenaltyEquation penaltyEquation = ((PenaltyEquationViewController) controller).findPenaltyEquationByLibrary(library.getActorID());
							if( penaltyEquation==null ){
								penaltyEquation = new PenaltyEquation();
							}
							
							penaltyEquation.setDelayAmount(BigDecimal.valueOf(Double.parseDouble(mma.getText())));
							penaltyEquation.setLostAmount(BigDecimal.valueOf(Double.parseDouble(mmp.getText())));
							penaltyEquation.setOwner(libraryAux);
										
							((PenaltyEquationViewController) controller).SavePenaltyEquation(penaltyEquation);
						}

					});
				  
				  
				  LoadPenaltyEquation();
		return shell;
	}


	private void LoadPenaltyEquation() {
		//Long idLibrary = (long) 2;
		
		ILoginService log = (ILoginService) RWT.getUISession().getAttribute("loginService"); 
		Library library = (Library) log.getSecurityDataStore().getSecurityDataObject("library");
		
		PenaltyEquation penaltyEquation = ((PenaltyEquationViewController) controller).findPenaltyEquationByLibrary(library.getActorID());
		if( penaltyEquation!=null ){
			penaltyEquationAux = penaltyEquation;
			//Integer mmaValue = penaltyEquation.getDelayAmount().intValueExact();
			mma.setText(penaltyEquation.getDelayAmount().toString());
			//Integer mmpValue = penaltyEquation.getLostAmount().intValueExact();
			mmp.setText(penaltyEquation.getLostAmount().toString());
		}
		
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
		this.controller = controller;
	}
}
