package cu.uci.abcd.administration.library.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abcd.administration.library.aux.Auxiliary;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.administration.library.ui.controller.ProviderViewController;
import cu.uci.abcd.administration.library.ui.model.FormationCourseAddArea;
import cu.uci.abcd.administration.library.ui.model.LibraryAddArea;
import cu.uci.abcd.administration.library.ui.model.LibraryGrid;
import cu.uci.abcd.administration.library.ui.model.PersonGrid;
import cu.uci.abcd.administration.library.ui.model.WorkerAddArea;
import cu.uci.abcd.administration.library.ui.model.WorkerGrid;
import cu.uci.abcd.administration.library.ui.model._ProviderUpdateArea;
import cu.uci.abcd.administration.library.ui.model.ProviderGrid;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.Column;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class SearchPerson implements IContributor{
	
	private IViewController controller;
	private TabFolder tabFolder;
	//private Composite otherDatas;
	private Map<String, Control> controls = new HashMap<String, Control>();
	
	//private Label aaa;
	
	FormLayout form;
	CRUDTreeTable tablePerson;

	public SearchPerson(IViewController controller, TabFolder tabFolder, Map<String, Control> controls) {
		this.controller = controller;
		this.tabFolder = tabFolder;
		this.controls = controls;
	}
	
	
	public Control createUIControl(final Composite parent) {
		final Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new FormLayout());
		result.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		Label searchCriteriaLabel = new Label(result, SWT.NONE);
		searchCriteriaLabel.setLayoutData(new FormData());
		searchCriteriaLabel.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		FormDatas.attach(searchCriteriaLabel).atTopTo(result, 10).atLeft(10);
		
		Label firstNamePersonaLabel = new Label(result, SWT.NONE);
		firstNamePersonaLabel.setLayoutData(new FormData());
		firstNamePersonaLabel.setText("Primer Nombre");
		FormDatas.attach(firstNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeft(10);
		
		Text firtNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(firtNamePersonaText).atTopTo(firstNamePersonaLabel, 10).atLeft(10).withWidth(180);;
		
		
		Label secondNamePersonaLabel = new Label(result, SWT.NONE);
		secondNamePersonaLabel.setLayoutData(new FormData());
		secondNamePersonaLabel.setText("Segundo Nombre");
		FormDatas.attach(secondNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeftTo(firtNamePersonaText, 30);
		
		Text secondNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(secondNamePersonaText).atTopTo(secondNamePersonaLabel, 10).atLeftTo(firtNamePersonaText, 30).withWidth(180);
		
		Label firstLastNamePersonaLabel = new Label(result, SWT.NONE);
		firstLastNamePersonaLabel.setLayoutData(new FormData());
		firstLastNamePersonaLabel.setText("Primer Apellido");
		FormDatas.attach(firstLastNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeftTo(secondNamePersonaText, 30);
		
		Text firstLastNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(firstLastNamePersonaText).atTopTo(firstLastNamePersonaLabel, 10).atLeftTo(secondNamePersonaText, 30).withWidth(180);
		
		Label secondLastNamePersonaLabel = new Label(result, SWT.NONE);
		secondLastNamePersonaLabel.setLayoutData(new FormData());
		secondLastNamePersonaLabel.setText("Segundo Apellido");
		FormDatas.attach(secondLastNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeftTo(firstLastNamePersonaText, 30);
		
		Text secondLastNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(secondLastNamePersonaText).atTopTo(secondLastNamePersonaLabel, 10).atLeftTo(firstLastNamePersonaText, 30).withWidth(180);
		
		Label identificationPersonaLabel = new Label(result, SWT.NONE);
		identificationPersonaLabel.setLayoutData(new FormData());
		identificationPersonaLabel.setText("Identificacion");
		FormDatas.attach(identificationPersonaLabel).atTopTo(firtNamePersonaText, 10).atLeft(10);
		
		Text identificationPersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(identificationPersonaText).atTopTo(identificationPersonaLabel, 10).atLeft(10).withWidth(180);
		
		Label sexoPersonaLabel = new Label(result, SWT.NONE);
		sexoPersonaLabel.setLayoutData(new FormData());
		sexoPersonaLabel.setText("Sexo");
		FormDatas.attach(sexoPersonaLabel).atTopTo(firtNamePersonaText, 10).atLeftTo(identificationPersonaText,30);
		
		Text sexoPersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(sexoPersonaText).atTopTo(sexoPersonaLabel, 10).atLeftTo(identificationPersonaText, 30).withWidth(180);
		
		Label separator = new Label(result, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new FormData());
		FormDatas.attach(separator).atTopTo(sexoPersonaText, 10).atLeft(10).atRight(10);
		
		Button searchButton = new Button(result, SWT.NONE);
		searchButton.setLayoutData(new FormData());
		searchButton.setText("Buscar");
		FormDatas.attach(searchButton).atTopTo(separator, 10).atRight(10).withWidth(130);
		
		Label listLibraryLabel = new Label(result, SWT.NORMAL);
		listLibraryLabel.setLayoutData(new FormData());
		listLibraryLabel.setText("Lista de Personas Coincidentes");
		FormDatas.attach(listLibraryLabel).atTopTo(searchButton, 10).atLeft(10);
		
		tablePerson = new CRUDTreeTable(result, SWT.NONE);
		tablePerson.setEntityClass(PersonGrid.class);
		
		tablePerson.addActionColumn(new Column(parent.getDisplay(), "arrow_down.png", new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				PersonGrid entity = (PersonGrid) event.entity;
				//Control[] childrens = otherDatas.getChildren();
				//for (int i = 1; i < childrens.length; i=i+2) {
				    
				   controls.get("1").setVisible(false);
				   controls.get("2").setVisible(false);
				   
				   controls.get("3").setVisible(true);
				   controls.get("4").setVisible(true);
				   controls.get("5").setVisible(true);
				   
				   ((Label)controls.get("6")).setText(entity.getActorID().toString());
				   
				   
				   Table dataPersonTable = (Table) controls.get("4");
				   
				   dataPersonTable.getItem(0).setText(1,entity.getFirstName());
				   dataPersonTable.getItem(1).setText(1,entity.getDNI());
				   dataPersonTable.getItem(2).setText(1,entity.getGender().name());
				   //dataPersonTable.getItem(3).setText(1,entity.getBirthDate().toString());
				   
				   //childrens[3].getItem(0).setText(0,"");
				   
				   
				//}
				tabFolder.setSelection(0);
			}
		}));
		
		tablePerson.setColumnHeaders(Arrays.asList("Nombre", "Identificacion")); 																	
		try {
			tablePerson.createTable();
		} catch (Exception e) {
		}
		FormDatas.attach(tablePerson).atTopTo(listLibraryLabel, 10).atLeft(20)
				.atRight(20);
		tablePerson.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// IGridViewEntity entity = (IGridViewEntity) event.entity;
			}
		});
		tablePerson.addDeleteListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				// LibraryGrid pepe = (LibraryGrid) event.entity;
			}
		});
		InitializePersonGrid();
		    return result;
	}

	private void InitializePersonGrid() {
		// TODO Auto-generated method stub
		Collection<Person> list = new ArrayList<Person>();
		
		if( controller instanceof ProviderViewController ){
			list = ((ProviderViewController) controller).findAllPerson();
		}else{
			list = ((LibraryViewController) controller).findAllPerson();
		}
		
		
		
		for (Person person : list) {
			PersonGrid aux = new PersonGrid(person.getActorID(), person.getDNI(), person.getFirstName(), person.getGender());
			tablePerson.addRow(aux);
		}
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}


	@Override
	public void setViewController(IViewController arg0) {
		// TODO Auto-generated method stub
		
	}


	public Map<String, Control> getControls() {
		return controls;
	}


	public void setControls(Map<String, Control> controls) {
		this.controls = controls;
	}

	
}
