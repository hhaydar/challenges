import java.util.*;
/*
Codility Golden Award
https://app.codility.com/cert/view/certNNCZQW-YVUMS9NCWEVRDZN3/
 */
class Solution {

    public class Disk {
        public int value;
        public boolean state;
        Disk(int v, boolean s){
            this.value=v;
            this.state=s;
        }
    }

    class SortDescbyvalue implements Comparator<Disk> {
        public int compare(Disk a, Disk b)
        {
            return b.value - a.value;
        }
    }

    public int solution(int[] A, int L, int R) {
        List<Disk> p = new ArrayList<>();
        Arrays.sort(A);
        Arrays.stream(A).forEach(e->p.add(new Disk(e,false)));
        var wrapper = new Object(){ int lFirst = L; int rFirst=R; int disks=0;};

        p.stream().filter(e->e.value>wrapper.rFirst).forEach(e->{
            wrapper.rFirst=e.value;
            e.state=true;
            wrapper.disks++;
        });

        p.sort(new SortDescbyvalue());
        p.stream().filter(e->(!e.state)&&(e.value<wrapper.lFirst)).forEach(e->{
            wrapper.lFirst=e.value;
            wrapper.disks++;
        });

        return wrapper.disks;
    }
}