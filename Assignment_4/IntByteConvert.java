public class IntByteConvert{
    public static void main(String[] args){
        int value = -1;
        byte b = (byte)value;
        char c = (char)b;
        int num = (int) c;
        System.out.println("Initial value: " + value); //-1
        System.out.println("Final value: " + num);
        String outputst = "Byte ranges from -128 to 127 and hence, conversion from int to byte doesn't change Value and it stays -1." 
        + "However, char datatype ranges from 0 to 65,535 so, -1 is out of range and value changes when byte converted to char." 
        + "Due to this, JVM automatically allocates upper boundary(65, 535) to variable." + 
        "Upon final conversion, 65, 535 is in range of int so final value is 65, 535";
        System.out.println(outputst);
    }
}