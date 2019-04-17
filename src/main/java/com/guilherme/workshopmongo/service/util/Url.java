package com.guilherme.workshopmongo.service.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author Guilherme
 */
public class Url {

    static public String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return "";
        }
    }
}
