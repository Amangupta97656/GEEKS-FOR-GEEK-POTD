class Solution {
    private static final long MOD = 1_000_000_007L;

    public int minTime(int a, int b, int d, int l, int r) {
        long cycleGain = a - b;

        // Minimum time using normal movement alone.
        long normalCycles = ceilDiv(d - a, cycleGain);
        long normalTime = d + 2L * b * normalCycles;

        // q = d - j, so the queried q values are [d-r, d-l].
        long qLow = (long) d - r;
        long qHigh = (long) d - l;

        // Find the largest q for which jumping is no slower than normal movement.
        long left = qLow, right = qHigh, best = qLow - 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (jumpTime(mid, a, b, cycleGain) <= normalTime) {
                best = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long answer = 0;
        long jumpHigh = Math.min(qHigh, best);

        if (qLow <= jumpHigh) {
            long smallHigh = Math.min(jumpHigh, (long) a);
            if (qLow <= smallHigh) {
                long count = smallHigh - qLow + 1;
                long sumQ = (qLow + smallHigh) * count / 2;
                answer = (answer + count + sumQ) % MOD; // jump time = 1 + q
            }

            long largeLow = Math.max(qLow, (long) a + 1);
            if (largeLow <= jumpHigh) {
                long count = jumpHigh - largeLow + 1;
                long sumQ = (largeLow + jumpHigh) * count / 2;

                // Sum ceil((q-a)/cycleGain) over this interval.
                long xLow = largeLow - a;
                long ceilSum = floorSum(
                    count, cycleGain, 1, xLow + cycleGain - 1
                );

                long sumTimes = count + sumQ + 2L * b * ceilSum;
                answer = (answer + sumTimes) % MOD;
            }
        }

        // All remaining q values use normal movement alone.
        long normalCount = (qHigh - qLow + 1) - Math.max(0, jumpHigh - qLow + 1);
        answer = (answer + (normalCount % MOD) * (normalTime % MOD)) % MOD;

        return (int) answer;
    }

    private long jumpTime(long q, long a, long b, long cycleGain) {
        if (q <= a) return 1 + q;
        return 1 + q + 2 * b * ceilDiv(q - a, cycleGain);
    }

    private long ceilDiv(long x, long y) {
        return (x + y - 1) / y;
    }

    // Returns sum for i = 0..n-1 of floor((a*i + b) / m).
    private long floorSum(long n, long m, long a, long b) {
        long result = 0;

        while (true) {
            if (a >= m) {
                result += (n - 1) * n * (a / m) / 2;
                a %= m;
            }
            if (b >= m) {
                result += n * (b / m);
                b %= m;
            }

            long yMax = a * n + b;
            if (yMax < m) break;

            n = yMax / m;
            b = yMax % m;

            long temp = m;
            m = a;
            a = temp;
        }

        return result;
    }
}