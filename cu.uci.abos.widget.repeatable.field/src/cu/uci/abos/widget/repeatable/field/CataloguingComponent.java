package cu.uci.abos.widget.repeatable.field;

import java.util.ArrayList;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import cu.uci.abos.widget.repeatable.field.listener.EventAddField;
import cu.uci.abos.widget.repeatable.field.listener.EventSimpleAdd;
import cu.uci.abos.widget.repeatable.field.listener.EventTabFolder;
import cu.uci.abos.widget.repeatable.field.util.AttachDigitalFileComposite;
import cu.uci.abos.widget.repeatable.field.util.FieldStructure;
import cu.uci.abos.widget.repeatable.field.util.SubFieldDescription;
import cu.uci.abos.util.api.FormDatas;

public class CataloguingComponent extends Composite {
	
	private Control control;
	private ControlType controlType;
	private boolean white = true;
	private Link lin1;
	private Link lin2;
	private Label label;
	private Composite parent;
	private Composite father;
	private Composite content;
	private ExpandItem ei;
	private CTabFolder tabFolder;
	private boolean plus;
	public static ArrayList<FieldStructure> childrens = new ArrayList<FieldStructure>();
	
	public Link getLink(){return lin2;}
	
	//simple one children
	public CataloguingComponent(Composite parent, int style, String labelText, 
			ControlType controlType, boolean plus){
		super(parent, style);
		
		this.white = false;
		
		startAtributes(labelText);
		
		createControl(controlType, content);
		
		this.plus = plus;
		
		threeType(content);
		
		FormDatas.attach(lin2).atTopTo(content, 7).atLeftTo(control, 10);
		
		lin2.addListener(SWT.Selection, new EventSimpleAdd(labelText, father, parent, controlType));

	}
	
	//for event to simple one children 
	public CataloguingComponent(Composite parent, int style, String textName, ControlType controlType){
		super(parent, style);
		
		this.white = false;
		
		startAtributtesEvents(textName);
		
		createControl(controlType, this);
		
		this.plus = false;
		
        threeType(this);
		
		FormDatas.attach(lin2).atTopTo(this, 7).atLeftTo(control, 10);
		
		layout(true);
		
	}
	
	 //One children
	public CataloguingComponent(Composite parent,int style, int type, String labelText, ControlType ctrType ,ExpandItem ei, boolean plus, boolean repeatedField, CTabFolder tabFolder, String description, int tag) {
		super(parent,style);
		// TODO Auto-generated constructor stub
		
		this.parent = parent;
		this.controlType = ctrType;
		this.ei = ei;
		this.plus = plus;
		this.tabFolder = tabFolder;
		
		startAtributes(labelText);
		
		//common to all
		createControl(ctrType, content);
		
		childrens.add(new FieldStructure(tag, control));
		
		//particular cases
		if(type == 2 || type == 4){
			twoType();
			
        	if(type == 4){
        		threeType(content);
        		FormDatas.attach(lin2).atTopTo(content, 7).atLeftTo(lin1, 0);
        		lin2.addListener(SWT.Selection, new EventAddField(label.getText(), father, this.ei,parent,4,controlType, tabFolder,description,tag));
        	}
			
		}
		else if(type == 3){
			threeType(content);
			FormDatas.attach(lin2).atTopTo(content, 7).atLeftTo(control, 10);
			lin2.addListener(SWT.Selection, new EventAddField(label.getText(), father, this.ei,parent,3,controlType, tabFolder,description,tag));
		}
		
	}
	
	//for event to one children 
	public CataloguingComponent(Composite parent,int style, int type, String labelText, ControlType ctrType ,ExpandItem ei, CTabFolder tabFolder, String description, int tag) {
		super(parent,style);
		// TODO Auto-generated constructor stub
		
		this.plus = false;
		
		startAtributtesEvents(labelText);
		
		//common to all
		createControl(ctrType, this);
		
		childrens.add(new FieldStructure(tag, control));
		
		//particular cases
		if(type == 2 || type == 4){
			twoType();
			
        	if(type == 4){
        		threeType(this);
        		FormDatas.attach(lin2).atTopTo(this, 7).atLeftTo(lin1, 0);
        	}
			
		}
		else if(type == 3){
			threeType(this);
			FormDatas.attach(lin2).atTopTo(this, 7).atLeftTo(control, 10);
			
		}
		
		layout(true);
	}
	
  //n children's
	public CataloguingComponent(Composite parent,int style, SubFieldDescription subFieldDescription, ExpandItem ei, boolean repeatedField, CTabFolder tabFolder, String description, int tag) {
		
		super(parent,style);
		int componentsSize = subFieldDescription.getTypes().length;
		
		for (int i = 0; i < componentsSize; i++) {
		   CataloguingComponent gc = new CataloguingComponent(this, 0, subFieldDescription.getTypes()[i], subFieldDescription.getTexts()[i],
				   subFieldDescription.getControls()[i], ei, true, repeatedField, tabFolder,description, tag);
		   
		   gc.setLayout(new FormLayout());
		   
		   if(i==0){
			   if(repeatedField)
			   FormDatas.attach(this.getChildren()[i]).atTopTo(parent, 30);
			   else
			   FormDatas.attach(this.getChildren()[i]).atTopTo(parent, 5);	   
		   }   
		   else
			   FormDatas.attach(this.getChildren()[i]).atTopTo(this.getChildren()[i-1], 10).atLeftTo(this, 0);
		}
		
	}
	
	
	//Private Methods
	
	private void twoType(){
		
		Composite treePoints = new Composite(tabFolder,SWT.V_SCROLL|SWT.BORDER);
    	treePoints.setLayout(new FormLayout());
    	FormDatas.attach(treePoints).atTopTo(parent, 0).atLeftTo(parent, 0).withHeight(325);
    
    	AttachDigitalFileComposite attachDigitalFile = new AttachDigitalFileComposite(treePoints, 0,tabFolder);
    	attachDigitalFile.setLayout(new FormLayout());
    	
    	FormDatas.attach(attachDigitalFile).atTopTo(treePoints, 0);
    	
    	String subFieldName = label.getText();
    	
    	if(!label.getText().equals(""))
    	subFieldName = subFieldName.substring(0, subFieldName.length()-1);
    	
    	String fieldNumber = ei.getText();
    	fieldNumber = fieldNumber.substring(0, 3);
    	
    	lin1 = new Link(father, 0);
    	lin1.setText("<a> ... </a>");
    	FormDatas.attach(lin1).atTopTo(father, 3).atLeftTo(control, 10);

    	lin1.addListener(SWT.Selection, new EventTabFolder(treePoints, tabFolder, fieldNumber, subFieldName));
	}
	
	private void threeType(Composite parent){
		
		lin2 = new Link(parent, 0);
		if(plus)
    	lin2.setText("<a> + </a>");
		else
			lin2.setText("<a> - </a>");
    	
	}
	
	private void createControl(ControlType controlType, Composite parent){
		
		switch (controlType) {
		case Text:
			control = new Text(parent, 0);
			
			FormDatas.attach(control).atTopTo(parent, 2).atLeftTo(label, 10).withWidth(150);
		
			break;
			
		case Combo:
			control = new Combo(parent, 0);
			
			FormDatas.attach(control).atTopTo(parent, 2).atLeftTo(label, 10).withWidth(172);
			
			break;
			
		default:
			break;
		}
		
		FormDatas.attach(label).atTopTo(content, 10).atLeft(5);
	
	}
	
	public void startAtributes(String labelText){
		
		father = new Composite(this, 0);
		
		content = new Composite(father, 0);
		
		setLayout(new FormLayout());
		
		father.setLayout(new FormLayout());
		
		content.setLayout(new FormLayout());
		
		if(!white){
		
		this.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		father.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		content.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		}
		
		FormDatas.attach(father).atTopTo(this, 0).atLeftTo(this, 0);
		
		FormDatas.attach(content).atTopTo(father, 0).atLeftTo(father, 0);
		
		label = new Label(content, 0);
		
		label.setText(labelText);
		
		layout(true);
		
	}
	
	public void startAtributtesEvents(String labelText){
		
		setLayout(new FormLayout());
		
		if(!white){
		
		this.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
        }
		
		label = new Label(this, 0);
		label.setText(labelText);
		
		layout(true);
		
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
