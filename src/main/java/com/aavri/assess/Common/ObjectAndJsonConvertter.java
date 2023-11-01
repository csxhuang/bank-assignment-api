/*******************************************************************************
 * ObjectAndJsonConvertter.java - the conversion of json to object or object to
 *                                json.
 * Date   : Nov 10, 2018
 * Version: 1.0
 * Author : Bill Huang
 *
 * Common:
 *    1) Json converted to Java object;
 *    2) Java object converted to Json
 ********************************************************************************/

package com.aavri.assess.Common;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ObjectAndJsonConvertter {
    private static Logger logger = LoggerFactory.getLogger(ObjectAndJsonConvertter.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> String object_2_json(T o) {
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
        } catch (JsonGenerationException e) {
            logger.error("convert object to json failed.", e);
        } catch (JsonMappingException e) {
            logger.error("convert object to json failed.", e);
        } catch (IOException e) {
            logger.error("convert object to json failed.", e);
        }
        return json;
    }

    public static <T> T json_2_object(String json, Class<T> objectClass) {
        T obj = null;
        try {
            obj = mapper.readValue(json, objectClass);
        } catch (JsonParseException e) {
            logger.error("json to object failed. json --> " + json + "\t class --> " + objectClass.getName(), e);
        } catch (JsonMappingException e) {
            logger.error("json to object failed. json --> " + json + "\t class --> " + objectClass.getName(), e);
        } catch (IOException e) {
            logger.error("json to object failed. json --> " + json + "\t class --> " + objectClass.getName(), e);
        }
        return obj;
    }

}
