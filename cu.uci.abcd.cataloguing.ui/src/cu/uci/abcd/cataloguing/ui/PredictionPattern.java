package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import cu.uci.abos.l10n.cataloguing.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class PredictionPattern implements IContributor {

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return MessageUtil.unescape(AbosMessages.get().CONTRIBUTOR_PREDICTION_PATTERN);
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "55";
	}

	@Override
	public Control createUIControl(Composite parent) {
		// TODO Auto-generated method stub
		
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		Composite father = new Composite(parent, 0);
		
		father.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		Composite tableComposite = new Composite(father, SWT.CENTER);
		
		tableComposite.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		FormLayout layout = new FormLayout();
		
		parent.setLayout(layout);
		father.setLayout(layout);
		tableComposite.setLayout(layout);
		
		FormDatas.attach(father).atLeft(0).atRight(0);
		
        Table table = new Table(tableComposite, SWT.BORDER);
		
		table.setTouchEnabled(true);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColum1 = new TableColumn(table, SWT.None);
	    tableColum1.setWidth(150);
	    tableColum1.setText("");
		
	    TableColumn tableColum2 = new TableColumn(table, SWT.None);
	    tableColum2.setWidth(150);
	    tableColum2.setText(AbosMessages.get().TABLE_X);
	    
	    TableColumn tableColum3 = new TableColumn(table, SWT.None);
	    tableColum3.setWidth(150);
	    tableColum3.setText(AbosMessages.get().TABLE_Y);
	    
	    TableColumn tableColum4 = new TableColumn(table, SWT.None);
	    tableColum4.setWidth(150);
	    tableColum4.setText(AbosMessages.get().TABLE_Z);
	    
	  
	    TableItem[] items = new TableItem[6];
	    
	    for(int i = 0; i < 6; i++){
	    	
	       new TableItem(table, SWT.None);
	    }
	    
	    items = table.getItems();
	    
	    items[0].setText(AbosMessages.get().TABLE_INSERT);
	    items[1].setText(AbosMessages.get().TABLE_ONCE_EVERY);
	    items[2].setText(MessageUtil.unescape(AbosMessages.get().TABLE_WHEN_MORE_THAN));
	    items[3].setText(AbosMessages.get().TABLE_INTERNAL_COUNTER);
	    items[4].setText(AbosMessages.get().TABLE_BACK_TO);
	    items[5].setText(AbosMessages.get().TABLE_BEGINS_WITH);
	    
	    
	    Text[] texts = new Text[18];
	    
	    for(int i = 0; i < 18; i++){
	    	texts[i] = new Text(table, 0);
	    }
	    
	    texts[0].setText("1");
	    texts[3].setText("1");
	    texts[6].setText("9999999");
	    texts[12].setText("0");
	    texts[15].setText("1");
	  
	  
	    TableEditor tableEditor = new TableEditor(table);
	    int tabItem = 0;
	    int textsCount = 0;
	    
	    
	    while(textsCount < 18){
	    	
	    	for(int j = 1; j < 4; j++){
	    		
	    		tableEditor = new TableEditor(table);
	    		tableEditor.grabHorizontal = true;
	    		tableEditor.setEditor(texts[textsCount], items[tabItem], j);
	    	   textsCount++;
	    	}
	    	
	    	tabItem++;
	    }
		
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
		
	}

}
