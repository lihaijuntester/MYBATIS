package test.com;

import com.com.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by arvin on 2018/1/6.
 */
public interface UserMapper {
    @Insert("INSERT INTO users(age,NAME) VALUES(#{age},#{name})")
    public int addUser(User user);
    @Select("select * from users where id=#{id}")
    public User SelectUser(User user);
    @Delete("delete from users where id=#{id}")
    public int DeleteUser(User user);
    @Update("update users set age=#{age} where id=#{id}")
    public int UpdateUser(User user);
    @Select("select * from users where age=#{age}")
    public List<User> SelectAll(User user);
}
