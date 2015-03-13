package cu.uci.abcd.cataloguing.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unesco.jisis.corelib.common.Global;
import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.record.Field;
import org.unesco.jisis.corelib.record.IField;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.cataloguing.controller.RegisterController;
import cu.uci.abos.util.api.MessageDialogUtil;
import cu.uci.abos.widget.repeatable.field.util.FieldStructure;


public class EventSave implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RegisterController controller;
	private String dataBaseName;
	private ArrayList<FieldStructure> childrens;
	private Shell shell;
	
	public EventSave(RegisterController controller, String dataBaseName, ArrayList<FieldStructure> childrens, Shell shell){
		
		this.controller = controller;
		this.dataBaseName = dataBaseName;
		this.childrens = childrens;
		this.shell = shell;
	}

	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
	
	if(controller != null){			
		
	int fieldCount = childrens.size();
	
	String id1 = ((Text)childrens.get(0).getControl()).getText();
	String id2 = ((Text)childrens.get(1).getControl()).getText();
	
	List<String> ids = Arrays.asList(id1,id2);
	
	   IRecord record = Record.createRecord();
	   
	   try {
		   
		   int fieldNotEmpty = 0;
		    
		    for (int i = 0; i < fieldCount; i++) {
		    	
		    	String value = "";
		    	
		    	if(childrens.get(i).getControl() instanceof Text)
		    		value = ((Text)childrens.get(i).getControl()).getText();
		    	else if(childrens.get(i).getControl() instanceof Combo)
		    		value = ((Combo)childrens.get(i).getControl()).getText();
		    	
		    	if(!childrens.get(i).getControl().isDisposed() && value != ""){
		    		
		    		IField field = new Field(childrens.get(i).getTag(), Global.FIELD_TYPE_ALPHANUMERIC);
		    		field.setFieldValue(((Text)childrens.get(i).getControl()).getText());
		    		
		    		record.addField(field);
		    		
		    		fieldNotEmpty++;
		    	}
				
			}
		    
		    if(fieldNotEmpty > 0){
 
		      controller.saveRecord((Record)record,ids,dataBaseName);
		   
		      MessageDialogUtil.openInformation(shell, "Información", "Registro guardado con éxito!", null);
		    }
		    else
		    	MessageDialogUtil.openError(shell, "Error", "No se puede guardar un Registro Vacío", null);
		    
		} catch (DbException e) {
			
			MessageDialogUtil.openError(shell, "Error", "Problemas de Conección con JISIS", null);
			
		    e.printStackTrace();
		}
	  
	  
	}
	
	else
		MessageDialogUtil.openError(shell, "Error", "Problema de Conección con JISIS", null);
	
		
	
  }	

}
