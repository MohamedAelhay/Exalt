package question.first;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MyClass {

    private Date m_time;
    private String m_name;

    /**
     * Using Generics better to solve type safety at compile time rather than at run time.
     */
    private ArrayList<Long> m_numbers;
    private ArrayList<String> m_strings;

    public MyClass(Date time, String name, ArrayList<Long> numbers, ArrayList<String> strings) {
        m_time = time;
        m_name = name;
        m_numbers = numbers;
        m_strings = strings;
    }

//    public boolean equals(Object obj) {
//        if (obj instanceof MyClass) {
//            return m_name.equals(((MyClass) obj).m_name);
//        }
//        return false;
//    }

    /**
     * First Checking the object reference if it's equal so return true
     * Second Checking object is not null or object is not the same Class
     * Third Cast the object to access the properties
     * Fourth compares all object properties with the same way we compare the object reference
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        MyClass myClass = (MyClass) object;

        return Objects.equals(m_time, myClass.m_time) &&
               Objects.equals(m_name, myClass.m_name) &&
               Objects.equals(m_numbers, myClass.m_numbers) &&
               Objects.equals(m_strings, myClass.m_strings);
    }

    /**
     * When we use equals method it's necessary to override the hashCode method
     * which states that equal objects must have equal hash codes
     */
    @Override
    public int hashCode() {
        return Objects.hash(m_time, m_name, m_numbers, m_strings);
    }

    /**
     * Using StringBuilder over String concatenate is considered good practice
     * Using Generics parameter save us from individual type casting
     */
    public String toString() {
        StringBuilder out = new StringBuilder(m_name);

        for (long item : m_numbers) {
            out.append(" ").append(item);
        }
        return out.toString();
    }

//    @Override
//    public String toString() {
//        return "MyClass{" +
//                "m_time=" + m_time +
//                ", m_name='" + m_name + '\'' +
//                ", m_numbers=" + m_numbers +
//                ", m_strings=" + m_strings +
//                '}';
//    }

    /**
     * We Changed List to ArrayList so that we can use remove() method
     * We can use directly remove() on the array and it's enough
     */
    public void removeString(String str) {
//        for (int i = 0; i < m_strings.size(); i++) {
//            if (m_strings.get(i).equals(str)) {
//                m_strings.remove(i);
//            }
//        }

        m_strings.remove(str);
    }

    public List<String> getM_strings() {
        return m_strings;
    }

    /**
     * using the advantage of ArrayList methods we can use contains() and return the result directly
     */
    public boolean containsNumber(long number) {
//        for (long num: m_numbers) {
//            if (num == number) {
//                return true;
//            }
//        }
//        return false;

        return m_numbers.contains(number);
    }
    public boolean isHistoric() {
        return m_time.before(new Date());
    }
}
