class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String>map=new HashMap<>();
        for(List<String> kd:knowledge){
            map.put(kd.get(0),kd.get(1));
        }
        String ans="";
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                i++;
                String key="";
                while(s.charAt(i)!=')'){
                    key+=s.charAt(i);
                    i++;
                }
                if(map.containsKey(key)){
                    ans+=map.get(key);
                }
                else{
                    ans+="?";
                }
                i++;
            }
            else{
                ans+=s.charAt(i);
                i++;
            }
        }
        return ans;
    }
}
