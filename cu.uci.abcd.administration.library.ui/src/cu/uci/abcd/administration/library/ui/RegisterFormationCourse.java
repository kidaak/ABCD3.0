package cu.uci.abcd.administration.library.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.communFragment.RegisterFormationCourseFragment;
import cu.uci.abcd.administration.library.communFragment.RegisterWorkerFragment;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.administration.library.ui.model.FormationCourseAddArea;
import cu.uci.abcd.administration.library.ui.model.WorkerAddArea;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.management.security.ILoginService;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.IVisualEntityManager;

public class RegisterFormationCourse implements IContributor{
	
	//IVisualEntityManager manager;
	//IGridViewEntity entity;
	private IViewController controller;
	
	@Override
	public Control createUIControl(Composite shell) {
		ILoginService log = (ILoginService) RWT.getUISession().getAttribute("loginService"); 
		Library library = (Library) log.getSecurityDataStore().getSecurityDataObject("library");
				
		RegisterFormationCourseFragment registerFormationCourse =  new RegisterFormationCourseFragment(controller, library, null);
		return registerFormationCourse.createUIControl(shell);
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "RegistrarCursoFormacionID";
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Registrar Curso de Formacion";
	}

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
	}

}
