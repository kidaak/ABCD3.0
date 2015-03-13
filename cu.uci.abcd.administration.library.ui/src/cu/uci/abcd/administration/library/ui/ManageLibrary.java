package cu.uci.abcd.administration.library.ui;

import java.awt.event.ComponentListener;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cu.uci.abcd.administration.library.aux.Auxiliary;
import cu.uci.abcd.administration.library.ui.controller.LibraryViewController;
import cu.uci.abcd.administration.library.ui.model.LibraryAddArea;
import cu.uci.abcd.administration.library.ui.model.LibraryGrid;
import cu.uci.abcd.administration.library.ui.model.LibraryUpdateArea;
import cu.uci.abcd.administration.library.ui.model.LibraryViewArea;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class ManageLibrary implements IContributor {

	private IViewController controller;
	FormLayout form;
	Composite test;
	Label searchCriteriaLabel;
	CompoundLabel nameRegister;
	//Label nameRegisterLabel;
	//Text nameRegisterText;
	Label separator;
	Button newSearchButton;
	Button consultButton;
	Label listLibraryLabel;
	CRUDTreeTable tableLibrary;
	Button exportPdfButton;
	Button exportHcButton;

	@Override
	public void setViewController(IViewController controller) {
		this.controller = controller;
	}

	@Override
	public String contributorName() {
		return "Bibliotecas";
	}

	@Override
	public String getID() {
		return "AdministrarBibliotecaID";
	}

	@Override
	public Control createUIControl(Composite shell) {
		form = new FormLayout();
		shell.setLayout(form);
		shell.setData(RWT.CUSTOM_VARIANT, "gray_background");
		test = new Composite(shell, SWT.NORMAL);
		test.setLayout(form);
		test.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(test).atLeftTo(shell, 10).atLeft(0).atRight(0);

		searchCriteriaLabel = new Label(test, SWT.NONE);
		searchCriteriaLabel.setLayoutData(new FormData());
		FormDatas.attach(searchCriteriaLabel).atTopTo(test, 10).atLeft(10);
		
		nameRegister = new CompoundLabel(test, SWT.NONE);
		nameRegister.setPosition(SWT.TOP, 10);
		FormDatas.attach(nameRegister).atTopTo(searchCriteriaLabel, 10).atLeft(10);
		
		separator = new Label(test, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new FormData());
		FormDatas.attach(separator).atTopTo(nameRegister, 12).atLeft(5)
				.atRight(5);

		newSearchButton = new Button(test, SWT.NONE);
		newSearchButton.setLayoutData(new FormData());
		FormDatas.attach(newSearchButton).atTopTo(separator, 10).atRight(5)
				.withWidth(130);

		newSearchButton.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = -5179607102055540891L;

			@Override
			public void widgetSelected(SelectionEvent e) {
				Auxiliary.CleanFields(test);
			}

		});
		consultButton = new Button(test, SWT.NONE);
		consultButton.setLayoutData(new FormData());
		FormDatas.attach(consultButton).atTopTo(separator, 10)
				.atRightTo(newSearchButton, 10).withWidth(130);

		listLibraryLabel = new Label(test, SWT.NORMAL);
		listLibraryLabel.setLayoutData(new FormData());
		FormDatas.attach(listLibraryLabel).atTopTo(newSearchButton, 10)
				.atLeft(10);
		tableLibrary = new CRUDTreeTable(test, SWT.NONE);
		tableLibrary.setEntityClass(LibraryGrid.class);
		
		tableLibrary.setAdd(true, new LibraryAddArea(controller));
		tableLibrary.setWatch(true, new LibraryViewArea(controller));
		tableLibrary.setUpdate(true, new LibraryUpdateArea(controller));
		tableLibrary.setDelete(true);
		
		tableLibrary.setColumnHeaders(Arrays.asList(AbosMessages.get().NAME, AbosMessages.get().SURFACE,
				AbosMessages.get().ROOM_QUANTITY));
		try {
			tableLibrary.createTable();
		} catch (Exception e) {
		}
		FormDatas.attach(tableLibrary).atTopTo(listLibraryLabel, 10).atLeft(5)
				.atRight(5);

		tableLibrary.addUpdateListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {

			}
		});
		tableLibrary.addDeleteListener(new TreeColumnListener() {
			public void handleEvent(TreeColumnEvent event) {
				LibraryGrid library = (LibraryGrid) event.entity;
				Long libraryId = library.getLibrary().getActorID();
				((LibraryViewController) controller)
						.deleteLibraryById(libraryId);
				event.performDelete = true;

			}
		});
		exportPdfButton = new Button(test, SWT.PUSH);
		FormDatas.attach(exportPdfButton).atTopTo(tableLibrary, 10).atRight();
		exportHcButton = new Button(test, SWT.PUSH);
		FormDatas.attach(exportHcButton).atTopTo(tableLibrary, 10)
				.atRightTo(exportPdfButton, 10);

		consultButton.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = -1030305633320960902L;

			@Override
			public void widgetSelected(SelectionEvent e) {
				tableLibrary.clearRows();
				String libraryName = ((Text)nameRegister.getControl()).getText();
				if (libraryName.equalsIgnoreCase("")
						|| libraryName.equalsIgnoreCase(null)
						|| libraryName.equalsIgnoreCase("*")) {
					tableLibrary.clearRows();
					InitializeLibraryGrid();
					tableLibrary.refresh();
				} else {
					Collection<Library> list = ((LibraryViewController) controller)
							.findByLibraryName(libraryName);
					for (Library library : list) {
						LibraryGrid aux = new LibraryGrid(library);
						tableLibrary.addRow(aux);
						tableLibrary.refresh();
					}
				}
			}

		});
		InitializeLibraryGrid();
		l10n();
		return shell;
	}

	private void InitializeLibraryGrid() {
		Collection<Library> list = ((LibraryViewController) controller)
				.findAllLibraries();
		for (Library library : list) {
			LibraryGrid aux = new LibraryGrid(library);
			tableLibrary.addRow(aux);
		}
	}

	@Override
	public boolean canClose() {
		return false;
	}

	@Override
	public void l10n() {
		searchCriteriaLabel
				.setText(MessageUtil.unescape(AbosMessages.get().LABEL_SEARCH_CRITERIA));
		nameRegister.setText(AbosMessages.get().LABEL_NAME);
		newSearchButton
				.setText(MessageUtil.unescape(AbosMessages.get().BUTTON_NEW_SEARCH));
		consultButton.setText(AbosMessages.get().BUTTON_CONSULT);
		listLibraryLabel.setText(AbosMessages.get().LABEL_MLIBRARIES);
		exportPdfButton.setText(AbosMessages.get().BUTTON_EXPORT_TO_PDF);
		exportHcButton.setText(AbosMessages.get().BUTTON_EXPORT_TO_EXCEL);
		
		tableLibrary.setCancelButtonText(AbosMessages.get().BUTTON_CANCEL);
		tableLibrary.setAddButtonText(AbosMessages.get().BUTTON_ADD);
		
		tableLibrary.setColumnHeaders(Arrays.asList(AbosMessages.get().NAME, AbosMessages.get().SURFACE,
				AbosMessages.get().ROOM_QUANTITY));
		
	}
}
