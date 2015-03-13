package cu.uci.abos.l10n.management.library;

import org.eclipse.rap.rwt.RWT;

import cu.uci.abos.l10n.AbosMessageConstants;

public class AbosMessages {

	// BUTTONS
	public String BUTTON_NEW;
	public String BUTTON_ACEPT;
	public String BUTTON_CLOSE;
	public String BUTTON_CANCEL;
	public String BUTTON_ADD;
	public String BUTTON_EXPORT_TO_EXCEL;
	public String BUTTON_EXPORT_TO_PDF;
	public String BUTTON_CONSULT;
	public String BUTTON_NEW_SEARCH;
	
		//public String BUTTON_LOG_IN;
		//public String BUTTON_UPDATE;
		//public String BUTTON_MODIFY;
		//public String BUTTON_INSERT;
		//public String BUTTON_RETURN;
		//public String BUTTON_VALIDATE;
		//public String BUTTON_ASSOCIATE;
		//public String BUTTON_DISSOCIATE;
		//public String BUTTON_RENEW;
		//public String BUTTON_CURRENT_STATUS;
		//public String BUTTON_HISTORY;
		//public String BUTTON_LOSS_REGISTER;
		//public String BUTTON_LOAN;
		//public String BUTTON_APPROVE_ALL;
		//public String BUTTON_REJECT_ALL;
		//public String BUTTON_DELETE;
		//public String BUTTON_SEARCH;
		//public String BUTTON_MORE_OPTIONS;
		//public String BUTTON_START_SEARCH;
		//public String BUTTON_ATTACH;
		//public String BUTTON_SAVE;
		//public String BUTTON_EDIT;
		//public String BUTTON_ERASE;
		//public String BUTTON_ACEPT_ALL;
		
		// LABEL
	public String LABEL_SEARCH_CRITERIA;
	public String LABEL_FROM;
	public String LABEL_TO;
	public String LABEL_TYPE_OF_USER;
	public String LABEL_STATE;
	public String LABEL_IDENTIFICATION;
	public String LABEL_NAME;
	public String LABEL_LIST_PROVIDERS;
	public String LABEL_NAME_PROVIDER;
	public String LABEL_TYPE_PROVIDER;
	public String LABEL_MLIBRARIES;
	public String LABEL_MATERIAL_TYPE;
	public String LABEL_LIST_CIRCULATION_RULES;
	public String LABEL_NAME_COIN;
	public String LABEL_IDENTIFIER_COIN;
	public String LABEL_LIST_OF_CURRENCY;
	public String LABEL_GENERAL_DATA;
	public String LABEL_LIBRARY;
	
	public String CHECKBUTTON_COMMERCIAL;
	public String CHECKBUTTON_CHANGE;
	public String CHECKBUTTON_DONATIONS;
	public String CHECKBUTTON_PRODUCER;
	
		//public String LABEL_TRANSACTIONS;
		//public String LABEL_USER_CURRENT_LOAN_TRANSACTIONS;
		//public String LABEL_USER_HISTORICAL_LOAN_TRANSACTIONS;
		//public String LABEL_OBJECT_HISTORICAL_LOAN_TRANSACTIONS;
		//public String LABEL_RESERVATIONS;
		//public String LABEL_USER_CURRENT_LOAN_RESERVATIONS;
		//public String LABEL_USER_HISTORICAL_LOAN_RESERVATIONS;
		//public String LABEL_OBJECT_HISTORICAL_LOAN_RESERVATIONS;
		//public String LABEL_SANCTIONS;
		//public String LABEL_USER_CURRENT_LOAN_SANCTIONS;
		//public String LABEL_USER_HISTORICAL_LOAN_SANCTIONS;
		//public String LABEL_OBJECT_HISTORICAL_LOAN_SANCTIONS;
		//public String LABEL_DETAILS_OF_THE_PERSON;
		//public String LABEL_OBJECT_LOAN_DATA;
		//public String LABEL_USER_LOAN_DATA;
		//public String LABEL_OBSERVATIONS;
		//public String LABEL_ADVANCED_SEARCH;
		//public String LABEL_BASIC_SEARCH;
		//public String LABEL_COINCIDENCE_LIST;
		//public String LABEL_DATE_OF_REGISTRATION_RANGE;
		//public String LABEL_DISABLE;
		//public String LABEL_JUSTIFICATION;
		//public String LABEL_USER;
		//public String LABEL_USER_CODE;
		//public String LABEL_FIRST_NAME;
		//public String LABEL_SECOND_NAME;
		//public String LABEL_FIRST_LAST;
		//public String LABEL_SECOND_LAST;
		//public String LABEL_NUMBER_OF_EDITION;
		//public String LABEL_KEYWORD;
		//public String LABEL_RESERVATION_STATUS;
		//public String LABEL_MESSAGE_USER_LOAN;
		//public String LABEL_RECORD;
		//public String LABEL_MESSAGE_OBJECT_LOAN;
		//public String LABEL_AUTHOR;
		//public String LABEL_CONTROL_NUMBER;
		//public String LABEL_OBJECT_TYPE;
		//public String LABEL_STATE_OF_OBJECT;
		//public String LABEL_LOCATION;
		//public String LABEL_CURRENT_STATUS;
		//public String LABEL_LOST_REGISTER;
		//public String LABEL_TYPE_OF_LOAN;
		//public String LABEL_EXTERNAL;
		//public String LABEL_INTERNAL;
		//public String LABEL_LIST_OF_OBJECTS_TO_LOAN;
		//public String LABEL_LIST_OF_OBJECTS_TO_RENEW;
		//public String LABEL_REGISTRY_DATA_LOAN;
		//public String LABEL_DATE_OF_RESERVATION;
		//public String LABEL_REGISTRY_DATA_RETURN;
		//public String LABEL_REGISTRY_DATA_RENEW;
		//public String LABEL_OBJECT_DATE_ASOCCIATED_LOAN;
		//public String LABEL_USER_DATE_ASOCCIATED_LOAN;
		//public String LABEL_DATE_OF_TRANSACTION;
		//public String LABEL_DATA_LAST_UPDATE;
		//public String LABEL_MESSAGE_RENOVATION;
		//public String LABEL_MESSAGE_RENOVATION_DA;
		//public String LABEL_DATA_SANCTION;
		//public String LABEL_TYPE_OF_SANCTION;
		//public String LABEL_DURATION;
		//public String LABEL_DAYS;
		//public String LABEL_REASON;
		//public String LABEL_AMOUNT;
		//public String LABEL_PAY;
		//public String LABEL_OBJECT_RELATED_LOAN;
		//public String LABEL_FINE;
		//public String LABEL_SUSPENCION;
		//public String LABEL_DATE;
		//public String LABEL_MESSAGE_SANCION;
	//public String MANAGE_PROVIDERS;
	//public String REGISTER_PROVIDERS;
	//public String DATA_PROVIDER;
	//public String IDENTIFICATION;
	//public String EMAIL;
	//public String DATA_OF_REPRESENTATIVE;
	//public String ADDRESS;
	//public String MANAGE_LIBRARY;
	//public String C_TIME;
	//public String MANAGE_CIRCULATION_RULES;
	//public String PERMITTED_LOANS;
	//public String RENOVATIONS;
	//public String TIME;
	//public String MANAGE_CURRENCY;
	//public String IDENIFIER;
	//public String CUP;
	//public String UPDATING_DATE;

	
	private AbosMessages() {
		// Prevent instantiation
	}

	public static AbosMessages get() {
		return RWT.NLS
				.getISO8859_1Encoded(
						AbosMessageConstants.ABOS_MESSAGES_MANAGEMENT_LIBRARY_CLASS_NAME,
						AbosMessages.class);
	}
}
