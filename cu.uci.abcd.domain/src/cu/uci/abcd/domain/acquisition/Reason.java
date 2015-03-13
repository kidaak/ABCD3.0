package cu.uci.abcd.domain.acquisition;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import cu.uci.abcd.domain.common.Nomenclator;
@Entity
@DiscriminatorValue(value = "REASON")
public class Reason extends Nomenclator {

}
