import java.util.*;
public class ReArrange {
    public static char find(ArrayList<Character> ar,char c)
    {
        for(int i=0;i<ar.size();i++)
        {
            if(ar.get(i)!=c)
            {
                char ret=ar.get(i);
                ar.remove(i);
                return ret;
            }
        }
        return c;
    }
    public static void main(String[]args)
    {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the String ");
            String input=scanner.nextLine();
            input=input.toLowerCase();
            System.out.println("Input String is "+input);
            ArrayList<Character> input1=new ArrayList<>();

            for(int i=1;i<input.length();i++)
            {


                input1.add(input.charAt(i)) ;
            }
            //System.out.println(" ArrayList "+input1);
            Stack<Character> stack=new Stack<>();
            int impossible=0;
            if(input.length()>0)
            {
                stack.push(input.charAt(0));
                for(int i=1;i<input.length();i++)
                {
                    char insert=find(input1,stack.peek());
                    if(insert==stack.peek())
                    {
                        impossible=1;
                        break;
                    }else
                    {
                        stack.push(insert);
                    }
                   // System.out.println("stack "+stack);
                  //  System.out.println("ArrayList "+input1);

                }
            }
            if(impossible==1)
            {
                System.out.println("It is impossible to rearrange the string without repeating adjacent characters");
            }else
            {
                System.out.println("It is posssible to rearrange the string ");

                StringBuffer print=new StringBuffer();
                while(stack.size()>0)
                {
                    print.append(stack.pop());
                }
                System.out.println("The rearranged String is: "+print.reverse().toString());
            }




    }
}
