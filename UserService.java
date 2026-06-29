import java.util.*;
import java.lang.*;
import java.util.stream.*;

class User{
    int id;
    String name,email;
    public User(int id,String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

public class UserService{

    private List<User> users;
    public UserService(List<User> users){
        this.users = users;

    }


    public static void main(String[] args){
        List<User> userObj = new ArrayList<>(List.of(
        new User(1,"Abhinav","abhi@gail.com"),
        new User(11,"B","fgabhi@gail.com"),
        new User(5,"C","adgabhi@gail.com"),
        new User(17,"v","fhdhfabhi@gail.com"),
        new User(45,"T","uktabhi@gail.com"),
        new User(24,"nav","ytjabhi@gail.com")));

        // userObj.forEach((user) -> System.out.println
        // (user.id+" "+user.name+" "+user.email));
        
        UserService userServiceObj = new UserService(userObj);
        userServiceObj.findById(11)
            .ifPresentOrElse(
                user -> System.out.println(user.id+" "+user.name+" "+user.email),
                () -> System.out.print("User not found")
            );
        System.out.println(userServiceObj.getEmailOrDefault(12,"default@email.com"));
        User user = userServiceObj.getOrThrow(11);
        System.out.println(user.id+" "+user.name+" "+user.email);
        List<String> allEmails = userServiceObj.getAllEmails();
        for(String email: allEmails){
            System.out.println(email);
        }
    }

    Optional<User> findById(int id){
        return  users.stream()
                .filter( user -> user.id == id)
                .findFirst();

    }

    String getEmailOrDefault(int id, String defaultEmail){
        return findById(id)
                .map(user -> user.email)
                .orElse(defaultEmail);

    }

    User getOrThrow(int id){
        return findById(id)
                .orElseThrow(()-> new RuntimeException("User not found: "+id));

    }

    List<String> getAllEmails(){
        return  users.stream()
                    .map(user -> user.email)
                    .collect(Collectors.toList());
    }
    
}