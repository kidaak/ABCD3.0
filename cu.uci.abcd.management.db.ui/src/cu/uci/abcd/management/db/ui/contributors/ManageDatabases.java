package cu.uci.abcd.management.db.ui.contributors;

import java.util.List;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import controller.ManageDatabasesController;
import cu.uci.abos.l10n.management.db.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class ManageDatabases implements IContributor {

	private IViewController controller;

	private Label databaseNameLabel;
	private Text databaseNameInputText;
	private Button queryBtn;
	private Button newBtn;
	private Button newSearchBtn;
	private Button cancelBtn;
	private Label buttonSeparator;
	private Label databaseHitsLabel;
	private GridColumn column;
	private List<String> databases;
	private TableViewerColumn databasesColumn;

	@Override
	public Control createUIControl(Composite parent) {
		Composite com = new Composite(parent, SWT.BORDER);
		Composite composite = new Composite(com, SWT.CENTER);
		FormLayout layout = new FormLayout();
		com.setLayout(layout);
		parent.setLayout(layout);
		composite.setLayout(layout);

		com.setData(RWT.CUSTOM_VARIANT, "gray_background");
		composite.setData(RWT.CUSTOM_VARIANT, "gray_background");

		FormDatas.attach(com).atLeftTo(parent, 0);

		databaseNameLabel = new Label(composite, SWT.NONE);
		databaseNameLabel.setText(AbosMessages.get().MANAGE_DATABASES_DATABASE_NAME_LABEL);
		FormDatas.attach(databaseNameLabel).atLeft(10).atTop(10);

		databaseNameInputText = new Text(composite, 0);
		FormDatas.attach(databaseNameInputText).atTopTo(databaseNameLabel, 10).atLeftTo(composite, 10).withWidth(200);

		buttonSeparator = new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR);
		FormDatas.attach(buttonSeparator).atTopTo(databaseNameInputText, 10).withWidth(1000);

		queryBtn = new Button(composite, SWT.PUSH | SWT.CENTER);
		queryBtn.setText(AbosMessages.get().BUTTON_CONSULT);
		FormDatas.attach(queryBtn).atTopTo(databaseNameInputText, 20).atLeftTo(composite, 550);

		newSearchBtn = new Button(composite, SWT.PUSH | SWT.CENTER);
		newSearchBtn.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		FormDatas.attach(newSearchBtn).atLeftTo(queryBtn, 10).atTopTo(databaseNameInputText, 20);

		newBtn = new Button(composite, SWT.PUSH | SWT.CENTER);
		newBtn.setText(AbosMessages.get().BUTTON_NEW);
		FormDatas.attach(newBtn).atLeftTo(newSearchBtn, 10).atTopTo(databaseNameInputText, 20);

		cancelBtn = new Button(composite, SWT.PUSH | SWT.CENTER);
		cancelBtn.setText(AbosMessages.get().BUTTON_CANCEL);
		FormDatas.attach(cancelBtn).atLeftTo(newBtn, 10).atTopTo(databaseNameInputText, 20);

		databaseHitsLabel = new Label(composite, SWT.None);
		databaseHitsLabel.setText(AbosMessages.get().LABEL_DATABASE_HITS);
		FormDatas.attach(databaseHitsLabel).atTopTo(queryBtn, 20).atLeft(10);

		databases = ((ManageDatabasesController) controller).getDatabaseNames();

		Grid hitsTable2 = new Grid(composite, SWT.BORDER | SWT.FULL_SELECTION | RWT.CELL);
		hitsTable2.setFooterVisible(true);
		hitsTable2.setHeaderVisible(true);

		column = new GridColumn(hitsTable2, SWT.NONE);
		column.setText(AbosMessages.get().MANAGE_DATABASES_DATABASE_NAME_LABEL);
		column.setWidth(800);
		column.setFooterText(AbosMessages.get().DATABASE_MANAGEMENT_TOTAL + ": " + String.valueOf(databases.size()));
		column.setSort(SWT.DOWN);

		for (int i = 0; i < databases.size(); i++) {
			final GridItem item = new GridItem(hitsTable2, SWT.NONE);
			item.setText(0, databases.get(i));
		}

		FormDatas.attach(hitsTable2).atTopTo(databaseHitsLabel, 10).atLeft(10).withWidth(990);

		return parent;
	}

	@Override
	public String getID() {
		return "AdministrarBaseDatoID";
	}

	@Override
	public void l10n() {
		databaseNameLabel.setText(AbosMessages.get().MANAGE_DATABASES_DATABASE_NAME_LABEL);
		queryBtn.setText(AbosMessages.get().BUTTON_CONSULT);
		newSearchBtn.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		databaseHitsLabel.setText(AbosMessages.get().LABEL_DATABASE_HITS);
		column.setFooterText(AbosMessages.get().DATABASE_MANAGEMENT_TOTAL + ": " + String.valueOf(databases.size()));
		column.setText(AbosMessages.get().MANAGE_DATABASES_DATABASE_NAME_LABEL);
	}

	@Override
	public String contributorName() {
		return AbosMessages.get().DATABASE_MANAGEMENT_HEADER;
	}

	@Override
	public boolean canClose() {
		return true;
	}

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;

	}
}
