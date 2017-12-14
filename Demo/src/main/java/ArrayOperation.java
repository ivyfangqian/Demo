import java.util.ArrayList;

public class ArrayOperation {
//    private static ArrayList quickSort(ArrayList list) {
//        if(list.size()==1){
//            return list;
//        }else{
//            int flag = ((Integer) list.get(0)).intValue();
//            ArrayList<Integer> smallers = new ArrayList<Integer>();
//            ArrayList<Integer> biggers = new ArrayList<Integer>();
//            ArrayList<Integer> flags = new ArrayList<Integer>();
//            ArrayList<Integer> results = new ArrayList<Integer>();
//
//            for (int i = 0; i < list.size(); i++) {
//                int number = ((Integer) list.get(i)).intValue();
//                if (number > flag) {
//                    biggers.add(number);
//                } else if (number == flag) {
//                    flags.add(number);
//                } else {
//                    smallers.add(number);
//                }
//            }
//            smallers = quickSort(smallers);
//            biggers = quickSort(biggers);
//            results.addAll(smallers);
//            results.addAll(flags);
//            results.addAll(biggers);
//            return results;
//        }
//
//    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(90);
        intList.add(30);
        intList.add(20);
        intList.add(50);
        intList.add(60);

        for (int i = 0; i < intList.size(); i++) {
            intList.set(i,i);
            System.out.println(((Integer) intList.get(i)).intValue());
        }

    }
}
