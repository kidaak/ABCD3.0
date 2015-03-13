package cu.uci.abcd.circulation.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import cu.uci.abcd.circulation.ui.model.EntityLoanUser;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;

public class ShowHistoricalObjectLoan implements IContributor{

	Label lbTableReservations;
	Button btnClose;
	Label lbTableTransactions;
	Label lbTableSanctions;
	Button btnExportExcel;
	Button btnExportPDF;

		
	
	@Override
	public String contributorName() {
		return "Mostrar Historial del Objeto de Préstamo";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		parent.setLayout(new FormLayout());
		Composite grupo = new Composite(parent, SWT.BORDER);
		grupo.setData(RWT.CUSTOM_VARIANT, "gray_background");
		grupo.setLayout(new FormLayout());
		FormDatas.attach(grupo).atLeftTo(parent, 95).atTopTo(parent, 15);
		
		Label lab1 = new Label(grupo, SWT.NONE);
		lab1.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_LOAN_DATA));
		FormDatas.attach(lab1).atTopTo(grupo, 5);
		
		Label separador = new Label(grupo, SWT.SEPARATOR | SWT.VERTICAL);
		FormDatas.attach(separador).atTopTo(grupo, 5).atLeftTo(lab1, 150).withHeight(160);
		
		Label lab2 = new Label(grupo, SWT.NONE);
		lab2.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_LAST_UPDATE));
		FormDatas.attach(lab2).atTopTo(grupo, 5).atLeftTo(separador, 60);
	
		Table tabla = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla.setHeaderVisible(false);
		tabla.setLinesVisible(true);
			
		TableItem tableItem1 = new TableItem(tabla, SWT.NORMAL);
		tableItem1.setText("Título");
			
		TableItem tableItem2 = new TableItem(tabla, SWT.END);
		tableItem2.setText("Autor");
		
		TableItem tableItem3 = new TableItem(tabla, SWT.NONE);
		tableItem3.setText("No. Control");
		
		TableItem tableItem4 = new TableItem(tabla, SWT.NONE);
		tableItem4.setText("Tipo de Objeto");
			
		TableItem tableItem5 = new TableItem(tabla, SWT.NONE);
		tableItem5.setText("Estado");

		TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		columna1.setWidth(125);
		columna1.setText("");
		TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		columna2.setWidth(125);
		columna2.setText("");
		
		FormDatas.attach(tabla).atTopTo(lab1, 5);
		
		Table tabla2 = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		tabla2.setHeaderVisible(false);
		tabla2.setLinesVisible(true);
			
		TableItem tableItem6= new TableItem(tabla2, SWT.NORMAL);
		tableItem6.setText("Nombre y Apellido");
			
		TableItem tableItem7= new TableItem(tabla2, SWT.END);
		tableItem7.setText("Usuario");
		
		TableItem tableItem8= new TableItem(tabla2, SWT.NONE);
		tableItem8.setText("Fecha y Hora");
			
		TableColumn columna11 = new TableColumn(tabla2, SWT.NONE);
		columna11.setWidth(125);
		columna11.setText("");
		TableColumn columna22 = new TableColumn(tabla2, SWT.NONE);
		columna22.setWidth(125);
		columna22.setText("");
		
		FormDatas.attach(tabla2).atTopTo(lab2, 5).atLeftTo(separador,50);
		
		Label separador1 = new Label(grupo, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador1).atTopTo(tabla, 25).withWidth(900);
		
		TabFolder tabFolder = new TabFolder(grupo, SWT.NONE);
		
		FormDatas.attach(tabFolder).atTopTo(separador1, 5).withWidth(900).withHeight(200);
		
		//---------------------------
		Composite g1 = new Composite(tabFolder, SWT.BORDER);
		g1.setData(RWT.CUSTOM_VARIANT, "gray_background");
		TabItem tabItem_1 = new TabItem(tabFolder, SWT.None);
		tabItem_1.setText(AbosMessages.get().LABEL_TRANSACTIONS);
		tabItem_1.setControl(g1);
		 
		g1.setLayout(new FormLayout());
		FormDatas.attach(g1).atBottomTo(tabFolder);
		
		lbTableTransactions = new Label(grupo, SWT.NONE);
		FormDatas.attach(lbTableTransactions).atTopTo(grupo, 5);
		
		Composite compoTableTransaccions = new Composite(grupo, SWT.NONE);
		compoTableTransaccions.setLayout(new FormLayout());
		FormDatas.attach(compoTableTransaccions).atTopTo(lbTableTransactions, 10);
				
		CRUDTreeTable tableTransaccions = new CRUDTreeTable(compoTableTransaccions, SWT.BORDER);
		tableTransaccions.setEntityClass(EntityLoanUser.class);
		
		//-----------------------
		
		TabItem tabItem_2 = new TabItem(tabFolder, SWT.None);
		tabItem_2.setText(AbosMessages.get().LABEL_RESERVATIONS);
		//Group g2 = new Group(tabFolder, SWT.NONE);
		Composite g2 = new Composite(tabFolder, SWT.BORDER);
		g2.setData(RWT.CUSTOM_VARIANT, "gray_background");
		tabItem_2.setControl(g2);
		g2.setLayout(new FormLayout());
		FormDatas.attach(g2).atTopTo(tabFolder, 1);
		
		lbTableReservations = new Label(grupo, SWT.NONE);
		FormDatas.attach(lbTableReservations).atTopTo(grupo, 5);
		
		Composite compoTableReservations = new Composite(grupo, SWT.NONE);
		compoTableReservations.setLayout(new FormLayout());
		FormDatas.attach(compoTableReservations).atTopTo(lbTableReservations, 10);
				
		CRUDTreeTable tableReservations = new CRUDTreeTable(compoTableReservations,  SWT.BORDER);
		tableReservations.setEntityClass(EntityLoanUser.class);
						
		//----------
		TabItem tabItem_3 = new TabItem(tabFolder, SWT.None);
		tabItem_3.setText(AbosMessages.get().LABEL_SANCTIONS);
		//Group g3 = new Group(tabFolder, SWT.NONE);
		Composite g3 = new Composite(tabFolder, SWT.BORDER);
		g3.setData(RWT.CUSTOM_VARIANT, "gray_background");
		tabItem_3.setControl(g3);
		
		g3.setLayout(new FormLayout());
		FormDatas.attach(g3).atTopTo(tabFolder, 1);
		
		lbTableSanctions = new Label(g3, SWT.NONE);
		FormDatas.attach(lbTableSanctions).atTopTo(g3, 15).atLeftTo(g3, 10);
		 
		Composite compoTableSanctions = new Composite(grupo, SWT.NONE);
		compoTableSanctions.setLayout(new FormLayout());
		FormDatas.attach(compoTableSanctions).atTopTo(lbTableSanctions, 10);
				
		CRUDTreeTable tableSanctions = new CRUDTreeTable(compoTableSanctions,  SWT.BORDER);
		tableSanctions.setEntityClass(EntityLoanUser.class);
		
		//---------------
		btnExportExcel = new Button(grupo, SWT.PUSH);
		btnExportPDF = new Button(grupo, SWT.PUSH);
		btnClose = new Button(grupo, SWT.PUSH);
			
		FormDatas.attach(btnExportExcel).atTopTo(tabFolder, 5).atLeftTo(grupo,430);
		FormDatas.attach(btnExportPDF).atTopTo(tabFolder, 5).atLeftTo(btnExportExcel,20);
		FormDatas.attach(btnClose).atTopTo(tabFolder, 5).atLeftTo(btnExportPDF,20);
					
		return parent;
	}

	@Override
	public String getID() {
		return "RegistrarDevolucionID";
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		lbTableTransactions.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_HISTORICAL_LOAN_TRANSACTIONS));
		lbTableReservations.setText(MessageUtil.unescape(AbosMessages.get().LABEL_OBJECT_HISTORICAL_LOAN_RESERVATIONS));
		lbTableSanctions.setText(AbosMessages.get().LABEL_OBJECT_HISTORICAL_LOAN_SANCTIONS);
		btnExportExcel.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		btnExportPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		btnClose.setText(AbosMessages.get().BUTTON_CLOSE);
				
	}

	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}
}
