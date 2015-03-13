package cu.uci.abcd.domain.acquisition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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

import cu.uci.abcd.domain.common.Account;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dorder", schema = "abcd")
public class Order {
	@Id
	@TableGenerator(name = "ORDER_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "ORDER_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ORDER_GEN")
	@Column(name = "order_id")
	private Long orderID;
	@Column(name = "identifier", length = 11, nullable = false, unique = true)
	private String identifier;
	@Embedded
	private MaterialCopy materialCopy;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_owner_id", nullable = false)
	private Account accountOwner;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_library_id", nullable = false)
	private Library ownerLibrary;
	@Enumerated(EnumType.STRING)
	@Column(name = "order_state_id", nullable = false)
	private OrderState orderState;
	@OneToMany(mappedBy = "associateOrder", fetch = FetchType.LAZY)
	private List<Suggestion> suggestions;
	@Column(name = "order_cost")
	private BigDecimal orderCost;
	@Column(name = "order_quantity")
	private int orderQuantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchaseOrder;

	public Order() {
		super();
		suggestions = new ArrayList<>();
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public MaterialCopy getMaterialCopy() {
		return materialCopy;
	}

	public void setMaterialCopy(MaterialCopy materialCopy) {
		this.materialCopy = materialCopy;
	}

	public Account getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Account accountOwner) {
		this.accountOwner = accountOwner;
	}

	public Library getOwnerLibrary() {
		return ownerLibrary;
	}

	public void setOwnerLibrary(Library ownerLibrary) {
		this.ownerLibrary = ownerLibrary;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public BigDecimal getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(BigDecimal orderCost) {
		this.orderCost = orderCost;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
		if (!purchaseOrder.getOrders().contains(this)) {
			purchaseOrder.getOrders().add(this);
		}
	}

	public void addSuggestion(Suggestion suggestion) {
		this.suggestions.add(suggestion);
		if (!suggestion.getAssociateOrder().equals(this)) {
			suggestion.setAssociateOrder(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
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
		Order other = (Order) obj;
		if (identifier == null) {
			if (other.identifier != null) {
				return false;
			}
		} else if (!identifier.equals(other.identifier)) {
			return false;
		}
		if (orderID == null) {
			if (other.orderID != null) {
				return false;
			}
		} else if (!orderID.equals(other.orderID)) {
			return false;
		}
		return true;
	}

}
