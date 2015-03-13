package cu.uci.abcd.administration.library.ui.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;

import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class CoinGrid implements IGridViewEntity {

	private Coin coin;
	
	public CoinGrid(Coin coin) {
		super();
		this.setCoin(coin);
	}
	
	public CoinGrid() {
	}
	@TreeTableColumn(percentWidth = 25, index=0)
	public String getCoinName() {
		return getCoin().getNomenclatorDescription();
	}
	@TreeTableColumn(percentWidth = 25, index=1)
	public String getNomenclatorCode() {
		return getCoin().getNomenclatorCode().toString();
	}
	@TreeTableColumn(percentWidth = 25, index=2)
	public BigDecimal getExchangeRate() {
		return getCoin().getExchangeRate();
	}
	@TreeTableColumn(percentWidth = 25, index=3)
	public Date getUpdatedDate() {
		return getCoin().getUpdatedDate();
	}
	
	@Override
	public void addChild(IGridViewEntity child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	public Coin getCoin() {
		return coin;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}
	
	
}
