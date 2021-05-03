import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Фамилия1", "Иван");
        map.put("Фамилия2", "Олег");
        map.put("Фамилия3", "Яна");
        map.put("Фамилия4", "Влад");
        map.put("Фамилия5", "Антон");
        map.put("Фамилия6", "Яна");
        map.put("Фамилия7", "Влад");
        map.put("Фамилия8", "Влад");
        map.put("Фамлия9", "Коля");
        map.put("Фамилия10", "Антон");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        List<String> uniq_name = new ArrayList<>();
        int size_arr = 0;
        for(Map.Entry<String, String> pair : map.entrySet()) {
            boolean is_duplicate = false;
            for(int i = 0; i < size_arr; i++) {
                if(pair.getValue().equals(uniq_name.get(i))) {
                    is_duplicate = true;
                    break;
                }
            }

            if(!is_duplicate) {
                uniq_name.add(pair.getValue());
                size_arr++;
            }
        }
        Map<String, String > copy = new HashMap<>(map);
        for(int i = 0; i < uniq_name.size(); i++) {
            int count = 0;
            for(Map.Entry<String, String> pair : copy.entrySet()) {
                if(uniq_name.get(i).equals(pair.getValue())) {
                    count++;
                    if(count > 1) {
                        map.remove(pair.getKey());
                    }
                }
            }
        }
        for(Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + "" + pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }
}
