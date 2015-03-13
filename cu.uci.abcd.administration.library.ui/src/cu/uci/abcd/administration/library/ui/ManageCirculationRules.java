package cu.uci.abcd.administration.library.ui;

import java.util.Arrays;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import cu.uci.abcd.administration.library.aux.Auxiliary;
import cu.uci.abcd.administration.library.ui.model.CirculationRuleAddArea;
import cu.uci.abcd.administration.library.ui.model.CirculationRuleGrid;
import cu.uci.abcd.administration.library.ui.model.CirculationRuleUpdateArea;
import cu.uci.abcd.administration.library.ui.model.CirculationRuleViewArea;
import cu.uci.abcd.administration.library.ui.model.LibraryAddArea;
import cu.uci.abcd.administration.library.ui.model.LibraryGrid;
import cu.uci.abcd.administration.library.ui.model.LibraryUpdateArea;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ManageCirculationRules implements IContributor{

	Composite test;
	
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Reglas de Circulación";
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "AdministrarReglaCirculacionID";
	}

	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		
		FormLayout form = new FormLayout();
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		shell.setLayout(form);
		
		
		test= new Composite(shell, SWT.NORMAL);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test.setLayout(form);
		
		//test.setText(MessageUtil.unescape(AbosMessages.get().MANAGE_CIRCULATION_RULES));
		FormDatas.attach(test).atLeftTo(shell, 10).atLeft(0).atRight(0);
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10).atLeft(10);
		
		
			Label lblNombreDelRegistro=  new Label(test, SWT.NONE);
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 10).atLeft(10);
			lblNombreDelRegistro.setText("Tipo de Material");
			
			
			Combo estado1 = new Combo(test, SWT.NONE);
			estado1.setItems(new String[] { "Libro", "Revista","Ensayo"});
			FormDatas.attach(estado1).atTopTo(lblNombreDelRegistro, 10).atLeft(10).withWidth(200);
		
			
			Label lblCdigo=  new Label(test, SWT.NONE);
			FormDatas.attach(lblCdigo).atLeftTo(estado1, 40).atTopTo(lblCriiteriosDeBsqueda, 10);
			lblCdigo.setText("Tipo de Usuario");
			
			Combo estado2 = new Combo(test, SWT.NONE);
			estado2.setItems(new String[] { "Estudiante", "Profesor",});
			FormDatas.attach(estado2).atLeftTo(estado1, 40).atTopTo(lblCdigo, 10).withWidth(200);
			
			Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
			FormDatas.attach(separador).atTopTo(estado2, 10).atLeft(5).atRight(5);
			
			Button btnNewButton_2 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_2).atTopTo(separador, 10).atRight(5).withWidth(130);
			btnNewButton_2.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
			
			btnNewButton_2.addSelectionListener(new SelectionAdapter() {
				private static final long serialVersionUID = -5179607102055540891L;
				@Override
				public void widgetSelected(SelectionEvent e) {
					Auxiliary.CleanFields(test);
				}

			});
			
			Button btnNewButton_1 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_1).atTopTo(separador, 10).atRightTo(btnNewButton_2, 10).withWidth(130);
			btnNewButton_1.setText(AbosMessages.get().BUTTON_CONSULT);
			
			
			
			  
			  Label listado = new Label(test, SWT.NORMAL);
			  FormDatas.attach(listado).atTopTo(btnNewButton_2, 10);
			  listado.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LIST_CIRCULATION_RULES));
		
			  CRUDTreeTable tabla = new CRUDTreeTable(test, SWT.NONE);
				tabla.setEntityClass(CirculationRuleGrid.class);
				tabla.setAdd(true, new CirculationRuleAddArea());
				tabla.setAddButtonText("Adicionar");
				tabla.setWatch(true, new CirculationRuleViewArea());
				tabla.setUpdate(true, new CirculationRuleUpdateArea());
				//tabla.setSearch(true);
				tabla.setDelete(true);
				//tabla.setSaveAll(true);
				
				tabla.setColumnHeaders(Arrays.asList("Tipo de Usuario", "Tipo de Material", "Prestamos permitidos", "Tiempo", "Renovaciones"));		//For the internationalization.
				
				try {
					tabla.createTable();
				}
				catch(Exception e) {
				}
				FormDatas.attach(tabla).atTopTo(listado, 10).atLeft(5).atRight(5);
				//TreeItem root = tabla.addRow(new LibraryGrid("Editorial Gente Nueva","EK52635"));
		        tabla.addRow(new CirculationRuleGrid("Profesor", "Libro", 7, "4 dias", 1));
		        tabla.addRow(new CirculationRuleGrid("Estudiante", "Revista", 5, "10 dias", 8));
		        tabla.addRow(new CirculationRuleGrid("Especialista", "DVD", 12, "2 dias", 4));
		        
				tabla.addUpdateListener(new TreeColumnListener() {
					public void handleEvent(TreeColumnEvent event) {
						//IGridViewEntity entity = (FDTViewEntity) event.entity;
						//do something with the data
					}
				});
				
				tabla.addDeleteListener(new TreeColumnListener() {
					public void handleEvent(TreeColumnEvent event) {
						//IGridViewEntity entity = (FDTViewEntity) event.entity;
						//do something with the data
					}
				});
				
		  //-----------------Tabla--------------------------------------
		  /*
			  Table tabla = new Table(test, SWT.BORDER | SWT.FULL_SELECTION);
			  FormDatas.attach(tabla).atTopTo(listado, 10);
			  tabla.setHeaderVisible(true);
			  tabla.setLinesVisible(true);
			  
			  TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
			  tableItem_1.setText( new String[] { "column 0", "column 1" } );

			  TableColumn columna0 = new TableColumn(tabla, SWT.NONE);
			  columna0.setWidth(120);
			  columna0.setText(AbosMessages.get().LABEL_TYPE_OF_USER);
			  
			  TableColumn columna01 = new TableColumn(tabla, SWT.NONE);
			  columna01.setWidth(120);
			  columna01.setText(AbosMessages.get().MATERIAL_TYPE);
			  
			  TableColumn columna02 = new TableColumn(tabla, SWT.NONE);
			  columna02.setWidth(150);
			  columna02.setText(MessageUtil.unescape(AbosMessages.get().PERMITTED_LOANS));
			  
			  TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
			  columna1.setWidth(80);
			  columna1.setText(AbosMessages.get().TIME);
			  
			  TableColumn columna11 = new TableColumn(tabla, SWT.NONE);
			  columna11.setWidth(120);
			  columna11.setText(AbosMessages.get().RENOVATIONS);
			  
			  TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
			  columna2.setWidth(100);
			  columna2.setText(AbosMessages.get().ACTIONS);
			  */
			//----------------------------------------------------------

			  Button exportarPDF = new Button(test, SWT.PUSH);
			  exportarPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
			  FormDatas.attach(exportarPDF).atTopTo(tabla, 10).atRight();
			  
			  Button exportarHC = new Button(test, SWT.PUSH);
			  exportarHC.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
			  FormDatas.attach(exportarHC).atTopTo(tabla, 10).atRightTo(exportarPDF, 10);
		  
		
		
		  
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
