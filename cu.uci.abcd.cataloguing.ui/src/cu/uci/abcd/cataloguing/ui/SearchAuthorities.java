package cu.uci.abcd.cataloguing.ui;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;
import cu.uci.abos.widget.compoundLabel.ControlType;

public class SearchAuthorities implements IContributor {

	@Override
	public String contributorName() {
		
		return "Buscar Autoridades";
	}

	@Override
	public Control createUIControl(Composite parent) {
		
		parent.setData(RWT.CUSTOM_VARIANT,"gray_background");
		parent.setLayout(new FormLayout());
		
		Group group = new Group(parent, SWT.NORMAL);
		group.setText("BUSCAR AUTORIDADES");
		group.setLayout(new FormLayout());
		
		group.setData(RWT.CUSTOM_VARIANT,"gray_background");
		
		FormDatas.attach(group).atLeft(0).atRight(0);
		
		Label typeOfAuthority = new Label(group, SWT.NORMAL);
		Label personName = new Label(group, SWT.NORMAL);

		typeOfAuthority.setText("Tipo de autoridad");
        personName.setText("Nombre Persona");
       
        CompoundLabel mainEntrance1 = new CompoundLabel(group, 0,ControlType.Combo);
        mainEntrance1.setText("Entrada Principal(sólo $a)");
        
        CompoundLabel mainEntrance2 = new CompoundLabel(group, 0,ControlType.Combo);
        mainEntrance2.setText("Entrada Principal");
        
        CompoundLabel anyWhere = new CompoundLabel(group, 0,ControlType.Combo);
        anyWhere.setText("En cualquier parte");
        
        CompoundLabel orderBy = new CompoundLabel(group, 0,ControlType.Combo);
        orderBy.setText("Ordenar por");
        
        FormDatas.attach(typeOfAuthority).atTopTo(group, 5).atLeftTo(group, 55);
		FormDatas.attach(personName).atTopTo(group, 5).atLeftTo(typeOfAuthority, 15);
		FormDatas.attach(mainEntrance1).atTopTo(typeOfAuthority, 15);
		FormDatas.attach(mainEntrance2).atTopTo(mainEntrance1, 15);
		FormDatas.attach(anyWhere).atTopTo(mainEntrance2, 15);
		FormDatas.attach(orderBy).atTopTo(anyWhere, 15);
		
		int moreBig = mainEntrance1.getLabel().getSize().x;
		
		mainEntrance1.setPosition(SWT.LEFT, 10);
		mainEntrance2.setPosition(SWT.LEFT, moreBig - mainEntrance2.getLabel().getSize().x + 10);
		anyWhere.setPosition(SWT.LEFT, moreBig - anyWhere.getLabel().getSize().x + 10);
		orderBy.setPosition(SWT.LEFT, moreBig - orderBy.getLabel().getSize().x + 10);
		
		CompoundLabel text1 = new CompoundLabel(group, 0);
		text1.setText("");
		
		CompoundLabel text2 = new CompoundLabel(group, 0);
		text2.setText("");
		
		CompoundLabel text3 = new CompoundLabel(group, 0);
		text3.setText("");
		
		FormDatas.attach(text1).atTopTo(typeOfAuthority, 15).atLeftTo(mainEntrance1, 5);
		FormDatas.attach(text2).atTopTo(text1, 15).atLeftTo(mainEntrance2, 5);
		FormDatas.attach(text3).atTopTo(text2, 15).atLeftTo(anyWhere, 5);
		
		text1.setPosition(SWT.LEFT, 0);
		text2.setPosition(SWT.LEFT, 0);
		text3.setPosition(SWT.LEFT, 0);
		
		Label separator = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separator).atTopTo(orderBy, 5).atLeft(0).atRight(0);
	
		Button startSearchButton = new Button(group, SWT.NONE);
		Button cancelButton = new Button(group, SWT.NONE);
		
		startSearchButton.setText("Iniciar Búsqueda");
		cancelButton.setText("Cancelar");
		
		FormDatas.attach(startSearchButton).atTopTo(separator, 5).withHeight(25);
		FormDatas.attach(cancelButton).atTopTo(separator, 5).atLeftTo(startSearchButton, 20).withHeight(25);
		
		Label results = new Label(group, SWT.NONE);
		results.setText("Resultados");
		FormDatas.attach(results).atTopTo(startSearchButton, 15);
	
		Table table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Resumen");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Usado");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Obtenerlo");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(147);
		tblclmnNewColumn_3.setText("Otra Acción");
        
		FormDatas.attach(table).atTopTo(results, 5).withWidth(500).withHeight(70);
	
		parent.layout(true);
		
		return parent;
	}

	@Override
	public String getID() {
		return "ConsultarSubscripcionPublicacionesPeriodicas";
	}

	

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}

}
