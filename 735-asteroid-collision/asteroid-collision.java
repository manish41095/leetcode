class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int num : asteroids) {
            //Collisoin happen only when top have +ve and current have -ve element

            while (!st.isEmpty() && num < 0 && st.peek() > 0) {
                int sum = num + st.peek();
                if (sum > 0) { // e.g. : 7 - 5 -> 7 will be in stack
                    num = 0;
                } else if (sum < 0) { // e.g 5 -7 : 5 will be pop and -7 will push in stack
                    st.pop();
                } else { // e.g : 5 - 5 : collision happen 5 will be pop and simply igonre -5
                    st.pop();
                    num = 0;
                }
            }

            if (num != 0)
                st.push(num);

        }

        int[] arr = new int[st.size()];
        int i = 0;
        for (int num : st) {
            arr[i++] = num;
        }
        return arr;

    }
}