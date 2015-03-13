package cu.uci.abcd.administration.library.aux;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;

import cu.uci.abcd.domain.common.Address;
import cu.uci.abcd.domain.common.PostalAddress;

public class Auxiliary {

	public static void CleanFields(Composite composite) {
		Control[] aux = composite.getChildren();
		for (int i = 0; i < aux.length; i++) {
			Control control = aux[i];
			if (control instanceof Text) {
				((Text) control).setText("");
			} else {
				if (control instanceof Combo) {
					((Combo) control).setText("");
				}else{
					if (control instanceof Button) {
						//if(((Button) control).getStyle()==SWT.CHECK){
							((Button) control).setSelection(false);
						//}
					}
				}
			}
		}
	}

	public static PostalAddress getPostalAddress(List<Address> listAddress) {
		PostalAddress postalAddress = null;
		for (Address address : listAddress) {
			if( address instanceof PostalAddress ){
				postalAddress = (PostalAddress)address;
			}
		}
		return postalAddress;
		
	}
}
