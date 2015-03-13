package cu.uci.abcd.administration.library.communFragment;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.ui.api.IFragmentContributor;
import cu.uci.abos.util.api.FormDatas;

public class ViewFormationCourseFragment implements IFragmentContributor {

	@Override
	public Control createUIControl(Composite shell) {
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		FormDatas.attach(shell).atLeft(0).atRight(0);
		Composite parent= new Composite(shell, SWT.NORMAL);
		
		parent.setLayout(form);
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		FormDatas.attach(parent).atLeft(0).atRight(0);
        //tabFolder = new TabFolder(parent, SWT.NONE);
        //tabFolder.setData(RWT.CUSTOM_VARIANT, "gray_background");
        //FormDatas.attach(tabFolder).atTopTo(parent).atLeft(0).atRight(0);
		Composite group1 = new Composite(parent, SWT.NONE);
		group1.setLayout(form);
		group1.setData(RWT.CUSTOM_VARIANT, "gray_background");
	
		FormDatas.attach(group1).atTopTo(parent).atLeft(0).atRight(0);
		
		Label generalDataLabel = new Label(group1, SWT.NONE);
		//lblNewLab.setText(MessageUtil.unescape(AbosMessages.get().LABEL_GENERAL_DATA)); //no esta pinchando
		generalDataLabel.setText("Datos Generales"); //no esta pinchando
		
		FormDatas.attach(generalDataLabel).atTopTo(group1, 10).atLeft(20);
		
		Table generalDataTable = new Table(group1, SWT.BORDER | SWT.FULL_SELECTION);
		generalDataTable.setHeaderVisible(false);
		generalDataTable.setLinesVisible(true);
        
        TableColumn generalDataColumn1 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn1.setWidth(125);
        TableColumn generalDataColumn2 = new TableColumn(generalDataTable, SWT.NONE);
        generalDataColumn2.setWidth(125);
                                
        TableItem nameTableItem = new TableItem(generalDataTable, SWT.NONE);
        nameTableItem.setText(0,"Nombre");
        nameTableItem.setText(1, "");
                
        TableItem surficeTableItem = new TableItem(generalDataTable, SWT.NONE);
        surficeTableItem.setText("Superficie");
        surficeTableItem.setText(1, "");
                                
        TableItem roomQuantityTableItem = new TableItem(generalDataTable, SWT.NONE);
        roomQuantityTableItem.setText("Cantidad de Salas");
        roomQuantityTableItem.setText(1, "");
        
        FormDatas.attach(generalDataTable).atTopTo(generalDataLabel, 5).atLeftTo(group1, 20);
        
        
        Label userDataLabel = new Label(group1, SWT.NONE);
        userDataLabel.setText("Datos del usuario que actua en el sistema"); //no esta pinchando
		FormDatas.attach(userDataLabel).atTopTo(group1, 10).atLeftTo(generalDataLabel, 300);
		
		Table userDataTable = new Table(group1, SWT.BORDER | SWT.FULL_SELECTION);
		userDataTable.setHeaderVisible(false);
		userDataTable.setLinesVisible(true);
        
        TableColumn userDataColumn1 = new TableColumn(userDataTable, SWT.NONE);
        userDataColumn1.setWidth(175);
        TableColumn userDataColumn2 = new TableColumn(userDataTable, SWT.NONE);
        userDataColumn2.setWidth(300);
                                
        TableItem nameAndLastNameTableItem= new TableItem(userDataTable, SWT.NONE);
        nameAndLastNameTableItem.setText(0,"Nombre y Apellidos");
        nameAndLastNameTableItem.setText(1, "");
                
        TableItem userTableItem = new TableItem(userDataTable, SWT.NONE);
        userTableItem.setText("Usuario");
        userTableItem.setText(1, "");
                                
        TableItem DateTableItem = new TableItem(userDataTable, SWT.NONE);
        DateTableItem.setText("Fecha");
        DateTableItem.setText(1, "");
        
        TableItem HourTableItem = new TableItem(userDataTable, SWT.NONE);
        HourTableItem.setText("Hora");
        HourTableItem.setText(1, "");
        
        FormDatas.attach(userDataTable).atTopTo(generalDataLabel, 5).atLeftTo(generalDataLabel, 300);
        
        Label addressLibraryLabel = new Label(group1, SWT.NONE);
		addressLibraryLabel.setText("Dirección");
		FormDatas.attach(addressLibraryLabel).atTopTo(generalDataTable,10).atLeft(20);
		
		Text addressLibraryText = new Text(group1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		FormDatas.attach(addressLibraryText).atTopTo(addressLibraryLabel, 5).atLeft(10).withWidth(350).withHeight(30);
		
		
		
		
		
			return shell;
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
	public Control getControl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
