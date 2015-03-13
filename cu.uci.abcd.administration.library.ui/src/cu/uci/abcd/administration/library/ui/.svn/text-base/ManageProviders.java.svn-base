package cu.uci.abcd.administration.library.ui;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abcd.administration.library.aux.Auxiliary;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.administration.library.ui.controller.ProviderViewController;
import cu.uci.abcd.administration.library.ui.model.LibraryGrid;
import cu.uci.abcd.administration.library.ui.model.ProviderAddArea;
import cu.uci.abcd.administration.library.ui.model.ProviderUpdateArea;
import cu.uci.abcd.administration.library.ui.model.ProviderViewArea;
import cu.uci.abcd.administration.library.ui.model._ProviderUpdateArea;
import cu.uci.abcd.administration.library.ui.model.ProviderGrid;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ManageProviders implements IContributor{
	
	private IViewController controller;
	
	FormLayout form;
	Composite test;
	CRUDTreeTable tableProvider;
	
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Proveedores";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "AdministrarProveedoresID";
	}


	@Override
	public Control createUIControl(final Composite shell) {
		// TODO Auto-generated method stub
	
		
		form = new FormLayout();
		shell.setLayout(form);
		
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test= new Composite(shell, SWT.NORMAL);
		test.setLayout(form);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		//test.setText(AbosMessages.get().MANAGE_PROVIDERS);
		FormDatas.attach(test).atLeftTo(shell, 10).atLeft(0).atRight(0);
		Label lblCriiteriosDeBsqueda=  new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));

		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test,10).atLeft(10);
		
		
			Label lblNombreDelRegistro=  new Label(test, SWT.NONE);
			FormDatas.attach(lblNombreDelRegistro).atTopTo(lblCriiteriosDeBsqueda, 10).atLeft(10);
			lblNombreDelRegistro.setText("Nombre del provedor");
			
			Text text_1 = new Text(test, SWT.BORDER);
			FormDatas.attach(text_1).atTopTo(lblNombreDelRegistro, 10).atLeft(10).withWidth(200);
		
			
			Label lblCdigo=  new Label(test, SWT.NONE);
			lblCdigo.setLayoutData(new FormData());
			FormDatas.attach(lblCdigo).atLeftTo(text_1, 40).atTopTo(lblCriiteriosDeBsqueda, 10);
			lblCdigo.setText("Identificacion");
			
			Text text_2 = new Text(test, SWT.BORDER);
			FormDatas.attach(text_2).atLeftTo(text_1, 40).atTopTo(lblCdigo, 10).withWidth(200);
			
			
			Label lblEst=  new Label(test, SWT.NONE);
			lblEst.setText("Estado");
			FormDatas.attach(lblEst).atLeftTo(text_2, 40).atTopTo(lblCriiteriosDeBsqueda, 10);
			
			Combo estado1 = new Combo(test, SWT.NONE);
			estado1.setItems(new String[] { "Activo", "Pasivo"});
			FormDatas.attach(estado1).atLeftTo(text_2, 40).atTopTo(lblEst, 10).withWidth(200);
			
			Label lblTPo=  new Label(test, SWT.NONE);
			lblTPo.setText("Tipo de Provedor");
			FormDatas.attach(lblTPo).atTopTo(text_1, 15).atLeft(10);
			
			Button btnCheckButton = new Button(test, SWT.CHECK);
			btnCheckButton.setText("Comercial");
			FormDatas.attach(btnCheckButton).atTopTo(lblTPo, 10).atLeft(10);
			
	Button btnCheckButton_1 = new Button(test, SWT.CHECK);
	btnCheckButton_1.setText("Canje");
	FormDatas.attach(btnCheckButton_1).atLeftTo(btnCheckButton, 10).atTopTo(lblTPo, 10);
	
	Button btnCheckButton_2 = new Button(test, SWT.CHECK);
	btnCheckButton_2.setText("Donaciones");
	FormDatas.attach(btnCheckButton_2).atLeftTo(btnCheckButton_1, 10).atTopTo(lblTPo, 10);
	
	Button btnCheckButton_3 = new Button(test, SWT.CHECK);
	btnCheckButton_3.setText("Productor");
	FormDatas.attach(btnCheckButton_3).atLeftTo(btnCheckButton_2, 10).atTopTo(lblTPo, 10);
			
	 Label separador = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(btnCheckButton_3, 10).atLeft(5).atRight(5);
		
			
			
			
			
			
			
			//Button btnCerrar = new Button(test, SWT.NONE);
			
			//FormDatas.attach(btnCerrar).atTopTo(separador, 10).atRight(5).withWidth(130);
			//btnCerrar.setText(AbosMessages.get().BUTTON_CLOSE);
			
			Button btnNewButton_2 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_2).atTopTo(separador, 10).atRight(5).withWidth(130);
			btnNewButton_2.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
			btnNewButton_2.addSelectionListener(new SelectionAdapter() {
				private static final long serialVersionUID = -3341103990632230082L;
				@Override
				public void widgetSelected(SelectionEvent e) {
					Auxiliary.CleanFields(test);//public static void 
				}

			});
			
			
			Button btnNewButton_1 = new Button(test, SWT.NONE);
			FormDatas.attach(btnNewButton_1).atTopTo(separador, 10).atRightTo(btnNewButton_2, 10).withWidth(130);
			btnNewButton_1.setText(AbosMessages.get().BUTTON_CONSULT);
			
			  
			  Label listado = new Label(test, SWT.NORMAL);
			  listado.setLayoutData(new FormData());
			  FormDatas.attach(listado).atTopTo(btnNewButton_1, 10).atLeft(10);
			  listado.setText(AbosMessages.get().LABEL_LIST_PROVIDERS);
			  
			  
			 
			  
			 
			  
		
				tableProvider = new CRUDTreeTable(test, SWT.NONE);
				tableProvider.setEntityClass(ProviderGrid.class);
				tableProvider.setAdd(true, new ProviderAddArea(controller));
				//tableProvider.setAdd(true, new ProviderAddArea111());
				tableProvider.setAddButtonText("Adicionar");
				tableProvider.setWatch(true, new ProviderViewArea(controller));
				tableProvider.setUpdate(true, new ProviderUpdateArea());
				tableProvider.setDelete(true);
				tableProvider.setCancelButtonText("Cancelar"); 
				
				
				tableProvider.setColumnHeaders(Arrays.asList("Nombre del Proveedor", "Identificacion", "Estado"));		//For the internationalization.
				
				try {
					tableProvider.createTable();
				}
				catch(Exception e) {
				}
				FormDatas.attach(tableProvider).atTopTo(listado, 10).atLeft(5).atRight(5);
				//TreeItem root = tabla.addRow(new ProviderGrid("Editorial Gente Nueva","EK52635", "sadf", "sdfsd", "sdfsd"));
		        //tabla.addRow(new ProviderGrid("Yaksel Duran Rivas","EK41", "Calle 23", "Comercial", "ACTIVO"));
				//tabla.addRow(new ProviderGrid("Yanet Crespo Diaz","EK52", "Calle 25", "Productor", "ACTIVO"));
		        //tabla.addRow(new ProviderGrid("Angela Gloria Gomez Peña","EK59", "Calle 27", "Productor", "ACTIVO"));
				//tabla.addInnerRow(root, new ProviderGrid("Editorial Gente Nueva","EK52635", "sadf", "sdfsd", "sdfsd"));
				tableProvider.addUpdateListener(new TreeColumnListener() {
					public void handleEvent(TreeColumnEvent event) {
						//IGridViewEntity entity = (FDTViewEntity) event.entity;
						//do something with the data
					}
				});
				
				tableProvider.addDeleteListener(new TreeColumnListener() {
					public void handleEvent(TreeColumnEvent event) {
						//IGridViewEntity entity = (FDTViewEntity) event.entity;
						//do something with the data
					}
				});
				
		  Button exportarPDF = new Button(test, SWT.PUSH);
		  exportarPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		  FormDatas.attach(exportarPDF).atTopTo(tableProvider, 10).atRight();
		  
		  Button exportarHC = new Button(test, SWT.PUSH);
		  exportarHC.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
		  FormDatas.attach(exportarHC).atTopTo(tableProvider, 10).atRightTo(exportarPDF, 10);
		
		InitializeProviderGrid();
		  
		return shell;
	}


	private void InitializeProviderGrid() {
		Collection<Provider> list = ((ProviderViewController) controller).findAllProviders();
		for (Provider provider : list) {
			ProviderGrid aux = new ProviderGrid(provider);
			tableProvider.addRow(aux);
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
