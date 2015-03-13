package cu.uci.abcd.circulation.ui.composite;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.circulation.ui.controller.AllManagementLoanUserViewController;
import cu.uci.abcd.circulation.ui.controller.LoanUserViewController;
import cu.uci.abcd.circulation.ui.model.PersonGrid;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.Column;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class SearchPerson {
	
	private IViewController controller;
	FormLayout form;
	static CRUDTreeTable tablePerson;
	private Composite compo;
	private TabFolder tabFolder;

	public SearchPerson(IViewController controller, Composite compo, TabFolder tabFolder) {
		this.controller = controller;
		this.compo = compo;
		this.tabFolder= tabFolder;
	}
	
	
	public Composite createUIControl(Composite shell) {
		
		Composite result = new Composite(shell, SWT.NONE);
		result.setLayout(new FormLayout());
		result.setData(RWT.CUSTOM_VARIANT, "gray_background");
		
		Label searchCriteriaLabel = new Label(result, SWT.NONE);
		searchCriteriaLabel.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		FormDatas.attach(searchCriteriaLabel).atTopTo(result, 10).atLeft(10);
		
		Label firstNamePersonaLabel = new Label(result, SWT.NONE);
		firstNamePersonaLabel.setText("Primer Nombre");
		FormDatas.attach(firstNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeft(10);
		
		Text firtNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(firtNamePersonaText).atTopTo(firstNamePersonaLabel, 10).atLeft(10).withWidth(180);;
		
		
		Label secondNamePersonaLabel = new Label(result, SWT.NONE);
		secondNamePersonaLabel.setText("Segundo Nombre");
		FormDatas.attach(secondNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeftTo(firtNamePersonaText, 30);
		
		Text secondNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(secondNamePersonaText).atTopTo(secondNamePersonaLabel, 10).atLeftTo(firtNamePersonaText, 30).withWidth(180);
		
		Label firstLastNamePersonaLabel = new Label(result, SWT.NONE);
		firstLastNamePersonaLabel.setText("Primer Apellido");
		FormDatas.attach(firstLastNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeftTo(secondNamePersonaText, 30);
		
		Text firstLastNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(firstLastNamePersonaText).atTopTo(firstLastNamePersonaLabel, 10).atLeftTo(secondNamePersonaText, 30).withWidth(180);
		
		Label secondLastNamePersonaLabel = new Label(result, SWT.NONE);
		secondLastNamePersonaLabel.setText("Segundo Apellido");
		FormDatas.attach(secondLastNamePersonaLabel).atTopTo(searchCriteriaLabel, 10).atLeftTo(firstLastNamePersonaText, 30);
		
		Text secondLastNamePersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(secondLastNamePersonaText).atTopTo(secondLastNamePersonaLabel, 10).atLeftTo(firstLastNamePersonaText, 30).withWidth(180);
		
		Label identificationPersonaLabel = new Label(result, SWT.NONE);
		identificationPersonaLabel.setText("Identificacion");
		FormDatas.attach(identificationPersonaLabel).atTopTo(firtNamePersonaText, 10).atLeft(10);
		
		Text identificationPersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(identificationPersonaText).atTopTo(identificationPersonaLabel, 10).atLeft(10).withWidth(180);
		
		Label sexoPersonaLabel = new Label(result, SWT.NONE);
		sexoPersonaLabel.setText("Sexo");
		FormDatas.attach(sexoPersonaLabel).atTopTo(firtNamePersonaText, 10).atLeftTo(identificationPersonaText,30);
		
		Text sexoPersonaText = new Text(result, SWT.BORDER);
		FormDatas.attach(sexoPersonaText).atTopTo(sexoPersonaLabel, 10).atLeftTo(identificationPersonaText, 30).withWidth(180);
		
		Label separator = new Label(result, SWT.SEPARATOR | SWT.HORIZONTAL);
	    FormDatas.attach(separator).atTopTo(sexoPersonaText, 10).atLeft(10).atRight(10);
		
		Button searchButton = new Button(result, SWT.NONE);
		searchButton.setText("Buscar");
		FormDatas.attach(searchButton).atTopTo(separator, 10).atRight(10).withWidth(130);
		
		Label listLibraryLabel = new Label(result, SWT.NORMAL);
		listLibraryLabel.setText("Lista de Personas Coincidentes");
		FormDatas.attach(listLibraryLabel).atTopTo(searchButton, 10).atLeft(10);
		
		tablePerson = new CRUDTreeTable(result, SWT.NONE);
		tablePerson.setEntityClass(PersonGrid.class);
		
		tablePerson.addActionColumn(new Column(shell.getDisplay(), "arrow_down.png", new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				PersonGrid entity = (PersonGrid) event.entity;
				Control[] childrens = compo.getChildren();
				//for (int i = 1; i < childrens.length; i=i+2) {
				    
				   childrens[1].setVisible(false);
				   childrens[2].setVisible(false);
				   
				   childrens[3].setVisible(true);
				   childrens[4].setVisible(true);
				   childrens[5].setVisible(true);
				   
				   ((Label)childrens[6]).setText(entity.getActorID().toString());
				   
				   
				   Table dataPersonTable = (Table) childrens[4];
				   
				   dataPersonTable.getItem(0).setText(1,entity.getFirstName());
				   dataPersonTable.getItem(1).setText(1,entity.getDNI());
				   dataPersonTable.getItem(2).setText(1,entity.getGender().name());
				   
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
	
		initializePersonGrid();
		    return result;
	}

	private void initializePersonGrid() {
		// TODO Auto-generated method stub
		
		Collection<Person> list = ((AllManagementLoanUserViewController) controller).getPersonService().findAllPerson();
		
		for (Person person : list) {
			PersonGrid aux = new PersonGrid(person.getActorID(), person.getDNI(), person.getFirstName(), person.getGender());
			tablePerson.addRow(aux);
		}
	}

}
