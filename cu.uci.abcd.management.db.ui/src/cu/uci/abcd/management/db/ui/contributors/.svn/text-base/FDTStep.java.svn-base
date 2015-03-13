package cu.uci.abcd.management.db.ui.contributors;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import cu.uci.abos.l10n.management.db.AbosMessages;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;
import cu.uci.abos.widgets.wizard.BaseStep;
import cu.uci.abos.widgets.wizard.IStep;
import cu.uci.abos.widgets.wizard.Wizard;

public class FDTStep extends BaseStep implements IStep {

	private Group fdtGroup;
	private CRUDTreeTable fdt;
	
    public FDTStep(Wizard wizard) {
    	super(wizard);
    }

    @Override
    public boolean isValid() {
		// for(Control control : this.controls.values()) {
		// TODO: validation logic here.
		// }
    	return true;
    }

    @Override
    public Control createUI(Composite parent) {
		this.createFieldDefinitionTable(parent);	
		return parent;
    }

    private Group createFieldDefinitionTable(Composite parent) {
    	fdtGroup = new Group(parent, SWT.NONE);
    	fdtGroup.setLayout(new FormLayout());
    	FormDatas.attach(fdtGroup).atTop(0).atLeft(0).atRight(0);    	
		
		fdt = new CRUDTreeTable(fdtGroup, SWT.NONE);
		FormDatas.attach(fdt).atRight(0).atLeft(0);
		fdt.setEntityClass(FDTViewEntity.class);
		fdt.setDelete(true);
		fdt.setUpdate(true, new FDTUpdateArea());
		fdt.setAdd(true, new FDTAddArea());
		fdt.setSaveAll(true);
		fdt.setSearch(true);
		//fdt.addActionButton("restoreBtn", new ButtonData("restore.png", null));
				
		try {
			fdt.createTable();
		}
		catch(Exception e) {
		}
		
		fdt.addDeleteListener(new TreeColumnListener() {			
			@Override
			public void handleEvent(TreeColumnEvent event) {
				event.performDelete = true;
			}
		});
		
		fdt.addRow(new FDTViewEntity(0, "nombre", FDType.ALPHANUMERIC, true, false, true, "ab"));
		fdt.addRow(new FDTViewEntity(1, "apellidos", FDType.ALPHANUMERIC, false, true, false, "ab"));
		fdt.addRow(new FDTViewEntity(2, "identificación", FDType.ALPHABETIC, true, false, true, "ab"));
		fdt.addRow(new FDTViewEntity(3, "sexo", FDType.NUMERIC, true, false, true, "ab"));
		
		return fdtGroup;
    }

	@Override
	public void l10n() {
		fdtGroup.setText(AbosMessages.get().GROUP_TABLE_FDT);
		fdt.setCancelButtonText(AbosMessages.get().BUTTON_CANCEL_FDT);
		fdt.setSearchHintText(AbosMessages.get().MESSAGE_SEARCH_HINT_FDT);
		fdt.setAddButtonText(AbosMessages.get().BUTTON_ADD_FDT);
		fdt.setSaveAllButtonText(AbosMessages.get().BUTTON_SAVE_ALL_FDT);
		//fdt.setActionButtonText("restoreBtn", AbosMessages.get().BUTTON_RESTORE_FDT);
		fdt.setColumnHeaders(Arrays.asList(AbosMessages.get().HEADER_TAG_FDT, AbosMessages.get().HEADER_NAME_FDT, 
				AbosMessages.get().HEADER_TYPE_FDT, AbosMessages.get().HEADER_INDICATORS_FDT, 
				AbosMessages.get().HEADER_REP_FDT, AbosMessages.get().HEADER_FIRST_SUBFIELD_FDT, 
				AbosMessages.get().HEADER_SUBFIELDS_PATTERN_FDT));
		fdt.l10n();
	}
}
