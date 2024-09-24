package com.urbanestia.property.shared;

import com.urbanestia.property.shared.exception.SanitizeStringUtilException;
import org.owasp.encoder.Encode;

public class SanitizeStringUtil {

    private SanitizeStringUtil() {
    }

    public static String sanitize(final String str) {
        try {
            return Encode.forJava(str);
        } catch (Exception e) {
            throw new SanitizeStringUtilException("Error al sanitizar el string: " + e.getMessage());
        }
    }
}