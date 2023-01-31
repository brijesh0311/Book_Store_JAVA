
import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User
{
    private String fullname,username;
    private char[] password;
    public void registerUser(String f_name,String u_name, char pwd[]) {

        String reg_ex = "#[^.#]*[^.#\\s][^#.]*\\.\\w+";
        Pattern pattern = Pattern.compile(reg_ex);
        Matcher matcher = pattern.matcher(f_name);
        while (matcher.find()){
            System.out.println("PLease Remove " + matcher.group(0) + " Character in Full Name Section !!!");
        }

        for (int i = 0; i < f_name.length(); i++) {
            if (Character.isDigit(f_name.charAt(i))) {
                System.out.println("PLease Remove Digits in Full Name !!!");
            }
        }

        if (f_name==" "){
            System.out.println("Please Enter Full Name ...");
        }

        fullname=f_name;
        username=u_name;
        password=pwd;
    }

    public boolean login(String u_name, char pwd[]) {

        if ("bg".equals(u_name) && "bg".equals(pwd)) {
            return true;
        }
        else {
            return false;

        }
    }

    public static void main(String[] args) {
        // Create the console object
        Console cnsl = System.console();


        Scanner sc = new Scanner(System.in);
        User user = new User();
        while (true) {
            System.out.println("Enter 1 for Register\n");
            System.out.println("Enter 2 for Sign In\n");
            System.out.println("Enter 3 for Exit\n");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:

                    System.out.println("Enter Fullname:");
                    String fullname = sc.nextLine();
                    System.out.println("Enter username:");
                    String username = sc.nextLine();

                    char[] password = cnsl.readPassword("pass : ");
                    //System.out.println("Password : " + password);
                    //System.out.println("Enter password:");
                    //String password = sc.nextLine();
                    user.registerUser(fullname,username, password);
                    for (int i = 0; i < password.toString().length(); i++) {
                        System.out.println(password);
                    }

                    //System.out.println("User Registered");
                    break;

                case 2:

                    System.out.println("Enter username:");
                    username = sc.nextLine();

                    password = cnsl.readPassword(" Enter password : ");

                    /*System.out.println("Enter password:");
                    password = sc.nextLine();*/

                    if (user.login(username, password)) {
                        System.out.println("Login Successful");
                    }
                    else {
                        System.out.println("PLease Enter Correct Credintials !!");
                    }
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
}