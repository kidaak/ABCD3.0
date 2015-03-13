package cu.uci.abos.platform.tracker;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abos.platform.domain.MenuEntity;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IContributorService;
import cu.uci.abos.ui.api.IContributorTracker;

public class TreeMenuContributorTracker implements IContributorTracker {

	private ExpandBar expandBar;
	private IContributorService service;
	private Map<String, ExpandItem> expandItems;
	private Map<String, MenuEntity> menuStructure;
	private Map<String, TreeItem> treeItems;
	private Map<String, TreeItem> treeItemsLeaf;
	private Map<String, Tree> treeMap;

	public TreeMenuContributorTracker(ExpandBar expandBar,
			IContributorService service, Map<String, MenuEntity> MenuStructure) {
		super();
		this.expandBar = expandBar;
		this.service = service;
		this.menuStructure = MenuStructure;
		this.expandItems = new HashMap<String, ExpandItem>();
		treeItems = new HashMap<String, TreeItem>();
		treeMap = new HashMap<String, Tree>();
		treeItemsLeaf = new HashMap<String, TreeItem>();

	}

	@Override
	public void uiContributorAdded(final IContributor contributor) {
		expandBar.getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {

				String contribution = contributor.getID();
				
	System.out.println("Contribution: " + contribution);
				
				
				if (menuStructure.get(contribution) != null) {
					MenuEntity menuEntity = (MenuEntity) menuStructure
							.get(contribution);
					String module = menuEntity.containerMenu;
					
	//System.out.println("Functionality: " + menuEntity.functionality);

					ExpandItem menuItem = expandItems.get(module);
					// pregunto si el modulo ya existe
					if (menuItem == null) {
						// en caso de que el modulo no se haya creado, lo
						// creamos
						creatExpandItem(menuEntity);

						// adicionamos las categorias al modulo, asi como sus
						// funcionalidades
						createCategories(menuEntity, contributor);

					} else {

						createCategories(menuEntity, contributor);

					}

				}

			}
		});
	}

	@Override
	public void uiContributorRemoved(IContributor contributor) {

	}

	Integer calculateHeigth(TreeItem[] items) {
		Integer functionality = 0;
		Integer category = 0;

		for (int i = 0; i < items.length; i++) {
			Integer childrens = items[i].getItemCount();
			category = category + 40;
			functionality = functionality + (childrens * 30);

		}
		return functionality + category;
	}

	void TreeSelectionListener(Tree tree, final IContributor contributor) {
		tree.addSelectionListener(new SelectionListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				TreeItem treeItem = (TreeItem) arg0.item;

				IContributor contributorId = (IContributor) treeItem
						.getData(contributor.contributorName());
				if (contributorId != null) {
					treeItem.setText(contributor.contributorName());
					service.selectContributor(contributor.getID());

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

	}

	private void createCategories(MenuEntity menuEntity,
			IContributor contributor) {
		String category = menuEntity.containerCategory;
		String module = menuEntity.containerMenu;
		final String contribution = menuEntity.functionality;

		// pregunto si la categoria ya esta creada
		TreeItem treeItemCategory = treeItems.get(category + module);
		if (treeItemCategory == null) {
			// si la categoria no esta creada se adiciona al árbol.
			Tree root = treeMap.get(module);
			treeItemCategory = new TreeItem(root, SWT.NORMAL);
			treeItemCategory.setText(category);
			treeItemCategory.setData(category, menuEntity.containerCategoryId);

			// por último se debe adicionar la funcionalidad dentro de la
			// categoria y el módulo que corresponde
			if (treeItemsLeaf.get(contributor.getID()) == null) {
				TreeItem functionItem = new TreeItem(treeItemCategory,
						SWT.NORMAL);

				functionItem.setText(contributor.contributorName());

				functionItem
						.setData(contributor.contributorName(), contributor);
				functionItem.getParentItem().setExpanded(true);
				TreeSelectionListener(functionItem.getParent(), contributor);

				treeItems.put(category + module, treeItemCategory);
				treeItemsLeaf.put(contributor.getID(), functionItem);
				TreeItem[] childItems = functionItem.getParent().getItems();
				Integer sizeInteger = calculateHeigth(childItems);
				expandItems.get(module).setHeight(sizeInteger);

			}

		} else {

			if (treeItemsLeaf.get(contribution) == null) {
				TreeItem functionItem = new TreeItem(treeItemCategory,
						SWT.NORMAL);

				functionItem.setText(contributor.contributorName());
				functionItem
						.setData(contributor.contributorName(), contributor);
				functionItem.getParentItem().setExpanded(true);
				TreeSelectionListener(functionItem.getParent(), contributor);

				treeItems.put(category + module, treeItemCategory);
				treeItemsLeaf.put(contributor.getID(), functionItem);
				TreeItem[] childItems = functionItem.getParent().getItems();
				Integer sizeInteger = calculateHeigth(childItems);
				expandItems.get(module).setHeight(sizeInteger);
			}
		}

	}

	private void creatExpandItem(MenuEntity menuEntity) {

		String module = menuEntity.containerMenu;

		ExpandItem expandItem = new ExpandItem(expandBar, SWT.NONE);
		expandItem.setText(module);
		expandItem.setData(module, menuEntity.containerMenuId);

		Tree tree = treeMap.get(module);
		// pregunto si ya se creo el arbol del modulo
		if (tree == null) {
			tree = new Tree(expandBar, SWT.NORMAL);
			expandItem.setControl(tree);
			treeMap.put(module, tree);

		} else {

			expandItem.setControl(tree);
		}

		expandItem.setExpanded(true);
		expandItems.put(module, expandItem);

	}

}
