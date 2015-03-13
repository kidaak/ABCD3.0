package cu.uci.abcd.circulation.ui.model;

import java.util.Date;
import java.util.List;


import cu.uci.abos.widgets.grid.IGridViewEntity;

public class RegisterSanctionView implements IGridViewEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterSanctionView(String penaltyType, Date penaltyDate, Integer suspensionDays, 
			String motive, Integer delaymentCost) {
		super();
		
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

	
}
