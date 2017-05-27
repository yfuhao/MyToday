package text.bwie.today.view;

import java.util.Comparator;

/**
 * 用来对ListView中的数据根据A-Z进行排序，前面两个if判断主要是将不是以汉字开头的数据放在后面
 */
public class PinyinComparator implements Comparator<CitySortModel> {


//    http://blog.csdn.net/u014049880/article/details/51920128

    public int compare(CitySortModel o1, CitySortModel o2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序 正数，零，负数各代表大于，等于，小于
//        if (o1.getSortLetters().equals("@")
//                || o2.getSortLetters().equals("#")) {
//            //由高到底排序
//            return -1;
//        } else if (o1.getSortLetters().equals("#")
//                || o2.getSortLetters().equals("@")) {
//            //由底到高排序
//            return 1;
//        } else {
////            方法如果这个字符串是等参数字符串那么返回值0，如果这个字符串是按字典顺序小于字符串参数那么返回小于0的值，如果此字符串是按字典顺序大于字符串参数那么一个大于0的值
//            return o1.getSortLetters().compareTo(o2.getSortLetters());
//        }
                    return o1.getSortLetters().compareTo(o2.getSortLetters());

    }
}
