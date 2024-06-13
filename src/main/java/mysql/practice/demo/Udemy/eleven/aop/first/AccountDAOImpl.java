package mysql.practice.demo.Udemy.eleven.aop.first;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work :adding an account _______ ");
    }

}
