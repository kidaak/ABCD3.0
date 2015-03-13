
package cu.uci.abcd.management.db.ui.contributors;

import java.util.Arrays;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.Column;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class Administrar_Hoja_Trabajo implements IContributor{
	
	Label criterio;
	Text text;
	Text text_1;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(final Composite parent) {
		// TODO Auto-generated method stub
		
		 FormLayout layout=new FormLayout();
		
        parent.setLayout(layout);
		Composite comp=new Composite(parent, SWT.None);
		
		comp.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		
		FormDatas.attach(comp).atLeftTo(parent, 90);
		
		
		
		Label lblNewLabel = new Label(comp, SWT.NONE);
		lblNewLabel.setBounds(22, 44, 156, 15);
		lblNewLabel.setText("Criterios de Búsqueda");
		
		Label lblNombreDeLa = new Label(comp, SWT.NONE);
		lblNombreDeLa.setText("Hoja de Trabajo");
		lblNombreDeLa.setBounds(22, 73, 156, 15);
		
		Label lblNombreDel = new Label(comp, SWT.NONE);
		lblNombreDel.setText("Tipo de Registro");
		lblNombreDel.setBounds(310, 73, 156, 15);
		
		text = new Text(comp, SWT.BORDER);
		text.setBounds(22, 94, 224, 25);
		
		text_1 = new Text(comp, SWT.BORDER);
		text_1.setBounds(306, 94, 224, 25);
			
		Button btnNewButton = new Button(comp, SWT.NONE);
		btnNewButton.setBounds(255, 158, 83, 27);
		btnNewButton.setText("Consultar");
		
		Button btnCerrar = new Button(comp, SWT.NONE);
		btnCerrar.setText("Cerrar");
		btnCerrar.setBounds(610, 158, 83, 27);
		
		Button btnNuevo = new Button(comp, SWT.NONE);
		btnNuevo.setText("Nuevo");
		btnNuevo.setBounds(503, 158, 83, 27);
		
		Button btnNuevaBsqueda = new Button(comp, SWT.NONE);
		btnNuevaBsqueda.setText("Nueva Búsqueda");
		btnNuevaBsqueda.setBounds(355, 158, 122, 27);
		
		Button hoja = new Button(comp, SWT.NONE);
		hoja.setText("Exportar a PDF");
		hoja.setBounds(550, 300, 100, 27);
		
		Button pdf = new Button(comp, SWT.NONE);
		pdf.setText("Exportar a Hoja de Cálculo");
		pdf.setBounds(355, 300, 160, 27);
		/*
		Table table = new Table(grupo, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(22, 228, 671, 62);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		

		TableColumn colum2= new TableColumn(table, SWT.CENTER);
		colum2.setText("Nombre de la Lista");
		colum2.setWidth(265);
		
		TableColumn colum3= new TableColumn(table, SWT.CENTER);
		colum3.setText("Nombre del Archivo");
		colum3.setWidth(265);
		
		TableColumn colum4= new TableColumn(table, SWT.CENTER);
		colum4.setText("Acciones");
		colum4.setWidth(136);
		
		Label lblListasDeSeleccin = new Label(grupo, SWT.NONE);
		lblListasDeSeleccin.setText("Listas de Selección");
		lblListasDeSeleccin.setBounds(22, 207, 156, 15);
		
		Button btnExportarAPdf = new Button(grupo, SWT.NONE);
		btnExportarAPdf.setText("Exportar a PDF");
		btnExportarAPdf.setBounds(571, 309, 122, 27);
		
		Button btnExportarAHoja = new Button(grupo, SWT.NONE);
		btnExportarAHoja.setText("Exportar a Hoja de Cálculo");
		btnExportarAHoja.setBounds(371, 309, 178, 27);
		
		
		/*
		final CRUDTreeTable fdt = new CRUDTreeTable(container, SWT.NONE);
		FormDatas.attach(fdt).atRight(0).atLeft(0);
		fdt.setEntityClass(FDTViewEntity.class);
		fdt.setAdd(true, new FDTAddArea());
		fdt.setUpdate(true, new FDTUpdateArea());
		fdt.setWatch(true, new FDTUpdateArea());	//same as update
		fdt.setDelete(true);		
		fdt.setSearch(true);
		fdt.setSaveAll(true);
		
		fdt.addActionColumn(new Column(parent.getDisplay(), "arrow_down.png", new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				final Shell shell = new Shell(parent.getDisplay());
				shell.setLayout(new GridLayout());
				shell.setText("Hacer algo");
				shell.setSize(400, 100);
				shell.setLocation(600, 200);
				Label lbl = new Label(shell, SWT.NONE);
				lbl.setText("Hacer algo");
				Button closeBtn = new Button(shell, SWT.PUSH);
				closeBtn.setText("Cerrar");
				closeBtn.addSelectionListener(new SelectionListener() {
					private static final long serialVersionUID = 1L;
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						shell.close();
						shell.dispose();
					}						
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
					}
				});
				shell.open();
			}
		}));
		
		
		fdt.setSearchHintText("Buscar");		 //For the internationalization. If non set, it will show up blank.
		fdt.setAddButtonText("Adicionar");       //For the internationalization. If it is non set, only the icon will show up.
		fdt.setSaveAllButtonText("Salvar todo"); //For the internationalization. If it is non set, only the icon will show up.
		fdt.setCancelButtonText("Cancelar");     //For the internationalization. If it is non set, only the icon will show up.
		fdt.setColumnHeaders(Arrays.asList("Etiqueta", "Nombre", "Tipo", "Subcapmpos/Patrón"));	//For the internationalization. If non set, it will show up blank.
		
		try {
			fdt.createTable();
		}
		catch(Exception e) {
		}
		
		TreeItem root = fdt.addRow(new FDTViewEntity(0, "nombre",         1, true,  false, true,  "ab"));
		fdt.addRow(new FDTViewEntity(1, "apellidouug",      1, false, true,  false, "ab"));
		fdt.addRow(new FDTViewEntity(2, "identificación", 1, true,  false, true,  "ab"));
		fdt.addRow(new FDTViewEntity(3, "sexo",           1, true,  false, true,  "ab"));		
		fdt.addInnerRow(root, new FDTViewEntity(1, "apodo",      1, false, true,  false, "ab"));
		
		fdt.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				//IGridViewEntity entity = (FDTViewEntity) event.entity;
				//do something with the data
				//event.showEditableArea = false;
			}
		});
		
		fdt.addDeleteListener(new TreeColumnListener() {
			public void handleEvent(final TreeColumnEvent event) {
				event.performDelete = true;
			}
		});
		
		Button i10nSimulatorEnBtn = new Button(container, SWT.PUSH);
		FormDatas.attach(i10nSimulatorEnBtn).atTopTo(fdt, 10);
		i10nSimulatorEnBtn.setText("Idioma inglés");
		i10nSimulatorEnBtn.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent event) {
				fdt.setSearchHintText("Search");		 //For the internationalization. If non set, it will show up blank.
				fdt.setAddButtonText("Add");       //For the internationalization. If it is non set, only the icon will show up.
				fdt.setSaveAllButtonText("Save all"); //For the internationalization. If it is non set, only the icon will show up.
				fdt.setCancelButtonText("Cancel");     //For the internationalization. If it is non set, only the icon will show up.
				fdt.setColumnHeaders(Arrays.asList("Tag", "Name", "Type", "Subfields/Patterns"));	//For the internationalization. If non set, it will show up blank.
				
			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		Button i10nSimulatorEsBtn = new Button(container, SWT.PUSH);
		FormDatas.attach(i10nSimulatorEsBtn).atTopTo(fdt, 10).atLeftTo(i10nSimulatorEnBtn, 10);
		i10nSimulatorEsBtn.setText("Idioma español");
		i10nSimulatorEsBtn.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent event) {
				fdt.setSearchHintText("Buscar");		 //For the internationalization. If non set, it will show up blank.
				fdt.setAddButtonText("Adicionar");       //For the internationalization. If it is non set, only the icon will show up.
				fdt.setSaveAllButtonText("Salvar todo"); //For the internationalization. If it is non set, only the icon will show up.
				fdt.setCancelButtonText("Cancelar");     //For the internationalization. If it is non set, only the icon will show up.
				fdt.setColumnHeaders(Arrays.asList("Etiqueta", "Nombre", "Tipo", "Subcapmpos/Patrón"));	//For the internationalization. If non set, it will show up blank.
			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		*/
		return parent;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "AdministrarHojaTrabajoID";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Administrar Hoja de Trabajo";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void setViewController(IViewController arg0) {
		// TODO Auto-generated method stub
		
	}

}
