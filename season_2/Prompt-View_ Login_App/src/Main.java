import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Main {
    public static void main(String[] args) {

        // Setup the menu prompt message
       /* MenuInputScanner scanner = MenuInputScanner(options);
        scanner.setMessage("Choose an option: ");
        MenuIn*/
        //MenuInputScanner var1 = new MenuInputScanner();
        System.out.println("Welcome to your first Prompt-View Experience!\n");
        System.out.println("Insert your login credentials below:");

        // create a question, and set the message to be displayed

        /*//StringInputScanner
        Prompt var1 = new Prompt(System.in, System.out);
        StringInputScanner var2 = new StringInputScanner();
        var1.setMessage("Username:");
*/

        /*String[] var10 = new String[]{"Name", "Login"};
        Prompt var2 = new Prompt(System.in, System.out);
        MenuInputScanner var3 = new MenuInputScanner(var1);
        var3.setMessage("Choose an option: ");
        System.out.println(var2.getUserInput(var3));*/

        Prompt prompt = new Prompt(System.in, System.out);

// Instantiate a password input scanner
        PasswordInputScanner scanner = new PasswordInputScanner();

// Grab that password
        String password = prompt.getUserInput(scanner);
        if (password.equals("Teste")) {
            System.out.println("Password equals");
        } else {

        System.out.println("rt");}
}
}

