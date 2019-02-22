public class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int rect1 = (C - A) * (D - B);
    int rect2 = (G - E) * (H - F);
    if (A >= G || B >= H || E >= C || F >= D) {
      return rect1 + rect2;
    }
    int height = Math.min(H, D) - Math.max(B, F);
    int length = Math.min(G, C) - Math.max(A, E);
    return rect1 + rect2 - height * length;
  }
}
