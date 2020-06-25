public class ChainOfResponsibilityMain {
	public static void main(String[] args){
		// lets here check, does this pattern works :)
		
		Server server = new Server();
		server.register("admin@mail.com", "123456");
		server.register("user@mail.com", "123654");
		
		Middleware middleware = new ThrottlingMiddleware(2)
		.setNext(new UserExistsMiddleware(server))
		.setNext(new RoleCheckMiddleware());
		
	}
}

abstract class Middleware { // frame for every one of chain elements
	private Middleware next;
	
	public Middleware setNext(Middleware next){
		this.next = next;
		return next;
	}
	
	public abstract boolean check(String email, String password);
	
	protected boolean checkNext(String email, String password){
		if(next == null) {
			return true;
		}
		
		return next.check(email, password);
	}
}

class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }
	
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;
        
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(email, password);
    }
}

class UserExistsMiddleware extends Middleware { // here we checking does user registered on server
	private Server server;
	
	public UserExistsMiddleware(Server server){
		this.server = server;
	}
	
	public boolean check(String email, String password){
		if(!server.hasEmail(email)){
			System.out.println("This email is not registered");
			return false;
		}
		if(!server.isValidPassword(email, password)){
			System.out.println("Wrong password bro!");
			return false;
		}
		
		return checkNext(email, password); // and giving this user to next elemnt of chain
	}
}

class RoleCheckMiddleware extends Middleware { // here we check does user admin ?
	public boolean check(String email, String password){
		if(email.equals("admin@mail.com"){
			System.out.println("Admin rules added");
			return true;
		}
		
		System.out.println("User rules");
		return checkNext(email, password); // and giving this user to next element of chein 
	}
}

class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");
// here code for authorised users
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}



