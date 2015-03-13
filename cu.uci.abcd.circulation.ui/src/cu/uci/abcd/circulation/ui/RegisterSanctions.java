package cu.uci.abcd.circulation.ui;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.composite.AssociateLoanUser;
import cu.uci.abcd.circulation.ui.controller.AllManagementLoanUserViewController;
import cu.uci.abcd.circulation.ui.controller.PenaltyViewController;
import cu.uci.abcd.circulation.ui.listener.EventEditSanctionPerson;
import cu.uci.abcd.circulation.ui.model.GridConsultSanction;
import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abcd.domain.circulation.PenaltyState;
import cu.uci.abcd.domain.circulation.PenaltyType;
import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class RegisterSanctions implements IContributor {
	
	private IViewController controller;
	
	FormLayout form;
	Composite parent;
	TabFolder tabFolder;
	Composite otherDatas;
	Label lbDetailsPerson;
	Button associateButton;
	Label lab;
	Table generalDataTable;
	Button unAssociateButton;
	Label idPerson;
	Text txtUserCode;
	//-----------
	Label lbUserDate;
	Label lbUserLoanData;
    Label lbSanctionsDate;
	Label lbSanctionsType;
	Button rdbSuspencion;
	Button rdbFine;
	Label lbDateDesde;
	Label lbDataHasta;
	Label lbAmount;
	Label lbReason;
	Label lbMsjeSanction;
	Label lbUserCode;
	Button validar;
	Button btnDissociate;
	Text txt_monto;
	Combo comboCoin;
	DateTime fromDateTime;
	DateTime toDateTime;
	
	//----Tabla
	TableColumn generalDataColumn1;
	TableColumn generalDataColumn2;
	TableItem nameTableItem;
	TableItem userTableItem;
	TableItem codeTableItem;
	TableItem userTypeTableItem;
	TableItem stateTableItem;
	 
	@Override
	public String contributorName() {
		return MessageUtil.unescape(AbosMessages.get().NAME_UI_PENALTY);
	}
	@Override
	public String getID() {
		return "RegistrarSancionID";
	}	
	
	@Override
	public Control createUIControl(Composite shell) {
		form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
		
		parent= new Composite(shell, SWT.NORMAL);
		parent.setLayout(form);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
		
		tabFolder = new TabFolder(parent, SWT.NONE);
		tabFolder.setData(RWT.CUSTOM_VARIANT, "gray_background");
        FormDatas.attach(tabFolder).atTopTo(parent).atLeft(0).atRight(0);
        
        TabItem libraryTabItem = new TabItem(tabFolder, SWT.NONE);
		libraryTabItem.setText("Sancion");
		
		Composite group1 = new Composite(tabFolder, SWT.NONE);
		group1.setLayout(form);
		group1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		libraryTabItem.setControl(group1);
		FormDatas.attach(group1).atTopTo(tabFolder).atLeft(0).atRight(0);
		
		otherDatas = new Composite(group1, SWT.NORMAL);
		otherDatas.setLayout(form);
		otherDatas.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(otherDatas).atTopTo(group1, 10).atLeft(0).atRight(0);
		
		//child 0
		lbDetailsPerson = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbDetailsPerson).atTopTo(otherDatas, 5).atLeftTo(shell, 15);
				
		//child 1
		lbMsjeSanction = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbMsjeSanction).atTopTo(lbDetailsPerson, 5).atLeftTo(shell, 15);
		
		//child 2
		lbUserCode = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbUserCode).atTopTo(lbMsjeSanction,10).atLeftTo(otherDatas,15);
		
		//child 3
		txtUserCode = new Text(otherDatas, SWT.None);
		FormDatas.attach(txtUserCode).atTopTo(lbUserCode, 6).atLeftTo(otherDatas,15).withWidth(150);
		
		//child 4
		validar = new Button(otherDatas, SWT.NONE);
		FormDatas.attach(validar).atTopTo(lbUserCode, 6).atLeftTo(txtUserCode,10);
			
		//child 5
		associateButton = new Button(otherDatas, SWT.PUSH);
		associateButton.setText("...");
		FormDatas.attach(associateButton).atTopTo(lbUserCode, 6).atLeftTo(validar,10);
		
		//child 6
		lab = new Label(otherDatas, SWT.None);
	     lab.setData(RWT.MARKUP_ENABLED,Boolean.TRUE);
	     String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		  lab.setText("<img width='110' height='113' src='" +elemento+"'></img>");
		  lab.setVisible(false);
			  FormDatas.attach(lab).atTopTo(lbDetailsPerson, 2).atLeft(10);
			  
	    //child 7  
		generalDataTable = new Table(otherDatas, SWT.BORDER | SWT.FULL_SELECTION);
        generalDataTable.setHeaderVisible(false);
        generalDataTable.setLinesVisible(true);
        generalDataTable.setVisible(false);
                
        generalDataColumn1 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn1.setWidth(150);
        generalDataColumn2 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn2.setWidth(180);
                
        nameTableItem = new TableItem(generalDataTable, SWT.NONE);
        nameTableItem.setText(0,"Nombre");
        nameTableItem.setText(1, "");
        
        userTableItem = new TableItem(generalDataTable, SWT.NONE);
        userTableItem.setText("Usuario");
        userTableItem.setText(1, "");
                                
        codeTableItem = new TableItem(generalDataTable, SWT.NONE);
        codeTableItem.setText("Codigo");
        codeTableItem.setText(1, "");
        
        userTypeTableItem = new TableItem(generalDataTable, SWT.NONE);
        userTypeTableItem.setText("Tipo de Usuario");
        userTypeTableItem.setText(1, "");
        
        stateTableItem = new TableItem(generalDataTable, SWT.NONE);
        stateTableItem.setText("Estado");
        stateTableItem.setText(1, "");
        
        
        FormDatas.attach(generalDataTable).atLeftTo(lab, 0).atTopTo(lbDetailsPerson, 2);
        
        //child 8
        unAssociateButton = new Button(otherDatas, SWT.PUSH);
        unAssociateButton.setVisible(false);
		FormDatas.attach(unAssociateButton).atTopTo(generalDataTable, 10).atLeftTo(generalDataTable, 10);
        
		//child 9
		idPerson = new Label(otherDatas, SWT.NONE);
		idPerson.setVisible(false);
		FormDatas.attach(idPerson).atTopTo(unAssociateButton, 3);
		
		
		unAssociateButton.addSelectionListener(new SelectionAdapter() {
            
            private static final long serialVersionUID = 1L;
            @Override
            public void widgetSelected(SelectionEvent e) {
            	lbMsjeSanction.setVisible(true);
            	associateButton.setVisible(true);
            	lbUserCode.setVisible(true);
            	txtUserCode.setVisible(true);
            	validar.setVisible(true);
				   
            	lab.setVisible(false);
            	generalDataTable.setVisible(false);
            	unAssociateButton.setVisible(false);
            }

    });        
		associateButton.addListener(SWT.Selection, new Listener() {
		private static final long serialVersionUID = 1L;

			@Override
			public void handleEvent(Event arg0) {
				if(tabFolder.getItemCount()==1){
				TabItem tabItemR = new TabItem(tabFolder, SWT.None);
				tabItemR.setText(AbosMessages.get().LABEL_DETAILS_OF_THE_PERSON);
					
				Composite compoR = new AssociateLoanUser(controller,otherDatas,tabFolder).createUIControl(tabFolder);
				tabItemR.setControl(compoR);
				FormDatas.attach(compoR).atLeft(0).atRight(0).atTopTo(tabFolder, 10);
				}
				tabFolder.setSelection(1);
			
			}
				
		});
		
		validar.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                                     
             String userCode = txtUserCode.getText();
                    
             LoanUser loanUserCode = ((AllManagementLoanUserViewController) controller).getManageLoanUser().findByLoanUserCode(userCode);
            
             
             lbMsjeSanction.setVisible(false);
             lbUserCode.setVisible(false);
             txtUserCode.setVisible(false);
             validar.setVisible(false);
             associateButton.setVisible(false);
             
             lbDetailsPerson.setVisible(true);
             generalDataTable.setVisible(true);
             lab.setVisible(true);
                        
                          
            nameTableItem.setText(1, loanUserCode.getLoanUser().toString());
                        
            
             userTableItem.setText(1, loanUserCode.getLoanUser());
                                                 
             
             codeTableItem.setText(1, loanUserCode.getLoanUserCode());
                         
      
             userTypeTableItem.setText(1, loanUserCode.getLoanUserType().getNomeclatorName());
             
             idPerson.setText(loanUserCode.getLoanUserID().toString());
          
            // stateTableItem.setText(1, loanUserCode.getLoanUserState().toString());
             
                       
            //btnDissociate.setVisible(true);
            }

    });

				
		//----------------------------------------------------------------------		
		Label separador = new Label(otherDatas, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(unAssociateButton, 5).atLeft(0).atRight(0);
		

		lbSanctionsDate = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbSanctionsDate).atTopTo(separador, 15).atLeftTo(parent, 15);
		
		lbSanctionsType = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbSanctionsType).atTopTo(lbSanctionsDate, 15).atLeftTo(parent, 15);
		
		rdbSuspencion = new Button(otherDatas, SWT.RADIO);
		FormDatas.attach(rdbSuspencion).atTopTo(lbSanctionsType,10).atLeft(0,15);

		rdbFine = new Button(otherDatas, SWT.RADIO);
		FormDatas.attach(rdbFine).atTopTo(lbSanctionsType,10).atLeftTo(rdbSuspencion, 10);

		lbDateDesde = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbDateDesde).atTopTo(rdbSuspencion,10).atLeftTo(otherDatas, 15);

		lbDataHasta = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbDataHasta).atTopTo(rdbSuspencion,10).atLeftTo(lbDateDesde, 130);

		fromDateTime= new DateTime(otherDatas, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(fromDateTime).atTopTo(lbDateDesde,5).atLeft(15).withWidth(150);
				
		toDateTime= new DateTime(otherDatas, SWT.BORDER | SWT.DROP_DOWN);
		FormDatas.attach(toDateTime).atTopTo(lbDataHasta, 5).atLeftTo(fromDateTime,15).withWidth(150);

		//------- Aparece si es seleccionado multa---------
		Composite composite = new Composite(otherDatas, SWT.NONE);
		composite.setLayout(new FormLayout());
		FormDatas.attach(composite).atTopTo(rdbSuspencion,10).atLeftTo(lbDataHasta, 130);
		composite.setData(RWT.CUSTOM_VARIANT, "gray_background");
		composite.setVisible(false);

		lbAmount = new Label(composite, SWT.NONE);
		FormDatas.attach(lbAmount).atTopTo(composite,1).atLeftTo(composite, 1);

		txt_monto = new Text(composite,SWT.NONE);
		FormDatas.attach(txt_monto).atTopTo(lbAmount,5).atLeftTo(composite, 1).withWidth(150);

		comboCoin = new Combo(composite, SWT.NONE);
		initializeCombo();
		FormDatas.attach(comboCoin).atTopTo(lbAmount,5).atLeftTo(txt_monto, 5).withWidth(90);

		rdbFine.addListener(SWT.Selection, new EventEditSanctionPerson(composite,rdbFine));

		//----------------------------------------------------------------------------
		lbReason = new Label(otherDatas, SWT.NONE);
		FormDatas.attach(lbReason).atTopTo(fromDateTime,10).atLeft(15);

		final Text listlbReason = new Text(otherDatas, SWT.V_SCROLL | SWT.WRAP);
		FormDatas.attach(listlbReason).atTopTo(lbReason,10).atLeft(15).withHeight(50).withWidth(600);
        
		
		Button saveBtn = new Button(otherDatas, SWT.PUSH);
		saveBtn.setText("Registrar");
		FormDatas.attach(saveBtn).atTopTo(listlbReason, 15).atLeftTo(listlbReason, 10);
		
		saveBtn.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {
			
				Long idLoanUser = Long.parseLong(idPerson.getText());
				Penalty penalty;
				LoanUser loanUser = new LoanUser();
				loanUser = ((AllManagementLoanUserViewController) controller).getManageLoanUser().findOneLoanUser(idLoanUser);
				
				int fromYear = fromDateTime.getYear();
				int fromMonth = fromDateTime.getMonth();
				int fromDay = fromDateTime.getDay();
				Date startDate = new Date(fromYear, fromMonth, fromDay);

				int toYear = toDateTime.getYear();
				int toMonth = toDateTime.getMonth();
				int toDay = toDateTime.getDay();

				Date endDate = new Date(toYear, toMonth, toDay);
				
			if (rdbSuspencion.getSelection() == true) {
			
				PenaltyType type = PenaltyType.SUSPENSION;
				PenaltyState state = PenaltyState.PENDING;
				String reason = listlbReason.getText();
				
					
				penalty = new GridConsultSanction(type, startDate, endDate, reason, state, loanUser);
				
				Penalty auxPenalty = new Penalty();
				auxPenalty.setPenaltyType(penalty.getPenaltyType());
				auxPenalty.setEffectiveDate(penalty.getEffectiveDate());
				auxPenalty.setExpirationDate(penalty.getExpirationDate());
				auxPenalty.setReason(penalty.getReason());
				auxPenalty.setPenaltyState(penalty.getPenaltyState());
				auxPenalty.setLoanUser(penalty.getLoanUser());
								
				((AllManagementLoanUserViewController) controller).getManagePenalty().addPenalty(auxPenalty);
				
			}
			else {
				
				PenaltyType penaltyType = PenaltyType.PENALTY;
				PenaltyState penaltyState = PenaltyState.PENDING;
				
				String reason = listlbReason.getText();
							
				BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(txt_monto.getText()));
				
				
				penalty = new GridConsultSanction(penaltyType,startDate, endDate,reason,
						penaltyState, amount);
				
				Penalty auxPenalty = new Penalty();
				auxPenalty.setPenaltyType(penalty.getPenaltyType());
				auxPenalty.setEffectiveDate(penalty.getEffectiveDate());
				auxPenalty.setExpirationDate(penalty.getExpirationDate());
				auxPenalty.setReason(penalty.getReason());
				auxPenalty.setPenaltyState(penalty.getPenaltyState());
				auxPenalty.setAmount(penalty.getAmount());
				
				((AllManagementLoanUserViewController) controller).getManagePenalty().addPenalty(auxPenalty);
							
			}							
				// clean the controls
				txt_monto.setText("");
				listlbReason.setText("");
			}

		});
		
		
		l10n();
		return shell;
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		lbSanctionsDate.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_SANCTION));
		lbSanctionsType.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_SANCTION));
		rdbSuspencion.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SUSPENCION));
		rdbFine.setText(AbosMessages.get().LABEL_FINE);
		lbDateDesde.setText(AbosMessages.get().LABEL_FROM);
		lbDataHasta.setText(AbosMessages.get().LABEL_UP);
		lbAmount.setText(AbosMessages.get().LABEL_AMOUNT);
		lbReason.setText(AbosMessages.get().LABEL_REASON);
		lbMsjeSanction.setText(MessageUtil.unescape(AbosMessages.get().LABEL_MESSAGE_SANCION));
		lbUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		validar.setText(AbosMessages.get().BUTTON_VALIDATE);
		unAssociateButton.setText(AbosMessages.get().BUTTON_DISSOCIATE);
		lbDetailsPerson.setText(AbosMessages.get().LABEL_DETAILS_OF_THE_PERSON);
		
	}
	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
		
	}
	
    private void initializeCombo() {
		
	    List<Coin> listCoin = ((AllManagementLoanUserViewController) controller).getManagePenalty().findAllCoin();
	    
		String [] comboStrings = new String[listCoin.size()];
		List<Coin> coin = new LinkedList<Coin>();
		for (int i = 0; i < listCoin.size(); i++) {
			
			coin.add(listCoin.get(i));
			comboStrings[i] = listCoin.get(i).getNomenclatorDescription();
			
		}
		comboCoin.setData(coin);
		comboCoin.setItems(comboStrings);

	}

	
}
