package cu.uci.abcd.opac.contribution;

import java.awt.Scrollbar;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.template.Template;
import org.eclipse.rap.rwt.template.TextCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

import cu.uci.abcd.opac.listener.FilterMenuListener;
import cu.uci.abos.ui.api.IContributor;
import cu.uci.abos.ui.api.IViewController;
import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widgets.grid.CRUDTreeTable;
import cu.uci.abos.widgets.grid.Column;
import cu.uci.abos.widgets.grid.TreeColumnEvent;
import cu.uci.abos.widgets.grid.TreeColumnListener;

public class MainContent implements IContributor {
	
	public   Text searchBox;
	public   Composite result;	
	public   Composite action;
	private Map<String, Control> controls;
	
	
	public MainContent() {
		this.controls = new HashMap<String, Control>();
	}

	
	public Text getSearchBox() {
		return searchBox;
	}

	public void update()
	{
		result.layout(true, true);
		action.layout(true, true);
	}
	
	
	@Override
	public Control createUIControl(final Composite parent) {
		


		result = new Composite(parent, SWT.V_SCROLL);
		result.setData(RWT.CUSTOM_VARIANT, "workspace_content");
		result.setLayout(new FormLayout());	


		FormDatas.attach(result).atLeft(0).atRight(0).atTop(0).atBottom(0);

		searchBox=new Text(result, SWT.None);         


		/*

        Integer width=(Integer)RWT.getApplicationContext().getAttribute("width");

        Integer halfPerCent=width*50/100;
        Integer searcBoxWidth=500;  
        Integer half=halfPerCent-(searcBoxWidth/2);*/


		final Combo filterOne = new Combo(result, SWT.NORMAL);

		filterOne.setItems(new String [] {"Palabra Clave", "Titulo", "Autor", "Tema", 
				"ISBN", "Series", "Signatura Topografica"});


		filterOne.setText("Palabra Clave");

		FormDatas.attach(filterOne).atTop(100).atLeft(50);


		final Button advanceOptionBtn = new Button(result, SWT.CURSOR_SIZEALL);
		//advanceOptionBtn.setText("Avanzado");
		FormDatas.attach(advanceOptionBtn).atTop(100).atRight(50);	         



		final Button searchButton=new Button(result, SWT.NONE);
		searchButton.setText("Buscar");
		FormDatas.attach(searchButton).atTop(100).atLeftTo(searchBox, 10).withHeight(27).atRightTo(advanceOptionBtn, 20);
		searchButton.addListener(SWT.Selection, new FilterMenuListener());      


		FormDatas.attach(searchBox).withHeight(16).withWidth(300).atTop(100).atLeftTo(filterOne, 30);


		action = new Composite(result, SWT.NORMAL);		
		action.setLayout(new FormLayout());		
		action.setBackground(result.getBackground());
		FormDatas.attach(action).atLeft(0).atRight(0).atBottom(0);



		Button closeAdvance = new Button(action, SWT.PUSH);
		closeAdvance.setText("Cerrar");
		FormDatas.attach(closeAdvance).atTop(0).atBottom(0).atRight(20);


		Button newFindAdvance = new Button(action, SWT.PUSH);
		newFindAdvance.setText("Nueva Busqueda");
		FormDatas.attach(newFindAdvance).atTop(0).atBottom(0).atRightTo(closeAdvance, 20);

		Button findAdvance = new Button(action, SWT.PUSH);
		findAdvance.setText("Buscar");
		FormDatas.attach(findAdvance).atTop(0).atBottom(0).atRightTo(newFindAdvance, 20);





		final Group AdvancesOptions = new Group(result, SWT.NONE);
		AdvancesOptions.setLayout(new FormLayout());

		AdvancesOptions.setText("Opciones Avanzadas");


		FormDatas.attach(AdvancesOptions).atTop(0).atLeft(0).atRight(0).atBottomTo(action);




		Label publicationYear = new Label(AdvancesOptions, SWT.NORMAL);
		publicationYear.setText("Año de Publicación");
		FormDatas.attach(publicationYear).atTopTo(AdvancesOptions, 5); 

		Text txtannoPubliaccion = new Text(AdvancesOptions, SWT.NORMAL);
		FormDatas.attach(txtannoPubliaccion).atTopTo(publicationYear, 5).withWidth(130);


		Label tipoRegistro = new Label(AdvancesOptions, SWT.NORMAL);
		tipoRegistro.setText("Tipo de Registro");
		FormDatas.attach(tipoRegistro).atTopTo(AdvancesOptions, 5).atLeftTo(txtannoPubliaccion, 10);

		Text txtTipoRegistro = new Text(AdvancesOptions, SWT.NORMAL);
		FormDatas.attach(txtTipoRegistro).atTopTo(tipoRegistro, 5).withWidth(130).atLeftTo(txtannoPubliaccion, 10);

		Label ubicacionDispon = new Label(AdvancesOptions, SWT.NORMAL);
		ubicacionDispon.setText("Ubicación y Disponibilidad:");
		FormDatas.attach(ubicacionDispon).atTopTo(AdvancesOptions, 5).atLeftTo(txtTipoRegistro, 10);

		Combo comUbicacionDisp = new Combo(AdvancesOptions, SWT.NORMAL);
		comUbicacionDisp.setItems(new String [] {"123", "456", "789"});		
		FormDatas.attach(comUbicacionDisp).atTopTo(ubicacionDispon, 5).atLeftTo(txtTipoRegistro, 10).withWidth(130);


		Label tipodeOrdenamiento = new Label(AdvancesOptions, SWT.NORMAL);
		tipodeOrdenamiento.setText("Tipo de Ordenamiento");
		FormDatas.attach(tipodeOrdenamiento).atTopTo(comUbicacionDisp,10);

		Combo comTipodeOrden = new Combo(AdvancesOptions, SWT.NORMAL);
		comTipodeOrden.setItems(new String [] {"Por Fecha de Publicacion", "Por Nombre del Autor", "Por Nombre de Material"});		
		FormDatas.attach(comTipodeOrden).atTopTo(tipodeOrdenamiento, 5).withWidth(130);





		///////....Sale si se seleccionan mas opciones....////


		final Button moreOptionBtn = new Button(AdvancesOptions, SWT.CURSOR_HAND);
		moreOptionBtn.setText("Mas opciones");		
		FormDatas.attach(moreOptionBtn).atBottom(30).atLeft(200);




		final Label tipoDeAudiencia = new Label(AdvancesOptions, SWT.NORMAL);			    
		tipoDeAudiencia.setText("Tipo de Audiencia");
		FormDatas.attach(tipoDeAudiencia).atTopTo(txtTipoRegistro, 10).atLeftTo(comTipodeOrden, 10);

		final Combo comTipodeAudiencia = new Combo(AdvancesOptions, SWT.NORMAL);
		comTipodeAudiencia.setItems(new String [] {"Por Fecha de Publicacion", "Por Nombre del Autor", "Por Nombre de Material"});		
		FormDatas.attach(comTipodeAudiencia).atTopTo(tipoDeAudiencia, 5).atLeftTo(comTipodeOrden, 10).withWidth(130);


		final Label tipoDeContenido = new Label(AdvancesOptions, SWT.NORMAL);
		tipoDeContenido.setText("Tipo de Contenido");
		FormDatas.attach(tipoDeContenido).atTopTo(comUbicacionDisp, 10).atLeftTo(comTipodeAudiencia, 10);

		final Combo comTipodeContenido = new Combo(AdvancesOptions, SWT.NORMAL);
		comTipodeContenido.setItems(new String [] {"Por Fecha de Publicacion", "Por Nombre del Autor", "Por Nombre de Material"});		
		FormDatas.attach(comTipodeContenido).atTopTo(tipoDeContenido, 5).atLeftTo(comTipodeAudiencia, 10).withWidth(130);


		/*

				Label tipoDeFormato = new Label(areaMasOpciones, SWT.NORMAL);
			    tipoDeFormato.setText("Tipo de Formato");
				FormDatas.attach(tipoDeFormato).atTopTo(tipoDeContenido,30);

				Combo comTipodeFormato = new Combo(areaMasOpciones, SWT.NORMAL);
				comTipodeFormato.setItems(new String [] {"Por Fecha de Publicacion", "Por Nombre del Autor", "Por Nombre de Material"});		
				FormDatas.attach(comTipodeFormato).atTopTo(tipoDeContenido,25).atLeftTo(tipoDeFormato,15).withHeight(23).withWidth(210);

				Label tipoDeConteniAdicio = new Label(areaMasOpciones, SWT.NORMAL);
			    tipoDeConteniAdicio.setText("Tipo de Contenido Adicional");
				FormDatas.attach(tipoDeConteniAdicio).atTopTo(tipoDeFormato,30);

				Combo comTipodeConteniAdicio = new Combo(areaMasOpciones, SWT.NORMAL);
				comTipodeConteniAdicio.setItems(new String [] {"Por Fecha de Publicacion", "Por Nombre del Autor", "Por Nombre de Material"});		
				FormDatas.attach(comTipodeConteniAdicio).atTopTo(tipoDeFormato,25).atLeftTo(tipoDeConteniAdicio,15).withHeight(23).withWidth(210);

		 */




		
		final Group resultados = new Group(result, SWT.NONE);
		resultados.setLayout(new FormLayout());
		

		FormDatas.attach(resultados).atTopTo(searchBox, 5).atLeft(0).atRight(0);




		Label aaaa = new Label(AdvancesOptions, SWT.NORMAL);
		aaaa.setText("Año de Publicación");
		FormDatas.attach(aaaa).atTopTo(AdvancesOptions, 5); 
		
		
		
		
		
		

		

		










		/////// INICIALMENTE OCULTOS//////



		AdvancesOptions.setVisible(false);
		action.setVisible(false);
		tipoDeAudiencia.setVisible(false);
		comTipodeAudiencia.setVisible(false);
		tipoDeContenido.setVisible(false);
		comTipodeContenido.setVisible(false);






		/////LISENERRSSSS////////////////


		advanceOptionBtn.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				searchButton.setVisible(false);
				searchBox.setVisible(false);	
				filterOne.setVisible(false);
				advanceOptionBtn.setVisible(false);
				AdvancesOptions.setVisible(true);
				action.setVisible(true);			

			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				//do nothing
			}
		});



		moreOptionBtn.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent arg0) {


				tipoDeAudiencia.setVisible(true);
				comTipodeAudiencia.setVisible(true);
				tipoDeContenido.setVisible(true);
				comTipodeContenido.setVisible(true);

				/*

				AdvancesOptions.setVisible(false);
				action.setVisible(false);
				searchButton.setVisible(true);
		        searchBox.setVisible(true);	
		        filterOne.setVisible(true);
		        advanceOptionBtn.setVisible(true);*/

			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				//do nothing
			}
		});








		findAdvance.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				AdvancesOptions.setVisible(false);
				action.setVisible(false);
				tipoDeAudiencia.setVisible(false);
				comTipodeAudiencia.setVisible(false);
				tipoDeContenido.setVisible(false);
				comTipodeContenido.setVisible(false);
				searchButton.setVisible(true);
				searchBox.setVisible(true);	
				filterOne.setVisible(true);
				advanceOptionBtn.setVisible(true);

			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				//do nothing
			}
		});




		closeAdvance.addSelectionListener(new SelectionListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				AdvancesOptions.setVisible(false);
				action.setVisible(false);
				tipoDeAudiencia.setVisible(false);
				comTipodeAudiencia.setVisible(false);
				tipoDeContenido.setVisible(false);
				comTipodeContenido.setVisible(false);
				searchButton.setVisible(true);
				searchBox.setVisible(true);		
				filterOne.setVisible(true);
				advanceOptionBtn.setVisible(true);

			}			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				//do nothing
			}
		});





		return result;


		
		
		
	}
 
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "MainContentID";
	}

	@Override
	public void l10n() {
		// TODO Auto-generated method stub

	}

	@Override
	public String contributorName() {
		// TODO Auto-generated method stub
		return "MainContent";
	}

	@Override
	public boolean canClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setViewController(IViewController controller) {
		// TODO Auto-generated method stub

	}

}
