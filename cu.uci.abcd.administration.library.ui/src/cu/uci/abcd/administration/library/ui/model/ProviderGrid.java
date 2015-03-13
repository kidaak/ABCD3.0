package cu.uci.abcd.administration.library.ui.model;

import java.util.List;

import cu.uci.abcd.domain.common.EntityState;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abcd.domain.management.library.ProviderType;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class ProviderGrid implements IGridViewEntity {

	private Provider provider;
	
	public ProviderGrid(Provider provider) {
		super();
		this.provider = provider;
	}
	
	public ProviderGrid() {
		
	}
	
	@TreeTableColumn(percentWidth = 40, index=0)
	public String getProviderName() {
		return getProvider().getProviderName();
	}
	
	@TreeTableColumn(percentWidth = 30, index=1)
	public String getProviderIdentification() {
		return getProvider().getRIF_NIT();
	}
	
	@TreeTableColumn(percentWidth = 30, index=2)
	public String getProviderEstate() {
		return getProvider().getProviderState().toString();
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public void addChild(IGridViewEntity arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
