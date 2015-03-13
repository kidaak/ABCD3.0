package cu.uci.abcd.domain.acquisition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dpurchaseorder", schema = "abcd")
public class PurchaseOrder {
	@Id
	@TableGenerator(name = "PURCHASEORDER_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "PURCHASEORDER_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PURCHASEORDER_GEN")
	@Column(name = "purchase_order_id")
	private Long purchaseOrderID;
	@Column(name = "identifier", length = 11, nullable = false, unique = true)
	private String identifier;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provider_id")
	private Provider provider;
	@Column(name = "purchase_date", nullable = false)
	private Date purchaseDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "purchase_order_state", nullable = false)
	private PurchaseOrderState purchaseOrderState;
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
	private List<Order> orders;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_library_id", nullable = false)
	private Library ownerLibrary;

	public PurchaseOrder() {
		super();
		orders = new ArrayList<>();
	}

	public Long getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(Long purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public PurchaseOrderState getPurchaseOrderState() {
		return purchaseOrderState;
	}

	public void setPurchaseOrderState(PurchaseOrderState purchaseOrderState) {
		this.purchaseOrderState = purchaseOrderState;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Library getOwnerLibrary() {
		return ownerLibrary;
	}

	public void setOwnerLibrary(Library ownerLibrary) {
		this.ownerLibrary = ownerLibrary;
	}

	public void associateOrder(Order order) {
		this.orders.add(order);
		if (!order.getPurchaseOrder().equals(this)) {
			order.setPurchaseOrder(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result
				+ ((purchaseOrderID == null) ? 0 : purchaseOrderID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PurchaseOrder other = (PurchaseOrder) obj;
		if (identifier == null) {
			if (other.identifier != null) {
				return false;
			}
		} else if (!identifier.equals(other.identifier)) {
			return false;
		}
		if (purchaseOrderID == null) {
			if (other.purchaseOrderID != null) {
				return false;
			}
		} else if (!purchaseOrderID.equals(other.purchaseOrderID)) {
			return false;
		}
		return true;
	}

}
