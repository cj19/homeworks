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
        if (isApplePhoneValid(mobile)) {
            return false;
        } else {
            return isSamsungPhoneValid(mobile);
        }
    }

    private static boolean isSamsungPhoneValid(MobileType mobile) {
        return !(mobile.getManufacturer() == Brand.SAMSUNG && (mobile.getColor() == ColorType.GREEN));
    }

    private static boolean isApplePhoneValid(MobileType mobile) {
        return (mobile.getManufacturer() == Brand.APPLE) && !((mobile.getColor()) == ColorType.BLACK
                || mobile.getColor() == ColorType.WHITE);
    }

}
