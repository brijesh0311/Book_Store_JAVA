
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User
{
    private String fullname,username;
    private char[] password;
    public String[][] user_data=new String[3][10];
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

        for (int row=0;row<3;row++){
                for (int col=0;col<10;col++){
                    System.out.println(user_data[row][col] + " ");
                }
        }
    }

    public boolean login(String u_name, char pwd[]) {

        if ("bg".equals(u_name) && "bg".equals(pwd)) {
            return true;
        }
        else {
            return false;

        }
    }
    /*

    for (int i = 0; i < users.length; i++) {
      if (username.equals(users[i][0]) && password.equals(users[i][1])) {
        success = true;
        break;
      }
    }

    if (success) {
      System.out.println("Login successful");
    } else {
      System.out.println("Login failed");
    }
  }

    for (var row = 0; row < personInfo.length; row++) {

  for (var col = 0; col < personInfo.length; col++) {
    personInfo[row][col];
  }
  if (userName == personInfo[row][col] && passWord == personInfo[row][col]) {
    document.write("found")

} else {
    document.write("not found")
}*/

    public static void main(String[] args) {
        // Create the console object
        //Console cnsl = System.console();

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

                    //char[] password = cnsl.readPassword("pass : ");
                    //System.out.println("Password : " + password);
                    /*for (int i = 0; i < password.toString().length(); i++) {
                        System.out.println(password);
                    }*/

                    System.out.println("Enter password:");
                    String password = sc.nextLine();

                    user.registerUser(fullname,username, password.toCharArray());


                    //System.out.println("User Registered");
                    break;

                case 2:

                    System.out.println("Enter username:");
                    username = sc.nextLine();

                    //password = cnsl.readPassword(" Enter password : ");

                    System.out.println("Enter password:");
                    password = sc.nextLine();

                    if (user.login(username, password.toCharArray())) {
                        System.out.println("Login Successful");
                    }
                    else {
                        System.out.println("PLease Enter Correct Credintials !!\n\n");
                        System.out.println("Press R for Reset Password ...");
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