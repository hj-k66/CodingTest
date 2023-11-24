package CodingTest.Programmers.LV1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 신고결과받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportByUser = new HashMap<>(); //key - id, value - 신고한 Id

        for (String id : id_list) {
            reportByUser.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] s = r.split(" ");
            Set<String> value = reportByUser.get(s[0]);
            value.add(s[1]);
            reportByUser.put(s[0], value);
        }

        //신고횟수 count
        Map<String, Integer> reportCnt = new HashMap<>();
        for (String id : id_list) {
            Set<String> ids = reportByUser.get(id);
            for (String reportedId : ids) {
                reportCnt.put(reportedId, reportCnt.getOrDefault(reportedId, 0) + 1);
            }
        }

        //k번 이상 신고당하면 이용정지
        List<String> stopped = new ArrayList<>();
        for (String id : id_list) {
            int cnt = reportCnt.getOrDefault(id, 0);
            if (cnt >= k) {
                stopped.add(id);
            }
        }

        //메일 횟수
        for (int i = 0; i < id_list.length; i++) {
            Set<String> values = reportByUser.get(id_list[i]);
            int mailCnt = 0;
            for (String stop : stopped) {
                if (values.contains(stop)) {
                    mailCnt++;
                }
            }
            answer[i] = mailCnt;
        }

        return answer;
    }

    /*
    카카오 기술블로그 풀이
     */
    public static int[] otherSolution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();//key - 신고된 유저 id, value - 신고한 유저
        for(String repo : report){
            String[] splited = repo.split(" ");
            String reporter  = splited[0];
            String reported = splited[1];
            map.putIfAbsent(reported, new HashSet<>(){{
                add(reporter);
            }});
            map.get(reported).add(reporter);
        }

        //신고된 유저 아이디 순회
        for(String reported : map.keySet()){
            Set<String> reporters = map.get(reported);
            if(reporters.size() >= k){
                //신고한 유저 목록 순회 -> 메일 보내기
                for(int i = 0; i < id_list.length; i++){
                    if(reporters.contains(id_list[i])){
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] solution = solution(id_list, report, k);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }
}
