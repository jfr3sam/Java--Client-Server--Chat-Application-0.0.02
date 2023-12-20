
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Researcher{
   
    public Admin() throws Exception {
        super();
        csv.createUser();
        //TODO Auto-generated constructor stub
    }

    
    public void addResearcher (String name , String ip ) throws FileNotFoundException {

       
        csv.EditUser(name, ip);
        notfiy();
       

       

        

    }

    private void notfiy () {

        File file = new File("users.csv");

        byte [] data = null; 
        data = new byte[(int)file.length()];
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            bis.read(data, 0, data.length);
            bis.close();
        } catch (Exception e) {
            System.out.println("File Not Found ");
        }

        List<String> users = new ArrayList<String>();

        users = csv.getUsers(); 

        for (String user : users) {
           System.out.println(user);
            Client client = new Client(6602,user);
            System.out.println("Sending");
            client.senduers(data);
            
        }


        
    }
    
}
