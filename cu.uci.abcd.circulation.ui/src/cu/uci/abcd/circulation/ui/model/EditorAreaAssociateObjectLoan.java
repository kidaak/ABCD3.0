package cu.uci.abcd.circulation.ui.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class EditorAreaAssociateObjectLoan implements IEditableArea{
  	
   private Map<String, Control> controls;
	
	public EditorAreaAssociateObjectLoan() {
		this.controls = new HashMap<String, Control>();
	}
	
	@Override
	public Composite createUI(Composite parent, IGridViewEntity entity,IVisualEntityManager manager) {
		ObjectLoanView fdtEntity = (ObjectLoanView)entity;
		
		FormLayout form = new FormLayout();
		parent.setLayout(form);
		Composite topGroup= new Composite(parent, SWT.NORMAL);
		topGroup.setLayout(form);
		FormDatas.attach(topGroup).atLeftTo(parent, 5);
		
		Label lbUserLoanData = new Label(topGroup, SWT.NONE);
		lbUserLoanData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		FormDatas.attach(lbUserLoanData).atTopTo(topGroup, 5);
		
		Label lbDataLastUpdate = new Label(topGroup, SWT.NORMAL);
		lbDataLastUpdate.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));
		FormDatas.attach(lbDataLastUpdate).atTopTo(topGroup, 5).atLeftTo(lbUserLoanData, 130);
		
		Table tabla = new Table(topGroup, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);
			
		TableItem tableItem_1 = new TableItem(tabla, SWT.NORMAL);
		tableItem_1.setText("Título");
		
		TableItem tableItem = new TableItem(tabla, SWT.END);
		tableItem.setText("Autor");
					
		TableItem tableItem_2 = new TableItem(tabla, SWT.NONE);
		tableItem_2.setText("Volumen");
			
		TableItem tableItem_3 = new TableItem(tabla, SWT.NONE);
		tableItem_3.setText("Tomo");

		TableItem tableItem_4 = new TableItem(tabla, SWT.NONE);
		tableItem_4.setText("No. Control");
		
		TableItem tableItem_5 = new TableItem(tabla, SWT.NONE);
		tableItem_5.setText("Tipo de Objeto");
		
		TableItem tableItem_6 = new TableItem(tabla, SWT.NONE);
		tableItem_6.setText("Estado");
		
		TableItem tableItem_7 = new TableItem(tabla, SWT.NONE);
		tableItem_7.setText("Ubicación");
		
		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		columna1.setText("");
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(125);
		columna2.setText("");
			
		FormDatas.attach(tabla).atTopTo(lbUserLoanData, 5);
			
		//------------------------------tabla 2
		Table tabla2 = new Table(topGroup, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
					
		TableItem tableItem1 = new TableItem(tabla2, SWT.NONE);
		tableItem1.setText("Nombre y Apellido");
			
		TableItem tableItem2 = new TableItem(tabla2, SWT.NONE);
		tableItem2.setText("Usuario");
							
		TableItem tableItem3 = new TableItem(tabla2, SWT.NONE);
		tableItem3.setText("Fecha y Hora");
					
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(140);
		columna11.setText("");
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
		columna22.setText("");	
		
		FormDatas.attach(tabla2).atTopTo(lbDataLastUpdate, 5).atLeftTo(tabla, 30);
		
		Label lbObservations = new Label(topGroup, SWT.NORMAL);
		lbObservations.setText(AbosMessages.get().LABEL_OBSERVATIONS);
		FormDatas.attach(lbObservations).atTopTo(tabla, 5);
		
		Text txtObservations = new Text(topGroup, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(txtObservations).atTopTo(lbObservations, 5).withWidth(600).withHeight(50);
		
		Button btnCurrentStatus = new Button(topGroup, SWT.PUSH);
		Button btnHistory = new Button(topGroup, SWT.PUSH);
		Button btnLossRegister = new Button(topGroup, SWT.PUSH);
		Button btnClose = new Button(topGroup, SWT.PUSH);
		
		btnCurrentStatus.setText(AbosMessages.get().BUTTON_CURRENT_STATUS);
		btnHistory.setText(AbosMessages.get().BUTTON_HISTORY);
		btnLossRegister.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_LOSS_REGISTER));
		btnClose.setText(AbosMessages.get().BUTTON_CLOSE);

		FormDatas.attach(btnCurrentStatus).atTopTo(txtObservations, 5).atLeftTo(topGroup,155);
		FormDatas.attach(btnHistory).atTopTo(txtObservations, 5).atLeftTo(btnCurrentStatus,20);
		FormDatas.attach(btnLossRegister).atTopTo(txtObservations, 5).atLeftTo(btnHistory,20);
		FormDatas.attach(btnClose).atTopTo(txtObservations, 5).atLeftTo(btnLossRegister,20);
		
		return parent;
	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {
		
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

}
