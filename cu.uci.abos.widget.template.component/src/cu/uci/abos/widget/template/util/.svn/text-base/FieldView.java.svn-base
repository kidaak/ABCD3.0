package cu.uci.abos.widget.template.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Link;

import cu.uci.abos.widget.repeatable.field.CataloguingComponent;
import cu.uci.abos.widget.repeatable.field.ControlType;
import cu.uci.abos.widget.repeatable.field.listener.EventAdd;
import cu.uci.abos.widget.repeatable.field.util.SubFieldDescription;
import cu.uci.abos.util.api.FormDatas;

public class FieldView {
	
	private CTabFolder tabFolder;
	private ExpandBar expandBar;
	private ExpandItem expandItem;
	private CataloguingComponent componet;
	private boolean repeatedField;
	private int tag;
	private String description;
	private int type;
	
    public FieldView(CTabFolder tabFolder, ExpandBar expandBar, ExpandItem expandItem,
    		int position, boolean repeatedField, int tag, String description, int type){
    	
    	this.tabFolder = tabFolder;
    	this.expandBar = expandBar;
    	this.expandItem = expandItem;
    	this.repeatedField = repeatedField;
    	this.tag = tag;
    	this.description = description;
    	this.type = type;
    }
	
	
	public void buildingView(){
		
		Composite expandItemComposite = createComposite();

		 String[] texts = new String[1];
		 int[] types = new int[1];
		 ControlType[] controls = new ControlType[1];
		
		 SubFieldDescription subFieldDescription = new SubFieldDescription(texts, types, controls);
		
		 expandItem.setExpanded(true);
		 
		 //Creating the view of the field
		 texts = new String[1];
		 types = new int[1];
		 controls = new ControlType[1];
		 
		 repeatedField = true;
		 
		 type = 3;
		 
		 texts[0] = "";
		 
		 types[0] = type;
		 
		 controls[0] = ControlType.Text;	 
		 
		 subFieldDescription.setDescriptions(texts, types, controls);
		 
		 plusLink(this.repeatedField, expandItemComposite, subFieldDescription);
		 
		 componet = new CataloguingComponent(expandItemComposite, 0, subFieldDescription, expandItem,
				 repeatedField, tabFolder, description, tag);
		 
		 componet.setLayout(new FormLayout());
		 
		 updateExpandItem(expandItemComposite);
		
		
	}
	
	private Composite createComposite(){
		
		Composite composite = new Composite(expandBar, 0);  
		composite.setLayout(new FormLayout());
		FormDatas.attach(composite).atTop(0).atLeft(0);
		
		return composite;
		
	}
	
	private void plusLink(boolean repeatedField, Composite expandItemComposite, SubFieldDescription subFieldDescription){
		
		Link plusLink = new Link(expandItemComposite, 0);
		 
		 if(repeatedField){
		 
		   plusLink.setText("<a> + </a>");
		 
		   FormDatas.attach(plusLink).atTop(5).atLeft(5);
		 
		   EventAdd eventAdd = new EventAdd(expandBar, tabFolder, subFieldDescription,
				   tag, description);
		    
		   plusLink.addListener(SWT.Selection,eventAdd);
		 
		 }
		
	}
	
	private void updateExpandItem(Composite expandItemComposite){
		
		 //UpdateSize
		 expandItem.setHeight(expandItemComposite.computeSize(SWT.DEFAULT,
					SWT.DEFAULT).y+5);
		 
		 //SetControl
		 expandItem.setControl(expandItemComposite);
		
	}


	public CataloguingComponent getComponet() {
		return componet;
	}


	public void setComponet(CataloguingComponent componet) {
		this.componet = componet;
	}
	
	
}
