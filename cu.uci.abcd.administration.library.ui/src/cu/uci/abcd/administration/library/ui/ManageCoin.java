package cu.uci.abcd.administration.library.ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abcd.administration.library.ui.controller.CoinViewController;
import cu.uci.abcd.administration.library.ui.controller.ProviderViewController;
import cu.uci.abcd.administration.library.ui.model.CoinAddArea;
import cu.uci.abcd.administration.library.ui.model.CoinUpdateArea;
import cu.uci.abcd.administration.library.ui.model.CoinViewArea;
import cu.uci.abcd.administration.library.ui.model._CoinUpdateArea;
import cu.uci.abcd.administration.library.ui.model.CoinGrid;
import cu.uci.abcd.administration.library.ui.model.LibraryAddArea;
import cu.uci.abcd.administration.library.ui.model.LibraryGrid;
import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.Column;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ManageCoin implements IContributor {

	private IViewController controller;
	FormLayout form;
	Composite parent;
	Label searchCriteriaLabel;
	Label coinNameLabel;
	Text coinNameText;
	Label identifierCoinLabel;
	Text identifierCoinText;
	Label separador;
	Button consultButton;
	Button newSearchButton;
	Button newButton;
	Button closeButton;
	Label coinListLabel;
	Table coinListTable;
	FillLayout bottomFillLayout;
	GridData bottomGridData;
	Composite bottomGroup;
	CRUDTreeTable tableCoin;
	Button exportPDFButton;
	Button exportExcelButton;
	List<Column> customActionColumns;

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Monedas";
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "AdministrarMonedasID";
	}

	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		form = new FormLayout();
		shell.setLayout(form);
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		parent = new Composite(shell, SWT.NORMAL);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		parent.setLayout(form);
		FormDatas.attach(parent).atLeftTo(shell, 10).atLeft(0).atRight(0);;
		searchCriteriaLabel = new Label(parent, SWT.NONE);
		FormDatas.attach(searchCriteriaLabel).atTopTo(parent, 10).atLeft(10);
		coinNameLabel = new Label(parent, SWT.NONE);
		FormDatas.attach(coinNameLabel).atTopTo(searchCriteriaLabel, 10).atLeft(10);
		coinNameText = new Text(parent, SWT.BORDER);
		FormDatas.attach(coinNameText).atTopTo(coinNameLabel, 10).atLeft(10).withWidth(200);
		identifierCoinLabel = new Label(parent, SWT.NONE);
		identifierCoinLabel.setLayoutData(new FormData());
		FormDatas.attach(identifierCoinLabel).atLeftTo(coinNameText, 40)
				.atTopTo(searchCriteriaLabel, 10);
		identifierCoinText = new Text(parent, SWT.BORDER);
		FormDatas.attach(identifierCoinText).atLeftTo(coinNameText, 40)
				.atTopTo(coinNameLabel, 10).withWidth(200);;
		separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(identifierCoinText, 10)
				.atLeft(5).atRight(5);
		newSearchButton = new Button(parent, SWT.NONE);
		FormDatas.attach(newSearchButton).atTopTo(separador, 10).atRight(5).withWidth(130);
		consultButton = new Button(parent, SWT.NONE);
		FormDatas.attach(consultButton).atTopTo(separador, 10).atRightTo(newSearchButton, 10).withWidth(130);
		coinListLabel = new Label(parent, SWT.NORMAL);
		FormDatas.attach(coinListLabel).atTopTo(newSearchButton, 10).atLeft(10).atRight(10);
		tableCoin = new CRUDTreeTable(parent, SWT.NONE);
		tableCoin.setEntityClass(CoinGrid.class);
		tableCoin.setAdd(true, new CoinAddArea(controller));
		tableCoin.setAddButtonText("Adicionar");
		tableCoin.setUpdate(true, new CoinUpdateArea());
		tableCoin.setWatch(true, new CoinViewArea());
		tableCoin.setDelete(true);
		tableCoin.setCancelButtonText("Cancelar");
		tableCoin.setColumnHeaders(Arrays.asList("Nombre", "Identificador", "Taza", "Fecha de Actualizacion"));		
		try {
			tableCoin.createTable();
		}
		catch(Exception e) {
		}
		FormDatas.attach(tableCoin).atTopTo(coinListLabel, 10).atLeft(5).atRight(5);	
		tableCoin.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
			
			}
		});
		
		tableCoin.addDeleteListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				
			}
		});
		exportPDFButton = new Button(parent, SWT.PUSH);
		FormDatas.attach(exportPDFButton).atTopTo(tableCoin, 10).atRight();
		exportExcelButton = new Button(parent, SWT.PUSH);
		FormDatas.attach(exportExcelButton).atTopTo(tableCoin, 10)
				.atRightTo(exportPDFButton, 10);
		l10n();
		InitializeCoinGrid();
		return shell;
	}

	private void InitializeCoinGrid() {
		Collection<Coin> list = ((CoinViewController) controller).findAllCoins();
		for (Coin coin : list) {
			CoinGrid aux = new CoinGrid(coin);
			tableCoin.addRow(aux);
		}
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		searchCriteriaLabel
				.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		//coinNameLabel.setText(AbosMessages.get().LABEL_NAME_COIN);
		//identifierCoinLabel.setText(AbosMessages.get().LABEL_IDENTIFIER_COIN);
		coinNameLabel.setText("Nombre de la moneda");
		identifierCoinLabel.setText("Identificador");
		consultButton.setText(AbosMessages.get().BUTTON_CONSULT);
		newSearchButton
				.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		coinListLabel.setText(AbosMessages.get().LABEL_LIST_OF_CURRENCY);
		exportPDFButton.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		exportExcelButton
				.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL));
	}

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
	}
}
