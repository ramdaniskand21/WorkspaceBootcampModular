package common.validator;


import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.Clients;

/**
 * Validator class for validating numeric format field.
 * 
 * @author Bayu
 * 
 */

public class NumericValidator extends AbstractValidator {

	@Override
	public void validate(ValidationContext ctx) {
		String number = (String) ctx.getProperty().getValue();

		if (number != null && !number.matches("[0-9]+") && !number.isEmpty()) {
			Clients.wrongValue(ctx.getBindContext().getComponent(),
					Labels.getLabel("E040"));
			ctx.setInvalid();
		}

	}

}
