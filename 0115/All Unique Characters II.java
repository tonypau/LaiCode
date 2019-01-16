/*
operand priority, from high to low:
        []
         .
        (),
        
        ++
        --,
        
        ++
        --
        +
        -
        !
        ~,
        
        ()
       new,
        
      * / %, 
      
        + -
        +,
        
    << >> >>>, 
    
      < <=
      > >=
    instanceof,
    
      == !=, 
      
        &, 
        
        ^,
        
        |,
        
       &&,
       
       ||,
       
       ?:,
       
   =   +=   -=
  *=   /=   %=
  &=   ^=   |=
  <<=  >>= >>>=
*/

public class Solution {
  public boolean allUnique(String word) {
    if (word.length() == 0) return true;
    int[] vec = new int[8];
    char[] arr = word.toCharArray();
    for (char c : arr) {
      int i = 1;
      i <<= c % 32;
      if ((vec[c / 32] >>> c % 32 & 1) != 0) {
        return false;
      }
      vec[c / 32] |= 1 << (c % 32);
    }
    return true;
  }
}

