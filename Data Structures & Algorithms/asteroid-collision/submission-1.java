class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int size = asteroids.length;
        int j = -1;
        for (int asteroid : asteroids) {
            while (j >= 0 && asteroids[j] > 0 && asteroid < 0) {
                if (asteroids[j] > Math.abs(asteroid)) {
                    asteroid = 0;
                    break;
                } else if (asteroids[j] == Math.abs(asteroid)) {
                    j--;
                    asteroid = 0;
                    break;
                } else {
                    j--;
                }
            }
            if (asteroid != 0) {
                asteroids[++j] = asteroid;
            }
        }
        return Arrays.copyOfRange(asteroids, 0, j + 1);
    }
}