package study_210627;
import java.util.ArrayList;

import java.util.Collections;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;

import java.util.TreeMap;


public class 베스트앨범_프로그래머스_윤수님 {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        
        Map<Integer, String> rev = new HashMap<Integer, String>();
        Map<Integer, String> remap = new HashMap<Integer, String>();
        
        HashSet<String> set = new HashSet<String>();

        
        for(int i=0;i<genres.length;i++) {
            
           if(map.get(genres[i]) == null) {
              map.put(genres[i], plays[i]);
                
           }else {
              int play = map.get(genres[i]);
              map.put(genres[i], play+plays[i]);
           }
            
           index.put(plays[i], i);
           set.add(genres[i]);
           rev.put(plays[i],genres[i]);
        }
        
        

        ArrayList<Integer> sortgenre = new ArrayList<Integer>();
        for(String genre : set) {
           sortgenre.add(map.get(genre));
           remap.put(map.get(genre), genre);
        }
        // 어떤장르가 가장큰지 정렬
        sortgenre.sort(Collections.reverseOrder());
        
        
        
        ArrayList<Integer> sortplays = new ArrayList<Integer>();
        
        for(int i = 0 ;i < plays.length;i++) {
           sortplays.add(plays[i]);
        }
        
        sortplays.sort(Collections.reverseOrder());
       
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0 ; i < sortgenre.size(); i++) {

           String name = remap.get(sortgenre.get(i));
           int cnt = 0;
           for(int j = 0 ; j < sortplays.size(); j++) {

              if(rev.get(sortplays.get(j)).equals(name)) {
                 if(cnt >1) break;
                 
                 for(int k = 0 ; k < plays.length; k++) {
                    if(plays[k] == sortplays.get(j) && name.equals(genres[k]) ) {
                       ans.add(k);
                       cnt++;
                    }
                 }
                    
                 if(cnt == 2 && ans.get(ans.size()-1) == ans.get(ans.size()-2)) {

                    if(ans.get(ans.size()-2)>= ans.get(ans.size()-1)) {
                       continue;
                    }else {
                       int big = ans.get(ans.size()-2);
                       int small = ans.get(ans.size()-1);
                       
                       ans.remove(ans.size()-1);
                       ans.remove(ans.size()-1);
                       ans.add(small);
                       ans.add(big);
                    }
                 }
                 
              
              }
           }
        }
        



        ans.toArray();
        int answer[] = new int[ans.size()];
        for(int i = 0 ; i < ans.size();i++) {
           answer[i]=ans.get(i);
        }
        
        return answer;
    }
    


}
