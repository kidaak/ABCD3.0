package cu.uci.abos.widget.template.component;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.unesco.jisis.corelib.common.WorksheetDef;
import org.unesco.jisis.corelib.common.WorksheetDef.WorksheetField;

import cu.uci.abos.widget.repeatable.field.CataloguingComponent;
import cu.uci.abos.widget.repeatable.field.util.FieldStructure;
import cu.uci.abos.widget.template.domain.FieldDomain;
import cu.uci.abos.widget.template.util.FieldView;
import cu.uci.abcd.dataprovider.jisis.IJisisDataProvider;
import cu.uci.abcd.dataprovider.jisis.exception.JisisDatabaseException;
import cu.uci.abos.util.api.FormDatas;

public class TemplateCompound extends Composite{

	private Button save;
	private Button search;
	private Label marcRecord;
	private CTabFolder tabFolder;
	private Composite father;
	
	public TemplateCompound(Composite parent, int style, String dataBaseName, IJisisDataProvider service) {
		super(parent,style);
		// TODO Auto-generated constructor stub
		
        parent.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		father = new Composite(parent, 0);
		father.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		father.setLayout(new FormLayout());
		
		setLayout(new FormLayout());
		setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		FormDatas.attach(this).atTopTo(parent, 0).atLeftTo(parent, 0);
		
		save = new Button(father, 0);
		save.setText("Guardar");
		
		search = new Button(father, SWT.PUSH);
		search.setText("Busqueda z39.50");
		
		marcRecord = new Label(father, 0);
		marcRecord.setText("Agregar registro de "+ dataBaseName);
		
		Label changeWorksSheet = new Label(father, 0);
		changeWorksSheet.setText("Cambiar hoja de trabajo:");
		
		Combo changeCombo = new Combo(father, 0);
		changeCombo.add("Predeterminado", 0);
		changeCombo.add("Tesis", 1);
		changeCombo.add("Libro", 2);
		changeCombo.add("Artículo", 3);
		changeCombo.select(0);
		
		tabFolder = new CTabFolder(father, SWT.V_SCROLL);
		parent.setLayout(new FormLayout());
		tabFolder.setLayout(new FormLayout());
		
		tabFolder.setData(RWT.CUSTOM_VARIANT,"gray_background");
		FormDatas.attach(save).atTop(0).atLeft(0);
		FormDatas.attach(search).atLeftTo(save, 10);
		FormDatas.attach(marcRecord).atTopTo(save, 2);
		FormDatas.attach(tabFolder).atTopTo(marcRecord, 0).withWidth(1000);
		FormDatas.attach(changeWorksSheet).atTop(8).atLeftTo(father, 695);
		FormDatas.attach(changeCombo).atTop(0).atLeftTo(changeWorksSheet, 10);
		
		//This items are the names of the TabItems
		ArrayList<Integer> tabItemsName = new ArrayList<Integer>();
		
		//components are the names of the expandItems
		ArrayList<ArrayList<FieldDomain>> components = new ArrayList<ArrayList<FieldDomain>>();
		
		//Read of JIsis
		if(service != null){
			
			WorksheetDef worksheet = new WorksheetDef();
			
			try {
				List<String> list = service.getWorksheetNames(dataBaseName);
				
				worksheet = service.getWorksheet(list.get(0),dataBaseName);
				
			} catch (JisisDatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    int fielCount = worksheet.getFieldsCount();
		    
		  //Creating the components
		    for (int i = 0; i < fielCount; i++) {
		    	
		    	WorksheetField workSheetField = worksheet.getFieldByIndex(i);
		    	
		    	//getInformation
		    	boolean repeatableField = workSheetField.getRepeatable();
		    	
		    	String defaultValue = workSheetField.getDefaultValue();
		    	
		    	String description = workSheetField.getDescription();
		    	
		    	String displayControl = workSheetField.getDisplayControl();
		    	
		    	boolean descriptors = workSheetField.getDescriptors();
		    	
                String helpMessage = workSheetField.getHelpMessage();
		    	
		    	String pickList = workSheetField.getPickList();
		    	
		    	int subFieldsCount = workSheetField.getSubFieldsCount();
		    	
		    	int type = workSheetField.getType();
		    	
		    	String validationFormat = workSheetField.getValidationFormat();
		    	
		    	int tag = workSheetField.getTag();
		    	
		    	int tabNumber = TabNumber(tag);
		    	
				if(!tabItemsName.contains(tabNumber)){
					
					tabItemsName.add(tabNumber);
					
					ArrayList<FieldDomain> array = new ArrayList<FieldDomain>();
					
					array.add(new FieldDomain(repeatableField, tag, defaultValue, description,
							displayControl, descriptors, helpMessage, pickList, subFieldsCount,
							type, validationFormat, tabNumber));
					
					components.add(array);
				}
				else{
					
					int positionArray = -1;
					boolean found = false;
					int componentCount = components.size();
					
					for (int j = 0; j < componentCount && found == false; j++) {
						
						int tabItemName = 0;
						
						ArrayList<FieldDomain> ar = components.get(j);
						
						FieldDomain fd = ar.get(0);
						
						tabItemName = fd.getTabItemName();
						
						if(tabItemName == tabNumber){
							found = true;
							positionArray = j;
						}
						
					}
					
					components.get(positionArray).add(new FieldDomain(repeatableField, tag,
							defaultValue, description, displayControl, descriptors, helpMessage,
							pickList, subFieldsCount, type, validationFormat, tabNumber));
					
				}
				
				
			}
		     
		}
		
		//Reset components
		CataloguingComponent.childrens = new ArrayList<FieldStructure>();
		
		//Creating the view
		 for(int i = 0; i < tabItemsName.size(); i++){
			CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
			tabItem.setText(String.valueOf(tabItemsName.get(i)));
			
			Composite page = new Composite(tabFolder, 0);
			page.setData(RWT.CUSTOM_VARIANT,"gray_background");
			page.setLayout(new FormLayout());
			
			FormDatas.attach(page).atTop(0).atLeft(0);
			
			ExpandBar expandBar = new ExpandBar(page, SWT.V_SCROLL);
			
			expandBar.setSpacing(10);
			
			FormDatas.attach(expandBar).withWidth(expandBar.getParent().getParent().getParent()
					.getParent().computeSize(SWT.DEFAULT, SWT.DEFAULT).x)
					.withHeight(315).atLeft(0).atRight(0);
			
			ArrayList<FieldDomain> fieldsList = components.get(i);
			
			int fieldsListSize = fieldsList.size();
			    
			for(int j = 0; j < fieldsListSize;j++){	
			   
			   String text = fieldsList.get(j).getExpandItemText();
			   ExpandItem expandItem = new ExpandItem(expandBar, 0);
			   expandItem.setText(text);
			   expandItem.setHeight(200);
			   
			   int position = j;
			   
			   FieldView fieldView = new FieldView(tabFolder, expandBar, expandItem, position,
					   fieldsList.get(j).isRepeatableField(), fieldsList.get(j).getTag(), 
					   fieldsList.get(j).getDescription(), fieldsList.get(j).getType());
			   
			   fieldView.buildingView();
			   
			   father.setSize(SWT.DEFAULT, father.computeSize(SWT.DEFAULT,
				SWT.DEFAULT).y);
			   
			    tabItem.setControl(page);
			  
			}
			
		 }
		 
		 tabFolder.setSelection(0);
		 
		 parent.getShell().layout(true, true);
		 parent.getShell().redraw();
	     parent.getShell().update();
		
	}
	
	
    private int TabNumber(int tag){
		
		int tagNumber = -1;
		
		if(tag >= 0 && tag < 100)
    		tagNumber = 0;
    	else if(tag >= 100 && tag < 200)
    		tagNumber = 1;
    	else if(tag >= 200 && tag < 300)
    		tagNumber = 2;
    	else if(tag >= 300 && tag < 400)
    		tagNumber = 3;
    	else if(tag >= 400 && tag < 500)
    		tagNumber = 4;
    	else if(tag >= 500 && tag < 600)
    		tagNumber = 5;
    	else if(tag >= 600 && tag < 700)
    		tagNumber = 6;
    	else if(tag >= 700 && tag < 800)
    		tagNumber = 7;
    	else if(tag >= 800 && tag < 900)
    		tagNumber = 8;
    	else if(tag >= 900 && tag < 1000)
    		tagNumber = 9;
    	else if(tag >= 1000 && tag < 1100)
    		tagNumber = 10;
    	else if(tag >= 1100 && tag < 1200)
    		tagNumber = 11;
    	else if(tag >= 1200 && tag < 1300)
    		tagNumber = 12;
    	else if(tag >= 1300 && tag < 1400)
    		tagNumber = 13;
    	else if(tag >= 1400 && tag < 1500)
    		tagNumber = 14;
    	else if(tag >= 1500 && tag < 1600)
    		tagNumber = 15;
    	else if(tag >= 1600 && tag < 1700)
    		tagNumber = 16;
    	else if(tag >= 1700 && tag < 1800)
    		tagNumber = 17;
    	else if(tag >= 1800 && tag < 1900)
    		tagNumber = 18;
    	else if(tag >= 1900 && tag < 2000)
    		tagNumber = 19;
    	else if(tag >= 2000 && tag < 2100)
    		tagNumber = 20;
		
		return tagNumber;
	}
    
    public Button getButtonSave(){return save;}
    public Button getButtonSearch(){return search;}
    public Label getLabel(){return marcRecord;}
    public ArrayList<FieldStructure> getChildrens(){return CataloguingComponent.childrens;}
    public CTabFolder getTabFolder(){return tabFolder;}
    public Composite getFather(){return father;}
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
