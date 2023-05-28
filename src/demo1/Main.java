package demo1;

import javafx.scene.control.Alert;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // demo1
//        HashSet<String> hs = new HashSet<>();
//        hs.add("Hello");
//        hs.add("Hello");
//        hs.add("world");
//        System.out.println("Count: " + hs.size());

        // Viết chương trình nhập vào 10 số nguyên khác nhau
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap 10 so nguyen: ");
//        HashSet<Integer> hsi = new HashSet<>();
//        try {
//            for (int i = 0; i < 10; i ++) {
//                System.out.println("Nhap so nguyen thu " + (i + 1));
//                int num = sc.nextInt();
//
//                if (hsi.equals(num)) {
//                    throw new  Exception("Da ton tai");
//                }
//                hsi.add(num);
//            }
//
//            System.out.println(hsi);
//        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText(e.getMessage());
//            alert.show();
//        }

        // demo2
        PriorityQueue<Integer> ps = new PriorityQueue<>();
        ps.add(4);
        ps.add(8);
        ps.add(1);
        ps.add(5);
        while (ps.size()>0) {
            int i = ps.poll();
            System.out.println("queue: "+i);
        }
        PriorityQueue<String> spt = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("B10", 20);
        hm.put("A5", 18);
        System.out.println(hm.get("B10"));
        System.out.println(hm.get("A5"));
    }
}
