package common.validator;


import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.Clients;

/**
 * Validator class for validating max length of number field. It will ignore
 * thousand separator.
 * 
 * 
 * @author Leo Sendra Using Example: <textbox
 *         value="@bind(vm.number) @validator('numberMaxLength', tot=10, dec=4)" />
 */

public class NumberMaxLengthValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String s = String.valueOf(ctx.getProperty().getValue());		
		
		long tot = (long)ctx.getBindContext().getValidatorArg(
				"tot");		
		long maxDec = (long)ctx.getBindContext().getValidatorArg(
				"dec");

		long maxPos = tot - maxDec;
		
		String[] splitter = s.split("\\.");
		
		int thePos = Integer.valueOf(splitter[0].length());
		int theDec = 0;
		
		if (splitter.length > 1){
			theDec = Integer.valueOf(splitter[1].length());
		}
		
		if (thePos > maxPos || theDec > maxDec){
			Clients.wrongValue(ctx.getBindContext().getComponent(), Labels.getLabel("E041", new String[]{String.valueOf(maxPos)}));
			ctx.setInvalid();
		}
	}
}