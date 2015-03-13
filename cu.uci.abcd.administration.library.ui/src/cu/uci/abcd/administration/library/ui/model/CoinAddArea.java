package cu.uci.abcd.administration.library.ui.model;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.ui.controller.CoinViewController;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IEditableArea;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

import java.math.BigDecimal;
import java.sql.Date;


public class CoinAddArea implements IEditableArea {

	private IViewController controller;
	
	Text coinNameText;
	Label coinNameLabel;
	Label coinIdLabel;
	Text coinIdText;
	Label exchangeRateLabel;
	Text exchangeRateText;
	
	public CoinAddArea(IViewController controller) {
		this.controller = controller;
	}
	
	@Override
	public Composite createUI(Composite shell, IGridViewEntity entity,
			IVisualEntityManager manager) {
		// TODO Auto-generated method stub
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(shell).atLeft(0).atRight(0);
		Composite test = new Composite(shell, SWT.NORMAL);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test.setLayout(form);
		FormDatas.attach(test).atLeft(0).atRight(0);
		Label lblCriiteriosDeBsqueda = new Label(test, SWT.NONE);
		lblCriiteriosDeBsqueda.setText("Datos de la Moneda");
		FormDatas.attach(lblCriiteriosDeBsqueda).atTopTo(test, 10).atLeft(10);

		coinNameLabel = new Label(test, SWT.NONE);
		coinNameLabel.setText("Nombre de la Moneda");
		FormDatas.attach(coinNameLabel).atTopTo(lblCriiteriosDeBsqueda,
				10).atLeft(10);

		coinNameText = new Text(test, SWT.BORDER);
		FormDatas.attach(coinNameText).atTopTo(coinNameLabel, 10).withWidth(200).atLeft(10);
		
		coinIdLabel = new Label(test, SWT.NONE);
		coinIdLabel.setText("Identificador");
		FormDatas.attach(coinIdLabel).atLeftTo(coinNameText, 45)
				.atTopTo(lblCriiteriosDeBsqueda, 10);
		
		coinIdText = new Text(test, SWT.BORDER);
		FormDatas.attach(coinIdText).atLeftTo(coinNameText, 45).atTopTo(coinIdLabel, 10).withWidth(200);

		
		exchangeRateLabel = new Label(test, SWT.NONE);
		exchangeRateLabel.setText("Taza de Cambio");
		FormDatas.attach(exchangeRateLabel).atLeftTo(coinIdText, 45)
				.atTopTo(lblCriiteriosDeBsqueda, 10);

		

		
		exchangeRateText = new Text(test, SWT.BORDER);
		FormDatas.attach(exchangeRateText).atLeftTo(coinIdText, 45).atTopTo(coinIdLabel, 10).withWidth(200);


		Label espacio = new Label(test, SWT.NORMAL);
		FormDatas.attach(espacio).atTopTo(exchangeRateText, 5);
		
		return shell;

	}

	@Override
	public Composite createButtons(Composite parent, IGridViewEntity entity,
			final IVisualEntityManager manager) {
		Button saveBtn = new Button(parent, SWT.PUSH);
		saveBtn.setText("Registrar");
		
		saveBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String coinName = coinNameText.getText();
				String coinId = coinIdText.getText();
				BigDecimal exchangeRate = BigDecimal.valueOf(Double.parseDouble(exchangeRateText.getText()));
				
				java.util.Date fecha = new java.util.Date();
				Date updatedDate = new Date(fecha.getTime());
				
				Coin coin = new Coin();
				
				//CoinGrid coin = new CoinGrid(coinName, coinId, exchangeRate, updatedDate);
				
				//Coin auxCoin =  new Coin();
				//auxCoin.setExchangeRate(exchangeRate);
				//auxCoin.setNomeclatorName(coinId);
				//auxCoin.setNomenclatorCode(coinName);
				//auxCoin.setNomenclatorDescription(coinName);
				//auxCoin.setUpdatedDate(updatedDate);
				
				//Coin newCoin = ((CoinViewController) controller).SaveCoin(auxCoin);
				//coin.setNomenclatorID(newCoin.getNomenclatorID());
				
				//manager.add(coin);
				
				
				
				
			}
		});
		return parent;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Control getControl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
