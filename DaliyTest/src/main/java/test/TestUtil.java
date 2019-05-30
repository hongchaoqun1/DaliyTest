package test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/7 11:04
 * @ClassName TestUtil
 */

public class TestUtil {
    public static void main(String[] args){
        List<Map<String, String>> list = new ArrayList<>();

        BufferedReader reader = null;
        try {
            File file = new File("D:\\neuroCloud\\upload\\208\\20190527\\cajiceshi002_caijiceshi002_20190527105119_1_mark.txt");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.length() <= 0) {
                    continue;
                }
                String[] lines = line.split(",");
                String mark = lines[0].trim();
                String start = lines[1].trim();
                String end = lines[2].trim();

                Map<String, String> map = new HashMap<>();
                map.put("mark", mark);
                System.out.println(mark);
                map.put("start", start);
                System.out.println(start);
                map.put("end", end);
                System.out.println(end);
                list.add(map);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ex) {} finally {
                    reader = null;
                }
            }
        }

    }
}
