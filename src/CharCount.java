import java.util.*;

public class CharCount {

    public static void main(String[] args) {
        System.out.println("Enter the String");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        input=input.toLowerCase();
        System.out.println("Method one :");
        long start=System.nanoTime();
        String result=getCount(input);
        System.out.println("Result is "+ result);
        long end=System.nanoTime();
        System.out.println("Method one running time "+(end-start)+" nanoSeconds");
        System.out.println("Method two :");
        long start1=System.nanoTime();
        result=getCountValue(input);
        System.out.println("Result is "+ result);
        long end1=System.nanoTime();
        System.out.println("Method two running time "+(end1-start1)+" nanoSeconds");
        System.out.println("Method three :");
        long start2=System.nanoTime();
        result=getCountValues(input);
        System.out.println("Result is "+ result);
        long end2=System.nanoTime();
        System.out.println("Method three running time "+(end2-start2)+" nanoSeconds");
    }
    public static String getCountValue(String input)
    {
        String result="";

        int alpha[]=new int[26];
        for(int i=0;i<input.length();i++)
        {
            alpha[input.charAt(i)-'a']++;
        }
        for(int i=0;i<alpha.length;i++)
        {
            if(alpha[i]!=0)
            {
                char temp=(char)('a'+i);
              //  System.out.println("char is "+temp);
                result+=temp+String.valueOf(alpha[i]);

            }
        }

        return result;
    }
    public static String getCount(String input)
    {
        HashMap<Character,Integer> count=new HashMap<>();
        for(int i=0;i<input.length();i++)
        {
            if(count.containsKey(input.charAt(i)))
            {

                count.put(input.charAt(i),count.get(input.charAt(i))+1);
            }
            else
            {

                count.put(input.charAt(i),1);
            }
        }
        Iterator iterator=count.entrySet().iterator();
        String result="";
        while(iterator.hasNext())
        {
            Map.Entry map=(Map.Entry)iterator.next();

            result+=(String.valueOf(map.getKey())+String.valueOf(map.getValue()));

        }
        return result;
    }

    public static String getCountValues(String input)
    {
        String result="";

        StringBuffer st=new StringBuffer(input);
        for(int i=0;i<st.length();i++)
        {
            char temp=input.charAt(i);
            int count=0;
            int find=0;
            //count=returnCount(st,temp);
            String sos=" ";

            for(int j=0;j<st.length();j++)
            {
                ArrayList<Integer> value=new ArrayList<>();

                if(temp==st.charAt(j))
                {
                    value.add(j);
                    count++;


                }else
                {
                    sos+=st.charAt(j);
                }

            }
           // System.out.println(sos);
             st=new StringBuffer(sos);
         //   System.out.println("stata "+st);

            if(count==0)
            {

            }else
            {
                result+=String.valueOf(temp)+String.valueOf(count);
            }

        }
        return result;
    }
}
