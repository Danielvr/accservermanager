package grimsi.accservermanager.backend.validator;

import grimsi.accservermanager.backend.annotation.UniqueInstanceName;
import grimsi.accservermanager.backend.exception.NotFoundException;
import grimsi.accservermanager.backend.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InstanceNameValidator implements ConstraintValidator<UniqueInstanceName, String> {

    @Autowired
    InstanceService instanceService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext cxt) {
        try {
            instanceService.findByName(name);
            return false;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
