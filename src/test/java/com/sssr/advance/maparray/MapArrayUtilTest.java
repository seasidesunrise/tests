package com.sssr.advance.maparray;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapArrayUtilTest {

    @Test
    public void testLoadNormal() {
        String text = "k1=v1;k2=v2\nA=XXX";
        Map[] mapArray = MapArrayUtil.load(text);
        System.out.println(mapArray);
    }

    @Test
    public void testLoadSingle() {
        String text = "a";
        Map[] mapArray = MapArrayUtil.load(text);
        System.out.println(mapArray);
    }

    @Test
    public void testLoadSingle2() {
        String text = "\n";
        Map[] mapArray = MapArrayUtil.load(text);
        System.out.println(mapArray);
    }

    @Test
    public void testLoad3() {
        String text = "k1=v1;k2=v2\nA";
        Map[] mapArray = MapArrayUtil.load(text);
        System.out.println(mapArray);
    }

    @Test
    public void testLoad4() {
        String text = "k1=v1;k2=v2\nA=";
        Map[] mapArray = MapArrayUtil.load(text);
        System.out.println(mapArray);
    }

    @Test
    public void testLoad5() {
        String text = "k1=v1;k2=v2\nA==";
        Map[] mapArray = MapArrayUtil.load(text);
        System.out.println(mapArray);
    }

    @Test
    public void testLoad6() {
        String text = "k1=v1;k2=v2\nA==1";
        System.out.println(text);
        Map[] mapArray = MapArrayUtil.load(text);
        System.out.println(mapArray);
    }

    @Test
    public void test7() throws Exception {
        System.out.println(URLEncoder.encode("=", "UTF-8"));

        System.out.println(URLEncoder.encode("\n", "UTF-8"));

        System.out.println(URLEncoder.encode(";", "UTF-8"));

        System.out.println(URLEncoder.encode("%3D", "UTF-8"));
    }

    @Test
    public void testStore1() {
        Map[] resultMap = new HashMap[2];

        Map map = new HashMap();
        map.put("k1", "v1");
        map.put("k2", "v2");
        resultMap[0] = map;

        Map map2 = new HashMap();
        map2.put("A", "XX");
        resultMap[1] = map2;

        System.out.println(resultMap);

        String store = MapArrayUtil.store(resultMap);
        System.out.println(store);
    }

    @Test
    public void testStore2() {
        Map[] resultMap = new HashMap[2];

        Map map = new HashMap();
        map.put(4, new Object());
        map.put(5, "v2");
        resultMap[0] = map;

        Map map2 = new HashMap();
        map2.put("A", "XX");
        resultMap[1] = map2;

        System.out.println(resultMap);

        String store = MapArrayUtil.store(resultMap);
        System.out.println(store);
    }

}
