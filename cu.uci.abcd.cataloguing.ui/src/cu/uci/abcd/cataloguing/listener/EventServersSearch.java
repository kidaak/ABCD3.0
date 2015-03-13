package cu.uci.abcd.cataloguing.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import cu.uci.abcd.cataloguing.ui.FindServersZ3950;
import cu.uci.abcd.cataloguing.listener.TabItemResizeListener;



public class EventServersSearch implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CTabFolder tabFolder;
	private Composite father;
	
	public EventServersSearch(CTabFolder tabFolder, Composite parent){
		
	   this.tabFolder = tabFolder;	
	   
	   this.father = parent;
	   
	}
	
	
	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		Composite content = new Composite(tabFolder, 0);
		
		content.setLayout(new FillLayout());
		
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(content,
				SWT.V_SCROLL | SWT.H_SCROLL);
		
		scrolledComposite.setMinHeight(50);
		scrolledComposite.setMinWidth(content.getBounds().width);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setExpandHorizontal(true);
		
		Composite view = new Composite(scrolledComposite, 0);
		
		view.setLayout(new FormLayout());
		
		view.setRedraw(false);
		
		view.addListener(SWT.Resize, new TabItemResizeListener());
		
		new FindServersZ3950().createUIControl(view);
		
		scrolledComposite.setContent(view);
		
		
		
		
		int cantItems = tabFolder.getItemCount();
		boolean foundItem = false;
		int position = cantItems;
		
		for (int i = 0; i < cantItems && foundItem == false; i++) {
			String text = tabFolder.getItem(i).getText();
			
			if(text.equals("Puntos de Búsqueda Z39.50")){
				foundItem = true;
				position = i;
			}
		}
		
		if(foundItem)
	    tabFolder.setSelection(position);
		else{
			
			CTabItem tabItem = new CTabItem(tabFolder, SWT.CLOSE);
			tabItem.setText("Puntos de Búsqueda Z39.50");
			tabItem.setShowClose(true);
			tabItem.setControl(content);
			
			tabFolder.setSelection(position);
		  
		}
		
		view.setSize(100, 100); 
		
		view.layout(true);
		
		scrolledComposite.setMinSize(view.computeSize(scrolledComposite.getSize().x, SWT.DEFAULT));
		
		father.layout(true, true);
	
	}

}
