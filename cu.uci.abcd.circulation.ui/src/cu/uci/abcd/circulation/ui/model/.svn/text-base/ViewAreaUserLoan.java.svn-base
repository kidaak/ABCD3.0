package cu.uci.abcd.circulation.ui.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.controller.AllManagementLoanUserViewController;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class ViewAreaUserLoan implements IEditableArea{

	private Map<String, Control> controls;
	private IViewController controller;
	
	TableItem tbItemNameLastName;
    TableItem tbItemIdentification;
    TableItem tbItemAge;
	TableItem tbItemSex;
	TabItem tabItemLoanUSer;

	EntityLoanUser entityLoanUser; 
	
	public ViewAreaUserLoan(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite parent, IGridViewEntity entity,IVisualEntityManager manager) {
	
        parent.setLayout(new FormLayout());
        FormDatas.attach(parent).atRight(0).atLeft(0);
    	parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		entityLoanUser = (EntityLoanUser)entity;
				
        TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
		FormDatas.attach(tabFolder).atTopTo(parent, 5).atLeft(0).atRight(0);
		
		Composite compoLoanUser = new Composite(tabFolder, SWT.None);
		compoLoanUser.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		tabItemLoanUSer = new TabItem(tabFolder, SWT.None);
		tabItemLoanUSer.setControl(compoLoanUser);
		
		compoLoanUser.setLayout(new FormLayout());
		FormDatas.attach(compoLoanUser).atTopTo(tabFolder, 1).atLeft(0).atRight(0);
		
		Composite grupo = new Composite(compoLoanUser, SWT.None);
		grupo.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo.setLayout(new FormLayout());
		FormDatas.attach(grupo).atLeft(0).atRight(0).atTopTo(compoLoanUser, 15).atLeft(0).atRight(0);
		
		Label lbDetailsPerson = new Label(grupo, SWT.NONE);
		lbDetailsPerson.setText(AbosMessages.get().LABEL_DETAILS_OF_THE_PERSON);
		FormDatas.attach(lbDetailsPerson).atTopTo(grupo, 5).atLeftTo(grupo, 20);
		
		Label insertarE = new Label(grupo, SWT.NONE);
		insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		
		FormDatas.attach(insertarE).atTopTo(lbDetailsPerson, 5).atLeftTo(grupo, 20);
		
		Table tabla = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(130);
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(130);
		
		tbItemNameLastName = new TableItem(tabla, SWT.NONE);
		tbItemNameLastName.setText(1, ((Person)entityLoanUser.getOwner()).getFirstName());
		
		tbItemIdentification = new TableItem(tabla, SWT.NONE);
		tbItemIdentification.setText(1, ((Person)entityLoanUser.getOwner()).getDNI());
		
		tbItemAge = new TableItem(tabla, SWT.NONE);
		
		Date fechaN = ((Person)entityLoanUser.getOwner()).getBirthDate();
		
		String fecha = formateaFecha(fechaN.toString());
		
		int edad = calcularEdad(fecha);
		String aux = Integer.toString(edad);
		tbItemAge.setText(1, aux);
		
		tbItemSex = new TableItem(tabla, SWT.NONE);
		tbItemSex.setText(1, ((Person)entityLoanUser.getOwner()).getGender().toString());
		
		FormDatas.attach(tabla).atTopTo(lbDetailsPerson, 5).atLeftTo(insertarE, 30);
			
		Label lbDataLastUpdate = new Label(grupo, SWT.NORMAL);
		lbDataLastUpdate.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));
		FormDatas.attach(lbDataLastUpdate).atTopTo(grupo, 5).atLeftTo(lbDetailsPerson, 320);
			
		Table tabla2 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
			
		TableItem tableItem1 = new TableItem(tabla2, SWT.NONE);
		tableItem1.setText("Nombre y Apellido" );
			
		TableItem tableItem2 = new TableItem(tabla2, SWT.NONE);
		tableItem2.setText("Usuario");
					
		TableItem tableItem3 = new TableItem(tabla2, SWT.NONE);
		tableItem3.setText("Fecha");
			
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(125);
		columna11.setText("");
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
		columna22.setText("");
		FormDatas.attach(tabla2).atTopTo(lbDataLastUpdate, 5).atLeftTo(tabla, 30);
		
		Label lbUserLoanData = new Label(grupo, SWT.NORMAL);
		lbUserLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		FormDatas.attach(lbUserLoanData).atTopTo(tabla, 25).atLeftTo(grupo, 20);
			
		Table tabla3 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla3.setHeaderVisible(false);
		tabla3.setLinesVisible(true);
		
		TableColumn columna13 = new TableColumn(tabla3, SWT.NONE);
		columna13.setWidth(125);
		TableColumn columna23 = new TableColumn(tabla3, SWT.NONE);
		columna23.setWidth(125);
					
		TableItem tableItem13 = new TableItem(tabla3, SWT.NONE);
		tableItem13.setText(0,"Usuario");
		tableItem13.setText(1, entityLoanUser.getLoanUser());
			
		TableItem tableItem23 = new TableItem(tabla3, SWT.NONE);
		tableItem23.setText("Código");
		tableItem23.setText(1, entityLoanUser.getLoanUserCode());
					
		TableItem tableItem33 = new TableItem(tabla3, SWT.NONE);
		tableItem33.setText("Tipo de Usuario");
		tableItem33.setText(1, entityLoanUser.getLoanUserType().getNomeclatorName());
		
		TableItem tableItem43 = new TableItem(tabla3, SWT.NONE);
		tableItem43.setText("Estado");
		tableItem43.setText(1, entityLoanUser.getLoanUserState().name());
				
		TableItem tableItem53 = new TableItem(tabla3, SWT.NONE);
		tableItem53.setText("Fecha Registro");
		
		//tableItem53.setText(1, entityLoanUser.getRegistrationDate());
		
		FormDatas.attach(tabla3).atTopTo(lbUserLoanData, 5).atLeftTo(grupo, 20);
		 
		Label lbObservations = new Label(grupo, SWT.NORMAL);
		lbObservations.setText(AbosMessages.get().LABEL_OBSERVATIONS);
		FormDatas.attach(lbObservations).atTopTo(tabla, 25).atLeftTo(tabla3, 50);
		
		Text txtObservations = new Text(grupo, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtObservations.setText(entityLoanUser.getObservation());
		FormDatas.attach(txtObservations).atTopTo(lbObservations, 5).atLeftTo(tabla3, 40).withWidth(350).withHeight(80);
		txtObservations.setEnabled(false);
		
		//----------------------Current State
		
		TabItem tabItemCurrentState = new TabItem(tabFolder, SWT.None);
		tabItemCurrentState.setText(AbosMessages.get().LABEL_CURRENT_STATUS);
		
		
		Composite compoCurrentState = new Composite(tabFolder, SWT.NONE);
		compoCurrentState.setData(RWT.CUSTOM_VARIANT, "gray_background");
		compoCurrentState.setLayout(new FormLayout());
		tabItemCurrentState.setControl(compoCurrentState);
			
		//------------------TabFolder de adentro
		TabFolder tabFolderCurrentState = new TabFolder(compoCurrentState, SWT.NONE);
		FormDatas.attach(tabFolderCurrentState).atTopTo(parent, 5).atLeft(0).atRight(0).withHeight(200);
				
			
		//------------------tabItems Transacciones
		TabItem tabItemT = new TabItem(tabFolderCurrentState, SWT.None);
		tabItemT.setText(AbosMessages.get().LABEL_TRANSACTIONS);
		
		
		Composite grupo2 = new Composite(tabFolderCurrentState, SWT.None);
		grupo2.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo2.setLayout(new FormLayout());
		FormDatas.attach(grupo2).atLeft(0).atRight(0);
		
		tabItemT.setControl(grupo2);
		
		
		Label lbUserCurrentTransaction = new Label(grupo2, SWT.NONE);
		lbUserCurrentTransaction.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CURRENT_LOAN_TRANSACTIONS));
		FormDatas.attach(lbUserCurrentTransaction).atTopTo(grupo2, 15).atLeftTo(grupo2, 10);
		
				
		//------------------tabItems Reservaciones
		TabItem tabItemR = new TabItem(tabFolderCurrentState, SWT.None);
		tabItemR.setText(AbosMessages.get().LABEL_RESERVATIONS);
		
				
		Composite compoR = new Composite(tabFolderCurrentState, SWT.None);
		compoR.setData(RWT.CUSTOM_VARIANT, "gray_background");
		compoR.setLayout(new FormLayout());
		FormDatas.attach(compoR).atLeft(0).atRight(0);
		tabItemR.setControl(compoR);
		
		
		Label lbUserCurrentReservations = new Label(compoR, SWT.NONE);
		lbUserCurrentReservations.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CURRENT_LOAN_RESERVATIONS));
		FormDatas.attach(lbUserCurrentReservations).atTopTo(compoR, 15).atLeftTo(compoR, 10);
				
	
		//------------------tabItems Sanciones
		TabItem tabItemS = new TabItem(tabFolderCurrentState, SWT.None);
		tabItemS.setText(AbosMessages.get().LABEL_SANCTIONS);
		
				
		Composite compoS = new Composite(tabFolderCurrentState, SWT.None);
		compoS.setData(RWT.CUSTOM_VARIANT, "gray_background");
		compoS.setLayout(new FormLayout());
		FormDatas.attach(compoS).atLeft(0).atRight(0);
		tabItemS.setControl(compoS);
		
				
		Label lbUserCurrentSanctions = new Label(compoS, SWT.NONE);
		lbUserCurrentSanctions.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CURRENT_LOAN_SANCTIONS));
		FormDatas.attach(lbUserCurrentSanctions).atTopTo(compoS, 15).atLeftTo(compoS, 10);
				
		
		//--------------------Historial
		
		TabItem tabItemRecord = new TabItem(tabFolder, SWT.None);
		tabItemRecord.setText(AbosMessages.get().LABEL_RECORD);
		
		
		Composite compoRecord = new Composite(tabFolder, SWT.NONE);
		compoRecord.setData(RWT.CUSTOM_VARIANT, "gray_background");
		compoRecord.setLayout(new FormLayout());
		tabItemRecord.setControl(compoRecord);
			
		//------------------TabFolder de adentro
		TabFolder tabFolderRecord = new TabFolder(compoRecord, SWT.NONE);
		FormDatas.attach(tabFolderRecord).atTopTo(parent, 5).atLeft(0).atRight(0).withHeight(200);
				
			
		//------------------tabItems Transacciones
		TabItem tabItemTRecord = new TabItem(tabFolderRecord, SWT.None);
		tabItemTRecord.setText(AbosMessages.get().LABEL_TRANSACTIONS);
		
		
		Composite compoTR = new Composite(tabFolderRecord, SWT.None);
		compoTR.setData(RWT.CUSTOM_VARIANT, "gray_background");
		compoTR.setLayout(new FormLayout());
		FormDatas.attach(compoTR).atLeft(0).atRight(0);
		
		tabItemTRecord.setControl(compoTR);
		
		Label lbRecordTransaction = new Label(compoTR, SWT.NONE);
		lbRecordTransaction.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_HISTORICAL_LOAN_TRANSACTIONS));
		FormDatas.attach(lbRecordTransaction).atTopTo(compoTR, 15).atLeftTo(compoTR, 10);
		
				
		//------------------tabItems Reservaciones
		TabItem tabItemRRecord = new TabItem(tabFolderRecord, SWT.None);
		tabItemRRecord.setText(AbosMessages.get().LABEL_RESERVATIONS);
						
		Composite compoRRecord = new Composite(tabFolderRecord, SWT.None);
		compoRRecord.setData(RWT.CUSTOM_VARIANT, "gray_background");
		compoRRecord.setLayout(new FormLayout());
		FormDatas.attach(compoRRecord).atLeft(0).atRight(0);
		tabItemRRecord.setControl(compoRRecord);
		
		
		Label lbUserRecordReservations = new Label(compoRRecord, SWT.NONE);
		lbUserRecordReservations.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_HISTORICAL_LOAN_RESERVATIONS));
		FormDatas.attach(lbUserRecordReservations).atTopTo(compoRRecord, 15).atLeftTo(compoRRecord, 10);
				
	
		//------------------tabItems Sanciones
		TabItem tabItemSRecord = new TabItem(tabFolderRecord, SWT.None);
		tabItemSRecord.setText(AbosMessages.get().LABEL_SANCTIONS);
		
				
		Composite compoSRecord = new Composite(tabFolderRecord, SWT.None);
		compoSRecord.setData(RWT.CUSTOM_VARIANT, "gray_background");
		compoSRecord.setLayout(new FormLayout());
		FormDatas.attach(compoSRecord).atLeft(0).atRight(0);
		tabItemSRecord.setControl(compoSRecord);
		
				
		Label lbUserRecordSanctions = new Label(compoSRecord, SWT.NONE);
		lbUserRecordSanctions.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_HISTORICAL_LOAN_SANCTIONS));
		FormDatas.attach(lbUserRecordSanctions).atTopTo(compoSRecord, 15).atLeftTo(compoSRecord, 10);
		
		
		final CRUDTreeTable tableHistoricalPenalty = new CRUDTreeTable(compoSRecord, SWT.NONE);
	    FormDatas.attach(tableHistoricalPenalty).atTopTo(lbUserRecordSanctions, 10).atLeft(0).atRight(0);
	    			
	    tableHistoricalPenalty.setEntityClass(GridConsultSanction.class);	
		
	    tableHistoricalPenalty.setWatch(true, new ViewAreaPenalty(controller));
	   		
	    tableHistoricalPenalty.setCancelButtonText("Cancelar");     //For the internationalization. If it is non set, only the icon will show up.
					
		try {
			tableHistoricalPenalty.setColumnHeaders(Arrays.asList("Tipo de Sancion", "Fecha de Inicio","Fecha de Fin", "Observaciones","Estado"));
			tableHistoricalPenalty.createTable();	
		}
			catch(Exception e) {
				e.printStackTrace();
		}
		
		
		initializeGrid(tableHistoricalPenalty);
		
	//--------------------Botones Finales
		
		
		/*Button btnExportPDF = new Button(compoLoanUser, SWT.PUSH);
		Button btnExportExcel = new Button(compoLoanUser, SWT.PUSH);
		
		btnExportExcel.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		
		FormDatas.attach(btnExportPDF).atTopTo(tabFolder, 5).atRight(0);
		FormDatas.attach(btnExportExcel).atTopTo(tabFolder, 5).atRightTo(btnExportPDF,10);*/
		
		l10n();
		return parent;
	}
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Control getControl(String key) {
		return this.controls.get(key);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {
	
		return null;
	}
	

	  public void l10n() {
		
		tabItemLoanUSer.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		tbItemNameLastName.setText(AbosMessages.get().LABEL_NAME);
    	tbItemIdentification.setText(MessageUtil.unescape(AbosMessages.get().LABEL_IDENTIFICATION));
		tbItemAge.setText(AbosMessages.get().TABLE_AGE);
    	tbItemSex.setText(AbosMessages.get().TABLE_SEX);
	}

	  public int calcularEdad(String fecha) {
		  String datetext = fecha;
		  try {
		  Calendar birth = new GregorianCalendar();
		  Calendar today = new GregorianCalendar();
		  int age=0;
		  int factor=0;
		  Date birthDate=new SimpleDateFormat("dd-MM-yyyy").parse(datetext);
		  Date currentDate= new Date(); //current date
		  birth.setTime(birthDate);
		  today.setTime(currentDate);
		  if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
		  if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
		  if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
		  factor = -1; //Aun no celebra su cumpleaÃ±os
		  }
		  } else {
		  factor = -1; //Aun no celebra su cumpleaÃ±os
		  }
		  }
		  age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
		  return age;
		  } catch (ParseException e) {
		  return -1;
		  }

		  }
	  
	  public String formateaFecha(String vFecha){
		  String vDia, vMes, vAno;
		  StringTokenizer tokens = new StringTokenizer(vFecha,"-");
		  vAno = tokens.nextToken();
		  vMes = tokens.nextToken();
		  vDia = tokens.nextToken();
		   return vDia +"-"+vMes+"-"+ vAno;
		  }
	  
	  
	 private void initializeGrid(CRUDTreeTable table) {
	 	Long idLoanUser = entityLoanUser.getLoanUserID();	
		 
	 		Collection<Penalty> listPenalty = ((AllManagementLoanUserViewController) controller).getManagePenalty().findPenaltybyLoanUser(idLoanUser);
	 		
	 		for (Penalty aux : listPenalty) {
	 			
	 			GridConsultSanction penalty = new GridConsultSanction(aux.getPenaltyType(),
	 					 aux.getEffectiveDate(), aux.getExpirationDate(), aux.getReason(), aux.getPenaltyState(), aux.getLoanUser());
	 			penalty.setPenaltyID(aux.getPenaltyID());
	 			table.addRow(penalty);
	 		}
	 	}
	  

}
