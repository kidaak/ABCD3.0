package cu.uci.abos.widgets.grid;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abos.util.api.FormDatas;

public class CRUDTreeTable extends Composite {
	
	private static final long serialVersionUID = 1L;
	private Composite parent;
	private Tree tree;
	private List<Column> columns, actionColumns;
	private List<TreeColumn> treeColumns;
	private ImageManager imageManager;
	private Image addImg, saveImg, checkedImg, uncheckedImg;
	private CRUDTreeTable self;
	private Composite clientComposite, contentComposite, editionComposite;
	//private Composite paginationComposite;
	private IEditableArea watchArea, updateArea, addArea;
	private IEditableArea activeArea;
	private Column watchColumn, updateColumn, deleteColumn;
	private boolean add, saveAll, search, watch, update, delete;
	private boolean editionVisible;
	private IGridViewEntity selectedEntity;
	private TreeItem selectedTreeItem;
	private ToolItem searchItem;
	private Class<? extends IGridViewEntity> entityClass;
	private IVisualEntityManager visualEntityManager;
	private List<String> columnHeaders;
	private String cancelButtonText, searchHintText, addButtonText, saveAllButtonText;
	private ToolItem addButton, saveAllButton;
	//private List<CustomButtonData> customButtons;
	private Text searchText;
	private Button cancelButton;
	private Map<String, ButtonData> actionButtonsData;
	private Map<String, ToolItem> actionButtons;
	

	public CRUDTreeTable(Composite parent, int style) {
		super(parent, style);
		this.parent = parent;
		this.entityClass = null;
		this.actionColumns = new LinkedList<Column>();
		//this.customButtons = new LinkedList<ToolItem>();
		this.treeColumns = new LinkedList<>();
		this.columnHeaders = new LinkedList<>();
		this.actionButtonsData = new HashMap<>();
		this.actionButtons = new HashMap<>();
		this.add = false;
		this.watch = false;
		this.update = false;
		this.delete = false;
		this.search = false;
		this.saveAll = false;
		this.imageManager = new ImageManager(parent.getDisplay());
		this.checkedImg = imageManager.loadImage("checked.png");
		this.uncheckedImg = imageManager.loadImage("unchecked.png");
		this.addImg = imageManager.loadImage("add2.png");
		this.saveImg = imageManager.loadImage("save.png");
		this.self = this;
		this.editionVisible = false;
		this.cancelButtonText = "";
		this.addButtonText = "";
		this.searchHintText = "";
		this.saveAllButtonText = "";
		this.visualEntityManager = new IVisualEntityManager() {			
			@Override
			public void save(IGridViewEntity entity) {
				saveEntity(selectedTreeItem, entity);
				refresh();
			}			
			@Override
			public void delete(IGridViewEntity entity) {
				refresh();				
			}			
			@Override
			public void add(IGridViewEntity entity) {
				addRow(entity);
				if(tree.getItemCount() < 10) {
					refresh();
				}				
			}
		};
	}	
	
	@SuppressWarnings("serial")
	public void createTable() throws Exception {
		
		if(this.entityClass == null) {
			throw new Exception("You must set entity class before creating the tree table.");
		}		
		
		this.setLayout(new FormLayout());
		this.clientComposite = new Composite(this, SWT.NONE);
		this.clientComposite.setLayout(new FormLayout());
		
		this.contentComposite = new Composite(this.clientComposite, SWT.NONE);
		this.contentComposite.setLayout(new FormLayout());
		
		FormDatas.attach(this.contentComposite).atTop().atLeft(0).atRight(0);
		
		ToolBar toolBar1 = null;
		ToolBar toolBar2 = null;

		if(this.add || this.saveAll) {
			toolBar2 = new ToolBar(contentComposite, SWT.NONE);
			FormDatas.attach(toolBar2).atTop(0).atRight(0);
		}
		
		if(this.search) {
			toolBar1 = new ToolBar(contentComposite, SWT.NONE);
			FormDatas.attach(toolBar1).atTop(5).atLeft(0);
			this.searchItem = new ToolItem( toolBar1, SWT.SEPARATOR );
		    Text text = new Text( toolBar1, SWT.BORDER );
		    text.setMessage(this.searchHintText);
		    this.searchText = text;
		    searchItem.setControl( text );
		    searchItem.setWidth( 10 );		    
		}
		
		for(Entry<String, ButtonData> entry : this.actionButtonsData.entrySet()) {
			ToolItem customButton = new ToolItem( toolBar2, SWT.PUSH );
			this.actionButtons.put(entry.getKey(), customButton);
			ButtonData buttonData = entry.getValue();
			if(buttonData.getListener() != null) {
				customButton.addSelectionListener(buttonData.getListener());
			}
			if(buttonData.getIconName() != null && !buttonData.getIconName().isEmpty()) {
				Image buttonIcon = imageManager.loadImage(buttonData.getIconName());
				customButton.setImage(buttonIcon);
			}
		}
		
		if(this.add) {
			ToolItem addItem = new ToolItem( toolBar2, SWT.PUSH );
			addItem.setText(this.addButtonText);
			addItem.setImage(this.addImg);
			this.addButton = addItem;
			addItem.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					createAddArea();
				}				
				@Override
				public void widgetDefaultSelected(SelectionEvent event) {	
				}
			});
		}
		
		if(this.saveAll) {
			ToolItem saveAllItem = new ToolItem( toolBar2, SWT.PUSH );
			saveAllItem.setText(this.saveAllButtonText);
			saveAllItem.setImage(this.saveImg);
			this.saveAllButton = saveAllItem;
		}	
		
		Composite treeContainer = new Composite(this.contentComposite, SWT.NONE);
		treeContainer.setLayout(new FormLayout());
		
		this.tree = new Tree(treeContainer, SWT.BORDER | SWT.FULL_SELECTION);
		
		FormDatas.attach(treeContainer).atLeft(0).atRight(0);
		
		if(toolBar2 != null) {
			FormDatas.attach(treeContainer).atTopTo(toolBar2, 0);
		}
		else if(toolBar1 != null) {
			FormDatas.attach(treeContainer).atTopTo(toolBar1, 5);
		}
		
		this.tree.setLinesVisible(true);
		this.tree.setHeaderVisible(true);
		
		List<Method> methods = new LinkedList<Method>(Arrays.asList(this.entityClass.getMethods()));
		Collections.sort(methods, new MethodComparator());
		this.columns = new LinkedList<Column>();
		
		for(Method method : methods) {
			TreeTableColumn columnAnnotation = method.getAnnotation(TreeTableColumn.class);
			if(columnAnnotation != null) {
				Column columnData = new Column(columnAnnotation.percentWidth(), columnAnnotation.index());
				columnData.setDataExtractor(method);
				columns.add(columnData);
			}
		}
		
		for(int i = 0; i < columns.size(); i++) {
			Column columnData = columns.get(i);
			TreeColumn treeColumn = this.createTreeColumn(columnData);			
			String header = "";			
			if(i < this.columnHeaders.size()) {
				header = this.columnHeaders.get(i);
			}			
			columnData.setHeader(header);
			treeColumn.setText(header);
			this.treeColumns.add(treeColumn);
		}
		
		int columnCount = this.tree.getColumnCount();
		
		this.createDefaultActionColumns();
		
		for(int i = 0; i < this.actionColumns.size(); i++) {
			Column columnData = this.actionColumns.get(i);
			columnData.setIndex(columnCount + i);
			this.createTreeColumn(columnData);
		}
  		
  		if(!this.actionColumns.isEmpty()) {
	  		tree.addListener(SWT.MouseDown, new Listener() {
				private static final long serialVersionUID = 1L;
				@Override
				public void handleEvent(Event event) {
					Point pt = new Point(event.x, event.y);
					Rectangle clientArea = tree.getClientArea();
					Queue<TreeItem> itemsQueue = new LinkedList<TreeItem>(Arrays.asList(tree.getItems()));	//a lo ancho
					boolean handled = false;
					while(!itemsQueue.isEmpty() && !handled) {
						TreeItem treeItem = (TreeItem) itemsQueue.poll();
						itemsQueue.addAll(Arrays.asList(treeItem.getItems()));					
						boolean visible = false;
						int firstActionColumnIndex = actionColumns.get(0).getIndex();
						for(int j = firstActionColumnIndex; j < tree.getColumnCount(); j++) {
							Rectangle cellBounds = treeItem.getBounds(j);
							if(cellBounds.contains(pt)) {														
								Column actionColumn = actionColumns.get(j - firstActionColumnIndex);
								TreeColumnEvent eventData = new TreeColumnEvent();
								eventData.item = treeItem;
								eventData.source = self;
								eventData.entity = (IGridViewEntity)treeItem.getData("entity");
								eventData.showEditableArea = true;
								selectedEntity = eventData.entity;
								actionColumn.fireListeners(eventData);
								handled = true;
								break;
							}
							if(!visible && cellBounds.intersects(clientArea)) {
								visible = true;
							}
							if(!visible) {
								break;
							}
						}				
					}
				}
	  		});
  		}
  		
  		tree.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent event) {
				if(!event.item.isDisposed()) {
					selectedEntity = ((IGridViewEntity)event.item.getData("entity"));
				}
				else {
					selectedEntity = null;
				}
			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {				
			}
		});
  		
  		/*this.paginationComposite = new Composite(treeContainer, SWT.BORDER);
  		this.paginationComposite.setLayout(new FormLayout());
  		
  		FormDatas.attach(this.paginationComposite).atTopTo(this.tree).atLeft(0).atRight(0);
  		
  		Button first = new Button(this.paginationComposite, SWT.PUSH);
  		first.setText("<<");
  		FormDatas.attach(first).atTop(0).atLeft(0);
  		
  		Button before = new Button(this.paginationComposite, SWT.PUSH);
  		before.setText("<");
  		FormDatas.attach(before).atTop(0).atLeftTo(first);*/
  		
  		this.addControlListener(new ControlListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void controlResized(ControlEvent event) {
				CRUDTreeTable.this.controlResized(event);
			}			
			@Override
			public void controlMoved(ControlEvent arg0) {	
			}
		});
	
  		
	}
	
	private TreeColumn createTreeColumn(Column columnData) {		
		final TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(20);
		treeColumn.setData("percent", columnData.getPercentWidth());
		treeColumn.setMoveable(columnData.getMoveable());
		treeColumn.setAlignment(columnData.getAlignment());
		treeColumn.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
				Tree tree = treeColumn.getParent();
				if(treeColumn == tree.getSortColumn()) {
					if(tree.getSortDirection() == SWT.UP) {
						tree.setSortDirection(SWT.DOWN);
					}
					else {
						tree.setSortDirection(SWT.UP);
					}
				}
				else {
					tree.setSortColumn(treeColumn);
					tree.setSortDirection(SWT.DOWN);
				}
				//sort
				//int[] columnOrder = tree.getColumnOrder();
			}			
			@Override
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent arg0) {				
			}
		});
		return treeColumn;
	}
	
	public TreeItem addRow(IGridViewEntity entity){
		TreeItem item = new TreeItem(tree, SWT.NONE);
		this.initializeTableItem(item, entity);
		return item;
	}
	
	public TreeItem addInnerRow(TreeItem parentItem, IGridViewEntity entity){
		IGridViewEntity parentEntity = (IGridViewEntity) parentItem.getData("entity");
		parentEntity.addChild(entity);
		TreeItem item = new TreeItem(parentItem, SWT.NONE);
		this.initializeTableItem(item, entity);
		return item;
	}
	
	public List<IGridViewEntity> getRows() {
    	List<IGridViewEntity> result = new LinkedList<IGridViewEntity>();
    	for(TreeItem treeItem : this.tree.getItems()) {
    		result.add((IGridViewEntity) treeItem.getData("entity"));
    	}
    	return result;
    }
	
	private void initializeTableItem(TreeItem item, IGridViewEntity entity) {
		for(int i = 0; i < this.columns.size(); i++) {
			Column columnData = this.columns.get(i);
			String text = String.valueOf(columnData.getCellData(entity));
			if(text.toLowerCase() == "true" || text.toLowerCase() == "false") {
				Image img = Boolean.parseBoolean(text)? checkedImg : uncheckedImg;
				item.setImage(i, img);
			}
			else {
				item.setText(i, text);			
			}	
			item.setData(String.valueOf(i), text);
		}
		
		for(int i = 0; i < actionColumns.size(); i++) {
			Column actionColumn = actionColumns.get(i);
			item.setImage(actionColumn.getIndex(), actionColumn.getImage());
		}
		
		item.setData("entity", entity);
	}
	
	public List<IGridViewEntity> getEntities() {
		List<IGridViewEntity> result = new LinkedList<IGridViewEntity>();
		for(TreeItem treeItem : this.tree.getItems()) {
			result.add((IGridViewEntity) treeItem.getData("entity"));
		}
		return result;
	}

	public void refresh() {
		tree.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		tree.getShell().layout(true, true);
		tree.getShell().redraw();
		tree.getShell().update();
	}
	
	private void controlResized(ControlEvent event) {
		//if(!this.internalRefresh) {
			int actionsWidth = this.actionColumns.size() * 20;
			int parentWidth = this.getSize().x - actionsWidth - 10;
			for(TreeColumn treeColumn : this.treeColumns) {	
				int percent = (int)treeColumn.getData("percent");
				int percentWidth = (int)(percent * parentWidth / 100);
				treeColumn.setWidth(percentWidth);
			}
	
			int searchWidth = 40 * parentWidth / 100;
			
			if(searchWidth > 300) {
				searchWidth = 300;
			}
			else if(searchWidth < 100) {
				searchWidth = 100;
			}
			
			if(this.searchItem != null) {
				this.searchItem.setWidth(searchWidth);
			}
					
			/*int treeWidth = this.tree.getSize().x;
			int difference = parentWidth - treeWidth;
			int lastColumnWidth = this.lastDataColumn.getWidth();
			this.lastDataColumn.setWidth(lastColumnWidth + difference);*/
			this.refresh();
		//}
	}

	public void setEntityClass(Class<? extends IGridViewEntity> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void setColumnHeaders(List<String> headers) {
		this.columnHeaders = headers;
		for(int i = 0; i < this.treeColumns.size(); i++) {
			treeColumns.get(i).setText(columnHeaders.get(i));
		}
	}
	
	public List<String> getColumnHeaders() {
		return this.columnHeaders;
	}
	
	public void setCancelButtonText(String text) {
		this.cancelButtonText = text;
		if(this.cancelButton != null) {
			this.cancelButton.setText(text);
		}
	}
	
	public void setAddButtonText(String text) {
		this.addButtonText = text;
		if(this.addButton != null) {
			this.addButton.setText(text);
		}
	}
	
	public void setSearchHintText(String text) {
		this.searchHintText = text;
		if(this.searchText != null) {
			this.searchText.setMessage(text);
		}
	}
	
	public void setSaveAllButtonText(String text) {
		this.saveAllButtonText = text;
		if(this.saveAllButton != null) {
			this.saveAllButton.setText(text);
			refresh();
		}
	}
	
	public void setAdd(boolean add, IEditableArea editableArea) {
		this.add = add;
		this.addArea = editableArea;
	}
	
	public void setWatch(boolean watch, IEditableArea editableArea) {
		this.watch = watch;
		this.watchArea = editableArea;
	}
	
	public void setUpdate(boolean update, IEditableArea editableArea) {
		this.update = update;
		this.updateArea = editableArea;
	}
	
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
	public void setSearch(boolean search) {
		this.search = search;
	}
	
	public void setSaveAll(boolean saveAll) {
		this.saveAll = saveAll;
	}
    
	public IGridViewEntity getSelectedEntity() {
		return selectedEntity;
	}
	
    public void setCustomActionColumns(List<Column> actionColumns) {
    	this.actionColumns = actionColumns;
    }
    
    public void addActionColumn(Column column) {
		this.actionColumns.add(column);
		column.addListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				if(event.showEditableArea) {
					selectedTreeItem = event.item;
		    		selectedEntity = (IGridViewEntity) selectedTreeItem.getData("entity");
					createEditableArea(event.editableArea, event.entity, visualEntityManager);
				}
			}
		});
	}
    
    public void createUpdateArea(IGridViewEntity entity, final TreeItem treeItem) {
    	if(this.updateArea != null) {
    		this.selectedTreeItem = treeItem;
    		//this.selectedEntity = entity;
    		createEditableArea(this.updateArea, entity, this.visualEntityManager);
    	}
    }
    
    public void createAddArea() {
    	this.selectedTreeItem = null;
    	//this.selectedEntity = null;    	
    	if(this.addArea != null) {
    		destroyEditableArea();
    		createEditableArea(this.addArea, null, this.visualEntityManager);
    	}
    }
        
    private void destroyEditableArea() {
    	if(this.editionVisible) {
	    	this.editionComposite.dispose();
	    	this.editionComposite = null;
	    	refresh();
	    	this.editionVisible = false;
	    	this.cancelButton = null;
    	}
    }    
   
    private void createEditableArea(IEditableArea area, IGridViewEntity entity, IVisualEntityManager manager) {
    	destroyEditableArea();
    	if(!this.editionVisible) {
    		if(area != null) {
	    		this.editionComposite = new Composite(this.clientComposite, SWT.BORDER);
				this.editionComposite.setLayout(new FormLayout());
				FormDatas.attach(this.editionComposite).atTopTo(this.contentComposite, 5).atLeft(0).atRight(0);
				
				Composite editionControls = new Composite(this.editionComposite, SWT.NONE); 
				editionControls.setLayout(new FormLayout());
				FormDatas.attach(editionControls).atTop(0).atLeft(0).atRight(0);
				
				Composite editionButtons = new Composite(this.editionComposite, SWT.NONE);
				editionButtons.setLayout(new RowLayout());
				FormDatas.attach(editionButtons).atTopTo(editionControls).atLeft(0).atRight(0);
			
				area.createUI(editionControls, entity, manager);
				area.createButtons(editionButtons, entity, manager);
				this.activeArea = area;				
			
				if(area.closable()) {
					Button closeBtn = new Button(editionButtons, SWT.PUSH);
					closeBtn.setText(this.cancelButtonText);
					
					closeBtn.addSelectionListener(new SelectionListener() {
						private static final long serialVersionUID = 1L;
						@Override
						public void widgetSelected(SelectionEvent event) {
							destroyEditableArea();
						}				
						@Override
						public void widgetDefaultSelected(SelectionEvent event) {
							//do nothing					
						}
					});
					
					this.cancelButton = closeBtn;
				}
				
				Point editionSize = this.editionComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
				Point parentSize = this.parent.getSize();
				this.parent.setSize(parentSize.x, parentSize.y + editionSize.y);
				this.parent.getShell().layout(true, true);
				this.parent.getShell().redraw();
				this.parent.getShell().update();
				this.editionVisible = true;
				
				this.clientComposite.layout(true, true);
				this.clientComposite.redraw();
				this.clientComposite.update();
				
				this.editionComposite.addDisposeListener(new DisposeListener() {
					private static final long serialVersionUID = 1L;
	
					@Override
					public void widgetDisposed(DisposeEvent event) {
						parent.pack();
						
					}
				});

				this.activeArea.l10n();
				this.refresh();
			}
    	}
    }
    
    private void saveEntity(TreeItem treeItem, IGridViewEntity entity) {
    	for(int i = 0; i < columns.size(); i++) {
			try {
				Column column = columns.get(i);
				String text = String.valueOf(column.getCellData(entity));
				if(text.toLowerCase() == "true" || text.toLowerCase() == "false") {
					Image img = Boolean.parseBoolean(text)? checkedImg : uncheckedImg;
					treeItem.setImage(i, img);
				}
				else {
					treeItem.setText(i, text);
					System.out.println("seteado texto: " + text + " en la columna " + i);
				}
				treeItem.setData(String.valueOf(i), text);
			}
			catch(Exception e) {
			}
		}
    	treeItem.setData("entity", entity);
    }

    private void createDefaultActionColumns() {
    	this.watchColumn = new Column(parent.getDisplay(), "eye.png", watchArea, new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				if(event.showEditableArea) {
					selectedTreeItem = event.item;
		    		selectedEntity = (IGridViewEntity) selectedTreeItem.getData("entity");
					createEditableArea(event.editableArea, event.entity, visualEntityManager);
				}
			}
		});
    	this.updateColumn = new Column(parent.getDisplay(), "update.png", updateArea, new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				if(event.showEditableArea) {
					selectedTreeItem = event.item;
		    		selectedEntity = (IGridViewEntity) selectedTreeItem.getData("entity");
					createEditableArea(event.editableArea, event.entity, visualEntityManager);
				}
			}
		});
    	this.deleteColumn = new Column(parent.getDisplay(), "delete.png", new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				if(event.performDelete) {
					event.item.dispose();
					event.source.refresh();
				}
			}
		});
    	if(watch) {
    		this.actionColumns.add(watchColumn);
    	}
    	if(this.update) {
    		this.actionColumns.add(updateColumn);
    	}
    	if(this.delete) {
	    	this.actionColumns.add(deleteColumn);
    	}
    }
    
    public void addUpdateListener(TreeColumnListener listener) {
    	this.updateColumn.addListener(listener);    	
    }
    
    public void addDeleteListener(TreeColumnListener listener) {
    	//TODO: me quede aqui, da null pointer exception.
    	System.out.println("Delete COlumn: " + deleteColumn);
    	this.deleteColumn.addListener(listener);
    }
    
    public void clearRows() {
    	for(TreeItem treeItem : this.tree.getItems()) {
    		treeItem.dispose();
    	}
    	this.refresh();
    }
    
    public String[][] getCellValues() {
    	String[][] result = new String[this.tree.getItems().length][this.columnHeaders.size()];    	
    	for(int i = 0; i < this.tree.getItems().length; i++) {
    		for(int j = 0; j < this.columnHeaders.size(); j++) {
    			result[i][j] = this.tree.getItem(i).getText(j);
    		}
    	}
    	return result;
    }

    public void addActionButton(String key, ButtonData buttonData) {
    	this.actionButtonsData.put(key, buttonData);
    }
    
    public void setActionButtonText(String key, String text) {
    	this.actionButtons.get(key).setText(text);
    }
    
    public void l10n() {
    	if(this.activeArea != null) {
    		this.activeArea.l10n();
    	}
    	this.refresh();
    }
    
	private class MethodComparator implements Comparator<Method>
    {
		@Override
		public int compare(Method m1, Method m2) {
			TreeTableColumn ann1 = m1.getAnnotation(TreeTableColumn.class);
			TreeTableColumn ann2 = m2.getAnnotation(TreeTableColumn.class);
			if(ann1 != null && ann2 != null) {
				if(ann1.index() > ann2.index()) {
					return 1;
				}
				else if(ann1.index() < ann2.index()) {
					return -1;
				}
			}
			else if(ann1 != null && ann2 == null) {
				return 1;
			}
			else if(ann1 == null && ann2 != null) {
				return -1;
			}			
			return 0;
		}    	
    }
}