package cu.uci.abcd.administration.library.ui;


import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import cu.uci.abcd.administration.library.communFragment.RegisterWorkerFragment;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.management.security.ILoginService;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class RegisterWorkerLibrary implements IContributor{
	private IViewController controller;
	
	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
	}
	
	@Override
	public String contributorName() {
		return "Registrar Trabajador";
	}

	@Override
	public String getID() {
		return "RegistrarTrabajadoresBibliotecaID";
	}

	@Override
	public Control createUIControl(Composite shell) {
		
		ILoginService log = (ILoginService) RWT.getUISession().getAttribute("loginService"); 
		Library library = (Library) log.getSecurityDataStore().getSecurityDataObject("library");
		
		RegisterWorkerFragment registerWorker =  new RegisterWorkerFragment(controller, library, null);
		return registerWorker.createUIControl(shell);
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
	}
}
