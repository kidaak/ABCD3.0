package cu.uci.abcd.circulation.ui.model;

import java.util.List;

import cu.uci.abcd.domain.common.Gender;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class PersonGrid extends Person implements IGridViewEntity {

	private String dNI;
	private String firstName;

	
	public PersonGrid(Long id, String firstName, String dni, Gender gender) {
		super();
		this.setActorID(id);
		this.setFirstName(firstName);
		this.setDNI(dni);
		this.setGender(gender);
		//this.set
	}
	
	public PersonGrid() {
	}
	@TreeTableColumn(percentWidth = 49, index=0)
	public String getDNI() {
		return super.getDNI();
	}
	@TreeTableColumn(percentWidth = 50, index=1)
	public String getFirstName() {
		return super.getFirstName();
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
