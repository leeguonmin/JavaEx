package JavaTest;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] names) {
        List<String> aw = new ArrayList<>();
        
        for (int i = 0; i < names.length; i += 5) {
                aw.add(names[i]);
        }
        
        String[] cf = new String[aw.size()];
        // 스트링 방을 새로 만들어주라고. aw 사이즈 만하게
            return aw.toArray(cf);
 

    }
}