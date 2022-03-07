package Programers;

import java.util.*;

public class level2_주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        // fees : 기본시간(m), 기본요금, 단위시간(m), 단위요금
        // records : "시간 차량번호 IN/OUT"
        // 단위시간으로 나누어 떨어지지 않으면 소수점 첫째자리에서 올림
        // 출차기록이 없으면 23:59 로 정산
        // 차량번호가 작은것부터 요금만 answer 배열에 저장

        List<String[]> list = new ArrayList<>(); // 입차 내역
        Map<String, Integer> map = new HashMap<>();

        // 내역을 항목별로 분리
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            //System.out.println(Arrays.toString(record));

            if(record[2].equals("IN")){
                list.add(record);
            }else{
                //입차 내역 찾기
                for (int j = 0; j < list.size(); j++) {
                    String[] tmp = list.get(j); // IN 내역
                    //System.out.println("tmp : " + Arrays.toString(tmp));

                    // 요금 계산
                    int fee = 0;
                    if(record[1].equals(tmp[1])){ // 차량 번호가 같다면
                        String[] in = tmp[0].split(":");
                        String[] out = record[0].split(":");

                        int totalTime = (Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1])) - (Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]));
                        fee = fees[1];

                        if(totalTime >  fees[0]){ // 기본시간보다 더 오래 있었다면 추가요금 발생
                            totalTime -= fees[0]; // 기본시간을 제외한 시간만 남음
                            int t = totalTime % fees[2] == 0 ? totalTime / fees[2] : totalTime / fees[2] + 1;
                            fee += t * fees[3];
                        }
                        list.remove(j); // 입차 내역 삭제
                        j--;
                        if(map.containsKey(tmp[1])){
                            map.put(tmp[1], map.get(tmp[1])+fee);
                        }else{
                            map.put(tmp[1],fee);
                        }
                    }
                } // for
            }//else
        }

        // 출차기록이 없다면
        for (int i = 0; i < list.size(); i++) {
            String[] tmp = list.get(i); // IN 내역
            String[] in = tmp[0].split(":");
            int totalTime = (23 * 60 + 59) - (Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]));

            int fee = fees[1];
            if(totalTime >  fees[0]) {
                totalTime -= fees[0];
                int t = totalTime % fees[2] == 0 ? totalTime / fees[2] : totalTime / fees[2] + 1;
                fee += t * fees[3];
            }
            if(map.containsKey(tmp[1])){
                map.put(tmp[1], map.get(tmp[1])+fee);
            }else{
                map.put(tmp[1],fee);
            }
        }

        Object[] mapKey = map.keySet().toArray();
        Arrays.sort(mapKey);

        int[] answer = new int[map.size()];
        int idx = 0;
        for (String keyVal : map.keySet()) {
            answer[idx++] = map.get(keyVal);
        }

        System.out.println(Arrays.toString(answer));
    }
}
