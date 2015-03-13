package cu.uci.abcd.administration.library.ui.model;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class CirculationRuleAddArea implements IEditableArea{

	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
	
		
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		
		
		Composite group= new Composite(shell, SWT.NORMAL);
		group.setLayout(form);
		group.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		Label lblNewLab = new Label(group, SWT.NONE);
		lblNewLab.setText("Datos Generales");
		FormDatas.attach(lblNewLab).atTopTo(group, 10);
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setText("Tipo de Material");
		FormDatas.attach(lblNewLabel).atTopTo(lblNewLab, 10);
		
		Combo estado1 = new Combo(group, SWT.NONE);
		estado1.setItems(new String[] { "LIbro", "Revista","Ensayo"});
		FormDatas.attach(estado1).atTopTo(lblNewLabel, 10);
		
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setText("Tipo de Usuario");
		FormDatas.attach(lblNewLabel_1).atTopTo(lblNewLab, 10).atLeftTo(estado1, 70);
		
		Combo estado2 = new Combo(group, SWT.NONE);
		estado2.setItems(new String[] { "Esudiante", "Profesor",});
		FormDatas.attach(estado2).atTopTo(lblNewLabel_1, 10).atLeftTo(estado1, 70);
		
		Label lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setText("Estado de la Regla");
		FormDatas.attach(lblNewLabel_2).atTopTo(lblNewLab, 10).atLeftTo(estado2, 70);
		
		Button btnAciva = new Button(group, SWT.RADIO);
		FormDatas.attach(btnAciva).atTopTo(lblNewLabel_2, 10).atLeftTo(estado2, 70);
		btnAciva.setText("Activa");
		
		Button btnInaciva = new Button(group, SWT.RADIO);
		FormDatas.attach(btnInaciva).atTopTo(lblNewLabel_2, 10).atLeftTo(btnAciva, 30);
		btnInaciva.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = -6660764764913146142L;

			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnInaciva.setText("Inactiva");
		
		Label separador = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(estado1, 10).withWidth(750);
		
		Label lblDatosDelPrstamo = new Label(group, SWT.NONE);
		lblDatosDelPrstamo.setText("Datos del Préstamo");
		FormDatas.attach(lblDatosDelPrstamo).atTopTo(separador, 10);
		
		Label lblLapsoDeTiempo = new Label(group, SWT.NONE);
		lblLapsoDeTiempo.setText("Lapso de Tiempo Normal");
		FormDatas.attach(lblLapsoDeTiempo).atTopTo(lblDatosDelPrstamo, 10);
		
		Combo combo_2 = new Combo(group, SWT.NONE);
		FormDatas.attach(combo_2).atTopTo(lblLapsoDeTiempo, 10).withWidth(130);
		
		Label lblLapsoDeTiempo_1 = new Label(group, SWT.NONE);
		lblLapsoDeTiempo_1.setText("Lapso de Tiempo (En Cola)");
		FormDatas.attach(lblLapsoDeTiempo_1).atTopTo(lblDatosDelPrstamo, 10).atLeftTo(combo_2, 60);
		
		Combo combo_3 = new Combo(group, SWT.NONE);
		FormDatas.attach(combo_3).atTopTo(lblLapsoDeTiempo_1, 10).atLeftTo(combo_2, 60).withWidth(130);
		
		Label lblNmeroDePrsamos = new Label(group, SWT.NONE);
		FormDatas.attach(lblNmeroDePrsamos).atTopTo(lblDatosDelPrstamo, 10).atLeftTo(combo_3, 60);
		lblNmeroDePrsamos.setText("Préstamos Permitidos");
		
		Combo combo_1 = new Combo(group, SWT.NONE);
		FormDatas.attach(combo_1).atTopTo(lblNmeroDePrsamos, 10).atLeftTo(combo_3, 60).withWidth(130);
		
		Label lblNewRenovaciones = new Label(group, SWT.NONE);
		FormDatas.attach(lblNewRenovaciones).atTopTo(lblDatosDelPrstamo, 10).atLeftTo(combo_1, 60);
		lblNewRenovaciones.setText("Renovaciones Permitidas");
		
		Combo combo = new Combo(group, SWT.NONE);
		FormDatas.attach(combo).atTopTo(lblNewRenovaciones, 10).atLeftTo(combo_1, 60).withWidth(130);
		
		
		Label lblUnidad = new Label(group, SWT.NONE);
		lblUnidad.setText("Unidad");
		FormDatas.attach(lblUnidad).atTopTo(combo, 20);
	
		Button btnDas = new Button(group, SWT.RADIO);
		FormDatas.attach(btnDas).atTopTo(lblUnidad, 10);
		btnDas.setText("Días");
		
		Button btnHoras = new Button(group, SWT.RADIO);
		FormDatas.attach(btnHoras).atTopTo(lblUnidad, 10).atLeftTo(btnDas, 30);
		btnHoras.setText("Horas");
		
		Button btnCheckButton = new Button(group, SWT.CHECK);
		FormDatas.attach( btnCheckButton).atTopTo(combo, 20).atLeftTo(btnHoras, 70);
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = -8061892215035998610L;

			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCheckButton.setText("Permitir reservas aún cuando el usuario esé atrasado");
		
		Button btnPrestarVariosEjemplares = new Button(group, SWT.CHECK);
		btnPrestarVariosEjemplares.setText("Prestar varios ejemplares del mismo registro");
		FormDatas.attach(btnPrestarVariosEjemplares).atTopTo(btnCheckButton, 10).atLeftTo(btnHoras, 70);
		
		Label separador1 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador1).atTopTo(btnPrestarVariosEjemplares, 10).withWidth(750);
		  
		Label lblDatosDeLa = new Label(group, SWT.NONE);
		lblDatosDeLa.setText("Datos de la Reservación");
		FormDatas.attach(lblDatosDeLa).atTopTo(separador1, 10);
		
			
			Button btnPermitirReservas = new Button(group, SWT.CHECK);
			btnPermitirReservas.setText("Permitir reservas");
			FormDatas.attach(btnPermitirReservas).atTopTo(lblDatosDeLa, 10);
		
		Button btnDasDeEspera = new Button(group, SWT.CHECK);
		btnDasDeEspera.setText("Días de espera para retirar el material reservado");
		FormDatas.attach(btnDasDeEspera).atTopTo(lblDatosDeLa, 10).atLeftTo(btnPermitirReservas, 70);
		
		Label separador2 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador2).atTopTo(btnDasDeEspera, 10).withWidth(750);
		
		Label lblDatosDeLa_1 = new Label(group, SWT.NONE);
		lblDatosDeLa_1.setText("Datos de la Sanción/Multa");
		FormDatas.attach(lblDatosDeLa_1).atTopTo(separador2, 10);
		
		Label lblMultaPorDa = new Label(group, SWT.WRAP);
		FormDatas.attach(lblMultaPorDa).atTopTo(lblDatosDeLa_1, 10).withWidth(160).withHeight(30);
		lblMultaPorDa.setText("Multa por Día de Atraso (MDA)");
		
		Text text = new Text(group, SWT.BORDER);
		FormDatas.attach(text).atTopTo(lblMultaPorDa, 10).withWidth(110);
		
		Label lblMulaPorDa = new Label(group, SWT.WRAP);
		FormDatas.attach(lblMulaPorDa).atTopTo(lblDatosDeLa_1, 10).atLeftTo(text, 60).withWidth(160).withHeight(30);
		lblMulaPorDa.setText("Multa por Día de Atraso (Si es Reservado)(MDAR)");
		
		Text text_1 = new Text(group, SWT.BORDER);
		FormDatas.attach(text_1 ).atTopTo(lblMulaPorDa, 10).atLeftTo(text, 60).withWidth(110);
		
		Label lblDasDeSuspencin = new Label(group, SWT.WRAP);
		FormDatas.attach(lblDasDeSuspencin).atTopTo(lblDatosDeLa_1, 10).atLeftTo(text_1, 60).withWidth(160).withHeight(30);
		lblDasDeSuspencin.setText("Días de Suspención por Días de Atraso");
		
		Combo combo_5 = new Combo(group, SWT.NONE);
		FormDatas.attach(combo_5).atTopTo(lblDasDeSuspencin, 10).atLeftTo(text_1, 60).withWidth(130);
		
		Label lblDasDeSuspencin_1 = new Label(group, SWT.WRAP);
		FormDatas.attach(lblDasDeSuspencin_1).atTopTo(lblDatosDeLa_1, 10).atLeftTo(combo_5, 60).withWidth(190).withHeight(30);
		lblDasDeSuspencin_1.setText("Días de Suspención por Días de Atraso (Si es Reservado)");
		
			Combo combo_4 = new Combo(group, SWT.NONE);
			FormDatas.attach(combo_4).atTopTo(lblDasDeSuspencin, 10).atLeftTo(combo_5, 60).withWidth(130);
		
			
			Label lblMultaPorPrdida = new Label(group, SWT.NONE);
			lblMultaPorPrdida.setText("Multa por Pérdida (MP)");
			FormDatas.attach(lblMultaPorPrdida).atTopTo(combo_4, 20);
		
		    Text text_2 = new Text(group, SWT.BORDER);
		    FormDatas.attach(text_2).atTopTo(lblMultaPorPrdida, 10).withWidth(110);
		
		  
		  Button btnCerrar = new Button(group, SWT.PUSH);
			btnCerrar.setText(AbosMessages.get().BUTTON_CANCEL);
			  FormDatas.attach(btnCerrar).atTopTo(text_2, 10).atRight();
			  
			  Button Consultar = new Button(group, SWT.PUSH);
			  Consultar.setText(AbosMessages.get().BUTTON_ACEPT);
			  FormDatas.attach(Consultar).atTopTo(text_2, 10).atRightTo(btnCerrar, 10);
			  
			  return shell;
	
	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Control getControl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
