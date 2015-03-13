package cu.uci.abcd.circulation.ui.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.controller.PenaltyViewController;
import cu.uci.abcd.circulation.ui.listener.EventEditSanctionPerson;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class EditorAreaConsultSanction implements IEditableArea{
  	
   private Map<String, Control> controls;
	private IViewController controller;
	
	Label lbUserDate;
    Label lbSanctionsDate;
	Label lbSanctionsType;
	Button rdbSuspencion;
	Button rdbFine;
	Label lbDateDesde;
	Label lbDataHasta;
	Label lbAmount;
	Label lbReason;
	DateTime fromDateTime;
	DateTime toDateTime;
		
	TableItem tbItemName;
	TableItem tbItemUser;
	TableItem tbItemUserCode;
	TableItem tbItemUserType;
	TableItem tbItemState;

	public EditorAreaConsultSanction(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite parent, IGridViewEntity entity,IVisualEntityManager manager) {
	
		GridConsultSanction entityPenalty = (GridConsultSanction)entity;
		
	    parent.setLayout(new FormLayout());
        FormDatas.attach(parent).atLeft(0).atRight(0);
        parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
					
		lbUserDate = new Label(parent, SWT.NONE);
		FormDatas.attach(lbUserDate).atTopTo(parent, 10).atLeftTo(parent, 10);
		
		Label user = new Label(parent, SWT.NONE);
		user.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		user.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		
		FormDatas.attach(user).atTopTo(lbUserDate, 10).atLeftTo(parent, 15);
		
		Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);
		
		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(125);
		
		tbItemName = new TableItem(tabla, SWT.NONE);
		tbItemUser = new TableItem(tabla, SWT.NONE);
		tbItemUserCode = new TableItem(tabla, SWT.NONE);
		tbItemUserType = new TableItem(tabla, SWT.NONE);
		tbItemState = new TableItem(tabla, SWT.NONE);

		FormDatas.attach(tabla).atTopTo(lbUserDate, 10).atLeftTo(user, 15);			
		//----------------------------------------------------------------------		
		Label separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(tabla,15).atLeft(0).atRight(0);
		

		lbSanctionsDate = new Label(parent, SWT.NONE);
		FormDatas.attach(lbSanctionsDate).atTopTo(separador, 15).atLeftTo(parent, 15);
		
		lbSanctionsType = new Label(parent, SWT.NONE);
		FormDatas.attach(lbSanctionsType).atTopTo(lbSanctionsDate, 15).atLeftTo(parent, 15);
		
		rdbSuspencion = new Button(parent, SWT.RADIO);
		FormDatas.attach(rdbSuspencion).atTopTo(lbSanctionsType,10).atLeft(0,15);

		rdbFine = new Button(parent, SWT.RADIO);
		FormDatas.attach(rdbFine).atTopTo(lbSanctionsType,10).atLeftTo(rdbSuspencion, 10);

		lbDateDesde = new Label(parent, SWT.NONE);
		FormDatas.attach(lbDateDesde).atTopTo(rdbSuspencion,10).atLeftTo(parent, 15);

		lbDataHasta = new Label(parent, SWT.NONE);
		FormDatas.attach(lbDataHasta).atTopTo(rdbSuspencion,10).atLeftTo(lbDateDesde, 130);

		fromDateTime= new DateTime(parent, SWT.BORDER | SWT.DROP_DOWN);
		int fromYear = entityPenalty.getEffectiveDate().getYear();
		int fromMonth = entityPenalty.getEffectiveDate().getMonth();
		int fromDay = entityPenalty.getEffectiveDate().getDay();
		Date startDate = new Date(fromYear, fromMonth, fromDay);
 
		fromDateTime.setDate(fromYear, fromMonth, fromDay);
		FormDatas.attach(fromDateTime).atTopTo(lbDateDesde,5).atLeft(15).withWidth(150);
		
		
		DateTime toDateTime= new DateTime(parent, SWT.BORDER | SWT.DROP_DOWN);
		
		int toYear = entityPenalty.getExpirationDate().getYear();
		int toMonth = entityPenalty.getExpirationDate().getMonth();
		int toDay = entityPenalty.getExpirationDate().getDay();

		Date endDate = new Date(toYear, toMonth, toDay);
		
		toDateTime.setDate(toYear, toMonth, toDay);		
		FormDatas.attach(toDateTime).atTopTo(lbDataHasta, 5).atLeftTo(fromDateTime,15).withWidth(150);

		//------- Aparece si es seleccionado multa---------
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FormLayout());
		FormDatas.attach(composite).atTopTo(rdbSuspencion,10).atLeftTo(lbDataHasta, 130);
		composite.setData(RWT.CUSTOM_VARIANT, "gray_background");
		composite.setVisible(false);

		lbAmount = new Label(composite, SWT.NONE);
		FormDatas.attach(lbAmount).atTopTo(composite,1).atLeftTo(composite, 1);

		Text txt_monto = new Text(composite,SWT.NONE);
		FormDatas.attach(txt_monto).atTopTo(lbAmount,5).atLeftTo(composite, 1).withWidth(150);

		Combo comb = new Combo(composite, SWT.NONE);
		comb.setItems(new String[] { "CUP", "CUC"});
		FormDatas.attach(comb).atTopTo(lbAmount,5).atLeftTo(txt_monto, 5).withWidth(90);

		rdbFine.addListener(SWT.Selection, new EventEditSanctionPerson(composite,rdbFine));

		//----------------------------------------------------------------------------
		lbReason = new Label(parent, SWT.NONE);
		FormDatas.attach(lbReason).atTopTo(fromDateTime,10).atLeft(15);

		Text listlbReason = new Text(parent, SWT.V_SCROLL | SWT.WRAP);
		listlbReason.setText(entityPenalty.getReason());
		this.controls.put("listlbReason", listlbReason);
		FormDatas.attach(listlbReason).atTopTo(lbReason,10).atLeft(15).withHeight(50).withWidth(600);

		l10n();
						
		this.controls.put("txt_monto", txt_monto);
		this.controls.put("fromDateTime", fromDateTime);
		this.controls.put("toDateTime", toDateTime);
		this.controls.put("listlbReason", listlbReason);
		this.controls.put("comb", comb);
		
		return parent;
	}

	@Override
	public Composite createButtons(Composite parent, final IGridViewEntity entity,
			IVisualEntityManager manager) {
		
		Button updateBtn = new Button(parent, SWT.PUSH);
		updateBtn.setText("Actualizar");
		
		updateBtn.addSelectionListener(new SelectionListener() {
			
     		private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent arg0) {
			
						
			GridConsultSanction fdtEntity = (GridConsultSanction) entity;
			
			/*fdtEntity.setLoanUser(((Text)controls.get("txtUser")).getText());
			fdtEntity.setObservation(((Text)controls.get("txtObservation")).getText());
			fdtEntity.setLoanUserType(loanUserType);
			fdtEntity.setLoanUserCode(((Text)controls.get("txtUserCode")).getText());
			fdtEntity.setInactiveStateObservation(((Text)controls.get("txtJustification")).getText());
			fdtEntity.setLoanUserID(fdtEntity.getLoanUserID());
																
			Penalty auxPenalty = new Penalty();
			auxLoanUser.setLoanUser(fdtEntity.getLoanUser());
			auxLoanUser.setObservation(fdtEntity.getObservation());
			auxLoanUser.setLoanUserType(fdtEntity.getLoanUserType());
			auxLoanUser.setLoanUserCode(fdtEntity.getLoanUserCode());
			auxLoanUser.setInactiveStateObservation(fdtEntity.getInactiveStateObservation());
			auxLoanUser.setLoanUserID(fdtEntity.getLoanUserID());
						
			
			((PenaltyViewController) controller).addPenalty(auxPenalty);
			 manager.save(fdtEntity);*/
		
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
		
		return parent;
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
	public void l10n() {
		lbSanctionsDate.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_SANCTION));
		lbSanctionsType.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TYPE_OF_SANCTION));
		rdbSuspencion.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SUSPENCION));
		rdbFine.setText(AbosMessages.get().LABEL_FINE);
		lbDateDesde.setText(AbosMessages.get().LABEL_FROM);
		lbDataHasta.setText(AbosMessages.get().LABEL_UP);
		lbAmount.setText(AbosMessages.get().LABEL_AMOUNT);
		lbReason.setText(AbosMessages.get().LABEL_REASON);
		lbUserDate.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		
		tbItemName.setText(AbosMessages.get().LABEL_NAME);
		tbItemUser.setText(AbosMessages.get().LABEL_USER);
		tbItemUserCode.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_CODE));
		tbItemUserType.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
		tbItemState.setText(AbosMessages.get().LABEL_STATE);
	}
	
}
