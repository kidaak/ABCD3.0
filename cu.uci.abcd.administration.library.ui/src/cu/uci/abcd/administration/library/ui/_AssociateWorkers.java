package cu.uci.abcd.administration.library.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import cu.uci.abos.l10n.management.library.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;

public class _AssociateWorkers implements IContributor{
	FormLayout form;
	Composite parent;
	Label nameAndSurnamesLabel;
	Label identifierLabel;
	Text identifierText;
	Button closeButton;
	Button consultButton;
	Label separador;
	Label list;
	Table tabla;

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "Asociar Trabajadores";
	}


	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return ManageCoin.class.getSimpleName() + "id5";
	}

	@Override
	public Control createUIControl(Composite shell) {
		// TODO Auto-generated method stub
		FormLayout form = new FormLayout();
		shell.setLayout(form);
		parent= new Composite(shell, SWT.NORMAL);
		parent.setLayout(form);
		FormDatas.attach(parent).atLeftTo(shell, 10);
		
		nameAndSurnamesLabel =  new Label(parent, SWT.NONE);
		FormDatas.attach(nameAndSurnamesLabel).atTopTo(parent, 10);
		
		Text nameAndSurnameText = new Text(parent, SWT.BORDER);
		FormDatas.attach(nameAndSurnameText).atTopTo(nameAndSurnamesLabel, 10);
		
		identifierLabel=  new Label(parent, SWT.NONE);
		identifierLabel.setLayoutData(new FormData());
		FormDatas.attach(identifierLabel).atLeftTo(nameAndSurnamesLabel, 53).atTopTo(parent, 10);
		
		identifierText = new Text(parent, SWT.BORDER);
		FormDatas.attach(identifierText).atLeftTo(nameAndSurnameText, 75).atTopTo(identifierLabel, 10);
			
		closeButton = new Button(parent, SWT.PUSH);
		FormDatas.attach(closeButton).atTopTo(identifierText, 10).atRight();
			  
	    consultButton = new Button(parent, SWT.PUSH);
		FormDatas.attach(consultButton).atTopTo(identifierText, 10).atRightTo(closeButton, 10);
			
	    separador = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormDatas.attach(separador).atTopTo(closeButton, 10).withWidth(680);
			  
		list = new Label(parent, SWT.NORMAL);
		FormDatas.attach(list).atTopTo(separador, 10);
		
		
		  //-----------------Tabla--------------------------------------
		  
		  tabla = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		  FormDatas.attach(tabla).atTopTo(list, 10);
		  tabla.setHeaderVisible(true);
		  tabla.setLinesVisible(true);
		  
		  TableItem tableItem_1 = new TableItem(tabla, SWT.NONE);
		    tableItem_1.setText( new String[] { "column 0", "column 1" } );
		    
		    		  TableColumn columna0 = new TableColumn(tabla, SWT.NONE);
		    		  columna0.setWidth(150);
		    		  columna0.setText(AbosMessages.get().NAME_LASTNAME);
		    		  
		    		  TableColumn columna1 = new TableColumn(tabla, SWT.NONE);
		    		  columna1.setWidth(100);
		    		  columna1.setText(MessageUtil.unescape(AbosMessages.get().IDENTIFICATION));
		    		  
		    		  TableColumn columna2 = new TableColumn(tabla, SWT.NONE);
		    		  columna2.setWidth(100);
		    		  columna2.setText("Edad");
		    		  
		    		  TableColumn columna3 = new TableColumn(tabla, SWT.NONE);
		    		  columna3.setWidth(70);
		    		  columna3.setText("Sexo");
		    		  
		    		  TableColumn columna4 = new TableColumn(tabla, SWT.NONE);
		    		  columna4.setWidth(150);
		    		  columna4.setText("Tipo de Trabajador");
		    		  
		    		  TableColumn columna5 = new TableColumn(tabla, SWT.NONE);
		    		  columna5.setWidth(100);
		    		  columna5.setText(AbosMessages.get().ACTIONS);
		    		  
		    		  l10n();
		return shell;
	}


	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void l10n() {
		// TODO Auto-generated method stub
		nameAndSurnamesLabel.setText(AbosMessages.get().NAME_LASTNAME);
		identifierLabel.setText(AbosMessages.get().IDENIFIER);
		closeButton.setText(AbosMessages.get().BUTTON_CLOSE);
		consultButton.setText(AbosMessages.get().BUTTON_CONSULT);
		list.setText("Listado de Trabajadores Asociados");
		
	}


	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub
		
	}
}
