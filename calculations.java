package com.example.calculator;

import java.util.Stack;

public class calculations {

    static Stack stack = new Stack();

    private static boolean isANumber(String input) {
        if (input == null || input.isEmpty()) return false;
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //add elements to the stack using postfix and convert to integers
    public static void addStack(String input) {
        Integer num;
        Stack opStack = new Stack();
        if(isANumber(input)) {

            num=Integer.parseInt(input);
            while(!stack.isEmpty() && !isANumber(String.valueOf(stack.peek()))) {
                String value=stack.peek().toString();
                stack.pop();
                opStack.push(value);

            }
            stack.push(num);

            while(!opStack.isEmpty()) {
                stack.push(opStack.peek());
            }



        }
        else{
            stack.push(input);
        }

    };

    public static String calc(){

        Stack temp =new Stack();
        Integer []numbers = new Integer[2];
        int i=0;
        Integer res;

        while(!stack.isEmpty()){
            i=i+1%2;
            if(stack.peek() instanceof Integer){
                numbers[i]=(Integer)stack.peek();
                stack.pop();

            }
            else{
                if(numbers.length==2){

                    res=switch (stack.peek().toString()){
                        case "+"->numbers[1]+numbers[0];
                        case "-"->numbers[1]-numbers[0];
                        case "/"->numbers[1]/numbers[0];
                        case "x"->numbers[1]*numbers[0];
                        default -> res=0;
                    };
                    stack.push(res);
                }
                else{
                    temp.push(stack.peek());
                    stack.pop();
                }
            }
        }

        return String.valueOf(stack.peek());
    };
}
