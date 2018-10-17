package com.sssr.advance.maparray;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map���鹤���࣬�־û�Ϊ�ַ���
 *
 * ��֪��
 *
 * @author zhaojun.wzj
 * @version $Id MapArrayUtil.java, v 0.1 2018-10-17 13:24 zhaojun.wzj Exp $$
 */
public class MapArrayUtil {

    /** ����Ԫ�طָ�� */
    private static final String ARRAY_SEP = "\n";

    /** �ֵ�Ԫ�طָ�� */
    private static final String DICT_SEP = ";";

    /** key-value�ָ�� */
    private static final String KEY_VALUE_SEP = "=";

    /** �ַ�����UTF-8 */
    private static final String ENCODE_UTF8 = "UTF-8";

    /**
     * ���ַ���ת��Ϊ�ֵ�����
     * <p>
     * �ַ���Ϊ�գ���Ϊ'\n'������null
     *
     * @param text
     * @return
     */
    public static Map[] load(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        String[] array = text.split(ARRAY_SEP);
        if (ArrayUtils.isEmpty(array)) {
            return null;
        }

        // ���巵�ؽ����map����
        Map[] mapArray = new HashMap[array.length];

        for (int i = 0; i < array.length; i++) {
            String mapOfString = array[i];
            HashMap<String, String> map = new HashMap<String, String>(2);
            mapArray[i] = map;

            if (StringUtils.isNotEmpty(mapOfString)) {
                String[] mEle = mapOfString.split(DICT_SEP);
                if (ArrayUtils.isNotEmpty(mEle)) {
                    for (int j = 0; j < mEle.length; j++) {
                        String jEle = mEle[j];
                        if (StringUtils.isNotEmpty(jEle)) {
                            String[] mapEle = jEle.split(KEY_VALUE_SEP);
                            if (mapEle != null && mapEle.length == 2) {
                                map.put(getDecodeUtf8(mapEle[0]), getDecodeUtf8(mapEle[1]));
                            }
                        }
                    }
                }
            }

        }

        return mapArray;
    }

    /**
     * key�Լ�value����Ҫת��Ϊutf-8���룬�ٽ��г־û�����������ַ�������
     *
     * @param array
     * @return
     */
    public static String store(Map[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            Map map = array[i];

            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                if (key instanceof String && val instanceof String) {
                    String keys = (String) key;
                    String value = (String) val;

                    String keyEncode = getEncodeUtf8(keys);
                    String valueEncode = getEncodeUtf8(value);

                    result.append(keyEncode).append("=").append(valueEncode).append(";");
                }
            }

            if (result.toString().endsWith(";")) {
                result.deleteCharAt(result.length() - 1);
            }
            if (i < array.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * ת��ΪUTF8����
     * @param s
     * @return
     */
    public static String getEncodeUtf8(String s) {
        try {
            return URLEncoder.encode(s, ENCODE_UTF8);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * UTF8����
     * @param s
     * @return
     */
    public static String getDecodeUtf8(String s) {
        try {
            return URLDecoder.decode(s, ENCODE_UTF8);
        } catch (Exception e) {

        }
        return null;
    }

}