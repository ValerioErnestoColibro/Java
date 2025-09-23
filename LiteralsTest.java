public class LiteralsTest 
{
 public static void main(String[] args) 
{
 for (int i = 1; i <= 3; i++) 
{
 System.out.println("Iterazione " + i + ": " + 100 * i + ", " + (3.14 * i) + ",  " + (char)('A' + i));
 }
 }
}