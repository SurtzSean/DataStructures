//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #6
public class PQEntry{
   private Integer key;
   private String value;
   public PQEntry(Integer k, String v){
      key = k;
      value = v;
   }
   public PQEntry(){
      this(-1,null);
   }
   public Integer getKey(){
      return key;
   }
   
   public String getValue(){
      return value;
   }
   public void setKey(Integer k){
      key = k;
   }
   public void setValue(String v){
      value = v;
   }
   
}