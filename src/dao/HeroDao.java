package dao;

/**
 * Created by Administrator on 2017/7/21.
 */
import bean.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroDao {
    //构造方法

    public HeroDao() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_db_test?characterEncoding=UTF-8","root","root");
    }

    public int getTotal(){
        int total = 0;
        try(Connection c = getConnection(); Statement s = c.createStatement()){
            String sql = "select count(*) from hero";

            ResultSet resultSet = s.executeQuery(sql);
            while (resultSet.next()){
                total = resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    //添加
    public void add(Hero hero){
        String sql = "insert into hero values(null,?,?,?)";
        try(Connection c = getConnection();PreparedStatement preparedStatement = c.prepareStatement(sql)){

            //设置参数
            preparedStatement.setString(1,hero.name);
            preparedStatement.setFloat(2,hero.hp);
            preparedStatement.setInt(3,hero.damage);

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                hero.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //修改
    public void update(Hero hero){
        String sql = "update  hero set name = ?,hp = ?,damage = ? where id = ?";
        try(Connection c = getConnection();PreparedStatement preparedStatement = c.prepareStatement(sql)){

            //设置参数
            preparedStatement.setString(1,hero.name);
            preparedStatement.setFloat(2,hero.hp);
            preparedStatement.setInt(3,hero.damage);
            preparedStatement.setInt(4,hero.id);

            preparedStatement.execute();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //删除
    public void delete(int id){
        String sql = "delete from hero where id = "+id;
        try(Connection c = getConnection();Statement statement = c.createStatement()){
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //查询
    public Hero get(int id){
        Hero hero = null;
        String sql = "select * from hero where id = "+id;
        try(Connection c = getConnection();Statement statement = c.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                hero = new Hero();
                //查询出来的数据
                String name = resultSet.getString(2);
                float hp = resultSet.getFloat("hp");
                int damage = resultSet.getInt("damage");
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hero;
    }


    //以列表的形式返回
    public List<Hero> list(){
        return list(0,Short.MAX_VALUE);
    }

    public List<Hero> list(int start,int count){
        List<Hero> heroes = new ArrayList <>();

        String sql = "select * from hero order by id asc limit ?,?";//desc降序排列，asc升序排列
        try(Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,count);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Hero hero = new Hero();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float hp = resultSet.getFloat("hp");
                int damage = resultSet.getInt("damage");
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
                //添加到集合中
                heroes.add(hero);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heroes;
    }

    public static void main(String[] args){
        List<Hero> heroes = new HeroDao().list();
        System.out.println(Arrays.asList(heroes));
    }
}
