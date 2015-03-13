package cu.uci.abos.widget.repeatable.field.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;

import cu.uci.abos.widget.repeatable.field.CataloguingComponent;
import cu.uci.abos.widget.repeatable.field.util.SubFieldDescription;
import cu.uci.abos.util.api.FormDatas;


public class EventAdd implements Listener {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private ExpandBar expandBar;
    private CTabFolder tabFolder;
    private SubFieldDescription subFieldDescription;
    private int tag;
    private String description;
    private String expandBarText;
    
    public EventAdd(ExpandBar expandBar, CTabFolder tabFolder, 
    		SubFieldDescription subFielDescription, int tag, String description){
    	
    	this.subFieldDescription = subFielDescription;
    	this.expandBar = expandBar;
    	this.tabFolder = tabFolder;
    	this.tag = tag;
    	this.description = description;
    	this.expandBarText = String.valueOf(tag)+"- "+description;
    }
    
	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		int position = 0;
		
		boolean foundItem = false;
		
		for (int i = 0; i < expandBar.getItemCount() && foundItem == false; i++) {
			
			if(expandBar.getItem(i).getText().equals(expandBarText)){
				foundItem = true;
				position = i;
			}
			
		}
		
		ExpandItem expandItem = new ExpandItem(expandBar, 0, position);
		expandItem.setText(expandBarText);
	    expandItem.setHeight(200);
	    
	    expandItem.setExpanded(true);
	    
	    Composite expandItemComposite = new Composite(expandBar, 0);
	    expandItemComposite.setLayout(new FormLayout());
	    
	    Link deleteLink = new Link(expandItemComposite, 0);
	    deleteLink.setText("<a> - </a>");
	    
	    FormDatas.attach(deleteLink).atTopTo(expandItemComposite, 5).atLeftTo(expandItemComposite, 5);
	    
	    deleteLink.addListener(SWT.Selection, new EventDelete(expandItem, expandBar));
	     
	     //Creating the view of the field
		 CataloguingComponent gc = new CataloguingComponent(expandItemComposite, 0, subFieldDescription,
				 expandItem, true, tabFolder,description,tag);
		 
		 gc.setLayout(new FormLayout());
		 
		 FormDatas.attach(gc).atTopTo(expandItemComposite, 0).atLeftTo(expandItemComposite, 0);
	     
		 //Update
		 expandItem.setHeight(expandItemComposite.computeSize(SWT.DEFAULT,
					SWT.DEFAULT).y+5);
		 
		 //SetControl
		 expandItem.setControl(expandItemComposite);
		 
		 
	}


}
