package com.myproject;
//스킬트리
public class SkillTree {
    public int solution(String skills, String[] skill_trees) {
        int answer = skill_trees.length;
        
        StringBuilder sb = new StringBuilder();
        sb.append("[^").append(skills).append("]");
        
        for(String skillCombo : skill_trees) {
        	if(skills.indexOf(skillCombo.replaceAll(sb.toString(), "")) != 0)
        		answer--;
    	}
        
        return answer;
    }
}
