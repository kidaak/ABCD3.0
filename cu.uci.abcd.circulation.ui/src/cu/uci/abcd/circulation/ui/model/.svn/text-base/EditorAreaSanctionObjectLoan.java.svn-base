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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
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

public class EditorAreaSanctionObjectLoan implements IEditableArea{

	/*User Loan Data*/
	TableItem tbItemName;
	TableItem tbItemUser;
	TableItem tbItemUserCode;
	TableItem tbItemUserType;
	TableItem tbItemState;
	/*Object Loan Data*/
	TableItem tbItemTitle;
	TableItem tbItemAuthor;
	TableItem tbItemControlNumber;
	TableItem tbItemObjectType;
	TableItem tbItemStateObject;
	/*Sanctions Data*/
	TableItem tbItemSanctionsType;
	TableItem tbItemDateSanction;
	TableItem tbItemDuration;
	TableItem tbItemAcount;
	TableItem tbItemStateSanction;
	/*Last Update*/
	TableItem tbItemNameLast;
	TableItem tbItemUser1;
	TableItem tbItemDate;
	
	private Map<String, Control> controls;
	private IViewController controller;
	
	public EditorAreaSanctionObjectLoan(IViewController controller) {
		controls = new HashMap<String, Control>();
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite parent, IGridViewEntity entity,IVisualEntityManager manager) {
		ObjectLoanView fdtEntity = (ObjectLoanView)entity;
		
		FormLayout form = new FormLayout();
		parent.setLayout(form);
		Composite grupo= new Composite(parent, SWT.NORMAL);
		grupo.setLayout(form);
		FormDatas.attach(grupo).atLeftTo(parent, 5);
		
		//Ver
		Label lbDetailsPerson = new Label(grupo, SWT.NONE);
		lbDetailsPerson.setText(AbosMessages.get().LABEL_DETAILS_OF_THE_PERSON);
		FormDatas.attach(lbDetailsPerson).atTopTo(grupo, 5);
		
		Label insertarE = new Label(grupo, SWT.NONE);
		insertarE.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		String elemento = RWT.getResourceManager().getLocation("administracion/user.png");
		insertarE.setText("<img width='110' height='110' src='" +elemento+"'></img>");
		FormDatas.attach(insertarE).atTopTo(lbDetailsPerson, 5);
		
		
		Table tabla = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);
		
		tbItemName = new TableItem(tabla, SWT.NONE);
		tbItemUser = new TableItem(tabla, SWT.NONE);
		tbItemUserCode = new TableItem(tabla, SWT.NONE);
		tbItemUserType = new TableItem(tabla, SWT.NONE);
		tbItemState = new TableItem(tabla, SWT.NONE);
			
		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		columna1.setText("");
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(125);
		columna2.setText("");
		
		FormDatas.attach(tabla).atTopTo(lbDetailsPerson, 5).atLeftTo(insertarE, 30);
			
		Label lbDataLastUpdate = new Label(grupo, SWT.NORMAL);
		lbDataLastUpdate.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));
		FormDatas.attach(lbDataLastUpdate).atTopTo(grupo, 5).atLeftTo(lbDetailsPerson, 240);
			
		Table tabla2 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
			
		tbItemNameLast = new TableItem(tabla2, SWT.NONE);
		tbItemNameLast.setText("Nombre" );
			
		tbItemUser1 = new TableItem(tabla2, SWT.NONE);
		tbItemUser1.setText("Usuario");
					
		tbItemDate = new TableItem(tabla2, SWT.NONE);
		tbItemDate.setText("Fecha");
			
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(125);
		columna11.setText("");
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
		columna22.setText("");
		FormDatas.attach(tabla2).atTopTo(lbDataLastUpdate, 5).atLeftTo(tabla, 30);
		
		Label lbSanctionsData = new Label(grupo, SWT.NORMAL);
		lbSanctionsData.setText(AbosMessages.get().LABEL_DATA_SANCTION);
		FormDatas.attach(lbSanctionsData).atTopTo(tabla, 25);
			
		Table tabla3 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla3.setHeaderVisible(false);
		tabla3.setLinesVisible(true);
				
		tbItemSanctionsType = new TableItem(tabla3, SWT.NONE);
		tbItemSanctionsType.setText( "Tipo de Sanción" );
			
		tbItemDateSanction = new TableItem(tabla3, SWT.NONE);
		tbItemDateSanction.setText("Fecha");
				
		tbItemDuration = new TableItem(tabla3, SWT.NONE);
		tbItemDuration.setText("Duración");
		
		tbItemAcount = new TableItem(tabla3, SWT.NONE);
		tbItemAcount.setText("Monto");
		
		tbItemStateSanction = new TableItem(tabla3, SWT.NONE);
		tbItemStateSanction.setText("Estado");
			
		TableColumn columna13 = new TableColumn(tabla3, SWT.NONE);
		columna13.setWidth(125);
		columna13.setText("");
		TableColumn columna23 = new TableColumn(tabla3, SWT.NONE);
		columna23.setWidth(125);
		columna23.setText("");
		
		FormDatas.attach(tabla3).atTopTo(lbSanctionsData, 5);
		
		Label lbObjectLoanData = new Label(grupo, SWT.NORMAL);
		lbObjectLoanData.setText(AbosMessages.get().LABEL_OBJECT_DATE_ASOCCIATED_LOAN);
		FormDatas.attach(lbObjectLoanData).atTopTo(tabla, 25).atLeftTo(lbSanctionsData, 320);
			
		Table tabla4 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla4.setHeaderVisible(false);
		tabla4.setLinesVisible(true);
				
		tbItemTitle = new TableItem(tabla2, SWT.NONE);
		tbItemAuthor = new TableItem(tabla2, SWT.NONE);
		tbItemControlNumber = new TableItem(tabla2, SWT.NONE);
		tbItemObjectType = new TableItem(tabla2, SWT.NONE);
		tbItemStateObject = new TableItem(tabla2, SWT.NONE);
							
		TableColumn columna14 = new TableColumn(tabla4, SWT.NONE);
		columna14.setWidth(125);
		columna14.setText("");
		TableColumn columna24 = new TableColumn(tabla4, SWT.NONE);
		columna24.setWidth(125);
		columna24.setText("");
		
		FormDatas.attach(tabla4).atTopTo(lbObjectLoanData, 5).atLeftTo(lbDetailsPerson, 240);
		 
		//-------------
		
		Label label5 = new Label(grupo, SWT.NORMAL);
		label5.setText("Motivos");
		FormDatas.attach(label5).atTopTo(tabla3, 10);	
		
		
		Text text2 = new Text(grupo, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(text2).atTopTo(label5, 5).withWidth(600).withHeight(50);
		
		
		
		/*Link link = new Link(grupo, SWT.NONE);
		Link link1 = new Link(grupo, SWT.NONE);
		Button btnModify = new Button(grupo, SWT.PUSH);
		Button btnDelete = new Button(grupo, SWT.PUSH);
		Button btnClose = new Button(grupo, SWT.PUSH);
		Button btnExportExcel = new Button(grupo, SWT.PUSH);
		Button btnExportPDF = new Button(grupo, SWT.PUSH);
		
		link.setText("<a>"+AbosMessages.get().LABEL_RECORD +"</a>");
		link1.setText("<a>"+ AbosMessages.get().LABEL_CURRENT_STATUS +"</a>");
		btnModify.setText(AbosMessages.get().BUTTON_MODIFY);
		btnDelete.setText(AbosMessages.get().BUTTON_DELETE);
		btnClose.setText(AbosMessages.get().BUTTON_CLOSE);
		btnExportExcel.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		
		FormDatas.attach(link).atTopTo(text2, 5).atLeftTo(grupo,250);
		FormDatas.attach(link1).atTopTo(text2, 5).atLeftTo(link,20);
		FormDatas.attach(btnModify).atTopTo(text2, 5).atLeftTo(link1,20);
		FormDatas.attach(btnDelete).atTopTo(text2, 5).atLeftTo(btnModify,20);
		FormDatas.attach(btnClose).atTopTo(text2, 5).atLeftTo(btnDelete,20);
		FormDatas.attach(btnExportExcel).atTopTo(btnModify, 5).atLeftTo(grupo,370);
		FormDatas.attach(btnExportPDF).atTopTo(btnModify, 5).atLeftTo(btnExportExcel,20);*/
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

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			IVisualEntityManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

}
