import java.util.Arrays;
import java.util.stream.IntStream;

/* Codility Award

https://app.codility.com/cert/view/certKFH8K5-JCNFEUFUU58A3YXF/details/

*/

public class SolutionUsingTreeGoldenAward {
    public int solution(int N, int K, int[] A, int[] B, int[] C) {
        /* select limit for build segments for tree */
        int[] arr = IntStream.concat(Arrays.stream(A), Arrays.stream(B).map(x->x+1))
                .distinct()
                .sorted()
                .toArray();
        Node node = buildSegmentTree(arr, 0, arr.length - 1);
        IntStream.range(0,A.length).forEach(e->makeCakes(node, A[e], B[e], C[e], Integer.MAX_VALUE));
        node.setNodeParentFlavor(Integer.MAX_VALUE);
        return getWellNodes(node, K);
    }

    public void makeCakes(Node node, int start, int end, int flavor, int nodeParentFlavor) {
        if (nodeParentFlavor != Integer.MAX_VALUE) node.flavor = nodeParentFlavor;
        if (node.start > end || node.end < start) return;
        if (node.start >= start && node.end <= end) {
            if (node.flavor != Integer.MAX_VALUE) {
                if (flavor - node.flavor == 1) {
                    node.flavor = flavor;
                    if (node.left != null) node.left.flavor = flavor;
                    if (node.right != null) node.right.flavor = flavor;
                } else {
                    node.unsorted = true;
                }
                return;
            }
        }
        if (node.left != null) {
            makeCakes(node.left, start, end, flavor, node.flavor);
            if (node.left.unsorted) node.left = null;
        }
        if (node.right != null) {
            makeCakes(node.right, start, end, flavor, node.flavor);
            if (node.right.unsorted) node.right = null;
        }

        /* Compress tree */
        int children = node.getNumberOfChildren();
        if (children == 0) {
            node.unsorted = true;
        } else if (children == 1) {
            Node child = node.left != null ? node.left : node.right;
            node.start = child.start;
            node.end = child.end;
            node.left = child.left;
            node.right = child.right;
            node.flavor = child.flavor;
        } else if (children == 2 ){
            node.start = Math.min(node.left.start, node.right.start);
            node.end = Math.max(node.left.end, node.right.end);
            node.flavor = node.left.flavor == node.right.flavor ? node.left.flavor : Integer.MAX_VALUE;
        }
    }

    public class Node {
        public int start, end, flavor;
        public boolean unsorted;
        public Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isWell(int K) {
            if (unsorted) return false;
            return K == flavor;
        }

        public int getNumberOfChildren() {
            int children = 0;
            if (left != null) children++;
            if (right != null) children++;
            return children;
        }

        public int getLayers(int K) {
            return !isWell(K) ? 0 : this.end - this.start + 1;
        }

        public void setNodeParentFlavor(int nodeParentFlavor) {
            if (nodeParentFlavor != Integer.MAX_VALUE) flavor = nodeParentFlavor;
            if (left != null) left.setNodeParentFlavor(flavor);
            if (right != null) right.setNodeParentFlavor(flavor);
        }
    }

    /* Count how many cakes are well prepared */
    public int getWellNodes(Node node, int K) {
        if (node == null) return 0;
        int left = getWellNodes(node.left, K);
        int right = getWellNodes(node.right, K);
        if (node.left == null) return right + node.getLayers(K);
        if (node.right == null) return left + node.getLayers(K);
        return left + right;
    }

    /* build segment tree */
    private Node buildSegmentTree(int[] arr, int start, int end) {
        Node node = new Node(arr[start], arr[end]-1);
        int center = (start + end) / 2;
        if (center > start) {
            node.left = buildSegmentTree(arr, start, center);
            if (center < end) node.right = buildSegmentTree(arr, center, end);
        }
        return node;
    }
}
