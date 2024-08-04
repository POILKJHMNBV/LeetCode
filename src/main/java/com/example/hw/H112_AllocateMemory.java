package com.example.hw;

import java.util.Scanner;

/**
 * <p>堆内存申请</p>
 * <p>
 *     有一个总空间为100字节的堆，现要从中新申请一块内存，内存分配原则为:
 *     优先分配紧接着前一块已使用的内存，分配空间足够时分配最接近申请大小的空闲内存。
 * </p>
 * <p>
 *     输入描述：
 *          第1行是1个整数，表示期望申请的内存字节数。
 *          第2到第N行是用空格分割的两个整数，表示当前已分配的内存的情况，每一行表示一块已分配的连续内存空间，每行的第1个和第2个整数分别表示偏移地址和内存块大小，
 *          如: 0 1 3 2 表示0偏移地址开始的1个字节和3偏移地址开始的2个字节已被分配，其余内存空闲。
 * </p>
 * <p>
 *     输出描述：
 *          若申请成功，输出申请到内存的偏移 若申请失败，输出-1。
 *          备注 1.若输入信息不合法或无效，则申请失败
 *              2.若没有足够的空间供分配，则申请失败
 *              3.堆内存信息有区域重叠或有非法值等都是无效输入
 * </p>
 * @author zhenwu
 * @date 2024/7/27 16:20
 */
public class H112_AllocateMemory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OperatingSystem operatingSystem = new OperatingSystem(100);
        int require = in.nextInt();
        while (in.hasNext()) {
            int res = operatingSystem.allocate(in.nextInt(), in.nextInt());
            if (res == -1) {
                System.out.println(res);
                return;
            }
        }
        System.out.println(operatingSystem.allocate(require));
    }

    private static class OperatingSystem {

        private final int[] memory;

        public OperatingSystem(int size) {
            this.memory = new int[size];
        }

        public int allocate(int offset, int size) {
            if (invalidInput(offset, size)) {
                return -1;
            }
            for (int i = offset; i < offset + size; i++) {
                if (memory[i] == 1) {
                    // 堆内存信息有区域重叠
                    return -1;
                }
                memory[i] = 1;
            }
            return 0;
        }

        public int allocate(int size) {
            if (size > memory.length) {
                return -1;
            }
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == 0) {
                    for (int j = i; j < memory.length; j++) {
                        if (memory[j] == 1 && (j - i) < size) {
                            i = j;
                            break;
                        } else if ((j - i + 1) >= size) {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        private boolean invalidInput(int offset, int size) {
            int length = memory.length;
            return offset < 0 || offset > length - 1 || (offset + size) > length;
        }
    }
}
