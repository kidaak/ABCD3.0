package Escucha;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unesco.jisis.corelib.common.Global;
import org.unesco.jisis.corelib.record.Field;
import org.unesco.jisis.corelib.record.IField;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.adquisicion.iu.controller.RegistrarRegistroDeAdquisicionController;

public class Escuchar implements Listener{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numero;
	private String titulo;
	private String author;
	private String edit;
	private String annoPubli;
	private String tipoMat;
	private String room;
    private RegistrarRegistroDeAdquisicionController controller;


	// TODO Auto-generated constructor stub
	
	
public Escuchar(String numero, String titulo, String author, String edit,
		String annoPubli, String tipoMat, String room,
		RegistrarRegistroDeAdquisicionController controller) {
	this.numero = numero;
	this.titulo = titulo;
	this.author = author;
	this.edit = edit;
	this.annoPubli = annoPubli;
	this.tipoMat = tipoMat;
	this.room = room;
	this.controller = controller;
}	

	
	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		IRecord record = Record.createRecord();
		try {
			IField numeroControl1 = new Field(1, Global.FIELD_TYPE_NUMERIC);
			numeroControl1.setFieldValue(numero);

			IField title = new Field(2, Global.FIELD_TYPE_ALPHABETIC);
			title.setFieldValue(title);

			IField author = new Field(3, Global.FIELD_TYPE_ALPHABETIC);
			author.setFieldValue(author);

			IField editor1 = new Field(4, Global.FIELD_TYPE_ALPHABETIC);
			editor1.setFieldValue(edit);

			IField annoPublic = new Field(5, Global.FIELD_TYPE_ALPHABETIC);
			annoPublic.setFieldValue(annoPublic);

			IField tipoMaterial1 = new Field(6, Global.FIELD_TYPE_ALPHABETIC);
			tipoMaterial1.setFieldValue(annoPubli);

			IField sala1 = new Field(7, Global.FIELD_TYPE_ALPHANUMERIC);
			sala1.setFieldValue(room);

			record.addField(numeroControl1);
			record.addField(title);
			record.addField(author);
			record.addField(editor1);
			record.addField(annoPublic);
			record.addField(tipoMaterial1);
			record.addField(sala1);
            
			controller.RegisterAcquisition(record);
		}catch(Exception e){

		}
		
		
	}

}
