class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> mp = new HashMap<>(); 

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int number = seat[1];
            if (!mp.containsKey(row)) {
                mp.put(row, new HashSet<>());
            }
            mp.get(row).add(number);
        }

        int result = (n - mp.size()) * 2;

        for(Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
            Set<Integer> bookedSeats = entry.getValue();

            boolean groupA = !bookedSeats.contains(2) && !bookedSeats.contains(3) && !bookedSeats.contains(4) && !bookedSeats.contains(5);
            boolean groupB = !bookedSeats.contains(4) && !bookedSeats.contains(5) && !bookedSeats.contains(6) && !bookedSeats.contains(7);
            boolean groupC = !bookedSeats.contains(6) && !bookedSeats.contains(7) && !bookedSeats.contains(8) && !bookedSeats.contains(9);

            if(groupA && groupC)
                result += 2;
            else if(groupA || groupB || groupC)
                result += 1;
        }

        return result;
    }
}
