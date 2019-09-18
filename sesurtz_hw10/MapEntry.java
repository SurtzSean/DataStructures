//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #9
public class MapEntry{
   private String key;
   private String value;
   public MapEntry(){
      this.key = null;
      this.value = null;
   }
   public MapEntry(String k, String v){
      this.key = k;
      this.value = v;
   }
   
   public String getKey(){
      return key;
   }
   
   public String getValue(){
      return value;
   }
   
   public String setKey(String k){
      this.key = k;
      return k;
   }
   
   public String setValue(String v){
      this.key = v;
      return v;
   }
   
   public int hashCode(){
      if(key == null) return 0;
      int h = 0;
      for(int i = 0; i<key.length(); i++){
         h = (h<<5)|(h>>>27);
         h+=(int)key.charAt(i);
      }
      return h;
   }
}