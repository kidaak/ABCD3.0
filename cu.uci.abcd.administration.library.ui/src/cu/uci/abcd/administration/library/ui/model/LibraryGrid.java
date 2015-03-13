package cu.uci.abcd.administration.library.ui.model;

import java.util.Collection;
import java.util.List;

import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.domain.common.Address;
import cu.uci.abcd.domain.common.PostalAddress;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class LibraryGrid implements IGridViewEntity {
	private Library library;

	
	public LibraryGrid(Library library) {
		super();
		this.library =  library;
	}
	
	public LibraryGrid() {
		
	}
	
	@TreeTableColumn(percentWidth = 40, index=0)
	public String getLibraryName() {
		return getLibrary().getLibraryName();
	}
	
	@TreeTableColumn(percentWidth = 30, index=1)
	public String getLibrarySurface() {
		return (!(getLibrary().getLibrarySurface() == null))?getLibrary().getLibrarySurface().toString():"";
	}
	
	@TreeTableColumn(percentWidth = 30, index=2)
	public String getLibraryRoomQuantity() {
		return (!(getLibrary().getRoomQuantity() == null))?getLibrary().getRoomQuantity().toString():"";
	}
	
	
	@Override
	public void addChild(IGridViewEntity child) {
		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		return null;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	
}
