package practice.javastream;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharacterInWord {
    
    public static void main(String[] args) {
        FrequencyOfEachCharacterInWord o = new FrequencyOfEachCharacterInWord();    
        o.find("Programmingp");
    }


    private void find(String w)
    {
        if(Objects.isNull(w) || w.isBlank() || w.isEmpty())
        {
            System.out.println("Give valid input");
            return;
        }else{
            System.out.println(w.chars()
            .mapToObj(c -> {
                if (Character.isUpperCase(c)) {
                    return (char) Character.toLowerCase(c);
                } else {
                    return (char) c;
                }
            })
            .collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
            ));
        }
            
    }
    

}

