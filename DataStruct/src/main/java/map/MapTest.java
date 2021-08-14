package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<User,Integer> map =new HashMap<>();
        User user = new User("小贺","2");
        User user1 = new User("小谢","3");
        map.put(user,1);
        System.out.println(user.hashCode());
        user.setAge("5");
        map.put(user,3);
        System.out.println(user.hashCode());
        System.out.println(map.get(user)+""+map.containsKey(user));
        map.put(user1,3);
        Set<User> users =map.keySet();
        for(User user2 :users){
            System.out.println(user2);
        }
    }

    static class User {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        public void setAge(String age) {
            this.age = age;
        }

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name) && Objects.equals(age, user.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
