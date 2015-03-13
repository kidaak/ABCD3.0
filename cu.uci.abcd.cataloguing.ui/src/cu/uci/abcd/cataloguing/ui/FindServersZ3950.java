package cu.uci.abcd.cataloguing.ui;


import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.compoundLabel.CompoundLabel;

public class FindServersZ3950 implements IContributor{

	@Override
	public String contributorName() {
		
		return "Buscar Servidores Z39.50";
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public Control createUIControl(Composite parent) {
		
		parent.setData(RWT.CUSTOM_VARIANT, "gray_background");
		parent.setLayout(new FormLayout());
		
		Group searchGroup = new Group(parent, SWT.NORMAL);
		searchGroup.setText("Punto de Búsqueda Z39.50");
		searchGroup.setLayout(new FormLayout());
		FormDatas.attach(searchGroup).atLeft(0).atRight(0);
		
		Composite leftComposite = new Composite(searchGroup, SWT.BORDER);
		leftComposite.setData(RWT.CUSTOM_VARIANT, "gray_background");
		leftComposite.setLayout(new FormLayout());
		FormDatas.attach(leftComposite).atTopTo(searchGroup, 10);
		
		CompoundLabel title = new CompoundLabel(leftComposite, 0);
		title.setText("Título:");
		
		CompoundLabel isbn = new CompoundLabel(leftComposite, 0);
		isbn.setText("ISBN/ISSN:");
		
		CompoundLabel number = new CompoundLabel(leftComposite, 0);
		number.setText("Número LC:");
		
		CompoundLabel controlNumber = new CompoundLabel(leftComposite, 0);
		controlNumber.setText("Número de Control:");
		
		CompoundLabel address = new CompoundLabel(leftComposite, 0);
		address.setText("Directo(cualquiera)");
		
		FormDatas.attach(title).atTopTo(leftComposite, 10);
		FormDatas.attach(isbn).atTopTo(title, 5);
		FormDatas.attach(number).atTopTo(isbn, 5);
		FormDatas.attach(controlNumber).atTopTo(number, 5);
		FormDatas.attach(address).atTopTo(controlNumber, 5).atBottomTo(leftComposite, 10);
		
		int moreBig = address.getLabel().getSize().x;
		
		title.setPosition(SWT.LEFT, moreBig - title.getLabel().getSize().x + 10);
		isbn.setPosition(SWT.LEFT, moreBig - isbn.getLabel().getSize().x + 10);
		number.setPosition(SWT.LEFT, moreBig - number.getLabel().getSize().x + 10);
		controlNumber.setPosition(SWT.LEFT, moreBig - controlNumber.getLabel().getSize().x + 10);
		address.setPosition(SWT.LEFT,10);
		
		Composite rightComposite= new Composite(searchGroup, SWT.BORDER);
		rightComposite.setData(RWT.CUSTOM_VARIANT, "gray_background");
		rightComposite.setLayout(new FormLayout());
		FormDatas.attach(rightComposite).atTopTo(searchGroup, 10).atLeftTo(leftComposite, 13);
		
		CompoundLabel author = new CompoundLabel(rightComposite, 0);
		author.setText("Autor:");
		
		CompoundLabel headers = new CompoundLabel(rightComposite, 0);
		headers.setText("Encabezados de tema:");
		
		CompoundLabel dewey = new CompoundLabel(rightComposite, 0);
		dewey.setText("Dewey:");
		
		CompoundLabel id = new CompoundLabel(rightComposite, 0);
		id.setText("ID estándar:");
		
		FormDatas.attach(author).atTopTo(rightComposite, 10);
		FormDatas.attach(headers).atTopTo(author, 5);
		FormDatas.attach(dewey).atTopTo(headers, 5);
		FormDatas.attach(id).atTopTo(dewey, 5);
		
		int moreBig2 = headers.getLabel().getSize().x;
		
		author.setPosition(SWT.LEFT, moreBig2 - author.getLabel().getSize().x + 10);
		headers.setPosition(SWT.LEFT,10);
		dewey.setPosition(SWT.LEFT, moreBig2 - dewey.getLabel().getSize().x + 10);
		id.setPosition(SWT.LEFT, moreBig2 - id.getLabel().getSize().x + 10);
		
		Label servers = new Label(searchGroup, SWT.NONE);
		servers.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);
		servers.setText("<span style='font:bold 15px Arial;'>Servidores de Búsqueda</span>");
		FormDatas.attach(servers).atTopTo(leftComposite, 5);
		
		Link selectAll = new Link(searchGroup, SWT.NONE);
		selectAll.setText("<a> Seleccionar todo </a>");
		FormDatas.attach(selectAll).atTopTo(leftComposite, 5).atLeftTo(servers, 15);
				
		Link cleanAll = new Link(searchGroup, SWT.NONE);
		cleanAll.setText("<a> Limpiar todo </a>");
		FormDatas.attach(cleanAll).atTopTo(leftComposite, 5).atLeftTo(selectAll, 15);
		
		Button serverButton = new Button(searchGroup, SWT.CHECK);
		serverButton.setText("SERV [10.51.6.85]");
		FormDatas.attach(serverButton).atTopTo(servers, 5).withHeight(25);
		
		Button universityButton = new Button(searchGroup, SWT.CHECK);
		universityButton.setText("NEW YORK UNIVERSITY LIBRARIES [bobcat.nyu.edu]");
		FormDatas.attach(universityButton).atTopTo(serverButton, 5).withHeight(25);
				
		Button libraryButton = new Button(searchGroup, SWT.CHECK);
		libraryButton.setText("NEW YORK PUBLIC LIBRARY [catnyp.nypl.org]");
		FormDatas.attach(libraryButton).atTopTo(universityButton, 5).withHeight(25);
		
		Button columbia = new Button(searchGroup, SWT.CHECK);
		columbia.setText("COLUMBIA UNIVERSITY [clio-db.cc.columbia.edu]");
		FormDatas.attach(columbia).atTopTo(libraryButton, 5).withHeight(25);
		
		Button consult = new Button(searchGroup, SWT.PUSH);
		Button close = new Button(searchGroup, SWT.PUSH);
		
		consult.setText("Consultar");
		close.setText("Cerrar");
		
		FormDatas.attach(consult).atTopTo(columbia, 5).withHeight(25);
		FormDatas.attach(close).atTopTo(columbia, 5).atLeftTo(consult, 20).withHeight(25);
		
		parent.layout(true);
			
	 return searchGroup;
	}

	@Override
	public String getID() {
		return "AsociarTerminosID";
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
