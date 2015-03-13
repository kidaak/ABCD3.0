package cu.uci.abcd.adquisicion.iu;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.adquisicion.iu.controller.ConsultarRegistroDeAdquisicionController;
import cu.uci.abcd.adquisicion.iu.domain.ListadoDeRegistroDeAdquisicionesEntity;
import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;
import cu.uci.abos.widgets.grid.CRUDTreeTable;

public class ConsultarRegistroDeAdquisiciones implements IContributor {
	private IViewController controller;
	private Text txtTitulo; 
	private Text txtAutor;
	private Combo tipoMaterial;
	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Consultar Registro de Adquisiciones";
	}

	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "ConsultarRegistroAdquisicionID";
	}

	public String containerMenu() {
		// TODO Auto-generated method stub
		return "Adquisición";
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		Composite group = new Composite(parent, SWT.NONE);
		
		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);
		FormDatas.attach(group).atLeft(0).atRight(0);
		
		Label criterio = new Label(group,SWT.NONE);
		criterio.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		FormDatas.attach(criterio).atTopTo(group, 10).atLeft(33);
			
		
		CompoundLabel titleCompound = new CompoundLabel(group, 0, ControlType.Text);
		titleCompound.setText(MessageUtil.unescape(AbosMessages.get().LABEL_TITLE));
		
		CompoundLabel authorCompound = new CompoundLabel(group, 0, ControlType.Text);
		authorCompound.setText(AbosMessages.get().LABEL_AUTHOR);
		
		CompoundLabel tipoAdqCompound = new CompoundLabel(group, 0, ControlType.Combo);
		tipoAdqCompound.setText(MessageUtil.unescape(AbosMessages.get().LABEL_ADQUISITION_TYPE));
		//String text = ((Combo)tipoAdqCompound.getControl()).getText();
				
		CompoundLabel tipoMaterialCompound = new CompoundLabel(group, 0, ControlType.Combo);
		tipoMaterialCompound.setText(AbosMessages.get().LABEL_MATERIAL_TYPE);
						  
	    FormDatas.attach(titleCompound).atTopTo(group, 30).atLeft(50);
	    FormDatas.attach(authorCompound).atTopTo(group, 30).atLeftTo(titleCompound,50);
	    FormDatas.attach(tipoAdqCompound).atTopTo(group, 30).atLeftTo(authorCompound,50);
	    FormDatas.attach(tipoMaterialCompound).atTopTo(group, 30).atLeftTo(tipoAdqCompound,50);
	    
	    titleCompound.setPosition(SWT.TOP, 6);
	    authorCompound.setPosition(SWT.TOP, 6);
	    tipoAdqCompound.setPosition(SWT.TOP, 6);
	    tipoMaterialCompound.setPosition(SWT.TOP, 6);
	   	
		
		CompoundLabel estadoCompound = new CompoundLabel(group, 0, ControlType.Combo);
		estadoCompound.setText(AbosMessages.get().LABEL_STATE);
		
		Label lblFechaDeRegistro = new Label(group, SWT.NONE);
		FormDatas.attach(lblFechaDeRegistro).atTopTo(authorCompound,20).atLeftTo(estadoCompound,70);
		lblFechaDeRegistro.setText(MessageUtil.unescape(AbosMessages.get().LABEL_CREATION_DATE_ADQUISITION));

		CompoundLabel desdeCompound = new CompoundLabel(group, 0, ControlType.DatePicker);
		desdeCompound.setText(AbosMessages.get().LABEL_SINCE);
		
		CompoundLabel hastaCompound = new CompoundLabel(group, 0, ControlType.DatePicker);
		hastaCompound.setText(AbosMessages.get().LABEL_UNTIL);
				
		 FormDatas.attach(estadoCompound).atTopTo(lblFechaDeRegistro, 6).atLeft(50);
		    FormDatas.attach(desdeCompound).atTopTo(lblFechaDeRegistro, 6).atLeftTo(estadoCompound,70);
		    FormDatas.attach(hastaCompound).atTopTo(lblFechaDeRegistro, 6).atLeftTo(desdeCompound,25);
		    
		    
		    estadoCompound.setPosition(SWT.TOP, 6);
		    desdeCompound.setPosition(SWT.TOP, 6);
		    hastaCompound.setPosition(SWT.TOP, 6);

		Button consultar = new Button(group, SWT.NONE);
		FormDatas.attach(consultar).atTopTo(desdeCompound, 20).atLeftTo(hastaCompound,-30);
		consultar.setText(AbosMessages.get().BUTTON_CONSULT);
		
		//consultar.addListener(SWT.Selection, new EventCheckLogAcquisition(txtTitulo,txtAutor,tipoAdq,tipoMaterial,cb_Estado,dt_Desde,dateTimeHasta,controller));


		Button nuevaBusq = new Button(group, SWT.NONE);
		FormDatas.attach(nuevaBusq).atTopTo(hastaCompound, 20).atLeftTo(consultar, 20);
		nuevaBusq.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));

		Button cerrar = new Button(group, SWT.NONE);
		FormDatas.attach(cerrar).atTopTo(hastaCompound, 20).atLeftTo(nuevaBusq, 20);
		cerrar.setText(AbosMessages.get().BUTTON_CLOSE);

		Label separador = new Label(group,SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(consultar,5).atLeft(0).atRight(0);

		Label listado = new Label(group,SWT.NONE);
		FormDatas.attach(listado).atTopTo(separador,10).atLeftTo(group, 33);
		listado.setText(AbosMessages.get().LABEL_SUGGESTIONS_LIST);

		CRUDTreeTable tabla = new cu.uci.abos.widgets.grid.CRUDTreeTable(group, SWT.BORDER);
		tabla.setEntityClass(ListadoDeRegistroDeAdquisicionesEntity.class);
		FormDatas.attach(tabla).atTopTo(listado, 10).atLeft(0).atRight(0);

		tabla.setColumnHeaders(Arrays.asList(AbosMessages.get().TABLE_SUMMARY,
				MessageUtil.unescape(AbosMessages.get().TABLE__ADQUISITION_TYPE),AbosMessages.get().TABLE_DATE,
				AbosMessages.get().TABLE_STATE_OF_REGISTRATION));
		try {
			tabla.createTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//initializeGrid(tabla);

		
		Button exportarHC = new Button(group, SWT.NONE);
		FormDatas.attach(exportarHC).atTopTo(tabla,20).atLeftTo(hastaCompound,-30);
		exportarHC.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));

		Button exportarPDF = new Button(group, SWT.NONE);
		FormDatas.attach(exportarPDF).atTopTo(tabla,20).atLeftTo(exportarHC,10);
		exportarPDF.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);

		return parent;

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
		this.controller= controller;
	}
	private void initializeGrid(CRUDTreeTable tabla) {

		Collection<Record> listRecord;
		try {
			listRecord = ((ConsultarRegistroDeAdquisicionController) controller).consultService(txtTitulo.getText(),txtAutor.getText(),tipoMaterial.getText());
			for (IRecord aux : listRecord) {
				ListadoDeRegistroDeAdquisicionesEntity recordAcquisition = new ListadoDeRegistroDeAdquisicionesEntity(((ListadoDeRegistroDeAdquisicionesEntity) aux).getMfn(),
						((ListadoDeRegistroDeAdquisicionesEntity) aux).getResumen(),((ListadoDeRegistroDeAdquisicionesEntity) aux).getTipoDeAdquisicion(), ((ListadoDeRegistroDeAdquisicionesEntity) aux).getData(),((ListadoDeRegistroDeAdquisicionesEntity) aux).getEstadoDelRegistro());
				recordAcquisition.setMfn(aux.getMfn());
				tabla.addRow(recordAcquisition);
			}
			
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
		
	

