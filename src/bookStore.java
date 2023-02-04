import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class userinfo{

    public String username,fullname,reset_pwd;
    public int count=0;
    public String[][] user_data=new String[3][10];
    public String password;
    Scanner sc = new Scanner(System.in);
    userinfo() {

        //Create the console object
        //Console cnsl = System.console();
        while (true) {
            System.out.println("Enter 1 for Register\n");
            System.out.println("Enter 2 for Sign In\n");
            System.out.println("Enter 3 for Exit\n");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    System.out.println("Enter Fullname:");
                    String f_name = sc.nextLine();
                    System.out.println("Enter username:");
                    String u_name = sc.nextLine();
                    System.out.println("Enter password:");
                    String pwd = sc.nextLine();

                    //char[] password = cnsl.readPassword("pass : ");
                    //System.out.println("Password : " + password);
                    /*for (int i = 0; i < password.toString().length(); i++) {
                        System.out.println(password);
                    }*/

                    registerUser(f_name,u_name, pwd);
                    break;

                case 2:

                    System.out.println("Enter username:");
                    String u_namee = sc.nextLine();

                    //password = cnsl.readPassword(" Enter password : ");

                    System.out.println("Enter password:");
                    String pwdd = sc.nextLine();

                    login(u_namee,pwdd);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    public void login(String user, String pw) {

        System.out.println(username+password+fullname);
        System.out.println(this.username+this.password+this.fullname);
        if (username.equals(user) && password.equals(pw)) {
            System.out.println("Login Successful");
        }
        else {
            System.out.println("PLease Enter Correct Credintials !!\n\n");

            while (true) {
                System.out.println("Enter 1 for Forget Password\n");
                System.out.println("Enter 2 for Exit\n");
                int option=sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("PLease Enter Full Name : ");
                        String ful_name=sc.next();

                        if (ful_name==fullname){
                             System.out.println("Enter New Password : ");
                             reset_pwd=sc.next();
                             System.out.println("Password Changed..");
                             password=reset_pwd;

                        }

                        break;

                    case 2:
                        return;

                    default:
                        System.out.println("Please Enter Valid Operation ...");
                }
            }
        }
    }
    

    public void registerUser(String f_name, String u_name, String pwd ) {

        boolean result =reg_cheaker(f_name,u_name,pwd);
        if (result==true)
        {
            username=u_name;
            password=pwd;
            fullname=f_name;

                /*for (int row = 0; row < count; row++) {
                    for (int col = 0; col < 10; col++) {
                        System.out.println(user_data[row][col] + " ");
                    }
                }*/

        }
        else {

        }



    }

    public  boolean reg_cheaker(String f_name, String u_name, String pwd) {

        String reg_ex = "#[^.#]*[^.#\\s][^#.]*\\.\\w+";
        Pattern pattern = Pattern.compile(reg_ex);
        Matcher matcher = pattern.matcher(f_name);

        for (int i = 0; i < f_name.length(); i++) {
            if (Character.isDigit(f_name.charAt(i))) {
                System.out.println("PLease Remove Digits in Full Name !!!");
                return false;
            }
            else if (f_name == " ") {
                System.out.println("Please Enter Full Name ...");
                return false;
            }
            while (matcher.find()) {
                System.out.println("PLease Remove " + matcher.group(0) + " Character in Full Name Section !!!");
                return false;
            }
        }
        return true;
    }

}
public class bookStore {
    public static void main(String[] args){
        userinfo u_info=new userinfo() ;
    }
}
