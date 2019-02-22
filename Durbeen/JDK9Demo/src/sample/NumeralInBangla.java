package sample;

public class NumeralInBangla {

    public static String toBanglaString(String p){
        char[] arr = p.toCharArray();
        for(int i=0; i<arr.length; ++i){
            if(arr[i]>='০' && arr[i]<='৯'){
                arr[i] -= ('০'-'0');
            }
        }
        String abc = new String(arr);
        System.out.println("From class : " + abc);
        return abc;
    }
}
