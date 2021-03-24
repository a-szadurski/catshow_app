package pl.coderslab.catshowapp.validationcustom;

import pl.coderslab.catshowapp.breeds.BreedCategory01;
import pl.coderslab.catshowapp.breeds.BreedCategory02;
import pl.coderslab.catshowapp.breeds.BreedCategory03;
import pl.coderslab.catshowapp.breeds.BreedCategory04;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;
import java.util.stream.Collectors;

public class EmsValidator implements ConstraintValidator<ValidEms, String> {


    @Override
    public boolean isValid(final String ems, final ConstraintValidatorContext context) {
        return validateEms(ems);
    }

    private boolean validateEms(final String ems) {

        Set<String> breeds = new HashSet<>();

        breeds.addAll(EnumSet.allOf(BreedCategory01.class).stream().map(Enum::name).collect(Collectors.toSet()));
        breeds.addAll(EnumSet.allOf(BreedCategory02.class).stream().map(Enum::name).collect(Collectors.toSet()));
        breeds.addAll(EnumSet.allOf(BreedCategory03.class).stream().map(Enum::name).collect(Collectors.toSet()));
        breeds.addAll(EnumSet.allOf(BreedCategory04.class).stream().map(Enum::name).collect(Collectors.toSet()));

        return breeds.stream()
                .anyMatch(ems::contains);

    }

}
