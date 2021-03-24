package pl.coderslab.catshowapp.validationcustom;

import pl.coderslab.catshowapp.entities.Judge;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class AtLeastOneCategoryValidator implements ConstraintValidator<AtLeastOneCategory, Object> {

    @Override
    public void initialize(final AtLeastOneCategory constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {

        final Judge judge = (Judge) obj;

        List<Boolean> categories = Arrays.asList(judge.isCategory01(), judge.isCategory02(), judge.isCategory03(),
                judge.isCategory04());

        for (boolean category : categories) {
            if (category) {
                return true;
            }
        }
        return false;
    }

}
