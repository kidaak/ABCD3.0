package cu.uci.abcd.adquisicion.ui.updateArea;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import cu.uci.abos.l10n.adquisition.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class ListaDeEjemplaresDelRegistroDeAdquisicionUpdateArea implements IEditableArea {

	private Map<String, Control> controls;
	
	public ListaDeEjemplaresDelRegistroDeAdquisicionUpdateArea() {
		this.controls = new HashMap<String, Control>();
	}
	@Override
	public Composite createButtons(Composite arg0, IGridViewEntity arg1,
			IVisualEntityManager arg2) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Composite createUI(Composite parent, IGridViewEntity arg1,
			IVisualEntityManager arg2) {
		// TODO Auto-generated method stub
Composite group = new Composite(parent, SWT.NONE);
		

		FormLayout layout = new FormLayout();

		parent.setLayout(layout);
		group.setLayout(layout);

		Label datosPedido = new Label(group,SWT.NONE);
		datosPedido.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LOG_DATA_ACQUISITION));
		//FormDatas.attach(datosPedido).atTop(20).atLeft(100);
		
		CompoundLabel autorCorp = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(datosPedido).atTopTo(datosPedido,20).atLeft(43);
		autorCorp.setText(AbosMessages.get().LABEL_CORPORATE_AUTHOR);
	
		//FormDatas.attach(textAutotCorp).atTopTo(datosPedido,20).atLeftTo(autorCorp,75).withWidth(190);
		
		CompoundLabel volumen = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(volumen).atTopTo(autorCorp,20).atLeft(43);
		volumen.setText(AbosMessages.get().LABEL_VOLUME); 
		//FormDatas.attach(textVolumen).atTopTo(autorCorp,20).atLeftTo(autorCorp,75).withWidth(190);

		CompoundLabel tomo = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(tomo).atTopTo(volumen,20).atLeft(43);
		tomo.setText(AbosMessages.get().LABEL_TOME);
//		FormDatas.attach(textTomo).atTopTo(volumen,20).atLeftTo(autorCorp,75).withWidth(190);

		CompoundLabel editor = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(editor).atTopTo(tomo,20).atLeft(43);
		editor.setText(AbosMessages.get().LABEL_EDITOR);
//		FormDatas.attach(textEditor).atTopTo(tomo,20).atLeftTo(autorCorp,75).withWidth(190);

		CompoundLabel ciudad = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(ciudad).atTopTo(editor,20).atLeft(43);
		ciudad.setText(AbosMessages.get().LABEL_CITY);
//		FormDatas.attach(textCiudad).atTopTo(editor,20).atLeftTo(autorCorp,75).withWidth(190);

		CompoundLabel pais = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(pais).atTopTo(ciudad,20).atLeft(43);
		pais.setText(MessageUtil.unescape(AbosMessages.get().LABEL_COUNTRY));
//		FormDatas.attach(textPaís).atTopTo(ciudad,20).atLeftTo(autorCorp,75).withWidth(190);

		CompoundLabel edicion = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(edicion).atTopTo(pais,20).atLeft(43);
		edicion.setText(MessageUtil.unescape(AbosMessages.get().LABEL_EDITION));
//		FormDatas.attach(textEdicion).atTopTo(pais,20).atLeftTo(autorCorp,75).withWidth(190);

		CompoundLabel notaPub = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(notaPub).atTopTo(edicion,20).atLeft(43);
		notaPub.setText(MessageUtil.unescape(AbosMessages.get().LABEL_PUBLIC_NOTE));
//		FormDatas.attach(textNotaPub).atTopTo(edicion,20).atLeftTo(autorCorp,75).withWidth(190);

		Label datosEjemp = new Label(group,SWT.NONE);
		//FormDatas.attach(datosEjemp).atTopTo(notaPub, 40).atLeft(25);
		datosEjemp.setText(AbosMessages.get().LABEL_SAMPLE_DATA);

		CompoundLabel codigoBarra = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(codigoBarra).atTopTo(datosEjemp, 20).atLeft(43);
		codigoBarra.setText(MessageUtil.unescape(AbosMessages.get().LABEL_BARCODE));
//		FormDatas.attach(textCodigoBarra).atTopTo(datosEjemp,20).atLeftTo(autorCorp,75).withWidth(190);

		CompoundLabel localizacionPerm = new CompoundLabel(group, 0, ControlType.Combo);
		//FormDatas.attach(localizacionPerm).atTopTo(codigoBarra, 20).atLeft(43);
		localizacionPerm.setText(MessageUtil.unescape(AbosMessages.get().LABEL_PERMANENT_LOCATION));
		//FormDatas.attach(textLocalizacionPerm).atTopTo(codigoBarra,20).atLeftTo(localizacionPerm,30).withWidth(210);

		CompoundLabel localizacionEstant = new CompoundLabel(group, 0, ControlType.Combo);
		//FormDatas.attach(localizacionEstant).atTopTo(localizacionPerm, 20).atLeft(43);
		localizacionEstant.setText(MessageUtil.unescape(AbosMessages.get().LABEL_LOCATION_ON_SHELF));
//		FormDatas.attach(cb_localizacionEstant).atTopTo(localizacionPerm,20).atLeftTo(localizacionPerm,30).withWidth(210);

		CompoundLabel estadoMat = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(estadoMat).atTopTo(localizacionEstant, 20).atLeft(43);
		estadoMat.setText(AbosMessages.get().LABEL_MATERIAL_STATE);
//		FormDatas.attach(textEstadoMat).atTopTo(localizacionEstant,20).atLeftTo(autorCorp,75).withWidth(190);


		CompoundLabel restricciones = new CompoundLabel(group, 0, ControlType.Combo);
		//FormDatas.attach(restricciones).atTopTo(estadoMat, 20).atLeft(43);
		restricciones.setText(AbosMessages.get().LABEL_RESTRICTION_ON_USE);
//		FormDatas.attach(cb_restricciones).atTopTo(estadoMat,20).atLeftTo(localizacionPerm,30).withWidth(210);

		Label datosAdq = new Label(group,SWT.None);
		//FormDatas.attach(datosAdq).atTopTo(restricciones, 40).atLeft(25);
		datosAdq.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_ACQUISITION));

		CompoundLabel proveedor = new CompoundLabel(group, 0, ControlType.Combo);
		//FormDatas.attach(proveedor).atTopTo(datosAdq, 20).atLeft(43);
		proveedor.setText(AbosMessages.get().LABEL_PROVIDER);
//		FormDatas.attach(cb_proveedor).atTopTo(datosAdq,20).atLeftTo(localizacionPerm,30).withWidth(210);

		CompoundLabel fechaAdq = new CompoundLabel(group, 0, ControlType.DatePicker);
		//FormDatas.attach(fechaAdq).atTopTo(proveedor, 20).atLeft(43);
		fechaAdq.setText(MessageUtil.unescape(AbosMessages.get().LABEL_DATA_ACQUISITION));
//		FormDatas.attach(dateTime).atTopTo(proveedor,20).atLeftTo(localizacionPerm,30).withWidth(212);

		CompoundLabel precio = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(precio).atTopTo(fechaAdq, 20).atLeft(43);
		precio.setText(AbosMessages.get().LABEL_COST);
//		FormDatas.attach(textPrecio).atTopTo(fechaAdq, 20).atLeftTo(autorCorp,75).withWidth(90);

		Combo cb_precio= new Combo (group,SWT.NONE);
		FormDatas.attach(cb_precio).atTopTo(fechaAdq,9).atLeftTo(precio,10).withWidth(90);

		CompoundLabel tipoAdq = new CompoundLabel(group, 0, ControlType.Combo);
		//FormDatas.attach(tipoAdq).atTopTo(precio, 20).atLeft(43);
		tipoAdq.setText(MessageUtil.unescape(AbosMessages.get().LABEL_ADQUISITION_TYPE));
//		FormDatas.attach(cb_tipoAdq).atTopTo(fechaAdq,20).atLeftTo(precio,20).withWidth(210);

		CompoundLabel sugeridoPor = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(sugeridoPor).atTopTo(tipoAdq, 40).atLeft(25);
		sugeridoPor.setText(AbosMessages.get().LABEL_SUGGESTED_BY);
		
		 int moreBig = localizacionEstant.getLabel().getSize().x;
		 
		 	FormDatas.attach(datosPedido).atTopTo(group, 10).atLeft(300); 
		    FormDatas.attach(autorCorp).atTopTo(datosPedido,10).atLeft(310);
		    FormDatas.attach(volumen).atTopTo(autorCorp, 15).atLeft(310);
		    FormDatas.attach(tomo).atTopTo(volumen, 15).atLeft(310);
		    FormDatas.attach(editor).atTopTo(tomo, 15).atLeft(310);
		    FormDatas.attach(ciudad).atTopTo(editor, 15).atLeft(310);
		    FormDatas.attach(pais).atTopTo(ciudad, 10).atLeft(310); 
		    FormDatas.attach(edicion).atTopTo(pais,10).atLeft(310);
		    FormDatas.attach(notaPub).atTopTo(edicion, 15).atLeft(310);
		    FormDatas.attach(datosEjemp).atTopTo(notaPub, 15).atLeft(310);
		    FormDatas.attach(codigoBarra).atTopTo(datosEjemp, 15).atLeft(310);
		    FormDatas.attach(localizacionPerm).atTopTo(codigoBarra, 15).atLeft(310);
		    FormDatas.attach(localizacionEstant).atTopTo(localizacionPerm, 10).atLeft(310); 
		    FormDatas.attach(estadoMat).atTopTo(localizacionEstant,10).atLeft(310);
		    FormDatas.attach(restricciones).atTopTo(estadoMat, 15).atLeft(310);
		    FormDatas.attach(datosAdq).atTopTo(restricciones, 15).atLeft(310);
		    FormDatas.attach(proveedor).atTopTo(datosAdq, 15).atLeft(310);
		    FormDatas.attach(fechaAdq).atTopTo(proveedor, 15).atLeft(310);
		    FormDatas.attach(precio).atTopTo(fechaAdq, 10).atLeft(310); 
		    FormDatas.attach(tipoAdq).atTopTo(precio,10).atLeft(310);
		    FormDatas.attach(sugeridoPor).atTopTo(tipoAdq,10).atLeft(310);
		    
		    
		    
		    
		    
		    localizacionEstant.setPosition(SWT.LEFT, 10);
		    autorCorp.setPosition(SWT.LEFT, moreBig - autorCorp.getLabel().getSize().x + 10);
		    volumen.setPosition(SWT.LEFT, moreBig - volumen.getLabel().getSize().x + 10); 
		    tomo.setPosition(SWT.LEFT, moreBig - tomo.getLabel().getSize().x + 10);
		    editor.setPosition(SWT.LEFT, moreBig - editor.getLabel().getSize().x + 10); 
		    ciudad.setPosition(SWT.LEFT, moreBig - ciudad.getLabel().getSize().x + 10);
		    pais.setPosition(SWT.LEFT, moreBig - pais.getLabel().getSize().x + 10); 
		    edicion.setPosition(SWT.LEFT, moreBig - edicion.getLabel().getSize().x + 10);
		    notaPub.setPosition(SWT.LEFT, moreBig - notaPub.getLabel().getSize().x + 10); 
		    
		    codigoBarra.setPosition(SWT.LEFT, moreBig - codigoBarra.getLabel().getSize().x + 10); 
		    localizacionPerm.setPosition(SWT.LEFT, moreBig - localizacionPerm.getLabel().getSize().x + 10);
		    estadoMat.setPosition(SWT.LEFT, moreBig - estadoMat.getLabel().getSize().x + 10); 
		    restricciones.setPosition(SWT.LEFT, moreBig - restricciones.getLabel().getSize().x + 10);
		    proveedor.setPosition(SWT.LEFT, moreBig - proveedor.getLabel().getSize().x + 10);
		    fechaAdq.setPosition(SWT.LEFT, moreBig - fechaAdq.getLabel().getSize().x + 10); 
		    precio.setPosition(SWT.LEFT, moreBig - precio.getLabel().getSize().x + 10);
		    tipoAdq.setPosition(SWT.LEFT, moreBig - tipoAdq.getLabel().getSize().x + 10); 
		    sugeridoPor.setPosition(SWT.LEFT, moreBig - sugeridoPor.getLabel().getSize().x + 10);
		   
		    


		Label informacion = new  Label(group,SWT.NONE);
		//FormDatas.attach(informacion).atTopTo(sugeridoPor, 20).atLeft(25);
		informacion.setText(AbosMessages.get().LABEL_INFORMATION);

		CompoundLabel identificador = new CompoundLabel(group, 0, ControlType.Text);
		//FormDatas.attach(identificador).atTopTo(informacion, 20).atLeft(43);
		identificador.setText(AbosMessages.get().LABEL_IDENTIFIER);
//		FormDatas.attach(textIdentificador).atTopTo(informacion, 20).atLeftTo(autorCorp,75).withWidth(190);
		
		FormDatas.attach(informacion).atTopTo(sugeridoPor, 10).atLeft(50); 
		FormDatas.attach(identificador).atTopTo(informacion, 10).atLeft(310); 
		identificador.setPosition(SWT.LEFT, moreBig - identificador.getLabel().getSize().x + 10);
		
		Button validar = new Button (group,SWT.None);
		FormDatas.attach(validar).atTopTo(informacion, 10).atLeftTo(identificador,20);
		validar.setText(AbosMessages.get().BUTTON_VALIDATE);
		
		Button invalidar = new Button (group,SWT.None);
		FormDatas.attach(invalidar).atTopTo(informacion, 10).atLeftTo(validar,20);
		invalidar.setText(AbosMessages.get().BUTTON_ANNUL);

		Button aceptar = new Button (group,SWT.None);
		FormDatas.attach(aceptar).atTopTo(validar, 20).atLeftTo(identificador,20);
		aceptar.setText(AbosMessages.get().BUTTON_ACEPT);

		Button cancelar = new Button (group,SWT.None);
		FormDatas.attach(cancelar).atTopTo(identificador, 20).atLeftTo(aceptar,20);
		cancelar.setText(AbosMessages.get().BUTTON_CANCEL);


		return parent;
	
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Control getControl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
