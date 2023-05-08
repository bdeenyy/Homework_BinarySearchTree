public class BinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};
        int[] levels = new int[arr.length];
        mark(0, arr.length - 1, 0, levels);
        build(arr, levels);
    }

    public static void mark(int left, int right, int level, int[] levels) {
        if (left == right) {
            levels[left] = level;
            return;
        }

        int middle = (left + right) / 2;
        levels[middle] = level;
        mark(left, middle - 1, level + 1, levels);
        mark(middle + 1, right, level + 1, levels);
    }

    public static void build(int[] arr, int[] levels) {
        int maxLevel = 0;
        for (int level : levels) {
            maxLevel = Math.max(maxLevel, level);
        }

        for (int level = 0; level <= maxLevel; level++) {
            for (int i = 0; i < arr.length; i++) {
                if (levels[i] == level) {
                    System.out.print(arr[i] + "  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}