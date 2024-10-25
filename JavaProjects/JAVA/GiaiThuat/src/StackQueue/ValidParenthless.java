package StackQueue;

import java.sql.SQLOutput;
import java.util.Stack;

public class ValidParenthless {
    public static boolean isValid(String s){
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            if(c=='(' || c=='{'|| c ==']'){
                characters.push(c);

            }else{
                if(characters.empty() == true){
                    return false;
                }
                char openPeek =characters.peek();
                if((c ==')'&& openPeek =='(')||(c==']'&& openPeek == '[')
                        ||( c=='}' && openPeek=='{') ){
                    characters.pop();
                }else{
                    return false;
                }
            }
        }
        return characters.empty();
    }
    public static void main(String[] args) {
        String  s= "()";
        System.out.println(isValid(s));
    }
}
