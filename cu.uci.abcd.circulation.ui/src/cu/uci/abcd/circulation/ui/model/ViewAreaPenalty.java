package cu.uci.abcd.circulation.ui.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class ViewAreaPenalty implements IEditableArea{

	private Map<String, Control> controls;
	private IViewController controller;
	
	TabItem tabItemLoanUSer;

	public ViewAreaPenalty(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite parent, IGridViewEntity entity,IVisualEntityManager manager) {
	
        parent.setLayout(new FormLayout());
        FormDatas.attach(parent).atRight(0).atLeft(0);
    	parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
    	GridConsultSanction entityPenalty = (GridConsultSanction)entity;
		
		Label lbUserData = new Label(parent, SWT.NONE);
		lbUserData.setText(MessageUtil.unescape(AbosMessages.get().LABEL_USER_LOAN_DATA));
		FormDatas.attach(lbUserData).atTopTo(parent, 15).atLeftTo(parent, 15);
		
		Label insertarE = new Label(parent, SWT.NONE);
		insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		
		FormDatas.attach(insertarE).atTopTo(lbUserData, 15).atLeftTo(parent, 15);
		
		Table tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);
		
		TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		tableItem_1.setText("Nombre");
			
		TableItem tableItem = new TableItem(tabla, SWT.NONE);
		tableItem.setText("Usuario");
					
		TableItem tableItem_2 = new TableItem(tabla, SWT.NONE);
		tableItem_2.setText("Código");
			
		TableItem tableItem_3 = new TableItem(tabla, SWT.NONE);
		tableItem_3.setText("Tipo de Usuarios");
		
		TableItem tableItem_4 = new TableItem(tabla, SWT.NONE);
		tableItem_4.setText("Estado");
			
		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		columna1.setText("");
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(125);
		columna2.setText("");
		
		FormDatas.attach(tabla).atTopTo(lbUserData, 5).atLeftTo(insertarE, 15);
			
		Label label2 = new Label(parent, SWT.NORMAL);
		label2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));
		FormDatas.attach(label2).atTopTo(parent, 15).atLeftTo(lbUserData, 230);
			
		Table tabla2 = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
		
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(125);
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
					
		TableItem tableItem1 = new TableItem(tabla2, SWT.NONE);
		tableItem1.setText("Nombre" );
			
		TableItem tableItem2 = new TableItem(tabla2, SWT.NONE);
		tableItem2.setText("Usuario");
					
		TableItem tableItem3 = new TableItem(tabla2, SWT.NONE);
		tableItem3.setText("Fecha");
		FormDatas.attach(tabla2).atTopTo(label2, 5).atLeftTo(tabla, 30);
		
		Label label3 = new Label(parent, SWT.NORMAL);
		label3.setText(AbosMessages.get().LABEL_DATA_SANCTION);
		FormDatas.attach(label3).atTopTo(tabla, 25).atLeftTo(parent, 15);
			
		Table tabla3 = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla3.setHeaderVisible(false);
		tabla3.setLinesVisible(true);
		
		TableColumn columna13 = new TableColumn(tabla3, SWT.NONE);
		columna13.setWidth(125);
		TableColumn columna23 = new TableColumn(tabla3, SWT.NONE);
		columna23.setWidth(125);
				
		TableItem tableItem13 = new TableItem(tabla3, SWT.NONE);
		tableItem13.setText( "Tipo de Sanción" );
			
		TableItem tableItem23 = new TableItem(tabla3, SWT.NONE);
		tableItem23.setText("Código");
					
		TableItem tableItem33 = new TableItem(tabla3, SWT.NONE);
		tableItem33.setText("Tipo de Usiario");
		
		TableItem tableItem43 = new TableItem(tabla3, SWT.NONE);
		tableItem43.setText("Fecha");
				
		TableItem tableItem53 = new TableItem(tabla3, SWT.NONE);
		tableItem53.setText("Duración");
		
		TableItem tableItem63 = new TableItem(tabla3, SWT.NONE);
		tableItem63.setText("Monto");
		
		TableItem tableItem73 = new TableItem(tabla3, SWT.NONE);
		tableItem73.setText("Estado");
			
		FormDatas.attach(tabla3).atTopTo(label3, 5).atLeftTo(parent, 15);
		
		Label label4 = new Label(parent, SWT.NORMAL);
		label4.setText(AbosMessages.get().LABEL_OBJECT_DATE_ASOCCIATED_LOAN);
		FormDatas.attach(label4).atTopTo(tabla, 25).atLeftTo(label3, 320);
			
		Table tabla4 = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tabla4.setHeaderVisible(false);
		tabla4.setLinesVisible(true);
				
		TableColumn columna14 = new TableColumn(tabla4, SWT.NONE);
		columna14.setWidth(125);
		TableColumn columna24 = new TableColumn(tabla4, SWT.NONE);
		columna24.setWidth(125);
			
		TableItem tableItem14 = new TableItem(tabla4, SWT.NONE);
		tableItem14.setText( "Título" );
			
		TableItem tableItem24 = new TableItem(tabla4, SWT.NONE);
		tableItem24.setText("Autor");
					
		TableItem tableItem34 = new TableItem(tabla4, SWT.NONE);
		tableItem34.setText("No.Control");
		
		TableItem tableItem44 = new TableItem(tabla4, SWT.NONE);
		tableItem44.setText("Tipo de Objeto");
				
		TableItem tableItem54 = new TableItem(tabla4, SWT.NONE);
		tableItem54.setText("Estado");
		
		FormDatas.attach(tabla4).atTopTo(label4, 5).atLeftTo(lbUserData, 240);
		 
		Label labReason= new Label(parent, SWT.NORMAL);
		labReason.setText("Motivos");
		FormDatas.attach(labReason).atTopTo(tabla3, 10).atLeftTo(parent, 15);	
		
		Text txtReason = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(txtReason).atTopTo(labReason, 5).withWidth(600).withHeight(50).atLeftTo(parent, 15);
				
	
		Button btnClose = new Button(parent, SWT.PUSH);
		Button btnExportExcel = new Button(parent, SWT.PUSH);
		Button btnExportPDF = new Button(parent, SWT.PUSH);
	
		btnClose.setText(AbosMessages.get().BUTTON_CLOSE);
		btnExportExcel.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
	
		FormDatas.attach(btnClose).atTopTo(txtReason, 5).atRight(0);
		FormDatas.attach(btnExportExcel).atTopTo(txtReason, 5).atRightTo(btnClose, 20);
		FormDatas.attach(btnExportPDF).atTopTo(txtReason, 5).atRightTo(btnExportExcel,20);
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
	


}
