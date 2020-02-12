package basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsPractice {

    static public class User implements Comparable {
        int id;
        String name;

        User(String name, int id) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id && name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return id * StringToInt.stringToInt(name);
        }

        @Override
        public int compareTo(Object o) {
            return id - ((User) o).id;
        } // sorting by ID

        @Override
        public String toString() {
            return "Name: " + name + ", ID: " + id + "; ";
        }

    }

    static class UserComparator implements Comparator<User> // sorting by NAME
    {
        @Override
        public int compare(User o1, User o2) {
            return o1.name.toUpperCase().compareTo(o2.name.toUpperCase());
        }
    }


    public static void hashSetPracticeSE() {
        Set<User> hashSet = new HashSet<>();
        /*In Object.class methods equals() and hashCode() gives results
        different results for same fields in User exemplars. So, i have 2 exemplars
        of User but this have same values in fields. And after adding in Set, this elements adds together.
        For my example its incorrect. So i must rewrite methods hash and equals to except same exemplars.
         */
        hashSet.add(new User("andrew", 12));
        hashSet.add(new User("victor", 66));
        hashSet.add(new User("andrew", 12));

        System.out.println(hashSet.size());
        for (User u : hashSet) {
            System.out.println(u.toString());
        }

    }

    public static void treeSetPracticeSE() {
        Set<User> treeSet = new TreeSet<>(); // sorted set
        /* Of course, when i try to add in sorted set User and it have not implementation of Comparable interface
        i will have en exceptions in program work.
         */
        treeSet.add(new User("andrew", 12));
        treeSet.add(new User("lima", 22));
        treeSet.add(new User("andrew", 12));

        System.out.println(treeSet.size());
        // in result of this method we have 2 elements, but this set never use hashCode() or equals() method.
        for (User u : treeSet) {
            System.out.println(u.toString());
        }

    }

    public static void researchOfLists() {
        //in first time i have done experiment with filling lists.
        //next part of experiment if deleting 100000 elements from every lists

        final int QUANTITY_OF_NUMBERS = 1000000;
        final int QUANTITY_OF_QUERY = 100000;

        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        long timeOfFinish;

        Date start = new Date();
        for(int i = 0; i < QUANTITY_OF_NUMBERS; i++)
        {
            linkedList.add(i, random.nextInt(500));
        }
        Date finish = new Date();
        timeOfFinish = finish.getTime() - start.getTime();
        System.out.println(timeOfFinish + " milliseconds have used to fill LinkedList(One million random integers).");


        start = new Date();
        for(int i = 0; i < QUANTITY_OF_NUMBERS; i++)
        {
            arrayList.add(i, random.nextInt(500));
        }
        finish = new Date();
        timeOfFinish = finish.getTime() - start.getTime();
        System.out.println(timeOfFinish + " milliseconds have used to fill ArrayList(One million random integers).");


        start = new Date();
        for(int i = 0; i < QUANTITY_OF_QUERY; i++)//querying from LinkedList
        {
            linkedList.remove(random.nextInt(QUANTITY_OF_QUERY));
        }
        finish = new Date();
        timeOfFinish = finish.getTime() - start.getTime();
        System.out.println(timeOfFinish + " milliseconds have used to query from LinkedList one hundred thousand of random elements.");

        start = new Date();
        for(int i = 0; i < QUANTITY_OF_QUERY; i++) // querying from ArrayList
        {
            arrayList.remove(random.nextInt(QUANTITY_OF_QUERY));
        }
        finish = new Date();
        timeOfFinish = finish.getTime() - start.getTime();
        System.out.println(timeOfFinish + " milliseconds have used to query from ArrayList one hundred thousand of random elements.");

        // i have used two methods of taking a time. So, every time i have same results.

        /*
        ******RESULTS******
        * It is a result of filling end querying elements from lists.
        *
        216 milliseconds have used to fill LinkedList(One million random integers).
        59 milliseconds have used to fill ArrayList(One million random integers).
        16474 milliseconds have used to query from LinkedList one hundred thousand of random elements.
        5 milliseconds have used to query from ArrayList one hundred thousand of random elements.
        *
        ******RESULTS******
        * It is result of removing elements from lists.
        207 milliseconds have used to fill LinkedList(One million random integers).
        62 milliseconds have used to fill ArrayList(One million random integers).
        34624 milliseconds have used to query from LinkedList one hundred thousand of random elements.
        13131 milliseconds have used to query from ArrayList one hundred thousand of random elements.
         */

        System.out.println(linkedList.size());
        System.out.println(arrayList.size());
    }

    public static void mapPractice() {

        Random random = new Random();
        String[] randStr = new String[3]; {
            randStr[0] = "familyA";
            randStr[1] = "familyB";
            randStr[2] = "familyC";
        }

        /*filling and print result of filling hash-map*/
        Map<String, User> map = new HashMap<>();

        for(int i = 0; i < 1000; i++)
        {
            /* function that filling map for test by random users and pseudo random keys */
            map.put(StringToInt.randomString(5), new User(StringToInt.randomString(10), random.nextInt(500)));
            //map.put(randStr[random.nextInt(2)], new User(StringToInt.randomString(10), random.nextInt(500)));
        }
        System.out.println("=============================");
        System.out.println("========Hash map next========");
        System.out.println("=============================");

        for(Map.Entry<String, User> printer : map.entrySet())
        {
            System.out.println("Key: " + printer.getKey() + ", User:{ " + printer.getValue().toString() + "}");
        }

        System.out.println("Size: " + map.size());
        System.out.println("=============================");
        System.out.println("========Tree map next========");
        System.out.println("=============================");

        /*using new methods to compute and print tree-map*/

        Map<String, User> sortedMap = new TreeMap<>(map); // collection that auto-sorted by black-red tree algorithm

        sortedMap.compute("A compute, ", (k, v) -> new User("Andrew Volostnykh", 900000));

        //sortedMap.forEach((a, b) -> System.out.println("Key: " + a + ", value: " + b.toString()));

        /* in the last, lets import all from this map to new map<String, List<User>> and sort it by ID maybe?*/
        Map<String, List<User>> listMap = new HashMap<>();
        List<User> tempList1 = new LinkedList<>();
        List<User> tempList2 = new LinkedList<>();
        List<User> tempList3 = new LinkedList<>();
        for(Map.Entry<String, User> temp : map.entrySet())
        {

            int tempInt = temp.getValue().id;
            if(tempInt < 200)
            {
                tempList1.add(temp.getValue());
            } else if(tempInt < 400)
            {
                tempList2.add(temp.getValue());
            } else
            {
                tempList3.add(temp.getValue());
            }
        }

        listMap.put(randStr[0], tempList1);
        listMap.put(randStr[1], tempList2);
        listMap.put(randStr[2], tempList3);

        for(Map.Entry<String, List<User>> tempSet : listMap.entrySet())
        {
            System.out.println(tempSet.getKey());
            tempSet.getValue().forEach(v -> System.out.println(v.toString()));
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        }

    }

    public static void letsStream() {

        List<User> linkedList = new LinkedList<>();
        Random random = new Random();
        int c = 0;

        for(int i = 0; i < 200; i++)
        {
            linkedList.add(new User(StringToInt.randomString(5), random.nextInt(500)));
        }

//      Stream<User> stream = linkedList.stream();
        Set<User> set = linkedList.stream().filter(u -> u.id < 100 ).collect(Collectors.toSet());
//        linkedList.stream().forEach(user -> System.out.println(user.toString()));
        for(User u : set)
        {
            System.out.print(c + ". ");
            System.out.println(u.toString());
            c++;
        }

        linkedList.stream().map(u -> u.name.toUpperCase()).forEach(System.out::println);

        Stream.of(new User("Andrew", 321), new User("Solya", 465546), new User("Vanya", 2222));



    }

    public static void letsStream2() {

            LinkedList<String> strings = new LinkedList<>(); {
                int counter = 0;
            while(counter< 500)

                {
                    strings.add(StringToInt.randomString(8));
                    counter++;
                }
            }

        System.out.println("/* Filtering, brute force, showing */");
        Stream<User> firstUsers = Stream.of(new User("Andrew", 20), new User("Solya", 23), new User("Zhenya", 19),
                                            new User("Oksana", 25), new User("Vera", 30), new User("Zhenya", 19));
        List<User> userList = firstUsers.collect(Collectors.toList());
// must to show all users with ID < 20 and this must to be equal result of 268 line
        System.out.println("Filter, must be equal with next filter");
        userList.stream().filter(u -> u.id < 20).forEach(u -> System.out.println(u.toString()));
// must to show all user id's
        System.out.println("All users");
        userList.stream().map(u -> u.id).forEach(u -> System.out.println(u.toString()));
// must to show all users that have id < 20 and they's hash code!
        System.out.println("Next Filter, must show name and hash of users with ID < 20");
        userList.stream().filter(u -> u.id<20).flatMap(u -> Stream.of(
                String.format("Name: %s, id: %d", u.name, u.id),
                String.format("Name: %s, hash: %s", u.name, u.hashCode())
        )).forEach(u -> System.out.println(u.toString()));

//sorting and distinct operations
        System.out.println("Sorting");
        userList.stream().sorted(new UserComparator()).forEach(u-> System.out.println(u.toString())); // work
        System.out.println("Distinct");
        userList.stream().distinct().forEach(u-> System.out.println(u.toString()));

//counting and matching operations
        System.out.print("Counting of Distinct elements: " + userList.stream().distinct().count());
        System.out.print("Match that all ID > 10 : " + userList.stream().allMatch(u -> u.id > 10));
        System.out.print("Match that any ID > 29 : " + userList.stream().anyMatch(u -> u.id > 29));
        System.out.print("Match that no one ID > 0 : " + userList.stream().noneMatch(u -> u.id > 0));
//min and max elements, reduce next
        System.out.println("Min element: " + userList.stream().min(new UserComparator()).get().toString());
        System.out.println("Max element: " + userList.stream().max(new UserComparator()).get().toString());

        System.out.println("Here can be your advertising");

        System.out.println(">> Concat all names? ");
        System.out.println(userList.stream().reduce((a, b) -> new User(a.name + b.name, b.id)).map(u -> u.toString()));
        System.out.println(">> Try reduce with Strings: " + strings.stream().reduce((a, b) -> a + b));

        Map<Integer, String> toMap = userList.stream().distinct().collect(Collectors.toMap(p-> p.id, t-> t.name));
        toMap.forEach((k, v) -> System.out.println(k.toString() + " " + v));
    }

}
