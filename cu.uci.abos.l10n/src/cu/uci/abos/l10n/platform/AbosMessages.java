package cu.uci.abos.l10n.platform;

import org.eclipse.rap.rwt.RWT;

import cu.uci.abos.l10n.AbosMessageConstants;

public class AbosMessages {

	// HEADER
	public String HEADER_PROFILE;
	public String HEADER_LOG_OFF;
	public String HEADER_HELP;
	public String HEADER_MANUAL;
	public String HEADER_ABOUT_US;
	public String HEADER_SYSTEM_NAME;
	public String HEADER_LOG_IN;

	
	// LOGIN
	public String USER;
	public String PASSWORD;
	public String REMEMBER_PASSWORD;
	public String FORGET_PASSWORD;
	public String BUTTON_LOG_IN;

	// MESSAGES OF FIELDS VALIDATIONS
	public String MESSAGE_VALIDATE_FIELD_REQUIRED;
	public String MESSAGE_VALIDATE_FIELD_EMAIL;
	public String MESSAGE_VALIDATE_FIELD_ONLY_LETTERS;
	public String MESSAGE_VALIDATE_FIELD_ONLY_NUMBERS;
	public String MESSAGE_VALIDATE_FIELD_ONLY_LETTERS_OR_NUMBERS;

	private AbosMessages() {
		// Prevent instantiation
	}

	public static AbosMessages get() {
		return RWT.NLS.getISO8859_1Encoded(
				AbosMessageConstants.ABOS_MESSAGES_PLATFORM_CLASS_NAME,
				AbosMessages.class);
	}
}
