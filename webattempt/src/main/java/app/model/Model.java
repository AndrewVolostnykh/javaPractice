package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<User> model;

    public static Model getInstance()
    {
        return instance;
    }

    private Model()
    {
        model = new ArrayList<>();
    }

    public void add(User user)
    {
        model.add(user);
    }

    public List<String> list()
    {
        return model.stream().map(User::toString).collect(Collectors.toList());
    }

    public boolean duplicationCheck(User user)
    {
        return model.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()));

    }

    public User findUser(String email, String password)
    {
//        for(int i = 0; i < model.size(); i++)
//        {
//            if(model.get(i).getEmail().equals(email) & model.get(i).getPassword().equals(password))
//            {
//                return model.get(i);
//            }
//        }

        for (User u : model)
            if (u.getEmail().equals(email) & u.getPassword().equals(password)) return u;
        return null;
    }

}
