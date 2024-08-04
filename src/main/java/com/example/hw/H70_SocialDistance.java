package com.example.hw;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * <p>社交距离</p>
 * <p>
 *     疫情期间，需要大家保证一定的社交距离，公司组织开交流会议，座位有一排共N个座位，编号分别为[0..N-1]，要求员工一个接着一个进入会议室，并且可以在任何时候离开会议室。
 *     满足:每当一个员工进入时，需要坐到最大社交距离的座位
 *     (例如:位置A与左右有员工落座的位置距离分别为2和2，位置B与左右有员工落座的位置距离分别为2和3，影响因素都为2个位置，则认为座位A和B与左右位置的社交距离是一样的)，
 *     如果有多个这样的座位，则坐到索引最小的那个座位。
 * </p>
 * <p>
 *     输入描述：
 *          会议室座位总数seatNum，(1 <= seatNum <= 500) 员工的进出顺序 seatOrLeave数组，元素值为1: 表示进场，元素值为负数，表示出场(特殊:位置0的员工不会离开)。
 *          例如-4表示坐在位置4的员工离开 (保证有员工坐在该座位上)。
 * </p>
 * <p>
 *     输出描述：最后进来员工，他会坐在第几个位置，如果位置已满，则输出-1。
 * </p>
 * @author zhenwu
 * @date 2024/7/20 8:38
 */
public class H70_SocialDistance {
    public static void main(String[] args) {
        int seatNum = 10;
        int[] seatOrLeave = {1, 1, 1, 1, -4, 1};
        System.out.println(conferenceSeatDistance(seatNum, seatOrLeave));
    }

    private static int conferenceSeatDistance(int seatNum, int[] seatOrLeave) {
        SeatDistance seatDistance = new SeatDistance(seatNum);
        int last = -1;
        for (int num : seatOrLeave) {
            if (num == 1) {
                last = seatDistance.findSeat();
            } else {
                seatDistance.leaveSeat(-num);
            }
        }
        return last;
    }

    private static class SeatDistance {

        final int seatNum;

        // 利用 TreeSet 维护已经有人的座位
        final TreeSet<Integer> seatTree;

        public SeatDistance(int seatNum) {
            this.seatNum = seatNum;
            seatTree = new TreeSet<>();

            // 前后添加虚拟的座位
            seatTree.add(-2 * (seatNum - 1));
            seatTree.add(2 * (seatNum - 1));
        }

        public void leaveSeat(int index) {
            seatTree.remove(index);
        }

        public int findSeat() {
            int index = -1, maxSocialDistance = 0;
            Iterator<Integer> iterator = seatTree.iterator();
            int pre = iterator.next();
            while (iterator.hasNext()) {
                int cur = iterator.next();
                int distance = (cur - pre) / 2;

                // 每次取两个有人座位的中间位置即为最大社交距离
                if (distance > maxSocialDistance) {
                    int pos = (pre + cur) / 2;
                    if (pos >= 0 && pos < seatNum) {
                        index = pos;
                        maxSocialDistance = distance;
                    }
                }

                pre = cur;
            }

            if (index != -1) {
                seatTree.add(index);
            }
            return index;
        }
    }

}
