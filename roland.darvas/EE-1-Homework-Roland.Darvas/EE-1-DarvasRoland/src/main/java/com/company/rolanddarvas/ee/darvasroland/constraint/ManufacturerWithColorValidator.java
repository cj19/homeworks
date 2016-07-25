package com.company.rolanddarvas.ee.darvasroland.constraint;

import com.company.rolanddarvas.ee.darvasroland.dto.MobileType;
import com.company.rolanddarvas.ee.darvasroland.model.Brand;
import com.company.rolanddarvas.ee.darvasroland.model.ColorType;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author darvasr
 */
public class ManufacturerWithColorValidator implements ConstraintValidator<ManufacturerWithColor, MobileType> {

    @Override
    public void initialize(ManufacturerWithColor a) {
        //no need to initialize here
    }

    @Override
    public boolean isValid(MobileType mobile, ConstraintValidatorContext context) {
        if ((mobile.getManufacturer() == Brand.APPLE) && !((mobile.getColor()) == ColorType.BLACK
                || mobile.getColor() == ColorType.WHITE)) {
            return false;
        }
            return !(mobile.getManufacturer() == Brand.SAMSUNG && (mobile.getColor() == ColorType.GREEN));
    }

}
