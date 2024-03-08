import java.util.Scanner;

public class Main {
    public static boolean isValidCNIC(String cnic){
        return cnic.length()==13;
    }

    public static int calculateExpiryYear(int issueYear){
        return issueYear+10;
    }

    public static String determineProvince(int provinceCode){
        if (provinceCode==1){
            return "Khyber Pakhtunkhwa";
        }
        else if (provinceCode==2) {
            return "FATA (Federally Administered Tribal Areas)";
        }
        else if (provinceCode==3) {
            return "Punjab";
        }
        else if (provinceCode==4) {
            return "Sindh";
        }
        else if (provinceCode==5) {
            return "Balochistan";
        }
        else if (provinceCode==6) {
            return "Islamabad Territory";
        }
        else if (provinceCode==7) {
            return "Gilgit-Baltistan";
        }else{
            return "Un Known";
        }
    }

    public static int determineDivision(int divisionCode)    {
        return divisionCode;
    }

    public static String determineGender(int genderCode){
        if(genderCode%2==0){
            return "Female";
        }else {
            return "Male";
        }
    }

    public static void analyzeCNIC(String cnic, int issueYear){
        System.out.println("Provence: "+determineProvince(Character.getNumericValue(cnic.charAt(0))));

        if (determineDivision(Character.getNumericValue(cnic.charAt(1)))==4){
            System.out.println("Division: Gujranwala");
        }else{
            System.out.println("Division: Not Belongs to Gujranwala");
        }

        System.out.println("Gender: "+determineGender(Character.getNumericValue(cnic.charAt(cnic.length()-1))));

        System.out.println("Expiry Year: "+calculateExpiryYear(issueYear));
    }


    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String cnicNumber;
        while (true){
            System.out.println("Enter Your CNIC number ( without dashes ): ");
            cnicNumber=input.next();
            if (isValidCNIC(cnicNumber)){
                break;
            }
            System.out.println("Please Enter a Valid CNIC number.");
        }

        System.out.println("Enter the year of Card issue ( e.g 2022):   ");
        int year= input.nextInt();

        analyzeCNIC(cnicNumber,year);
    }
}